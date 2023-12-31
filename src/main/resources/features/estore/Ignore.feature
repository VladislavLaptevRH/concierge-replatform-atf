Feature: Test cases which are not use

  Scenario: Search after opening hamburger menu
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on hamburger menu for estore
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    Then I verify that search result "802-GRAM TURKISH TOWEL COLLECTION" for search product via product name is displayed

  Scenario: eStore - Gift Box fee in cart
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I open product page with "prod20000465" and "17110459" with "MIST" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I add item to cart via API for estore
    When I open estore cart
    When I click on zipcode estore button
    When I update postal code in cart
    When I click on gift box button
    Then I verify gift box fee in estore cart

  Scenario: Verify CTA functionality
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I scroll down to Request a design consultation and click
    And I fill in the request form
    Then I Verify Thank you message

  Scenario: To Verify Sale banner
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "FABRIC CHAIR COLLECTION" from search field
    When I apply In stock to Sale filter
    Then I verify sale banner for estore


  Scenario: eStore - CAN Shipping restriction
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I choose "CAN" country from footer
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address for CAN
    Then I verify "CAN" shipping restriction

  Scenario: eStore - New York Shipping restriction
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with NY restriction item
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    When I click on estore no thanks button
    When I fill estore shipping address for "NY"
    When I click on edit estore billing address button
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    Then I verify "NY" shipping restriction
