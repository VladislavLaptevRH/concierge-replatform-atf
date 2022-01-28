@criticalpath @smoke @monitor @mobile
Feature:
    As a user
    I want to be able to login to the site from mobile


    Scenario: Log In to an existing account
        Given I am on the site and click on hamburger menu to verify guest user on mobile
        # And The mWeb customer "logInAndOutTest" exists
        # When I scroll on mobile
        When I log into the site as "logInAndOutTest" on mobile
        Then I expect that I am signed in with name "Cucumber" on mobile

