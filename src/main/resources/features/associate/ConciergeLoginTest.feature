Feature:Verify login

  Scenario: Login as associate and see dashboard
    Given I log into Concierge as "associate"
    Then  I expect that I am on the Concierge Dashboard page

  Scenario: Login as leader and see dashboard
    Given I log into Concierge as "leader"
    Then  I expect that I am on the Concierge Dashboard page

