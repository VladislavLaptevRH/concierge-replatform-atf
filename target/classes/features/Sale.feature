@conciergeRegression
Feature:Sale

  Scenario: Sale navigation bar is displayed and functional
    Given I log into Concierge as "associate"
    When I click on sale
    Then I verify sale navigation bars are displayed

