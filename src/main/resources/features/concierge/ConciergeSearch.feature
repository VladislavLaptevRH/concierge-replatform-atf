@concierge-All
@concierge-Search
@conciergeCriticalPathTestRun
Feature: Concierge PG Page

  Scenario: Verify that Search for keyword is functioning as expected
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on search Icon
    When I Type product name 'table'
    Then I verify that 'PG Search Page has title (TABLE) and text "Results" and "Sort" are present' on search page
    Then I verify that 'Grid View is present in top right'
    Then I verify that 'PG pictures of all items are visible' on search page
    Then I verify that 'page is loaded until footer' on search page
    Then I verify that relevant items are returned on search page 'Table'

  Scenario: Verify that cross brand search is functioning as expected
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on search Icon
    When I Type product name 'Crib'
    Then I verify that 'PG page is returned with text  RESULTS (IN RH BABY & CHILD)' on search page
    Then I verify that 'VIEW RH BABY & CHILD RESULTS button is present' on search page
    Then I verify that 'footer is present' on search page
    Then I click on 'VIEW RH BABY & CHILD RESULTS' button on search page
    Then I verify that relevant items are returned on search page 'Crib'
    Then I verify that RH Brand dropdown is present in 'BC' home page
    Then I verify that 'PG pictures of all items are visible' on search page
    Then I verify that 'page is loaded until footer' on search page

  Scenario: Verify that search for non-existent search term returns 0 results
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on search Icon
    When I Type product name '234adf'
    Then I verify that 'PG page is returned with RESULTS(0) present and search text "234ADF" is present' on search page
    Then I verify text 'We’re sorry, we cannot find what you are looking for.'
    Then I verify text 'Please try a new search or contact '
    Then I verify that 'customer experience' on search page
    Then I click on 'customer experience' button on search page
    Then I verify that 'customer experience page is opened' on search page
    Then I verify that 'footer is present' on search page




