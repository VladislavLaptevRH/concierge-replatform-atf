@estoreRegression
Feature: Estore PG

  Scenario: Grid view Mobile Only 1 and 2 grid view
    Given I log into eStore as "guest" user user
    When I go to estore item "white and blue corner leather sofa" from search field
    Then I validate "1","2" and "3" grid view should work

  Scenario: Verify two grids are default Grid view in PG
    Given I log into eStore as "guest" user user
    When I go to estore item "white and blue corner leather sofa" from search field
    Then I verify that two grids are default view in PG

  Scenario: PG - Back to Top button
    Given I log into eStore as "guest" user user
    When I goes to estore collection page
    When I scroll on the page till back to top button is visible
    Then I verify that back to top button is clickable
    And I verify that after click on back to top button user is scrolled to top on the page

  Scenario: Back button after appying filter
    Given I log into eStore as "guest" user user
    When I goes to estore collection page
    When I scroll on the page till back to top button is visible
    Then I verify that back to top button is clickable
    And I verify that after click on back to top button user is scrolled to top on the page