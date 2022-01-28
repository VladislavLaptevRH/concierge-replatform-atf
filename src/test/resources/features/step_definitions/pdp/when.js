import ProductDisplayPage from '../../../pageobjects/browse/pdp.page';
import CustomProductDisplayPage from '../../../pageobjects/browse/pdpCustom.page';
import { config } from '../../../../wdio.conf';
const { When } = require('cucumber');
var logger = require('../../../../wdio.log4js.js').log();
let heroImageSrc, lineItemSrc, lineItemSrc2;
When(/^I select the options and add quantity "([^"]*)" to cart$/, function(
    qty
) {
    ProductDisplayPage.selectOptionsAndAddToCart(
        this.skuOptions,
        this.skuProductId,
        qty
    );
    browser.pause(1000);
});

When(/^I select the options$/, function() {
    const productId = this.skuProductId;
    ProductDisplayPage.selectOptions(this.skuOptions, this.skuProductId);

    // browser.waitUntil(
    //     () => {
    //         return (
    //             ProductDisplayPage.getItemSkuByProductId(this.skuProductId)
    //                 .getText()
    //                 .indexOf(this.skuId) !== -1
    //         );
    //     },
    //     12000,
    //     'sku id did not appear for selected options after 5s'
    // );
});

When(
    /^I select the options and add quantity "([^"]*)" to my project$/,
    function(qty) {
        ProductDisplayPage.selectOptionsAndAddToProject(
            this.skuOptions,
            this.skuProductId,
            qty,
            this.projectId
        );
        browser.pause(1000);
    }
);

When(/^I select the options and quantity "([^"]*)"$/, function(qty) {
    ProductDisplayPage.selectOptions(this.skuOptions, this.skuProductId);

    ProductDisplayPage.selectItemQuantity(this.skuProductId, qty);
});

When(/^I select quantity "([^"]*)"$/, function(qty) {
    ProductDisplayPage.selectItemQuantity(this.skuProductId, qty);
});

When(
    /^I add the product to my project with the (Add To Project|instock Add To Project|Add All To Project) button$/,
    function(buttonName) {
        ProductDisplayPage.addToProjectAndViewProject({
            fullSkuId: this.skuId,
            productId: this.skuProductId,
            buttonName,
            projectId: this.projectId
        });
    }
);

When(/^I open the instock panel$/, function() {
    ProductDisplayPage.clickInstockButton(this.skuProductId);
});

When(/^I select the quantity "([^"]*)" for the instock item$/, function(qty) {
    ProductDisplayPage.selectInstockQuantity({
        fullSkuId: this.skuId,
        productId: this.skuProductId,
        qty
    });
});

When(/^I select custom options:$/, function(data) {
    const productId = this.skuProductId;
    const customOptions = data.hashes();
    CustomProductDisplayPage.selectCustomOptions({ productId, customOptions });
    this.customOptions = customOptions;
});

When(/^I select options and custom options:$/, function(data) {
    const customOptions = data.hashes();

    const productId = this.skuProductId;
    ProductDisplayPage.selectOptions(this.skuOptions, this.skuProductId);

    CustomProductDisplayPage.selectCustomOptions({ productId, customOptions });
    this.customOptions = customOptions;
});
When(
    /^I click on check your zip code and enter the zipcode "([^"]*)" for "([^"]*)"$/,
    function(zipcode, country) {
        ProductDisplayPage.clickAndEnterZipCode(zipcode, country);
    }
);
When(/^I scroll to link "([^"]*)"$/, function(scrollValue) {
    browser.scroll(0, parseInt(scrollValue));
    browser.pause(config.newPlatformPauseTimeout);
});
When(
    /^I click on Add to Registry Button for the product "([^"]*)" and select registry from modal and again click on Add to Registry$/,
    function(productId) {
        browser.pause(config.newPlatformPauseTimeout);
        ProductDisplayPage.clickAddToRegistryButton(productId);
    }
);

When(/^I click on "([^"]*)" link on PDP page$/, function(link) {
    ProductDisplayPage.clickOnLink(link);
});
When(
    /^I enter zip code "([^"]*)" for "([^"]*)" country and click on Confirm button$/,
    function(zipcode, country) {
        ProductDisplayPage.enterZipcodeandClickOnConfirm(zipcode, country);
    }
);
When(/^I click on "([^"]*)" button$/, function(button) {
    console.log('clicking on button');
    ProductDisplayPage.clickOnButton(button);
});

When(/^I select quantity "([^"]*)?" for "([^"]*)" Items$/, function(
    qty,
    typeOfProduct
) {
    ProductDisplayPage.selectItemQuantityOnModal(qty, typeOfProduct);
});

When(/^I click on the AddToCart button$/, function() {
    browser.pause(10000);
    ProductDisplayPage.clickAddToCart();
    browser.pause(5000);
    ProductDisplayPage.clickSpoAddToCart();
});

When(/^I vertically scroll "([^"]*)" to the line item$/, function(scrollValue) {
    ProductDisplayPage.scrollToTheElement(scrollValue);
});

When(/^I select the options and add to cart$/, function() {
    ProductDisplayPage.selectOptionsAndAddItemToCart(
        this.skuOptions,
        this.skuProductId
    );
});

When(/^I select swatch from swatch panel$/, function() {
    browser.pause(config.newPlatformPauseTimeout);
    heroImageSrc = ProductDisplayPage.getHeroImageSrc();
    logger.info('Hero image src is', heroImageSrc);
    lineItemSrc = ProductDisplayPage.getLineItemSrc();
    logger.info('Line Item image src is', lineItemSrc);
    ProductDisplayPage.selectFabricSwatchFromSwatchPanel();
});

When(/^I select swatch from swatch panel for product$/, function() {
    browser.pause(config.newPlatformPauseTimeout);
    heroImageSrc = ProductDisplayPage.getHeroImageSrc();
    logger.info('Hero image src is', heroImageSrc);
    lineItemSrc = ProductDisplayPage.getLineItemSrc();
    logger.info('First Line Item image src is', lineItemSrc);
    lineItemSrc2 = ProductDisplayPage.getSecondLineItemSrc();
    logger.info('Second Line Item image src is', lineItemSrc2);
    ProductDisplayPage.selectFabricSwatchFromSwatchPanel();
});

When(/^I select swatch on PDP page$/, function() {
    browser.pause(config.newPlatformPauseTimeout);
    heroImageSrc = ProductDisplayPage.getHeroImageSrc();
    logger.info('Hero image src is', heroImageSrc);
    lineItemSrc = ProductDisplayPage.getLineItemSrc();
    logger.info('Line Item image src is', lineItemSrc);
    ProductDisplayPage.selectSwatchFromSwatchPanel();
});

When(/^I select swatch on PDP page for product$/, function() {
    browser.pause(config.newPlatformPauseTimeout);
    heroImageSrc = ProductDisplayPage.getHeroImageSrc();
    logger.info('Hero image src is', heroImageSrc);
    lineItemSrc = ProductDisplayPage.getLineItemSrc();
    logger.info('First Line Item image src is', lineItemSrc);
    lineItemSrc2 = ProductDisplayPage.getSecondLineItemSrc();
    logger.info('Second Line Item image src is', lineItemSrc2);
    ProductDisplayPage.selectSwatchFromSwatchPanel();
});

When(/^I click on Add To Cart button for "([^"]*)"$/, function(productId) {
    ProductDisplayPage.addToCartAndProceedToCart(productId);
});
export { heroImageSrc, lineItemSrc, lineItemSrc2 };
