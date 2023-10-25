@estoreParallelTestRun
Feature: Estore Homepage

  Scenario Outline: Verify search functionality
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    And I click on search Icon
    And I Type product name "<productname>"
    Then verify users is taken to search result page
    Examples:
      | productname |
      | towels      |
      | sofa        |
      | tables      |

  Scenario: Verify RH Brand Dropdown
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on RH dropdown
    Then I verify RH dropdown and list of brand names

  Scenario: Verify categories
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then I Verify list of Navigation bars

  Scenario: Verify Hamburger menu
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on Hamburger menu
    Then I verify list of items in hamburger menu

  Scenario: Verify the hamburger icon on the homepage
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then I verify that hamburger icon is displayed for the main menu

  Scenario Outline: Verify the search
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    And I click on search Icon
    When I change the brand to "<brand>" for eStore
    And I Type product name "<productname>"
    Then verify users is taken to search result page
    Examples:
      | productname | brand           |
      | towels      | RH              |
      | towels      | RH CONTEMPORARY |
      | towels      | RH MODERN       |
      | towels      | RH OUTDOOR      |
      | towels      | RH BEACH HOUSE  |
      | towels      | RH SKI HOUSE    |
      | towels      | RH TEEN         |
      | towels      | RH BABY & CHILD |

  Scenario: Verify the cart icon on the home page and do not have the item
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then I verify that cart page icon is displayed

  Scenario: Verify the cart icon on the home page and have the item/s count next to the mini cart icon.
    Given I log into eStore as "cartIconOnTheHomePage" user
    When I choose country for eStore from footer
    When I add item to cart via API for estore
    When I open estore cart
    Then I verify that cart page icon is displayed
    And  I verify that cart page icon have the item count next to the mini cart icon

  Scenario: Verify the my account icon
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then I verify that my account icon is displayed

#  Scenario: Validate Each Category And Sub-Category for eStore
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    Then I validate each cat and sub-cat for eStore




