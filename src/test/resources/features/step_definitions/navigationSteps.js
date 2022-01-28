import AddressBookPage from '../../pageobjects/estoreAddressBook.page';
import LoginPage from '../../pageobjects/account/estoreLogin.page';
import Header from '../../pageobjects/estoreHeader.page';
import MiniCartPage from '../../pageobjects/checkout/minicart.page';
var rootConfig = require('../../../wdio.conf.js').config;

const { Given, When, Then } = require('cucumber');

/**
 * For going directly to a page, not using navigation.
 */
Given(/^I open the "([^"]*)?" page$/, function(pageName) {
    browser.pause(rootConfig.newPlatformLowPauseTimeout);
    switch (pageName.toLowerCase()) {
        case 'address book':
            AddressBookPage.open();
            break;
        case 'login':
        case 'register':
            LoginPage.open();
            break;
    }
});

//keep adding links as needed in header
When(/^I click the (sign in|sign out|cart) button in the header$/, function(
    button
) {
    switch (button) {
        case 'sign in':
            Header.clickSignInLink();
            break;
        case 'sign out':
            Header.clickSignOutLink();
            break;
        case 'cart':
            MiniCartPage.clickCartLink();
            break;
    }
});
//site links
When(
    /^I click (RH|RH Modern|RH Baby & Child|RH Teen|RH Ski House|RH Beach House|Outdoor|Shop Rooms) in the header$/,
    function(site) {
        Header.clickSiteLink(site);
    }
);
