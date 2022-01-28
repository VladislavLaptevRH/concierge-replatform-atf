@smoke @locator
Feature:
    As a customer
    I want to see a map with all gallery locations when I go to the locator page.


Scenario: Gallery Locator Map renders
    Given I open the gallery locator page
    Then  I expect the list and map to display all "gallery" locations
    And I expect page to not scroll horizontally
