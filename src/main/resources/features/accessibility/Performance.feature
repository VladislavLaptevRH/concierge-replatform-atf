Feature:Verify performance in chrome

  Scenario: Verify loading speed
    Given I log into Concierge as nbohr@nomail.com
    When I choose client from header
    When I add 3 times an item in the cart

  Scenario: Add items to cart
    Given I log into Concierge as "associate"
    When I add items in cart