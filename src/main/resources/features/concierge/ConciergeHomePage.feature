@concierge-All
@concierge-HomePage
Feature:Concierge Homepage

  Scenario: Verify that home page is accessible
    Given I log into Concierge as "associate"
    Then  I expect that I am on the Concierge Dashboard page

  Scenario: Verify menu of items
    Given I log into Concierge as "associate"
    Then user verifies that all items from menu are displayed

  Scenario: Login as associate and see dashboard
    Given I log into Concierge as "associate"
    Then  I expect that I am on the Concierge Dashboard page

  Scenario: Login as leader and see dashboard
    Given I log into Concierge as "associate"
    Then  I expect that I am on the Concierge Dashboard page

  Scenario: Change store number in concierge from dashboard
    Given I log into Concierge as "associate"
    When I change my store to number "10"
    Then I verify I see store Palo Alto in the header

  Scenario: Verify that all galleries are present in list
    Given I log into Concierge as "associate"
    When user clicks on gallery button from header
    Then user verifies list of galleries which have default value "5: Newport Beach"

  Scenario: Footer links
    Given I log into Concierge as "associate"
    Then I verify footer links


#  Scenario: Validate Each Category And Sub-Category
#    Given I log into Concierge as "associate"
#    Then  I expect that I am on the Concierge Dashboard page
#    Then I validate each cat and sub-cat

