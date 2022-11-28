@concierge-All
@concierge-OrderReview
Feature:Concierge Order review

  Scenario: Edit Shipping Address
    Given I log into Concierge as "associate"
    When I clear order via API
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    When I fill all fields from address screen
    And I continue to payment
    When I choose POP for payment method
    When I edit shipping address from order review page
    When I continue to payment
    #Then I verify that I'm able to edit shipping address

  Scenario: Edit Billing Address
    Given I log into Concierge as "associate"
    When I clear order via API
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    When I fill all fields from address screen
    And I continue to payment
    When I choose POP for payment method
    When I edit billing address from order review page
    When I continue to payment
    When I click on order details button
    And I verify that I'm able to edit billing address

  Scenario: Edit payment
    Given I log into Concierge as "associate"
    When I clear order via API
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    When I fill all fields from address screen
    And I continue to payment
    When I choose POP for payment method
    When I edit payment method
    When I click on a place order button

  Scenario: Verify the payment details and Order estimate summary
    Given I log into Concierge as "associate"
    When I clear order via API
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    When I fill all fields from address screen
    And I continue to payment
    When I choose POP for payment method
    Then I verify the payment details and order estimate summary

  Scenario: SPO ORDER & TERMS REVIEW SIGNATURE CAPTURE
    Given I log into Concierge as "associate"
    When I remove all items from cart via API
    When I remove client from header
    When I clicks on a random menu item
    When I click on collections item
    When I clicks on o random item
    When I select debth option
    When I select fabric option
    When I select length option
    When I select color option
    And I select count of product
    And I click on add to cart button
    When I click on aggree&add button
    And I click on view cart button
    When I choose order classification
    And I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    When I fill all fields from address screen
    When I continue to payment
    When I choose POP for payment method
    When I click on a place order button
    Then I verify spo order & terms review signature

  Scenario: Verify all the line items on the order review page
    Given I log into Concierge as "associate"
    When I clear order via API
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    When I fill all fields from address screen
    And I continue to payment
    When I choose POP for payment method
    Then I verify that all the line items in the cart with the order review page
