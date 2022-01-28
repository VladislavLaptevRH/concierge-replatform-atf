import ClearCartService from '../../../serviceobjects/cart/clearcart.service.js';
import AddToCartService from '../../../serviceobjects/cart/addtocart.service.js';

const { Given } = require('cucumber');

Given(/^I have the following items in the cart on mobile:$/, function(data) {
    const products = data.hashes();

    // preserve these globally for follow on when statements
    this.cartProducts = products;

    // clear the cart of any pre-existing items to cover the case where the
    // test is working on a registered user
    //
    ClearCartService.call();

    var postResult = AddToCartService.call(products);

    console.log(postResult.value.status);
    console.log(postResult.value.body);

    // check for invalid items and fail if they are there
    var invalids = postResult.value.body.invalidItems;
    if (invalids !== null) {
        expect(
            invalids,
            'Not all items could be added to cart. Check invalidItems list in log above.'
        ).to.be.an('object').that.is.empty;
    }
});
