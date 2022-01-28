import ConciergeLoginPage from '../../../pageobjects/concierge/concierge-login.page';

const { Given, When, Then } = require('cucumber');
var logger = require('../../../../wdio.log4js.js').log();

Given(/^I am logged into Concierge as "([^"]*)?"$/, function(username) {
    ConciergeLoginPage.loginForUser(username);
});

Given(/^I log into Concierge as "([^"]*)?"$/, function(username) {
    ConciergeLoginPage.loginForUser(username);
});

Given(
    /^I log into Concierge as "([^"]*)?" and store number "([^"]*)?"$/,
    function(username, storeNumber) {
        var storeNumber = parseInt(storeNumber);
        logger.info('I tried to login into the store number : %d', storeNumber);
        ConciergeLoginPage.login(storeNumber);
        logger.info('I successfully logged in to concierge');
    }
);
