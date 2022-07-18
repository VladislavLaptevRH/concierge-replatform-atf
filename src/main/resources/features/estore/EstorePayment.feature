@estoreRegression
@estorePaymentRegression
Feature:Estore Payment

  Scenario Outline: Major CCs
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "10011389 BRS" from search field
    And I select count of product
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    When I fill all fields from address screen
    And I continue to payment
    When I execute payment for "<paymentmethod>"
    And I verify that review screen is displayed
    Examples:
      | paymentmethod |
      | VI            |
      | MC            |
      | AX            |
      | DI            |

  Scenario: GC/ Balance check
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "10035093 LBB" from search field
    And I select count of product
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    When I fill all fields from address screen
    And I continue to payment
    When I choose RH Gift Card from payment method
    When I click on check balance button
    Then I verify that balance info is displayed

  Scenario: Verify the Complete Billing address
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "10035093 LBB" from search field
    And I select count of product
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    When I fill all fields from address screen
    And I continue to payment
    Then I verify the complete billing address

  Scenario: Verify the subtotal, shipping fee, taxes based on postal code
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "10035093 LBB" from search field
    And I select count of product
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    When I fill all fields from address screen
    And I continue to payment
    Then I verify subtotal, shipping fee, taxes based on postal code

  Scenario: Verify member savings in payment page
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I go to item "10035093 LBB" from search field
    And I select count of product
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "member"
    When I click on checkout button
    When I fill all fields from address screen
    And I continue to payment
    Then I verify that member savings in payment page

  Scenario: Verify trade savings in payment page
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I go to item "10035093 LBB" from search field
    And I select count of product
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "trade"
    When I click on checkout button
    And I fill all fields for sold to address
    And I continue to payment
    Then I verify that trade savings in payment page

  Scenario: Edit Address
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I go to item "10035093 LBB" from search field
    And I select count of product
    When I click on add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    And I fill all fields from address screen
    And I continue to payment
    When I edit billing address from PG
    And I continue to payment
    Then I verify that I'm able to edit billing address

