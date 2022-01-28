import GiftCardBalanceCheckPage from '../../../pageobjects/giftCard/giftCardBalanceCheck.page';

const { When } = require('cucumber');

When(/^I enter following gift card details in the fields:/, function(data) {
    var giftCardFields = data.hashes();
    GiftCardBalanceCheckPage.checkBalance(giftCardFields[0]);
});

When(/^Gift card number and pin is not entered/, function() {
    GiftCardBalanceCheckPage.enterNoValues();
});
