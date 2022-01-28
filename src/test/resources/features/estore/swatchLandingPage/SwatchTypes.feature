Feature:
    As a developer
    I want to be able to select swatch type and navigate to respetive page

    Scenario Outline: Open Swatch page
        Given I open the site "/swatch/order.jsp"
        When I select "<type_swatch>" type of swatch
        Then I scroll on swatch with "10000"
        Then I verify swatch options are available on desktop
        When I select a swatch of sku "<sku_id>"
        Then I verify the selected swatch option "<sku_id>" should be checked

        Examples:
        |type_swatch|sku_id|
        |leather|sku66010366_BMSM|
        |fabric|sku66010366_BWWT|
        

