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

  Scenario: Instock
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "sofa" from search field
    Then I verify sofa search page is displayed
    Then I select IN-STOCK box
    Then I verify IN-STOCK filter is applied

  Scenario: Search with Keywords - Art or swivels
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "Art" from search field
    Then I verify art search page is displayed
    When I go to item "swivels" from search field
    Then I verify swivels search page is displayed

  Scenario: Clicking on cross icon search item should clear from search box
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I search item "sofa"
    When I clear search
    Then I confirm search item is clear

  Scenario: Verify the search results with multiple terms search: white and blue corner leather sofa
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "white and blue corner leather sofa" from search field
    Then I verify multi search result is displayed

  Scenario: Verify the results with multiple term search and facet selections
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "white and blue corner leather sofa" from search field
    Then I verify multi search result is displayed
    Then I select IN-STOCK box
    Then I verify multi search result is displayed

  Scenario: Verify that by clicking on 'clear all', all the applied options should get removed
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "sofa" from search field
    Then I verify sofa search page is displayed
    Then I select IN-STOCK box
    Then I clear all and confirm the applied option is removed

  Scenario: Search Suggestion should be removed
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I search with the 'sof' product and observe the absent auto suggestions on the dashboard search field
    Then I search with the 'sof' product and observe the absent auto suggestions on the search sidebar

  Scenario: Filters
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "sofa" from search field
    Then I verify sofa search page is displayed
    Then I verify that 'Filters such as Material Filters, Size Filters, Brand' on search page

  Scenario: Filters after Cross Brand Search
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "sofa" from search field
    Then I verify sofa search page is displayed
    Then I click on 'BRAND facet' button on search page
    Then I click on 'select any brand' button on search page
    Then I verify that 'Filters such as Material Filters, Size Filters, Brand' on search page

  Scenario: Pricing
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "sofa" from search field
    Then I verify sofa search page is displayed
    Then Pricing should be shown against each item

  Scenario: Verify Sort after search - (Featured/Price Low to Hight/Price High to Low)
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "sofa" from search field
    Then I verify sofa search page is displayed
    Then I click 'Price Low to High and verify price is sorted' on PG screen
    Then I click 'Price High to Low and verify price is sorted' on PG screen

  Scenario: Verify the in-stock facet selection and in-stock product
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "outdoor sofas" from search field
    Then I select IN-STOCK box
    Then I verify IN-STOCK filter is applied
    Then Pricing should be shown against each item

  Scenario: By searching couch, Verify Sofa products too in search
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "couch" from search field
    Then Sofa products too should be searched

  Scenario: In displayed products regular and member prices should be displayed
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "sofa" from search field
    Then I verify sofa search page is displayed
    Then Regular and Member prices should be displayed against each product

  Scenario: Verify the sort: High to low
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "sofa" from search field
    Then I verify sofa search page is displayed
    Then I click 'Price High to Low and verify price is sorted' on PG screen

  Scenario: Verify the sort: Low to High
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "sofa" from search field
    Then I verify sofa search page is displayed
    Then I click 'Price Low to High and verify price is sorted' on PG screen

  Scenario: Pricing on search result page(US and CAN)
    Given I log into Concierge as "associate"
    When I go to item "sofas" from search field
    Then I chose '1' product from the list
    Then I Verify that 'item title' is present
    When I choose 'US' country
    Then Verify that 'default US zip code is present in PDP'
    Then Verify that 'price should be shown in US Dollar'
    When I choose 'CA' country
    Then I click on zip code and change it to 'H1Y2B5'
    Then I verify that zip code in PDP is 'H1Y 2B5'
    Then Verify that 'price in PDP changed from US$ to CA$'

  Scenario: To verify Search page is loading till footer
    Given I log into Concierge as "associate"
    When I go to item "sofa" from search field
    Then I verify sofa search page is displayed
    Then I verify that PG loads

  @vlad
  Scenario: WIld card name search
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on search Icon
    When I type item name '*?'
    Then All RH products should be searched

  @vlad
  Scenario: Search with Collection name
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on search Icon
    When I type item name 'Seating Collections'
    Then Seating Collections products should be displayed

  @vlad
  Scenario: After switching to diff country check the count of products, it should display the available product count
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on search Icon
    When I type item name 'Seating Collections'
    Then Seating Collections products should be displayed
    Then verify the count of products
    When I choose 'CA' country
    Then Product's count should be shown as per the availability of the products in that country