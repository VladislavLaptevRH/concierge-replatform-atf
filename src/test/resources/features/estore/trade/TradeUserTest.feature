@criticalpath @smoke
Feature:
    As a Trade user
    I want to be able to login to the site. Also,I want to be able to add different types of product to cart. I verify the trade price should be display on PDP and cart page.


Scenario: Trade User Sign In
    Given I open the "Trade" Sign In page
    When I enter "Trade" credentials for "stagingUser"
    Then I expect that I am successfully signed in as "Trade" user

Scenario Outline: Trade user can add item to cart
    When I open the pdp "<product_id>"
    And I prepare options for product "<product_id>" and sku "<full_sku_id>"
    When I select the options and quantity "<qty>"  
    Then I verify the "Trade" price is displayed on "PDP" page
    When I click on Add To Cart button for "<product_id>"
    Then I verify the "Trade" price is displayed on "Cart" page

    Examples:
      |product_id   | full_sku_id   |qty|
      |prod1214115  |17210506 WHT   | 1 |
      |prod9740156  |50400843 CLMR  | 1 |
      |prod14280120 |17050042 CERU  | 1 |
      |prod7410999  |62960718 LGRY  |1  |
      |prod10810111 |10038761 CHR   | 1 |
      |prod10800120 |22260070 ABRS  |1|
      |prod2420980  |10005170 AGCL  | 1 | 
      |prod8550689  |10011460 NONE  |1|   
      |prod190091   |13070073 BLCG  |1| 
      |prod7620020  |68270225 LBBM  |1|
      |prod1676346  |42850301 AS    |1|
      |prod23230023 |10084502 CHCL  |1|
                  
Scenario: Trade User Logout
    Given I open the "Trade" Sign In page
    When I click on Sign out Of my "Trade" Id
    Then I expect that I am not signed in as "Trade" user
