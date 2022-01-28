import ProductGalleryPage from '../../../pageobjects/browse/pg.page';
const { Then } = require('cucumber');
var logger = require('../../../../wdio.log4js.js').log();

Then (/^I verify for the product gallery list$/, function(){
    var isNotBlank =ProductGalleryPage.verifyProductGalleryList();
    assert.isTrue(isNotBlank, 'getting the blank page');

});
