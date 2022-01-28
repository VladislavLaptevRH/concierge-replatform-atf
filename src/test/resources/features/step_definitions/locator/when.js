import GalleryLocator from '../../../pageobjects/locator/galleryLocator.page';
const { When } = require('cucumber');

When(/^I enter "([^"]*)?" in the locator search field/, function(searchTerm) {
    GalleryLocator.scrollDownToForm();
    GalleryLocator.searchForTerm(searchTerm);
});

When(/^I enter "([^"]*)?" in the locator search promo field/, function(
    searchTerm
) {
    GalleryLocator.searchForTermFromPromoSearchField(searchTerm);
});
