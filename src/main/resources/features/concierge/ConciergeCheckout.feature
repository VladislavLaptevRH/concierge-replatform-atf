@conciergeTestRun
@conciergeCheckout
Feature: Concierge Checkout flow

  Scenario: Verify checkout with non member client
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I remove all items from cart via UI
	When I choose client who is a non member
	When I add item to cart via API with "10146709 LOAK" and quantity '1'
	When I open cart
	When I choose order classification
	When I click on checkout button
	Then Verify Checkout page should get opened with Shipping and Billing address option

  Scenario: Verify checkout with member client - verify the member discount applied
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I remove all items from cart via UI
	When I remove client from header
	When I add item to cart via API with "10146709 LOAK" and quantity '1'
	When I open cart
	When I choose order classification
	When I click on checkout button
	When I click on no thanks button
	When I choose client who is a "Member"
	Then I verify that cart is displayed
	Then I verify that membership price displayed as total price
	When I click on checkout button
	Then I verify that ship to, bill to, sold to addresses are displayed
	When I continue to payment
	When I click on continue with original address button
	When I execute payment for "VI"
	Then I verify that review screen is displayed
	When I click on a place order button

  Scenario: Verify checkout with trade client - verify the trade discount applied
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
	Then I verify "trade" savings for a "trade" user

  Scenario: Verify checkout with Unclassified Business client
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I remove all items from cart via UI
	When I remove client from header
	When I add item to cart via API
	When I open cart
	When I choose order classification
	When I click on checkout button
	When I click on no thanks button
	When I choose client who is a "Unclassified"
	When I click on checkout button
	Then I verify that ship to, bill to, sold to addresses are displayed
	When I continue to payment
	When I click on continue with original address button
	When I execute payment for "VI"
	Then I verify that review screen is displayed
	When I click on a place order button

  Scenario:Verify checkout with a NEW CLIENT functionality - address fields empty and new client is added to session
	Given I log into Concierge as "associate"
	When I remove all items from cart via UI
	When I remove client from header
	When I add item to cart via API
	When I open cart
	When I choose order classification
	When I click on checkout button
	When I click on no thanks button
	When I choose client who is a "Non-Member"
	When I continue to payment
	Then I verify client should not get added with empty address field.


  Scenario: Verify the saved addresses, ship to - bill to  from SF in address page for a client with primary and secondary addresses - regular accounts
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
	Then I verify that ship to, bill to, sold to addresses are displayed
	When I continue to payment
	When I click on continue with original address button
	Then Verify that after come back to address page from payment page ship to and bill to address is showing
