@estoreRegression
Feature: Estore Homepage

  Scenario: Verify that home page is accessible
    Given I log into eStore as "regular"
    Then I expect that I am on the eStore Dashboard page
    Then I Verify list of Navigation bars
