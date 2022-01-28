@helloWorld @criticalpath @mobile @monitor @smoke
Feature:
    As a developer
    I want to be able to test the swatch order flow

    Background:

    Scenario: Open Swatch page
        Given I open the site "/swatch/order.jsp" on mobile
        Then I dismiss the membership popup if exists
        Then I dismiss the swatch welcome popup if exists
        Then I scroll on swatch mobile with "10000"

    Scenario: Select Swatch option
        Given Swatch options available
        When I select a swatch "sku69310136_BLWE"
        Then I verify the selected swatch "sku69310136_BLWE" should be checked

    Scenario: Order Swatches
        Given I click on order swatches
        When I enter the following data in the shipping form on mobile:
            |firstName | lastName | email           | phone        | address            | address2 | city    | state | zip   | country |
            |John      | Willi    | john@email.com  | 111-111-1111 | 1300 N Dearborn St |          | Chicago | IL    | 60610 | US      |
        Then I click on place order
        Then I wait on loading cursor
        Then I see thank you popup shows up and I close thank you popup



