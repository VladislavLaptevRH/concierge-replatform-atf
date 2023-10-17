@conciergeTestRun
@conciergeSearch
Feature: Concierge PG Page

  Scenario: Verify that Search for keyword is functioning as expected
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on search Icon
    When I type item name 'table'
    Then I verify that 'PG Search Page has title (TABLE) and text "Results" and "Sort" are present' on search page
    Then I verify that 'Grid View is present in top right' search screen
    Then I verify that 'PG pictures of all items are visible' on search page
    Then I verify that 'page is loaded until footer' on search page
    Then I verify that relevant items are returned on search page 'Table'

  Scenario: Verify that cross brand search is functioning as expected
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on search Icon
    When I type item name 'Crib'
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
    When I type item name '234adf'
    Then I verify that 'PG page is returned with RESULTS(0) present and search text "234ADF" is present' on search page
    Then I verify text 'We’re sorry, we cannot find what you are looking for.'
    Then I verify text 'Please try a new search or contact '
    Then I verify that 'customer experience' on search page
    Then I click on 'customer experience' button on search page
    Then I verify that 'customer experience page is opened' on search page
    Then I verify that 'footer is present' on search page


  Scenario: Search after opening hamburger menu
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on search Icon
    When I type item name 'table'
    Then I verify that 'PG Search Page has title (TABLE) and text "Results" and "Sort" are present' on search page


  Scenario: Search Icon should display on all the pages.
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Living'
    Then I navigate to sub menu 'Fabric Seating'
    Then I navigate to gallery 'Seating Collections'
    Then I Verify Search icon is present
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Benches & Stools'
    Then I navigate to gallery 'Benches'
    Then I Verify Search icon is present


  Scenario: By clicking on search icon, user should be able to enter and search the product from any of the page
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on search Icon
    When I type item name 'table'
    Then I verify that 'PG Search Page has title (TABLE) and text "Results" and "Sort" are present' on search page
    Then I navigate to menu 'Living'
    Then I navigate to sub menu 'Fabric Seating'
    Then I navigate to gallery 'Seating Collections'
    When I click on search Icon
    When I type item name 'table'
    Then I verify that 'PG Search Page has title (TABLE) and text "Results" and "Sort" are present' on search page
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Benches & Stools'
    Then I navigate to gallery 'Benches'
    When I click on search Icon
    When I type item name 'table'
    Then I verify that 'PG Search Page has title (TABLE) and text "Results" and "Sort" are present' on search page


  Scenario: After entering search term user can see SEE ALL RESULTS
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on search Icon
    When I type 'table'
    Then I verify SEE ALL RESULTS button is present


  Scenario: Search product via SKU
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'PDP title' is present


  Scenario: Search product via Product name
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "sofa" from search field
    Then I verify sofa search page is displayed

  @mukthar
  Scenario: Instock
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "sofa" from search field
    Then I verify sofa search page is displayed
    Then I select IN-STOCK box

  @mukthar
  Scenario: Search with Keywords - Art or swivels
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "Art" from search field
    Then I verify art search page is displayed
    When I go to item "swivels" from search field
    Then I verify swivels search page is displayed

  @mukthar
  Scenario: Clicking on cross icon search item should clear from search box
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I search item "sofa"
    When I clear search
    Then I confirm search item is clear

  @mukthar
  Scenario: Verify the search results with multiple terms search: white and blue corner leather sofa
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "white and blue corner leather sofa" from search field
    Then I verify multi search result is displayed

  @mukthar
  Scenario: Verify the results with multiple term search and facet selections
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I search item "white and blue corner leather sofa"
    Then I verify multi search result is displayed
    Then I select IN-STOCK box
    Then I verify multi search result is displayed

  @mukthar
  Scenario: Verify that by clicking on 'clear all', all the applied options should get removed
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "sofa" from search field
    Then I verify sofa search page is displayed
    Then I select IN-STOCK box
    Then I clear all and confirm the applied option is removed





