import ProductDisplayPageMobile from '../../../pageObjectsMobile/pdp/pdp.page';
import moveToElement from '../../../support/action/moveToElement';
var config = require('../../../../wdio.estoreselectorsmobile.conf.js').config;
var logger = require('../../../../wdio.log4js.js').log();
const { When } = require('cucumber');
let heroImageSrc, lineItemSrc, lineItemSrc2;

When(
    /^I click on availability, delivery & returns and click on check your zip code and enter "([^"]*)?" on mobile for "([^"]*)?"$/,
    function(zipcode, productId) {
        ProductDisplayPageMobile.clickOnAvailabilityDeliveryAndReturns(
            productId
        );
        ProductDisplayPageMobile.clickToCheckZipCode();
        ProductDisplayPageMobile.enterZipCode(zipcode);
    }
);

When(
    /^I click on change your zip code and enter "([^"]*)?" on mobile$/,
    function(zipcode) {
        ProductDisplayPageMobile.clickToChangeZipCode();
        ProductDisplayPageMobile.enterZipCode(zipcode);
    }
);

When(/^I select the options on mobile$/, function() {
    ProductDisplayPageMobile.selectOptionsMobile(
        this.skuOptions,
        this.skuProductId
    );
    browser.pause(1200);

    // ProductDisplayPageMobile.getItemSkuByProductIdMobile(this.skuProductId)
    //     .getText()
    //     .indexOf(this.skuId) !== -1;
});

When(/^I select the options and quantity "([^"]*)" on mobile$/, function(qty) {
    ProductDisplayPageMobile.selectOptionsMobile(
        this.skuOptions,
        this.skuProductId
    );
    ProductDisplayPageMobile.selectItemQuantity(this.skuProductId, qty);
});
When(
    /^I select the options and add quantity "([^"]*)" to cart on mobile$/,
    function(qty) {
        ProductDisplayPageMobile.selectOptionsAndAddToCart(
            this.skuOptions,
            this.skuProductId,
            qty
        );
        browser.pause(1000);
    }
);

When(/^I scroll on mobile$/, function() {
    console.log('scrolling down');
    browser.scroll(0, 500);
    browser.pause(5000);
    console.log(' scrolling done');
});

When(/^I scroll on mobile with "([^"]*)"$/, function(scrollValue) {
    console.log('scrolling down ' + scrollValue);
    browser.scroll(0, parseInt(scrollValue));
    browser.pause(5000);
    console.log(' scrolling done');
});

When(/^I verify Add To Cart Button is disabled on mobile$/, function() {
    let isDisabled;
    isDisabled = ProductDisplayPageMobile.verifyATCButton();
    assert.isFalse(isDisabled, 'not disabled the ATC Button');
});

When(/^I open the Swatch Panel Dialog$/, () => {
    const swatchDialogOpener = browser.$(config.swatchDialogOpener);
    swatchDialogOpener.scroll();
    swatchDialogOpener.click();
    browser.waitForVisible(config.swatchPanelDialog, 2000);
});
When(/^I click on OK button on mobile$/, function() {
    ProductDisplayPageMobile.clickOnCurrencyAcceptanceButton();
});

When(/^I click on "([^"]*)" link on PDP page on mobile$/, function(link) {
    ProductDisplayPageMobile.clickOnLink(link);
});

When(/^I click on "([^"]*)" fabric link on PDP page on mobile$/, function(
    link
) {
    browser.pause(config.newPlatformPauseTimeout);
    heroImageSrc = ProductDisplayPageMobile.getHeroImageSrc();
    logger.info('Hero image src is', heroImageSrc);
    lineItemSrc = ProductDisplayPageMobile.getLineItemSrc();
    logger.info('Line Item image src is', lineItemSrc);
    ProductDisplayPageMobile.clickOnLink(link);
});

When(/^I click on "([^"]*)" link on PDP page for product on mobile$/, function(
    link
) {
    browser.pause(config.newPlatformPauseTimeout);
    heroImageSrc = ProductDisplayPageMobile.getHeroImageSrc();
    logger.info('Hero image src is', heroImageSrc);
    lineItemSrc = ProductDisplayPageMobile.getLineItemSrc();
    logger.info('First Line Item image src is', lineItemSrc);
    lineItemSrc2 = ProductDisplayPageMobile.getSecondLineItemSrc();
    logger.info('Second Line Item image src is', lineItemSrc2);
    ProductDisplayPageMobile.clickOnLink(link);
});

When(/^I select swatch on PDP page on mobile$/, function() {
    browser.pause(config.newPlatformPauseTimeout);
    heroImageSrc = ProductDisplayPageMobile.getHeroImageSrc();
    logger.info('Hero image src is', heroImageSrc);
    lineItemSrc = ProductDisplayPageMobile.getLineItemSrc();
    logger.info('Line Item image src is', lineItemSrc);
    ProductDisplayPageMobile.selectSwatchFromSwatchPanel();
});

When(/^I select swatch on PDP page for product on mobile$/, function() {
    browser.pause(config.newPlatformPauseTimeout);
    heroImageSrc = ProductDisplayPageMobile.getHeroImageSrc();
    logger.info('Hero image src is', heroImageSrc);
    lineItemSrc = ProductDisplayPageMobile.getLineItemSrc();
    logger.info('First Line Item image src is', lineItemSrc);
    lineItemSrc2 = ProductDisplayPageMobile.getSecondLineItemSrc();
    logger.info('Second Line Item image src is', lineItemSrc2);
    ProductDisplayPageMobile.selectSwatchFromSwatchPanel();
});

When(/^I select swatch from swatch panel on mobile$/, function() {
    ProductDisplayPageMobile.selectFabricSwatchFromSwatchPanel();
});

export { heroImageSrc, lineItemSrc, lineItemSrc2 };
