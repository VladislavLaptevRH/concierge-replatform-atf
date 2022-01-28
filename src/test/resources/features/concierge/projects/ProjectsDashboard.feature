@smoke @criticalpath @projects
Feature:
    As a developer
    I want to be able to test that projects are rendering in concierge

Scenario: Verify Projects Dashboard Renders
    Given I am logged into Concierge as "aassociate"
    When I navigate to "Projects" in Concierge
    Then I expect the projects dashboard to render

#Scenario: Create a new project from the dashboard
#    Given I am logged into Concierge as "aassociate"
#    When I navigate to "Projects" in Concierge
#    And I click the "New Projects" button
#    And I fill out the new project form for a design client
#    Then I see the project in the dashboard list
# //teardown created project

#Scenario: Search for an existing project from the dashboard
# //create project via api
#    Given I am logged into Concierge as "aassociate"
#    And the project "My Test Project" exists
#    When I navigate to "Projects" in Concierge
#    And I search "Project Name" for "My Test Project"
#    Then I see the project in the dashboard list
# //teardown created project
