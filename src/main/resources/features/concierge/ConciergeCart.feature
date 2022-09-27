@conciergeRegression
Feature:Concierge Cart Page

  Scenario: Order Classification
    Given I log into Concierge as "associate"
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    Then I verify order classification

  Scenario: Checkout membership popup for Guest user
    Given I log into Concierge as "associate"
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    Then I verify membership popup for guest user

  Scenario: Line Item : Quantity update
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I click on quantity line item button
    Then I verify that quantity was updated

  Scenario:Remove line item - click on remove button and verify that line item is removed and subtotal and minicart value is updated
    Given I log into Concierge as "associate"
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I remove all items from cart
    Then I verify that line item was removed

  Scenario Outline: Override Line item Prices - with <method> override price methods
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I click on cart button from header
    When I click on total item line price
    When I select price override "<method>"
    When I introduces value for override price
    When I choose reason code for price override
    When I click on apply uppercase button for "override line item"
    Then I verify line items prices for "<method>"
    Examples:
      | method          |
      | PERCENT_OFF     |
      | AMOUNT_OFF      |
      | AMOUNT_OVERRIDE |

  Scenario: Override Line item Prices - for all line items from cart
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I click on total item line price
    When I select price override "PERCENT_OFF"
    When I introduces value for override price
    When I choose reason code for price override
    When I click on apply all checkbox
    When I click on apply uppercase button for "override line item"
    Then I verify line items prices for "PERCENT_OFF"

  Scenario:Override Line item Prices - verify update button, verify remove button
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I click on total item line price
    When I select price override "PERCENT_OFF"
    When I introduces value for override price
    When I choose reason code for price override
    When I click on apply uppercase button for "override line item"
    Then I verify line items prices for "PERCENT_OFF"
    When I click on total item line price
    When I select price override "AMOUNT_OVERRIDE"
    When I introduces value for override price
    When I click on update button from price override pop up
    Then I verify line items prices for "AMOUNT_OVERRIDE"

  Scenario:Override Line item Prices - verify remove button
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I click on total item line price
    When I select price override "PERCENT_OFF"
    When I introduces value for override price
    When I choose reason code for price override
    When I click on apply uppercase button for "override line item"
    Then I verify line items prices for "PERCENT_OFF"
    When I click on total item line price
    When I click on remove button from price override
    Then I verify that price override was removed

  Scenario:Shipping Override (SD, UFD) -  i can introduce only zero in unlimited furniture delivery field, verify that error should be appeared -> Value must be 0.
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I click on UFD button from cart

  Scenario: FEMA Promotion Code Description  - FEMAD
    Given I log into Concierge as "associate"
    And I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I introduces promo code "FEMAD" for promo codes field
    When I click on apply promocode button
    Then I verify that "FEMAD" promocode was approved for cart items
    And I remove promotion from cart

  Scenario: Move to Project
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I click on move to project button
    When I click on save button
    Then I verify that projects screen is displayed

  Scenario: Promo codes - promo code for guest user
    Given I log into Concierge as "associate"
    And I remove all items from cart
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I introduces promo code "HM4TS97" for promo codes field
    When I click on apply promocode button
    Then I verify that "HM4TS97" promocode was approved for cart items
    And I remove promotion from cart

  Scenario: Designed/ Sold By
    Given I log into Concierge as "associate"
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    Then I verify that designed sold by

  Scenario: Promo codes - verify that total price from cart and from payment page is the same after applying promocode
    Given I log into Concierge as "associate"
    And I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I introduces promo code "FEMAD" for promo codes field
    When I click on apply promocode button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    When I fill all fields from address screen
    When I continue to payment
    Then I verify that total price from cart and from payment page is the same

  Scenario:Promo codes - verify that total price from cart and from payment page is the same after applying promo code
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I introduces promo code "FEMAD" for promo codes field
    When I click on apply promocode button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    When I fill all fields from address screen
    When I continue to payment
    When I choose POP for payment method
    Then I verify that Total Additional Product Discount message is "displayed" on review page

  Scenario:Promo codes - verify that promo code was removed for member client
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I introduces promo code "FEMAD" for promo codes field
    When I click on apply promocode button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "member"
    Then I verify that promo code was removed

  Scenario:Verify mini cart count
    Given I log into Concierge as "associate"
    When I remove all items from cart for minicart
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    Then I verify that mini cart value is equal to 1
    When I click on quantity line item button
    Then I verify that mini cart value is equal to quantity of product

  Scenario Outline: Verify Membership banner for <businessClient> - should not be present
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "<businessClient>"
    Then I verify membership banner for "<businessClient>" client not displayed
    Examples:
      | businessClient       |
      | trade                |
      | unclassifiedBusiness |

  Scenario: Verify Membership Pop up while checkout for Trade - should not
    Given I log into Concierge as "associate"
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "trade"
    Then I verify membership banner for "trade" client not displayed
    When I click on checkout button
    Then I verify that membership popup for "trade" is not displayed

  Scenario: Verify Membership Pop up while checkout for contract - should not be present
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I choose contract gallery
    When I click on client button from header
    When I look on client by "accountnumber" with "20211221164476"
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    Then I verify that membership popup for "contract client" is not displayed

  Scenario Outline: Verify Trade,Contract client address page - ship to Bill to, Sold to addresses - edit addresses
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I look on client by "accountnumber" with "<businessClient>"
    When I click on checkout button
    Then I verify that ship to, bill to, sold to addresses are displayed
    And I edit ship to, bill to, sold to addresses
    When I continue to payment
    Examples:
      | businessClient |
      | 20211221164474 |
#      | 20211221164476 |

  Scenario: Verify membership prices for Membership client
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "member"
    Then I verify that membership price displayed as total price

  Scenario: Verify Employee discount checkout
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I apply employee discount
    Then I verify that employee discount is present

  Scenario: Postpone shipment
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I choose postpone shipment
    When I click on apply uppercase button for "postpone shipment"
    Then I verify that postpone shipment was applied

  Scenario: Monogram Edit / Remove / Add
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with productId "prod19500002"
    When I select size option 2 for item
    When I select color option
    When I click on add to cart button
    When I click on view cart button
    When I click on add monogram checkbox
    When I choose monogram properties
    Then I verify that monogram was added
    When I edit monogram
    Then I verify that monogram was edited
    When I remove monogram
    Then I verify that monogram was removed

  Scenario: Gift Box Add / Remove / View
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with productId "prod19500002"
    When I select size option 2 for item
    When I select color option
    When I click on add to cart button
    When I click on view cart button
    When I click on gift box button
    Then I verify that gift box was added
    When I click on gift box button
    Then I verify that gift box was removed

  Scenario: Verify Member savings for a Non member user in cart - From PDP and Project
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    When I click on cart button from header
    #Then I verify "nonmember" savings for a "nonmember" user

  Scenario: Verify Trade savings for a Trade user in cart - From PDP and Project
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "trade"
    Then I verify "trade" savings for a "trade" user

#  Scenario: Verify CAN shipping restriction
#    Given I log into Concierge as "associate"
#    When I remove all items from cart
#    When I remove client from header
#    When I open product page with productId "prod25150082"
#    When I select debth option
#    When I select fabric option
#    When I select length option
#    When I select color option
#    When I click on add to cart button
#    When I click on aggree&add button
#    When I click on view cart button
#    When I choose order classification
#    When I click on checkout button
#    When I click on no thanks button
#    When I choose client who is a "nonmember"
#    When I fill all fields from address with "CA" zip code
#    Then I verify that restrictions pop up is displayed

#  Scenario: Verify NY shipping restriction
#    Given I log into Concierge as "associate"
#    When I remove all items from cart
#    When I remove client from header
#    When I open product page with productId "prod25150082"
#    When I select debth option
#    When I select fabric option
#    When I select length option
#    When I select color option
#    When I click on add to cart button
#    When I click on aggree&add button
#    When I click on view cart button
#    When I choose order classification
#    When I click on checkout button
#    When I click on no thanks button
#    When I choose client who is a "nonmember"
#    When I fill all fields from address with "NY" zip code
#    Then I verify that restrictions pop up is displayed

  Scenario: Verify Member savings for a member user in cart - From PDP and Project
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "member"
    Then I verify "member" savings for a "member" user

  Scenario: Verify address saved in address page when navigate back from order review or any page
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on aggree&add button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    When I fill all fields from address screen
    When I continue to payment
    When I choose POP for payment method
    And I verify that review screen is displayed
    When I goes to address page from review screen
    Then I verify that address saved in address page

  Scenario: Zipcode Validation
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
   # When I click on aggree&add button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    #Then I verify zipcode

  Scenario: Availability, Delivery and Returns messages
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    Then I verify that availability, Delivery and Returns messaging in cart

  Scenario:Verify alternate addresses for client with multiple addresses
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I click on client button
    When I choose client who is a "nonmember"
    When I click on plus button from client lookup search results
    Then I verify alternate addresses for client with multipel addresses
