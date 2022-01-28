@criticalpath @smoke
Feature:  
   As a developer 
   I want to be able to verify the minicart correctly handles totals for an order with items with Surcharge. 

Background:
   Given I open the url "/my-account/sign-in.jsp"
   Given I set a cookie "pc" with the content "94111"

Scenario Outline: Minicart total shows additional shipping surcharge
   Given I open the pdp "<product_id>" 
   Given I prepare options for product "<product_id>" and sku "<full_sku_id>"
   When  I select the options and add quantity "<qty>" to cart
   Then  I expect the minicart subtotal to be the sum of item totals
   Then  I expect the minicart to display "Surcharge" shipping charge
   Then  I expect the minicart totals to be correct

Examples:
    |product_id   | title               | full_sku_id     | qty | 
    |prod1677198  | San Pietro Fountain | 42600040 STON   | 1   | 
