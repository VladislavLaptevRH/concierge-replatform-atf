@regression
Feature: Verify e2e flow

  Scenario: Verify that user is able to buy item
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I clicks on a random menu item
    When I click on collections item
    When I clicks on o random item
    When I select debth option
    When I select fabric option
    When I select color option
    And I select count of product
    When I click on add to cart button
    When I click on aggree&add button
    When I click on view cart button
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "non member"
    When I fill all fields from address screen
    When I continue to payment
    When I introduces payment details
    And I verify that review screen is displayed
    When I click on a place order button
    Then I verify that confirmation order screen is displayed

  Scenario: Verify that user is able to execute split payment using all payment methods
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "prod19250012" from search field
    And I select count of product
    When I click on add to cart button
    When I click on view cart button
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "non member"
    When I fill all fields from address screen
    And I continue to payment
    When I introduces payment details for several payment methods
    When I click on a place order button
    Then I verify that confirmation order screen is displayed

  Scenario: Verify that if client is a member then redirected to carts screen
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "prod17860058" from search field
    And I select count of product
    When I click on add to cart button
    When I click on view cart button
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "member"
    Then I verify that cart is displayed

  Scenario: Verify that if client is a non member then redirected to address screen
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "prod17860061" from search field
    And I select count of product
    When I click on add to cart button
    When I click on view cart button
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    Then I verify that address screen is displayed

  Scenario Outline: Verify that user is able to buy item through search item by SKU id
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "<skuID>" from search field
    And I select count of product
    When I click on add to cart button
    When I click on view cart button
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    When I fill all fields from address screen
    When I continue to payment
    When I introduces payment details
    And I verify that review screen is displayed
    When I click on a place order button
    Then I verify that confirmation order screen is displayed
    Examples:
      | skuID    |
      | 10010969 |
#
  Scenario: Verify that user is able to add item to project and pay
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I go to item "10010966" from search field
    And I select count of product
    When I click on add to project button
    When I click on add to cart button from project screen
    When I click on view cart button
    When I click on checkout button
    Then I click on no thanks button
    When I choose client who is a "nonmember"
    When I fill all fields from address screen
    When I continue to payment
    When I introduces payment details
    And I verify that review screen is displayed
#
#  Scenario Outline: Verify that user is able to buy item from brand menu - <brands>
#    Given I log into Concierge as "associate"
#    When I remove all items from cart
#    When I remove client from header
#    When I choose "<brands>" from brand menu
#    When I clicks on a random menu item
#    When I click on collections item
#    When I clicks on o random item
#    And I select count of product
#    When I select debth option
#    When I select fabric option
##    When I select color option
#    When I click on add to cart button
#    When I click on checkout button
#    When I fill all fields from address screen
#    When I continue to payment
#    When I introduces payment details
#    And I verify that review screen is displayed
#    When I click on a place order button
#    Then I verify that confirmation order screen is displayed
#    Examples:
#      | brands         |
##      | RH Modern      |
#      | RH Baby&Child  |
#      | RH Teen        |
#      | RH Outdoor     |
#      | RH SKI House   |
#      | RH Beach House |
#      | RH Interiors   |

  Scenario Outline: Verify <state> shipping restriction
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item which has "<state>" restriction
    When I fill all options for item
    When I click on add to cart button
    When I click on aggree&add button
    When I click on view cart button
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "non member"
    When I fill all fields from address with "<state>" zip code
    Then I verify that restrictions pop up is displayed
    Examples:
      | state |
      | NY    |
      | CA    |


