@criticalpath
Feature:
    As a user
    I want to test the currency of the product according to the change of the zip code for mobile
    Background:
        Given I have a new session
  
    Scenario Outline: PDP displays correct currency according to US zip codes
        Given I open the pdp "<product_id>" on mobile by "<brand>" brand
        When I click on availability, delivery & returns and click on check your zip code and enter "<zipcode>" on mobile for "<product_id>" 
        Then I verify currency for respective "<country>" on "PDP" page on mobile

        Examples:
            |product_id   | title                         | full_sku_id   | zipcode | country |brand|
            |prod2020027 | 802-GRAM TURKISH TOWEL COLLECTION | 17050042 WHT | 98947   | US      |rh|
            |prod10810133 | LAMBETH KNURLED KNOB          | 10035093 CHR | 98101    | US      |mo|
            |rhbc_prod961038  | LARKIN FAUX MONGOLIAN LAMB DESK CHAIR| 112833 IVOR  | 98101    | US  | bc |
            |rhtn_prod106612|RUFFLED WASHED COTTON GAUZE SHEET SET|602710 WHT TWIN  |   98101    | US   | tn |


    Scenario Outline: PDP displays correct currency according to Canada zip codes
        Given I open the pdp "<product_id>" on mobile by "<brand>" brand
        When I click on availability, delivery & returns and click on check your zip code and enter "<zipcode>" on mobile for "<product_id>"
        Then I can see the "cad_currency_message" message
        When I click on OK button on mobile
        Then I verify currency for respective "<country>" on "PDP" page on mobile

        Examples:
            | product_id   | title                         | full_sku_id   | zipcode | country |brand|
            |prod2020027 | 802-GRAM TURKISH TOWEL COLLECTION | 17050042 WHT| M4B 1B4 | Canada  |rh|
            |prod10810133 | LAMBETH KNURLED KNOB          | 10035093 CHR |M4B 1B4 | Canada       |mo| 
            |rhbc_prod961038  | LARKIN FAUX MONGOLIAN LAMB DESK CHAIR| 112833 IVOR  | M4B 1B4 | Canada | bc |
            |rhtn_prod106612|RUFFLED WASHED COTTON GAUZE SHEET SET|602710 WHT TWIN|  M4B 1B4 | Canada | tn |
