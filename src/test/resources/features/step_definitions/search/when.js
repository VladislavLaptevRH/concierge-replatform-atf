const { When } = require('cucumber');
import searchPage from '../../../pageobjects/search/search.page';

When(/^I click on the search icon$/, function() {
    searchPage.clickOnSearchIcon();
});

When(/^Search for product (.*)$/, function(text) {
    searchPage.sendKeysToSearch(text);
});

When(/^I click on search text box$/, function() {
    searchPage.clickOnSearchTextBox();
});

When(/^I navigate via "([^"]*)",and "([^"]*)"$/, function(topnav, category) {
    browseCategoryPage.browseForCategory(topnav, category);
});

When(/^I click on the subCategory \"([^\"]*)\"$/, function(subcategory) {
    browseCategoryPage.clickOnSubCategory(subcategory);
});

When(/^I search for "([^"]*)" in search box and click on See All$/, function(
    searchTerm
) {
    searchPage.searchForProduct(searchTerm);
});
When(/^I click "([^"]*)" filter item from left "([^"]*)" navigation$/, function(
    optionSelected,
    filterOption
) {
    searchPage.clickOnFilterOption(optionSelected, filterOption);
});
