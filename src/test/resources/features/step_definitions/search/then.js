const { Then } = require('cucumber');
import searchPage from '../../../pageobjects/search/search.page';
var rootConfig = require('../../../../wdio.conf.js').config;

Then(/^verify the one way synonym rule with "([^"]*)" and "([^"]*)"$/, function(
    searchterms,
    synonyms
) {
    browser.pause(1200);
    searchPage.synonymOneWayRule(searchterms, synonyms);
});

Then(
    /^Verify that checkbox is autoselected \"([^\"]*)\" in refinement \"([^\"]*)\"$/,
    function(subcategory, facets) {
        browseCategoryPage.verifyAutoSelectRefinement(subcategory, facets);
    }
);

Then(
    /^I verify the first two products on top contain the word "([^"]*)"$/,
    function(searchItem) {
        browser.pause(rootConfig.newPlatformPauseTimeout);
        var isSearchFieldPresent = searchPage.verifyProduct(searchItem);
        assert.isTrue(
            isSearchFieldPresent,
            'First two products on top does not contain word: ' + searchItem
        );
    }
);

Then(/^I see "([^"]*)" category refinement selected$/, function(categoryName) {
    var areCategoryDisplayed = searchPage.areCategoryDisplayed(categoryName);
    assert.isTrue(areCategoryDisplayed, 'Category refinement is not displayed');
});

Then(/^I verify filter "([^"]*)" is selected$/, function(option) {
    browser.pause(rootConfig.newPlatformLowPauseTimeout);
    var isOptionSelected = searchPage.isOptionSelected(option);
    assert.isTrue(isOptionSelected, 'Option is not selected');
});
