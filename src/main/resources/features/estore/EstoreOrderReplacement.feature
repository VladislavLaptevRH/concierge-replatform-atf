@estoreTestRun
@estoreOrderReplacement
Feature:Estore Order replacement

  Scenario: estore - Order replacement - Visa payment
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute estore payment for "VI"

  Scenario: estore - Order replacement - Mastercard payment
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute estore payment for "MC"

  Scenario: estore - Order replacement - Amex payment
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute estore payment for "AX"

  Scenario: estore - Order replacement - Discovery payment
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute estore payment for "DI"



