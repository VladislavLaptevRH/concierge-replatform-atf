import SearchMobile from '../../../pageObjectsMobile/search/search.page';
const { Then } = require('cucumber');

Then(
    /^I enter "([^"]*)?" in the search field and verify search results url/,
    function(searchTerm) {
        SearchMobile.searchForATerm(searchTerm);
    }
);
