@concierge-All
@concierge-CG
@conciergeCriticalPathTestRun
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
      | Lighting  | Lighting Collections    |                                | RH              | RH               | 2                 |
      | Textiles  | Pillows                 | Pillow Collections             | RH              | RH               | 1                 |
      | Rugs      | Rugs                    | Rug Collections                | RH              | RH               | 1                 |
      | Windows   | Drapery                 | Drapery Collections            | RH              | RH               | 1                 |
      | Outdoor   | Furniture Collections   |                                | RH              | RH               | 3                 |
      | Living    | Leather Seating         | Seating Collections            | RH CONTEMPORARY | CN               | 1                 |
      | Bath      | Faucets & Hardware      | Faucets & Hardware Collections | RH CONTEMPORARY | CN               | 1                 |
      | Textiles  | Bed Linens              | Bedding Collections            | RH CONTEMPORARY | CN               | 1                 |
      | Living    | Sideboards              | Sideboard Collections          | RH INTERIORS    | IN               | 1                 |
      | Dining    | Counter & Bar           | Leather Stool Collections      | RH INTERIORS    | IN               | 2                 |
      | Textiles  | Throws                  | Throw Collections              | RH INTERIORS    | IN               | 1                 |
      | Living    | Pillows & Throws        | Throw Collections              | RH MODERN       | MO               | 2                 |
      | Dining    | Shelving & Cabinets     | Cabinet Collections            | RH MODERN       | MO               | 1                 |
      | Textiles  | Windows                 | Custom Drapery Collections     | RH MODERN       | MO               | 4                 |
      | Furniture | Furniture Collections   |                                | RH OUTDOOR      | OD               | 2                 |
      | Textiles  | Pillows                 | Outdoor Pillow Collections     | RH OUTDOOR      | OD               | 1                 |
      | Bed       | RH Beach House Bed      | Bedroom Collections            | RH BEACH HOUSE  | BH               | 1                 |
      | Lighting  | RH Beach House Lighting | Ceiling Collections            | RH BEACH HOUSE  | BH               | 1                 |
      | Dining    | RH Ski House Dining     | Cabinet & Shelving Collections | RH SKI HOUSE    | SH               | 8                 |
      | Bath      | RH Ski House Bath       | Bath Collections               | RH SKI HOUSE    | SH               | 4                 |
      | Furniture | Bedroom                 | Bedroom Collections            | RH BABY & CHILD | BC               | 1                 |
      | Furniture | Nursery                 | Nursery Collections            | RH BABY & CHILD | BC               | 1                 |
      | Furniture | Bedroom                 | Bedroom Collections            | RH TEEN         | TN               | 1                 |
      | Rugs      | Handcrafted Rugs        | Rug Collections                | RH TEEN         | TN               | 1                 |

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
      | menu      | subMenu               | gallery                    | brand        | currentBrandName |
      | Windows   | Drapery               | Drapery Collections        | RH           | RH               |
      | Bath      | Furniture             | Bath Collections           | RH           | RH               |
      | Living    | Shelving & Cabinets   | Cabinet Collections        | RH INTERIORS | IN               |
      | Textiles  | Pillows               | Outdoor Pillow Collections | RH OUTDOOR   | OD               |
      | Furniture | Lounge & Media        | Lounge & Media Collections | RH TEEN      | TN               |

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
    Then I verify that 'Navigate to fourth collection' on CG screen
    Then I verify that 'Navigate to first product' on CG screen
    Then I click 'Back Browser Button' on CG screen
    Then I verify that 'confirm that PG is displayed' on CG screen
    Then I click 'Back Browser Button' on CG screen
    Then I click 'confirm that CG Rug Collections is displayed' on CG screen


