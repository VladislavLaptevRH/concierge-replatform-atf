@criticalpath @checkout @payment @smoke
Feature:
    I want to test the payment page form for an anonymous user

    Background:
        Given I have a new session

    Scenario Outline: Guest user can apply single payment to order
        Given I am on the site as a guest user
        Given I open the pdp "<productId>"
        When I vertically scroll "<scrollValue>" to the line item
        Given I select "<optionType1>" , "<productId>" for "<optionValue1>"
        Given I select "<optionType2>" , "<productId>" for "<optionValue2>"
        Given I select "<optionType3>" , "<productId>" for "<optionValue3>"
        Given I select "<optionType4>" , "<productId>" for "<optionValue4>"
        Given I select "<optionType5>" , "<productId>" for "<optionValue5>"
        #Given I select "<qty>" quantity for "<productId>"
        Then I verify "<fullSku_Id>" fullSkuId on PDP page
        When I click on the AddToCart button
        Then I click on the View Cart button
        And  I visit the cart and proceed to shipping
        And  I continue as guest
        And  I enter shipping address:
            | first    | last | address1        | address2 | city    | state | country | postal | phone      |
            | Cucumber | User | 2811 Judith Dr  |          | Bellmore| NY    | US      | 11710  | 5555555555 |
        And  I select billing same as shipping
        And  I enter email address "test@rh.com" on the shipping page
        And  I proceed to payment
        When I enter payment info for new card:
            | cardType   | cardNumber   | expMonth   | expYear   | ccv   |
            | visa | 4678475330157543 | 03 | 2030 | 737 |
        And  I continue to preview page by clicking on Continue on payment page
        Then I expect the review page to be displayed
        When I click on Place Order
        Then I land on Thank you page and I see the Order Number

        Examples:
            |productId    | optionType1 | optionValue1 |  optionType2 | optionValue2| optionType3| optionValue3| optionType4| optionValue4| optionType5| optionValue5| qty|fullSku_Id    | scrollValue|
            |prod15080332 | Depth       | 72600012     |  Finish      | 72800012    | Fabric     | 18800006    | Color      | 6800006     | Size       | 34900039    | 2  |38990243 VNGR | 800        |

