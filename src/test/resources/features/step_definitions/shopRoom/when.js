import ShopRoomPage from '../../../pageobjects/shopRoom/shopRoom.page';
const { When } = require('cucumber');
var logger = require('../../../../wdio.log4js.js').log();
var rootConfig = require('../../../../wdio.conf.js').config;

When(/^I click on 'Sale' Section$/, function() {
    SalePage.clickOnSaleTab();
});

When(
    /^I hover over "([^"]*)" and select first subcategory from menu$/,
    function(topCategory) {
        browser.pause(rootConfig.newPlatformLowPauseTimeout);
        SalePage.hoverOverCategory(topCategory);
    }
);
