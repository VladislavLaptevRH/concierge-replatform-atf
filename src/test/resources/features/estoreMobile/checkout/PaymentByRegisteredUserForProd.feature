@criticalpath @checkout @payment @smoke
Feature:
	I want to test the payment page form for a registered user

# Background:
# 	Given I have a new session

Scenario: Login to the site
        Given I am on the site as "logInAndOutTest" registered user on mobile

Scenario Outline: Registered user can add different product to cart
        Given I open the pdp "<product_id>" on mobile
        Given I prepare options for product "<product_id>" and sku "<full_sku_id>" for "<postalCode>" on mobile
        When I select the options and add quantity "<qty>" to cart on mobile

        Examples:
          |product_id   | title                                   | full_sku_id     | qty |postalCode |
          |prod11600084 | Rectangular Column Table Lamp           | 68270648 LBBM   | 2   |postalCode |
            # |prod15970044 | Salvage Wood Trestle Round Dining Table | 62870008 NATL   | 1   |postalCode |
          | prod10810132  | LAMBETH KNURLED KNOB                 | 10035093 CHR   | 4   |postalCode |


Scenario Outline: Registered user can apply single credit card payment to order
    # Given I am on the site as "logInAndOutTest" registered user on mobile
	# Given I have the following saved address on mobile:
	# 	|first    | last   | address1   | address2   | city   | state   | country   | postal   | phone   |
	# 	|<first> | <last> | <address1> | <address2> | <city> | <state> | <country> | <postal> | <phone> |
	# And I have the following items in the cart on mobile:
	# 	|product_id   | title                                   | full_sku_id     | qty |
    #     |prod11600084 | Rectangular Column Table Lamp           | 68270648 LBBM   | 2   |
    #     |prod15970044 | Salvage Wood Trestle Round Dining Table | 62870008 NATL   | 1   |
    #    | prod10810132  | LAMBETH KNURLED KNOB                 | 10035093 CHR   | 4   |
    And  I visit the cart and proceed to shipping on mobile
    # When I verify the billing address and proceed to payment on mobile
	When I enter billing address and proceed to payment on mobile:
		|first    | last   | address1   | address2   | city   | state   | country   | postal   | phone   |
		| <first> | <last> | <address1> | <address2> | <city> | <state> | <country> | <postal> | <phone> |
    When I enter payment information for prod on mobile
    And  I continue to preview page by clicking on Continue on payment page on mobile
    Then I expect the review page to be displayed on mobile
	Examples:
		| first    | last | address1        | address2 | city    | state | country | country_full  | postal | phone      |
        | Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | United States | 98101  | 5555555555 |
