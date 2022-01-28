import ProductDisplayPage from '../../../pageobjects/browse/pdp.page';
import apiUtils from '../../../support/lib/apiUtils';

const { Given } = require('cucumber');

Given(/^I open the pdp "([^"]*)?"$/, function(productId) {
    ProductDisplayPage.openToProduct(productId);
});

Given(/^I open the pdp "([^"]*)?" by "([^"]*)?" brand$/, function(
    productId,
    brand
) {
    ProductDisplayPage.openToProductByBrand(productId, brand);
});

Given(/^I open the pdp "([^"]*)" for brand$/, function(productId) {
    ProductDisplayPage.openToProductForBrand(productId);
});

Given(/^I prepare options for product "([^"]*)" and sku "([^"]*)"$/, function(
    productId,
    fullSkuId
) {
    //returns a promise, which is what lets the test know it can move to the next step.
    return apiUtils
        .get({
            path: `/rh/api/sku/options/v1/${encodeURIComponent(fullSkuId)}`,
            queryParams: { productId }
        })
        .then(response => {
            // saves the options into the global "world" instance available for all steps in scenario
            this.skuOptions = response.body.options;
            this.skuProductId = productId;
            this.skuId = fullSkuId;
        })
        .catch(error => {
            console.log('error preparing sku options: ' + error);
        });
});

Given(/^I select "([^"]*)" , "([^"]*)" for "([^"]*)"$/, function(
    optionType,
    productId,
    optionValue
) {
    browser.pause(10000);
    ProductDisplayPage.selectItemOptionByValue(
        optionType,
        productId,
        optionValue
    );
});
Given(/^I select "([^"]*)" quantity for "([^"]*)"$/, function(
    qtyValue,
    productId
) {
    browser.pause(10000);
    ProductDisplayPage.selectItemQuantity(productId, qtyValue);
});
Given(
    /^I prepare options for product "([^"]*)" and sku "([^"]*)" for "([^"]*)"$/,
    function(productId, fullSkuId, postalCode) {
        //returns a promise, which is what lets the test know it can move to the next step.
        if (
            ProductDisplayPage.inventoryStatusValue(
                productId,
                fullSkuId,
                postalCode
            )
        ) {
            return apiUtils
                .get({
                    path: `/rh/api/sku/options/v1/${encodeURIComponent(
                        fullSkuId
                    )}`,
                    queryParams: { productId }
                })
                .then(response => {
                    // saves the options into the global "world" instance available for all steps in scenario
                    this.skuOptions = response.body.options;
                    this.skuProductId = productId;
                    this.skuId = fullSkuId;
                })
                .catch(error => {
                    console.log('error preparing sku options: ' + error);
                });
        } else {
            console.log('error fetching sku inventory response ');
        }
    }
);
