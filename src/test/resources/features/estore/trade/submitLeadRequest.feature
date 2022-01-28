Feature:
    As a Trade user
    I want to submit a lead service request.

    Scenario: Trade User should be able to sumbit a lead
    Given I open the the "Trade" page
    When I click on "Contact Your Local RH Trade Team" link
    Then I verify service request modal is displayed
    When I fill the service request form for "stagingUser" and submit it
    Then I verify the service request form is submitted
