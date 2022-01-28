import MonogramModalPage from '../../../pageobjects/monogram/monogramModal.page';
import { config } from '../../../../wdio.conf';
import ProductDisplayPage from "../../../pageobjects/browse/pdp.page";
var logger = require('../../../../wdio.log4js.js').log();

const { When } = require('cucumber');

When(/^I select options "([^"]*)" for font and color$/, function (index) {
    MonogramModalPage.selectFontStyleAndColor(index);
});

When(/^I enter text "([^"]*)" on monogram modal$/, function(text){
    MonogramModalPage.enterMonogramText(text);
});
When(/^I click on Add Monogram button on monogram modal$/, function(){
    MonogramModalPage.clickOnAddMonogramButton();
});


