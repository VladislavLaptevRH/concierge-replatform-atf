import GiftCardBalanceCheckPage from '../../../pageobjects/giftCard/giftCardBalanceCheck.page';

const { Given } = require('cucumber');

Given(/^I am on gift card balance inquiry page$/, function() {
    GiftCardBalanceCheckPage.open();
    GiftCardBalanceCheckPage.pauseForResultsToLoad();
});
