@smoke @criticalpath
Feature:
    As a user
    I can view In stock items and change location and able to add item to cart

    Background:
        Given I have a new session

    Scenario Outline: PDP displays Instock link and Instock Items
        Given I open the pdp "<product_id>"
        When I scroll to link "800"
        When I click on "In-Stock" link on PDP page
        When I enter zip code "<zipcode>" for "<country>" country and click on Confirm button
        Then I see a list of available "In-stock" Items

        Examples:
            |product_id | title | full_sku_id |zipcode|country|
            |prod20480291 | AERO WOOD RECTANGULAR DINING TABLE  | 10038149 LGBP  |98947 |US|
            |prod21100111 |CAYDEN CAMPAIGN DOUBLE VANITY BASE|10062221 WGRY|98101|US|
            |prod17810160|ITALIAN HOTEL TRIPLE SATIN STITCH SATEEN DUVET COVER|10011335 ASH|12345|US|
            |prod610053  |DELUXE RUG PAD    |15300009 NONE|98101|US|
            |prod1159311 |BELGIAN TEXTURED LINEN DRAPERY|13050018 CHAR|12345|US|
            |prod10810132|LAMBETH KNURLED KNOB|10035093 CHR|M4B 1B4|Canada|
            |prod20530102|PALLADIUM PANELED MIRROR|10060878 GOLD|M1R 0E9|Canada|
            |prod6371042|CLOUD MODULAR CORNER CHAIR| 50400843 CLMR|G1A 0A2|Canada|
            |prod2020027|802-GRAM TURKISH TOWEL COLLECTION|17050042 WHT|M4B1B4|Canada|
            |prod13270090|AIRELOOM® FOUNDATIONS|10011452 NONE|M1R 0E9|Canada|


    Scenario Outline: Instock modal allows to change location 
        Given I open the pdp "<product_id>"
        When I scroll to link "800"
        When I click on "In-Stock" link on PDP page
        When I enter zip code "<zipcode1>" for "<country1>" country and click on Confirm button
        Then I see a list of available "In-stock" Items       
        When I click on "Change location" button
        When I enter zip code "<zipcode2>" for "<country2>" country and click on Confirm button
        Then I see a list of available "In-stock" Items

        Examples:
           |product_id | title | full_sku_id  |zipcode1|zipcode2|country1|country2|
           |prod20480291 | AERO WOOD RECTANGULAR DINING TABLE  | 10038149 LGBP  | 98101|M4B 1B4|US|Canada|
           |prod21100111 |CAYDEN CAMPAIGN DOUBLE VANITY BASE|10062221 WGRY |M4B 1B4|98101|Canada|US|

    Scenario Outline: Instock modal allows add to cart  
        Given I open the pdp "<product_id>"
        When I scroll to link "800"
        When I click on "In-Stock" link on PDP page
        When I enter zip code "<zipcode>" for "<country>" country and click on Confirm button           
        When I select quantity "1" for "In-Stock" Items
        When I click on "Add to Cart" button
        When I click on "View Cart" link on PDP page
        Then I see item in cart with same name as on PDP

        Examples:
            |product_id | title | full_sku_id |zipcode|country|
            |prod20480291 | AERO WOOD RECTANGULAR DINING TABLE  | 10038149 LGBP  |98947 |US|
            |prod10810132|LAMBETH KNURLED KNOB|10035093 CHR|M4B 1B4|Canada|
    