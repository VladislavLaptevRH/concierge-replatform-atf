@estoreTestRun

Feature: Estore PG

  Scenario: Grid view Mobile Only 1 and 2 grid view
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "sofa" from search field
    Then I validate "1","2" and "3" grid view should work

  Scenario: Verify two grids are default Grid view in PG
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "white and blue corner leather sofa" from search field
    Then I verify that two grids are default view in PG

  Scenario: PG - Back to Top button
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I goes to estore collection page
    When I scroll on the page till back to top button is visible
    Then I verify that back to top button is clickable
    And I verify that after click on back to top button user is scrolled to top on the page

  Scenario: Back button after applying filter
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I goes to estore product sale page
    When I apply In stock to Sale filter
    When I scroll on the PG page till back to top button is visible
    Then I verify that back to top button is clickable
    And I verify that after click on back to top button user is scrolled to top on the PG

  Scenario: Apply filter on PG and search for any term, application should give newly searched items
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I goes to estore product sale page
    When I apply In stock to Sale filter
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    Then I verify that search results page is displayed with newly searched products

  Scenario: Search any term apply filter and move to fusion PG and take back
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    When I apply In stock to Sale filter
    When I navigate to any estore fusion PG
    When I navigate back from "fusion PG" page
    Then I verify page with previous filter applied

  Scenario: Change the different grid and search the any product via search
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "sofa" from search field
    When I change a grid view from default 3 grid view to 2 grid view
    When I go to estore item "sofa" from search field
    Then I verify that page is displayed with the previous grid selected

  Scenario: Navigation to PG pages from top menu
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I navigate to PG page from top menu
    Then I verify that PG page is displayed with all the related products

  Scenario: Verify sale verbiage messages are present
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "belgian classic shelter arm" from search field
    Then I verify that sale verbiage message are present on PG page

  Scenario: Two grid and three grid views alignment
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "sofa" from search field
    Then I verify alignment for two and three grid views

  Scenario: Change PG grid view, go to PDP, go back to PG. Application should render to the same view grid which was selected
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "sofa" from search field
    When I change a grid view from default 3 grid view to 2 grid view
    When I navigate to any estore fusion PG
    When I navigate back from "PDP" page
    Then I verify that application render to the same view grid which was selected

  Scenario: Go to PDP, go back from PG, should redirect to the exact Product on PG
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "sofa" from search field
    When I change a grid view from default 3 grid view to 2 grid view
    When I navigate to any estore fusion PG
    When I navigate back from "PDP" page
    Then I verify that redirected to the exact product on PG

  Scenario: Search option should work fine on fusion + ATG PGs.

    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I goes to "rhmodern" estore brand
    When I go to estore item "sofa" from search field
    Then I verify that PG page is displayed with all filter options

  Scenario: Change the different grid and search the turkish towel product via search

    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "sofa" from search field
    When I change a grid view from default 3 grid view to 2 grid view
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    Then I verify that search results page is displayed with newly searched products

  Scenario: Verify the title after navigating fusion PG
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    Then I verify that search results page is displayed with newly searched products

  Scenario: PG - Verify the product details on PG
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "FABRIC CHAIR COLLECTION" from search field
    When I apply In stock to Sale filter
    Then I verify that the swatches should show below the image with correct padding
    And I verify that the product name and price should correct
    Then I verify that the VIEW SELECT ITEMS ON SALE link should show in red color
    And I verify that the underline should appear on the link VIEW SELECT ITEMS ON SALE.

  Scenario: Verify that user is able to see combined price on frame and cushion on PG
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    Then I verify that combined price on frame and cushion on PG
    When I navigate to any estore fusion PG
    And I verify that price on PG is the same as on PDP

  Scenario: Verify the prices shown against instock products on PG page when instock is selected and the prices at line item level on PDP are same
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    When I apply In stock filter on PG for estore
    Then I verify that the prices shown against instock products on PG page
    And I verify that combined price on frame and cushion on PG
    When I navigate to any estore fusion PG
    And I verify that price on PG is the same as on PDP for In stock filter applied

  Scenario: Verify the products are shown with relevant colorized images on PG page when instock filter is selected
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    When I apply In stock filter on PG for estore
    Then I verify that the products are shown with relevant colorized images on PG page

  Scenario: Verify the user can see Pagination carousel
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    When I scroll to the bottom of the estore page
    Then I verify that the Pagination carousel is displayed on PG for estore

  Scenario: Verify the Pagination carousel content
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    When I scroll to the bottom of the estore page
    Then I verify that the Pagination carousel content is displayed on PG for estore


