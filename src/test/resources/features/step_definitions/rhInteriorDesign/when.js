import InteriorDesignPage from '../../../pageobjects/rhInteriorDesign/interiorDesign.page';
const { When } = require('cucumber');

When(/^I click on Request A Design Consulatation button$/, function() {
    InteriorDesignPage.clickOnRAC();
});

When(/^I fill the RAC form for "([^"]*)?" and submit it$/, function(username) {
    InteriorDesignPage.fillRACform(username);
});
