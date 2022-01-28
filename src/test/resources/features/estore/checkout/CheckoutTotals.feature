@criticalpath @checkout @smoke
Feature:
   I want to be able to test the cart totals match through checkout

Background:
   Given I open the url "/my-account/sign-in.jsp"
   Given I set a cookie "pc" with the content "94111"

Scenario: Checkout Totals verify cart totals match through checkout
   Given I am the web customer:
          |first    | last | email                 | password     |
          |Cucumber | User | login@rh.com          | Test1234     |
   And I have the following saved address:
		    |first    | last   | address1   | address2   | city   | state   | country   | postal   | phone   |
		    |Cucumber | User   | 721 Pine Street |          | Seattle | WA    | US      | 98101 | 5555555555|
	And I have no saved credit cards
	And I visit the user payment page and enter:
		| first   | last   | address1   | address2   | city   | state   | country   | postal   | phone   | cardType   | cardNumber   | expMonth   | expYear   | ccv   |
		|Cucumber| User | 721 Pine Street |          | Seattle | WA    | US      | 98101 | 5555555555| masterCard | 2222400010000008 | 03       | 2030   |737|
   And I have the following items in the cart:
          |product_id   | title                                   | full_sku_id     | qty |
          |prod11600084 | Rectangular Column Table Lamp           | 68270648 LBBM   | 2   |
          |prod15970044 | Salvage Wood Trestle Round Dining Table | 62870126 NATL   | 1   |
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
   When  I visit the cart
   Then  I expect the cart totals to be correct
   When  I visit the cart and proceed to shipping
	And  I proceed to payment
   When  I enter ccv value "737" for stored credit card
   Then  I expect the review page to be displayed
