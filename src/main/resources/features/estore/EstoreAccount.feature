@estoreParallelTestRun
Feature: Estore account

  Scenario: Verify the personal Info displayed after Sign in - First, last name and email
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I goes to my account for estore
    Then I verify that the personal info is displayed

  Scenario: Verify the max length for First Name text field
    Given I log into eStore as "regular" user
    When I goes to my account for estore
    When I verify the max length for first name text field

  Scenario: Verify the min length for First Name text field
    Given I log into eStore as "regular" user
    When I goes to my account for estore
    When I verify the min length for first name text field

  Scenario: Verify that by updating personal information, application should get saved the entered details
    Given I log into eStore as "regular" user
    When I goes to my account for estore
    When I update personal information for account
    When I click on estore update personal information data button
    Then I verify that by updating personal information, application should get saved the entered details

  Scenario: Verify that after updating account profile, application should display popup with 'your profile has been updated' message
    Given I log into eStore as "regular" user
    When I goes to my account for estore
    When I update personal information for account
    When I click on estore update personal information data button
    Then I verify that after updating account profile popup with your profile has been updated message is displayed

  Scenario: Verify the max length for Last Name text field
    Given I log into eStore as "regular" user
    When I goes to my account for estore
    When I verify the max length for last name text field

  Scenario: Verify the min length for Last Name text field
    Given I log into eStore as "regular" user
    When I goes to my account for estore
    When I verify the min length for last name text field

  Scenario: Verify by entering already existing email ID, application should get an error message
    Given I log into eStore as "regular" user
    When I goes to my account for estore
    When I update email for account personal information
    When I click on estore update personal information data button
    Then I verify that estore application should get an error message

  Scenario: Verify the updated firstname in top nav Header
    Given I log into eStore as "regular" user
    When I goes to my account for estore
    When I update personal information for account
    When I click on estore update personal information data button
    When I close estore your profile has been updated pop up
    When I click on estore my account icon
    Then I verify that the updated firstname in top nav header

  Scenario: Verify the Update Personal Email Information Functionality - update first name
    Given I log into eStore as "regular" user
    When I goes to my account for estore
    When I update first name for estore account
    When I click on estore update personal information data button
    When I close estore your profile has been updated pop up
    Then I verify that by updating personal information, application should get saved the entered details

  Scenario: Verify the Update Personal Email Information Functionality - update last name
    Given I log into eStore as "regular" user
    When I goes to my account for estore
    When I update last name for estore account
    When I click on estore update personal information data button
    When I close estore your profile has been updated pop up
    Then I verify that the updated last name is saved

  Scenario: Verify the Update Personal Email Information Functionality -update to existing email (Error message should be displayed regarding Entered email is already registered)
    Given I log into eStore as "regular" user
    When I goes to my account for estore
    When I update account email with the existing email
    When I click on estore update personal information data button
    Then I verify that error message is displayed regarding entered email is already registered