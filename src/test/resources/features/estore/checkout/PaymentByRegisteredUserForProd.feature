@criticalpath @checkout @payment @smoke
Feature:
	I want to test the payment page form for a registered user

Background:
	Given I have a new session
	Given I open the url "/my-account/sign-in.jsp"
	Given I set a cookie "pc" with the content "94111"

Scenario Outline: Registered user can apply single credit card payment to order
	Given I am the web customer:
		|first    | last | email                 | password     |
		|<first> | <last> | login@rh.com         | Test1234     |
	Given I have the following saved address:
		|first    | last   | address1   | address2   | city   | state   | country   | postal   | phone   |
		| <first> | <last> | <address1> | <address2> | <city> | <state> | <country> | <postal> | <phone> |
	And I have the following items in the cart:
		|product_id   | title                                   | full_sku_id     | qty |
		|prod11600084 | Rectangular Column Table Lamp           | 68270648 LBBM   | 2   |
        |prod15970044 | Salvage Wood Trestle Round Dining Table | 62870008 NATL   | 1   |
        |prod2020027  |802-GRAM TURKISH TOWEL COLLECTION		| 17050042 WHT    | 1   |
    And  I visit the cart and proceed to shipping
	When  I enter billing address and proceed to payment:
		|first    | last   | address1   | address2   | city   | state   | country   | postal   | phone   |
		| <first> | <last> | <address1> | <address2> | <city> | <state> | <country> | <postal> | <phone> |
	When I enter payment information for prod
	And  I continue to preview page by clicking on Continue on payment page
	Then I expect the review page to be displayed

	Examples:
		| first    | last | address1        | address2 | city    | state | country | country_full  | postal | phone      |
        | Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | United States | 98101  | 5555555555 |
