@estoreRegression
Feature: Estore E2E flow

  Scenario: Verify that user is able to buy item for estore
    Given I log into eStore as "regular"
#    When I remove all items from estore cart
    When I clicks on a random estore menu item
    When I click on estore collections item
    When I clicks on estore random item
    When I select estore debth option
    When I select estore fabric option
    When I select estore length option
    When I select estore color option
    When I click on add to cart estore button
    When I click on aggree&add estore button
    And I click on view cart estore button
    When I click on estore checkout button
#    When I choose estore order classification
    And I click on estore no thanks button
#    When I choose estore client who is a "nonmember"
#    When I fill all fields from estore address screen
#    When I click on same as shipping address checkbox
    When I continue to estore payment
#    And I introduces payment details for estore
#    Then I verify that estore review screen is displayed
    When I click on continue payment method estore button
    When I click on a place estore order button
    Then I verify that thank you page is displayed

  Scenario: Verify that user is able to execute split payment using all payment methods
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I go to item "10011392 SS" from search field
    And I select count of estore product
    When I click on add to cart estore button
    When I click on view cart estore button
    When I click on estore checkout button
    When I click on estore no thanks button
    When I choose estore client who is a "nonmember"
    When I fill all fields from estore address screen
    And I continue to estore payment
    When I introduces payment details for estore several payment methods
    When I click on a place estore order button
    Then I verify that confirmation estore order screen is displayed

  Scenario: Verify that if client is a member then redirected to carts screen
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I go to item "10001414 PEWT" from search field
    And I select count of estore product
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "member"
    Then I verify that cart is displayed

  Scenario: Verify that if client is a non member then redirected to address screen
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I go to item "68260005 BULB" from search field
    And I select count of product
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    Then I verify that address screen is displayed

  Scenario Outline: Verify that user is able to buy item through search item by SKU id
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I go to item "<skuID>" from search field
    And I select count of product
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
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
#  Scenario: Verify that user is able to add item to project and pay
#    Given I log into Concierge as "associate"
#    When I remove all items from cart
#    When I go to item "10035329 GRY" from search field
#    And I select count of product
#    When I click on add to project button
#    When I choose project from addToProject popup
#    When I click on add to cart button from project screen
#    When I choose order classification
#    When I click on checkout button
#    Then I click on no thanks button
#    When I fill all fields from address screen
#    When I continue to payment
#    When I introduces payment details
#    And I verify that review screen is displayed
#
##  Scenario Outline: Verify that user is able to buy item from brand menu - <brands>
##    Given I log into Concierge as "associate"
##    When I remove all items from cart
##    When I remove client from header
##    When I choose "<brands>" from brand menu
##    When I clicks on a random menu item
##    When I click on collections item
##    When I clicks on o random item
##    When I fiils all options for item
##    And I select count of product
##    When I click on add to cart button
##    When I click on aggree&add button
##    When I click on view cart button
##    When I click on checkout button
##    When I click on no thanks button
##    When I choose client who is a "nonmember"
##    When I fill all fields from address screen
##    When I continue to payment
##    When I introduces payment details
##    And I verify that review screen is displayed
##    When I click on a place order button
##    Then I verify that confirmation order screen is displayed
##    Examples:
##      | brands         |
##      | RH Modern      |
##      | RH Baby&Child  |
##      | RH Teen        |
##      | RH Outdoor     |
##      | RH SKI House   |
##      | RH Beach House |
##      | RH Interiors   |
#
#
#
