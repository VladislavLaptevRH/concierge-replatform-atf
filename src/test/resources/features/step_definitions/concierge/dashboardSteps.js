import ConciergeDashboard from '../../../pageobjects/concierge/conciergeDashboard.page';

const { Given, When, Then } = require('cucumber');

When(
    /^I navigate to the "([^"]*)?" page from the concierge dashboard$/,
    function(pageName) {
        ConciergeDashboard.open();
        ConciergeDashboard.navigateTo(pageName);
    }
);

Then(/^I expect that I am on the Concierge Dashboard page$/, function() {
    ConciergeDashboard.checkDashboardContent();
});
