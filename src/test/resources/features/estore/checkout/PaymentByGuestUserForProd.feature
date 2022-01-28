@criticalpath @checkout @payment @smoke
Feature:
    I want to test the payment page form for an anonymous user

    Background:
        Given I have a new session

    Scenario: Guest user can apply single payment to order
        Given I am on the site as a guest user
        And I have the following items in the cart:
            |product_id   | title                                   | full_sku_id     | qty |
            |prod11600084 | Rectangular Column Table Lamp           | 68270648 LBBM   | 2   |
            |prod15970044 | Salvage Wood Trestle Round Dining Table | 62870008 NATL   | 1   |
            |prod2020027 	|802-GRAM TURKISH TOWEL COLLECTION				| 17050042 WHT    | 1   |
        And  I visit the cart and proceed to shipping
        And  I continue as guest
        And  I enter shipping address:
            |first   | last | address1        | address2 |city     | state | country |postal | phone     |
            |Cucumber| User | 721 Pine Street |          | Seattle | WA    | US      | 98101 | 5555555555|
        And  I select billing same as shipping
        And  I enter email address "test@rh.com" on the shipping page
        And  I proceed to payment
        When I enter payment information for prod
        And  I continue to preview page by clicking on Continue on payment page
        Then I expect the review page to be displayed

