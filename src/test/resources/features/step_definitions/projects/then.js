import ProjectDetailPage from '../../../pageobjects/projects/projectDetail.page';

const { Then } = require('cucumber');

Then(/^I see the product in my project$/, function() {
    ProjectDetailPage.checkProductInProject({
        divisionId: this.divisionId,
        skuId: this.skuId
    });
});

Then(/^I verify the product has the options I selected$/, function() {
    ProjectDetailPage.checkOptionsOnProduct({
        customOptions: this.customOptions,
        option: this.skuOptions,
        divisionId: this.divisionId
    });
});
