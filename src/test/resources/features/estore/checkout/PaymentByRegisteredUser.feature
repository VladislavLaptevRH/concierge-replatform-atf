@criticalpath @checkout @payment @smoke
Feature: I want to test the payment page form for a registered user

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
        |prod15970044 | Salvage Wood Trestle Round Dining Table | 62870126 NATL   | 1   |
        |prod10810132  | LAMBETH KNURLED KNOB                 | 10035093 CHR   | 4   |
          |prod19660330 | TETON MERINO WOOL GEO PILLOW COVER - SQUARE  | 10036059 BKNA    | 4   |
         #  |prod190091   |BELGIAN HEAVYWEIGHT TEXTURED LINEN DRAPERY|13070073 BLCG  |1| 
          |prod1676346  |GREENWICH URN                           |42850301 AS    |1|
          |prod23230023 |BAHIA SOFA COVER                        |10084502 CHCL  |1|
          |prod10810111 |LAMBETH HEXAGONAL KNOB                         |10038761 CHR   | 1 |
          |prod10800120 |PIEDMONT PEDESTAL SOAKING TUB WITH CROSS-HANDLE TUB FILL|22260070 ABRS  |1|
         #  |prod2420980  |ST. JAMES DOUBLE VANITY|10005170 WCAR  | 1 | 
          |prod8550689  |AIRELOOM® ALTA LUXETOP™ LIFT™ MATTRESS|10011460 NONE  |1| 
          |prod14280120 |802-GRAM TURKISH TOWEL COLLECTION |17050042 CERU  | 1 |
         #   |prod9740156  |CLOUD MODULAR SOFA           |50400833 CLWT | 1 |
    And  I visit the cart and proceed to shipping
	When I enter billing address and proceed to payment:
		|first    | last   | address1   | address2   | city   | state   | country   | postal   | phone   |
		| <first> | <last> | <address1> | <address2> | <city> | <state> | <country> | <postal> | <phone> |
	When I enter payment info for new card:
		| cardType   | cardNumber   | expMonth   | expYear   | ccv   |
		| <cardType> | <cardNumber> | <expMonth> | <expYear> | <ccv> |
	And  I continue to preview page by clicking on Continue on payment page
	Then I expect the review page to be displayed
	When I click on Place Order
	Then I land on Thank you page and I see the Order Number
    Then I verify payment information for estore under payment information section on checkout thank you page
        | cardType   | cardNumber   |
        | <cardType> | <cardNumber> |
	Then I signed out

	Examples:
		| first    | last | address1        | address2 | city    | state | country | country_full  | postal | phone      | cardType        | cardNumber       | expMonth | expYear | ccv  |
       #| Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | United States | 98101  | 5555555555 | americanExpress | 341134113411347  |02       | 2025    | 6765 |
		#| Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | United States | 98101  | 5555555555 | visa            | 4114360123456785 | 03      | 2030    | 111  |
        | Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | United States | 98101  | 5555555555 | americanExpress | 370788901763229|02       | 2033    | 3876 |
        | Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | United States | 98101  | 5555555555 | visa            | 4678475330157543| 03      | 2030    | 737  |


    Scenario Outline: Registered user can apply saved credit card payment method to order
	Given I am the web customer:
        |first    | last | email                 | password     |
		|<first> | <last> | login@rh.com         | Test1234     |
	And I have the following saved address:
		|first    | last   | address1   | address2   | city   | state   | country   | postal   | phone   |
		| <first> | <last> | <address1> | <address2> | <city> | <state> | <country> | <postal> | <phone> |
	And I have no saved credit cards
	And I visit the user payment page and enter:
		| first   | last   | address1   | address2   | city   | state   | country   | postal   | phone   | cardType   | cardNumber   | expMonth   | expYear   | ccv   |
		| <first> | <last> | <address1> | <address2> | <city> | <state> | <country> | <postal> | <phone> | <cardType> | <cardNumber> | <expMonth> | <expYear> | <ccv> |
	And I have the following items in the cart:
		| product_id   | title                                   | full_sku_id     | qty |
		| prod11600084 | Rectangular Column Table Lamp           | 68270648 LBBM   | 2   |
		| prod15970044 | Salvage Wood Trestle Round Dining Table | 62870126 NATL   | 1   |
        | prod10810132  | LAMBETH KNURLED KNOB                 | 10035093 CHR   | 4   |
      #  | prod1861095  |MESA SQUARE SIDE TABLE                   |64420024 NATL    | 2   |
        | prod20480292  |AERO WOOD RECTANGULAR DINING TABLE       |10038149 LGBP    | 1   |
        | prod10850149 |MARBELLA TEAK CLASSIC MODULAR LEFT-ARM CHAIR - WEATHERED TEAK|64920136 WGTK|2|
      #  | prod1871355  |CUSTOM BELGIAN LOOPED WOOL SISAL RUG     |15020143 HONY    | 2   |
    And  I visit the cart and proceed to shipping
	And  I proceed to payment
	When I select the following saved card:
		| cardType   | cardNumber   | expMonth   | expYear   |
		| <cardType> | <cardNumber> | <expMonth> | <expYear> |
	Then I expect to see the saved card data on the payment page:
		| first   | last   | address1   | address2   | city   | state   | country        | postal   | phone   | cardType   | cardNumber   | expMonth   | expYear   |
		| <first> | <last> | <address1> | <address2> | <city> | <state> | <country_full> | <postal> | <phone> | <cardType> | <cardNumber> | <expMonth> | <expYear> |
	When I enter ccv value "<ccv>" for stored credit card
	Then I expect the review page to be displayed
	When I click on Place Order
	Then I land on Thank you page and I see the Order Number
    Then I verify payment information for estore under payment information section on checkout thank you page
        | cardType   | cardNumber   |
        | <cardType> | <cardNumber> |
	Then I signed out

	Examples:
		| first    | last | address1        | address2 | city    | state | country | country_full  | postal | phone      | cardType        | cardNumber       | expMonth | expYear | ccv  |
        # | Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | United States | 98101  | 5555555555 | americanExpress | 341134113411347  | 02       | 2025    | 6765 |
	   # | Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | United States | 98101  | 5555555555 | visa            | 4114360123456785 | 03       | 2030    | 111  |
         | Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | United States | 98101  | 5555555555 | americanExpress | 370788901763229|02       | 2033    | 3876 |
         | Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | United States | 98101  | 5555555555 | visa            | 4678475330157543| 03      | 2030    | 737  |


    Scenario Outline: Registered user can go back to Payment page from Order Review Page
	Given I am the web customer:
		|first    | last | email                 | password     |
		|<first> | <last> | login@rh.com         | Test1234     |
	Given I have the following saved address:
		|first    | last   | address1   | address2   | city   | state   | country   | postal   | phone   |
		| <first> | <last> | <address1> | <address2> | <city> | <state> | <country> | <postal> | <phone> |
	And I have the following items in the cart:
		|product_id   | title                                   | full_sku_id     | qty |
		|prod11600084 | Rectangular Column Table Lamp           | 68270648 LBBM   | 2   |
		|prod15970044 | Salvage Wood Trestle Round Dining Table | 62870126 NATL   | 1   |
        | prod10810132  | LAMBETH KNURLED KNOB                 | 10035093 CHR   | 4   |
          |prod19660330 | TETON MERINO WOOL GEO PILLOW COVER - SQUARE  | 10036059 BKNA    | 4   |
         #  |prod190091   |BELGIAN HEAVYWEIGHT TEXTURED LINEN DRAPERY|13070073 BLCG  |1| 
          |prod1676346  |GREENWICH URN                           |42850301 AS    |1|
          |prod23230023 |BAHIA SOFA COVER                        |10084502 CHCL  |1|
          |prod10810111 |LAMBETH HEXAGONAL KNOB                         |10038761 CHR   | 1 |
          |prod10800120 |PIEDMONT PEDESTAL SOAKING TUB WITH CROSS-HANDLE TUB FILL|22260070 ABRS  |1|
         #  |prod2420980  |ST. JAMES DOUBLE VANITY|10005170 WCAR  | 1 | 
          |prod8550689  |AIRELOOM® ALTA LUXETOP™ LIFT™ MATTRESS|10011460 NONE  |1| 
          |prod14280120 |802-GRAM TURKISH TOWEL COLLECTION |17050042 CERU  | 1 |
         #   |prod9740156  |CLOUD MODULAR SOFA           |50400833 CLWT | 1 |
	And  I visit the cart and proceed to shipping
	When  I enter billing address and proceed to payment:
		|first    | last   | address1   | address2   | city   | state   | country   | postal   | phone   |
		| <first> | <last> | <address1> | <address2> | <city> | <state> | <country> | <postal> | <phone> |
	When I enter payment info for new card:
		| cardType   | cardNumber   | expMonth   | expYear   | ccv   |
		| <cardType> | <cardNumber> | <expMonth> | <expYear> | <ccv> |
	And  I continue to preview page by clicking on Continue on payment page
	Then I expect the review page to be displayed
	When I click on 'Back to Payment'
	Then I expect the payment page to be displayed
	Then I signed out

	Examples:
		| first    | last | address1        | address2 | city    | state | country | country_full  | postal | phone      | cardType        | cardNumber       | expMonth | expYear | ccv  |
		# | Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | United States | 98101  | 5555555555 |americanExpress | 341134113411347  |02       | 2025    | 6765 |
        #| Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | United States | 98101  | 5555555555 | visa            | 4114360123456785 | 03      | 2030    | 111  |
        | Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | United States | 98101  | 5555555555 |americanExpress | 370788901763229|02       | 2033    | 3876 |
        | Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | United States | 98101  | 5555555555 | visa             | 4678475330157543| 03      | 2030    | 737  |

    Scenario Outline: Registered user can apply multiple credit card and split payment method to order
	Given I am the web customer:
		|first    | last | email                 | password     |
		|<first> | <last> | login@rh.com         | Test1234     |
	Given I have the following saved address:
		|first    | last   | address1   | address2   | city   | state   | country   | postal   | phone   |
		| <first> | <last> | <address1> | <address2> | <city> | <state> | <country> | <postal> | <phone> |
	And I have the following items in the cart:
		|product_id   | title                                   | full_sku_id     | qty |
		|prod11600084 | Rectangular Column Table Lamp           | 68270648 LBBM   | 2   |
        |prod15970044 | Salvage Wood Trestle Round Dining Table | 62870126 NATL   | 1   |
        | prod10810132  | LAMBETH KNURLED KNOB                 | 10035093 CHR   | 4   |
          |prod19660330 | TETON MERINO WOOL GEO PILLOW COVER - SQUARE  | 10036059 BKNA    | 4   |
         #  |prod190091   |BELGIAN HEAVYWEIGHT TEXTURED LINEN DRAPERY|13070073 BLCG  |1| 
          |prod1676346  |GREENWICH URN                           |42850301 AS    |1|
          |prod23230023 |BAHIA SOFA COVER                        |10084502 CHCL  |1|
          |prod10810111 |LAMBETH HEXAGONAL KNOB                         |10038761 CHR   | 1 |
          |prod10800120 |PIEDMONT PEDESTAL SOAKING TUB WITH CROSS-HANDLE TUB FILL|22260070 ABRS  |1|
         #  |prod2420980  |ST. JAMES DOUBLE VANITY|10005170 WCAR  | 1 | 
          |prod8550689  |AIRELOOM® ALTA LUXETOP™ LIFT™ MATTRESS|10011460 NONE  |1| 
          |prod14280120 |802-GRAM TURKISH TOWEL COLLECTION |17050042 CERU  | 1 |
         #   |prod9740156  |CLOUD MODULAR SOFA           |50400833 CLWT | 1 |
    And  I visit the cart and proceed to shipping
	When  I enter billing address and proceed to payment:
		|first    | last   | address1   | address2   | city   | state   | country   | postal   | phone   |
		| <first> | <last> | <address1> | <address2> | <city> | <state> | <country> | <postal> | <phone> |
	When I enter payment info for new card:
		| cardType   | cardNumber       | expMonth | expYear | ccv |
         #|americanExpress | 341134113411347  |02       | 2025    | 6765 |
        |americanExpress | 370788901763229|02       | 2033    | 3876 |
	And  I select Split payment method
	And I enter split amount as "1" and click Continue
#	When I enter payment info for new gift card:
#		| cardType   | cardNumber       | pin |
#		| giftcard|6006493880499901379| 2090|
#	And  I continue to preview page by clicking on Continue on payment page
	When I enter payment info for new card:
		| cardType   | cardNumber       | expMonth | expYear | ccv |
		#|visa            | 4114360123456785 | 03      | 2030    | 111  |
        | visa             | 4678475330157543| 03      | 2030    | 737  |
    And  I continue to preview page by clicking on Continue on payment page
	Then I expect the review page to be displayed
	When I click on Place Order
	Then I land on Thank you page and I see the Order Number
#    Then Payment information is "RH Gift Card XXXXXXXXXXXXXXX1379: $" on checkOut Thank you page
#    Then Payment information is "American Express XXXXXXXXXXX1347: $" on checkOut Thank you page
#    Then Payment information is "Visa XXXXXXXXXXXX6785: $" on checkOut Thank you page
     Then Payment information is "Visa XXXXXXXXXXXX7543: $" on checkOut Thank you page
     Then Payment information is "American Express XXXXXXXXXXX3229: $" on checkOut Thank you page  
     Then I signed out

	Examples:
		| first    | last | address1        | address2 | city    | state | country | country_full  | postal | phone      |
		| Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | United States | 98101  | 5555555555 |
