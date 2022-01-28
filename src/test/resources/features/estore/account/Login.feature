@criticalpath @smoke
Feature:
    As a user
    I want to be able to login to the site

Scenario: Login page displays after clicking sign in in header
    Given I am on the site as a guest user
    When I click the sign in button in the header
    Then I expect to be on the login page
    And I expect page to not scroll horizontally

Scenario: Log In to an existing account
    Given I am on the site as a guest user
    And The web customer "logInAndOutTest" exists
    When I log into the site as "logInAndOutTest"
    Then I expect that I am signed in with name "Cucumber"

# Scenario: User Cookie expires for guest user at end of session
#     Given I am on the site as a guest user
#     And the cookie "DYN_USER_ID" has an expiration at the end of the session

# Scenario: User Cookie expires for logged in user in a month
#     Given I am on the site as a guest user
#     And The web customer "logInAndOutTest" exists
#     When I log into the site as "logInAndOutTest"
#     And the cookie "DYN_USER_ID" has an expiration at least "29" days from now
