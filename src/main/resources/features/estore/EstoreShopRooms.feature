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
    Then I verify the shop by room under the BED top navigation

  Scenario: Verify the shop by room under the BATH top navigation.
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then I verify the shop by room under the BATH top navigation

  Scenario: Verify the shop by room under the OUTDOOR top navigation
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then I verify the shop by room under the OUTDOOR top navigation

  Scenario: Verify the shop room page. SHOPROOM navigation are: LIVING DINING BEDROOM BATH HOME OFFICE CONTEMPORARY OUTDOOR BEACH HOUSE SKI HOUSE
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then I verify the shop by room Page

  Scenario: Verify Elements/Apps panel
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then I verify elements panel

  Scenario: Verify Elements/Apps panel slider function
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then I verify elements panel slider function

  Scenario: Verify Show Products function
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then I verify show product function