@criticalpath @smoke
Feature: 
   As a developer 
   I want to be able to verify the minicart correctly handles totals for an order with free ship items only.

  Background: 
    Given I open the url "/my-account/sign-in.jsp"
    Given I set a cookie "pc" with the content "94111"

Scenario Outline: Minicart total shows free shipping
   Given I open the pdp "<product_id>" 
   Given I prepare options for product "<product_id>" and sku "<full_sku_id>"
   When  I select the options and add quantity "<qty>" to cart
   Then  I expect the minicart subtotal to be the sum of item totals
   Then  I expect the minicart to display "no" shipping charge
   Then  I expect the minicart totals to be correct

Examples:
    |product_id   | title                                        | full_sku_id      | qty |
    |prod19660330 | TETON MERINO WOOL GEO PILLOW COVER - SQUARE  | 10036059 BKNA    | 2   |
