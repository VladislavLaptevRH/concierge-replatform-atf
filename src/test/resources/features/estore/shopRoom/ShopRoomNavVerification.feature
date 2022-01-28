@smoke @criticalpath
Feature:
    As a user
    I want to verify category navigation menu is present on Shop rooms on each brand


    Scenario Outline: Verify category navigation on shop rooms page 
        Given I am on the site as a guest user
        And I click <brand> in the header
        When I click Shop Rooms in the header
        Then I expect that the header of page contains "Shop Rooms"
        Then I verify the navigation menu is displayed
        
    Examples:
            |brand |
            |RH    |
            |RH Modern|
            |RH Baby & Child|
            |RH Teen   |         