@estoreRegression
@estoreCartPage
Feature: Estore Cart Page

  Scenario: Remove item from cart
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I click on remove button from estore cart page
    Then I verify that item from estore cart has been removed

  Scenario: Apply/Remove employee discount
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I remove promotion from estore cart
    When I apply employee discount for estore
    Then I verify that I'm able to remove estore employee discount

  Scenario: Apply/Remove promotion code
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I remove promotion from estore cart
    Then I verify that I'm able to apply promotion code
    When I remove promotion from estore cart

  Scenario: Zip code validation in cart
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I click on zipcode estore button
    Then I verify US zip code validation in estore cart
    And I verify CA zip code validation in estore cart

  Scenario: eStore - Membership price in cart
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    Then I verify membership price in banner

  Scenario: eStore - Line item quantity update
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I choose qty for item from estore cart
    Then I verify that estore line item price should be update according to user selected qty
    And I verify that subtotal should be updated according to quantity selected

  Scenario: Place order for guest user
    Given I remove all items from estore cart
    When I open product page with "prod13800635" and "17050045" with "WHT" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    When I click on estore no thanks button
    When I click on continue as guest estore button
    When I fill estore shipping address
    When I fill estore shipping email address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    And I introduces payment details for estore
    When I click on continue payment method estore button
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

  Scenario: eStore - Add UFD item to Cart
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I add item "63130001 NATL"  and prod id "prod1617188" to cart via API for estore
    When I open estore cart
    When I click on zipcode estore button
    When I update postal code in cart
    Then I verify UFD in cart

  Scenario: eStore - Add Surcharge item to Cart
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I add item "63130001 NATL"  and prod id "prod1617188" to cart via API for estore
    When I open estore cart
    When I click on zipcode estore button
    When I update postal code in cart
    Then I verify SURCHARGE fee on cart page

  Scenario: eStore - Gift Box fee in cart
    Given I log into eStore as "regular"
    When I add item to cart via API for estore
    When I open estore cart
#    When I click on zipcode estore button
#    When I update postal code in cart
#    When I click on gift box button
#    Then I verify gift box fee in estore cart

  Scenario: eStore - Membership price for US and CAN
    Given I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
#    When I click on join the rh members program from footer
#    When I click on join now membership button
#    When I click on zipcode estore button
#    When I update "US" postal code in cart
#    Then I verify order estimate section in cart
#    When I click on "US" postal code in cart
#    When I update "CA" postal code in cart
#    Then I verify order estimate section in cart

  Scenario: eStore - Membership pop up for guest user
    Given I remove all items from estore cart
    When I open product page with "prod13800635" and "17050045" with "WHT" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    Then I verify membership popup for guest user

  Scenario: eStore - CAN Shipping restriction
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on estore no thanks button
    When I click on same as estore shipping address checkbox
    Then I verify "CAN" shipping restriction

  Scenario: eStore - New York Shipping restriction
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I open product page with "rhbc_prod962216" and "112414" with "OCEN%20BUMP" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    When I click on estore no thanks button
    When I fill estore shipping address for "NY"
    When I click on edit estore billing address button
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    Then I verify "NY" shipping restriction

  Scenario: eStore - Disable Continue as a Guest user option for guest user with membership
    When I open product page with "prod13800635" and "17050045" with "WHT" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on join now on estore cart page membership button
    When I click on estore checkout button
    Then I verify that continue as guest user option is not available

  Scenario: eStore Add products from all brands to cart
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    Then I verify that I'm able to add products from all brands to cart

  Scenario: eStore Membership banner for member user
    Given I log into eStore as "member"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    Then I verify membership estore banner for "member user"

  Scenario: eStore Membership banner for non-member user
    Given I log into eStore as "regular"
    When I add item to cart via API for estore
    When I open estore cart
    Then I verify membership estore banner for "nonmember user"

  Scenario: eStore Cart persistence in all brands
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    Then I verify that the added product is in the cart during brand switching

  Scenario: Verify the cart subtotal when regular user added membership card with other sku's.
  Member prices should be applicable
    Given I log into eStore as "regularAddMembership"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on remove membership estore button
    When I click on join now membership button
    Then I verify that "member" prices for "17050042WHT" was applied
    When I click on remove membership estore button
    Then I verify that "regular" prices for "17050042WHT" was applied

  Scenario: Verify state field Empty dropdown issue for International billing address
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I click on estore checkout button
    When I click on estore no thanks button
    When I fill estore shipping address
    When I choose estore empty state
    When I click on continue payment method estore button
    Then I verify state field empty dropdown issue for International billing address

  Scenario: Verify the standard delivery charges  (Free & applicable charges)
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore

  Scenario: Add Membership and verify order total in order estimate
    Given I log into eStore as "regularAddMembership"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I click on join now membership button
    Then I verify estore order total in order estimate for membership for "42100241 GREY"
    When I click on remove membership estore button

  Scenario: Verify the standard delivery charges (Free & applicable charges)
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    Then I verify the standard delivery charges for estore
