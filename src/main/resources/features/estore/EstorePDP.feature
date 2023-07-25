@estoreTestRun

Feature: Estore PDP

  Scenario: Verify user can see the Product Details correctly mentioned for a product
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
    Then I verify that user can see product details correctly mentioned for a product

  Scenario: Verify user can see the correct price for hero image product and the line items
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
    Then I verify user can see the correct price for hero image product and the line items

  Scenario: Verify View In-Stock Options
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
    Then I verify view In-stock options

  Scenario: Verify Details, Dimensions and Fabric
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
    Then I verify Details, Dimensions and Fabric

  Scenario: Verify the product price as per the postal code.
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
    When I update "CAN" postal code on pdp page
    Then verify the product price as per the postal code

  Scenario: Verify the zip code update on PDP
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
    When I update "CAN" postal code on pdp page
    Then verify that the "US" zip code was updated with the "CAN" zip code

  Scenario Outline: Verify Line Items functionality:
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
    Then I verify line items "<functional>"
    Examples:
      | functional            |
      | lineitemimage         |
      | customizeanproduct    |
      | addtowishlist         |
      | locationfunctionality |

    Scenario: Verify the SKU for single and multiple ids
      Given I log into eStore as "regular" user
    When I choose country for eStore from footer
      When I remove all items from estore cart
      When I open product page with "prod13800635" and "17050043" with "INDG" for estore
      Then I verify the sku for single and multiple ids

    Scenario: Verify the browser back and forward buttons.
      Given I log into eStore as "regular" user
    When I choose country for eStore from footer
      When I remove all items from estore cart
      When I open product page with "prod13800635" and "17050043" with "INDG" for estore
      Then I verify that PDP screen is displayed
      And I verify the browser back
      Then I verify the browser forwards button

    Scenario: Verify the search icon and functionality.
      Given I log into eStore as "regular" user
    When I choose country for eStore from footer
      When I remove all items from estore cart
      When I open product page with "prod13800635" and "17050043" with "INDG" for estore
      When I go to estore item "sofa" from search field
      Then I verify the search icon functionality

    Scenario: Verify the product price as per the selected country in the dropdown.
      Given I log into eStore as "regular" user
    When I choose country for eStore from footer
      When I remove all items from estore cart
      When I open product page with "prod13800635" and "17050043" with "INDG" for estore
      When I update "CAN" postal code on pdp page
      Then I verify the product price for the selected country

    Scenario: Verify the product price on PDP for non-sale cushion and frame product
      Given I log into eStore as "regular" user
    When I choose country for eStore from footer
      When I remove all items from estore cart
      When I open product page with "prod13800635" and "17050043" with "INDG" for estore
      Then I verify the product price on PDP for non-sale cushion and frame product

