@estoreTestRun

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

  Scenario: Verify CTA functionality
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I scroll down to Request a design consultation and click
    And I fill in the request form
    Then I Verify Thank you message

#  Scenario: Validate Each Category And Sub-Category for eStore
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    Then I validate each cat and sub-cat for eStore




