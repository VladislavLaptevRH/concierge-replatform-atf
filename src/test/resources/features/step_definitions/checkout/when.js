import CartPage from '../../../pageobjects/checkout/cart.page';
import ShipAddressPage from '../../../pageobjects/checkout/shipAddress.page';
import PaymentPage from '../../../pageobjects/checkout/payment.page';
import CheckoutLoginPage from '../../../pageobjects/checkout/checkoutLogin.page';
import OrderReviewPage from '../../../pageobjects/checkout/orderReview.page';
import UserPaymentPage from '../../../pageobjects/account/userPayment.page';

const { When } = require('cucumber');

When(/^I visit the cart$/, function() {
    CartPage.visit();
});

When(/^I visit the cart and click checkout$/, function() {
    CartPage.moveToCheckout();
});

When(/^I visit the cart and proceed to shipping$/, function() {
    CartPage.moveToCheckout();
});

When(/^I visit the cart and proceed to payment$/, function() {
    CartPage.moveToCheckout();
    ShipAddressPage.moveToPayment();
});

When(/^I continue as guest$/, function() {
    CheckoutLoginPage.continueAsGuest();
});

When(/^I enter shipping address:$/, function(data) {
    var addressFields = data.hashes();
    ShipAddressPage.applyShippingAddressToOrder(addressFields[0]);
});

When(/^I select billing same as shipping$/, function() {
    ShipAddressPage.clickBillingSameAsShipping();
});

When(/^I enter billing address and proceed to payment:$/, function(data) {
    var addressFields = data.hashes();

    ShipAddressPage.applyBillingAddressToOrder(addressFields[0]);
    ShipAddressPage.moveToPayment();
});

When(/^I enter email address "([^"]*)" on the shipping page$/, function(email) {
    ShipAddressPage.applyEmailAddressToOrder(email);
});

When(/^I proceed to payment$/, function() {
    ShipAddressPage.moveToPayment();
});

When(/^I enter ccv value "([^"]*)" for stored credit card$/, function(ccv) {
    PaymentPage.applySavedCreditCardToOrder(ccv);
});

When(/^I select the following saved card:$/, function(data) {
    var cardInfo = data.hashes();
    PaymentPage.selectSavedCard(cardInfo[0]);
});

When(/^I enter payment info for new card:$/, function(data) {
    var paymentFields = data.hashes();

    PaymentPage.applyNewCreditCardToOrder(paymentFields[0]);
});

When(/^I click submit on the payment page$/, function() {
    PaymentPage.clickSubmit();
});

When(/^I visit the cart and start a "([^"]*)?" quote$/, function(
    classification
) {
    CartPage.visit();

    // select order classification
    CartPage.selectOrderClassification(classification);

    //optionally accept prebill terms
    CartPage.acceptUpdatedPreBillTerms();

    // click on quote button
    CartPage.clickCreateQuoteButton();
});

When(/^I click on Place Order$/, function() {
    OrderReviewPage.clickOnPlaceOrderButton();
});

When(/^I select Split payment method$/, function() {
    PaymentPage.selectSplitPayment();
});

When(/^I enter split amount as "([^"]*)?" and click Continue$/, function(
    amount
) {
    PaymentPage.enterSpliAmountAndClickContinue(amount);
});

When(
    /^I continue to preview page by clicking on Continue on payment page$/,
    function() {
        PaymentPage.clickSubmit();
    }
);

When(/^I enter payment info for new gift card:$/, function(data) {
    var paymentFields = data.hashes();
    PaymentPage.applyRHGiftCard(paymentFields[0]);
});

When(/^I click on 'Back to Payment'$/, function() {
    OrderReviewPage.clickOnBackToPayment();
});

When(/^I enter payment information for prod$/, function() {
    PaymentPage.applyNewCreditCardToOrderForProd();
});
When(/^I proceed to shipping$/, function() {
    CartPage.moveToCheckout();
});
