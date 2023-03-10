@concierge-All
@concierge-EndToEnd
Feature:Concierge E2E flow

  Scenario: Verify that user is able to buy item
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    And I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    When I continue to payment
    When I execute payment for "VI"
    Then I verify that review screen is displayed
    When I click on a place order button

  Scenario: Verify that user is able to execute split payment using all payment methods
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    And I continue to payment
    When I introduces payment details for several payment methods
    When I click on a place order button
    Then I verify that confirmation order screen is displayed

  Scenario: Verify that if client is a member then redirected to carts screen
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I remove client from header
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Member"
    Then I verify that cart is displayed

  Scenario: Verify that if client is a non member then redirected to address screen
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    Then I verify that address screen is displayed

  Scenario Outline: Verify that user is able to buy item through search item by SKU id
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I remove client from header
    When I go to item "<skuID>" from search field
    And I select count of product
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    When I continue to payment
    When I execute payment for "AX"
    And I verify that review screen is displayed
    When I click on a place order button
    Then I verify that confirmation order screen is displayed
    Examples:
      | skuID    |
      | 63130001 |

  Scenario: Verify that user is able to add item to project and pay
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to project button
    When I choose project from addToProject popup
    When I click on add to cart button from project screen
    When I click on continue adding additional button
    When I choose order classification
    When I click on checkout button
    Then I click on no thanks button
    When I fill all fields from address screen
    When I continue to payment
    When I execute payment for "MC"
    And I verify that review screen is displayed

#  Scenario Outline: Verify that user is able to buy item from brand menu - <brands>
#    Given I log into Concierge as "associate"
#    When I remove all items from cart
#    When I remove client from header
#    When I choose "<brands>" from brand menu
#    When I clicks on a random menu item
#    When I click on collections item
#    When I clicks on o random item
#    When I fiils all options for item
#    And I select count of product
#    When I click on add to cart button
#    When I click on aggree&add button
#    When I click on view cart button
#    When I click on checkout button
#    When I click on no thanks button
#    When I choose client who is a "nonmember"
#    When I fill all fields from address screen
#    When I continue to payment
#    When I introduces payment details
#    And I verify that review screen is displayed
#    When I click on a place order button
#    Then I verify that confirmation order screen is displayed
#    Examples:
#      | brands         |
#      | RH Modern      |
#      | RH Baby&Child  |
#      | RH Teen        |
#      | RH Outdoor     |
#      | RH SKI House   |
#      | RH Beach House |
#      | RH Interiors   |



