@smoke @criticalpath 
Feature:  
   As a developer 
   I want to be able to test the handles all charges correction  

Background:
   Given I visit the cart
   Given I set a cookie "pc" with the content "94111"

#
Scenario Outline: Cart total displays all fees
   Given I open the pdp "<product_id>" 
   Given I prepare options for product "<product_id>" and sku "<full_sku_id>"
   When  I select the options and add quantity "<qty>" to cart
   Then  I expect the cart subtotal to be the sum of item totals
   Then  I expect the cart to display "<charge>" shipping charge
   Then  I expect the cart totals to be correct
  
Examples:
   |product_id   | title                                   			| full_sku_id     	| qty | charge       |
   |prod11600084 | Rectangular Column Table Lamp           			| 68270648 LBBM   	| 9   | standard     |
   |prod15970044 | Salvage Wood Trestle Round Dining Table 			| 62870008 NATL   	| 2   | UFD          |
   |prod1676346  | Greenwich Urn                    			        | 42850301 AS  	    | 1   | surcharge    |
   |prod19660388 | ULTIMATE FAUX FUR THROW                           | 10002516 LION     | 3   | no           |
#  |prod8550689  | AIRELOOM ALTA LUXETOP LIFT MATTRESS     			| 95550699 NONE   	| 1   | mattress fee |


