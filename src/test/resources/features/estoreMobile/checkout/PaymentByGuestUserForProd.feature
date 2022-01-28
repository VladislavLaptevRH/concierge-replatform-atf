@smoke @criticalpath @checkout @payment @mobile @monitor
Feature:

    I want to add products to cart, checkout and be able to review order confirmation page
    I want to test the payment page form for an anonymous user

    # Background:
    #     Given I have a new session

Scenario Outline: Guest user can add different product to cart
        Given I am on the site and click on hamburger menu to verify guest user on mobile
        Given I open the pdp "<product_id>" on mobile
        Given I prepare options for product "<product_id>" and sku "<full_sku_id>" for "<postalCode>" on mobile
        When I select the options and add quantity "<qty>" to cart on mobile

        Examples:
          |product_id   | title                                   | full_sku_id     | qty |postalCode |
          |prod11600084 | Rectangular Column Table Lamp           | 68270648 LBBM   | 2   |postalCode |
            # |prod15970044 | Salvage Wood Trestle Round Dining Table | 62870008 NATL   | 1   |postalCode |
          | prod10810132  | LAMBETH KNURLED KNOB                 | 10035093 CHR   | 4   |postalCode |



    Scenario: Guest user can apply single payment card to order on mobile
        # Given I am on the site and click on hamburger menu to verify guest user on mobile
        # And I have the following items in the cart on mobile:
        #     |product_id   | title                                   | full_sku_id     | qty |
        #     |prod11600084 | Rectangular Column Table Lamp           | 68270648 LBBM   | 2   |
        #     |prod15970044 | Salvage Wood Trestle Round Dining Table | 62870008 NATL   | 1   |
        #     | prod10810132  | LAMBETH KNURLED KNOB                 | 10035093 CHR   | 4   |
        And I visit the cart and proceed to shipping on mobile
        # When I scroll on mobile
        And I continue as guest on mobile
        And I enter shipping address on mobile:
            |first   | last | address1        | address2 |city     | state | country |postal | phone     |
            |Cucumber| User | 721 Pine Street |          | Seattle | WA    | US      | 98101 | 5555555555|
        And  I select billing same as shipping on mobile
        And  I enter email address "test@rh.com" on the shipping page on mobile
        # When I scroll on mobile with "2600"
        And  I proceed to payment on mobile
        # When I scroll on mobile
        When I enter payment information for prod on mobile
        # When I scroll on mobile
        And  I continue to preview page by clicking on Continue on payment page on mobile
        Then I expect the review page to be displayed on mobile

