@conciergeRegression
Feature: PDP

  Scenario:Monogram
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I go to item "MONOGRAMMED 802-GRAM TURKISH TOWEL" from search field
    When I click on first item from grid
    When I click on add monogram checkbox from pdp
    When I choose monogram properties for pdp
    Then I verify that monogram was added for pdp

  Scenario: In stock
    Given I log into Concierge as "associate"
    When I go to item "53600402 BWCG" from search field
    When I click on view in stock items
    Then I verify that in stock modal pop up is displayed

  Scenario: On Sale
    Given I log into Concierge as "associate"
    When I go to item "17050001 DUNE" from search field
    When I click on view sale items
    Then I verify that on sale modal pop up is displayed

  Scenario: Custom rugs
    Given I log into Concierge as "associate"
    When I choose "RH Teen" from brand menu
    When I go to custom rugs
    Then I verify that custom rugs are displayed


