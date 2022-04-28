@conciergeRegression
Feature: Print

  Scenario: Print PDF - PDP
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "10010966" from search field
    When I click on print combinations buttons
    Then I verify that print pop up is displayed

  Scenario: Print PDF - CART
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "10010966" from search field
    When I click on add to cart button
    When I click on view cart button
    When I click on print combinations buttons
    Then I verify that print pop up is displayed

  Scenario: Print PDF - Order review
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "10010966" from search field
    When I click on add to cart button
    When I click on view cart button

