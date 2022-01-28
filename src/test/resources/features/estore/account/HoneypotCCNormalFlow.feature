@criticalpath @checkout @smoke
Feature:  
   I want to test the honeypot bot trap on my account credit card entry

Background:
   Given I open the url "/my-account/sign-in.jsp"
   Given I set a cookie "pc" with the content "94111"

Scenario: Account CC Honeypot check allows normal flow
   Given I am the web customer:
          |first    |last    |email                    |password     |
          |Cucumber |Account |cucumberaccount@some.com |Hitchhiker42 | 
   Given I have no saved credit cards
   When  I visit the user payment page and enter:
          |first    |last    |address1         |address2 |city    |state |country |postal |phone      |cardType   |cardNumber       |expMonth |expYear |ccv | 
          |Cucumber |Account | 721 Pine Street |         |Seattle |WA    |US      |98101  |5555555555 |masterCard |5500000000000004 |03       |2030    |737 |
   Then  I expect the account payment page to show "masterCard" with last four "0004"
