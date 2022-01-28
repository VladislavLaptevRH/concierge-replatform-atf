import ConciergeDashboard from '../../../pageobjects/concierge/conciergeDashboard.page.js';
import ConciergeShoppingCart from '../../../pageobjects/concierge/conciergeShoppingCart.page.js';
import ConciergeClientLookUp from '../../../pageobjects/concierge/conciergeClientLookUp.page.js';
import ConciergeAddressPage from '../../../pageobjects/concierge/conciergeAddressPage.page.js';
import ConciergePayment from '../../../pageobjects/concierge/conciergePayment.page.js';
import ConciergeOrderReview from '../../../pageobjects/concierge/conciergeOrderReview.page.js';
import ConciergeSearchResult from '../../../pageobjects/concierge/conciergeSearchResult.page.js';
import ConciergeQuoteListing from '../../../pageobjects/concierge/conciergeQuoteListingPage.page.js';

const { When } = require('cucumber');
var logger = require('../../../../wdio.log4js.js').log();

When(/^I navigate to the "([^"]*)?" page$/, function(pageName) {
    ConciergeDashboard.navigateTo(pageName);
    logger.info('Navigated to the :%s page successfully ', pageName);
});

When(/^I select the order classification "([^"]*)?" in dropdown$/, function(
    orderClassification
) {
    ConciergeShoppingCart.selectTheOrderClassificationfromTheDropDown(
        orderClassification
    );
});

When(/^I click on "([^"]*)?" button on "([^"]*)?" page$/, function(
    buttonName,
    pageName
) {
    if (pageName.trim() === 'cart') {
        ConciergeShoppingCart.navigateTo(buttonName);
    } else if (pageName === 'Client Look-up') {
        ConciergeClientLookUp.clickOnButton(buttonName);
    } else if (pageName === 'Address') {
        ConciergeAddressPage.clickOnButton(buttonName);
    } else if (pageName === 'Payment') {
        ConciergePayment.clickOnButton(buttonName);
    } else if (pageName === 'Order Review') {
        ConciergeOrderReview.clickOnButton(buttonName);
    } else if (pageName === 'Dashboard') {
        ConciergeDashboard.clickOnButton(buttonName);
    } else {
        //add code for other pages when needed
    }
});

When(/^I choose the delivery preference "([^"]*)?"$/, function(preferenceType) {
    ConciergeShoppingCart.chooseTheDeliveryPreferenceUnderTheOrderEstimateSection(
        preferenceType
    );
});

When(
    /^I look up for the client firstname "([^"]*)?" and lastname "([^"]*)?"$/,
    function(firstName, lastName) {
        logger.info(
            'Request received for client look up for the name %s %s',
            firstName,
            lastName
        );
        ConciergeClientLookUp.enterTheClientNameInTheLookUpForm(
            firstName,
            lastName
        );
    }
);

When(
    /^I select the "([^"]*)?" entry in the client search results table$/,
    function(index) {
        ConciergeClientLookUp.chooseTheClientfromTheSearchResultTable(index);
    }
);

When(/^I enter payment info for new card on concierge$/, function(
    paymentTable
) {
    var paymentFields = paymentTable.hashes();
    ConciergePayment.applyNewCreditCardToOrder(paymentFields[0]);
});

When(/^I continue to payment page$/, function() {
    ConciergeShoppingCart.selectTheOrderClassificationfromTheDropDown(
        'RH Gallery Order'
    );
    ConciergeShoppingCart.chooseTheDeliveryPreferenceUnderTheOrderEstimateSection(
        'Deliver items in this order as they are available'
    );
    ConciergeShoppingCart.navigateTo('checkout');

    browser.pause(2000);
    ConciergeClientLookUp.enterTheClientNameInTheLookUpForm('Ali', 'Tahbazian');
    ConciergeClientLookUp.clickOnButton('search');

    browser.pause(5000);
    ConciergeClientLookUp.chooseTheClientfromTheSearchResultTable(1);

    browser.pause(2000);
    ConciergeAddressPage.clickOnButton('continue');
});

When(/^I enter the amount "([^"]*)?"$/, function(amount) {
    logger.info('Request received to enter the split amount %d', amount);
    ConciergePayment.enterTheAmount(amount);
    ConciergePayment.clickOnButton('Add another payment');
});

When(/^I enter the "([^"]*)?"$/, function(searchTerm) {
    logger.info('Request received for searching the : %s', searchTerm);
    ConciergeDashboard.enterTheSearchTermOnTheSearchBox(searchTerm);
});

When(/^I sort by "([^"]*)?" on "([^"]*)?" page$/, function(
    sortStyle,
    pageName
) {
    if (pageName === 'search result') {
        ConciergeSearchResult.sortTheResults(sortStyle);
    } else {
        //add code for other pages when needed
    }
});

When(/^I sees the "([^"]*)?" product price on "([^"]*)?" page$/, function(
    index,
    pageName
) {
    if (pageName === 'search result') {
        ConciergeSearchResult.captureTheProductPrice(index);
    } else {
        //add code for other pages when needed
    }
});

When(
    /^I sort by "([^"]*)?" and take the price on the first product on the list$/,
    function(sortStyle) {
        ConciergeSearchResult.captureTheProductPriceForTheSortStyle(sortStyle);
    }
);

When(
    /^I search by "([^"]*)?" for the email "([^"]*)?" in quote search$/,
    function(dropDownArg, emailId) {
        ConciergeQuoteListing.quoteSearchForTheClient(dropDownArg, emailId);
    }
);

When(/^I click on refine search option with text "([^"]*)?"$/, function(
    refineSearchPortal
) {
    ConciergeSearchResult.clickOnRefinedSearchOption(refineSearchPortal);
});

When(/^I click on "([^"]*)?" category from left navigation$/, function(
    categoryOption
) {
    ConciergeSearchResult.clickOnTheCategoryOption(categoryOption);
});
