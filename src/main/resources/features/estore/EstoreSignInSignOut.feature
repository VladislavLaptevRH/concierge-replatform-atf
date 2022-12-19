@estoreRegression
@estoreSignInSignOut
Feature: Estore Sign In/Signout

  Scenario: Verify that user is not able to login with ivalid email and password
    Given I introduce wrong login and password
    Then I verify that error message about invalid credentials is displayed

  Scenario: Forgot Password option should be present with proper funtionality
    Given when I click on forgot password button
    Then I verify that forgot password options works

  Scenario: To check if user is able to sign out properly
    Given I log into eStore as "regular"
    When I click on estore account
    When I click on estore signout button
    When I click on estore my account icon for not logged user
    Then I verify that user is able to signout