@estoreRegression
Feature:Estore Order review

  Scenario: Verify address, price, payment information, total, subtotal tags
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I go to estore item "63130001NATL" from search field
    When I click on add to cart estore button
    When I click on aggree&add estore button
    And I click on view cart estore button
    When I click on estore checkout button
    When I click on estore no thanks button
    When I click on continue with original address estore button
    When I continue to estore payment after address page
    When I click on add to cart estore button
    When I remove payment method which was used earlier
    When I choose saved card "VI" from payment method dropdown
    When I click on continue payment method estore button
    Then I verify that address on order review page the same as on address page

  Scenario: Edit payment
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I open direct product page on estore
    When I click on add to cart estore button
    When I click on aggree&add estore button
    And I click on view cart estore button
    When I click on estore checkout button
    When I click on estore no thanks button
    When I continue to estore payment after address page
    When I remove payment method which was used earlier
    When I choose saved card "VI" from payment method dropdown
    When I click on continue payment method estore button
    When I click on estore edit payment button on order review page
    When I remove existing payment method on payment estore page
    When I choose saved card "VI" from payment method dropdown
    When I click on continue payment method estore button
    Then I verify that payment has been changed

