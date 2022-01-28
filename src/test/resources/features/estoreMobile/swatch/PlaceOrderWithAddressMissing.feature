@mobile
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
        When I select "3" swatch options
        Then I verify the selected "3" swatches should be checked

    Scenario: Order Swatches
        Given I click on order swatches
        Then I click on place order
        Then I see error message for each address field
