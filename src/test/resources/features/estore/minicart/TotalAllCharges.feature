@smoke @criticalpath 
Feature:  
   As a developer 
   I want to be able to verify the minicart correctly handles UFD, standard, surcharge, and mattress fee shipping totals on the same order

Background:
   Given I open the url "/my-account/sign-in.jsp"
   Given I set a cookie "pc" with the content "94111"

#
Scenario Outline: Minicart total displays all fees
   Given I open the pdp "<product_id>" 
   Given I prepare options for product "<product_id>" and sku "<full_sku_id>"
   When  I select the options and add quantity "<qty>" to cart
   Then  I expect the minicart subtotal to be the sum of item totals
   Then  I expect the minicart to display "<charge>" shipping charge
   Then  I expect the minicart totals to be correct
  
 Examples:
   |product_id   	| title                                   			| full_sku_id     | qty | charge	    |
   |prod19660330    | TETON MERINO WOOL GEO PILLOW COVER - SQUARE       | 10036059 BKNA   | 1   | no 		    |
   |prod7630085 	|CYLINDRICAL COLUMN METAL TABLE LAMP     		    | 68270641 BRZ    | 2   | standard    	|
   |prod15970044 	|Salvage Wood Trestle Round Dining Table 		    | 62870008 NATL   | 3   | UFD		 	|
   |prod1677198 	|San Pietro Fountain 							    | 42600040 STON   | 4   | surcharge	    |
   |prod8550689     |AIRELOOM® ALTA LUXETOP™ LIFT™ MATTRESS            | 95550688 NONE   | 2    | mattress fee	|
   |prod17530001    |LARGE PLATE DOOR KNOCKER                           | 24320001 COPR   | 3   | all           |

