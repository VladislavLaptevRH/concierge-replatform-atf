@estoreTestRun
@estoreWishList
Feature: Estore Wishlist

  Scenario: Wishlist for registered users
    Given I log into eStore as "wishlist-registered" user
    When I choose country for eStore from footer
    When I navigate to the wishlist
    Then I validate items in wishlist

  Scenario: Add an item to wishlist
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I open product page with "prod2020027" and "17050043" with "FOG" for estore
    When I click on my account button if page is not loaded
    When I click on add to wishlist button
    Then I validate items in wishlist

  Scenario: Add an item to wishlist (Member User)
    Given I log into eStore as "member" user
    When I choose country for eStore from footer
    When I open product page with "prod2020027" and "17050043" with "FOG" for estore
    When I click on my account button if page is not loaded
    When I click on add to wishlist button
    Then I validate items in wishlist
    Then I validate member price in wishlist

  Scenario: Add an item from cart to wishlist
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I add item to cart via API for estore
    When I open estore cart
    When I click on add to wishlist button from cart
    When I click on view wishlist button
    When I click on my account button if page is not loaded
    Then I validate items in wishlist


