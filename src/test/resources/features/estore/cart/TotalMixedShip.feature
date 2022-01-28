@criticalpath @smoke
Feature:  
   As a developer 
   I want to be able to verify the cart correctly handles UFD and standard shipping totals on the same order

Background:
   Given I visit the cart
   Given I set a cookie "pc" with the content "94111"

#
Scenario Outline: Cart total shows standard and UFD shipping charges
   Given I open the pdp "<product_id>" 
   Given I prepare options for product "<product_id>" and sku "<full_sku_id>"
   When  I select the options and add quantity "<qty>" to cart
   Then  I expect the cart subtotal to be the sum of item totals
   Then  I expect the cart to display "<charge>" shipping charge
   Then  I expect the cart totals to be correct
  
Examples:
    |product_id   | title                                   | full_sku_id     | qty | charge   |
    |prod11600084 | Rectangular Column Table Lamp           | 68270648 LBBM   | 1   | standard |
    |prod15970044 | Salvage Wood Trestle Round Dining Table | 62870008 NATL   | 1   | both     |
   
