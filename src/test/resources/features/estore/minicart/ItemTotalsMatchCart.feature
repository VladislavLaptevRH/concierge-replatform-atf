@smoke @criticalpath
Feature:
   As a developer
   I want to be able to verify the minicart count matches the sum of items in the cart.

Background:
   Given I open the url "/my-account/sign-in.jsp"
   Given I set a cookie "pc" with the content "94111"

Scenario: Minicart verify totals match cart
   Given I have the following items in the cart:
          |product_id   | title                                   | full_sku_id     | qty |
          |prod11600084 | Rectangular Column Table Lamp           | 68270648 LBBM   | 1   |
          |prod15970044 | Salvage Wood Trestle Round Dining Table | 62870008 NATL   | 1   |
          |prod1283065  | LUGARNO KNOB                            | 24120451 PC     | 3   |
          |prod1677198  | San Pietro Fountain                     | 42600040 STON   | 4   |
          |prod15470002 | AIRELOOM CASCADE MEMORY FOAM MATTRESS   | 70740995 NONE   | 5   |
   When  I open the url "/customer-service/email-signup.jsp"
   Then  I expect the minicart totals to match cart totals 

