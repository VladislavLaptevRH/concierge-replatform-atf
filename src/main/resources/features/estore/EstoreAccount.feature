@estoreRegression
@estoreAccount
Feature: Estore account

  Scenario: Verify the personal Info displayed after Sign in - First, last name and email
    Given I log into eStore as "regular" user
    When I goes to my account for estore
    Then I verify that the personal info is displayed

  Scenario:Verify the max length for First Name text field
    Given I log into eStore as "regular" user
    When I click on estore my account icon
    When I click on estore sign out button
    When I click on confirm sign out button

  Scenario:Verify the max length for Last Name text field
    Given I log into eStore as "regular" user
    When I click on estore my account icon
    When I click on estore sign out button
    When I click on confirm sign out button

  Scenario: Verify that by updating personal information, application should get saved the entered details
    Given I log into eStore as "regular" user
    When I goes to my account for estore
    Then I verify that by updating personal information, application should get saved the entered details