import CartPage from '../../../pageobjects/checkout/cart.page';
import OrderReviewPage from '../../../pageobjects/checkout/orderReview.page';
import PaymentPage from '../../../pageobjects/checkout/payment.page';
import ThankYouPage from '../../../pageobjects/checkout/thankyou.page';
import LogoutService from '../../../serviceobjects/account/logout.service';
var rootConfig = require('../../../../wdio.conf.js').config;
const { Then } = require('cucumber');

Then(
    /^I expect the cart to have a "([^"]*)?" with quantity "([^"]*)?"$/,
    (itemName, itemQty) => {
        CartPage.checkItemInCart(itemName, itemQty);
    }
);

Then(/^I expect the cart subtotal to be the sum of item totals$/, () => {
    CartPage.checkCartSubtotals();
});

Then(
    /^I expect the cart to display "([^"]*)?" shipping charge$/,
    chargeType => {
        CartPage.verifyShippingCharge(chargeType);
    }
);

Then(/^I expect the cart totals to be correct$/, () => {
    CartPage.checkCartTotals();
});

Then(/^I expect the cart quantity to be "([^"]*)?"$/, totalQty => {
    CartPage.checkCartTotalQuantity(totalQty);
});

Then(/^I expect to be on the( empty)* cart page$/, function(emptyCase) {
    CartPage.checkCartPageLayout(!!emptyCase);
});

Then(/^I expect the review page totals to be correct$/, () => {
    OrderReviewPage.verifyOrderTotals();
});

Then(/^I expect the review page subtotal to be the sum of item totals$/, () => {
    OrderReviewPage.verifyItemSubtotals();
});

Then(/^I expect the review page to be displayed$/, () => {
    OrderReviewPage.verifyReviewPageDisplay();
    browser.pause(2000);
});

Then(/^I expect the payment page to be displayed$/, () => {
    PaymentPage.verifyPaymentPageDisplay();
    browser.pause(1000);
});

Then(/^I expect to see the saved card data on the payment page:$/, function(
    data
) {
    var cardInfo = data.hashes();
    PaymentPage.verifySavedCardData(cardInfo[0]);
});

Then(/^I expect the checkout payment error "([^"]*)?"$/, errMsg => {
    PaymentPage.verifyPaymentError(errMsg);
    browser.pause(1000);
});

Then(
    /^I expect the (availability|delivery|returns) messages to be shown for non-service skus only$/,
    function(messageType) {
        const cartProducts = this.cartProducts;
        let isMessageDisplayed,
            index = cartProducts.length - 1;

        cartProducts.forEach(function(product) {
            isMessageDisplayed = product.service_sku === 'false';
            CartPage.checkAvailabilityIsDisplayedForItemByIndex({
                messageType,
                isMessageDisplayed,
                index
            });
            index--;
        });
    }
);

Then(/^I land on Thank you page and I see the Order Number$/, function() {
    ThankYouPage.verifyOnThankYouPage();
    ThankYouPage.getOrderNumber();
});

Then(
    /^I verify payment information for estore under payment information section on checkout thank you page$/,
    function(data) {
        var paymentFields = data.hashes();
        ThankYouPage.verifyPaymentInformationOnCheckoutThankYouPageForSingleCard(
            paymentFields[0]
        );
    }
);

Then(/^Payment information is "([^"]*)?" on checkOut Thank you page$/, function(
    cardInfo
) {
    ThankYouPage.verifyPaymentInformationOnCheckoutThankYouPage(cardInfo);
});

Then(/^I signed out$/, function() {
    //   ThankYouPage.navigateToRHHomePage();
    LogoutService.call();
});

Then(/^I verify grouping option is displayed and I select it$/, function() {
    browser.pause(rootConfig.newPlatformLowPauseTimeout);
    CartPage.selectGroupingOption();
});

Then(/^I verify grouping option is selected$/, function() {
    var isGroupingPresent;
    browser.pause(rootConfig.newPlatformLowPauseTimeout);
    isGroupingPresent = CartPage.isGroupinOptionSelected();
    assert.isTrue(isGroupingPresent, 'Grouping option is not as selected');
});

Then(/^I see item in cart with same name as on PDP$/, function() {
    var isProductPresent = CartPage.isItemPresentInCart();
    assert.isTrue(isProductPresent, 'Expected item is not present in the cart');
});
