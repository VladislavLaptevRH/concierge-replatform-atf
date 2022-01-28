@mobile
Feature:
    As a developer
    I want to be able to test the swatch order flow

    Background:

    Scenario: Open Swatch page
        Given I open the site "/swatch/order.jsp" on mobile
        Then I dismiss the membership popup if exists
        Then I dismiss the swatch welcome popup if exists
        Then I scroll on swatch mobile with "700"

    Scenario: Select Swatch option
        Given Swatch options available
        When I select "51" swatch options
        Then I verify the selected "50" swatches should be checked
        Then I see a popup with message "YOU HAVE REACHED YOUR LIMIT OF 50 SWATCHES"

