import { assert } from 'chai';
import ShopRoomPage from '../../../pageobjects/shopRoom/shopRoom.page';
const { Then } = require('cucumber');
var logger = require('../../../../wdio.log4js.js').log();
var rootConfig = require('../../../../wdio.conf.js').config;

Then(/^I expect that the header of page contains "([^"]*)"$/, function(title) {
    browser.pause(rootConfig.newPlatformPauseTimeout);
    var isVerified;
    isVerified = ShopRoomPage.isHeaderDisplayed(title);
    assert.isTrue(isVerified, 'Shop Room header is not matched');
});
Then(/^I verify the navigation menu is displayed$/, function() {
    browser.pause(rootConfig.newPlatformPauseTimeout);
    var isDisplayed = ShopRoomPage.isNavMenuDisplayed();
    assert.isTrue(isDisplayed, 'Navigation menu is not displayed');
});
