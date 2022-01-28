@criticalpath @checkout @payment @smoke
Feature:
    I want to test the payment page form for an anonymous user

    Background:
        Given I have a new session

    Scenario Outline: Guest user can apply single payment to order
        Given I am on the site as a guest user
        And I have the following items in the cart:
            | product_id   | title                                   | full_sku_id   | qty |
            | prod11600084 | Rectangular Column Table Lamp           | 68270648 LBBM | 2   |
            | prod15970044 | Salvage Wood Trestle Round Dining Table | 62870126 NATL | 1   |
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
        And  I continue as guest
        And  I enter shipping address:
            | first    | last | address1        | address2 | city    | state | country | postal | phone      |
            | Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | 98101  | 5555555555 |
        And  I select billing same as shipping
        And  I enter email address "test@rh.com" on the shipping page
        And  I proceed to payment
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

        Examples:
            | cardType        | cardNumber       | expMonth | expYear | ccv  |
# Adyen     | discover        | 6011601160116611 | 03       | 2030    | 737  |
           # | masterCard      | 5111005111051128 | 05       | 2025    | 123  |
           # |americanExpress | 341134113411347  |02       | 2025    | 6765 |
           # | visa            | 4114360123456785 | 03       | 2030    | 111  |
            | masterCard      | 2222400010000008 | 03       | 2030    | 737  |
            # | americanExpress | 370788901763229  | 02       | 2033    | 3876 |
            # | visa            | 4678475330157543 | 03       | 2030    | 737  |

#    Scenario: Guest user can apply multiple payment card (split payment) to order
#        Given I am on the site as a guest user
#        And I have the following items in the cart:
#            | product_id   | title                                   | full_sku_id   | qty |
#            | prod11600084 | Rectangular Column Table Lamp           | 68270648 LBBM | 2   |
#            | prod15970044 | Salvage Wood Trestle Round Dining Table | 62870126 NATL | 1   |
#             | prod10810132  | LAMBETH KNURLED KNOB                 | 10035093 CHR   | 4   |
#             |prod19660330 | TETON MERINO WOOL GEO PILLOW COVER - SQUARE  | 10036059 BKNA    | 4   |
#             #  |prod190091   |BELGIAN HEAVYWEIGHT TEXTURED LINEN DRAPERY|13070073 BLCG  |1| 
#             |prod1676346  |GREENWICH URN                           |42850301 AS    |1|
#             |prod23230023 |BAHIA SOFA COVER                        |10084502 CHCL  |1|
#             |prod10810111 |LAMBETH HEXAGONAL KNOB                         |10038761 CHR   | 1 |
#             |prod10800120 |PIEDMONT PEDESTAL SOAKING TUB WITH CROSS-HANDLE TUB FILL|22260070 ABRS  |1|
#             #  |prod2420980  |ST. JAMES DOUBLE VANITY|10005170 WCAR  | 1 | 
#             |prod8550689  |AIRELOOM® ALTA LUXETOP™ LIFT™ MATTRESS|10011460 NONE  |1| 
#             |prod14280120 |802-GRAM TURKISH TOWEL COLLECTION |17050042 CERU  | 1 |
#             #   |prod9740156  |CLOUD MODULAR SOFA           |50400833 CLWT | 1 |
#        And  I visit the cart and proceed to shipping
#        And  I continue as guest
#        And  I enter shipping address:
#            | first    | last | address1        | address2 | city    | state | country | postal | phone      |
#            | Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | 98101  | 5555555555 |
#        And  I select billing same as shipping
#        And  I enter email address "test@rh.com" on the shipping page
#        And  I proceed to payment
#        When I enter payment info for new card:
#            | cardType        | cardNumber      | expMonth | expYear | ccv  |
#           #|americanExpress | 341134113411347  |02       | 2025    | 6765 |
#            | americanExpress | 370788901763229 | 02       | 2033    | 3876 |
#        And I select Split payment method
#        And I enter split amount as "1" and click Continue
# #        When I enter payment info for new gift card:
# #            | cardType   | cardNumber       | pin |
# #            | giftcard   |6006493880499901379  | 2090|
# #        And  I continue to preview page by clicking on Continue on payment page
#        When I enter payment info for new card:
#            | cardType | cardNumber       | expMonth | expYear | ccv |
#            # | visa            | 4114360123456785 | 03       | 2030    | 111  |
#            | visa     | 4678475330157543 | 03       | 2030    | 737 |
#        And  I continue to preview page by clicking on Continue on payment page
#        Then I expect the review page to be displayed
#        When I click on Place Order
#        Then I land on Thank you page and I see the Order Number
# #        Then Payment information is "American Express XXXXXXXXXXX1347: $" on checkOut Thank you page
# #        Then Payment information is "Visa XXXXXXXXXXXX6785: $" on checkOut Thank you page 
#        Then Payment information is "Visa XXXXXXXXXXXX7543: $" on checkOut Thank you page
#        Then Payment information is "American Express XXXXXXXXXXX3229: $" on checkOut Thank you page
       
# #       Then Payment information is "RH Gift Card XXXXXXXXXXXXXXX1379: $" on checkOut Thank you page
