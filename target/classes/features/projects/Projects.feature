Feature: Verify projects

  Scenario Outline: Verify that user is able to find project by projectName, projectID, createdBy, editedBy
    Given I log into Concierge as "associate"
    When I click on projects button
    When I search project by provided "<searchBy>"
    Then I verify that search result is displayed
    Examples:
      | searchBy    |
      | projectName |
      | projectID   |
      | createdBy   |
      | editedBy    |

  Scenario Outline: Verify that user is able to find project by pricing type
    Given I log into Concierge as "associate"
    When I click on projects button
    When I search project by "<pricingType>"
    Then I verify that search result for pricing type is displayed
    Examples:
      | pricingType |
      | regular     |
      | member      |
      | trade       |

  Scenario Outline: Verify that user is able to create project for clients
    Given I log into Concierge as "associate"
    When I click on projects button
    When I click on new project button
    When I introduces "<businessClient>" first and last name
    When I introduces details for new project
    Then I verify that new project for <"businessClient"> was created
    Examples:
      | businessClient       |
      | member               |
      | nonmember            |
      | trade                |
      | unclassifiedBusiness |

  Scenario: Verify that user is able to move cart to project
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I choose client from header
    When I clicks on a random menu item
    When I clicks on o random item
    When I fill all options for item
    When I click on add to cart button
    When I click on move to project button
    When I choose project from move to project pop up
    When I click on save button
    Then I verify that projects screen is displayed




