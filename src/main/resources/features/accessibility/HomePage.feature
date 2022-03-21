Feature:User expects the home page to be accessible

  Scenario: Verify that home page is accessible
    Given user opens the concierge site
    When user sign in concierge portal
    Then  I expect that I am on the Concierge Dashboard page

  Scenario: Verify menu of items
    Given I log into Concierge as "associate"
    Then user verifies that all items from menu are displayed
