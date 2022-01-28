import GiftRegistryPage from '../../../pageobjects/giftRegistry/giftRegistry.page';

const { Given } = require('cucumber');

Given(/^I crete registry if pre existing registry is not available$/, function() {
    GiftRegistryPage.open();
    GiftRegistryPage.checkExistingRegistry();
});
