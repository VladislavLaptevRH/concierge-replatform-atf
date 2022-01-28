import ConciergeShoppingCart from '../../../pageobjects/concierge/conciergeShoppingCart.page.js';
import ConciergeClientLookUp from '../../../pageobjects/concierge/conciergeClientLookUp.page.js';
import ConciergeThankYouPage from '../../../pageobjects/concierge/conciergeThankYouPage.page.js';
import ConciergeSearchResult from '../../../pageobjects/concierge/conciergeSearchResult.page.js';
import ConciergeProductDisplayPage from '../../../pageobjects/concierge/conciergeProductDisplayPage.page.js';
import ConciergeQuoteListing from '../../../pageobjects/concierge/conciergeQuoteListingPage.page.js';

const { Then } = require('cucumber');
var logger = require('../../../../wdio.log4js.js').log();

Then(
    /^I validated the items present in the "([^"]*)?" page with the data-table$/,
    function(pageName, dataTable) {
        logger.info('On Page :%s ', pageName);
        const products = data.hashes();
        this.cartProducts = products;
        ConciergeShoppingCart.validateAllTheItemsPresentInTheShoppingCart(
            products
        );
    }
);

Then(/^I landed on the "([^"]*)?" page$/, function(pageName) {
    browser.pause(2000);
    logger.info('On Page :%s ', pageName);
    if (pageName === 'Client Look-up') {
        pageName = 'sf-client-lookup-form.jsp';
    } else if (pageName === 'Address') {
        pageName = 'address.jsp';
    } else if (pageName === 'Payment') {
        pageName = 'payment.jsp';
    } else if (pageName === 'Order Review') {
        pageName = 'order_review.jsp';
    } else if (pageName === 'Thank You') {
        pageName = 'thank_you.jsp';
    } else if (pageName === 'search result') {
        pageName = 'search/results.jsp';
    } else if (pageName === 'PDP') {
        pageName = 'catalog/product/product.jsp';
    } else if (pageName === 'Quote Listing') {
        pageName = 'quote/quote-listing.jsp';
    } else {
        // add code here later
    }
    browser.pause(3000);
    var currentUrl = browser.getUrl();
    var isOnDesiredPage = currentUrl.includes(pageName);
    assert.isTrue(isOnDesiredPage, 'On the wrong page');
});

Then(/^I see "([^"]*)?" in "([^"]*)?" page$/, function(argName, pageName) {
    logger.info('On Page :%s ', pageName);
    var isDisplayed = false;
    if (pageName === 'Client Look-up') {
        isDisplayed = ConciergeClientLookUp.isClientSearchResultDisplayed(
            argName
        );
    } else if (pageName === 'Thank You') {
        isDisplayed = ConciergeThankYouPage.isOrderNoAppeearedOnThePage();
    } else if (pageName === 'PDP') {
        isDisplayed = ConciergeProductDisplayPage.isSkuPresent(argName);
    } else {
        // add code for other pages when needed
    }
    assert.isTrue(isDisplayed, 'not displayed the desired object');
});

Then(
    /^I verify payment information under payment information section on checkout thank you page$/,
    function(dataTable) {
        var paymentFields = dataTable.hashes();
        var isVerified = ConciergeThankYouPage.verifyPaymentInformationOnCheckoutThankYouPageForSingleCard(
            paymentFields[0]
        );
        assert.isTrue(isVerified, 'failed in verification');
    }
);

Then(
    /^I verify price on the first product from "([^"]*)?" sorting is less than from "([^"]*)?"$/,
    function(firstSortStyle, secondSortStyle) {
        var isCorrect = ConciergeSearchResult.verifyPriceOfTheFirstProductIsLess(
            firstSortStyle,
            secondSortStyle
        );
        assert.isTrue(isCorrect, 'not the correct price');
    }
);

Then(/^I see the products in the of the types "([^"]*)?"$/, function(
    searchTerms
) {
    var isCorrect = ConciergeSearchResult.seesTheProductsWithTheSearchTerm(
        searchTerms
    );
    assert.isTrue(isCorrect, 'not the correct search term');
});

Then(/^I verify column "([^"]*)?" present on "([^"]*)?" page$/, function(
    columns,
    pageName
) {
    var isVerified;
    if (pageName === 'Quote Listing') {
        isVerified = ConciergeQuoteListing.verifyTheColumnsPresentInThePage(
            columns
        );
    } else {
        // add code for other pages when needed
    }

    assert.isTrue(isVerified, 'Failed to verify');
});
