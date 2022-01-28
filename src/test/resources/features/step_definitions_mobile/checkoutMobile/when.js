import CartMobilePage from '../../../pageObjectsMobile/checkout/cart.page';
import ShipAddressMobilePage from '../../../pageObjectsMobile/checkout/shipAddress.page';
import PaymentMobilePage from '../../../pageObjectsMobile/checkout/payment.page';
import CheckoutLoginMobilePage from '../../../pageObjectsMobile/checkout/checkoutLogin.page';
import OrderReviewMobilePage from '../../../pageObjectsMobile/checkout/orderReview.page';

const { When } = require('cucumber');

When(/^I visit the cart and proceed to shipping on mobile$/, function() {
    CartMobilePage.moveToCheckout();
});

When(/^I continue as guest on mobile$/, function() {
    CheckoutLoginMobilePage.continueAsGuest();
});

When(/^I enter shipping address on mobile:$/, function(data) {
    var addressFields = data.hashes();
    ShipAddressMobilePage.applyShippingAddressToOrder(addressFields[0]);
});

When(/^I select billing same as shipping on mobile$/, function() {
    ShipAddressMobilePage.clickBillingSameAsShipping();
});

When(/^I enter billing address and proceed to payment on mobile:$/, function(
    data
) {
    var addressFields = data.hashes();

    ShipAddressMobilePage.applyBillingAddressToOrder(addressFields[0]);
    ShipAddressMobilePage.moveToPayment();
});
When(
    /^I verify the billing address and proceed to payment on mobile$/,
    function() {
        ShipAddressMobilePage.verifyBillingAddress();
    }
);

When(/^I proceed to payment on mobile$/, function() {
    ShipAddressMobilePage.moveToPayment();
});

When(
    /^I enter email address "([^"]*)" on the shipping page on mobile$/,
    function(email) {
        ShipAddressMobilePage.applyEmailAddressToOrder(email);
    }
);

When(
    /^I continue to preview page by clicking on Continue on payment page on mobile$/,
    function() {
        PaymentMobilePage.clickSubmit();
    }
);

When(/^I enter payment information for prod on mobile$/, function() {
    PaymentMobilePage.applyNewCreditCardToOrderForProd();
});

When(/^I enter payment info for new card on mobile$/, function(data) {
    var paymentFields = data.hashes();
    PaymentMobilePage.applyNewCreditCardToOrder(paymentFields[0]);
});

When(/^I click on Place Order on mobile$/, function() {
    OrderReviewMobilePage.clickOnPlaceOrderButton();
});

When(/^I select Split payment method on mobile$/, function() {
    PaymentMobilePage.selectSplitPayment();
});

When(
    /^I enter split amount as "([^"]*)?" and click Continue on mobile$/,
    function(amount) {
        PaymentMobilePage.enterSpliAmountAndClickContinue(amount);
    }
);
