import UserPaymentPage from '../../../pageobjects/account/userPayment.page';
import PaymentMethodService from '../../../serviceobjects/account/payment.service';

const { Given, When, Then } = require('cucumber');

When(/^I visit the user payment page and enter:$/, function(data) {
    var ccData = data.hashes();
    UserPaymentPage.createNewUserCreditCard(ccData[0]);
});

Then(/^I expect the account payment error "([^"]*)?"$/, errMsg => {
    UserPaymentPage.verifyPaymentError(errMsg);
    browser.pause(1000);
});

Then(
    /^I expect the account payment page to show "([^"]*)" with last four "([^"]*)"$/,
    function(type, four) {
        UserPaymentPage.verifyCardInList(type, four);
        browser.pause(1000);
    }
);

When(
    /^I clear the already present cards on the account payment page$/,
    function() {
        console.log('Clearing profile of existing cards.');
        var removeAllResult = PaymentMethodService.removeAll();

        console.log(removeAllResult.value.status);
        console.log(removeAllResult.value.body);

        expect(
            removeAllResult.value.status,
            'Unable to clear saved cards from profile.'
        ).to.equal(200);
    }
);

When(
    /^I click on PAYMENT METHODS and enter card information after clicking on New Card on payment page:$/,
    function(data) {
        var ccDataList = data.hashes();
        UserPaymentPage.createNewUserCreditCardList(ccDataList);
    }
);

Then(
    /^I expect the below cards should be displayed on account payment page$/,
    function(data) {
        var ccDataList = data.hashes();
        var isCardDisplayed = UserPaymentPage.verifyDisplayedCard(ccDataList);
        browser.pause(1000);
        assert.isTrue(isCardDisplayed, 'Cards are not displayed as expected');
    }
);

When(
    /^I clear the already present cards and add below cards on the account payment page:$/,
    function(data) {
        console.log('Clearing profile of existing cards.');
        var removeAllResult = PaymentMethodService.removeAll();

        console.log(removeAllResult.value.status);
        console.log(removeAllResult.value.body);

        expect(
            removeAllResult.value.status,
            'Unable to clear saved cards from profile.'
        ).to.equal(200);
        console.log('adding card on payment page');
        var ccDataList = data.hashes();
        UserPaymentPage.createNewUserCreditCardList(ccDataList);
    }
);

When(/^I delete "([^"]*)" credit card on Payment method page$/, function(
    cardType
) {
    UserPaymentPage.clickOnDeleteLink(cardType);
    browser.pause(2000);
});
