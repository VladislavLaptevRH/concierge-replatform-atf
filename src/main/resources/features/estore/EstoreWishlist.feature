@estoreRegression
Feature: Estore Wishlist

  Scenario: Wishlist for registered users
    Given I log into eStore as "wishlist-registered"
    When I navigate to the wishlist
    Then I validate items in wishlist

  Scenario: Add an item to wishlist
    Given I log into eStore as "regular"
    And I go to estore item "prod25160230" from search field
    When I click on add to wishlist button
    Then I validate items in wishlist

  Scenario: Add an item to wishlist (Member User)
    Given I log into eStore as "member"
    And I go to estore item "prod25160230" from search field
    When I click on add to wishlist button
    Then I validate items in wishlist
    Then I validate member price in wishlist

  Scenario: Add an item from cart to wishlist
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I go to estore item "prod25160230" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on add to wishlist button from cart
    Then I validate items in wishlist
    Then I validate cart is empty



