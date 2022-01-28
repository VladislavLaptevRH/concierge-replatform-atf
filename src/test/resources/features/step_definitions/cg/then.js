import CollectionGalleryPage from '../../../pageobjects/browse/cg.page';
const { Then } = require('cucumber');
var logger = require('../../../../wdio.log4js.js').log();

Then (/^I verify for the collection gallery list$/, function(){
    let isNotBlank =CollectionGalleryPage.verifyCollectionGalleryList();
    assert.isTrue(isNotBlank, 'getting the blank page');

});
