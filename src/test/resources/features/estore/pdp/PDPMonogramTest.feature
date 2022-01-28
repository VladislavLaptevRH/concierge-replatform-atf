@smoke @criticalpath
Feature:
    As a user
    I want to test monogram of the product
    Background:
        Given I have a new session

    Scenario Outline: PDP displays monogram modal
        Given I open the pdp "<product_id>"
        When I scroll to link "800"
        Then I expect that the title is "Animal Hooded Towel - Baby"
        When I click on "Add Monogram" link on PDP page



        Examples:
            | product_id      | link text           | title                | font                  | border              | color       | text |
            | rhbc_prod517005 | Add Monogram for $9 | Monogram Modal Title | Classic Script (CLSC) | Single Initial (YH) | White (WHT) | A    |

    Scenario Outline: Add personalization
        Given I open the pdp "<product_id>"
        When I scroll to link "800"
        When I click on "Add Monogram" link on PDP page
        When I select options "1" for font and color
        When I enter text "RH" on monogram modal
        When I click on Add Monogram button on monogram modal
        Then I see personalization information on "PDP" page

        Examples:
            | product_id      |
            | prod1214115     |

    Scenario Outline: Edit personalization
        Given I open the pdp "<product_id>"
        When I scroll to link "800"
        When I click on "Add Monogram" link on PDP page
        When I select options "1" for font and color
        When I enter text "RH" on monogram modal
        When I click on Add Monogram button on monogram modal
        Then I see personalization information on "PDP" page
        And I click on "Edit" link on PDP page
        When I select options "2" for font and color
        When I enter text "RHT" on monogram modal
        When I click on Add Monogram button on monogram modal
        Then I see personalization information on "PDP" page

        Examples:
            | product_id      |
            | prod1214115     |

    Scenario Outline: Add Personalized item to CART
        Given I open the pdp "<product_id>"
        And I prepare options for product "<product_id>" and sku "<full_sku_id>"
        When I select the options
        When I scroll to link "800"
        When I click on "Add Monogram" link on PDP page
        When I select options "1" for font and color
        When I enter text "RH" on monogram modal
        When I click on Add Monogram button on monogram modal
        Then I see personalization information on "PDP" page
        And I click on "Add to Cart" link on PDP page
        When I click on "View Cart" link on PDP page
        Then I see personalization information on "Cart" page

        Examples:
            | product_id      |full_sku_id     |
            | prod1214115     | 17210524 DUNE  |

    Scenario Outline: Purchase Personalized item (verify Order review and Thank You pages)
        Given I open the pdp "<product_id>"
        And I prepare options for product "<product_id>" and sku "<full_sku_id>"
        When I select the options
        When I scroll to link "800"
        When I click on "Add Monogram" link on PDP page
        When I select options "1" for font and color
        When I enter text "RH" on monogram modal
        When I click on Add Monogram button on monogram modal
        Then I see personalization information on "PDP" page
        And I click on "Add to Cart" link on PDP page
        When I click on "View Cart" link on PDP page
        Then I see personalization information on "Cart" page
        And  I visit the cart and proceed to shipping
        And  I continue as guest
        And  I enter shipping address:
            |first   | last | address1        | address2 |city     | state | country |postal | phone     |
            |Cucumber| User | 721 Pine Street |          | Seattle | WA    | US      | 98101 | 5555555555|
        And  I select billing same as shipping
        And  I enter email address "test@rh.com" on the shipping page
        And  I proceed to payment
        When I enter payment info for new card:
            | cardType   | cardNumber       | expMonth | expYear | ccv |
            | visa            | 4678475330157543 | 03       | 2030    | 737  |
        And  I continue to preview page by clicking on Continue on payment page
        When I see personalization information on "ReviewOrder" page
        When I click on Place Order
        Then I land on Thank you page and I see the Order Number


        Examples:
            | product_id      |full_sku_id     |
            | prod1214115     |17210506 DUNE   |


