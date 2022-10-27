#@conciergeRegression
#@concierge-OrderHistory
#Feature:Concierge Order history
#
#  Scenario: Order history search is accessible from the dashboard
#    Given I log into Concierge as "associate"
#    When I navigate to the order history page from the concierge dashboard
#    Then I verify the customer lookup form appears
#    And I verify the order lookup form appears
#
#  Scenario Outline: Verify order history search returns a list of users - <firstName>
#    Given I log into Concierge as "associate"
#    When I navigate to the order history page from the concierge dashboard
#    And I search order history for customer "<firstName>" "<lastName>"
#    Then I see results for order history by customer search
#    Examples:
#      | firstName | lastName   |
#      | notexist  | notexist   |
#      | test      | test       |
#
#  Scenario: Verify UI elements from order history page
#    Given I log into Concierge as "associate"
#    When I navigate to the order history page from the concierge dashboard
#    And I search order history for customer "Automation" "Nonmember"
#    When I click on the random result
#    Then I verify that order history page is displayed
#
#  Scenario:Verify that customer lookup is displayed after that I click on back to search results button
#    Given I log into Concierge as "associate"
#    When I navigate to the order history page from the concierge dashboard
#    And I search order history for customer "Automation" "Nonmember"
#    When I click on the random result
#    When I click on back to search results button
#    Then I verify the customer lookup form appears
#
#  Scenario: Verify that if I click on order item I'll redirected to wismo
#    Given I log into Concierge as "associate"
#    When I navigate to the order history page from the concierge dashboard
#    And I search order history for customer "Automation" "Nonmember"
#    When I click on the random result
#    When I click on random order
#    Then I verify that I redirected to wismo
#
#  Scenario: Verify that if I click on order item I'm able to check order details
#    Given I log into Concierge as "associate"
#    When I navigate to the order history page from the concierge dashboard
#    And I search order history for customer "Automation" "Nonmember"
#    When I click on the random result
#    When I click on random order
#    And I verify that I redirected to wismo
##    Then I verify order details
#
#  Scenario Outline: Verify order lookup search for <status> order
#    Given I log into Concierge as "associate"
#    When I navigate to the order history page from the concierge dashboard
#    Then I verifiy that Order Lookup title is displayed
#    When I introduced "<orderId>" with status "<status>" order number in order number field
#    Then I verify that I redirected to wismo
#    Examples:
#      | orderId         | status      |
#      | R03283581845714 | inProcess   |
#      | 785071          | open        |
#      | 12345           | notExisting |
#
