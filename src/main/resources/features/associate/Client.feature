Feature:Verify client search

  Scenario Outline: Verify client search by <searchBy>
    Given I log into Concierge as "associate"
    When I remove client from header
    When I search client by "<searchBy>"
    Then I verify that client results is displayed
    Examples:
      | searchBy |
      | email    |
      | lastName |
      | memberID                         |
      | businessAccountNumber            |
#      | phone number,postal code,company |

  Scenario: Verify that user is able to create new client
    Given I log into Concierge as "associate"
    When I remove client from header
    When I click on client button
    When I create new client
    Then I verify that new client has been created
