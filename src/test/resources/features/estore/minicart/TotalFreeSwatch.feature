@smoke
Feature:
   As a developer 
   I want to be able to verify the minicart correctly handles totals for an order with free ship $0 swatch.  

Background:
   Given I open the url "/my-account/sign-in.jsp"
   Given I set a cookie "pc" with the content "94111"

Scenario Outline: Minicart total is zero for free swatch
   Given I open the pdp "<product_id>" 
   Given I prepare options for product "<product_id>" and sku "<full_sku_id>"
   When  I select the options and add quantity "<qty>" to cart
   Then  I expect the minicart subtotal to be zero
   Then  I expect the minicart to display "no" shipping charge
   Then  I expect the minicart totals to be correct

Examples:
    |product_id   | title                      | full_sku_id     | qty | 
    |prod30011 | BELGIAN TEXTURED LINEN SWATCH | 20050498 CHAR   | 1   | 

