@estoreRegression
Feature: Estore Thank You page

  Scenario: Verify address, price, payment information, total, subtotal tags
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I go to estore item "17050042 WHT" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    When I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I execute payment with credit card on estore
    When I click on a place estore order button
    When I click on estore order details button
    Then I verify that address on order review page the same as on address page
