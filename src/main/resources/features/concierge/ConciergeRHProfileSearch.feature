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


  Scenario: Checkbox Registered user
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by registry only "Name"
	Then I confirm registered profile
	Then I confirm registered profile fields


  Scenario: Verify that Email or Membership id textfield should accept only integers or email formatted string
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by email
	Then I confirm registered profile


  Scenario: Verify that search with Membership id and verify the search results
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by member id
	Then I confirm registered profile
	Then I confirm registered profile fields

@mukthar
  Scenario: Verify that Searched profile should show Profile type(Registered/One Time Concierge user),  Email, name, RH Membership status, membership id, cart button CTA link and details button CTA link
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by Name
	Then I confirm registered profile
	Then I confirm registered profile fields
  	Then I confirm one time concierge user profile
  	Then I confirm one time concierge user fields

  @mukthar
  Scenario: Verify that Search with email id and verify the search results
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by email
	Then I confirm registered profile
	Then I confirm registered profile fields
	Then I confirm one time concierge user profile
	Then I confirm one time concierge user fields

  @mukthar
  Scenario: Verify that Search with Initial of First name and Full last name and verify the results
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by Initial of First name and Full last name
	Then I confirm registered profile
	Then I confirm registered profile fields
	Then I confirm one time concierge user profile
	Then I confirm one time concierge user fields

@mukthar
  Scenario: Verify that Search with email id, select Registered only checkbox and verify that search results excludes one time concierge user accounts
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by registry only "email"
	Then I confirm registered profile
	Then I confirm registered profile fields

  @mukthar
  Scenario: Verify that Search with emailid/membershipid, first name and last name, the results should be displayed based on the entered email id/membership id even if the firstname and last name field values are incorrect
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by email and incorrect name
	Then I confirm registered profile
	Then I confirm registered profile fields
	Then I confirm one time concierge user profile
	Then I confirm one time concierge user fields

@mukthar
  Scenario: Verify that On the user profile details page
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by Name
	Then I confirm registered profile
	Then I confirm registered profile fields
	Then I click details button
	Then I confirm user details page
  	Then I confirm fields of user details page

  @mukthar
  Scenario: Verify the Associate is able to navigate to Profile Search page using User Preference.
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by Name
	Then I confirm registered profile
	Then I confirm registered profile fields
	Then I confirm one time concierge user profile
	Then I confirm one time concierge user fields

  @mukthar
  Scenario: Verify that As an Associate, Verify the Search without entering any values
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click "RH.COM Profile" button on homepage
	Then I search by No Details
	Then I confirm error message
