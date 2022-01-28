@criticalpath @smoke @monitor @mobile
Feature:
    As a user
    I want to be able to register on the website from mobile

    Scenario: Register a new account
        Given I open the site "/" on mobile
        When I create a new account with name "Register" and password "Password1" on mobile
        Then I expect that I am signed in with name "Register" on mobile


