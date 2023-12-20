@conciergeTestRun
@conciergeRegistry
Feature:Concierge Registry

  Scenario: Search by name
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on registry button
    When I search registry by name
    When I click on "SEARCH" registry button
    Then I verify that search result for registry search by "name" is displayed

  Scenario: Search by email
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on registry button
    When I search registry by email
    When I click on "SEARCH" registry button
    Then I verify that search result for registry search by "email" is displayed

  Scenario: Search by event type
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on registry button
    When I search registry by event type
    When I click on "SEARCH" registry button
    Then I verify that search result for registry search by "event type" is displayed

  Scenario: Create A New Registry
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on registry button
    When I click on new registry button
    When I fills all field for create registry
    When I click on "create registry" registry button
    When I click on continue registrant button
    When I click on "create registry" registry button
    When I click on registry button
    When I go to the created registry
    When I click on "SEARCH" registry button
    Then I verify that registry was created

  Scenario: Edit registry
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on registry button
    When I search registry by name
    When I click on "SEARCH" registry button
    When I click on displayed registry
    When I click on "edit registry" registry button
    When I click on "edit registry details" registry button
    When I edit registry for registrant
    When I click on "SAVE CHANGES" registry button
    When I click on continue registrant button
    When I click on "SAVE CHANGES" registry button
    Then I verify that registry was edited

  Scenario: Delete registry
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on registry button
    When I click on new registry button
    When I fills all field for create registry
    When I click on "create registry" registry button
    When I click on continue registrant button
    When I click on "create registry" registry button
    When I click on delete registry button
    When I click on "delete registry" registry button
    When I click on registry button
    When I go to the created registry
    When I click on "SEARCH" registry button
    Then I verify that registry has been deleted

#  Scenario: Purchase Registry
#    Given I log into Concierge as "associate"
#    When I remove all items from cart
#    When I choose client from header
#    When I go to item "METAL BOX FRAME LEANER MIRROR" from search field
#    And I select count of product
#    When I click on add to registry button
#    When I click on manage registry button
#    When I click on purchase registry button
#    When I choose quantity for registry's item
#    When I add item to cart from registry
#    When I choose order classification
#    When I click on checkout button
#    When I click on no thanks button
#    When I choose client who is a "nonmember"
#    Then I verify that address screen is displayed

  Scenario: Manage Registry
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on registry button
    When I search registry by name
    When I click on "SEARCH" registry button
    When I click on displayed registry
    Then I verify that I'm able to manage registry

#  Scenario: Reset Registry from client drop down
#    Given I log into Concierge as "associate"
#    When I click on registry button
#    When I search registry by name
#    When I click on "SEARCH" registry button
#    When I click on displayed registry
#    When I click on rh concierge logo
#    When I go to item "METAL BOX FRAME LEANER MIRROR" from search field
#    Then I verify that add to registry button is "displayed"
#    When I click on reset registry
#    When I click on rh concierge logo
#    When I go to item "METAL BOX FRAME LEANER MIRROR" from search field
#    Then I verify that add to registry button is "not displayed"

  Scenario: Coregistraint name
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on registry button

#  Scenario: Pagination for searched registry
#    Given I log into Concierge as "associate"
#    When I click on registry button
#    When I search registry with more client create registries
#    When I click on "SEARCH" registry button
#    Then I verify that pagination is displayed