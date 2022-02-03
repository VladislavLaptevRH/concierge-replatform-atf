Feature: Verify concierge payment by signed user
Background:
	Scenario: Login into Concierge for the store 146: West Hollywood
	Given I login into Concierge with valid credentials for the store 146: West Hollywood
	Then  I expect that I am on the Concierge Dashboard page
	Scenario Outline: Concierge user verify that added items are saved in the shopping cart
		Given I am on concierge dashboard for the store 146:West Hollywood
		When I navigate to the cart page
		Then I verify that products the following options "<title>","<full_sku_id>","<qty>" are in the shopping cart
		Examples:
			| title                          | full_sku_id   | qty |
			|802-Gram Turkish Towel Collection| 17050042 | 1   |
			|Arles Rectangular Dining Table| 62960714 | 1   |
##
##	Scenario Outline: Concierge user can apply single credit card payment to order
##		Given I am on concierge dashboard for the store 146:West Hollywood
##		When I navigate to the cart page
##		When I continue to payment page
##		When I enter payment info for new card on concierge
##			| cardType   | cardNumber   | expMonth   | expYear   | ccv   |
##			| <cardType> | <cardNumber> | <expMonth> | <expYear> | <ccv> |
##		When I click on "Continue to order review" button on "Payment" page
##		Then I landed on the "Order Review" page
##		When I click on "Place Order" button on "Order Review" page
##		When I click on "Accept & Place Order" button on "Order Review" page
##		Then I landed on the "Thank You" page
##		Then I see "Order number" in "Thank You" page
##		Then I verify payment information under payment information section on checkout thank you page
##			| cardType   | cardNumber   |
##			| <cardType> | <cardNumber> |
#
#		Examples:
#			| cardType | cardNumber       | expMonth | expYear |
#		# Adyen     | discover        | 6011601160116611 | 03       | 2030    |
#		#           | masterCard      | 5111005111051128 | 05       | 2025    |
#		#            | americanExpress | 371144371144376  | 05       | 2025   |
#			| visa     | 4444444444444448 | 05       | 2025    |
#
##Scenario: Concierge user can apply multiple credit card payment to order
##	Given I am on concierge dashboard for the store "146: West Hollywood"
##	Given I have the following items in the cart:
##		|product_id   | title                            | full_sku_id     | qty |
##		|prod14650003 | Gram Turkish Bath Towel          | 17050042 BISQ   | 2   |
##		|prod1861095  | MESA SQUARE SIDE TABLE           | 64420024 NATL   | 2   |
##		|prod7411003  | ARLES RECTANGULAR DINING TABLE   | 62960714 LGRY   | 1   |
##		|prod10850149 | MARBELLA TEAK CLASSIC MODULAR LEFT-ARM CHAIR - WEATHERED TEAK|64920136 WGTK|2|
##		|prod1871355  | CUSTOM BELGIAN LOOPED WOOL SISAL RUG|15020143 HONY  | 2   |
##		#	|prod3070596  | COSTA TEAK SIDE CHAIR CUSHION       |64560069 BWMR           | 1   |
##	When I navigate to the "cart" page
##	When I continue to payment page
##	When I enter payment info for new card on concierge
##		| cardType   | cardNumber       | expMonth | expYear | ccv |
##		| americanExpress |371144371144376 |05       | 2025    | <ccv> |
##	When I click on "Split Payment with Additional Cards" button on "Payment" page
##	When I enter the amount "10"
##	When I enter payment info for new card on concierge
##		| cardType   | cardNumber       | expMonth | expYear | ccv |
##		| visa | 4444444444444448 | 05       | 2025    | <ccv> |
##	When I click on "Continue to order review" button on "Payment" page
##	Then I landed on the "Order Review" page
##	When I click on "Place Order" button on "Order Review" page
##	When I click on "Accept & Place Order" button on "Order Review" page
##	Then I landed on the "Thank You" page
##	Then I see "Order number" in "Thank You" page
