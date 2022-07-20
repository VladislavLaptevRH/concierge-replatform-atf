#@estoreRegression
#@estoreThankYouPageRegression
#Feature: Estore ThankYouPage
#
#  Scenario: Verify order details
#    Given I log into Concierge as "associate"
#    When I remove all items from cart
#    When I go to item "10011392 SS" from search field
#    And I select count of product
#    When I click on add to cart button
#    When I click on view cart button
#    When I choose order classification
#    When I click on checkout button
#    When I click on no thanks button
#    When I choose client who is a "nonmember"
#    When I fill all fields from address screen
#    And I continue to payment
#    When I choose POP for payment method
#    When I click on a place order button
#    When I click on order details button
#    Then I verify order details from thank you page
#
#  Scenario: Verify the payment details and Order estimate summary
#    Given I log into Concierge as "associate"
#    When I remove all items from cart
#    When I go to item "10011392 SS" from search field
#    And I select count of product
#    When I click on add to cart button
#    When I click on view cart button
#    When I choose order classification
#    When I click on checkout button
#    When I click on no thanks button
#    When I choose client who is a "nonmember"
#    When I fill all fields from address screen
#    And I continue to payment
#    When I choose POP for payment method
#    When I click on a place order button
#    When I click on order details button
#    Then I verify the payment details and order estimate summary
#
#  Scenario: Verify all the line items in the cart
#    Given I log into Concierge as "associate"
#    When I remove all items from cart
#    When I go to item "10011392 SS" from search field
#    And I select count of product
#    When I click on add to cart button
#    When I click on view cart button
#    When I choose order classification
#    When I click on checkout button
#    When I click on no thanks button
#    When I choose client who is a "nonmember"
#    When I fill all fields from address screen
#    And I continue to payment
#    When I choose POP for payment method
#    When I click on a place order button
#    When I click on order details button
#    Then I verify all the line items in the cart on thank you page
#
#  Scenario: Verify the order number and email address verbiage
#    Given I log into Concierge as "associate"
#    When I remove all items from cart
#    When I go to item "10011392 SS" from search field
#    And I select count of product
#    When I click on add to cart button
#    When I click on view cart button
#    When I choose order classification
#    When I click on checkout button
#    When I click on no thanks button
#    When I choose client who is a "nonmember"
#    When I fill all fields from address screen
#    And I continue to payment
#    When I choose POP for payment method
#    When I click on a place order button
#    Then I verify order number and email address verbiage
