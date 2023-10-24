@conciergeTestRun
@conciergeOrderHistory
Feature:Concierge Order history

  @mukthar
  Scenario: Verify the Order history in Dashboard
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	Then I expect that I am on the Concierge Dashboard page
	Then I verify button "RH Orders" on homepage
  	When I click "RH Orders" button on homepage
  	Then I verify order history page is displayed

  @mukthar
  Scenario: Verify look up by customer details
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	Then I expect that I am on the Concierge Dashboard page
	Then I verify button "RH Orders" on homepage
	When I click "RH Orders" button on homepage
	Then I verify order history page is displayed
	When I search by "name"
  	Then I confirm order is shown for search filter "name"

  @mukthar
  Scenario: Verify the contacts returned and select a contact to get the list of orders
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	Then I expect that I am on the Concierge Dashboard page
	Then I verify button "RH Orders" on homepage
	When I click "RH Orders" button on homepage
	Then I verify order history page is displayed
	When I search by "contact"
	Then I confirm order is shown for search filter "contact"

  @mukthar
  Scenario: Search with only First name field should not be allowed
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	Then I expect that I am on the Concierge Dashboard page
	Then I verify button "RH Orders" on homepage
	When I click "RH Orders" button on homepage
	Then I verify order history page is displayed
	When I search by "First Name"
  	Then I confirm user is not able to search only with first name

  @mukthar
  Scenario: Search with only Last name field and verify the customer account search results
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	Then I expect that I am on the Concierge Dashboard page
	Then I verify button "RH Orders" on homepage
	When I click "RH Orders" button on homepage
	Then I verify order history page is displayed
	When I search by "Last Name"
	Then I confirm order is shown for search filter "Last Name"

  @mukthar
  Scenario: Customer Accounts Search Results should contain Name, Address, Phone, Email, Trade id/ Trade Exempt columns and the Cusomter Account data
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	Then I expect that I am on the Concierge Dashboard page
	Then I verify button "RH Orders" on homepage
	When I click "RH Orders" button on homepage
	Then I verify order history page is displayed
	When I search by "Last Name"
	Then I confirm order is shown for search filter "Last Name"
  	Then I confirm table header " FIRST NAME"
  	Then I confirm table header "ADDRESS"
  	Then I confirm table header "PHONE"
  	Then I confirm table header "EMAIL"
	Then I confirm table header "COMPANY"
	Then I confirm table header " TRADE ID / TAX EXEMPT"
	Then I confirm order is shown for search filter "Last Name"

  @mukthar
  Scenario: US Region: Enter values in the order search modal and click on the Clear search button, the entered data should be cleared
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	Then I expect that I am on the Concierge Dashboard page
	Then I verify button "RH Orders" on homepage
	When I click "RH Orders" button on homepage
	Then I verify order history page is displayed




#  Scenario: Order history search is accessible from the dashboard
#    Given I log into Concierge as "associate"
#    When I navigate to the order history page from the concierge dashboard
#    Then I verify the customer lookup form appears
#    And I verify the order lookup form appears
#
#  Scenario Outline: Verify order history search returns a list of users - <firstName>
#    Given I log into Concierge as "associate"
#    When I navigate to the order history page from the concierge dashboard
#    And I search order history for customer "<firstName>" "<lastName>"
#    Then I see results for order history by customer search
#    Examples:
#      | firstName | lastName   |
#      | notexist  | notexist   |
#      | test      | test       |
#
#  Scenario: Verify UI elements from order history page
#    Given I log into Concierge as "associate"
#    When I navigate to the order history page from the concierge dashboard
#    And I search order history for customer "Automation" "Nonmember"
#    When I click on the random result
#    Then I verify that order history page is displayed
#
#  Scenario:Verify that customer lookup is displayed after that I click on back to search results button
#    Given I log into Concierge as "associate"
#    When I navigate to the order history page from the concierge dashboard
#    And I search order history for customer "Automation" "Nonmember"
#    When I click on the random result
#    When I click on back to search results button
#    Then I verify the customer lookup form appears
#
#  Scenario: Verify that if I click on order item I'll redirected to wismo
#    Given I log into Concierge as "associate"
#    When I navigate to the order history page from the concierge dashboard
#    And I search order history for customer "Automation" "Nonmember"
#    When I click on the random result
#    When I click on random order
#    Then I verify that I redirected to wismo
#
#  Scenario: Verify that if I click on order item I'm able to check order details
#    Given I log into Concierge as "associate"
#    When I navigate to the order history page from the concierge dashboard
#    And I search order history for customer "Automation" "Nonmember"
#    When I click on the random result
#    When I click on random order
#    And I verify that I redirected to wismo
##    Then I verify order details
#
#  Scenario Outline: Verify order lookup search for <status> order
#    Given I log into Concierge as "associate"
#    When I navigate to the order history page from the concierge dashboard
#    Then I verifiy that Order Lookup title is displayed
#    When I introduced "<orderId>" with status "<status>" order number in order number field
#    Then I verify that I redirected to wismo
#    Examples:
#      | orderId         | status      |
#      | R03283581845714 | inProcess   |
#      | 785071          | open        |
#      | 12345           | notExisting |