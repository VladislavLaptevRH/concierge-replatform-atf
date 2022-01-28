import QuoteDetail from '../../../pageobjects/quotes/quoteDetail.page';
import QuoteList from '../../../pageobjects/quotes/quoteList.page';
import QuoteCreationForm from '../../../pageobjects/quotes/quoteCreationForm.page';
const { Given, When, Then } = require('cucumber');

When(/^I search for a quote by "([^"]*)?" for "([^"]*)?"$/, function(
    searchCriteria,
    searchTerm
) {
    QuoteList.searchForQuotes(searchCriteria, searchTerm);
});

When(/^I search for my quote by quote id$/, function() {
    QuoteList.searchForQuotes('Quote ID', this.quoteId);
});

When(/^I create a quote for user:$/, function(data) {
    QuoteCreationForm.createQuote(data.hashes()[0]);
    this.quoteId = QuoteDetail.getQuoteId();
});

Then(/^I see the items in my quote$/, function() {
    this.cartProducts.forEach(item => {
        QuoteDetail.checkItemIsInQuote({
            skuId: item.full_sku_id,
            quantity: item.qty
        });
    });
});

Then(/^I expect my quote to be listed$/, function() {
    QuoteList.checkQuoteIsInResults(this.quoteId);
});

Then(
    /^I expect clicking on the quote id opens the quote detail page$/,
    function() {
        QuoteList.clickQuoteResultLink(this.quoteId);
        QuoteDetail.checkQuoteLoaded(this.quoteId);
    }
);
