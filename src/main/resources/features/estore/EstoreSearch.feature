@estoreTestRun
@estoreSearch

Feature: Estore Search

  Scenario: Search product via Product name
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    Then I verify that search result "802-GRAM TURKISH TOWEL COLLECTION" for search product via product name is displayed
#
  Scenario: Search product from other category
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "cribs" from search field
    Then I verify cribs title for estore

  Scenario: To verify search for random text
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I introduced random text for search field
    Then I verify that we cannot find what you are looking message is displayed

  Scenario: Verify count of search result and product
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "towels" from search field
    Then I verify count of search results

  Scenario: Verify the Back to top button
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    When I scroll to the bottom of the estore page
    When I click on estore back to top button

  Scenario: Verify the search results with multiple terms search: white and blue corner leather sofa
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "white and blue corner leather sofa" from search field
    Then I verify that search results for "white and blue corner leather sofa" is displayed

  Scenario: Place order: search with any key term, select Low to High. navigate to first product PDP
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "white" from search field
    When I select low to high for estore
    When I navigate for the first product PDP

  Scenario: Place order: search with any key term, select high to low. navigate to first product PDP
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "white and blue corner leather sofa" from search field
    When I select high to low for estore
    When I navigate for the first product PDP

  Scenario: Pricing on search result page(US and CAN)
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "towels" from search field
    Then I verify pricing on search result page

  Scenario: Back button
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "white and blue corner leather sofa" from search field
    When I navigate for the first product PDP
    Then I verify that I'm able to use back button

  Scenario: Search any product from CG and verify for back button
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "SOFAS" from search field
    Then I verify that I'm able to use back button from CG

  Scenario: Search any product from cart page and verify for back button
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I verify for back button from cart page

  Scenario Outline: Verify the 1,2 and 3 grid
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "white and blue corner leather sofa" from search field
    Then I verify the "<gridNumber>"
    Examples:
      | gridNumber |
      | 1          |
      | 2          |
      | 3          |

  Scenario: Apply any facet and verify the count of product
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "OUTDOOR" from search field
    Then I apply new arrivals facet

  Scenario: Verify the in stock facet selection and in stock product
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "sofa" from search field
    Then I verify in stock facet selection

  Scenario: Verify the results with multiple term search and facet selections
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "leather Sofa" from search field
    Then I verify the results with multiple term search

  Scenario: Brands refinement should only appear in concierge search, not on eStore
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "table" from search field
    Then I verify that brands refinement does not appear in estore search page

  Scenario: Hide swatches on Product Grid
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "sofa" from search field
    Then I verify that swathces are not displayed

  Scenario: Apply multiple facet and verify the count of product
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "table" from search field
    When I apply multiple facet on estore search page

  Scenario: Verify No search results page
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "QA Search Check" from search field
    Then I verify that No search result message is displayed

  Scenario: Verify that user is able to search with product name
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "TERZO ROUND DINING TABLE" from search field
    Then I verify that products that match the search criteria should be displayed

  Scenario:Verify that user is able to search with SKU id
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "17050044 EUCY" from search field
    Then I verify that search result "802-Gram Turkish Towel Collection" for search product via sku id is displayed

  Scenario: Verify that user is able to search with Product Id
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "prod2020027" from search field
    Then I verify that "prod2020027" title is displayed on CG

  Scenario: Verify that user is able to view price based on selected Pin code on PDP
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "Mirrors" from search field
    When I navigate to any estore fusion PG
    When I update "CAN" postal code on pdp page
    When I navigate back from "PDP" page
    Then verify the product price as per the postal code

  Scenario: Verify navigating back to Cart page from Search page
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I open product page with "prod25280089" and "17050044" with "JNPR" for estore
    When I click on add to cart estore button
    When I click on view cart estore button
    When I go to estore item "Mirrors" from search field
    When I navigate back from "PDP" page
    Then I verify that cart page is displayed
#--
  Scenario: Verify user is able to place a successful order for the searched product
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "17050044 EUCY" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

  Scenario: Verify the price for Outdoor sofa
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "Outdoor Sofa" from search field
    Then I verify that CG title is displayed for "Outdoor Sofa"
    And I verify that the price mentioned on PG page for "Outdoor Sofa"

  Scenario: Verify navigating back to PDP page from Search page
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on "Rugs" in TOP NAV menu
    When I click on SALE in Secondary NAV
    When I click on "Brown Rugs" in Tertiary NAV from "Rugs"
    When I navigate to any estore fusion PG
    When I go to estore item "Mirrors" from search field
    When I navigate back from "PG" page
    Then I verify that estore PDP page is displayed

  Scenario: Verify navigating back to PG page from Search page
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on "Rugs" in TOP NAV menu
    When I click on SALE in Secondary NAV
    When I click on "Brown Rugs" in Tertiary NAV from "Rugs"
    When I go to estore item "Mirrors" from search field
    When I navigate back from "PG" page
    Then I verify that PG page is displayed for eStore

  Scenario: Verify navigating back to CG page from Search page
    Given I log into eStore as "guest" user
    When I click on "Living" for estore
    When I click on "Fabric Seating" for estore
    When I click on "Seating Collections" for estore
    When I go to estore item "Mirrors" from search field
    When I navigate back from "PG" page
    Then I verify that "Seating Collections" title is displayed on CG

  Scenario: Verify searching multiple words as a criteria
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "glass mirrors" from search field
    Then I verify that "glass mirrors" title is displayed on CG

  Scenario:Verify Search Page filters - Clear applied filters
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "Mirrors" from search field
    When I apply In stock to Sale filter
    When I click on Shape dropdown
    When I click on Rectangular option
    When I click on clear all link in applied section filter
    Then I verify that the applied filters have been removed

  Scenario: Verify Search Page filters - multiple filters and Sort
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "Mirrors" from search field
    When I apply In stock to Sale filter
    When I click on Shape dropdown
    When I click on Rectangular option
    When I select low to high for estore
    Then I verify that sorting low to high is working as expected
    And I verify that available in multiple sizes&finishes should be displayed

  Scenario: Verify Search Page filters - multiple filter
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "Mirrors" from search field
    When I apply In stock to Sale filter
    When I click on Shape dropdown
    When I click on Rectangular option
    Then I verify page with previous filter applied
    And I verify that number of products should be displayed as RESULTS
    Then I verify that Rectangular filter should be displayed
    And I verify that available in multiple sizes&finishes should be displayed

  Scenario: Verify Search Page filters - Shape, if configured from BE
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "Mirrors" from search field
    When I click on Shape dropdown
    When I click on Rectangular option
    Then I verify that Rectangular filter should be displayed
    When I click on clear all link in applied section filter
    And I verify that number of products should be displayed as RESULTS

  Scenario: Verify Search Page filters - Size, if configured from BE
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "Mirrors" from search field
    When I click on Size dropdown
    When I click on width option from Size dropdown
    When I select width option value
    Then I verify that width filter should be displayed in the applied filter list
    And I verify that number of products should be displayed as RESULTS
    Then I click on clear all link in applied section filter

  Scenario: Verify Search Page filters - Material, if configured from BE
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "Sofas" from search field
    When I click on Material dropdown
    When I click on Leather option
    Then I verify that number of products should be displayed as RESULTS
    And I verify that material filter was applied
    Then I click on clear all link in applied section filter

  Scenario: Verify Search page Filters - New Arrival
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "Sofas" from search field
    When I click on New Arrival filter
    Then I verify that New Arrival filter was applied
    Then I verify that number of products should be displayed as RESULTS
    Then I click on clear all link in applied section filter

  Scenario: Verify Search page Filters - In Stock
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "Sofas" from search field
    When I apply In stock filter on PG for estore
    Then I verify that In stock filter was applied
    And I verify that number of products should be displayed as RESULTS
    Then I click on clear all link in applied section filter

  Scenario: Verify Search page Filters - Sale
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "Sofas" from search field
    When I apply In stock to Sale filter
    Then I verify that Sale filter was applied

  Scenario: Verify Search page sort option - Featured in Search page
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "Sofas" from search field
    Then I verify that default sort order should be featured

  Scenario: Verify Search page sort option - Price: High to Low in Search page
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "Sofas" from search field
    When I select high to low for estore
    Then I verify that sorting high to low is working as expected

  Scenario: Verify Search page sort option - Price: Low to High in Search page
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "Sofas" from search field
    When I select low to high for estore
    Then I verify that sorting low to high is working as expected

  Scenario: Verify Search page - sort options
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "Sofas" from search field
    When I click on sort by button for estore
    Then I verify that Featured,High to Low, Low to High options are displayed

  Scenario: Verify Search Page - no swatches
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "Sofas" from search field
    Then I verify that swatches are not displayed below the product image

  Scenario:Verify Search Page - less than 5 swatches
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "Sofas" from search field
    When I click on Size dropdown
    When I click on length button
    When I click on 5 length value
    Then I verify that the swatches should show below the image with correct padding

  Scenario: Verify PDP for the product where some skus are on sale - applying sale filter
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "Sofas" from search field
    When I apply In stock to Sale filter
    When I check sale price for "sofa" on PG page for estore
    When I navigate to any estore fusion PG
    Then I verify that prices for the VIEW SELECT ITEMS ON SALE on PDP and the sale page
    And I verify that PDP page url contains SALE=true

  Scenario: Verify PDP for the product where all skus are on sale - applying sale filter
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "Sofas" from search field
    When I apply In stock to Sale filter
    When I check sale price for "sofa" on PG page for estore
    When I navigate to any estore fusion PG
    Then I verify that prices for the VIEW SELECT ITEMS ON SALE on PDP and the sale page

  Scenario: Verify PDP upon clicking "VIEW SELECT ITEMS ON SALE"
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "sofas" from search field
    When I apply In stock to Sale filter
    When I check sale price for "sofa" on PG page for estore
    When I go to the sale page with "sofas" on estore
    Then I verify that prices for the VIEW SELECT ITEMS ON SALE on PG and the sale page

  Scenario: Verify Search Page - Pricing format
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "sofas" from search field
    When I apply In stock to Sale filter
    And I verify sale prices on PG pages for sale items

































