@smoke @criticalpath
Feature:
   As a developer
   I want to be able to test add to cart on all the brands

Background:
   Given I visit the cart

    Scenario Outline: Cart verify items can be added
        Given I open the pdp "<product_id>"
        Given I prepare options for product "<product_id>" and sku "<full_sku_id>"
        When  I select the options and add quantity "<qty>" to cart
        Then I expect the cart to have a "<title>" with quantity "<qty>"

        Examples:
            |product_id  | title                                       | full_sku_id        | qty |
            |prod2020027 | 802-GRAM TURKISH TOWEL COLLECTION           | 17050042 WHT      | 1   |
            |prod10810111 |LAMBETH HEXAGONAL KNOB                         |10038761 CHR   | 1 |


    Scenario Outline: Cart verify items can be added
        Given I open the pdp "<product_id>" by "<brand>" brand
        Given I prepare options for product "<product_id>" and sku "<full_sku_id>"
        When  I select the options and add quantity "<qty>" to cart
        Then I expect the cart to have a "<title>" with quantity "<qty>"

    Examples:
        |product_id                     | title                                 | full_sku_id             | qty | brand  |
        |prod10810133                   | LAMBETH KNURLED KNOB                  |   10035093 CHR          | 1   | mo     |
        |rhbc_prod960400                | LARKIN FAUX MONGOLIAN LAMB DESK CHAIR |  112833 IVOR            | 1   | bc     |
        |rhtn_prod104197                | WASHED COTTON GAUZE SHEET SET          |  601060 CHAR TWIN       | 1   | tn     |
