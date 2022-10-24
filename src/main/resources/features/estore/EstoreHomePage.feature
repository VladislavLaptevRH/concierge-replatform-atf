@estoreRegression
@estoreHomePage
Feature: Estore Homepage

  Scenario: Verify search functionality
    Given I log into eStore as "regular"
    And I click on search Icon
    And I Type product name "Sofa"
    Then Verify users is taken to product page

  Scenario: Verify RH Brand Dropdown
    Given I log into eStore as "regular"
    When I click on RH dropdown
    Then I verify RH dropdown and list of brand names

  Scenario: Verify categories
    Given I log into eStore as "regular"
    Then I Verify list of Navigation bars

  Scenario: Verify Hamburger menu
    Given I log into eStore as "regular"
    When I click on Hamburger menu
    Then I verify list of items in hamburger menu

  Scenario: Verify CTA functionality
    Given I log into eStore as "regular"
    When I scroll down to Request a design consultation and click
    And I fill in the request form
    Then I Verify Thank you message




