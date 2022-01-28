@smoke @criticalpath
Feature:
    As a user
    I want to test currency of the product according to change of the zipcode
    Background:
        Given I have a new session

    Scenario Outline: PDP displays correct currency according to zipcode changes
        Given I open the pdp "<product_id>"
        When I scroll to link "800"
        When I click on check your zip code and enter the zipcode "<zipcode>" for "<country>"
        Then I verify currency for respective "<country>" on "PDP" page

        Examples:
            |product_id | title | full_sku_id |zipcode|country|
            #|prod11600084 | Rectangular Column Table Lamp  | 68270648 LBBM   |98947| US|
            #|prod11600084 | Rectangular Column Table Lamp  | 68270648 LBBM   |M4B 1B4| Canada|
            #|prod14880454| ASPEN COLLECTION WOOD SWATCH - 6" SQ.|  61790992 GREY| 98947| US|
            #|prod14880454| ASPEN COLLECTION WOOD SWATCH - 6" SQ.|  61790992 GREY| M4B 1B4| Canada|
            |prod15970044 |Salvaged Wood Trestle Round Dining Table | 62870008 NATL   |98947| US|
            |prod15970044 |Salvaged Wood Trestle Round Dining Table | 62870008 NATL   | M4B 1B4| Canada|
