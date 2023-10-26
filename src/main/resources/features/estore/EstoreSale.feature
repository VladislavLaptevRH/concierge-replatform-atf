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

  Scenario: To Verify Sale banner
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to sale estore category
    Then I verify sale banner for estore

  Scenario: To verify the back button from sale PDP page
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I verify that I'm able to navigate different category
    Then I verify the back button from sale PDP page

