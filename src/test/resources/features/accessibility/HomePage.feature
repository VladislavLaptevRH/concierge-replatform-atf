Feature:User expects the home page to be accessible

  Scenario: Verify that home page is accessible
    Given user opens the concierge site
    When user sign in concierge portal
    Then user expects that no accessibility errors
