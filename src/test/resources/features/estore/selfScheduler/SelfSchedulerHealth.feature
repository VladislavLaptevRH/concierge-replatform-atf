@smoke
Feature:
    As a self schedule application I need to be able to display basic order information as part of a health check

@PHOE-780
Scenario: Self Scheduler health check
    Given I visit the self scheduler with token "healthcheck"
    Then  I expect the self scheduler to present a valid health check
