@estoreTestRun
@estorePDP
Feature: Estore PDP

  Scenario: Verify user can see the Product Details correctly mentioned for a product
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    Then I verify that user can see product details correctly mentioned for a product

  Scenario: Verify user can see the correct price for hero image product and the line items
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    Then I verify user can see the correct price for hero image product and the line items

  Scenario: Verify View In-Stock Options
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    Then I verify view In-stock options
    Then I add quantity and add to cart In-stock options

  Scenario: Verify Details, Dimensions and Fabric
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    Then I verify Details, Dimensions and Fabric

  Scenario: Verify the product price as per the postal code.
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    When I update "CAN" postal code on pdp page
    Then verify the product price as per the postal code

  Scenario: Verify the zip code update on PDP
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    When I update "CAN" postal code on pdp page
    Then verify that the "US" zip code was updated with the "CAN" zip code

  Scenario Outline: Verify Line Items functionality:
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "BLK" for estore
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
    When I open product page with "prod13800635" and "17050042" with "BLK" for estore
    Then I verify the sku for single and multiple ids

  Scenario: Verify the browser back and forward buttons.
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "BLK" for estore
    Then I verify that PDP screen is displayed
    And I verify the browser back
    Then I verify the browser forwards button

  Scenario: Verify the search icon and functionality.
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "BLK" for estore
    When I go to estore item "sofa" from search field
    Then I verify the search icon functionality

  Scenario: Verify the product price as per the selected country in the dropdown.
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    When I update "CAN" postal code on pdp page
    Then I verify price for member and regular user on PDP
    Then I verify the product price for product "prod19500002" and "17050045" with "NCKL" for the selected "CAN" country

  Scenario: Verify the product price on PDP for non-sale cushion and frame product
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    Then I verify the product price for product "prod19500002" and "17050045" with "NCKL" for the selected "CAN" country

  Scenario: Verify the text displaying before the price is "starting at" at hero image level
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
    Then I verify the text displaying before price at hero image level for product "prod13800635" and "17050043" with "INDG" for the selected "CAN" country

  Scenario: Verify the text displaying before the price is "starting at" at line item level
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
    Then I verify the text displaying before price at line item level for product "prod13800635" and "17050043" with "INDG" for the selected "CAN" country

  Scenario: Verify the line item price for Combined Frame + Cushion
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod7551915" and "97670" with "INDG" for estore
    Then I verify the line item price for Combined Frame and Cushion for product "prod13800635" and "17050043" with "INDG" for the selected "CAN" country

  Scenario: Verify that user is able to add line item separately
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    Then I verify that user is able to add line item separately for product "prod13800635" and "17050042" with "WHEA" for the selected "CAN" country

  Scenario: Verify availability delivery and return for product
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
    Then I verify availability delivery and return for product "prod13800635" and "17050043" with "INDG" for the selected "CAN" country

  Scenario: Verify functionality for Hero Image on PDP
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
    Then I verify functionality for Hero Image on PDP for product "prod13800635" and "17050043" with "INDG" for the selected "CAN" country

  Scenario: Verify the product price as per the Ship to selection
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
    Then I verify the product price as per the Ship to selection for product "prod13800635" and "17050043" with "INDG" for the selected "CAN" country

  Scenario: Verify View On Sale Options
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
    And I verify view sale
    Then I add quantity and add to cart In-stock options

  Scenario: Verify the Add to Wishlist
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
    And I click Add to Wishlist
    Then I verify the items present in the wishlist

  Scenario: Verify Add to Cart functionality button on PDP.
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
    And I click Add to Cart and validate the added items in the cart

  Scenario: Verify the text displaying befor price for Frame and cushion product
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod7551915" and "97670" with "INDG" for estore
    Then I get prices for US for eStore

  Scenario: Verify the product price on PDP for sale cushion and frame product
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod9460026" and "46680991" with "INDG" for estore
    Then Sale price validated before and after customizing

  Scenario: Verify the product price on PDP for sale cushion and frame product with sale==true
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When Product with Sale URL is opened
    Then Sale price validated and URL sale==true

  Scenario: Verify the product price on PDP for sale cushion and frame product with sale link available
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod10720085" and "46680991" with "INDG" for estore
    Then Sale link validated along with selecting value

  Scenario: Verify the PDP title and pricing
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open the product category "cat25450027"
    Then I verify the PDP title and pricing for product

  Scenario: Verify the content of PDP for eStore - verifying SOFA PDP
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod30390106" and "" with "INDG" for estore
    Then I verify the content of PDP for eStore - verifying SOFA PDP

  Scenario: Verifying another PDP - Chaise
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod14020058" and "17050043" with "INDG" for estore
    Then I verify another PDP - Chaise

  Scenario: Verifying PDP content - Bench
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod20850154" and "" with "INDG" for estore
    Then I verify another PDP - Bench

  Scenario: Verifying PDP content - Towel
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
    Then I verify another PDP - Towel

  @Alok
  Scenario: Verify the PDP hero Image Zoom line items
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod18890296" and "" with "INDG" for estore
    Then I verify the PDP hero Image Zoom line items
  @Alok
  Scenario: Verify IN STOCK functionality
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "" with "INDG" for estore
    Then I verify IN STOCK functionality
  @Alok
  Scenario: Verify the availability , delivery and return messages in PDP
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
    Then I verify availability delivery and return for product "prod13800635" and "17050043" with "INDG" for the selected "CAN" country

  Scenario: PDP Content - Verify on the PDP pages prices are changing with the country zip
    Given I log into eStore as "regular" user
    When I remove all items from estore cart
    When I choose country for eStore from footer
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    When I get prices for US for eStore
    When I update "CAN" postal code on pdp page
    Then I verify that prices for "CAN" was updated
    When I update "US" postal code on pdp page
    Then I verify that prices for "US" was updated





