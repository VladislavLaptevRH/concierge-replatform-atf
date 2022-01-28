@criticalpath @smoke
Feature:  
   As a developer 
   I want to be able to verify the cart correctly handles totals for an order with free ship items only. 

Background:
   Given I visit the cart
   Given I set a cookie "pc" with the content "94111"

Scenario Outline: Cart total shows free shipping
   Given I open the pdp "<product_id>" 
   Given I prepare options for product "<product_id>" and sku "<full_sku_id>"
   When  I select the options and add quantity "<qty>" to cart
   Then  I expect the cart subtotal to be the sum of item totals
   Then  I expect the cart to display "no" shipping charge
   Then  I expect the cart totals to be correct

Examples:
    |product_id  | title                       | full_sku_id    | qty |
    |prod19660388 | ULTIMATE FAUX FUR THROW  | 10002516 LION    | 3   |

