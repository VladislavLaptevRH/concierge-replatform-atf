@estoreTestRun
@estoreCart

Feature: Estore Cart Page

  Scenario: Remove item from cart
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I click on remove button from estore cart page
    Then I verify that item from estore cart has been removed

  Scenario: Apply/Remove employee discount
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I remove promotion from estore cart
    When I apply employee discount for estore
    Then I verify that I'm able to remove estore employee discount

  Scenario: Apply/Remove promotion code
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I remove promotion from estore cart
    Then I verify that I'm able to apply promotion code
    When I remove promotion from estore cart

  Scenario: Zip code validation in cart
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I click on zipcode estore button
    Then I verify US zip code validation in estore cart
    And I verify CA zip code validation in estore cart

  Scenario: eStore - Membership price in cart
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    Then I verify membership price in banner

  Scenario: eStore - Line item quantity update
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I choose qty for item from estore cart
    Then I verify that estore line item price should be update according to user selected qty
    And I verify that subtotal should be updated according to quantity selected

  Scenario: Place order for guest user
    Given I remove all items from estore cart
    When I choose country for eStore from footer
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
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
    And I introduces payment details for estore guest user for cart
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

  Scenario: eStore - Add UFD item to Cart
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add product "prod1617188" and sku "63130001 NATL" to cart via API for estore
    When I open estore cart
    Then I verify UFD in cart

  Scenario: eStore - Verify the Surcharge for Large furniture items
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add product "prod1617188" and sku "61690405 BRWN" to cart via API for estore
    When I open estore cart
    When I click on zipcode estore button
    When I update postal code in cart
    Then I verify SURCHARGE fee on cart page

  Scenario: eStore - Membership price for US and CAN
    Given I log into eStore as "member" user
    When I remove all items from estore cart
    When I choose country for eStore from footer
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I click on zipcode estore button
    When I update "US" postal code in cart
    Then I verify order estimate section in cart
    When I click on "US" postal code in cart
    When I update "CA" postal code in cart
    Then I verify order estimate section in cart

  Scenario: eStore - Membership pop up for guest user
    Given I remove all items from estore cart
    When I choose country for eStore from footer
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    Then I verify membership popup for guest user

  Scenario: eStore - CAN Shipping restriction
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I choose "CAN" country from footer
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address for CAN
    Then I verify "CAN" shipping restriction

  Scenario: eStore - New York Shipping restriction
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with NY restriction item
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
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on join now on estore cart page membership button
    When I click on estore checkout button
    Then I verify that continue as guest user option is not available

  Scenario: eStore Add products from all brands to cart
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    Then I verify that I'm able to add products from all brands to cart

  Scenario: eStore Membership banner for member user
    Given I log into eStore as "member" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    Then I verify membership estore banner for "member user"

  Scenario: eStore Membership banner for non-member user
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    Then I verify membership estore banner for "nonmember user"

  Scenario: eStore Cart persistence in all brands
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    Then I verify that the added product is in the cart during brand switching

  Scenario: Verify the cart subtotal when regular user added membership card with other sku's.
  Member prices should be applicable
    Given I log into eStore as "regularAddMembership" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on remove membership estore button
    When I click on join now membership button
    Then I verify that "member" prices for "17050042WHT" was applied
    When I click on remove membership estore button
    Then I verify that "regular" prices for "17050042WHT" was applied

  Scenario: Verify state field Empty dropdown issue for International billing address
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
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
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore

  Scenario: Add Membership and verify order total in order estimate
    Given I log into eStore as "regularAddMembership" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I click on join now membership button
    Then I verify estore order total in order estimate for membership for "42100241 GREY"
    When I click on remove membership estore button

  Scenario: Verify the standard delivery charges (Free & applicable charges 2 to 3 applicable charges)
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    Then I verify free delivery charges for estore in cart
    And I verify applicable charges 2 to 3 days for estore in cart

  Scenario: Verify the standard delivery charges (Applicable charges 1 to 2 applicable charges)
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    Then I verify applicable charges 1 to 2 days for estore in cart

  Scenario: Verify the UFD charges for furniture
    Given I remove all items from estore cart
    When I choose country for eStore from footer
    When I open product page with "prod6490263" and "50400761" with "BWBK" for estore
    When I click on add to cart estore button
    When I click on aggree&add estore button
    And I click on view cart estore button
    Then I verify that Unlimited Furniture Delivery message is displayed
    And I verify that amount for UFD was added to total price

  Scenario: Verify Membership Prices for Membership registered user for line items - discount verbiage line in summary
    Given I log into eStore as "member" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that rh member savings on this order message and amount is displayed
    And I verify that total line price is equal to price for member

  Scenario: Verify Promo code Discount applied for CART, order review and Order confirmation
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I remove promotion from estore cart
    Then I verify that I'm able to apply promotion code
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    Then I verify that Total Additional Product Discount message is displayed on order review page
    When I click on a place estore order button
    When I click on order details button
    And I verify that Total Additional Product Discount message is displayed on order review page

  Scenario: Verify Employee Discount applied for CART, order review and Order confirmation
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I remove promotion from estore cart
    When I apply employee discount for estore
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    Then I verify that Total Additional Product Discount message is displayed on order review page
    When I click on a place estore order button
    When I click on order details button
    And I verify that Total Additional Product Discount message is displayed on order review page

  Scenario: Verify Regular client address page - ship to and Bill to addresses - edit addresses functionality
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I click on edit estore billing address button on payment page
    When I click on edit billing adress button on address page
    When I introduce new billing address on address page
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    Then I verify that new billing address is displayed on payment page

  Scenario: Verify the qty updates and pricing update for line item and Summary
    Given I log into eStore as "nonmember" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod25280089" and "17050044" with "JNPR" for estore
    When I update item quantity in estore pdp
    When I click on add to cart estore button
    When I click on view cart estore button
    Then that was added "2" quantity of item in cart
    And I verify the total price for product in the cart
    When I change item quantity to "1" for "prod19500002" and "17050045" with "NCKL" for estore
    And I verify the total price for product in the cart

  Scenario: Verify new account creation during checkout
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod25280089" and "17050044" with "JNPR" for estore
    Then I chose the '1' line item selections one by one
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    When I click on estore no thanks button
    When I click on register button for eStore
    When I introduces the required details
    When I click on agree privacy policy checkbox
    When I click on create account button from form
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

  Scenario Outline:  Add the products from all the brands and verify the cart
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then  I change the brand to "<brand>" for eStore
    When I go to estore item "17050044 EUCY" from search field
    When I click on add to cart estore button
    When I click on view cart estore button
    Then I verify the standard delivery charges for estore
    And I verify the total price for product in the cart
    Examples:
      | brand           |
      | RH              |
      | RH CONTEMPORARY |
      | RH INTERIORS    |
      | RH MODERN       |
      | RH OUTDOOR      |
      | RH BEACH HOUSE  |
      | RH SKI HOUSE    |
      | RH TEEN         |
      | RH BABY & CHILD |

  Scenario: Remove Membership and verify order total in order estimate
    Given I log into eStore as "regularAddMembership" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I click on join now membership button
    Then I verify estore order total in order estimate for membership for "42100241 GREY"
    When I click on remove membership estore button
    And I verify estore order total in order estimate without membership

  Scenario: Verify without adding membership for guest user and should get continue as guest option after checkout
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    When I click on estore no thanks button
    Then I click on continue as guest estore button

  Scenario: Gift cards on all brands
    Given I log into eStore as trade
    When I choose country for eStore from footer
    Then  I change the brand to "<brand>" for eStore
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address for contract&trade
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I choose "RH Gift Card" from payment method
    When I click on check balance button
    Then I verify that gift card balance info is displayed for estore
    Examples:
      | brand           |
      | RH              |
      | RH CONTEMPORARY |
      | RH INTERIORS    |
      | RH MODERN       |
      | RH OUTDOOR      |
      | RH BEACH HOUSE  |
      | RH SKI HOUSE    |
      | RH TEEN         |
      | RH BABY & CHILD |

  Scenario: Verify starting at regular/member pricing per unit and total based on qty
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod18510007" and "17050044" with "NATL" for estore
    When I update item quantity in estore pdp
    When I click on add to cart estore button
    When I click on view cart estore button
    Then that was added "2" quantity of item in cart
    And I verify the total price for product in the cart

  Scenario: Verify the membership fee - US and CAN fee
    Given I log into eStore as "joinmembershipbanner" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on join now membership button
    Then I verify order estimate section in cart
    When I click on remove membership estore button

  Scenario: Verify the User logged and the cart persist across brands - registered
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    Then I verify that the added product is in the cart during brand switching

  Scenario: Verify the Mattress fee based on number of mattress lines in cart (CA, CT, RI) [06902, 02801, 94925]
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I open product page with "prod30680006" and "10179338" with "NONE" for estore
    When I introduce "06902" postal code for "US" on pdp page
    When I click on add to cart estore button
    When I click on aggree&add estore button
    When I click on view cart estore button
    Then I verify mattress fees should reflect

  Scenario: Grouping: Product: bed & mattress with different dates: Groupping options should be displayed
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod22300369" and "10075200" with "PSDV" for estore
    When I click on add to cart estore button
    When I click on aggree&add estore button
    When I open product page with "prod30680006" and "10179338" with "NONE" for estore
    When I click on add to cart estore button
    When I click on aggree&add estore button
    When I click on view cart button
    Then I verify that the grouping options are displayed after the line items

  Scenario: Verify the BO item - availability and return message
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I open product page with "prod12740400" and "47400990" with "NATL" for estore
    When I click on add to cart estore button
    When I click on view cart estore button
    Then I verify that user is able to see availability and return message

  Scenario: Verify the SPO item - availability and return message, terms of sale msg
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I open product page with "prod15050004" and "59810769" with "BMEB" for estore
    When I click on add to cart estore button
    When I click on aggree&add estore button
    When I click on view cart estore button
    Then I verify SPO item - availability and return message

  Scenario:  Verify the instock item - availability and return message
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that user is able to see availability and return message


