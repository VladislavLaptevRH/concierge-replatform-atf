import CartPage from '../../../pageobjects/checkout/cart.page';
import MiniCartPage from '../../../pageobjects/checkout/minicart.page';

const { Then } = require('cucumber');

Then(
    /^I expect the minicart to have a "([^"]*)?" with quantity "([^"]*)?"$/,
    (itemName, itemQty) => {
        MiniCartPage.checkItemInMiniCart(itemName, itemQty);
    }
);

Then(/^I expect the minicart quantity to be "([^"]*)?"$/, totalQty => {
    MiniCartPage.checkMiniCartTotalQuantity(totalQty);
});

Then(/^I expect the minicart subtotal to be the sum of item totals$/, () => {
    MiniCartPage.checkMiniCartSubtotals();
});

Then(/^I expect the minicart subtotal to be zero$/, () => {
    MiniCartPage.checkMiniCartSubtotalIsZero();
});

Then(/^I expect the minicart totals to be correct$/, () => {
    MiniCartPage.checkMiniCartTotals();
});

Then(
    /^I expect the minicart to display "([^"]*)?" shipping charge$/,
    chargeType => {
        MiniCartPage.verifyShippingCharge(chargeType);
    }
);

Then(/^I expect the minicart totals to match cart totals$/, () => {
    console.log('In the method --- expect mini cart totals');
    var miniTotals = MiniCartPage.checkMiniCartTotals();
    var cartTotals = CartPage.checkCartTotals();

    console.log(miniTotals);
    console.log(cartTotals);

    miniTotals.subtotal.should.be.equal(cartTotals.subtotal);
    miniTotals.stdShipAmt.should.be.equal(cartTotals.stdShipAmt);
    miniTotals.hdlShipAmt.should.be.equal(cartTotals.hdlShipAmt);
    miniTotals.surchargeAmt.should.be.equal(cartTotals.surchargeAmt);
    miniTotals.mattressAmt.should.be.equal(cartTotals.mattressAmt);
});
