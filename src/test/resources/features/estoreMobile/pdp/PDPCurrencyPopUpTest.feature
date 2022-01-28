@criticalpath
Feature:
    As a user
    I want to test the currency pop up according to the change of the zip code for mobile

    Background:
        Given I have a new session

    Scenario Outline: PDP displays an error message for an invalid postal code format
        Given I open the pdp "<product_id>" on mobile
        When I click on availability, delivery & returns and click on check your zip code and enter "<zipcode>" on mobile for "<product_id>"
        Then I should see the "<invalid-format-message>" message

        Examples:
            |product_id    | title                         | zipcode          | invalid-format-message     |
            | prod11600084 | Rectangular Column Table Lamp | invalid zip code | Invalid Postal Code Format |

    Scenario Outline: PDP displays a notification message about the currency change to Canada and US
        Given I open the pdp "<product_id>" on mobile by "<brand>" brand
        When I click on availability, delivery & returns and click on check your zip code and enter "<zipcode_us>" on mobile for "<product_id>"
        Then I verify currency for respective "US" on "PDP" page on mobile
        When I click on change your zip code and enter "<zipcode_cad>" on mobile  
        Then I can see the "cad_currency_message" message
        When I click on OK button on mobile
        And I verify currency for respective "Canada" on "PDP" page on mobile
        When I click on change your zip code and enter "<zipcode_us>" on mobile
        Then I can see the "us_currency_message" message
        When I click on OK button on mobile
        And I verify currency for respective "US" on "PDP" page on mobile

        Examples:
            |product_id   | title                         | full_sku_id   | zipcode_us | zipcode_cad |brand|
            |prod2020027 | 802-GRAM TURKISH TOWEL COLLECTION | 17050042 WHT| 98101      | M4B 1B4     |rh|
            |prod10810133 | LAMBETH KNURLED KNOB          | 10035093 CHR   |98101       | M4B 1B4     |mo|  
            |rhbc_prod961038  | LARKIN FAUX MONGOLIAN LAMB DESK CHAIR| 112833 IVOR  | 98101 | M4B 1B4 | bc |
            |rhtn_prod106612|RUFFLED WASHED COTTON GAUZE SHEET SET|602710 WHT TWIN  | 98101  | M4B 1B4   | tn |
    