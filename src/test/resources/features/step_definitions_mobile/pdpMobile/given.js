import ProductDisplayPageMobile from '../../../pageObjectsMobile/pdp/pdp.page';
import apiUtils from '../../../support/lib/apiUtils';
import browserApiUtils from '../../../support/lib/browserApiUtils';
var rootConfig = require('../../../../wdio.conf.js').config;
const { Given } = require('cucumber');

Given(/^I open the pdp "([^"]*)?" on mobile$/, function(productid) {
    ProductDisplayPageMobile.openToProduct(productid);
});

Given(/^I open the pdp "([^"]*)?" on mobile by "([^"]*)?" brand$/, function(
    productid,
    brand
) {
    ProductDisplayPageMobile.openToProductByBrand(productid, brand);
});

Given(
    /^I prepare options for product "([^"]*)" and sku "([^"]*)" on mobile$/,
    function(productId, fullSkuId) {
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
    }
);
Given(
    /^I prepare options for product "([^"]*)" and sku "([^"]*)" for "([^"]*)" on mobile$/,
    function(productId, fullSkuId, postalCode) {
        //returns a promise, which is what lets the test know it can move to the next step.
        if (
            ProductDisplayPageMobile.inventoryStatusValue(
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

Given(
    /^I open the pdp and prepare options for sku for postal and select options and add qty to cart on mobile$/,
    function(data) {
        var productId, fullSkuId, postalCode, qty;
        var pdpInformation = data.hashes();
        pdpInformation.forEach(hash => {
            productId = hash['product_id'];
            fullSkuId = hash['full_sku_id'];
            postalCode = hash['postalCode'];
            qty = hash['qty'];
            ProductDisplayPageMobile.openToProduct(productId);
            if (
                ProductDisplayPageMobile.inventoryStatusValue(
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
            console.log(this.skuOptions, this.skuProductId);
            ProductDisplayPageMobile.selectOptionsAndAddToCart(
                this.skuOptions,
                this.skuProductId,
                qty
            );
            browser.pause(rootConfig.newPlatformPauseTimeout);
        });
    }
);
