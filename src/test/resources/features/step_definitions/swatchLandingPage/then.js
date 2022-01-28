import ShippingDialogPage from '../../../pageobjects/swatchLandingPage/shippingDialog.page';
import ThankYouDialogPage from '../../../pageobjects/swatchLandingPage/thankYouDialog.page';
import SwatchPage from '../../../pageobjects/swatchLandingPage/swatch.page';

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

Then(/^I click on place order button$/, function() {
    ShippingDialogPage.placeOrder();
});
Then(/^I wait on a loading cursor$/, function() {
    ShippingDialogPage.swatchShippingLoadingSpinner.waitForExist(
        rootConfig.newPlatformPauseTimeout
    );
});

Then(
    /^I see a thank you popup shows up and I close thank you popup$/,
    function() {
        ThankYouDialogPage.swatchThankYouPopUp.waitForExist(
            rootConfig.newPlatformPauseTimeout
        );
        ThankYouDialogPage.closeSwatchThankYouPopUp();
    }
);

Then(
    /^I see error message for each address field in shipping form$/,
    function() {
        const errorMessages = ShippingDialogPage.swatchShippingErrorMessages;
        for (let idx = 0; idx < errorMessages.length; idx++) {
            assert.isTrue(
                errorMessagesSet.has(errorMessages[idx].getText()),
                true
            );
        }
    }
);
function selectedSwatchChecked(swatchSkuId) {
    const swatch = SwatchPage.getSwatchElementBySkuId(swatchSkuId);
    expect(
        browser.isSelected("[value='" + swatch.element().getValue() + "']")
    ).to.equal(true);
}

Then(
    /^I verify the selected swatch option "([^"]*)?" should be checked$/,
    function(swatchSkuId) {
        selectedSwatchChecked(swatchSkuId);
    }
);

Then(
    /^I verify the selected "([^"]*)?" swatch options should be checked$/,
    function(swatchCount) {
        SwatchPage.selectedSwatchesChecked(swatchCount);
    }
);

Then(/^I see message "([^"]*)?"$/, function(message) {
    expect(
        SwatchPage.greaterThanCertainQuantitySwatchPopupErrorMessage
    ).to.equal(message);
});

Then(/^I verify swatch options are available on desktop$/, function() {
    expect(SwatchPage.swatchCheckboxSelections).to.have.length.above(0);
});
