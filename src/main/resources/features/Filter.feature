@rhnonprodFilter
Feature: Filter

  Scenario Outline: Verify filter for provided search term - <searchterm>
    Given I search "<searchterm>" in search field from header
    When I click on brands
    Then I verify that brands are displayed
    When I click on in stock
    Then I verify that in stock is displayed
    When I click on color
    Then I verify that all colors are displayed
    When I click on sort button
    Then I verify that sort options are displayed
    Examples:
      | searchterm         |
      | All media consoles |
      | Glass Media        |
      | Closed Media       |
      | Open Media         |
      | Media Systems      |

  Scenario: Verify place order
    Given I log into stgrhnonprod
    When I go to item using "prod2820287"
    When I add item to cart
