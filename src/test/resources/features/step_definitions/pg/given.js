import ProductGalleryPage from '../../../pageobjects/browse/pg.page';

const { Given } = require('cucumber');

Given(/^I open the pg page with "([^"]*)?"$/, function(categoryId) {
    ProductGalleryPage.openToProductGallery(categoryId);
});
