Feature:
    As a developer
    I want to be able to test the swatch landing page

    Scenario: Open Swatch page
        Given I open the site "/swatch/order.jsp"
        And I scroll on swatch with "10000"

    Scenario: Select Swatch option
        Given Swatch options available on desktop
        When I select "3" swatch options from swatches
        Then I verify the selected "3" swatch options should be checked

    Scenario: Order Swatches
        Given I click on order swatches button
        When I enter the following data in the shipping form on desktop:
            |firstName | lastName | email           | phone        | address            | address2 | city    | state | zip   | country |
            |John      | Willi    | john@email.com  | 111-111-1111 | 1300 N Dearborn St |          | Chicago | IL    | 60610 | US      |
        Then I click on place order button
        Then I wait on a loading cursor
        Then I see a thank you popup shows up and I close thank you popup
