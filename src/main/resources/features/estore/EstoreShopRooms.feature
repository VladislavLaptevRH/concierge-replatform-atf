@estoreTestRun
@estoreShopRooms

Feature: Shop Rooms Links

  Scenario: Verify the shop by room under the LIVING top navigation.
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then I verify the shop by room under the LIVING top navigation


  Scenario: Verify the shop by room under the DINING top navigation.
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then I verify the shop by room under the LIVING top navigation

  Scenario Outline: Verify our company
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then I verify that I'm able to access "<link>"
    Examples:
      | link                 |
      | LETTERS FROM THE CEO |
      | LEADERSHIP TEAM      |
      | INVESTOR RELATIONS   |
      | PRESS                |
      | CAREERS              |

  Scenario Outline: Verify legal links
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then I verify that I'm able to access "<link>"
    Examples:
      | link                 |
      | PRIVACY              |
      | TERMS OF USE         |
      | TEXT MESSAGING TERMS |
      | RH IN CANADA         |
      | SAFETY RECALLS       |

  Scenario: Verify the country dropdown.
    Given I log into eStore as "regular" user
    When I scroll to bottom of Home Page
    Then I verify country dropdown form footer

  Scenario: Verify the copyright icon and year.
    Given I log into eStore as "regular" user
    When I scroll to bottom of Home Page
    Then I verify the copyright icon and year