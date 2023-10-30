@conciergeTestRun
@ConciergeRHProfileSearch
Feature: Concierge RH profile search

  Scenario: Verify Search by name
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by Name
	Then I confirm registered profile

  Scenario: Verify Search by email or membership id
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by email
	Then I confirm registered profile

  Scenario: Verify Search results verification
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by Name
	Then I confirm registered profile
	Then I confirm registered profile fields

  Scenario: Verify the estore user's Cart
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by Name
	Then I confirm registered profile
	Then I confirm registered profile fields
	Then I click cart button
	Then I confirm user cart page

  Scenario: Verify the estore user's Details
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by Name
	Then I confirm registered profile
	Then I confirm registered profile fields
	Then I click details button
	Then I confirm user details page

  Scenario: Verify the estore user's Wishlist
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by Name
	Then I confirm registered profile
	Then I confirm registered profile fields
	Then I click cart button
	Then I confirm user cart page
	Then I click on wishlist link
	Then I confirm user wishlist page

@mukthar
  Scenario: Verify that Order History in rh.com profile from registered user profile- estore users order history should be displayed
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by Name
	Then I confirm registered profile
	Then I confirm registered profile fields
	Then I click cart button
	Then I confirm user cart page
	Then I click on order history link
	Then I confirm user order history page

  @mukthar
  Scenario: Verify the estore user's Registry
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by Name
	Then I confirm registered profile
	Then I confirm registered profile fields
	Then I click cart button
	Then I confirm user cart page
	Then I click on order history link
	Then I confirm user order history page
	Then I confirm user order history Registry page

@mukthar
  Scenario: Checkbox Registered user
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by registry only
	Then I confirm registered profile
	Then I confirm registered profile fields

  @mukthar
  Scenario: Verify that Email or Membership id textfield should accept only integers or email formatted string
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by email
	Then I confirm registered profile

  @mukthar
  Scenario: Verify that search with Membership id and verify the search results
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by member id
	Then I confirm registered profile
	Then I confirm registered profile fields