import { assert } from 'chai';
import ProductDisplayPage from '../../../pageobjects/browse/pdp.page';
import { heroImageSrc, lineItemSrc, lineItemSrc2 } from '../pdp/when';
const { Then } = require('cucumber');
var logger = require('../../../../wdio.log4js.js').log();
var rootConfig = require('../../../../wdio.conf.js').config;

Then(/^I expect to see the "([^"]*)" delivery message$/, function(messageType) {
    ProductDisplayPage.checkForAdditionalMessage(
        this.skuProductId,
        messageType
    );
});
Then(/^I verify currency for respective "([^"]*)" on "([^"]*)" page$/, function(
    country,
    pageName
) {
    var isVerified;
    if (pageName == 'PDP') {
        isVerified = ProductDisplayPage.verifyCurrency(country);
        assert.isTrue(isVerified, 'Currency is not as expected');
    } else {
        logger.info('Invalid Page');
    }
});

Then(/^I expect the pdp page have this product "([^"]*)?"$/, function(
    productId
) {
    ProductDisplayPage.checkForProductOnPDP(productId);
});
Then(
    /^I am able to find "([^"]*)" button for the product "([^"]*)?"$/,
    function(button, productId) {
        switch (button) {
            case 'Add to WishList':
                ProductDisplayPage.checkAddToWishList(productId);
                break;
            case 'Add to Registry':
                ProductDisplayPage.checkAddToRegistry(productId);
                break;
        }
    }
);
Then(/^I can see a message "([^"]*)"$/, message => {
    ProductDisplayPage.verifyAddToRegistryMessage(message);
});

Then(/^I see a list of available "([^"]*)" Items$/, function(itemType) {
    var isItemDisplayed = ProductDisplayPage.isItemsDisplayed(itemType);
    assert.isTrue(isItemDisplayed, 'Items are not displayed');
});

Then(/^I verify "([^"]*)" fullSkuId on PDP page$/, function(fullSku_Id) {
    var isSkuPresent;
    browser.pause(rootConfig.newPlatformLowPauseTimeout);
    isSkuPresent = ProductDisplayPage.verifyFullSkuId(fullSku_Id);
    assert.isTrue(isSkuPresent, 'Full SKU Id is not as present');
});
Then(/^I click on the View Cart button$/, function() {
    browser.pause(rootConfig.newPlatformLowPauseTimeout);
    ProductDisplayPage.clickOnLink('View Cart');
});
Then(/^I close swatch panel modal$/, function() {
    browser.pause(1000);
    ProductDisplayPage.closeSwatchModal();
});
Then(
    /^I verify( "([^"]*)?")* "([^"]*)" image is changed as per selection$/,
    function(number, image) {
        var imageSrc;
        browser.pause(rootConfig.newPlatformPauseTimeout);
        if (image == 'Hero') {
            imageSrc = heroImageSrc;
        } else if (image == 'Line-Item') {
            if (number == 'second') {
                logger.info('Number is:', number);
                imageSrc = lineItemSrc2;
            } else {
                logger.info('Number is:', number);
                imageSrc = lineItemSrc;
            }
        }
        logger.info('Image src is:', imageSrc);
        assert.isFalse(
            ProductDisplayPage.isImageChange(image, imageSrc, number),
            'Image is not Changed'
        );
    }
);

Then(/^I scroll the PDP page till the footer$/, function() {
    ProductDisplayPage.scrollToTheFooter();
});

Then(
    /^I verify the option is selected for "([^"]*)" as per selection$/,
    function(productId) {
        assert.isTrue(
            ProductDisplayPage.verifyColorizeOptionSelection(productId),
            'Option is not selected'
        );
    }
);
Then(
    /^I verify the option is selected for child product "([^"]*)" as per selection$/,
    function(childProductId) {
        assert.isTrue(
            ProductDisplayPage.verifyColorizeOptionSelectionForChildProductId(
                childProductId
            ),
            'Option is not selected'
        );
    }
);
