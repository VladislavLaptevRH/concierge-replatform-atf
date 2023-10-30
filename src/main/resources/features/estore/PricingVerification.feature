@estoreTestRun
@estorePricingValidation

Feature: Pricing Verification

  Scenario: Verify user can see the correct pricing mentioned on the PG pages
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "sofa" from search field
    Then I verify that the price mentioned on PG page

  Scenario: PDP Content- Verify the prices are matching between PG and PDP pages
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "sofa" from search field
    When I check price for "sofa" on PG page for estore
    When I navigate to any estore fusion PG
    Then I verify that prices are matching between PG nad PDP pages

  Scenario: PG/DP Content- Verify User can see the correct prices for the VIEW SELECT ITEMS ON SALE on PG and the sale page
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "sofas" from search field
    When I apply In stock to Sale filter
    When I check sale price for "sofa" on PG page for estore
    When I go to the sale page with "sofas" on estore
    Then I verify that prices for the VIEW SELECT ITEMS ON SALE on PG and the sale page

  Scenario: PDP Content- Verify User can see the correct prices for the VIEW SELECT ITEMS ON SALE on PDP and the sale page
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "sofas" from search field
    When I apply In stock to Sale filter
    When I check sale price for "sofa" on PG page for estore
    When I navigate to any estore fusion PG
    Then I verify that prices for the VIEW SELECT ITEMS ON SALE on PDP and the sale page

  Scenario: Verify the products are shown with relevant colorized images on PG page when instock filter is selected
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    When I apply In stock filter on PG for estore
    Then I verify that the products are shown with relevant colorized images on PG page

  Scenario: PDP Content-Verify on the PG pages prices are changing with the country zip
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    When I check the prices for "US" zip code
    When I update zip code to "CAN" zip code on PG from footer
    Then I verify that prices for "CAN" was updated on PG
    When I update zip code to "US" zip code on PG from footer
    Then I verify that prices for "US" was updated on PG

  Scenario: PDP Content- Verify the prices are mentioned correctly where the filters are applied and the PDP page
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    When I apply In stock filter on PG for estore
    Then I verify that the prices shown against instock products on PG page
    When I navigate to any estore fusion PG
    And I verify that price on PG is the same as on PDP for In stock filter applied



