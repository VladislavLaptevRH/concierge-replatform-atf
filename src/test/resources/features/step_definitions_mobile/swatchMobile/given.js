import SwatchPage from '../../../pageObjectsMobile/swatch/swatch.page';

const { Given } = require('cucumber');

Given(/^Swatch options available$/, function() {
    expect(SwatchPage.swatchCheckboxSelections).to.have.length.above(0);
});

Given(/^I click on order swatches$/, function() {
    SwatchPage.openOrderSwatches();
});
