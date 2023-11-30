@conciergeTestRun
@conciergeThankYou

Feature: Concierge ThankYouPage

  Scenario: Verify order details
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
    When I choose POS for payment method
    When I click on a place order button
    When I click on order details button
    Then I verify order details from thank you page

  Scenario: Verify the payment details and Order estimate summary
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I fill all fields from address screen
    And I continue to payment
    When I click on continue with original address button
    When I choose POS for payment method
    When I click on a place order button
    When I click on order details button
    Then I verify the payment details and order estimate summary

  Scenario: Verify all the line items in the cart
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
    When I click on no thanks button
    When I choose POS for payment method
    When I click on a place order button
    When I click on order details button
    Then I verify all the line items in the cart on thank you page

  Scenario: Verify the order number and email address verbiage
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
    When I choose POS for payment method
    When I click on a place order button
    Then I verify order number and email address verbiage