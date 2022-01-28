import ConciergeNavigation from '../../../pageobjects/concierge/concierge-navigation.page';

const { Given, When, Then } = require('cucumber');

When(/^I navigate to "([^"]*)?" in Concierge$/, pageName => {
    ConciergeNavigation.navigateTo(pageName);
});

When(/^I change my store to store number "([^"]*)?"$/, function(storeNumber) {
    ConciergeNavigation.changeStore(storeNumber);
});

Then(/^I verify I see store "([^"]*)?" in the header$/, function(storeName) {
    ConciergeNavigation.checkStoreInHeader(storeName);
});
