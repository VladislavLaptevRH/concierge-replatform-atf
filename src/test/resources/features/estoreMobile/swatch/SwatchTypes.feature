@mobile
Feature:
    As a developer
    I want to be able to select swatch type and navigate to respetive page

    Scenario Outline: Open Swatch page
        Given I open the site "/swatch/order.jsp" on mobile
        Then I dismiss the membership popup if exists
        Then I dismiss the swatch welcome popup if exists
        When I select "<type_swatch>" type of swatch on mobile
        Then I scroll on swatch mobile with "10000"
        Then I verify swarch options are available
        When I select a swatch "<sku_id>"
        Then I verify the selected swatch "<sku_id>" should be checked

        Examples:
        |type_swatch|sku_id|
        |fabric|sku66010366_BWWT|
        |leather|sku66010366_BMSM|
         
