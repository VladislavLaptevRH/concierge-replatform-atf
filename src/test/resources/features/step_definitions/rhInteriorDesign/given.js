import InteriorDesignPage from '../../../pageobjects/rhInteriorDesign/interiorDesign.page';
var rootConfig = require('../../../../wdio.conf.js').config;

const { Given } = require('cucumber');

Given(/^I open the RH Interior Design page$/, function() {
    browser.pause(rootConfig.newPlatformPauseTimeout);
    InteriorDesignPage.open();
});
