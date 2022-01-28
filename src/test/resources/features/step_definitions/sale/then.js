import SalePage from '../../../pageobjects/sale/sale.page';
const { Then } = require('cucumber');
var logger = require('../../../../wdio.log4js.js').log();
var rootConfig = require('../../../../wdio.conf.js').config;

Then(/^I verify RH Sale banner displayed on page$/, function() {
    browser.pause(rootConfig.newPlatformPauseTimeout);
    var isVerified;
    isVerified = SalePage.isRHSaleBannerDisplayed();
    assert.isTrue(isVerified, 'RH Sale banner not displayed on Sale page');
});

Then(/^I verify Sale page contains "([^"]*)" products$/, function(pricetag) {
    browser.pause(rootConfig.newPlatformPauseTimeout);
    var isSaleProducts = SalePage.verifyProduct(pricetag);
    assert.isTrue(isSaleProducts, 'Sale page does not contain Sale producst ');
});
