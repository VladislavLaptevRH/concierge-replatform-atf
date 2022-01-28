import InteriorDesignPage from '../../../pageobjects/rhInteriorDesign/interiorDesign.page';
var rootConfig = require('../../../../wdio.conf.js').config;
const { Then } = require('cucumber');

Then(/^I verify RAC modal is displayed$/, function() {
    browser.pause(rootConfig.newPlatformLowPauseTimeout);
    var isModalDisplayed = InteriorDesignPage.isModalDisplayed();
    assert.isTrue(isModalDisplayed, 'Modal is not displayed');
});

Then(/^I verify the RAC form is submitted$/, function() {
    browser.pause(rootConfig.newPlatformLowPauseTimeout);
    var isFormSubmitted = InteriorDesignPage.isFormSubmitted();
    assert.isTrue(isFormSubmitted, 'Form is not submitted');
});
