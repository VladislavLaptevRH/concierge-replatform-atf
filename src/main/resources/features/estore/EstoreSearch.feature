@estoreRegression
@estoreSearch
Feature: Estore Search

  Scenario: Search product via Product name
    Given I log into eStore as "regular"
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    Then I verify that search result for search product via product name is displayed

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
    Then I verify that search results for "" is displayed

  Scenario: Verify the prices for searched term

