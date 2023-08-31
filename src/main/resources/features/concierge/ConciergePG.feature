@concierge-All
@concierge-PG
@conciergeCriticalPathTestRun
Feature: Concierge PG Page

  Scenario: Checking Faucets in Collection PG
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer

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
    Then I verify that 'Verify that all products have text From $ / $ Sale / $ Member' on PG screen

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
    When I open product page with "prod14020058"
    Then I click 'Back Browser Button' on PG screen
    Then I verify that 'grid view is set to 2-grid view' on PG screen
    Then I navigate to menu 'Dining'
    Then I navigate to sub menu 'Sideboards'
    Then I navigate to gallery 'Glass Sideboards'
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