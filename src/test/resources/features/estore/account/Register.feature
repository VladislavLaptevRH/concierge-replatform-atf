@criticalpath @smoke
Feature:
    As a user
    I want to be able to register on the website

Scenario: Register a new account
    Given I open the site "/"
    When I create a new account with name "Register" and password "Password1"
    Then I expect that I am signed in with name "Register"

