import SalePage from '../../../pageobjects/sale/sale.page';

var logger = require('../../../../wdio.log4js.js').log();
var rootConfig = require('../../../../wdio.conf.js').config;

const { When } = require('cucumber');

When(/^I click on Sale Section$/, function() {
    SalePage.clickOnSaleTab();
});

When(
    /^I hover over "([^"]*)" and select the first subcategory from menu$/,
    function(topCategory) {
        browser.pause(rootConfig.newPlatformLowPauseTimeout);
        SalePage.hoverOverCategory(topCategory);
    }
);
