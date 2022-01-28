@criticalpath @smoke
Feature:  
   As a developer 
   I want to be able to verify the cart correctly handles totals for an order with items with Surcharge. 

Background:
   Given I visit the cart
   Given I set a cookie "pc" with the content "94111"

Scenario Outline: Cart total shows additional shipping surcharge
   Given I open the pdp "<product_id>" 
   Given I prepare options for product "<product_id>" and sku "<full_sku_id>"
   When  I select the options and add quantity "<qty>" to cart
   Then  I expect the cart subtotal to be the sum of item totals
   Then  I expect the cart to display "Surcharge" shipping charge
   Then  I expect the cart totals to be correct

Examples:
    |product_id  | title               | full_sku_id     | qty | 
    |prod1676346 | Greenwich Urn | 42850301 AS      | 1   |
