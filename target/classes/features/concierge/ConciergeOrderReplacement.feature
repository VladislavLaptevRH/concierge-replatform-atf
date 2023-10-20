@conciergeOrderReplacement
@conciergeTestRun
Feature: Order replacement

  Scenario: concierge - Order replacement - Visa payment
    Given I log into intl Concierge as "associate"
    When I choose country for concierge from footer
    When I choose gallery number "701" for gallery intl concierge
    When I remove all items from cart via UI
    When I remove client from header
    When I open product page with "prod18510007" and "17050043" for stg3
    Then I chose the '1' line item selections one by one
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    And I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    When I continue to payment
    When I click on continue with original address button
    When I execute payment for "VI"
    Then I verify that review screen is displayed

  Scenario: concierge - Order replacement - Mastercard payment
    Given I log into intl Concierge as "associate"
    When I choose country for concierge from footer
    When I choose gallery number "701" for gallery intl concierge
    When I remove all items from cart via UI
    When I remove client from header
    When I open product page with "prod18510007" and "17050043" for stg3
    Then I chose the '1' line item selections one by one
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    And I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    When I continue to payment
    When I click on continue with original address button
    When I execute payment for "MC"
    Then I verify that review screen is displayed
    When I click on a place order button

  Scenario: concierge - Order replacement - AMEX payment
    Given I log into intl Concierge as "associate"
    When I choose country for concierge from footer
    When I choose gallery number "701" for gallery intl concierge
    When I remove all items from cart via UI
    When I remove client from header
    When I open product page with "prod18510007" and "17050043" for stg3
    Then I chose the '1' line item selections one by one
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    And I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    When I continue to payment
    When I click on continue with original address button
    When I execute payment for "AX"
    Then I verify that review screen is displayed
    When I click on a place order button

  Scenario: concierge - Order replacement - Discovery payment
    Given I log into intl Concierge as "associate"
    When I choose country for concierge from footer
    When I choose gallery number "701" for gallery intl concierge
    When I remove all items from cart via UI
    When I remove client from header
    When I open product page with "prod18510007" and "17050043" for stg3
    Then I chose the '1' line item selections one by one
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    And I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    When I continue to payment
    When I click on continue with original address button
    When I execute payment for "DI"
    Then I verify that review screen is displayed
    When I click on a place order button

  Scenario: concierge - Order replacement - POS payment
    Given I log into intl Concierge as "associate"
    When I choose country for concierge from footer
    When I choose gallery number "701" for gallery intl concierge
    When I remove all items from cart via UI
    When I remove client from header
    When I open product page with "prod18510007" and "17050043" for stg3
    Then I chose the '1' line item selections one by one
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    And I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    When I continue to payment
    When I click on continue with original address button
    When I execute payment for "POS"
    Then I verify that review screen is displayed