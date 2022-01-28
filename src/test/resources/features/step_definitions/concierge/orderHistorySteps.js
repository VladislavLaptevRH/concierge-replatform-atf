import ConciergeOrderHistorySearch from '../../../pageobjects/concierge/conciergeOrderHistorySearch.page';
import ConciergeOrderHistorySearchResults from '../../../pageobjects/concierge/conciergeOrderHistorySearchResults.page';

const { Given, When, Then } = require('cucumber');

When(/^I open the order history search page$/, function() {
    ConciergeOrderHistorySearch.open();
});

When(/^I search order history for customer:$/, function(data) {
    const searchFields = data.hashes();
    ConciergeOrderHistorySearch.searchForCustomer(searchFields[0]);
});

Then(/^I see results for order history by customer search$/, function() {
    ConciergeOrderHistorySearchResults.checkCustomerResultsListsExists();
});

Then(/^I verify the customer lookup form appears$/, function() {
    ConciergeOrderHistorySearch.checkCustomerSearchExists();
});

Then(/^I verify the order lookup form appears$/, function() {
    ConciergeOrderHistorySearch.checkOrderSearchExists();
});
