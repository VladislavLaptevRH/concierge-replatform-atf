@estoreTestRun
@estoreSale
Feature: Estore Sale

  Scenario: Sale Nav verification
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I click on estore sale button
    Then I verify that I'm able to navigate different category

  Scenario: Verify Sale Category
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I goes to estore cart for estore
    When I click on estore sale button
    Then I verify sale category for estore

  Scenario: To verify sale PDP load
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    Then I verify that I'm able to navigate different category

  Scenario: To verify the back button from sale PDP page
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I verify that I'm able to navigate different category
    Then I verify the back button from sale PDP page

  Scenario: Verify that user is able to navigate to secondary NAV of SALE
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click to secondary NAV of Sale
    Then I verify that SALE Nav should be expanded with secondary NAV

  Scenario: Verify that user is able to navigate to tertiary NAV of SALE - Living
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Living from sale nav menu
    Then I verify that Living in Secondary NAV should expand tertiary NAV

  Scenario: Verify that user is able to navigate to tertiary NAV of SALE - Dining
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Dining from sale nav menu
    Then I verify that Dining in Secondary NAV should expand tertiary NAV

  Scenario: Verify that user is able to navigate to tertiary NAV of SALE - Bed
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Bed from sale nav menu
    Then I verify that Bed in Secondary NAV should expand tertiary NAV

  Scenario: Verify that user is able to navigate to tertiary NAV of SALE - Bath
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Bath from sale nav menu
    Then I verify that Bath in Secondary NAV should expand tertiary NAV

  Scenario: Verify that user is able to navigate to tertiary NAV of SALE - Outdoor
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Outdoor from sale nav menu
    Then I verify that Outdoor in Secondary NAV should expand tertiary NAV

  Scenario: Verify that user is able to navigate to tertiary NAV of SALE - Lighting
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Lighting from sale nav menu
    Then I verify that Lighting in Secondary NAV should expand tertiary NAV

  Scenario: Verify that user is able to navigate to tertiary NAV of SALE - Textiles
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Textiles from sale nav menu
    Then I verify that Textiles in Secondary NAV should expand tertiary NAV

  Scenario: Verify that user is able to navigate to tertiary NAV of SALE - Rugs
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Rugs from sale nav menu
    Then I verify that Rugs in Secondary NAV should expand tertiary NAV

  Scenario: Verify that user is able to navigate to tertiary NAV of SALE - Rugs
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Decor from sale nav menu
    Then I verify that Decor in Secondary NAV should expand tertiary NAV

  Scenario: Verify that user is able to navigate to Sale PG on clicking on any Tertiary NAV of SALE
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Decor from sale nav menu
    When I click on Decor Mirrors from nav of Sale
    Then I verify that user is able to navigate to Sale PG

  Scenario: Verify In-stock filter on Sale PG
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Decor from sale nav menu
    When I click on Decor Mirrors from nav of Sale
    When I apply In stock filter on PG for estore
    Then I verify that In stock filter was applied

  Scenario: Verify that price of PDP line item is matching the selected sku from Sale PG
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    When I apply In stock filter on PG for estore
    Then I verify price on PG after In-stock filter was applied
    When I navigate to any estore fusion PG
    Then I verify that price on Sale PG is the same as on PDP after In stock filter was applied

  Scenario: Verify that configurations of PDP line item is matching the selected sku from Sale PG
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    When I apply In stock filter on PG for estore
    Then I verify configurations of sku from Sale PG
    When I navigate to any estore fusion PG
    Then I verify that configurations of PDP line item is matching the selected sku from Sale PG

  Scenario: Verify multiple filters on Sale PG
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Dining from sale nav menu
    When I click on All Dining Tables in tertiary nav
    When I apply In stock filter on PG for estore
    Then I verify that In stock filter was applied

  Scenario: Verify clearing the applied filters
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    When I apply In stock to Sale filter
    When I click on clear all link in applied section filter
    Then I verify that the applied filters have been removed

  Scenario: Verify CG Sale page
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    Then I verify that CG title is displayed on eStore
    And I verify that 1 grid view should be selected state by default
    Then I verify that each collection have image, title

  Scenario: Verify that price in PDP is matching the selected product from Sale PG
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    When I apply In stock filter on PG for estore
    Then I verify price on PG after In-stock filter was applied
    When I navigate to any estore fusion PG
    Then I verify that price on Sale PG is the same as on PDP after In stock filter was applied

  Scenario: Verify that user is able to see the combined price of frame and cushion on Sale PG
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Decor from sale nav menu
    When I click on Decor Mirrors from nav of Sale
    Then I verify that combined price on frame and cushion on PG

  @sale
  Scenario: Verify PG Sale page via CG Sale
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Bed from sale nav menu
    When I click on Bedding collection from tertiary NAV
    When I navigate to any estore fusion PG
    Then I verify that PG title, description text, member discount message is displayed for Bedding Collection

  Scenario: Verify that user is able to change grid on sale PG
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Dining from sale nav menu
    When I click on All Dining Tables in tertiary nav
    Then I validate "1","2" and "3" grid view should work

  Scenario: Verify user is able to change the sort option - Price: Low to High
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Decor from sale nav menu
    When I click on Decor Mirrors from nav of Sale
    When I select low to high for estore
    Then I verify that sorting low to high is working as expected

  Scenario:Verify user is able to change the sort option - Price: High to Low
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Decor from sale nav menu
    When I click on Decor Mirrors from nav of Sale
    When I select high to low for estore
    Then I verify that sorting high to low is working as expected

  Scenario:Verify user is able to change the sort option - Featured
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore sale button
    When I click on Decor from sale nav menu
    When I click on Decor Mirrors from nav of Sale
    Then I verify that user is able to change the sort option - Featured

  Scenario: Verify Sale CG via Bed Top Nav
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on Bed in TOP NAV menu
    When I click on SALE in Secondary NAV
    When I click on Bedroom collection in Tertiary NAV
    Then I verify that CG title is displayed on eStore
    And I verify that 1 grid view should be selected state by default
    Then I verify that each collection have image, title

  Scenario: Verify Sale PG via Bed Top Nav
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on Bed in TOP NAV menu
    When I click on SALE in Secondary NAV
    When I click on Beds in Tertiary NAV
    Then I verify that PG title is displayed for Beds
    And I verify that sale filter should be not displayed in Filter section
    Then I verify that number of products should be displayed as RESULTS
    And I verify that default sort order should be featured
    Then I verify that 3x3 grid should be in selected state by default
    And I verify sale prices on PG pages for sale items
    Then I verify that the swatches should show below the image with correct padding
    And I verify that available in multiple sizes&finishes should be displayed

  Scenario: Verify Sale PG via Living Top Nav
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on Living in TOP NAV menu
    When I click on SALE in Secondary NAV
    When I click on Sectionals in Tertiary NAV from Living
    Then I verify that PG title is displayed for Beds
    And I verify that sale filter should be not displayed in Filter section
    Then I verify that number of products should be displayed as RESULTS
    And I verify that default sort order should be featured
    Then I verify that 3x3 grid should be in selected state by default
    And I verify sale prices on PG pages for sale items
    Then I verify that the swatches should show below the image with correct padding
    And I verify that available in multiple sizes&finishes should be displayed

  Scenario:Verify Sale PG via Bath Top Nav
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on "Bath" in TOP NAV menu
    When I click on SALE in Secondary NAV
    When I click on "Shelving" in Tertiary NAV from "Bath"
    Then I verify that PG title is displayed for "Shelving"
    And I verify that sale filter should be not displayed in Filter section
    Then I verify that number of products should be displayed as RESULTS
    And I verify that default sort order should be featured
    Then I verify that 3x3 grid should be in selected state by default
    And I verify sale prices on PG pages for sale items
    Then I verify that the swatches should show below the image with correct padding

  Scenario:Verify Sale PG via Dining Top Nav
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on "Dining" in TOP NAV menu
    When I click on SALE in Secondary NAV
    When I click on "All Dining Tables" in Tertiary NAV from "Dining"
    Then I verify that PG title is displayed for "All Dining Tables"
    And I verify that sale filter should be not displayed in Filter section
    Then I verify that number of products should be displayed as RESULTS
    And I verify that default sort order should be featured
    Then I verify that 3x3 grid should be in selected state by default
    And I verify sale prices on PG pages for sale items
    Then I verify that the swatches should show below the image with correct padding

  Scenario: Verify Sale PG via Outdoor Top Nav
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on "Outdoor" in TOP NAV menu
    When I click on SALE in Secondary NAV
    When I click on "Sofas" in Tertiary NAV from "Outdoor"
    Then I verify that PG title is displayed for "Sofas"
    And I verify that sale filter should be not displayed in Filter section
    Then I verify that number of products should be displayed as RESULTS
    And I verify that default sort order should be featured
    Then I verify that 3x3 grid should be in selected state by default
    And I verify sale prices on PG pages for sale items
    Then I verify that the swatches should show below the image with correct padding

  Scenario: Verify Sale PG via Textiles Top Nav
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on "Textiles" in TOP NAV menu
    When I click on SALE in Secondary NAV
    When I click on "Quilts & Coverlets" in Tertiary NAV from "Textiles"
    Then I verify that PG title is displayed for "All quilt s and coverlet s"
    And I verify that sale filter should be not displayed in Filter section
    Then I verify that number of products should be displayed as RESULTS
    And I verify that default sort order should be featured
    Then I verify that 3x3 grid should be in selected state by default
    And I verify sale prices on PG pages for sale items

  Scenario: Verify Sale PG via Rugs Top Nav
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on "Rugs" in TOP NAV menu
    When I click on SALE in Secondary NAV
    When I click on "Grey Rugs" in Tertiary NAV from "Textiles"
    Then I verify that PG title is displayed for "Grey Rugs"
    And I verify that sale filter should be not displayed in Filter section
    Then I verify that number of products should be displayed as RESULTS
    And I verify that default sort order should be featured
    Then I verify that 3x3 grid should be in selected state by default
    And I verify sale prices on PG pages for sale items

  Scenario: Verify Sale PG via DÃ©cor Top Nav
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on "Décor" in TOP NAV menu
    When I click on SALE in Secondary NAV
    When I click on "Mirrors" in Tertiary NAV from "Décor"
    Then I verify that PG title is displayed for "Mirrors"
    And I verify that sale filter should be not displayed in Filter section
    Then I verify that number of products should be displayed as RESULTS
    And I verify that default sort order should be featured
    Then I verify that 3x3 grid should be in selected state by default
    And I verify sale prices on PG pages for sale items
    Then I verify that the swatches should show below the image with correct padding

  Scenario:Verify Sale CG via Living Top Nav
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on "Living" in TOP NAV menu
    When I click on SALE in Secondary NAV
    When I click on "Seating Collections" in Tertiary NAV from "Living"
    Then I verify that PG title is displayed for "Seating Collections"
    And I verify that 1 grid view should be selected state by default
    Then I verify that each collection have image, title

  Scenario:Verify Sale CG via Living Top Nav
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on "Living" in TOP NAV menu
    When I click on SALE in Secondary NAV
    When I click on "Seating Collections" in Tertiary NAV from "Living"
    Then I verify that PG title is displayed for "Seating Collections"
    And I verify that 1 grid view should be selected state by default
    Then I verify that each collection have image, title

  Scenario: Verify Sale CG via Bath Top Nav
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on "Bath" in TOP NAV menu
    When I click on SALE in Secondary NAV
    When I click on "Bath Collections" in Tertiary NAV from "Bath"
    Then I verify that CG title is displayed for "Bath  collections"
    And I verify that 1 grid view should be selected state by default
    Then I verify that each collection have image, title

  Scenario: Verify Sale CG via Textiles Top Nav
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on "Textiles" in TOP NAV menu
    When I click on SALE in Secondary NAV
    When I click on "Bedding Collections" in Tertiary NAV from "Textiles"
    Then I verify that CG title is displayed for "Bedding  collections"
    And I verify that 1 grid view should be selected state by default on CG
    Then I verify that images are displayed on CG for estore

  Scenario: Verify Sale CG via Outdoor Top Nav
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on "Outdoor" in TOP NAV menu
    When I click on SALE in Secondary NAV
    When I click on "Furniture Collections" in Tertiary NAV from "Outdoor"
    Then I verify that CG title is displayed for "Furniture  collections"
    And I verify that 1 grid view should be selected state by default on CG
    Then I verify that images are displayed on CG for estore

  Scenario: Verify back to top button Sale
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on "Rugs" in TOP NAV menu
    When I click on SALE in Secondary NAV
    When I click on "Brown Rugs" in Tertiary NAV from "Rugs"
    When I scroll to the bottom of the estore page
    Then I verify that page moved to the top on clicking the bottom to top button on CG

  Scenario Outline: Verify that user is able to see Sale Nav on all brands
    Given I log into eStore as guest
    When I choose country for eStore from footer
    When  I change the brand to "<brand>" for eStore
    Then I verify that SALE is present on TOP Nav menu
    Examples:
      | brand           |
      | RH CONTEMPORARY |
      | RH INTERIORS    |
      | RH MODERN       |
      | RH OUTDOOR      |
      | RH BEACH HOUSE  |
      | RH SKI HOUSE    |
      | RH TEEN         |
      | RH BABY & CHILD |




