import CollectionGalleryPage from '../../../pageobjects/browse/cg.page';
var rootConfig = require('../../../../wdio.conf.js').config;

const { Given } = require('cucumber');

Given(/^I open the cg page with "([^"]*)?"$/, function(categoryId) {
    CollectionGalleryPage.openToCollection(categoryId);
    browser.pause(rootConfig.newPlatformPauseTimeout);
});
