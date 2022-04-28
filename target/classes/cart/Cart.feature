@conciergeRegression
Feature: Cart

  Scenario: Order Classification
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "prod17860061" from search field
    When I click on add to cart button
    When I click on view cart button
    Then I verify order classification

  Scenario: Membership banner for Guest client
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "prod17860061" from search field
    When I click on add to cart button
    When I click on view cart button
    When I click on checkout button
    Then I verify member banner for guest client

  Scenario: Clear Order
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "prod17860061" from search field
    When I click on add to cart button
    When I click on view cart button
    When I click on clear order button from cart

  Scenario: Line Item : Quantiy update
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "prod17860061" from search field
    When I click on add to cart button
    When I click on view cart button
    When I click on quantity line item button
    Then I verify that quantity was updated

  Scenario:Remove line item - click on remove button and verify that line item is removed and subtotal and minicart value is updated
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "prod17860061" from search field
    When I click on add to cart button
    When I click on view cart button
    When I click on remove button from cart page
    Then I verify that line item was removed

  Scenario Outline: Override Line item Prices - with percent off, dollar off, override price methods
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "prod17860061" from search field
    When I click on add to cart button
    When I click on view cart button
    When I click on total item line price
    When I select price override "<method>"
    When I introduces value for override price
    When I choose reason code for price override
    When I click on apply uppercase button for "<method>"
    Then I verify line items prices for "<method>"
    Examples:
      | method          |
      | PERCENT_OFF     |
      | AMOUNT_OFF      |
      | AMOUNT_OVERRIDE |

  Scenario: Override Line item Prices - for all line items from cart
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "prod17860061" from search field
    When I click on add to cart button
    When I click on view cart button
    When I click on total item line price
    When I select price override "PERCENT_OFF"
    When I introduces value for override price
    When I choose reason code for price override
    When I click on apply all checkbox
    When I click on apply uppercase button for "PERCENT_OFF"
    Then I verify line items prices for "PERCENT_OFF"

  Scenario:Override Line item Prices - verify update button, verify remove button
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "prod17860061" from search field
    When I click on add to cart button
    When I click on view cart button
    When I click on total item line price
    When I select price override "PERCENT_OFF"
    When I introduces value for override price
    When I choose reason code for price override
    When I click on apply uppercase button for "PERCENT_OFF"
    Then I verify line items prices for "PERCENT_OFF"
    When I click on total item line price
    When I select price override "AMOUNT_OVERRIDE"
    When I introduces value for override price
    When I click on apply uppercase button for "AMOUNT_OVERRIDE"
    Then I verify line items prices for "AMOUNT_OVERRIDE"

  Scenario:Override Line item Prices - verify remove button
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "prod17860061" from search field
    When I click on add to cart button
    When I click on view cart button
    When I click on total item line price
    When I select price override "PERCENT_OFF"
    When I introduces value for override price
    When I choose reason code for price override
    When I click on apply uppercase button for "PERCENT_OFF"
    Then I verify line items prices for "PERCENT_OFF"
    When I click on total item line price
    When I click on remove button from price override
    Then I verify that price override was removed

  Scenario:Shipping Override (SD, UFD) -  i can introduce only zero in unlimited furniture delivery field, verify that error should be appeared -> Value must be 0.
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "prod17860061" from search field
    When I click on add to cart button
    When I click on view cart button
    When I click on UFD button from cart

  Scenario: Promo codes - military promo code for guest user
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "prod17860061" from search field
    When I click on add to cart button
    When I click on view cart button
    When I introduces promo code for promo codes field
    When I click on apply promocode button











