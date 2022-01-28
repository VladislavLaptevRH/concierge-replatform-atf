import WelcomeDialogPage from '../../../pageObjectsMobile/swatch/welcomeDialog.page';
import SwatchPage from '../../../pageObjectsMobile/swatch/swatch.page';
import ShippingDialogPage from '../../../pageObjectsMobile/swatch/shippingDialog.page';
import clickElementIfExist from '../../../support/action/clickElementIfExist';
var rootConfig = require('../../../../wdio.conf.js').config;
const { When } = require('cucumber');

When(/^I select "([^"]*)?" swatch options$/, function(swatchCount) {
    SwatchPage.selectSwatch(swatchCount);
});

When(/^I see a popup with message "([^"]*)?"$/, function(message) {
    expect(
        SwatchPage.greaterThanCertainQuantitySwatchPopupErrorMessage
    ).to.equal(message);
});

When(/^I select a swatch "([^"]*)?"$/, function(skuId) {
    browser.pause(rootConfig.newPlatformPauseTimeout);
    const swatchElement = SwatchPage.getSwatchElementBySkuId(skuId);
    swatchElement.click();
    browser.pause(rootConfig.newPlatformPauseTimeout);
});

When(/^I enter the following data in the shipping form on mobile:$/, function(
    data
) {
    ShippingDialogPage.applyShippingInfoToOrder(data.hashes()[0]);
});

When(/^I select "([^"]*)" type of swatch on mobile$/, function(typeOfswatch) {
    SwatchPage.selectTypeOfSwatch(typeOfswatch);
    browser.pause(5000);
});
