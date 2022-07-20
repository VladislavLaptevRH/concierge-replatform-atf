@conciergeRegression
Feature:Concierge Homepage

  Scenario: Verify that home page is accessible
    Given I log into Concierge as "associate"
    Then  I expect that I am on the Concierge Dashboard page

  Scenario: Verify menu of items
    Given I log into Concierge as "associate"
    Then user verifies that all items from menu are displayed

  Scenario: Login as associate and see dashboard
    Given I log into Concierge as "associate"
    Then  I expect that I am on the Concierge Dashboard page

  Scenario: Login as leader and see dashboard
    Given I log into Concierge as "leader"
    Then  I expect that I am on the Concierge Dashboard page

  Scenario: Change store number in concierge from dashboard
    Given I log into Concierge as "associate"
    When I change my store to store number 10
    Then I verify I see store Palo Alto in the header

  Scenario: Verify that all galeries are present in list
    Given I log into Concierge as "associate"
    When user clicks on gallery button from header
    Then user verifies list of galleries

  Scenario: Footer links
    Given I log into Concierge as "associate"
    Then I verify footer links

