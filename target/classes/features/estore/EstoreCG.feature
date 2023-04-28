@estoreRegression
@estoreCGPage
Feature: Estore CG

  Scenario Outline: CG - Test CGS in all menu items (All brands)

    Given I log into eStore as "guest" user
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
    When I goes to estore collection page
    Then I validate the collection name is not empty

  Scenario: CG-Verify Shop In Stock Link
    Given I log into eStore as "regular" user
    When I remove all items from estore cart

  Scenario: CG-Verify Back To top Button
    Given I log into eStore as "guest" user
    When I goes to estore collection page
    When I scroll on the page till back to top button is visible
    Then I verify that back to top button is clickable
    And I verify that after click on back to top button user is scrolled to top on the page

  Scenario: Verify single Grid View is as default on CG
    Given I log into eStore as "guest" user
    When I goes to estore collection page
    Then I verify that single grid view is selected on CG page by default

  Scenario: Verify collection name,image (regular,member,sale(applicable) on collection banner
    Given I log into eStore as "guest" user
    When I goes to estore collection page
    Then I verify collection name, image on collection banner

  Scenario: Verify 1,2,3 grid views are working fine
    Given I log into eStore as "guest" user
    When I goes to estore collection page
    Then I validate "1","2" and "3" grid view should work

  Scenario: Change the grid view, to to PG, go back from PG, CG page should render in the same grid view that you previously selected
    Given I log into eStore as "guest" user
    When I goes to estore collection page
    When I select "3" grid view on estore CG page
    When I go to estore item "white and blue corner leather sofa" from search field
    When I goes to estore collection page
    Then I verify that page render in the same grid view that previously selected

  Scenario: Verify Textile CG having "Enjoy Free Shipping On All Textiles" banner
    Given I log into eStore as "guest" user
    When user clicks on textile menu
    When user goes to bedding collections test
    Then I verify that Enjoy Free Shipping On All Textiles banner is displayed

#  Scenario: Verify CG name is visible on Preview the collection model
#    Given I log into eStore as "guest" user
#    When I goes to estore collection page
#    When I click on preview the collection link
#    Then I verify that I'm landing on preview the collection model
#
#  Scenario: Verify the close button on Preview the Collection Modal
#    Given I log into eStore as "guest" user
#    When I goes to estore collection page
#    When I click on preview the collection link
#    When I click on close button on preview the collection modal pop up
#    Then I verify after click on X icon model gets closed
#
#  Scenario: Verify Preview the Collection Modal is scrollable and after scrooling all products are visible on the model
#    Given I log into eStore as "guest" user
#    When I goes to estore collection page
#    When I click on preview the collection link
#    Then I verify that collection modal is scrollable

#  Scenario: Verify after clicking on any product from the Preview Collection model user lands on the PDP page
#    Given I log into eStore as "guest" user
#    When I goes to estore collection page
#    When I click on preview the collection link
#    When I click on any product from the preview collection model
#    Then I verify that estore PDP page is displayed