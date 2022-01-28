import SwatchPage from '../../../pageobjects/swatchLandingPage/swatch.page';

const { Given } = require('cucumber');

Given(/^Swatch options available on desktop$/, function() {
    expect(SwatchPage.swatchCheckboxSelections).to.have.length.above(0);
});

Given(/^I click on order swatches button$/, function() {
    SwatchPage.openOrderSwatches();
});
