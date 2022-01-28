import ContractUserPage from '../../../pageobjects/contract/contractUser.page';
import ShipAddressPage from '../../../pageobjects/checkout/shipAddress.page';
import TradeUserPage from '../../../pageobjects/trade/tradeUser.page';
var rootConfig = require('../../../../wdio.conf.js').config;
const { Then } = require('cucumber');

Then(/^I expect that I am successfully signed in as "([^"]*)" user$/, function(
    user
) {
    browser.pause(rootConfig.newPlatformLowPauseTimeout);
    var isUserSignIn = ContractUserPage.isUserSignIn(user);
    assert.isTrue(isUserSignIn, 'Contract User is not Sign In');
});

Then(/^I verify the "([^"]*)" price is displayed on "([^"]*)" page$/, function(
    userType,
    page
) {
    var isPriceDisplayed = ContractUserPage.verifyPrice(userType, page);
    assert.isTrue(isPriceDisplayed, 'Contract User price is not displayed');
});

Then(/^I verify email address is present on the shipping page$/, function() {
    var isEmailIdDisplayed = ShipAddressPage.verifyEmailAddress();
    assert.isTrue(isEmailIdDisplayed, 'EmailId is not displayed');
});

Then(/^I expect that I am not signed in as "([^"]*)" user$/, function(user) {
    ContractUserPage.verifyLogout(user);
});

Then(/^I verify service request modal is displayed$/, function() {
    var isModalDisplayed = TradeUserPage.isModalDisplayed();
    assert.isTrue(isModalDisplayed, 'Modal is not displayed');
});

Then(/^I verify the service request form is submitted$/, function(){
    var isFormSubmitted = TradeUserPage.isFormSubmitted();
    assert.isTrue(isFormSubmitted, 'Form is not submitted');
});