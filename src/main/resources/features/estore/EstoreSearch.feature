@estoreRegression
@estoreSearch
Feature: Estore Search

  Scenario: Search after opening hamburger menu
    Given I log into eStore as "regular"
    When I click on hamburger menu for estore
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    Then I verify that search result for search product via product name is displayed

  Scenario: Search product via Product name
    Given I log into eStore as "regular"
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    Then I verify that search result for search product via product name is displayed

  Scenario: Search product via SKU 10115260 VLBZ
    Given I log into eStore as "regular"
    When I go to estore item "17050044 CHAR" from search field
    Then I verify that search result "Cortona Sofa" for search product via sku id is displayed

  Scenario: To verify search for random text
    Given I log into eStore as "regular"
    When I introduced random text for search field
    Then I verify that we cannot find what you are looking message is not displayed

  Scenario: Verify count of search result and product
    Given I log into eStore as "regular"
    When I go to estore item "towels" from search field
    Then I verify count of search results

  Scenario: Verify the Back to top button
    Given I log into eStore as "regular"
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    When I scroll to the bottom of the estore page
    When I click on estore back to top button

  Scenario: Verify the search results with multiple terms search: white and blue corner leather sofa
    Given I log into eStore as "regular"
    When I go to estore item "white and blue corner leather sofa" from search field
    Then I verify that search results for "white and blue corner leather sofa" is displayed

  Scenario: Place order: search with any key term, select Low to High. navigate to first product PDP
    Given I log into eStore as "regular"
    When I go to estore item "white" from search field
    When I select low to high for estore
    When I navigate for the first product PDP

  Scenario: Place order: search with any key term, select high to low. navigate to first product PDP
    Given I log into eStore as "regular"
    When I go to estore item "white and blue corner leather sofa" from search field
    When I select high to low for estore
    When I navigate for the first product PDP

  Scenario: Pricing on search result page(US and CAN)
    Given I log into eStore as "regular"
    When I go to estore item "white and blue corner leather sofa" from search field
    Then I verify pricing on search result page

  Scenario: Back button test cases
    Given I log into eStore as "regular"
    When I go to estore item "white and blue corner leather sofa" from search field
    When I navigate for the first product PDP
    Then I verify that I'm able to use back button

  Scenario: Search any product from CG and verify for back button
    Given I log into eStore as "regular"
    When I go to estore item "SOFAS" from search field
    Then I verify that I'm able to use back button from CG

  Scenario: Search any product from cart page and verify for back button
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I verify for back button from cart page

  Scenario Outline: Verify the 1,2 and 3 grid
    Given I log into eStore as "regular"
    When I go to estore item "white and blue corner leather sofa" from search field
    Then I verify the "<gridNumber>"
    Examples:
      | gridNumber |
      | 1          |
      | 2          |
      | 3          |








