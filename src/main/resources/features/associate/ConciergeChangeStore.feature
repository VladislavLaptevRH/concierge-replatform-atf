@regression
Feature: Verify change to another store

  Scenario: Change store number in concierge from dashboard
    Given I log into Concierge as "associate"
    When I change my store to store number 10
    Then I verify I see store Palo Alto in the header

  Scenario: Verify that all galeries are present in list
    Given I log into Concierge as "associate"
    When user clicks on gallery button from header
    Then user verifies list of galleries
