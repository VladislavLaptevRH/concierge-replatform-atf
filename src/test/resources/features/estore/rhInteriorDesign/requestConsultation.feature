@criticalpath @smoke
Feature:
    As a user
    I want to be able to open RH Interior design page and verify the RAC modal and then submit a RAC form


Scenario: To verify the RAC modal and submit a request for design consultation
    Given I open the RH Interior Design page
    When I click on Request A Design Consulatation button
    Then I verify RAC modal is displayed
    When I fill the RAC form for "logInAndOutTest" and submit it
    Then I verify the RAC form is submitted