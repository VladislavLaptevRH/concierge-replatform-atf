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