@smoke @criticalpath 
Feature:  
   As a developer 
   I want to be able to test mini cart shows items i add to it  

Background:
   Given I open the url "/my-account/sign-in.jsp"

Scenario Outline: Minicart verify items can be added
   Given I open the pdp "<product_id>" 
   Given I prepare options for product "<product_id>" and sku "<full_sku_id>"
   When  I select the options and add quantity "<qty>" to cart
   Then  I expect the minicart to have a "<title>" with quantity "<qty>"
   Then  I expect the minicart quantity to be "<count>" 

Examples:
    |product_id  | title                         | full_sku_id     | qty | count |
    |prod7630086 | Cylindrical Column Table Lamp | 68270641 ASIL   | 2   | 2     |
    |prod8760140 | Maxwell Sofa                  | 58840005 BLBK   | 1   | 3     |
    |prod1283065 | LUGARNO KNOB                  | 24120451 PC      | 4   | 7     |
