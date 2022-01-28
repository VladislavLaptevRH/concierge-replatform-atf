import WelcomeDialogPage from '../../../pageobjects/swatchLandingPage/welcomeDialog.page';
import SwatchPage from '../../../pageobjects/swatchLandingPage/swatch.page';
import ShippingDialogPage from '../../../pageobjects/swatchLandingPage/shippingDialog.page';
import clickElementIfExist from '../../../support/action/clickElementIfExist';
var rootConfig = require('../../../../wdio.conf.js').config;
const { When } = require('cucumber');

When(/^I dismiss the swatch welcome popup if exists$/, function() {
    clickElementIfExist(
        'click',
        'element',
        WelcomeDialogPage.getStartBrowsingButtonSelector()
    );
});

When(/^I scroll on swatch with "([^"]*)"$/, function(scrollValue) {
    browser.scroll(0, parseInt(scrollValue));
    browser.pause(rootConfig.newPlatformPauseTimeout);
});

When(/^I select "([^"]*)?" swatch options from swatches$/, function(
    swatchCount
) {
    SwatchPage.selectSwatch(swatchCount);
});

When(/^I select a swatch of sku "([^"]*)?"$/, function(skuId) {
    browser.pause(rootConfig.newPlatformPauseTimeout);
    const swatchElement = SwatchPage.getSwatchElementBySkuId(skuId);
    swatchElement.click();
    browser.pause(rootConfig.newPlatformPauseTimeout);
});

When(/^I enter the following data in the shipping form on desktop:$/, function(
    data
) {
    ShippingDialogPage.applyShippingInfoToOrder(data.hashes()[0]);
});

When(/^I select "([^"]*)" type of swatch$/, function(typeOfswatch) {
    SwatchPage.selectTypeOfSwatch(typeOfswatch);
    browser.pause(5000);
});
