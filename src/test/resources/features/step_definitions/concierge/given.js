import ConciergeLoginPage from '../../../pageobjects/concierge/concierge-login.page';
import ConciergeDashboard from '../../../pageobjects/concierge/conciergeDashboard.page.js';

const { Given } = require('cucumber');
var logger = require('../../../../wdio.log4js.js').log();

Given(
    /^I login into Concierge with valid credentials for the store "([^"]*)?"$/,
    function(storeName) {
        logger.info('I tried to login into the store : %s', storeName);
        var storeNumber = parseInt(storeName.substr(0, 3));
        logger.info('I tried to login into the store number : %d', storeNumber);
        ConciergeLoginPage.login(storeNumber);
        logger.info('I successfully logged in to concierge');
    }
);

Given(/^I am on concierge dashboard for the store "([^"]*)?"$/, function(
    storeName
) {
    var storeName = storeName.substring(4, storeName.length);
    logger.info('I tried to login into the store number : %s', storeName);
    var isStoreCorrect = ConciergeDashboard.isOnDesiredConciergeStore(
        storeName
    );
    assert.isTrue(
        isStoreCorrect,
        'logged in to a different store or not in dashboard page'
    );
});

Given(/^I navigate to "([^"]*)?" on concierge$/, function(portal) {
    ConciergeDashboard.clickOnButton('Browse');
    ConciergeDashboard.navigateToThePortalOnConcierge(portal);
    logger.info('clicked on the : %s portal', portal);
});
