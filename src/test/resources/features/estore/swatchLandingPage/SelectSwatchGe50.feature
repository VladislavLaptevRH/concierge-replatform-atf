Feature:
    As a developer
    I want to be able to test the swatch order flow

    Scenario: Open Swatch page
        Given I open the site "/swatch/order.jsp"
        And I scroll on swatch with "700"

    Scenario: Select Swatch option
        Given Swatch options available on desktop
        When I select "51" swatch options from swatches
        Then I verify the selected "50" swatch options should be checked
        Then I see message "YOU HAVE REACHED YOUR LIMIT OF 50 SWATCHES"