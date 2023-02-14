@estoreRegression
Feature: Estore Signout

  Scenario: Verify the signout functionaity
    Given I log into eStore as "regular"
    When I click on estore my account icon
    When I click on estore sign out button
    When I click on confirm sign out button
    When I click on estore my account icon for not logged user

  Scenario: Verify the user is completely signed out of all brands
    Given I log into eStore as "regular"
    When I click on estore my account icon
    When I click on estore sign out button
    When I click on confirm sign out button
    When I click on estore my account icon for not logged user
    Then I verify that user is completely signed out of all brands
