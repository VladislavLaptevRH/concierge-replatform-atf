@conciergeTestRun
@conciergePayment
Feature: Concierge Payment

  Scenario Outline: Major CCs
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    And I continue to payment
    When I click on continue with original address button
    When I execute payment for "<cardType>"
    And I verify that review screen is displayed
    When I click on a place order button
    Then I click on order details button
    Then I verify that confirm screen is displayed
    Examples:
      | cardType |
      | VI       |
      | MC       |
      | AX       |
      | DI       |

  Scenario: Split Payment
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    And I continue to payment
    When I click on continue with original address button
    Then I execute split payment with 'VI'
    Then I execute split payment with 'MC'
    Then I verify that payment split is working and paid amount is visible on the review page
    When I click on a place order button
    Then I click on order details button
    Then I verify that payment split is working and paid amount is visible on the confirmation page

  Scenario: Full Payment
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    And I continue to payment
    When I click on continue with original address button
    When I execute payment for "VI"
    When I click on a place order button
    Then I click on order details button
    Then I verify the payment details and order estimate summary

  Scenario: RHCC Payment
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    And I continue to payment
    When I click on continue with original address button
    When I pay with RHCC method
    Then I verify that payment RHCC is working and paid amount is visible on the review page
    When I click on a place order button
    Then I click on order details button
    Then I verify that payment RHCC is working and paid amount is visible on the confirmation page
    Then I verify the payment details and order estimate summary

  Scenario: POS payment
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    When I continue to payment
    When I click on continue with original address button
    When I choose POS for payment method
    Then I verify that payment POS is working and paid amount is visible on the review page
    When I click on a place order button without signature
    Then I click on order details button
    Then I verify that payment POS is working and paid amount is visible on the confirmation page
    Then I verify the payment details and order estimate summary

  Scenario: Edit payment
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I fill all fields from address screen
    And I continue to payment
    When I click on continue with original address button
    When I execute payment for "VI"
    Then I verify that payment CC is working and paid amount is visible on the review page
    When I edit payment method
    When I click on a place order button
    Then I click on order details button
    Then I verify that payment POS is working and paid amount is visible on the confirmation page
    Then I verify the payment details and order estimate summary

  Scenario: Verify that DI and RHCC payments not allowed for CAN checkout
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose 'CA' country
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    And I continue to payment
    When I click on continue with original address button
    When I verify that I can't pay by RHCC and Discover cards for Canada

  Scenario: GC/ Balance check
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    And I continue to payment
    When I click on continue with original address button
    When I choose "RH Gift Card" from payment method
    When I click on check balance button
    Then I verify that balance info is displayed

  Scenario: Verify the Complete Billing address
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    And I continue to payment
    When I click on continue with original address button
    Then I verify the complete billing address

  Scenario: Verify the subtotal, shipping fee, taxes based on postal code
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    And I continue to payment
    When I click on continue with original address button
    Then I verify subtotal, shipping fee, taxes based on postal code

  Scenario: Verify member savings in payment page

    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Member"
    When I click on checkout button
    When I click on no thanks button
    When I fill all fields from address screen
    And I continue to payment
    When I click on continue with original address button
    Then I verify that member savings in payment page

  Scenario: Verify trade savings in payment page
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Trade"
    When I click on checkout button
    When I click on no thanks button
    And I fill all fields for sold to address
    Then I verify that trade savings in payment page

  Scenario: Edit Address
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    And I fill all fields from address screen
    And I continue to payment
    When I click on continue with original address button
    When I edit billing address from order review page
    And I continue to payment
    When I click on continue with original address button
    Then I verify that I'm able to edit billing address