@criticalpath @smoke
Feature:
    As a user
    I want to be able to log out of the site

    Background: User is Logged In
        Given I open the site "/"
        And The web customer "logInAndOutTest" exists
        When I am logged into the site as "logInAndOutTest"
        Then I expect that I am signed in with name "Cucumber"

   Scenario: Log Out of the site from the header
        When I click the sign out button in the header
        And I click on the sign out button on the sign out page
        Then I expect that I am not signed in on old page

#    Scenario: User Cookie expiration is reset when user logs out
#         Given the cookie "DYN_USER_ID" has an expiration at least "29" days from now
#         When I click the sign out button in the header
#         And I click on the sign out button on the sign out page
#         Then the cookie "DYN_USER_ID" has an expiration at the end of the session

