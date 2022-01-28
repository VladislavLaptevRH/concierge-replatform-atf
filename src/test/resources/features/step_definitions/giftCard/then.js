import GiftCardBalanceCheckPage from '../../../pageobjects/giftCard/giftCardBalanceCheck.page';

const { Then } = require('cucumber');

Then(/^I expect to see the Gift-Card-Balance-Check page$/, function() {
    GiftCardBalanceCheckPage.checkForGiftCardPageLoaded();
});

Then(/^I see gift card balance and usage details$/, function() {
    GiftCardBalanceCheckPage.checkForGiftCardResults();
});

Then(/^I expect error "([^"]*)?"$/, errMsg => {
    GiftCardBalanceCheckPage.verifyErrorMessage(errMsg);
    browser.pause(1000);
});
