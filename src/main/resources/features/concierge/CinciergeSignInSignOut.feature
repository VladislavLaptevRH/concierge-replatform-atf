@concierge-All
@concierge-SignInSignOut
@conciergeCriticalPathTestRun
Feature: Concierge Sign-in/Sign-out Page

  Scenario: User Sign-in
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I verify that user is logged in

  Scenario: User Sign-out
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I click 'on Associate Name' on signIn signOut screen
    Then I click 'on sign out button' on signIn signOut screen
    Then I verify that 'user is able to sign out' on signIn signOut screen

