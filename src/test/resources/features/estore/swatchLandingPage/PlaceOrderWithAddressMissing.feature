Feature:
    As a developer
    I want to be able to test the swatch order flow

    Scenario: Open Swatch page
        Given I open the site "/swatch/order.jsp"
        And I scroll on swatch with "10000"

    Scenario: Select Swatch option
        Given Swatch options available on desktop
        When I select "3" swatch options from swatches
        Then I verify the selected "3" swatch options should be checked

    Scenario: Order Swatches
        Given I click on order swatches button
        Then I click on place order button
        Then I see error message for each address field in shipping form
