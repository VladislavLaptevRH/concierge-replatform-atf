#@projects @smoke
#Feature:
#    As a concierge user
#    I want to be able to add custom products to my project
#
#    Background:
#        Given I am logged into Concierge as "aassociate"
#        And I have a new project
#
#    @deleteProjectAfter
#    Scenario Outline: Projects: add track hardware to project
#        When I open the pdp "<product_id>"
#        And I prepare options for product "<product_id>" and sku "<full_sku_id>"
#        When I select custom options:
#            | field                  | value               |
#            | Finish                 | Black               |
#            | Track Width            | 50                  |
#            | Panels                 | Pair                |
#            | Control Type           | Baton               |
#            | Mount Type             | Wall                |
#            | Room                   | Kitchen             |
#            | Window Description     | test order          |
#        And I select quantity "1"
#        And I add the product to my project with the Add All To Project button
#        Then I see the product in my project
#        And I verify the product has the options I selected
#
#        Examples:
#            | product_id   | title                                               | full_sku_id     |
#            | prod16840025 | Standard Track Hardware Set                         | 10003064 BK     |
