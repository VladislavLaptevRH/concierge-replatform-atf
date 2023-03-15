@estoreRegression
Feature: Estore PG

  Scenario: Grid view Mobile Only 1 and 2 grid view
    Given I log into eStore as "guest" user
    When I go to estore item "white and blue corner leather sofa" from search field
    Then I validate "1","2" and "3" grid view should work

  Scenario: Verify two grids are default Grid view in PG
    Given I log into eStore as "guest" user
    When I go to estore item "white and blue corner leather sofa" from search field
    Then I verify that two grids are default view in PG

  Scenario: PG - Back to Top button
    Given I log into eStore as "guest" user
    When I goes to estore collection page
    When I scroll on the page till back to top button is visible
    Then I verify that back to top button is clickable
    And I verify that after click on back to top button user is scrolled to top on the page

  Scenario: Back button after appying filter
    Given I log into eStore as "guest" user
    When I goes to estore product sale page
    When I apply In stock to Sale filter
    When I scroll on the PG page till back to top button is visible
    Then I verify that back to top button is clickable
    And I verify that after click on back to top button user is scrolled to top on the PG

  Scenario: Apply filter on PG and search for any term, application should give newly searched items
    Given I log into eStore as "guest" user
    When I goes to estore product sale page
    When I apply In stock to Sale filter
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    Then I verify that search results page is displayed with newly searched products

  Scenario: Search any term apply filter and move to fusion PG and take back
    Given I log into eStore as "guest" user
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    When I apply In stock to Sale filter
    When I navigate to any estore fusion PG
    When I navigate back from "fusion PG" page
    Then I verify page with previous filter applied

  Scenario: Change the different grid and search the any product via search
    Given I log into eStore as "guest" user
    When I go to estore item "sofa" from search field
    When I change a grid view from default 3 grid view to 2 grid view
    When I go to estore item "sofa" from search field
    Then I verify that page is displayed with the previous grid selected

  Scenario: Navigation to PG pages from top menu
    Given I log into eStore as "guest" user
    When I navigate to PG page from top menu
    Then I verify that PG page is displayed with all the related products

  Scenario: Verify sale verbiage messages are present
    Given I log into eStore as "guest" user
    When I go to estore item "sofa" from search field
    Then I verify that sale verbiage message are present on PG page

  Scenario: Two grid and three grid views alignment
    Given I log into eStore as "guest" user
    When I go to estore item "sofa" from search field
    Then I verify alignment for two and three grid views

  Scenario: Change PG grid view, go to PDP, go back to PG. Application should render to the same view grid which was selected
    Given I log into eStore as "guest" user
    When I go to estore item "sofa" from search field
    When I change a grid view from default 3 grid view to 2 grid view
    When I navigate to any estore fusion PG
    When I navigate back from "PDP" page
    Then I verify that application render to the same view grid which was selected

  Scenario: Go to PDP, go back from PG, should redirect to the exact Product on PG
    Given I log into eStore as "guest" user
    When I go to estore item "sofa" from search field
    When I change a grid view from default 3 grid view to 2 grid view
    When I navigate to any estore fusion PG
    When I navigate back from "PDP" page
    Then I verify that redirected to the exact product on PG

  Scenario: Search option should work fine on fusion + ATG PGs.
    Given I log into eStore as "guest" user
    When I goes to "rhmodern" estore brand
    When I go to estore item "sofa" from search field
    Then I verify that PG page is displayed with all filter options

  Scenario: Change the different grid and search the turkish towel product via search
    Given I log into eStore as "guest" user
    When I go to estore item "sofa" from search field
    When I change a grid view from default 3 grid view to 2 grid view
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    Then I verify that search results page is displayed with newly searched products

  Scenario: Verify the title after navigating fusion PG
    Given I log into eStore as "guest" user
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    Then I verify that search results page is displayed with newly searched products






