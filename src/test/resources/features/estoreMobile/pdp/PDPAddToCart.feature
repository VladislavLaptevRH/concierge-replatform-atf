@criticalpath @monitor @mobile
Feature:
    As a user
    I want to verify pricing and Add To cart functionality regarding the sku I have selected.
    Background:
        Given I have a new session
    Scenario Outline: PDP displays price and Add To Cart Button should be enabled after selecting the options for Product
        Given I open the pdp "<product_id>" on mobile
        #When I verify Add To Cart Button is disabled on mobile
        When I click on the element if exist ".sticky-banner-dismiss"
        Given I prepare options for product "<product_id>" and sku "<fullSku_Id>" for "<postalCode>"
        # When I scroll on mobile
        When I select the options and quantity "<qty>" on mobile
        Then I verify Pricing and Add to Cart after selecting the options on mobile

        Examples:
            |product_id | title | fullSku_Id |  postalCode |qty|
            |prod1677187 | Provence Fountain | 42600037 GS | postalCode |2|
            |prod11600084 | Rectangular Column Table Lamp  | 68270648 LBBM   | postalCode |1|
            |prod19310359| T-Brace Collection Wood Swatches|  10024482 WGRY| postalCode |3|

    Scenario Outline: PDP displays price and Add To Cart Button should be enabled after selecting the options for Product
        Given I open the pdp "<product_id>" on mobile by "<brand>" brand
        When I click on the element if exist ".sticky-banner-dismiss"
        Given I prepare options for product "<product_id>" and sku "<fullSku_Id>" for "<postalCode>"
        When I select the options and quantity "<qty>" on mobile
        Then I verify Pricing and Add to Cart after selecting the options on mobile

        Examples:
            |product_id | title | fullSku_Id |  postalCode | brand |qty|
            |prod10810133 | LAMBETH KNURLED KNOB| 10035093 CHR | postalCode | mo |2|
            |rhbc_prod961038  | LARKIN FAUX MONGOLIAN LAMB DESK CHAIR| 112833 IVOR  | postalCode | bc |3|
            |rhtn_prod104197  | WASHED COTTON GAUZE SHEET SET| 601060 CHAR TWIN  | postalCode | tn |4|
