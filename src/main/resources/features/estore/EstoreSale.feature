@estoreTestRun
@estoreSale
Feature: Estore Sale

  Scenario: Sale Nav verification
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I click on estore sale button
    Then I verify that I'm able to navigate different category

  Scenario: Verify Sale Category
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I goes to estore cart for estore
    When I click on estore sale button
    Then I verify sale category for estore

  Scenario: To verify sale PDP load
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    Then I verify that I'm able to navigate different category

  Scenario: To verify the back button from sale PDP page
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I verify that I'm able to navigate different category
    Then I verify the back button from sale PDP page

  Scenario: Verify that user is able to navigate to secondary NAV of SALE
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click to secondary NAV of Sale
    Then I verify that SALE Nav should be expanded with secondary NAV

  Scenario: Verify that user is able to navigate to tertiary NAV of SALE - Living
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Living from sale nav menu
    Then I verify that Living in Secondary NAV should expand tertiary NAV

  Scenario: Verify that user is able to navigate to tertiary NAV of SALE - Dining
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Dining from sale nav menu
    Then I verify that Dining in Secondary NAV should expand tertiary NAV

  Scenario: Verify that user is able to navigate to tertiary NAV of SALE - Bed
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Bed from sale nav menu
    Then I verify that Bed in Secondary NAV should expand tertiary NAV

  Scenario: Verify that user is able to navigate to tertiary NAV of SALE - Bath
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Bath from sale nav menu
    Then I verify that Bath in Secondary NAV should expand tertiary NAV


  Scenario: Verify that user is able to navigate to tertiary NAV of SALE - Outdoor
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Outdoor from sale nav menu
    Then I verify that Outdoor in Secondary NAV should expand tertiary NAV

  Scenario: Verify that user is able to navigate to tertiary NAV of SALE - Lighting
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Lighting from sale nav menu
    Then I verify that Lighting in Secondary NAV should expand tertiary NAV