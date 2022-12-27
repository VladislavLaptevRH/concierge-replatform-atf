@estoreRegression
@estoreOrderHistory
Feature: Order history

  Scenario: Verify accessing order history - orders displayed for registered user
    Given I log into eStore as "regular"
    When I click on estore my account icon
    When I click on estore order history
    Then I verify that estore order history page is displayed

  Scenario: Verify no Orders display for new registered user - verify the copy provided
    Given I log into eStore as "notregistered"
    When I click on estore my account icon
    When I click on estore order history
    Then I verify that no orders for new registered user

  Scenario: Verify placing a new order and see it listed in Order History  - logged user
    Given I log into eStore as "userWithSavedMasterCardVisa"
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
    When I execute payment with credit card on estore
    When I click on a place estore order button
    When I open order history for estore
    When I click on estore logo
    When I click on estore my account icon
    When I click on estore order history
    When I click on details and tracking order history
    Then I verify that a new order listed in order history

  Scenario: Verify the fields - ORDER DATE, EST. ORDER TOTAL, ORDER NUMBER,	SHIPPED TO,	ORDER DESCRIPTION
    Given I log into eStore as "regular"
    When I click on estore my account icon
    When I click on estore order history
    Then I verify the fileds for estore order history

  Scenario: Verify the total order count displayed at the bottom of the list
    Given I log into eStore as "regular"
    When I click on estore my account icon
    When I click on estore order history
    Then I verify the estore total order count displayed at the bottom of the list

  Scenario: Verify the pagination for the order history
    Given I log into eStore as "regular"
    When I click on estore my account icon
    When I click on estore order history
    Then I verify that the pagination for the order history is displayed

  Scenario: Verify the Billing summary link for order - Order to be in shipped/delivered state
    Given I log into eStore as "regular"
    When I click on estore my account icon
    When I click on estore order history
    Then I verify the billing summary link for order history

  Scenario: Verify the Details and Tracking link for the order placed
    Given I log into eStore as "regular"
    When I click on estore my account icon
    When I click on estore order history
    Then I verify the details and tracling link for the order placed

  Scenario: Veridy the CW order number displayed once the order is Available
    Given I log into eStore as "regular"
    When I click on estore my account icon
    When I click on estore order history
    Then I verify the CW order number


