Feature:User expects the home page to be accessible

  Scenario: Verify that home page is accessible
    Given user opens the concierge site
    When user sign in concierge portal
    Then user expects that no accessibility errors

  Scenario: Verify menu of items
    Given I log into Concierge as "associate"
    And I verify that category items are displayed
    Then user verifies that all items from menu are displayed
