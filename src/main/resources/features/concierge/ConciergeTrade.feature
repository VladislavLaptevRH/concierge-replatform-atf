@conciergeRegression
Feature:Concierge Trade

  Scenario: Trade Client - Non Exempt
    Given I log into Concierge as "associate"
    And I remove all items from cart
    And I go to item "10011392 SS" from search field
    And I select count of product
    And I click on add to cart button
    And I click on view cart button
    When I choose order classification
    And I click on checkout button
    And I click on no thanks button
    When I choose client who is a "trade"
    When I click on checkout button
    Then I verify that tax exempt checkbox is unchecked by default for trade client

  Scenario: Verify Trade Prices for PDP
    Given I log into Concierge as "associate"
    And I remove all items from cart
    And I go to item "10011389 SS" from search field
    And I select count of product
    And I click on add to cart button
    And I click on view cart button
    When I choose order classification
    And I click on checkout button
    And I click on no thanks button
    When I choose client who is a "trade"
    Then I verify trade prices for "PDP"

  Scenario: Verify Trade Prices for CP
    Given I log into Concierge as "associate"
    And I remove all items from cart
    And I go to item "10011389 SS" from search field
    And I select count of product
    And I click on add to cart button
    And I click on view cart button
    When I choose order classification
    And I click on checkout button
    And I click on no thanks button
    And I choose client who is a "trade"
    Then I verify trade prices for "PDP"

  Scenario: Verify Trade Prices for PG
    Given I log into Concierge as "associate"
    And I remove all items from cart
    When I choose contract gallery
    When I click on client button from header
    When I choose client who is a "trade"
    And I go to item "10011389 SS" from search field
    Then I verify trade prices for "PG"

  Scenario: Verify trade prices for project page
    Given I log into Concierge as "associate"
    When I click on projects button
    When I search project "TEST_TRADE_3MAR_1PM" by provided "projectName"
    When I click on the first project search result
    Then I verify trade prices for "project page"

  Scenario: Verify trade prices for order review page
    Given I log into Concierge as "associate"
    And I remove all items from cart
    And I go to item "68470071 SS" from search field
    And I click on add to cart button
    And I click on view cart button
    When I choose order classification
    And I click on checkout button
    And I click on no thanks button
    And I choose client who is a "trade"
    And I click on checkout button
    And I fill all fields for sold to address
    And I continue to payment
    And I choose POP for payment method

  Scenario: Address page: Sold-to, Billing, shipping address
    Given I log into Concierge as "associate"
    And I remove all items from cart
    And I go to item "68470071 SS" from search field
    And I click on add to cart button
    And I click on view cart button
    When I choose order classification
    And I click on checkout button
    And I click on no thanks button
    And I choose client who is a "trade"
    And I click on checkout button
    Then I verify sold-to, billing, shipping address on address page

  Scenario: Verify that Membership banner is not present on the cart page
    Given I log into Concierge as "associate"
    And I remove all items from cart
    And I go to item "68470071 SS" from search field
    And I click on add to cart button
    And I click on view cart button
    When I choose order classification
    And I click on checkout button
    And I click on no thanks button
    And I choose client who is a "trade"
    Then I verify membership banner for "trade" client not displayed

