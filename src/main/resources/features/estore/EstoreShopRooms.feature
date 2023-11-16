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

  Scenario: Verify the shop by room under the BED top navigation.
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then I verify the shop by room under the LIVING top navigation