@conciergeCG
@conciergeTestRun
Feature: Concierge CG Page

  Scenario Outline: Test CGS in all menu items
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I change the brand to "<brand>"
    Then I verify that RH Brand dropdown is present in "<currentBrandName>" home page
    Then I navigate to menu '<menu>'
    Then I navigate to sub menu '<subMenu>'
    Then confirm that Seating '<gallery>' is present in '<levelOfCollection>' of '<subMenu>'
    Examples:
      | menu      | subMenu                 | gallery                        | brand           | currentBrandName | levelOfCollection |
      | Living    | Fabric Seating          | Seating Collections            | RH              | RH               | 1                 |
      | Dining    | Tables                  | Rectangular Table Collections  | RH              | RH               | 1                 |
      | Bed       | Bed Linens              | Bedding Collections            | RH              | RH               | 1                 |
      | Bath      | Bath Towels & Linens    | Bath Towel Collections         | RH              | RH               | 1                 |
      | Textiles  | Pillows                 | Pillow Collections             | RH              | RH               | 1                 |
      | Rugs      | Rugs                    | Rug Collections                | RH              | RH               | 1                 |
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
      | menu      | subMenu             | gallery                    | brand        | currentBrandName |
#      | Windows   | Drapery             | Drapery Collections        | RH           | RH               |
      | Bath      | Furniture           | Bath Collections           | RH           | RH               |
#      | Living    | Shelving & Cabinets | Cabinet Collections        | RH INTERIORS | IN               |
#      | Textiles  | Pillows             | Outdoor Pillow Collections | RH OUTDOOR   | OD               |
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
      | menu      | subMenu               | gallery                     | brand        | currentBrandName |
      | Living    | Leather Seating       | Seating Collections         | RH           | RH               |
#      | Living    | Office                | Office Collections          | RH MODERN    | MO               |
#      | Lighting  | RH Ski House Lighting | Lighting Collections        | RH SKI HOUSE | SH               |
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
      | menu      | subMenu             | gallery              | brand               | currentBrandName |
      | Bath      | Furniture           | Bath Collections     | RH                  | RH               |
#      | Windows   | Drapery             | Drapery Collections  | RH INTERIORS        | IN               |
#      | Dining    | Shelving & Cabinets | Cabinet Collections  | RH MODERN           | MO               |
#      | Bed       | RH Beach House Bed  | Bedroom Collections  | RH BEACH HOUSE      | BH               |

#  Scenario: 1-2-3 Grid View Functionality within CG/PG/Different Brands
#    Given I log into Concierge as "associate"
#    When I choose country for concierge from footer
#    Then I navigate to menu "Living"
#    Then I navigate to sub menu "Office"
#    Then I navigate to gallery "Office Collections"
#    Then I safe the name of gallery
#    Then I verify that 'grid view is present on top right' on CG screen
#    Then I verify that 'grid view is set to 1-grid view by default' on CG screen
#    Then I Change the CG Grid view to '2' - grid view and confirm changing
#    Then I navigate to '1' gallery
#    Then I click 'Back Browser Button' on CG screen
#    Then I verify that 'same CG is displayed' on CG screen
#    Then I verify that 'grid view is set to 2-grid view' on CG screen
#    Then I Change the CG Grid view to '3' - grid view and confirm changing
#    Then I navigate to '2' gallery
#    Then I navigate to '1' PDP
#    Then I click 'Back Browser Button' on CG screen
#    Then I click 'Back Browser Button' on CG screen
#    Then I verify that 'same CG is displayed' on CG screen
#    Then I verify that 'grid view is set to 3-grid view' on CG screen
#    Then I Change the CG Grid view to '2' - grid view and confirm changing
#    Then I navigate to menu "Textiles"
#    Then I navigate to sub menu "Windows"
#    Then I navigate to gallery "Drapery Collections"
#    Then I verify that 'grid view is set to 2-grid view' on CG screen
#    Then I change the brand to "RH TEEN"
#    Then I verify that RH Brand dropdown is present in "TN" home page
#    Then I navigate to menu "Furniture"
#    Then I navigate to sub menu "Bedroom"
#    Then I navigate to gallery "Bedroom Collections"
#    Then I verify that 'grid view is set to 2-grid view' on CG screen
#    Then I change the brand to "RH MODERN"
#    Then I verify that RH Brand dropdown is present in "MO" home page
#    Then I navigate to menu "Rugs"
#    Then I navigate to sub menu "Handcrafted Rugs"
#    Then I navigate to gallery "Rug Collections"
#    Then I verify that 'grid view is set to 2-grid view' on CG screen

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

  Scenario: Verify Prices are not present in CGs
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Living'
    Then I navigate to sub menu 'Fabric Seating'
    Then I navigate to gallery 'Seating Collections'
    Then I verify $$ values are not present in the CG Collections page

  Scenario: In Main Menu of US/CA Sale Menu should be present, Sale menu should not be present for the UK region
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I verify flag icon for country selection and select and validate

  Scenario: CG loading time is expected to be less than 4-5 seconds
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Living'
    Then I navigate to sub menu 'Fabric Seating'
    Then I navigate to gallery 'Seating Collections'
    Then I verify loading time for CG page

  Scenario: To verify the top category nav
    Given I log into Concierge as "associate"
    Then I navigate to menu 'Living'
    Then I navigate to sub menu 'Fabric Seating'
    Then I navigate to gallery 'Seating Collections'
    Then I verify that 'grid view is present on top right' on CG screen
    Then I verify that 'grid view is set to 1-grid view by default' on CG screen
    Then I verify top nav

  Scenario: Verify Prices are not present in CG
    Given I log into Concierge as "associate"
    Then I navigate to menu 'Living'
    Then I navigate to sub menu 'Fabric Seating'
    Then I navigate to gallery 'Seating Collections'
    Then I verify that 'grid view is present on top right' on CG screen
    Then I verify that 'grid view is set to 1-grid view by default' on CG screen
    Then I Verify the price is not displayed

  Scenario: In main Menu of US/CA Sale Menu should be present, Sale menu should not be present for the UK region
    Given I log into Concierge as "associate"
    When I choose "US" country
    Then I Verify "SALE" is present
    When I choose "CA" country
    Then I Verify "SALE" is present
    When I choose "GB" country
    Then I Verify "Sale" is present

  Scenario: Switch countries on the CG Pages
    Given I log into Concierge as "associate"
    Then I navigate to menu 'Living'
    Then I navigate to sub menu 'Fabric Seating'
    Then I navigate to gallery 'Seating Collections'
    Then I verify that 'grid view is present on top right' on CG screen
    When I choose "US" country
    Then I verify that 'grid view is present on top right' on CG screen
    When I choose "CA" country
    Then I verify that 'grid view is present on top right' on CG screen
    When I choose "GB" country
    Then I verify that 'grid view is present on top right' on CG screen

  Scenario: To verify Collection name should be left aligned
    Given I log into Concierge as "associate"
    Then I navigate to menu 'Living'
    Then I navigate to sub menu 'Fabric Seating'
    Then I navigate to gallery 'Seating Collections'
    Then I verify title is left aligned

  Scenario: Verify that RH MEMBERS PROGRAM. SAVE 25% ON EVERYTHING* on the top-right
   Given I log into Concierge as "associate"
   Then I navigate to menu 'Living'
   Then I navigate to sub menu 'Fabric Seating'
   Then I navigate to gallery 'Seating Collections'
   Then I verify RH MEMBERS PROGRAM is right aligned

   Scenario: To verify that all CGs are loading till footer
     Given I log into Concierge as "associate"
     When I choose country for concierge from footer
     Then I navigate to menu 'Living'
     Then I navigate to sub menu 'Fabric Seating'
     Then I navigate to gallery 'Seating Collections'
     Then I verify page is loaded till footer

  Scenario: Verify that textile CGs have ENJOY FREE SHIPPING ON ALL TEXTILES to the right of the page
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Textiles'
    Then I navigate to sub menu 'Bed Linens'
    Then I navigate to gallery 'Bedding Collections'
    Then I verify Free shipping message in textiles

  Scenario: Verify that some CGs have View Sale
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Living'
    Then I navigate to sub menu 'Fabric Seating'
    Then I navigate to gallery 'Seating Collections'
    Then I Verify "SALE" is present

  Scenario: To verify that MO CGs are present for applicable CG pages below RH CGs
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Living'
    Then I navigate to sub menu 'Fabric Seating'
    Then I navigate to gallery 'Seating Collections'
    Then I verify MO in CG page

  Scenario: Verify that click on View Sale verbiage should open the sale PG with collections related sale SKUs
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Living'
    Then I navigate to sub menu 'Fabric Seating'
    Then I navigate to gallery 'Seating Collections'
    Then I verify Sale is clicked and taken to PG page
    Then I verify $$ values are present in the PG Collections page

  Scenario Outline: Verify that "Available in multiple sizes & finishes" verbiage is shown along with collection text for collections like Dining Tables. Bed Collections
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu "<menu>"
    Then I navigate to sub menu "<subMenu>"
    Then I navigate to gallery "<gallery>"
    Then I verify Available in multiple sizes & finishes text on page
    Examples:
      | menu      | subMenu               | gallery                      |
      | Dining    | Tables                | Rectangular Table Collections|
      | Bath      | Furniture             | Bath Collections             |
      | Outdoor   | In Stock              | Furniture Collections        |
