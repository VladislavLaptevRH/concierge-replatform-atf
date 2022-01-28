import GalleryLocator from '../../../pageobjects/locator/galleryLocator.page';

const { Then } = require('cucumber');

Then(/^I expect the map to display "([^"]*)?" locations$/, function(storeType) {
    GalleryLocator.checkMapHasIcons(storeType);
});

Then(
    /^I expect the list to display( updated)? "([^"]*)?" locations(?: for "([^"]*)?")?$/,
    function(checkIsChanged, storeType, searchTerm) {
        // check the number of results and if needed, compare to last set
        const resultListCount = GalleryLocator.getResultListCount();
        if (checkIsChanged) {
            assert(
                resultListCount !== this.locatorResultsCount,
                'expected a different result count (' +
                    resultListCount +
                    ') than before (' +
                    this.locatorResultsCount +
                    ')'
            );
        }
        this.locatorResultsCount = resultListCount;

        GalleryLocator.checkFilterToggled(storeType);

        // check that search term is in search box
        if (searchTerm) {
            GalleryLocator.checkSearchTermIsDisplayed(searchTerm);
        }

        //list is non zero
        GalleryLocator.checkListHasEntries();
    }
);

Then(
    /^I expect the list and map to display all "([^"]*)?" locations$/,
    function(storeType) {
        GalleryLocator.checkFilterToggled(storeType);

        //list is non zero
        GalleryLocator.checkListHasEntries();

        //icons are displaying on the map
        GalleryLocator.checkMapHasIcons(storeType);

        GalleryLocator.checkMapAndListLengths(storeType);
    }
);

Then(/^I see a no locations found message$/, function() {
    GalleryLocator.checkForNoLocationsFoundMessage();
});

Then(/^I click on the store type filter and see updated results:$/, function(
    data
) {
    GalleryLocator.scrollDownToForm();
    const quickLinkOptions = data.hashes();
    quickLinkOptions.forEach(option => {
        GalleryLocator.selectStoreType(option.store_type);
        GalleryLocator.pauseForResultsToLoad();

        const resultListCount = GalleryLocator.getResultListCount();
        assert(
            resultListCount !== this.locatorResultsCount,
            'expected a different result count (' +
                resultListCount +
                ') than before (' +
                this.locatorResultsCount +
                ')'
        );
        this.locatorResultsCount = resultListCount;

        //icons are displaying on the map
        GalleryLocator.checkMapHasIcons(option.store_type);

        //list is non zero
        GalleryLocator.checkListHasEntries();
    });
});
