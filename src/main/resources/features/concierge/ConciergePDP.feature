@conciergeTestRun
@conciergePDP
Feature: Concierge PDP

  Scenario: Verify the PDP title and pricing
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I navigate to "sofas"
    Then I remember the name of the first product and regular, member prices in PG and navigate to that PDP
    Then I Verify that the PDP title is present and prices match those prices in PG

  Scenario Outline: Verify the content of PDP for Concierge
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "<skuID>" from search field
    Then I Verify that 'PDP title' is present
    Then I Verify that 'the "Hero" Image' is present
    Then I Verify that '"Zoom" button' is present
    Then I Verify that 'images carousel is present below Hero image' is present
    Then I Verify that 'sections "dimensions" and "details"' is present
    Then I Verify that 'line items' is present
    Then I Verify that '"add to cart" and "add to project" buttons' is present
    Then I Verify that 'text "Learn more about our Return Policy"' is present
    Then I Verify that '"footer" in PDP' is present
    Then I chose zero choose in line items
    Then I chose zero choose in line items
    Then I verify the rest of the checkings for "<skuID>"
    Examples:
      |skuID        |
      |57070740 CLNT|
      |61970975 TEAK|
      |62870050 LOAK|
      |10024793 BRNZ|

  Scenario: Verify the PDP hero Image, zoom, line itemsVerify the PDP hero Image, zoom, line items
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I open product page with productId "prod18890296"
    When I click on the first project search result with parameters 'prod18890296''10024793 BRNZ'
    Then I Verify that 'item title' is present
    Then I Verify that '"Zoom" button' is present
    Then I Verify that 'the "Hero" Image' is present
    Then Verify that 'shop the entire collection'
    Then Verify that 'zoom button is clickable and zoom module is opened'
    Then Verify that 'is present view carousel is present on the right of the zoomed hero image and scrolling are present'
    Then Verify that 'plus and minus buttons are clickable and functioning'
    Then Verify that 'close the Zoom in Module'
    Then I Verify that 'images carousel is present below Hero image' is present
    Then Verify that 'left and right arrows are present and number of alt images is 5'
    Then Verify that 'line item selections (Size, Finish and Qty) are present'
    Then Verify that 'smaller preview product picture is present on the left of line items'
    Then Verify that 'View in-stock Items and View Sale Items links are present'
    Then I chose zero choose in line items
    Then Verify that 'text "Configure this item to view delivery information to" is present'
    Then Verify that 'text Swatch is present'
    Then Verify that 'Swatch image is present'
    Then Verify that 'line item for Swatch is present'
    Then Verify that 'text "Swatches are shipped at no charge" is present'
    Then Verify that 'text Furniture Touch-up Kit is present'
    Then Verify that 'button Check for Replacement parts is present'
    Then I Verify that '"footer" in PDP' is present
    Then I chose the '1' line item selections one by one
    Then Verify that 'text "This item will be ready for delivery between" is present'
    Then Verify that 'text "Unlimited Furniture Delivery" is present'
    Then I verify that text item# and SKU is present
    Then Verify that 'text "This item can be returned or exchanged within 30 days of delivery" is present'
    Then Verify that 'Add to Cart and Add to Project buttons are active'
    Then Verify that 'confirm that Add to Cart slider is present'
    Then Project modal appears and has all the data for '10024796'
    Then verify that another modal appears with all the data for '10024796'

  Scenario: Verify In Stock functionality
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'In Stock'
    Then I navigate to gallery 'Beds'
    Then I click 'first product from the list' on PG screen
    When I click on "view in stock items" link
    Then Verify that "In Stock modal" 'opens'
    Then Verify that "In Stock modal" 'has title'
    Then Verify that "In Stock modal" 'has item#'
    Then Verify that "In Stock modal" 'has price and member price'
    Then Verify that "In Stock modal" 'has qty dropdown'
    Then Verify that "In Stock modal" 'has "add to cart" and "add to project" buttons'
    Then Verify that "In Stock modal" 'has an item can be added to cart from modal'
    Then Verify that "In Stock modal" 'has an item can be added to project from modal'

  Scenario: Verify On Sale functionality
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    When I click on "view select items on sale" link
    Then Verify that "Sale modal" 'opens'
    Then Verify that "Sale modal" 'has title'
    Then Verify that "Sale modal" 'has item#'
    Then Verify that "Sale modal" 'has price, member and sale price'
    Then Verify that "Sale modal" 'has qty dropdown'
    Then Verify that "Sale modal" 'has "add to cart" and "add to project" buttons'
    Then Verify that "Sale modal" 'has an item can be added to cart from modal'
    Then Verify that "Sale modal" 'has an item can be added to project from modal'

  Scenario Outline: Availability, Delivery and Returns messaging for <items>
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "<skuID>" from search field
    Then I chose the '1' line item selections one by one
    Then I verify that availability, Delivery and returns messaging is displayed for "<items>"
    Examples:
      | items | skuID         |
      | SO    | 59810779 CTBZ |
      | BO    | 10024793 BRNZ |

  Scenario: Verify the dropdown selection and add to cart
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to concierge item 'prod12640168' from search field
    When I click on the first project search result with parameters 'prod12640168''59810779 CTBZ'
    Then I Verify that 'item title' is present
    Then Verify that 'text "Components starting at" is present'
    Then Verify that 'cloud Modular Leather Sofa titles are present'
    Then Verify that line item field 'Fill' is present
    Then Verify that line item field 'Leather' is present
    Then Verify that line item field 'Depth' is present
    Then Verify that line item field 'Color' is present
    Then I chose zero choose in line items
    Then Verify that 'text "Configure this item to view delivery information to" is present'
    Then Verify that 'Add to Cart and Add to Project buttons are inactive'
    Then I chose the '1' line item selections one by one
    Then I verify that text item# and SKU is present
    Then Verify that 'text "Unlimited Furniture Delivery" is present'
    Then I verify that check for replacements parts button is displayed
    Then Verify that 'Add to Cart and Add to Project buttons are active'
    When I click on add to cart button
    Then Verify that 'confirm that Add to Cart slider for SO is present'
    Then Verify that 'verify data in the modal for SO'
    Then Verify that 'click Agree and add to cart'
    When I click on view cart button
    Then I open cart
    Then Verify that 'cart page has item (SKU)'
    Then Verify that 'price is matching PDP'

  Scenario: Verify Colorization options
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "10115451 BWMR" from search field
    When I click on special order fabrics
    When I choose color from special order fabrics
    Then I verify that color has been chosen

  Scenario: Verify Monogram functionality
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I open product page with productId "prod19500002"
    When I click on add monogram checkbox from pdp
    When I choose monogram properties for pdp
    Then I verify that monogram was added for pdp

  Scenario Outline: Add To Cart (Instock, SPO, BO) functionality
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "<skuID>" from search field
    When I click on "view in stock items" link
    Then Verify that "In Stock modal" 'opens'
    Then I click on 'Add an item to cart from pop-up modal' switch button
    When I click on view cart button
    Then Verify that 'sku is present in Cart'
    Examples:
      | skuID         |
      | 60450996 BLNL |

  Scenario: ATC BO - add to cart
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "10024793 BRNZ" from search field
    Then I chose the '1' line item selections one by one
    Then I chose the '1' line item selections one by one
    When I click on add to cart button
    When I click on view cart button
    Then I verify that availability, Delivery and returns messaging is displayed for "BO"

  Scenario: ATC BO - add to cart
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "10060297 CLR" from search field
    Then I chose the '1' line item selections one by one
    When I click on add to cart button
    When I click on view cart button
    Then I verify that availability, Delivery and returns messaging is displayed for "BO"

  Scenario: Verify Custom Drapery PDP
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I choose "RH Teen" from brand menu
    When I go to custom rugs
    Then I verify that custom rugs are displayed

  Scenario: Verify YAML Carousel
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I open product page with productId "prod14900056"
    Then I verify that YAML carousel is displayed

  Scenario: SLP (Swatch Landing Page)
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to Swatch Landing Page
    Then I verify that swatch landing page is displayed

  Scenario: Verify the Postal code updates in PDP
    Given I log into Concierge as "associate"
    When I choose 'US' country
    When I go to item "10115451 BWMR" from search field
    Then Verify that 'default US zip code is present in PDP'
    Then I click on zip code and change it to '10001'
    Then I verify that zip code in PDP is '10001'
    When I choose 'CA' country
    Then I click on zip code and change it to 'H1Y2B5'
    Then I verify that zip code in PDP is 'H1Y 2B5'
    Then Verify that 'price in PDP changed from US$ to CA$'
    When I choose 'GB' country
    Then I click on zip code and change it to 'SW1A1AA'
    Then I verify that zip code in PDP is 'SW1A1AA'
    Then Verify that 'Confirm that PDP has price in GBP'

  Scenario: Sale PDP: Regular/Member/Final Price validation
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I choose country for concierge from footer
    When I navigate to "Sale"
    Then I choose a random sale item
    Then Verify that 'PDP has SALE and MEMBER prices'

  Scenario Outline: Verify Mattress Recycling Fee
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "10004670 NONE" from search field
    Then I chose the '1' line item selections one by one
    Then I chose the '1' line item selections one by one
    When I change state for "<state>" with zip code "<zipCode>"
    Then I verify that text ""<state>" requires a mattress recycling fee to be collected at checkout state" is present in PDP
    When I click on add to cart button
    When I click on view cart button
    Then I verify text "Mattress fee" and amount in checkout is present for state "<state>"
    Examples:
      | state | zipCode|
      | RI    | 02860  |
      | CT    | 06902  |
      | CA    | 94925  |

  Scenario: Custom Jewelry
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I choose "RH Teen" from brand menu
    When I go to custom rugs
    Then I verify that custom rugs are displayed

#  Scenario: Custom Windows
#    Given I log into Concierge as "associate"
#    When I choose country for concierge from footer
#    When I click on windows from top menu
#    Then I verify that custom windows are displayed

  Scenario: Replacement Items
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "10004670 NONE" from search field
    Then I chose the '1' line item selections one by one
    Then I verify that check for replacements parts button is displayed
    Then I click on 'CHECK FOR REPLACEMENT PARTS' button
    And I verify that replacements parts modal pop up is displayed

  Scenario: Add to Cart, Add All to Cart
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I chose '6' product on the page
    Then I Verify that 'item title' is present
    Then I chose the '1' line item selections one by one for '5' items
    Then I click on button "ADD TO CART" in the cart
    Then I verify that cart modal is displayed
    Then I click on button "ADD ALL TO CART" in the cart
    Then I verify that cart modal is displayed for more than one item

  Scenario: Add to Project, Add All to Project
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I chose '6' product on the page
    Then I Verify that 'item title' is present
    Then I chose the '1' line item selections one by one for '5' items
    Then I click on button "ADD TO PROJECT" in the cart
    Then I verify that project modal is displayed
    Then I click on button "ADD ALL TO PROJECT" in the cart
    Then I verify that project modal is displayed

  Scenario: After clicking on Detail section it should be expanded with - symbol
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I chose '6' product on the page
    Then I Verify that 'item title' is present
    Then I Verify that 'the "Hero" Image' is present
    Then I Verify that '"Zoom" button' is present
    Then I Verify that 'images carousel is present below Hero image' is present
    Then I Verify that 'sections "dimensions" and "details"' is present
    Then I Verify that 'line items' is present
    Then I Verify that 'sections "dimensions" and "details"' is present
    Then I click 'DETAILS section' on pdp page
    Then I Verify that 'Section should be expanded' is present

  Scenario: If links are present inside the Details section, then it should be opened with resp pop up modal
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I chose '6' product on the page
    Then I Verify that 'item title' is present
    Then I Verify that 'the "Hero" Image' is present
    Then I Verify that '"Zoom" button' is present
    Then I Verify that 'images carousel is present below Hero image' is present
    Then I Verify that 'line items' is present
    Then I Verify that 'sections "dimensions" and "details"' is present
    Then I click 'DETAILS section' on pdp page
    Then I Verify that 'Section should be expanded' is present
    Then I click 'link (If available) in DETAILS section' on pdp page

  Scenario: Learn more about our Return Policy should be displayed by default which has Link for Return Policy
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I chose '6' product on the page
    Then I Verify that 'item title' is present
    Then I Verify that 'the "Hero" Image' is present
    Then I Verify that '"Zoom" button' is present
    Then I Verify that 'images carousel is present below Hero image' is present
    Then I Verify that 'sections "dimensions" and "details"' is present
    Then I Verify that 'line items' is present
    Then I Verify that 'text "Learn more about our Return Policy"' is present

  Scenario: If we enter invalid zipcode then error message should be displayed
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I chose '6' product on the page
    Then I Verify that 'item title' is present
    Then I Verify that 'the "Hero" Image' is present
    Then I Verify that '"Zoom" button' is present
    Then I Verify that 'images carousel is present below Hero image' is present
    Then I Verify that 'sections "dimensions" and "details"' is present
    Then I Verify that 'line items' is present
    Then I chose the '1' line item selections one by one
    Then Verify that 'Verify the delivery information'
    And I change zip code on PDP page to "111"
    Then Verify that 'we enter invalid zipcode then error message should be displayed'

  Scenario: After clicking on any image, redirected to PDP page
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Leather Beds'
    Then I chose '6' product on the page
    Then I Verify that 'item title' is present
    Then I click 'any product image in carousel' on pdp page
    Then Verify that 'User should be navigated to respective PDP'

  Scenario: Yaml carousel update as per country selection
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I open product page with productId "prod14900056"
    Then I Verify that 'item title' is present
    Then I Verify that 'line items' is present
    Then I chose the '1' line item selections one by one
    Then Verify that 'Verify the delivery information'
    When I choose 'CA' country
    And I change zip code on PDP page to "H1Y2B5"
    Then I verify that YAML carousel is displayed

  Scenario: Related products : YML
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I open product page with productId "prod14900056"
    Then I Verify that 'item title' is present
    Then I Verify that 'line items' is present
    Then I verify that YAML carousel is displayed

  Scenario: Uphostry, Material, and/or Finish Swatches
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I open product page with productId "prod14900056"
    Then I Verify that 'item title' is present
    Then I Verify that 'line items' is present
    Then I Verify that 'Upholstery Swatch section' is present
    Then Verify that 'text Swatch is present'
    Then Verify that 'Swatch image is present'
    Then Verify that 'line item for Swatch is present'
    Then Verify that 'text "Swatches are shipped at no charge" is present'

  Scenario: Hero image, Line level product images
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Leather Beds'
    Then I chose '6' product on the page
    Then I Verify that 'item title' is present
    Then I Verify that 'the "Hero" Image' is present
    Then I Verify that '"Zoom" button' is present
    Then I Verify that 'images carousel is present below Hero image' is present

  Scenario: Product details
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Leather Beds'
    Then I chose '6' product on the page
    Then I Verify that 'item title' is present
    Then I Verify that 'the "Hero" Image' is present
    Then I Verify that '"Zoom" button' is present
    Then I Verify that 'images carousel is present below Hero image' is present
    Then I Verify that 'sections "dimensions" and "details"' is present
    Then I Verify that 'line items' is present
    Then I Verify that '"add to cart" and "add to project" buttons' is present
    Then I Verify that 'text "Learn more about our Return Policy"' is present
    Then I Verify that '"footer" in PDP' is present

  Scenario: PDP Swatch Landing Page
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Living'
    Then I navigate to sub menu 'Fabric Seating'
    Then I navigate to gallery 'Upholstery Swatches'
    Then Verify that 'the page is loading'
    Then Verify that 'CARE INSTRUCTIONS link is present'
    Then Verify that 'COMPLIMENTARY SWATCHES floater is present and moving as user scrolls down'
    Then Verify that 'after selecting color ORDER SWATCHES button is activated'
    Then Verify that 'after clicking ORDER SWATCHES user sees DELIVERY pop up'
    Then Verify that 'form has the fields: First Name, Last Name, Email, Phone, Address,Apt, suite etc, City, State, Zip, Country Dropdown, Place Order Button'
    Then Verify that 'fill in all fields'
    Then Verify that 'after placing order Thank You Message is displayed with text Your order has been placed..'
    Then Verify that 'Keep Shopping button is present'
    Then Verify that 'clicking Keep Shopping button closes the Thank you modal and user stays on the Swatches page'

  Scenario: Unlimited furniture items
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "Unlimited furniture items" from search field
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present
    Then I chose the '1' line item selections one by one
    Then Verify that 'text "Unlimited Furniture Delivery" is present'

  Scenario: Product name should be displayed on top of the section
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Leather Beds'
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present

  Scenario: After clicking on the link istock modal should be opened
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'In Stock'
    Then I navigate to gallery 'Beds'
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present
    When I click on "view in stock items" link
    Then Verify that "In Stock modal" 'opens'

  Scenario: Also available/Explore links should be dispalyed as per the product with > symbol
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Leather Beds'
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present
    Then I Verify that 'the "Hero" Image' is present
    Then I Verify that '"Zoom" button' is present
    Then I Verify that 'images carousel is present below Hero image' is present
    Then I Verify that 'line items' is present
    Then I Verify that '"add to cart" and "add to project" buttons' is present
    Then I Verify that 'text "Learn more about our Return Policy"' is present
    Then I Verify that '"footer" in PDP' is present
    Then I Verify that 'wording also available in' is present

  Scenario: Details/Dimension sction should be displayed as per product with + symbol
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Leather Beds'
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present
    Then I Verify that 'the "Hero" Image' is present
    Then I Verify that '"Zoom" button' is present
    Then I Verify that 'images carousel is present below Hero image' is present
    Then I Verify that 'line items' is present
    Then I Verify that '"add to cart" and "add to project" buttons' is present
    Then I Verify that 'text "Learn more about our Return Policy"' is present
    Then I Verify that '"footer" in PDP' is present
    Then I Verify that 'wording also available in' is present
    Then I Verify that 'sections "dimensions" and "details"' is present

  Scenario: After configuring the options SKU ID should be disaplayed with ITEM #
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Leather Beds'
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present
    Then I chose the '1' line item selections one by one
    Then I verify that text item# and SKU is present

  Scenario: Line item image should be displayed
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Leather Beds'
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present
    Then Verify that 'line Item section image is present'

  Scenario: Return policy message should be displayed after entering the zipcode and configuring the dropdown options
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present
    Then Verify that 'line Item section image is present'
    Then I chose the '1' line item selections one by one
    Then I Verify that 'text "Learn more about our Return Policy"' is present

  Scenario: After clicking on link, Instock modal should be opened as zipcode is already present
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'In Stock'
    Then I navigate to gallery 'Beds'
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present
    When I click on "view in stock items" link
    Then Verify that "In Stock modal" 'opens'
    Then Verify that "In Stock modal" 'zip code is present'

  Scenario: Dropdown should be displayed the options and user should be able to select the options
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present
    Then Verify that 'line Item section image is present'
    Then Verify that 'line item selections (Size, Finish and Qty) are present'
    Then I chose the '1' line item selections one by one
    Then I Verify that 'text "Learn more about our Return Policy"' is present

  Scenario: On left top it should dispalyed the Product name
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    When I click on "view select items on sale" link
    Then Verify that "Sale modal" 'opens'
    Then Product name should be displayed on left top

  Scenario: Sale/Final Sale price should be displayed for Sale products with label
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    Then Verify that 'Verify the Sale/Final Sale price'

  Scenario: For sale product Sale/Final Sale price should be displayed
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    Then Verify that 'Verify the Starting at price or configured price message'

  Scenario: Final sale items
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    Then I verify that availability, Delivery and returns messaging is displayed for "SO"

  Scenario: View Sale Items link should be displayed below the applicable line item image with > symbol for applicable Sale products
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    Then I Verify that '"VIEW SALE ITEMS" link below line item image' is present

  Scenario: After clicking on link, OnSale modal should be opened as zipcode is already present
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    Then I Verify that '"VIEW SALE ITEMS" link below line item image' is present
    Then I click '"VIEW SALE ITEMS" link below line item image' on pdp page
    Then Verify that "Sale modal" 'zip code is present'

  Scenario: The modal has ON SALE name in the left with close button right
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    Then I Verify that '"VIEW SALE ITEMS" link below line item image' is present
    Then I click '"VIEW SALE ITEMS" link below line item image' on pdp page
    Then Verify that 'ON SALE name in the left with close button right'

  Scenario: The On sale modal should be scrollable, if we have more Sale products
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    Then I Verify that '"VIEW SALE ITEMS" link below line item image' is present
    Then I click '"VIEW SALE ITEMS" link below line item image' on pdp page
    Then Verify that 'scrollable functionality'

  Scenario: Add to cart button should be enabled (VIEW SALE ITEMS)
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    Then I Verify that '"VIEW SALE ITEMS" link below line item image' is present
    Then I click '"VIEW SALE ITEMS" link below line item image' on pdp page
    Then Verify that "Sale modal" 'zip code is present'
    Then Verify that "Sale modal" 'Add to cart button should be enabled'

  Scenario: By default qty dropdown should be displayed 1, and user should be able to change the qty as per that qty limit
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    Then Verify that 'By default qty dropdown should be displayed one'

  Scenario: If we click on zipcode link, postal code modal should be opened to change zipcode
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    Then I Verify that '"VIEW SALE ITEMS" link below line item image' is present
    Then I click '"VIEW SALE ITEMS" link below line item image' on pdp page
    Then Verify that "Sale modal" 'zip code is present'
    Then Verify that "Sale modal" 'click on the postal link present in message below product name'
    Then Verify that 'postal code model is present'

  Scenario: Modal should displayed the list of OnSale item
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    Then I Verify that '"VIEW SALE ITEMS" link below line item image' is present
    Then I click '"VIEW SALE ITEMS" link below line item image' on pdp page
    Then Verify that "Sale modal" 'zip code is present'
    Then Verify that "Sale modal" 'Modal should displayed the list of ON SALE items'

  Scenario: Modal has dropdown which should contain the country list with resp flag and textbox to enter zipcode and confirm button
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present
    Then Verify that 'line Item section image is present'
    Then Verify that 'line item selections (Size, Finish and Qty) are present'
    Then I chose the '1' line item selections one by one
    Then I verify that text item# and SKU is present
    Then I Verify that 'text "Learn more about our Return Policy"' is present
    Then Verify that 'text "Unlimited Furniture Delivery" is present'
    Then I click 'postal code link' on pdp page
    Then Verify that 'postal code model is present'

  Scenario: The zipcode should be displayed on modal which has link
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    Then I Verify that '"VIEW SALE ITEMS" link below line item image' is present
    Then I click '"VIEW SALE ITEMS" link below line item image' on pdp page
    Then Verify that "Sale modal" 'zip code is present'

  Scenario: Configure this item for delivery information for your location. should be displayed by default
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present
    Then Verify that 'line Item section image is present'
    Then Verify that 'line item selections (Size, Finish and Qty) are present'
    Then I chose the '1' line item selections one by one
    Then Verify that 'text "Unlimited Furniture Delivery" is present'
    Then Verify that 'delivery information message should be displayed'

  Scenario: The country should always default to the Ship to country selected in the user preferences.
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present
    Then Verify that 'line Item section image is present'
    Then Verify that 'line item selections (Size, Finish and Qty) are present'
    Then I chose the '1' line item selections one by one
    Then I verify that text item# and SKU is present
    Then I Verify that 'text "Learn more about our Return Policy"' is present
    Then Verify that 'text "Unlimited Furniture Delivery" is present'
    Then I click 'postal code link' on pdp page
    Then Verify that 'country should always default to the Ship to country selected in the user preferences'

  Scenario: Modal should displayed the list of Instock item
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'In Stock'
    Then I navigate to gallery 'Beds'
    Then I chose '2' product from the list
    Then I Verify that 'item title' is present
    When I click on "view in stock items" link
    Then Verify that "In Stock modal" 'opens'
    Then Verify that "In Stock modal" 'modal should displayed the list of Instock item'

  Scenario: View In stock Items link should be displayed below the applicable line item image with > symbol for applicable Instock products
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'In Stock'
    Then I navigate to gallery 'Beds'
    Then I chose '2' product from the list
    Then I Verify that 'item title' is present
    Then I Verify that '"VIEW IN STOCK ITEMS" link below line item image' is present

  Scenario: View in Stock items
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'In Stock'
    Then I navigate to gallery 'Beds'
    Then I chose '2' product from the list
    Then I Verify that 'item title' is present
    When I click on "view in stock items" link
    Then Verify that "In Stock modal" 'opens'

  Scenario: The Instock modal should be scrollable, if we have more Instock products
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'In Stock'
    Then I navigate to gallery 'Beds'
    Then I chose '2' product from the list
    Then I Verify that 'item title' is present
    When I click on "view in stock items" link
    Then Verify that "In Stock modal" 'opens'
    Then Verify that 'scrollable functionality'

  Scenario: Add to cart button should be enabled (view in stock items)
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'In Stock'
    Then I navigate to gallery 'Beds'
    Then I chose '2' product from the list
    Then I Verify that 'item title' is present
    When I click on "view in stock items" link
    Then Verify that "In Stock modal" 'opens'
    Then Verify that "In Stock modal" 'Add to cart button should be enabled'

  Scenario: Each item has in stock attributes(options) with price and qty field. We can change the qty by selecting value from dropdown
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'In Stock'
    Then I navigate to gallery 'Beds'
    Then I chose '2' product from the list
    Then I Verify that 'item title' is present
    When I click on "view in stock items" link
    Then Verify that "In Stock modal" 'opens'
    Then Verify that "In Stock modal" 'we can change the qty by selecting value from dropdown'

  Scenario: Verify the same country, postal code is displayed as per Header preference
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    Then I click '"VIEW SALE ITEMS" link below line item image' on pdp page
    Then Verify that "Sale modal" 'click on the postal link present in message below product name'
    Then Verify that "Sale modal" 'postal code should be displayed as per the Header preferences'

  Scenario: Availability and delivery message should be displayed for each onsale product
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    Then I click '"VIEW SALE ITEMS" link below line item image' on pdp page
    Then Verify that "Sale modal" 'availability and delivery message should be displayed for each onsale product'

  Scenario: Availability and delivery message should be displayed for each instock product
  Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'In Stock'
    Then I navigate to gallery 'Beds'
    Then I chose '2' product from the list
    Then I Verify that 'item title' is present
    When I click on "view in stock items" link
    Then Verify that "In Stock modal" 'opens'
    Then Verify that "In Stock modal" 'availability and delivery message should be displayed for each instock product'

  Scenario: After clicking on that link Enter your postal code modal should be opened
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Leather Beds'
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present
    Then I chose the '1' line item selections one by one
    Then Verify that 'text "Unlimited Furniture Delivery" is present'
    Then I verify that text item# and SKU is present
    Then I click 'postal code link' on pdp page
    Then Verify that 'postal code model is present'

  Scenario: The same entered zipcode should be displayed on cart page
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Leather Beds'
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present
    Then I chose the '1' line item selections one by one
    Then Verify that 'text "Unlimited Furniture Delivery" is present'
    Then I verify that text item# and SKU is present
    Then I click on zip code and change it to '10001'
    Then I verify that zip code in PDP is '10001'

  Scenario: For CAN loc user, If User clicks on Shiping Link then Shipping & Delivery Modal Should be opened with Shipments to Canada tab which has CAN currency for shipping charges
    Given I log into Concierge as "associate"
    When I choose 'CA' country
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Leather Beds'
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present
    Then I chose the '1' line item selections one by one
    Then Verify that 'text "Unlimited Furniture Delivery" is present'
    Then I click 'text "Unlimited Furniture Delivery" is present' on pdp page
    Then I click 'Shipping & Delivery Modal Should be opened with Shipments to Canada tab which has CAN currency for shipping charges' on pdp page

  Scenario: Verify whether user able to view confirmation message post changing the shipping country
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    Then I click '"VIEW SALE ITEMS" link below line item image' on pdp page
    Then Verify that "Sale modal" 'zip code is present'
    Then Verify that "Sale modal" 'click on the postal link present in message below product name'
    Then Verify that 'postal code model is present'

  Scenario: Starting at price lable with Regular and member price shold be displayed
    Given I log into Concierge as "associate"
    When I choose 'CA' country
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Leather Beds'
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present
    Then Verify that 'text "Components starting at" is present'
    Then Verify that 'PDP has Regular and Member prices'

  Scenario: Validate the results based on Shipping country and Zip code selection
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    Then I click '"VIEW SALE ITEMS" link below line item image' on pdp page
    Then I click on zip code and change it to '10001' in modal opener
    Then Verify that "Sale modal" 'has changed zip code'

  Scenario Outline: Mattress charge applicable items - CA, RI, CT postal codes
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "10004670 NONE" from search field
    When I change state for "<state>" with zip code "<zipCode>"
    Then I verify that text ""<state>" requires a mattress recycling fee to be collected at checkout state" is present in PDP
    Then I chose the '1' line item selections one by one
    Then Mattress Recycling Fees message should be displayed below line item for state "<state>"
    Examples:
      | state | zipCode|
      | RI    | 02860  |
      | CT    | 06902  |
      | CA    | 94925  |

  Scenario: Select From Stocked and Special Order Fabrics link should be displayed below View In-stock Options link
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "10115451 BWMR" from search field
    Then I Verify that 'item title' is present
    Then Verify that 'SELECT FROM STOCKED AND SPECIAL ORDER FABRICS is displayed" link'

  Scenario: After clicking on the link we should get the modal with the details of the fabrics
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "10115451 BWMR" from search field
    Then I Verify that 'item title' is present
    Then Verify that 'SELECT FROM STOCKED AND SPECIAL ORDER FABRICS is displayed" link'
    Then I click 'SELECT FROM STOCKED AND SPECIAL ORDER' on pdp page
    Then Verify that 'SELECT FROM STOCKED AND SPECIAL ORDER model should be open'

  Scenario: After clicking on any swatch from Stocked/Special order section line items should get updated.
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "10115451 BWMR" from search field
    Then I Verify that 'item title' is present
    Then Verify that 'SELECT FROM STOCKED AND SPECIAL ORDER FABRICS is displayed" link'
    Then I click 'SELECT FROM STOCKED AND SPECIAL ORDER' on pdp page
    Then Verify that 'SELECT FROM STOCKED AND SPECIAL ORDER model should be open'
    When I choose color 'Azure' from special order fabrics
    Then Verify that 'Hero image should get updated and Shown in text below hero image should be suppressed'

  Scenario: Return policy link should be clickable and should navigate user to the Return policy page.
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Leather Beds'
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present
    Then Verify that 'line item selections (Size, Finish and Qty) are present'
    Then I Verify that 'text "Learn more about our Return Policy"' is present
    Then I click 'return policy link' on pdp page
    Then Verify that 'Return policy link should navigate user to the Return policy page'

  Scenario: For US user, If User clicks on Shiping Link with type UFD then Shipping & Delivery Modal Should be opened with UFD tab which has US currency for shipping charges
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Leather Beds'
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present
    Then Verify that 'line item selections (Size, Finish and Qty) are present'
    Then I chose the '1' line item selections one by one
    Then Verify that 'text "Unlimited Furniture Delivery" is present'
    Then I click 'text "Unlimited Furniture Delivery" is present' on pdp page
    Then Verify that 'Shipping & Delivery Modal Should be opened with UFD tab which has US currency for shipping charges'

  Scenario: For US user, If User clicks on Shiping Link with type Standard Shipping then Shipping & Delivery Modal Should be opened with Standard Shipping tab which has US currency for shipping charges
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I chose '6' product from the list
    Then I Verify that 'item title' is present
    Then Verify that 'line item selections (Size, Finish and Qty) are present'
    Then I chose the '1' line item selections one by one
    Then Verify that 'text "Unlimited Furniture Delivery" is present'
    Then I click 'text "Unlimited Furniture Delivery" is present' on pdp page
    Then Verify that 'Shipping & Delivery Modal Should be opened with Standard Shipping tab which has US currency for shipping charges'

  Scenario: For UK loc user, If User clicks on Shiping Link then Shipping & Delivery Modal Should be opened with Shipments to UK tab which has UK(GBP) currency for shipping charges
    Given I log into Concierge as "associate"
    When I choose 'GB' country
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I chose '4' product from the list
    Then I Verify that 'item title' is present
    Then Verify that 'line item selections (Size, Finish and Qty) are present'
    Then I chose the '1' line item selections one by one
    Then I chose the '1' line item selections one by one
    Then I chose the '1' line item selections one by one
    Then Verify that 'text "Unlimited Furniture Delivery" is present'
    Then I click 'text "Unlimited Furniture Delivery" is present' on pdp page
    Then Verify that 'Shipping & Delivery Modal Should be opened with Shipments to UK tab which has UK(GBP) currency for shipping charges'

  Scenario: If Delivery type is UFD, postal code should be present in the delivery message
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Leather Beds'
    Then I click 'first product from the list' on PG screen
    Then I Verify that 'item title' is present
    Then Verify that 'line item selections (Size, Finish and Qty) are present'
    Then I chose the '1' line item selections one by one
    Then I verify that text item# and SKU is present
    Then postal code '94925' should be present in the delivery message

  Scenario: If Delivery type is Standard Shipping, postal code should not be present in the delivery message
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "10121550 NOK" from search field
    Then I Verify that 'item title' is present
    Then I chose the '1' line item selections one by one
    Then I verify that text SKU is present
    Then Verify that 'postal code should not be present in the delivery message'

  Scenario: Validate the results based on Shipping country and Zip code selection with changing country and zip code
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "10121550 NOK" from search field
    Then I Verify that 'item title' is present
    When I click on "view in stock items" link
    Then Verify that "In Stock modal" 'opens'
    Then Verify that "In Stock modal" 'zip code is present'
    Then Verify that "In Stock modal" 'click on postal code and change country and postal code and confirm'
    Then Verify that 'User should be able to see the products based on shipping country and postal code'

  Scenario: The zipcode should be displayed on modal which has link (in stock)
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'In Stock'
    Then I navigate to gallery 'Beds'
    Then I chose '2' product from the list
    Then I Verify that 'item title' is present
    When I click on "view in stock items" link
    Then Verify that "In Stock modal" 'opens'
    Then Verify that "In Stock modal" 'zip code is present'

  Scenario: If we change the country and postal code, then we can see resp currecy on PDP page for all prices
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I chose '6' product from the list
    Then I Verify that 'item title' is present
    Then Verify that 'text "Configure this item to view delivery information to" is present'
    Then I click on postal code and change country to 'United Kingdom' and postal code to 'SW1A1AA' and confirm
    Then I verify that zip code in PDP is 'SW1A1AA'
    Then Verify that 'Confirm that PDP has price in GBP'

  Scenario: Verify whether user able to view confirmation message post changing the shipping country (In stock)
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'In Stock'
    Then I navigate to gallery 'Beds'
    Then I chose '2' product from the list
    Then I Verify that 'item title' is present
    When I click on "view in stock items" link
    Then Verify that "In Stock modal" 'opens'
    Then Verify that "In Stock modal" 'zip code is present'
    Then I click on postal code and change country to 'Canada' and postal code to 'H1Y2B5' and verify confirmation message

  Scenario: If we click on Re-enter postal code link, then it should displayed the enter postal code modal
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I chose '6' product from the list
    Then I Verify that 'item title' is present
    Then I am checking the re-enter zip code functional

  Scenario: By default zipcode should be displayed for each line item in the Availability section as per Ip address or if no ip address found then static zipcode should be present
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I chose '6' product from the list
    Then I Verify that 'item title' is present
    Then Verify that 'By default zipcode should be displayed for each line item in the Availability section as per Ip address or if no ip address found then static zipcode should be present'

  Scenario: After selecting all dropdown options, Add to cart button should be enabled
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    When I click on "view select items on sale" link
    Then Verify that "Sale modal" 'opens'
    Then Verify that "Sale modal" 'has title'
    Then Verify that "Sale modal" 'has item#'
    Then Verify that "Sale modal" 'ADD TO CART button should get enabled'

  Scenario: After clicking on ATC button we can see Item added cart message modal with view cart button and Keep Shopping buton
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    When I click on "view select items on sale" link
    Then Verify that "Sale modal" 'opens'
    Then Verify that "Sale modal" 'has title'
    Then Verify that "Sale modal" 'has item#'
    Then Verify that "Sale modal" 'has qty dropdown'
    Then Verify that "Sale modal" 'has "add to cart" and "add to project" buttons'
    Then Verify that "Sale modal" 'has an item can be added to cart from modal'

  Scenario: After clicking on ATC button we can see Item added cart message modal with view cart button and Keep Shopping buton (in stock)
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'In Stock'
    Then I navigate to gallery 'Beds'
    Then I chose '6' product from the list
    When I click on "view in stock items" link
    Then Verify that "In Stock modal" 'opens'
    Then Verify that "In Stock modal" 'has title'
    Then Verify that "In Stock modal" 'has item#'
    Then Verify that "In Stock modal" 'has qty dropdown'
    Then Verify that "In Stock modal" 'has "add to cart" and "add to project" buttons'
    Then Verify that "In Stock modal" 'has an item can be added to cart from modal'

  Scenario: If we enter valid zipcode and there has been no change to the country selection (it's the same as the Ship to country), and after clicking on confirm button no shipping confirmation modal should be displayed
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I chose '6' product from the list
    Then I Verify that 'item title' is present
    Then I click on zip code and change it to '94925'
    Then I verify that zip code in PDP is '94925'

  Scenario: Updated delivery message should be displayed after changing the postal code
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I chose '6' product from the list
    Then I Verify that 'item title' is present
    Then I click on zip code and change it to '94536'
    Then I verify that zip code in PDP is '94536'

  Scenario: Configured price with Regular,Member price should be displayed with selected Country currency after configuring the options
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I chose '6' product from the list
    Then I Verify that 'item title' is present
    Then I chose the '1' line item selections one by one
    Then Verify that 'PDP has Regular and Member prices'

  Scenario: Starting at price with Regular,Member price should be displayed with selected Country currency
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I chose '6' product from the list
    Then I Verify that 'item title' is present
    Then I chose the '1' line item selections one by one
    Then Verify that 'text "Components starting at" is present'
    Then Verify that 'PDP has Regular and Member prices'

  Scenario: Shown in text should be displayed by default(not for all PDPs) good PDPs to check are MARBELLA collections
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "MARBELLA collections" from search field
    Then I chose '1' product from the list
    Then I Verify that 'item title' is present
    Then I Verify that 'Shown in text below Hero Image' is present

  Scenario: Custom windows PDP
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "Custom windows" from search field
    Then I chose '1' product from the list
    Then I Verify that 'item title' is present
    Then I Verify that 'Custom Windows PDP details' is present

  Scenario: If the products are having multiple options like finish options and fabrics then it should be displayed accordingly.
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "10115451 BWMR" from search field
    Then I Verify that 'item title' is present
    Then Verify that 'SELECT FROM STOCKED AND SPECIAL ORDER FABRICS is displayed" link'
    When I click on special order fabrics
    When I choose color from special order fabrics

  Scenario: After clicking on any swatch from Stocked/Special order section or Finish option or both hero image should get updated and Shown in text below hero image should be suppressed
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "10115451 BWMR" from search field
    Then I Verify that 'item title' is present
    Then Verify that 'SELECT FROM STOCKED AND SPECIAL ORDER FABRICS is displayed" link'
    When I click on special order fabrics
    When I choose color from special order fabrics
    Then I verify that color has been chosen

  Scenario: AFter hover over the swatch preview modal is displayed
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "10115451 BWMR" from search field
    Then I Verify that 'item title' is present
    Then Verify that 'SELECT FROM STOCKED AND SPECIAL ORDER FABRICS is displayed" link'
    When I click on special order fabrics
    Then Swatch Fabric model should be displayed

  Scenario: Verify whether user able to change the shipping country and provide a valid zip code w.r.t country
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    When I click on "view select items on sale" link
    Then Verify that "Sale modal" 'opens'
    Then Verify that "Sale modal" 'zip code is present'
    Then Verify that "Sale modal" 'click on postal code and change country and postal code and confirm'
    Then Verify that "Sale modal" 'User should be able to change the shipping country and provide a valid zip code'

    @vlad
  Scenario: Verify whether user able to change the shipping country and provide a valid zip code w.r.t country (IN-STOCK)
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    When I click on "view select items on sale" link
    Then Verify that "In Stock modal" 'opens'
    Then Verify that "In Stock modal" 'zip code is present'
    Then Verify that "In Stock modal" 'click on postal code and change country and postal code and confirm'
    Then Verify that "In Stock modal" 'User should be able to change the shipping country and provide a valid zip code'

    @vlad
  Scenario:On CG,PG,Shop room,sale, cart checkout pages we can see same country currency for prices which we have entered on PDP page
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "57070740 CLNT" from search field
    Then I Verify that 'item title' is present
    Then  Verify that 'default US zip code is present in PDP'
    When I choose 'CA' country
    Then I click on zip code and change it to 'H1Y2B5'
    Then I verify that zip code in PDP is 'H1Y 2B5'
    Then Verify that 'price in PDP changed from US$ to CA$'

      @vlad
  Scenario: On shipping confirmation modal, if we click on yes button then update the zipcode in availabity and delivery message for each line item
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I chose '6' product from the list
    Then I Verify that 'item title' is present
    Then I click 'postal code link' on pdp page
    Then Verify that 'postal code model is present'
    Then I click on postal code and change country and postal code and confirm
    Then I chose the '1' line item selections one by one
    Then Verify that 'text "Configure this item to view delivery information to" is present'

     @vlad
  Scenario: If we enter valid zipcode and there has been a change to the country selection (i.e. US to CA), then display the shipping country confirmation modal
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I chose '6' product from the list
    Then I Verify that 'item title' is present
    Then I click 'postal code link' on pdp page
    Then Verify that 'postal code model is present'
    Then I enter valid zip code with different country and confirm
    Then Confirmation modal should be displayed

  @vlad
  Scenario: Updated avaialbility message should be displayed after changing the postal code based on inventory.
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I chose '6' product from the list
    Then I Verify that 'item title' is present
    Then I click 'postal code link' on pdp page
    Then Verify that 'postal code model is present'
    Then I click on postal code and change country and postal code and confirm
    Then I chose the '1' line item selections one by one
    Then Updated availability message should be displayed after changing the postal code based on inventory

#    @vlad
#  Scenario: Special order items, SPO Popup
#    Given I log into Concierge as "associate"
#    When I choose country for concierge from footer
#    When I remove all items from cart via UI
#    When I go to item "10110124 BWMR" from search field
#    Then I Verify that 'item title' is present
#    Then I chose the '1' line item selections one by one
#    Then User should be able to see Availability, Delivery, Return info at line level