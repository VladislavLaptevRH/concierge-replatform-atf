import GalleryLocator from '../../../pageobjects/locator/galleryLocator.page';

const { Given } = require('cucumber');

Given(/^I open the gallery locator page$/, function() {
    GalleryLocator.open();
    GalleryLocator.pauseForResultsToLoad();
    this.locatorResultsCount = GalleryLocator.getResultListCount();
});

Given(/^The Locator Search Promo is active$/, function() {
    GalleryLocator.checkGalleryLocatorPromoExists();
});
