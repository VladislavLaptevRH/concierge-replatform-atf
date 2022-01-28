import WelcomeDialogPage from '../../../pageObjectsMobile/swatch/welcomeDialog.page';
import ShippingDialogPage from '../../../pageObjectsMobile/swatch/shippingDialog.page';
import ThankYouDialogPage from '../../../pageObjectsMobile/swatch/thankYouDialog.page';
import SwatchPage from '../../../pageObjectsMobile/swatch/swatch.page';
import clickElementIfExist from '../../../support/action/clickElementIfExist';

var rootConfig = require('../../../../wdio.conf.js').config;

var errorMessagesSet = new Set([
    'first name is required',
    'last name is required',
    'email is required',
    'phone is required',
    'address is required',
    'city is required',
    'state is required',
    'required',
    'country is required'
]);

const { Then } = require('cucumber');

Then(/^I dismiss the swatch welcome popup if exists$/, function() {
    clickElementIfExist(
        'click',
        'element',
        WelcomeDialogPage.getStartBrowsingButtonSelector()
    );
});

Then(/^I scroll on swatch mobile with "([^"]*)"$/, function(scrollValue) {
    browser.scroll(0, parseInt(scrollValue));
    browser.pause(rootConfig.newPlatformPauseTimeout);
});

Then(/^I click on place order$/, function() {
    ShippingDialogPage.placeOrder();
});
Then(/^I wait on loading cursor$/, function() {
    ShippingDialogPage.swatchShippingLoadingSpinner.waitForExist(
        rootConfig.newPlatformPauseTimeout
    );
});

Then(
    /^I see thank you popup shows up and I close thank you popup$/,
    function() {
        ThankYouDialogPage.swatchThankYouPopUp.waitForExist(
            rootConfig.newPlatformPauseTimeout
        );
        ThankYouDialogPage.closeSwatchThankYouPopUp();
    }
);

Then(/^I see error message for each address field$/, function() {
    const errorMessages = ShippingDialogPage.swatchShippingErrorMessages;
    for (let idx = 0; idx < errorMessages.length; idx++) {
        assert.isTrue(errorMessagesSet.has(errorMessages[idx].getText()), true);
    }
});

Then(/^I verify the selected swatch "([^"]*)?" should be checked$/, function(
    swatchSkuId
) {
    SwatchPage.selectedSwatchChecked(swatchSkuId);
});

Then(/^I verify the selected "([^"]*)?" swatches should be checked$/, function(
    swatchCount
) {
    SwatchPage.selectedSwatchesChecked(swatchCount);
});
Then(/^I verify swarch options are available$/, function() {
    expect(SwatchPage.swatchCheckboxSelections).to.have.length.above(0);
});
