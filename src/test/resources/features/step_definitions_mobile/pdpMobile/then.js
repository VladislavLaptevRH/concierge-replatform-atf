import ProductDisplayPageMobile from '../../../pageObjectsMobile/pdp/pdp.page';
import { waitFor } from '../../../packages/testing-library';
var rootConfig = require('../../../../wdio.conf.js').config;
import { heroImageSrc, lineItemSrc, lineItemSrc2 } from '../pdpMobile/when';
const { Then } = require('cucumber');
var logger = require('../../../../wdio.log4js.js').log();

Then(
    /^I verify currency for respective "([^"]*)" on "([^"]*)" page on mobile$/,
    function(country, pageName) {
        console.log('pagename: ', pageName, ' country: ', country);
        var isVerified;
        if (pageName == 'PDP') {
            isVerified = ProductDisplayPageMobile.verifyCurrencyMobile(country);
            assert.isTrue(isVerified, 'Currency is not as expected');
        } else {
            logger.info('Invalid Page');
        }
    }
);

Then(/^I expect to see the "([^"]*)" delivery message on mobile$/, function(
    messageType
) {
    browser.pause(2000);
    ProductDisplayPageMobile.checkForAdditionalMessage(
        this.skuProductId,
        messageType
    );
});
Then(
    /^I verify Pricing and Add to Cart after selecting the options on mobile$/,
    function() {
        browser.pause(rootConfig.newPlatformPauseTimeout);
        let isEnabled, isPricing, flag;
        isEnabled = ProductDisplayPageMobile.verifyATCButton();
        isPricing = ProductDisplayPageMobile.verifyPricing();
        logger.info('isEnabled', isEnabled, 'isPricing', isPricing);
        if (isPricing == true && isEnabled == true) {
            flag = true;
        } else {
            flag = false;
        }
        assert.isTrue(
            flag,
            'Pricing not displayed and not enabled the ATC Button'
        );
    }
);

Then(
    /^I expect to see the "([^"]*)" and "([^"]*)" delivery messaging$/,
    (messaging, spoMessaging) => {
        assert.equal(
            messaging,
            browser
                .$('[data-testid="swatch-panel-dialog-delivery-message"]')
                .getText()
        );
        assert.equal(
            spoMessaging,
            browser
                .$('[data-testid="swatch-panel-dialog-spo-delivery-messsage"]')
                .getText()
        );
    }
);
Then(/^I can see the "([^"]*)" message$/, function(countryMsg) {
    var isDisplayed;
    isDisplayed = ProductDisplayPageMobile.verifyForCurrencyAcceptanceBox(
        countryMsg
    );
    assert.isTrue(isDisplayed, 'Currency Acceptance PopUp is not displayed');
});

Then(
    /^I can see swatch preview with selected swatch and i close it$/,
    function() {
        var isSwatchDisplayed = ProductDisplayPageMobile.verifySwatchOnPreview();
        assert.isTrue(isSwatchDisplayed, 'swatch preview is not displayed');
    }
);

Then(
    /^I verify( "([^"]*)?")* "([^"]*)" image is changed as per selection on mobile$/,
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
            ProductDisplayPageMobile.isImageChange(image, imageSrc, number),
            'Image is not Changed'
        );
    }
);

Then(
    /^I verify the option is selected for "([^"]*)" as per selection on mobile$/,
    function(productId) {
        assert.isTrue(
            ProductDisplayPageMobile.verifyColorizeOptionSelection(productId),
            'Option is not selected'
        );
    }
);

Then(/^I close swatch panel modal on mobile$/, function() {
    browser.pause(1000);
    ProductDisplayPageMobile.closeSwatchModal();
});

Then(
    /^I verify the option is selected for child product "([^"]*)" as per selection on mobile$/,
    function(childProductId) {
        assert.isTrue(
            ProductDisplayPageMobile.verifyColorizeOptionSelectionForChildProductId(
                childProductId
            ),
            'Option is not selected'
        );
    }
);
