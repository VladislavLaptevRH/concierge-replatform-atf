#@conciergeRegression
#Feature:Payment
#
#  Scenario Outline: Major CCs
#    Given I log into Concierge as "associate"
#    When I remove all items from cart
#    When I remove client from header
#    When I go to item "prod19250012" from search field
#    And I select count of product
#    When I click on add to cart button
#    When I click on view cart button
#    When I click on checkout button
#    When I click on no thanks button
#    When I choose client who is a "nonmember"
#    When I fill all fields from address screen
#    And I continue to payment
#    When I execute payment for "<paymentmethod>"
#    And I verify that review screen is displayed
#    Examples:
#      | paymentmethod |
#      | VI            |
#      | MC            |
#      | AX            |
#      | DI            |
#
#  Scenario: GC/ Balance check
#    Given I log into Concierge as "associate"
#    When I remove all items from cart
#    When I remove client from header
#    When I go to item "10035093 LBB" from search field
#    And I select count of product
#    When I click on add to cart button
#    When I click on view cart button
#    When I click on checkout button
#    When I click on no thanks button
#    When I choose client who is a "nonmember"
#    When I fill all fields from address screen
#    And I continue to payment
#    When I choose RH Gift Card from payment method
#    When I click on check balance button
#    Then I verify that balance info is displayed
#
#  Scenario: Verify the Complete Billing address
#    Given I log into Concierge as "associate"
#    When I remove all items from cart
#    When I remove client from header
#    When I go to item "10035093 LBB" from search field
#    And I select count of product
#    When I click on add to cart button
#    When I click on view cart button
#    When I click on checkout button
#    When I click on no thanks button
#    When I choose client who is a "nonmember"
#    When I fill all fields from address screen
#    And I continue to payment
#    Then I verify the complete billing address
#
#  Scenario: Verify the subtotal, shipping fee, taxes based on postal code
#    Given I log into Concierge as "associate"
#    When I remove all items from cart
#    When I remove client from header
#    When I go to item "10035093 LBB" from search field
#    And I select count of product
#    When I click on add to cart button
#    When I click on view cart button
#    When I click on checkout button
#    When I click on no thanks button
#    When I choose client who is a "nonmember"
#    When I fill all fields from address screen
#    And I continue to payment
#    Then I verify subtotal, shipping fee, taxes based on postal code
#
#
