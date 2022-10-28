@conciergeRegression
@concierge-Contract
Feature:Concierge Contract

  Scenario: Verify that I'm not able to select Contract Client without contract gallery
    Given I log into Concierge as "associate"
    When I clear order via API
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose order classification
    And I click on checkout button
    And I click on no thanks button
    When I look on client by "accountnumber" with "20211221164476"
    Then I verify that I'm able to select contract client

  Scenario: Verify that Membership banner is not present on the cart page
    Given I log into Concierge as "associate"
    When I clear order via API
    When I choose contract gallery
    When I add item to cart via API
    When I open cart
    When I choose order classification
    And I click on checkout button
    And I click on no thanks button
    When I look on client by "accountnumber" with "20211221164476"
    Then I verify membership banner for "contract" client not displayed

  Scenario: Address page: Sold-to, Billing, shipping address
    Given I log into Concierge as "associate"
    When I clear order via API
    When I choose contract gallery
    When I add item to cart via API
    When I open cart
    When I choose order classification
    And I click on checkout button
    And I click on no thanks button
    When I look on client by "accountnumber" with "20211221164476"
    And I click on checkout button
    Then I verify sold-to, billing, shipping address on address page

  Scenario: Verify contract saving for contract type client
    Given I log into Concierge as "associate"
    When I clear order via API
    When I choose contract gallery
    When I add item to cart via API
    When I open cart
    When I choose order classification
    And I click on checkout button
    And I click on no thanks button
    When I look on client by "accountnumber" with "20211221164476"
    Then I verify contract savings
    And I click on checkout button
    When I continue to payment
    Then I verify contract savings
    When I choose POP for payment method
    Then I verify contract savings
    When I click on a place order button
    When I click on order details button
    Then I verify contract savings

  Scenario: Contract Prices : CG, PG, PDP, Cart, Order Review, Thank you, Payment
    Given I log into Concierge as "associate"
    When I clear order via API
    When I choose contract gallery
    When I remove client from header
    When I click on client button from header
    When I look on client by "accountnumber" with "20211221164476"
    When I open product page with "prod1617188" and "63130001"
    Then I verify that contract price is displayed
    And I click on add to cart button
    And I click on view cart button
    When I choose order classification
    And I click on checkout button
    When I continue to payment
    When I choose POP for payment method
    Then I verify that contract price is displayed
    When I click on a place order button
    When I click on order details button
    Then I verify that contract price is displayed

  Scenario: Contract Prices: Project
    #Need Test data for stg4, test fails at the moment because project name does not exists
    Given I log into Concierge as "associate"
    When I clear order via API
    When I remove client from header
    When I choose contract gallery
    When I click on client button from header
    When I look on client by "accountnumber" with "20211221164476"
    When I click on projects button
    When I search project "contractprices" by provided "projectName"
    When I click on the first project search result
    Then I verify that contract price is displayed
