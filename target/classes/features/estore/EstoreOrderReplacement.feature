#@estoreRegression
#@estorePayment
#Feature:Estore Order replacement
#
#  Scenario: estore - Order replacement - Visa payment
#    Given I log into eStore as "regular" user
#    When I remove all items from estore cart
#    When I open product page with "prod13800635" and "17050045" with "WHT" for estore
#    When I click on add to cart estore button
#    And I click on view cart estore button
#    When I click on estore checkout button
#    And I click on estore no thanks button
#    When I fill estore shipping address
#    When I click on same as estore shipping address checkbox
#    When I click on continue to payment estore button
#    When I click on continue with original address estore button
#    When I remove payment method which was used earlier
#    When I execute estore payment for "VI"
#    When I click on estore continue button
#
#  Scenario: estore - Order replacement - Mastercard payment
#    Given I log into eStore as "regular" user
#    When I remove all items from estore cart
#    When I open product page with "prod13800635" and "17050045" with "WHT" for estore
#    When I click on add to cart estore button
#    And I click on view cart estore button
#    When I click on estore checkout button
#    And I click on estore no thanks button
#    When I fill estore shipping address
#    When I click on same as estore shipping address checkbox
#    When I click on continue to payment estore button
#    When I click on continue with original address estore button
#    When I remove payment method which was used earlier
#    When I execute estore payment for "MC"
#    When I click on estore continue button
#
#  Scenario: estore - Order replacement - Amex payment
#    Given I log into eStore as "regular" user
#    When I remove all items from estore cart
#    When I open product page with "prod13800635" and "17050045" with "WHT" for estore
#    When I click on add to cart estore button
#    And I click on view cart estore button
#    When I click on estore checkout button
#    And I click on estore no thanks button
#    When I fill estore shipping address
#    When I click on same as estore shipping address checkbox
#    When I click on continue to payment estore button
#    When I click on continue with original address estore button
#    When I remove payment method which was used earlier
#    When I execute estore payment for "AX"
#    When I click on estore continue button
#
#  Scenario: estore - Order replacement - Discovery payment
#    Given I log into eStore as "regular" user
#    When I remove all items from estore cart
#    When I open product page with "prod13800635" and "17050045" with "WHT" for estore
#    When I click on add to cart estore button
#    And I click on view cart estore button
#    When I click on estore checkout button
#    And I click on estore no thanks button
#    When I fill estore shipping address
#    When I click on same as estore shipping address checkbox
#    When I click on continue to payment estore button
#    When I click on continue with original address estore button
#    When I remove payment method which was used earlier
#    When I execute estore payment for "DI"
#    When I click on estore continue button
#
#
#