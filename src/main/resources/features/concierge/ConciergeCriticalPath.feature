@conciergeCriticalPathTestRun

Feature: Concierge Critical Path

  Scenario: User Sign-in
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I verify that user is logged in

  Scenario: User Sign-out
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I click 'on Associate Name' on signIn signOut screen
    Then I click 'on sign out button' on signIn signOut screen
    Then I verify that 'user is able to sign out' on signIn signOut screen

  Scenario: Verify the Postal code updates in cart
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I add item to cart via API with "10146709 LOAK" and quantity '1'
    When I open cart
#    Then I confirm that default zip code for country "US" is present in Cart
    And I change zip code in the cart to "94525"
    And Verify that zip code was updated in the Cart to "94525"

  Scenario: Verify the Price, Total, Shipping & Applicable fees in cart
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I add item to cart via API with "10146709 LOAK" and quantity '1'
    When I open cart
    Then I verify all the sums on the cart page

  Scenario: Verify that increasing the quantity updates correct product price lines,Total, Shipping & Applicable fees in cart
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I add item to cart via API with "10146709 LOAK" and quantity '2'
    When I open cart
    Then I verify all the sums on the cart page with item quantity '2'

  Scenario: Verify that the Membership Banner is present for Non-Members
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I verify that Membership Banner is present with all the data
    Then I click 'join now button' on cart screen
    Then I verify membership banner in PG
    Then I click 'remove membership button' on cart screen
    When I choose order classification
    When I click on checkout button
    Then I click on become a member now button
    Then I verify membership banner

  Scenario: Verify Removal of product in Cart
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I click 'Remove Link' on cart screen

  Scenario: Verify Quantity Update in Cart - decrease
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API with "61810993 MRBR" and quantity '5'
    When I open cart
    Then I save data for decreasing
    Then I change quantity in the car for '1'
    Then I verify that 'quantity and sum were decreased' on the cart page

  Scenario: Verify Quantity Update in Cart - increase
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API with "10031801 WGRY" and quantity '1'
    When I open cart
    Then I save data for increasing
    Then I change quantity in the car for '4'
    Then I verify that 'quantity and sum were increased' on the cart page

  Scenario Outline: Override Line item Prices - with <method> override price methods
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I click on cart button from header
    When I click on total item line price
    When I select price override "<method>"
    When I introduces value for override price
    When I choose reason code for price override
    When I click on apply uppercase button for "override line item"
    Then I verify line items prices for "<method>"
    Examples:
      | method          |
      | PERCENT_OFF     |
      | AMOUNT_OFF      |
      | AMOUNT_OVERRIDE |

  Scenario: Verify Price Override with default adjustment in cart
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I click on cart button from header
    When I click on total item line price
    Then Close the Form

  Scenario: Verify application of Promotion Code in cart
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I introduces promo code "FEMAD" for promo codes field
    When I click on apply promocode button
    Then I verify that "FEMAD" promocode was approved for cart items
    And I remove promotion from cart
    And I verify that promotion is not displayed

  Scenario: Verify Shipping Override update in cart
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    Then I click total excluding sales tax
    Then select any reason code on SHIPPING OVERRIDE form & click apply button

  Scenario: Verify that the user is able to Postpone Shipping Successfully
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose postpone shipment
    When I click on apply uppercase button for "postpone shipment"
    Then I verify that postpone shipment was applied
    Then I remove postpone shipment

  Scenario: Verify that the user is able to Clear cart
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I add item to cart via API
    When I clear all orders form the cart
  @vimal
  Scenario: Monogram Edit / Remove / Add
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I open product page with productId "prod19500002"
    Then I chose the '1' line item selections one by one
    When I click on add to cart button
    When I click on view cart button
    Then I open cart
    When I click on add monogram checkbox
    When I choose monogram properties
    Then I verify that monogram was added
    When I edit monogram
    Then I verify that monogram was edited
    When I remove monogram
    Then I verify that monogram was removed

  Scenario: Gift Box Add / Remove / View
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I open product page with productId "prod19500002"
    Then I chose zero choose in line items
    Then I chose the '1' line item selections one by one
    When I click on add to cart button
    When I click on view cart button
    Then I open cart
    When I click on gift box button
    Then I verify that gift box was added
    When I click on gift box button
    Then I verify that gift box was removed

  Scenario Outline: Test CGS in all menu items
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I change the brand to "<brand>"
    Then I verify that RH Brand dropdown is present in "<currentBrandName>" home page
    Then I navigate to menu '<menu>'
    Then I navigate to sub menu '<subMenu>'
    Then confirm that Seating '<gallery>' is present in '<levelOfCollection>' of '<subMenu>'
    Examples:
      | menu   | subMenu        | gallery             | brand | currentBrandName | levelOfCollection |
      | Living | Fabric Seating | Seating Collections | RH    | RH               | 1                 |
#      | Dining    | Tables                  | Rectangular Table Collections  | RH              | RH               | 1                 |
#      | Bed       | Bed Linens              | Bedding Collections            | RH              | RH               | 1                 |
#      | Bath      | Bath Towels & Linens    | Bath Towel Collections         | RH              | RH               | 1                 |
#      | Lighting  | Lighting Collections    |                                | RH              | RH               | 2                 |
#      | Textiles  | Pillows                 | Pillow Collections             | RH              | RH               | 1                 |
#      | Rugs      | Rugs                    | Rug Collections                | RH              | RH               | 1                 |
#      | Windows   | Drapery                 | Drapery Collections            | RH              | RH               | 1                 |
#      | Outdoor   | Furniture Collections   |                                | RH              | RH               | 3                 |
#      | Living    | Leather Seating         | Seating Collections            | RH CONTEMPORARY | CN               | 1                 |
#      | Bath      | Faucets & Hardware      | Faucets & Hardware Collections | RH CONTEMPORARY | CN               | 1                 |
#      | Textiles  | Bed Linens              | Bedding Collections            | RH CONTEMPORARY | CN               | 1                 |
#      | Living    | Sideboards              | Sideboard Collections          | RH INTERIORS    | IN               | 1                 |
#      | Dining    | Counter & Bar           | Leather Stool Collections      | RH INTERIORS    | IN               | 2                 |
#      | Textiles  | Throws                  | Throw Collections              | RH INTERIORS    | IN               | 1                 |
#      | Living    | Pillows & Throws        | Throw Collections              | RH MODERN       | MO               | 2                 |
#      | Dining    | Shelving & Cabinets     | Cabinet Collections            | RH MODERN       | MO               | 1                 |
#      | Textiles  | Windows                 | Custom Drapery Collections     | RH MODERN       | MO               | 4                 |
#      | Furniture | Furniture Collections   |                                | RH OUTDOOR      | OD               | 2                 |
#      | Textiles  | Pillows                 | Outdoor Pillow Collections     | RH OUTDOOR      | OD               | 1                 |
#      | Bed       | RH Beach House Bed      | Bedroom Collections            | RH BEACH HOUSE  | BH               | 1                 |
#      | Lighting  | RH Beach House Lighting | Ceiling Collections            | RH BEACH HOUSE  | BH               | 1                 |
#      | Dining    | RH Ski House Dining     | Cabinet & Shelving Collections | RH SKI HOUSE    | SH               | 8                 |
#      | Bath      | RH Ski House Bath       | Bath Collections               | RH SKI HOUSE    | SH               | 4                 |
#      | Furniture | Bedroom                 | Bedroom Collections            | RH BABY & CHILD | BC               | 1                 |
#      | Furniture | Nursery                 | Nursery Collections            | RH BABY & CHILD | BC               | 1                 |
#      | Furniture | Bedroom                 | Bedroom Collections            | RH TEEN         | TN               | 1                 |
#      | Rugs      | Handcrafted Rugs        | Rug Collections                | RH TEEN         | TN               | 1                 |

  Scenario Outline: Back to Top button functionality
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I change the brand to "<brand>"
    Then I verify that RH Brand dropdown is present in "<currentBrandName>" home page
    Then I navigate to menu "<menu>"
    Then I navigate to sub menu "<subMenu>"
    Then I navigate to gallery "<gallery>"
    Then I verify that 'Back to top Button is present' on CG screen
    Then I click 'Back to Top button' on PG screen
    Then I verify that 'user is brought to the top of the page' on CG screen
    Examples:
      | menu     | subMenu | gallery                    | brand      | currentBrandName |
#      | Windows   | Drapery             | Drapery Collections        | RH           | RH               |
#      | Bath      | Furniture           | Bath Collections           | RH           | RH               |
#      | Living    | Shelving & Cabinets | Cabinet Collections        | RH INTERIORS | IN               |
      | Textiles | Pillows | Outdoor Pillow Collections | RH OUTDOOR | OD               |
#      | Furniture | Lounge & Media      | Lounge & Media Collections | RH TEEN      | TN               |

  Scenario Outline: To check if single Grid View is as default on CG
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I change the brand to "<brand>"
    Then I verify that RH Brand dropdown is present in "<currentBrandName>" home page
    Then I navigate to menu "<menu>"
    Then I navigate to sub menu "<subMenu>"
    Then I navigate to gallery "<gallery>"
    Then I verify that 'grid view is present on top right' on CG screen
    Then I verify that 'grid view is set to 1-grid view by default' on CG screen
    Examples:
      | menu     | subMenu               | gallery              | brand        | currentBrandName |
#      | Living    | Leather Seating       | Seating Collections         | RH           | RH               |
#      | Living    | Office                | Office Collections          | RH MODERN    | MO               |
      | Lighting | RH Ski House Lighting | Lighting Collections | RH SKI HOUSE | SH               |
#      | Dining    | RH Ski House Dining   | Dining Table Collections    | RH SKI HOUSE | SH               |
#      | Furniture | Furniture Collections |                             | RH OUTDOOR   | OD               |
#      | Furniture | Bedroom               | Upholstered Bed Collections | RH TEEN      | TN               |

  Scenario Outline: To check 1,2,3 grid view functionality within CG
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I change the brand to "<brand>"
    Then I verify that RH Brand dropdown is present in "<currentBrandName>" home page
    Then I navigate to menu "<menu>"
    Then I navigate to sub menu "<subMenu>"
    Then I navigate to gallery "<gallery>"
    Then I verify that 'grid view is present on top right' on CG screen
    Then I verify that 'grid view is set to 1-grid view by default' on CG screen
    Then I Change the CG Grid view to '2' - grid view and confirm changing
    Then I Change the CG Grid view to '3' - grid view and confirm changing
    Then I Change the CG Grid view to '1' - grid view and confirm changing
    Examples:
      | menu    | subMenu | gallery             | brand        | currentBrandName |
#      | Bath      | Furniture           | Bath Collections     | RH                  | RH               |
      | Windows | Drapery | Drapery Collections | RH INTERIORS | IN               |
#      | Dining    | Shelving & Cabinets | Cabinet Collections  | RH MODERN           | MO               |
#      | Bed       | RH Beach House Bed  | Bedroom Collections  | RH BEACH HOUSE      | BH               |

  Scenario: 1-2-3 Grid View Functionality within CG/PG/Different Brands
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu "Living"
    Then I navigate to sub menu "Office"
    Then I navigate to gallery "Office Collections"
    Then I safe the name of gallery
    Then I verify that 'grid view is present on top right' on CG screen
    Then I verify that 'grid view is set to 1-grid view by default' on CG screen
    Then I Change the CG Grid view to '2' - grid view and confirm changing
    Then I navigate to '1' gallery
    Then I click 'Back Browser Button' on CG screen
    Then I verify that 'same CG is displayed' on CG screen
    Then I verify that 'grid view is set to 2-grid view' on CG screen
    Then I Change the CG Grid view to '3' - grid view and confirm changing
    Then I navigate to '2' gallery
    Then I navigate to '1' PDP
    Then I click 'Back Browser Button' on CG screen
    Then I click 'Back Browser Button' on CG screen
    Then I verify that 'same CG is displayed' on CG screen
    Then I verify that 'grid view is set to 3-grid view' on CG screen
    Then I Change the CG Grid view to '2' - grid view and confirm changing
    Then I navigate to menu "Textiles"
    Then I navigate to sub menu "Windows"
    Then I navigate to gallery "Drapery Collections"
    Then I verify that 'grid view is set to 2-grid view' on CG screen
    Then I change the brand to "RH TEEN"
    Then I verify that RH Brand dropdown is present in "TN" home page
    Then I navigate to menu "Furniture"
    Then I navigate to sub menu "Bedroom"
    Then I navigate to gallery "Bedroom Collections"
    Then I verify that 'grid view is set to 2-grid view' on CG screen
    Then I change the brand to "RH MODERN"
    Then I verify that RH Brand dropdown is present in "MO" home page
    Then I navigate to menu "Rugs"
    Then I navigate to sub menu "Handcrafted Rugs"
    Then I navigate to gallery "Rug Collections"
    Then I verify that 'grid view is set to 2-grid view' on CG screen

  Scenario: Browser back button from search to CG page
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Living'
    Then I navigate to sub menu 'Fabric Seating'
    Then I navigate to gallery 'Seating Collections'
    Then I click 'Back Browser Button' on CG screen
    Then I verify that 'Dashboard is displayed' on CG screen
    Then I navigate to menu 'Bath'
    Then I navigate to sub menu 'Furniture'
    Then I navigate to gallery 'Bath Collections'
    Then I verify that 'Navigate to third collection' on CG screen
    Then I click 'Back Browser Button' on CG screen
    Then I click 'Bath Collections are displayed' on CG screen
    Then I navigate to menu 'Rugs'
    Then I navigate to sub menu 'Rugs'
    Then I navigate to gallery 'Rug Collections'
    Then I verify that 'Navigate to second collection' on CG screen
    Then I verify that 'Navigate to first product' on CG screen
    Then I click 'Back Browser Button' on CG screen
    Then I verify that 'confirm that PG is displayed' on CG screen
    Then I click 'Back Browser Button' on CG screen
    Then I click 'confirm that CG Rug Collections is displayed' on CG screen

  Scenario: Login as associate and Verify that home page is accessible
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then  I expect that I am on the Concierge Dashboard page

  Scenario Outline: Verify Top Nav is present, clickable and responsive in HPs of all brands
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then  I change the brand to "<brand>"
    Then User verifies that all items from menu are displayed for "<brand>"
    Examples:
      | brand        |
#      | RH              |
#      | RH CONTEMPORARY |
      | RH INTERIORS |
#      | RH MODERN       |
#      | RH OUTDOOR      |
#      | RH BEACH HOUSE  |
#      | RH SKI HOUSE    |
#      | RH BABY & CHILD |
#      | RH TEEN         |

  Scenario Outline: Verify Logo is present in HPs of all brands
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then  I change the brand to "<brand>"
    Then I verify the logo
    Examples:
      | brand     |
#      | RH              |
#      | RH CONTEMPORARY |
#      | RH INTERIORS    |
      | RH MODERN |
#      | RH OUTDOOR      |
#      | RH BEACH HOUSE  |
#      | RH SKI HOUSE    |
#      | RH BABY & CHILD |
#      | RH TEEN         |

  Scenario Outline: Verify Brand Dropdown is present and functional in HPs of all brands
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I change the brand to "<brand>"
    Then I verify that RH Brand dropdown is present in "<currentBrandName>" home page
    Examples:
      | brand      | currentBrandName |
#      | RH              | RH               |
#      | RH CONTEMPORARY | CN               |
#      | RH INTERIORS    | IN               |
#      | RH MODERN       | MO               |
      | RH OUTDOOR | OD               |
#      | RH BEACH HOUSE  | BH               |
#      | RH SKI HOUSE    | SH               |
#      | RH BABY & CHILD | BC               |
#      | RH TEEN         | TN               |

  Scenario Outline: Verify the Footer links are present and clickable in HPs
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I change the brand to "<brand>"
    Then I verify footer links for brand "<brand>"
    Examples:
      | brand          |
#      | RH              |
#      | RH CONTEMPORARY |
#      | RH INTERIORS    |
#      | RH MODERN       |
#      | RH OUTDOOR      |
      | RH BEACH HOUSE |
#      | RH SKI HOUSE    |
#      | RH BABY & CHILD |
#      | RH TEEN         |

  Scenario: Verify the content for the HP for Concierge
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I expect that I am on the Concierge Dashboard page
    Then I verify the username
    Then I verify the gallery
    Then I verify the logo
    Then I verify project button
    Then I Verify search leans
    Then I verify user icon
    Then I verify cart
    Then I verify flag icon for country selection
    Then I verify top nav
    Then I verify brand dropdown
    Then I verify page label
    Then I verify button "RH Orders" on homepage
    Then I verify button "Apply for RH Card" on homepage
    Then I verify button "RH Card lookup" on homepage
    Then I verify button "Gift card enquiry" on homepage
    Then I verify button "RH.COM Profile" on homepage
    Then I verify search item field and search button

  Scenario: Change store number in concierge from dashboard
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I change my store to number "10"
    Then I verify I see store Palo Alto in the header

  Scenario: Verify that all galleries are present in list
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When user clicks on gallery button from header
    Then user verifies list of galleries which have default value "5: Newport Beach"
  @vimal
  Scenario Outline: Major CCs
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    And I continue to payment
    When I click on continue with original address button
    When I execute payment for "<cardType>"
    And I verify that review screen is displayed
    When I click on a place order button
    Then I click on order details button
    Then I verify that confirm screen is displayed
    Examples:
      | cardType |
      | VI       |
      | MC       |
      | AX       |
      | DI       |

  Scenario: Split Payment
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    And I continue to payment
    When I click on continue with original address button
    Then I execute split payment with 'VI'
    Then I execute split payment with 'MC'
    Then I verify that payment split is working and paid amount is visible on the review page
    When I click on a place order button
    Then I click on order details button
    Then I verify that payment split is working and paid amount is visible on the confirmation page

  Scenario: POS payment
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    When I continue to payment
    When I click on continue with original address button
    When I choose POS for payment method
    Then I verify that payment POS is working and paid amount is visible on the review page
    When I click on a place order button without signature
    Then I verify that payment POS is working and paid amount is visible on the confirmation page
    Then I verify the payment details and order estimate summary

  Scenario: Edit payment
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    And I continue to payment
    When I click on continue with original address button
    When I execute payment for "VI"
    Then I verify that payment CC is working and paid amount is visible on the review page
    When I edit payment method
    When I click on a place order button
    Then I click on order details button
    Then I verify that payment POS is working and paid amount is visible on the confirmation page
    Then I verify the payment details and order estimate summary

  Scenario: Verify the Complete Billing address
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    And I continue to payment
    When I click on continue with original address button
    Then I verify the complete billing address

  Scenario: GC/ Balance check
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    And I continue to payment
    When I click on continue with original address button
    When I choose "RH Gift Card" from payment method
    When I click on check balance button
    Then I verify that balance info is displayed

  Scenario: Edit Address
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I add item to cart via API
    When I open cart
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "Non-Member"
    And I fill all fields from address screen
    And I continue to payment
    When I click on continue with original address button
    When I edit billing address from order review page
    And I continue to payment
    When I click on continue with original address button
    Then I verify that I'm able to edit billing address

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
    Then I verify the rest of the checkings for "<skuID>"
    Examples:
      | skuID         |
#      |57070740 CLNT|
      | 61970975 TEAK |
      | 62870050 LOAK |
     | 10024793 BRNZ |
  @vimal
  Scenario: Verify the PDP hero Image, zoom, line itemsVerify the PDP hero Image, zoom, line items
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I open product page with productId "prod18890296"
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

#  Scenario: Verify On Sale functionality
#
#    Given I log into Concierge as "associate"
#    When I choose country for concierge from footer
#    When I remove all items from cart via UI
#    When I go to item "57070740 CLNT" from search field
#    When I click on "view select items on sale" link
#    Then Verify that "Sale modal" 'opens'
#    Then Verify that "Sale modal" 'has title'
#    Then Verify that "Sale modal" 'has item#'
#    Then Verify that "Sale modal" 'has price, member and sale price'
#    Then Verify that "Sale modal" 'has qty dropdown'
#    Then Verify that "Sale modal" 'has "add to cart" and "add to project" buttons'
#    Then Verify that "Sale modal" 'has an item can be added to cart from modal'
#    Then Verify that "Sale modal" 'has an item can be added to project from modal'
  @vimal
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

  Scenario: ATC SPO - add to cart
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "10105809 BWDV" from search field
    Then I chose the '1' line item selections one by one
    When I click on add to cart button
    When I click on agree&add button
    When I click on view cart button
    Then I verify that availability, Delivery and returns messaging is displayed for "SO"

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
  @Vimal
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
      | state | zipCode |
      | RI    | 02860   |
      | CT    | 06902   |
      | CA    | 94925   |

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

  Scenario Outline:  Test PGs in all menu items
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I change the brand to "<brand>"
    Then I verify that RH Brand dropdown is present in "<currentBrandName>" home page
    Then I navigate to menu "<menu>"
    Then I navigate to sub menu "<subMenu>"
    Then I navigate to gallery "<gallery>"
    Then I verify that PG loads
    Examples:
      | menu    | subMenu | gallery       | brand   | currentBrandName |
#      | Living    | Fabric Seating        | Sofas                         | RH              | RH               |
#      | Dining    | Tables                | Rectangular Table Collections | RH              | RH               |
#      | Dining    | Bar & Counter         | Bar & Counter Stools          | RH              | RH               |
#      | Dining    | Sideboards            | Glass Sideboards              | RH              | RH               |
#      | Bath      | Bath Storage          | Open Shelving                 | RH              | RH               |
#      | Bath      | Lighting              | Bath Flushmounts              | RH              | RH               |
#      | Lighting  | Wall                  | Picture Lights                | RH              | RH               |
#      | Rugs      | Rugs By Size          | 9' X 12' Rugs                 | RH              | RH               |
#      | Décor     | Wall Art              | Photography                   | RH              | RH               |
#      | Outdoor   | Décor                 | Mirrors                       | RH              | RH               |
#      | Living    | Tables                | Entry Table                   | RH CONTEMPORARY | CN               |
#      | Bed       | Bed Linens            | Quilts & Coverlets            | RH CONTEMPORARY | CN               |
#      | Lighting  | Floor                 | All Floor Lighting            | RH CONTEMPORARY | CN               |
#      | Dining    | Tables                | Extension Tables              | RH INTERIORS    | IN               |
#      | Outdoor   | Textlies              | Outdoor Towels                | RH INTERIORS    | IN               |
#      | Living    | Tables                | Console Tables                | RH MODERN       | MO               |
#      | Dining    | Seating               | Benches                       | RH MODERN       | MO               |
#      | Lighting  | Bath                  | Sconces                       | RH MODERN       | MO               |
#      | Furniture | Furniture             | Chaises                       | RH OUTDOOR      | OD               |
#      | Textiles  | Towels                | Outdoor Towels                | RH OUTDOOR      | OD               |
#      | Living    | RH Beach House Living | Desks                         | RH BEACH HOUSE  | BH               |
#      | Dining    | RH Beach House Dining | Seating                       | RH BEACH HOUSE  | BH               |
#      | Bed       | RH Ski House Bed      | Beds                          | RH SKI HOUSE    | SH               |
#      | Lighting  | RH Ski House Lighting | Floor Lighting                | RH SKI HOUSE    | SH               |
#      | Bed       |Toddler Collections    | Crib Sheets                   | RH BABY & CHILD | BC               |
#      | Furniture | Study                 | Desk Chairs                   | RH BABY & CHILD | BC               |
#      | Lighting  | Table                 | Shades                        | RH TEEN         | TN               |
      | Storage | Wall    | Memory Boards | RH TEEN | TN               |
  @vimal
  Scenario: Checking Faucets in Collection PG
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Dining'
    Then I navigate to sub menu 'Tables'
    Then I navigate to gallery 'Round & Oval Tables'
    Then I verify that 'PG has SALE and IN-STOCK filters, text RESULTS (n), faucet with text SORT' on PG screen
    Then I click 'SORT and confirm that Modal has text FEATURED, Price Low to High, Price High to Low' on PG screen
    Then I click 'Price Low to High and verify price is sorted' on PG screen
    Then I click 'Price High to Low and verify price is sorted' on PG screen
    Then I click 'IN-STOCK Filter' on PG screen
    Then I verify that 'CLEAR ALL is present when filter(s) are selected' on PG screen
    Then I click 'IN-STOCK Filter' on PG screen
    Then I click 'sale checkbox' on PG screen
    Then I verify that 'all products returned have $ SALE price in their descriptions' on PG screen
    Then I verify that PG loads

  Scenario: Checking Faucets in General PG (All Tables)
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Dining'
    Then I navigate to sub menu 'Tables'
    Then I navigate to gallery 'All Dining Tables'
    Then I verify that 'PG has filters: IN-STOCK, SALE, SIZE, SHAPE, BRAND, RESULTS and SORT is present' on PG screen
    Then I verify that 'user can select SIZE -> Length -> 30 and respective products are returned' on PG screen

  Scenario: Checking Faucets in SALE PGs
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'SALE'
    Then I navigate to sub menu 'Bed'
    Then I navigate to gallery 'Beds'
    Then I verify that 'text on banner SAVE UP TO 70% AS AN RH MEMBER' on PG screen
    Then I verify that 'PG has filters: IN-STOCK, SALE, SIZE, MATERIAL, BRAND, RESULTS and SORT is present' on PG screen
    Then I verify that PG loads
    Then I verify that 'all products returned have $ SALE price in their descriptions' on PG screen

  Scenario: Checking Faucets in Search PG
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on search Icon
    When I type item name 'rectangular table'
    Then I verify that 'PG has filters: CONCEPTS, IN-STOCK, SALE, BRAND, RESULTS and SORT is present' on PG screen
    Then I verify that 'CONCEPT dropdown returns various RH Brands' on PG screen
    Then I click 'RH Outdoor' on PG screen
    Then I verify that 'Italian Travertine Plinth Rectangular Fire Table is returned' on PG screen
    Then I verify that PG loads

  Scenario Outline: Verify that title is present in PG
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I change the brand to "<brand>"
    Then I verify that RH Brand dropdown is present in "<currentBrandName>" home page
    Then I navigate to menu "<menu>"
    Then I navigate to sub menu "<subMenu>"
    Then I navigate to gallery "<gallery>"
    Then I verify that "<PGName>" title is present in PG top left
    Examples:
      | menu      | subMenu   | gallery       | brand      | currentBrandName | PGName        |
#      | Bath      | Vanities            | Powder Vanities | RH              | RH               | Powder Vanities |
#      | Rugs      | Rug Pads            | All Rug Pads    | RH              | RH               | All Rug Pads    |
#      | Nursery   | Gifts               | Baby Apparel    | RH BABY & CHILD | BC               | Baby Apparel    |
      | Furniture | Furniture | Dining Chairs | RH OUTDOOR | OD               | Dining Chairs |

  Scenario: Verify that Back to Top Button is present in PG and functioning
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'All Beds'
    Then I verify that 'Back to top Button is present' on PG screen
    Then I click 'Back to Top button' on PG screen
    Then I verify that 'user is brought to the top of the page' on PG screen
    Then I navigate to menu 'Lighting'
    Then I navigate to sub menu 'Table'
    Then I navigate to gallery 'All Table Lighting'
    Then I verify that 'Back to top Button is present' on PG screen
    Then I click 'Back to Top button' on PG screen
    Then I verify that 'user is brought to the top of the page' on PG screen
    Then I change the brand to "RH BABY & CHILD"
    Then I verify that RH Brand dropdown is present in "BC" home page
    Then I navigate to menu 'Playroom'
    Then I navigate to sub menu 'Furniture'
    Then I navigate to gallery 'Play Tables & Chairs'
    Then I verify that 'Back to top Button is present' on PG screen
    Then I click 'Back to Top button' on PG screen
    Then I verify that 'user is brought to the top of the page' on PG screen

  Scenario: Verify that Sale Price is present in Sale PGs
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Lighting'
    Then I navigate to sub menu 'Ceiling'
    Then I navigate to gallery 'Chandeliers'
    Then I click 'sale checkbox' on PG screen
    Then I verify that 'Verify that all products have text From $ / $ Sale / $ Member' on PG screen
    Then I navigate to menu 'Outdoor'
    Then I navigate to sub menu 'Furniture'
    Then I navigate to gallery 'Sofas'
    Then I click 'sale checkbox' on PG screen
    Then I verify that 'Verify that all products have text Frame $ / $ Sale / $ Member' on PG screen

  Scenario: Verify that PG is defaulted to 3-grid view
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Benches & Stools'
    Then I navigate to gallery 'Benches'
    Then I verify that 'Grid View is present in top right' on PG screen
    Then I verify that 'Grid View in PG is set to 3-grid view by default' on PG screen

  Scenario: Verify that PG Grid View is functional within PG
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Dining'
    Then I navigate to sub menu 'Seating'
    Then I navigate to gallery 'Leather Seating'
    Then I verify that 'Grid View is present in top right' on PG screen
    Then I verify that 'grid view is set to 3-grid view' on PG screen
    Then I Change the PG Grid view to '2' - grid view and confirm changing
    Then I Change the PG Grid view to '3' - grid view and confirm changing

  Scenario: Verify that PG Grid View is kept as selected  as user browses through site -PG/CG/PDP and back
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Bath'
    Then I navigate to sub menu 'Bath Storage'
    Then I navigate to gallery 'Bath Cabinets'
    Then I verify that 'Grid View is present in top right' on PG screen
    Then I verify that 'grid view is set to 3-grid view' on PG screen
    Then I Change the PG Grid view to '2' - grid view and confirm changing
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I click 'first product from the list' on PG screen
    Then I click 'Back Browser Button' on PG screen
    Then I verify that 'grid view is set to 2-grid view' on PG screen
    Then I navigate to menu 'Dining'
    Then I navigate to sub menu 'Sideboards'
    Then I navigate to gallery 'Glass Sideboards'
    Then I click 'first product from the list' on PG screen
    Then I click 'Back Browser Button' on PG screen
    Then I verify that 'grid view is set to 2-grid view' on PG screen

  Scenario: Verify that Back Button PG -> CG and PDP -> PG is functioning as expected
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Bath'
    Then I navigate to sub menu 'Bath Storage'
    Then I navigate to gallery 'Bath Cabinets'
    Then I click 'Back Browser Button' on PG screen
    Then I verify that 'Dashboard is displayed' on PG screen
    Then I navigate to menu 'Dining'
    Then I navigate to sub menu 'Tables'
    Then I navigate to gallery 'Rectangular Table Collections'
    Then I click 'first collection from the list' on PG screen
    Then I click 'Back Browser Button' on PG screen
    Then I verify that 'CG is displayed' on PG screen
    When I open product page with "prod14020058"
    Then I click 'Back Browser Button' on PG screen
    Then I verify that 'CG is displayed' on PG screen
    Then I navigate to menu 'Dining'
    Then I navigate to sub menu 'Sideboards'
    Then I navigate to gallery 'Glass Sideboards'
    Then I click 'first product from the list' on PG screen
    Then I click 'Back Browser Button' on PG screen
    Then I verify that 'PG is displayed' on PG screen

  Scenario: Verify that Search for keyword is functioning as expected
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on search Icon
    When I type item name 'table'
    Then I verify that 'PG Search Page has title (TABLE) and text "Results" and "Sort" are present' on search page
    Then I verify that 'Grid View is present in top right' search screen
    Then I verify that 'PG pictures of all items are visible' on search page
    Then I verify that 'page is loaded until footer' on search page
    Then I verify that relevant items are returned on search page 'Table'

  Scenario: Verify that cross brand search is functioning as expected
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on search Icon
    When I type item name 'Crib'
    Then I verify that 'PG page is returned with text  RESULTS (IN RH BABY & CHILD)' on search page
    Then I verify that 'VIEW RH BABY & CHILD RESULTS button is present' on search page
    Then I verify that 'footer is present' on search page
    Then I click on 'VIEW RH BABY & CHILD RESULTS' button on search page
    Then I verify that relevant items are returned on search page 'Crib'
    Then I verify that RH Brand dropdown is present in 'BC' home page
    Then I verify that 'PG pictures of all items are visible' on search page
    Then I verify that 'page is loaded until footer' on search page

  Scenario: Verify that search for non-existent search term returns 0 results
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on search Icon
    When I type item name '234adf'
    Then I verify that 'PG page is returned with RESULTS(0) present and search text "234ADF" is present' on search page
    Then I verify text 'We’re sorry, we cannot find what you are looking for.'
    Then I verify text 'Please try a new search or contact '
    Then I verify that 'customer experience' on search page
    Then I click on 'customer experience' button on search page
    Then I verify that 'customer experience page is opened' on search page
    Then I verify that 'footer is present' on search page