@criticalpath @checkout @smoke
Feature:
   I want to test the honeypot bot trap on credit card selection

Background:
   Given I open the url "/my-account/sign-in.jsp"
   Given I set a cookie "pc" with the content "94111"

Scenario: Honeypot check on credit card does not prevent normal flow
   Given I am the web customer:
          |first    | last | email                 | password     |
          |Cucumber | User | login@rh.com          | Test1234     |
   Given I have the following saved address:
          |first   | last | address1        | address2 |city     | state | country |postal | phone     |
          |Cucumber| User | 721 Pine Street |          | Seattle | WA    | US      | 98101 | 5555555555|
   Given I have the following items in the cart:
          |product_id   | title                                   | full_sku_id     | qty |
          |prod11600084 | Rectangular Column Table Lamp           | 68270648 LBBM   | 2   |
          |prod15970044 | Salvage Wood Trestle Round Dining Table | 62870008 NATL   | 1   |
   When  I visit the cart and proceed to shipping
   When  I enter billing address and proceed to payment:
          |first   | last | address1        | address2 |city     | state | country |postal | phone     |
          |Cucumber| User | 721 Pine Street |          | Seattle | WA    | US      | 98101 | 5555555555|
   When  I enter payment info for new card:
          | cardType   | cardNumber       | expMonth | expYear | ccv |
          | masterCard | 5500000000000004 | 03       | 2030    | 737 |
    And  I continue to preview page by clicking on Continue on payment page
   Then  I expect the review page to be displayed
