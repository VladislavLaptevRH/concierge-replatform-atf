@concierge-All
@concierge-Sale
Feature:Concierge Sale

  Scenario: Sale navigation bar is displayed and functional
    Given I log into Concierge as "associate"
    When I click on sale
    Then I verify sale navigation bars are displayed

  Scenario: Sale navigation and validate regular, member and finale sale prices on PDP.
    Given I log into Concierge as "associate"
    When I click on sale
    When I click on sale menu item
    When I click on sub category and navigate PDP
    Then I verify prices on product page


