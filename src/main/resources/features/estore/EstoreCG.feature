@estoreParallelTestRun
@estoreCG
Feature: Estore CG

  Scenario Outline: CG - Test CGS in all menu items (All brands)
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I goes to "<brands>" estore collection page
    Then I verify CGS all menu items
    Examples:
      | brands         |
      | rh             |
      | rhcontemporary |
      | rhinteriors    |
      | rhmodern       |
      | rhoutdoor      |
      | rhbeachhouse   |
      | rhskihouse     |
      | rhbabyandchild |
      | rhteen         |

  Scenario: CG-Verify Collection Name
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I goes to estore collection page
    Then I validate the collection name is not empty

  Scenario: CG-Verify Back To top Button
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I goes to estore collection page
    When I scroll on the page till back to top button is visible
    Then I verify that back to top button is clickable
    And I verify that after click on back to top button user is scrolled to top on the page

  Scenario: Verify single Grid View is as default on CG
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I goes to estore collection page
    Then I verify that single grid view is selected on CG page by default

  Scenario: Verify collection name,image (regular,member,sale(applicable) on collection banner
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I goes to estore collection page
    Then I verify collection name, image on collection banner

  Scenario: Verify 1,2,3 grid views are working fine
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I goes to estore collection page
    Then I validate "1","2" and "3" grid view should work

  Scenario: Change the grid view, go to PG, go back from PG, CG page should render in the same grid view that you previously selected
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to "FABRIC CHAIR COLLECTIONS" on eStore
    When I select "3" grid view on estore CG page
    When I click on random item from collection page with applied "3" grid view
    When I navigate back from "collection page" page
    Then I verify that page render in the same grid view that previously selected

  Scenario: Verify Textile CG having "Enjoy Free Shipping On All Textiles" banner
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When user clicks on textile menu
    When user goes to bedding collections test
    Then I verify that Enjoy Free Shipping On All Textiles banner is displayed

  Scenario: Browser back button from search to CG page
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to "SEATING COLLECTIONS" on eStore
    When I go to estore item "sofa" from search field
    When I navigate back from "PDP" page
    Then I verify that CG page is displayed
    #go to cg->living-seating collections-search-navigate back-cg should displayed

  Scenario: Verify the logo, hamburger icon, search, cart and my account icons on the CG
    Given I log into eStore as "guest" user
    When I click on "Living" for estore
    When I click on "Fabric Seating" for estore
    When I click on "Seating Collections" for estore
    Then I verify that the top navigation, logo, hamburger icon,search should be displayed
    And I verify that cart and my account icons should be displayed

  Scenario: Verify the CG title on the top left corner of the page
    Given I log into eStore as "guest" user
    When I click on "Living" for estore
    When I click on "Fabric Seating" for estore
    When I click on "Seating Collections" for estore
    Then I verify that the CG title on the top left corner of the page

  Scenario: Verify the grid structure on the CG
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I goes to estore collection page
    Then I verify that by default the single grid view should be selected
    And I validate "1","2" and "3" grid view should work

  Scenario: Verify the product details for 1up
    Given I log into eStore as "guest" user
    When I click on "Living" for estore
    When I click on "Fabric Seating" for estore
    When I click on "Seating Collections" for estore
    Then I verify that PG title, description text, member discount message is displayed
    And I verify that In stock and size availability message is displayed

  Scenario: Verify the product details for 2up and 3up
    Given I log into eStore as "guest" user
    When I click on "Living" for estore
    When I click on "Fabric Seating" for estore
    When I click on "Seating Collections" for estore
    When I select 2up grid view on CG for estore
    Then I verify that PG title, description text, member discount message is displayed
    And I verify that In stock and size availability message is displayed
    When I select 3up grid view on CG for estore
    Then I verify that PG title, description text, member discount message is displayed
    And I verify that In stock and size availability message is displayed

  Scenario: Verify the count on the swatches
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to "RECTANGULAR TABLE COLLECTIONS" on eStore
    Then I verify that swatches are displayed for 1up grid view
    When I select 2up grid view on CG for estore
    Then I verify that swatches are displayed for 2up grid view
    When I select 3up grid view on CG for estore
    Then I verify that swatches are displayed for 3up grid view

  Scenario: Verify Sale messages on CG
    Given I log into eStore as "guest" user
    When I open CG page with sale message
    Then I verify that sale message is displayed in Red for CGs with Sale items

  Scenario: Verify the back button feature
    Given I log into eStore as "guest" user
    When I open CG page with sale message
    When I go to estore item "sofa" from search field
    When I navigate back from "fusion PG" page
    Then I verify that user back to the CG from PG or search result page.

  Scenario: Verify back to top button
    Given I log into eStore as "guest" user
    When I click on "Living" for estore
    When I click on "Fabric Seating" for estore
    When I click on "Seating Collections" for estore
    When I scroll to the bottom of the estore page
    When I click on estore back to top button
    Then I verify that page moved to the top on clicking the bottom to top button on CG



