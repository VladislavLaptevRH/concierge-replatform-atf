@conciergeTestRun
@ConciergePG
Feature: Concierge PG Page

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
      | menu      | subMenu               | gallery                       | brand           | currentBrandName |
      #| Living    | Fabric Seating        | Sofas                         | RH              | RH               |
      #| Dining    | Tables                | Rectangular Table Collections | RH              | RH               |
      #| Dining    | Bar & Counter         | Bar & Counter Stools          | RH              | RH               |
      #| Dining    | Sideboards            | Glass Sideboards              | RH              | RH               |
      #| Bath      | Bath Storage          | Open Shelving                 | RH              | RH               |
      #| Bath      | Lighting              | Bath Flushmounts              | RH              | RH               |
      #| Lighting  | Wall                  | Picture Lights                | RH              | RH               |
      #| Rugs      | Rugs By Size          | 9' X 12' Rugs                 | RH              | RH               |
      #| Décor     | Wall Art              | Photography                   | RH              | RH               |
      #| Outdoor   | Décor                 | Mirrors                       | RH              | RH               |
      #| Living    | Tables                | Entry Table                   | RH CONTEMPORARY | CN               |
      #| Bed       | Bed Linens            | Quilts & Coverlets            | RH CONTEMPORARY | CN               |
      #| Lighting  | Floor                 | All Floor Lighting            | RH CONTEMPORARY | CN               |
      #| Dining    | Tables                | Extension Tables              | RH INTERIORS    | IN               |
      #| Outdoor   | Textlies              | Outdoor Towels                | RH INTERIORS    | IN               |
      #| Living    | Tables                | Console Tables                | RH MODERN       | MO               |
      #| Dining    | Seating               | Benches                       | RH MODERN       | MO               |
      #| Lighting  | Bath                  | Sconces                       | RH MODERN       | MO               |
      #| Furniture | Furniture             | Chaises                       | RH OUTDOOR      | OD               |
      #| Textiles  | Towels                | Outdoor Towels                | RH OUTDOOR      | OD               |
      #| Living    | RH Beach House Living | Desks                         | RH BEACH HOUSE  | BH               |
      #| Dining    | RH Beach House Dining | Seating                       | RH BEACH HOUSE  | BH               |
      #| Bed       | RH Ski House Bed      | Beds                          | RH SKI HOUSE    | SH               |
      #| Lighting  | RH Ski House Lighting | Floor Lighting                | RH SKI HOUSE    | SH               |
      #| Bed       |Toddler Collections    | Crib Sheets                   | RH BABY & CHILD | BC               |
      #| Furniture | Study                 | Desk Chairs                   | RH BABY & CHILD | BC               |
      | Lighting  | Table                 | Shades                        | RH TEEN         | TN               |
      | Storage   | Wall                  | Memory Boards                 | RH TEEN         | TN               |

  Scenario: Checking Faucets in Collection PG
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I click 'SORT and confirm that Modal has text FEATURED, Price Low to High, Price High to Low' on PG screen
    Then I click 'Price Low to High and verify price is sorted' on PG screen
    Then I click 'IN-STOCK Filter' on PG screen
    Then I verify that 'CLEAR ALL is present when filter(s) are selected' on PG screen
    Then I click 'IN-STOCK Filter' on PG screen
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
    Then I navigate to menu 'Dining'
    Then I navigate to sub menu 'Sale'
    Then I navigate to gallerys_2 'Cabinets'
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
      | menu      | subMenu             | gallery         | brand           | currentBrandName | PGName          |
      #| Bath      | Vanities            | Powder Vanities | RH              | RH               | Powder Vanities |
      | Rugs      | Rug Pads            | All Rug Pads    | RH              | RH               | All Rug Pads    |
      #| Nursery   | Gifts               | Baby Apparel    | RH BABY & CHILD | BC               | Baby Apparel    |
      #| Furniture | Furniture           | Dining Chairs   | RH OUTDOOR      | OD               | Dining Chairs   |

  Scenario: Verify that Back to Top Button is present in PG and functioning
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'All Beds'
    Then I verify that 'Back to top Button is present' on PG screen
    Then I click 'Back to Top button' on PG screen
    Then I verify that 'user is brought to the top of the page' on PG screen
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
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
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I click 'sale checkbox' on PG screen
    Then I verify that 'Verify that all products have text From $ / $ Sale / $ Member' on PG screen
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Leather Beds'
    Then I click 'sale checkbox' on PG screen
    Then I verify that 'Verify that all products have text From $ / $ Sale / $ Member' on PG screen

  Scenario: Verify that PG is defaulted to 3-grid view
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I verify that 'Grid View is present in top right' on PG screen
    Then I verify that 'Grid View in PG is set to 3-grid view by default' on PG screen

  Scenario: Verify that PG Grid View is functional within PG
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I verify that 'Grid View is present in top right' on PG screen
    Then I verify that 'grid view is set to 3-grid view' on PG screen
    Then I Change the PG Grid view to '2' - grid view and confirm changing
    Then I Change the PG Grid view to '3' - grid view and confirm changing

  Scenario: Verify that PG Grid View is kept as selected as user browses through site -PG/CG/PDP and back
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Leather Beds'
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
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
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


  Scenario: To verify after navigating to PG, Brand name, categories, RH Logo, Search icon, Hamburger menu, Cart icon, My account image is present
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Dining'
    Then I navigate to sub menu 'Tables'
    Then I navigate to gallery 'Round & Oval Tables'
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


  Scenario: To verify sort option is present at the right side and its working
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Dining'
    Then I navigate to sub menu 'Tables'
    Then I navigate to gallery 'Round & Oval Tables'
    Then I verify that 'PG has SALE and IN-STOCK filters, text RESULTS (n), faucet with text SORT' on PG screen
    Then I click 'SORT and confirm that Modal has text FEATURED, Price Low to High, Price High to Low' on PG screen


  Scenario: To verify all options from sort dropdown are working
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Dining'
    Then I navigate to sub menu 'Tables'
    Then I navigate to gallery 'Round & Oval Tables'
    Then I verify that 'PG has SALE and IN-STOCK filters, text RESULTS (n), faucet with text SORT' on PG screen
    Then I click 'SORT and confirm that Modal has text FEATURED, Price Low to High, Price High to Low' on PG screen
    Then I verify that 'Back to top Button is present' on PG screen
    Then I click 'Back to Top button' on PG screen
    Then I click 'Price Low to High and verify price is sorted' on PG screen
    Then I click 'Price High to Low and verify price is sorted' on PG screen



  Scenario: To verify PG page is loading till footer
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Dining'
    Then I navigate to sub menu 'Tables'
    Then I navigate to gallery 'Round & Oval Tables'
    Then I verify page is loaded till footer


  Scenario: Verify that PG is defaulted to 3-grid view
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Bed'
    Then I navigate to sub menu 'Beds'
    Then I navigate to gallery 'Wood Beds'
    Then I verify that 'Grid View in PG is set to 3-grid view by default' on PG screen
    When I choose "CA" country
    Then I verify that 'Grid View in PG is set to 3-grid view by default' on PG screen
    When I choose "GB" country
    Then I verify that 'Grid View in PG is set to 3-grid view by default' on PG screen


  Scenario: Verify Enjoy free shipping banner for textile category
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Textiles'
    Then I navigate to sub menu 'Bedding by Type'
    Then I navigate to gallery 'Cotton Bedding'
    Then I verify Verify Enjoy free shipping banner for textile category
