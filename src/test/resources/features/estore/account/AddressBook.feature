@addressbook @smoke @presentation
Feature:
    As a user
    I want my addresses to only be accessible when I am signed in.

Background:
    Given I have a new session

    Scenario: Address book link is not visible when user is not logged in
        Given I am on the site as a guest user
        When I open the "Address Book" page
        Then I expect to not see the "Address Book" link in the account navigation
        And I expect page to not scroll horizontally

    Scenario: Address book page displays login message when user is not logged in
        Given I am on the site as a guest user
        When I open the "Address Book" page
        Then I expect to see the Address Book login message
        And I expect page to not scroll horizontally

    Scenario: Address book page displays when logged in
        Given I am logged into the site as "addressBookUser"
        When I open the "Address Book" page
        Then I expect to see the Address Book
        And I expect page to not scroll horizontally
