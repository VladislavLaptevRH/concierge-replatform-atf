@estoreParallelTestRun

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

  Scenario: CG-Verify Shop In Stock Link
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart

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
    When I go to estore item "white and blue corner leather sofa" from search field
    When I go to "SEATING COLLECTIONS" on eStore
    Then I verify that page render in the same grid view that previously selected

  Scenario: Verify Textile CG having "Enjoy Free Shipping On All Textiles" banner
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When user clicks on textile menu
    When user goes to bedding collections test
    Then I verify that Enjoy Free Shipping On All Textiles banner is displayed