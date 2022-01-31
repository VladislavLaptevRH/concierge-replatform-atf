Feature: Verify e2e flow

  Scenario: Verify that user is able to buy item
    Given I log into Concierge as "associate"
    When I choose client from header
    When I clicks on a random menu item
    When I clicks on o random item
    When I fill all options for item
    When I click on add to cart button
    When I click on checkout button
    When I fill all fields from address screen
    When I click on continue to payment button
    And I verify that review screen is displayed
    When I click on a place order button
    Then I verify that confirmation order screen is displayed

  Scenario: Verify that user is able to add item to project and pay
    Given I log into Concierge as "associate"
    When I choose client from header
    When I clicks on a random menu item
    When I clicks on o random item
    When I fill all options for item
    When I click on add to project button
    When I click on go to project button
    When I click on add to cart button from project screen
    When I click on checkout button
    When I fill all fields from address screen
    When I click on continue to payment button
    And I verify that review screen is displayed
    When I click on a place order button
    Then I verify that confirmation order screen is displayed

  Scenario: Verify that user is able to buy item from brands menu
    Given I log into Concierge as "associate"
    When I choose client from header
    When I choose random brand from menu
    When I clicks on a random menu item for brands
    When I clicks on o random item
    When I fill all options for item
    When I click on add to cart button
    When I click on checkout button
    When I fill all fields from address screen
    When I click on continue to payment button
    And I verify that review screen is displayed
    When I click on a place order button
    Then I verify that confirmation order screen is displayed


