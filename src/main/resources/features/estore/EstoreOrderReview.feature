@estoreRegression
@estoreOrderReview
Feature:Estore Order review

  Scenario: Verify address, price, payment information, total, subtotal tags
    Given I log into eStore as "orderreview"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    When I click on continue payment method estore button
    Then I verify that address on order review page the same as on address page

  Scenario: Edit payment
    Given I log into eStore as "orderreview"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    When I click on continue payment method estore button
    When I click on estore edit payment button on order review page
    When I remove existing payment method on payment estore page
    When I execute payment with credit card on estore
    When I click on continue payment method estore button
    Then I verify that payment has been changed

  Scenario: Edit Shipping and Billing Address
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050045" with "WHT" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    Then I verify that I'm able to edit shipping and billing address

