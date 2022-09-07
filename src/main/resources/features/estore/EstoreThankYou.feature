@estoreRegression
Feature: Estore Order review

  Scenario: Verify address, price, payment information, total, subtotal tags
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I go to estore item "10097379 PYR" from search field
    When I click on add to cart estore button
    When I click on aggree&add estore button
    And I click on view cart estore button
    When I click on estore checkout button
    When I click on estore no thanks button
    When I continue to estore payment
    When I choose saved card "VI" from payment method dropdown
    When I click on continue payment method estore button
    When I click on a place estore order button
    When I click on estore order details button
    Then I verify that address on order review page the same as on address page
