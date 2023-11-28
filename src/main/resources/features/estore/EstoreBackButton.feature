@estoreTestRun
@estoreBackButton

Feature: Estore back button

  Scenario: Verify that user is able to navigate to PDP page upon clicking on Back button in Cart page
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I navigate back from "Cart" page
    Then I verify that PDP screen is displayed

  Scenario: Home Page Back- Verify that user is able to navigate to Home page upon clicking on Back button in Search page
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "17050044 EUCY" from search field
    When I navigate back from "Search" page
    Then I verify that home page load will all sections and links

  Scenario: Home Page Back-Verify that user is able to navigate to Home page upon clicking on Back button in CG page
    Given I log into eStore as "guest" user
    When I click on "Living" for estore
    When I click on "Fabric Seating" for estore
    When I click on "Seating Collections" for estore
    When I navigate back from "CG" page
    Then I verify that home page load will all sections and links

  Scenario: Verify that user is able to navigate to Home page upon clicking on Back button in PG page
    Given I log into eStore as "guest" user
    When I click on "Dining" for estore
    When I click on "Seating" for estore
    When I click on "Leather Seating" for estore
    When I navigate back from "PG" page
    Then I verify that home page load will all sections and links

  Scenario: Verify that user is able to navigate to Home page upon clicking on Back button in Cart page
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore cart icon from header
    When I navigate back from "Cart" page
    Then I verify that home page load will all sections and links

  Scenario: Verify that user is able to navigate to Home page upon clicking on Back button in Account page
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I goes to my account for estore
    When I click on my account button if page is not loaded
    When I navigate back from "Account" page
    Then I verify that home page load will all sections and links

  Scenario: CG Back button-Verify that user is able to navigate to CG page upon clicking on Back button in PG page
    Given I log into eStore as "guest" user
    When I click on "Living" for estore
    When I click on "Fabric Seating" for estore
    When I click on "Seating Collections" for estore
    When I click on random product on collection page
    When I navigate back from "PG" page
    Then I verify that PG page is displayed for eStore

  Scenario: PG Back button-Verify that user is able to navigate to PG page upon clicking on Back button in PDP page
    Given I log into eStore as "guest" user
    When I click on "Dining" for estore
    When I click on "Seating" for estore
    When I click on "Leather Seating" for estore
    When I navigate to any estore fusion PG
    When I navigate back from "fusion PG" page
    When I navigate back from "PDP" page
    Then I verify that PG page is displayed for eStore

  Scenario: Search Back Button- Verify that user is able to navigate to Search page upon clicking on Back button in PDP page
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    When I navigate to any estore fusion PG
    Then I verify that PG page is displayed for eStore

  Scenario: Grid Changes -Verify that user is able to view recently selected grid in CG page upon clicking on Back button in PG page
    Given I log into eStore as "guest" user
    When I click on "Living" for estore
    When I click on "Fabric Seating" for estore
    When I click on "Seating Collections" for estore
    When I click on 2x2 grid view on PG
    When I click on random product on collection page
    When I navigate back from "CG" page
    Then I verify that recently selected 2x2 grid in CG page


  Scenario:Grid Changes PG-Verify that user is able to view recently selected grid in PG page upon clicking on Back button in PDP page
    Given I log into eStore as "guest" user
    When I click on "Dining" for estore
    When I click on "Seating" for estore
    When I click on "Leather Seating" for estore
    When I click on 2x2 grid view on PG
    When I navigate to any estore fusion PG
    When I navigate back from "PDP" page
    Then I verify that user is able to view recently selected 2x2 grid view on PG page

  Scenario: Grid Changes Search- Verify that user is able to view recently selected grid in Search page upon clicking on Back button in PDP page
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    Then I validate "2","2" and "2" grid view should work
    When I navigate to any estore fusion PG
    When I navigate back from "PDP" page
    Then I verify that 2x2 grid view is active on Search page







