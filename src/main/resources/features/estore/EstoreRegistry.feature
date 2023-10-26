@@estoreTestRun
@estoreRegistry
Feature: Registry

  Scenario: Verify that user is able to create the registry/find the existing registry
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore my account icon for guest user
    When I click on the "gift-registry" from my account dropdown
    Then I verify that "gift-registry" is available for eStore
    When I go to create the new registry page for eStore
    When I fill all required fields to create the new registry
    When I click to create registry button on eStore
    When I click on continue with original address estore button
    Then I verify that registry was created on eStore
    And I verify that I'm able to remove create gift registry
    Then I verify that registry has been deleted on eStore
    When I go to find a registry
    When I introduce the first and last name to search for registry
    When I click to create registry button on eStore
    Then I verify that search result on eStore for registry search by name is displayed

  Scenario: Verify that user is able to manage the existing registry
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore my account icon for guest user
    When I click on the "gift-registry" from my account dropdown
    Then I verify that "gift-registry" is available for eStore
    When I click on manage your registry button
    #this test case needs to be revised
