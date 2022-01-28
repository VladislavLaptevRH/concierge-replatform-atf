@criticalpath @smoke
Feature:
    As a contract user
    I want to be able to place an order for products

Background:
         Given I open the "Contract" Sign In page
         When I enter "Contract" credentials for "stagingUser"

Scenario Outline: Contract user successfully placing an order
        And I have the following items in the cart:
            | product_id   | full_sku_id   | qty |
            |prod1214115  |17210506 WHT   | 2 |
            |prod14280120 |17050042 CERU  | 3 |
            |prod8550689  |10011460 NONE  |1|   
            |prod10810111 |10038761 CHR   | 1 |
        And  I visit the cart    
        Then I verify the "Contract" price is displayed on "Cart" page    
        And  I proceed to shipping
        And  I enter shipping address:
            | first    | last | address1        | address2 | city    | state | country | postal | phone      |
            | Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | 98101  | 5555555555 |
        When I select billing same as shipping
        Then I verify email address is present on the shipping page
        And  I proceed to payment
        When I enter payment info for new card:
            | cardType   | cardNumber   | expMonth   | expYear   | ccv   |
            | <cardType> | <cardNumber> | <expMonth> | <expYear> | <ccv> |
        And  I continue to preview page by clicking on Continue on payment page
        Then I verify the "Contract" price is displayed on "Order-Review" page
        When I click on Place Order
        Then I land on Thank you page and I see the Order Number
        Then I verify the "Contract" price is displayed on "Thank-You" page
         Examples:
            | cardType        | cardNumber       | expMonth | expYear | ccv  |
            | visa            | 4678475330157543 | 03       | 2030    | 737  |     
    