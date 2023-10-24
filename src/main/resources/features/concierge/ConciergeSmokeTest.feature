@Smoke @SmokeTest @Smoketest
Feature: Smoke test for concierge


  Scenario Outline: Top Nav Check in RH Concierge
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	Then  I expect that I am on the Concierge Dashboard page
	Then User verifies that all items from menu are displayed for "RH"
	Then  I change the brand to "<brand>"
	Then I verify the logo
	Then I verify the username
	Then I verify the gallery
	Then I verify the logo
	Then I verify project button
	Then I Verify search leans
	Then I verify user icon
	Then I verify cart
	Then I verify flag icon for country selection
	Then I verify top nav
	Then I verify brand dropdown
	Then I verify page label
	Then I verify page label
	Then I verify button "RH Orders" on homepage
	Then I verify button "Apply for RH Card" on homepage
	Then I verify button "RH card lookup" on homepage
	Then I verify button "Gift card enquiry" on homepage
	Then I verify button "RH.COM Profile" on homepage
	Then I verify search item field and search button
	Then I verify footer links for brand "<brand>"
	Examples:
	  | brand |
	  | RH    |
	  |RH CONTEMPORARY|
	  |RH INTERIORS   |
	  |RH MODERN      |
	  |RH OUTDOOR     |
	  |RH BEACH HOUSE |
	  |RH TEEN        |



  Scenario: Basic search functionality, PG check
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click on search Icon
	When I type item name 'rectangular table'
	Then I verify that 'PG has filters: CONCEPTS, IN-STOCK, SALE, BRAND, RESULTS and SORT is present' on PG screen
	Then I verify that 'CONCEPT dropdown returns various RH Brands' on PG screen
	Then I click 'RH Outdoor' on PG screen
	Then I verify that 'Italian Travertine Plinth Rectangular Fire Table is returned' on PG screen
	Then I verify that PG loads


  Scenario: Add to Cart and proceed to Payment page
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I remove all items from cart via UI
	When I remove client from header
	When I go to item "63130001" from search field
	When I select count of product
	When I click on add to cart button
	When I click on view cart button
	When I choose order classification
	When I click on checkout button
	When I click on no thanks button
	When I choose client who is a "Non-Member"
	When I fill all fields from address screen
	When I continue to payment
	When I click on continue with original address button
	When I execute payment for "VI"
	Then I verify that review screen is displayed