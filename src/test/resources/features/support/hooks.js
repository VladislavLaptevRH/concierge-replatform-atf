import browserApiUtils from '../../support/lib/browserApiUtils';
import ConciergeNavigation from '../../pageobjects/concierge/concierge-navigation.page';
import QuoteDetail from '../../pageobjects/quotes/quoteDetail.page';
import QuoteList from '../../pageobjects/quotes/quoteList.page';
import LogoutService from '../../serviceobjects/account/logout.service';

var { After, Before } = require('cucumber');

//delete the project we created for the test.
After('@deleteProjectAfter', function() {
    console.log('deleting project ' + this.projectId);

    const postResult = browser.executeAsync(browserApiUtils.del, {
        path: '/rh/api/project/v1/' + this.projectId
    });
});

//log out of concierge
After('@logoutConciergeAfter', function() {
    ConciergeNavigation.logout();
});

// archive quote
// TODO: need a service for this.
After('@archiveQuoteAfter', function() {
    QuoteList.open();
    QuoteList.searchForQuotes('Quote ID', this.quoteId);
    QuoteList.clickQuoteResultLink(this.quoteId);
    QuoteDetail.archiveQuote();
});

//log out of estore
After('@logoutEstoreAfter', function() {
    return LogoutService.call();
});

//Getting scenario result status after each run
After(function(scenario) {
    console.log('scenario status after', scenario.result.status);
    //  var path = browser.options.screenshotPath;
    //  var fileName = path + '/ERROR_' + 'chrome' + Date.now() + '.png';
    //  var name = 'ERROR-chrome-' + Date.now();
    //  if (scenario.result.status === 'failed') {
    //      browser.saveScreenshot(fileName);
    //  }
});
