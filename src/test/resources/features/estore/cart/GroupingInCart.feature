@smoke @criticalpath 
Feature:
    As a developer
    I want to be able to see option to consolidate item in cart when cart contains grouping items


Background:
   Given I visit the cart
   Given I set a cookie "pc" with the content "94111"

Scenario: User can select Grouping option in Cart
   Given I am on the site as a guest user
   And I have the following items in the cart:
        | product_id  | title                                              | full_sku_id   | qty |
        # | prod9300314 | GRAYDON SHAGREEN SHELTER BED                       | 95950245 GRY | 2   |
        # | prod8550692 | AIRELOOM® BRECKENRIDGE STREAMLINE™ LIFT™ MATTRESS  | 95550690 NONE | 2   |
        # | prod18910167| CAYDEN CAMPAIGN SINGLE EXTRA-WIDE VANITY BASE WITH CORNER BRACKETS|10036856 WGRY | 2   | 
          |prod19350851|CAYDEN CAMPAIGN PANEL BED WITH CORNER BRACKETS & FOOTBOARD|10031798 WGRY |1|
          |prod19350847 |CAYDEN CAMPAIGN PANEL BED WITH CORNER BRACKETS   |10031801 WGRY|1|
   When I visit the cart
   Then I verify grouping option is displayed and I select it 
   Then I verify grouping option is selected
