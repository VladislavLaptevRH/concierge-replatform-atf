@criticalpath @smoke @monitor @mobile
Feature:
    As a user
    I want to be able to log out of the site

    Background: User is Logged In
        Given I am on the site and click on hamburger menu to verify guest user on mobile
        # And The mWeb customer "logInAndOutTest" exists
        When I log into the site as "logInAndOutTest" on mobile
        Then I expect that I am signed in with name "Cucumber" on mobile

   Scenario: Log Out of the site from the header
        Given I open the site "/" on mobile
        When I click on the hamburger menu and select My Account on mobile
        And I click on the sign out button on the my account page
        Then I expect that I am not signed in on mobile