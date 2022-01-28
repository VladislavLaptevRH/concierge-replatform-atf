@smoke @criticalpath
Feature:
    As a user
    I can view On Sale items and change location and able to add item to cart

    Background:
        Given I have a new session

    Scenario Outline: PDP displays OnSale link and OnSale Items
        Given I open the pdp "<product_id>"
        When I scroll to link "800"
        When I click on "Sale" link on PDP page
        When I enter zip code "<zipcode>" for "<country>" country and click on Confirm button
        Then I see a list of available "On-Sale" Items

        Examples:
            |product_id  | title        | full_sku_id |zipcode|country|
            |prod1166005 | LUGARNO PULL | 24120459 BRSS |98947 |US|
            |prod2510493 |CARMEL SOFA   |64410339 IRON  |98101|US|
            |prod17740355|LINNEA HAND-KNOTTED WOOL RUG|10012322 CBSI|98101|US|
            |prod1159311 |BELGIAN TEXTURED LINEN DRAPERY|13050018 CHAR|12345|Canada|
            |prod2020027 |802-GRAM TURKISH TOWEL COLLECTION|17050042 WHT|M4B1B4|Canada|
            |prod17860077|ORGANIC ITALIAN 600 THREAD-COUNT SATEEN SHAM|10011359 FOG|M4B1B4|Canada|
    

    Scenario Outline: OnSale modal allows to change location      
        Given I open the pdp "<product_id>"
        When I scroll to link "800"
        When I click on "Sale" link on PDP page
        When I enter zip code "<zipcode1>" for "<country1>" country and click on Confirm button
        Then I see a list of available "On-Sale" Items       
        When I click on "Change location" button
        When I enter zip code "<zipcode2>" for "<country2>" country and click on Confirm button  
        Then I see a list of available "On-Sale" Items    

        Examples:
           |product_id | title | full_sku_id  |zipcode1|zipcode2|country1|country2|
           |prod1166005 | LUGARNO PULL | 24120459 BRSS  | 98101|M4B 1B4|US|Canada|
           |prod2510493 |CARMEL SOFA   |64410339 IRON   |M4B 1B4|98101|Canada|US|

    Scenario Outline: OnSale modal allows add to cart       
        Given I open the pdp "<product_id>"
        When I scroll to link "800"
        When I click on "Sale" link on PDP page
        When I enter zip code "<zipcode>" for "<country>" country and click on Confirm button      
        When I select quantity "1" for "On-Sale" Items
        When I click on "Add to Cart" button
        When I click on "View Cart" link on PDP page
        Then I see item in cart with same name as on PDP

        Examples:
            |product_id  | title        | full_sku_id |zipcode|country|
            |prod1166005 | LUGARNO PULL | 24120459 BRSS |98947 |US|
            |prod2020027 |802-GRAM TURKISH TOWEL COLLECTION|17050042 WHT|M4B1B4|Canada|