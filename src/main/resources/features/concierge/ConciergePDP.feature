@conciergeTestRun
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

  Scenario: Verify the PDP hero Image, zoom, line items
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I click on the first project search result with parameters 'prod18890296''10024793 BRNZ'
    Then I Verify that 'PDP title' is present
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
    Then I choose option 'Waxed Grey Oak/ Pewter'
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
    Then Project modal appears and has all the data for '10024793 BRNZ'
    Then verify that another modal appears with all the data for '10024793 BRNZ'

  Scenario: Verify In Stock functionality
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "60450996 BLNL" from search field
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
    Then I Verify that 'PDP title' is present
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
    When I click on rh concierge logo
    When I click on search
    When I type item name 'Coffee Tables'
    Then I click on the first project search result
    Then Verify that 'default US zip code is present in PDP'

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
      | CA    | 94925  |
      | RI    | 02860  |
      | CT    | 06902  |

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
    Then I Verify that 'PDP title' is present
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
    Then I Verify that 'PDP title' is present
    Then I chose the '1' line item selections one by one for '5' items
    Then I click on button "ADD TO PROJECT" in the cart
    Then I verify that project modal is displayed
    Then I click on button "ADD ALL TO PROJECT" in the cart
    Then I verify that project modal is displayed

  Scenario: Verify alt video: After clicking on play button video should be played
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I click on the first project search result with parameters 'prod18890296''10024793 BRNZ'
    Then I Verify that 'PDP title' is present
    Then I Verify that 'PDP title' is present
    Then I Verify that '"Zoom" button' is present
    Then I Verify that 'the "Hero" Image' is present
    Then Verify that 'shop the entire collection'
    Then Verify that 'is present view carousel is present on the right of the zoomed hero image and scrolling are present'
    Then I Verify that 'images carousel is present below Hero image' is present
    Then Verify that 'left and right arrows are present and number of alt images is 5'
    Then Verify that 'zoom button is clickable and zoom module is opened'
    Then Verify that 'plus and minus buttons are clickable and functioning'