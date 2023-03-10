@concierge-All
@concierge-Cart
Feature: Order replacement

  Scenario: concierge - Order replacement - Visa payment
    Given I log into intl Concierge as "associate"
    When I choose gallery number "701" for gallery intl concierge
    When I remove all items from cart via UI
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    And I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    When I continue to payment
    When I execute payment for "VI"
    Then I verify that review screen is displayed
    When I click on a place order button

  Scenario: concierge - Order replacement - Mastercard payment
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I remove client from header
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    And I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    When I continue to payment
    When I execute payment for "MC"
    Then I verify that review screen is displayed
    When I click on a place order button

  Scenario: concierge - Order replacement - Mastercard payment
    Given I log into eStore as "regular" user
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
    When I execute payment for "MC"
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed
