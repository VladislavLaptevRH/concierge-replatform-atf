Feature: Verify project search

  Scenario Outline: Verify that user is able to buy item
    Given I log into Concierge as "associate"
    When I click on projects button
    When I search project by provided "<parameter>"
    Then I verify that search result is displayed
    Examples:
      | parameter   |
      | projectName |
      | clientID    |
      | pricingType |
      | rhLocation  |
      | createdBy   |
      | editedBy    |