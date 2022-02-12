#@projects @smoke
#Feature:
#    As a concierge user
#    I want to be able to add custom hardware to my project
#
#    Background:
#        Given I am logged into Concierge as "aassociate"
#        And I have a new project
#
#    @deleteProjectAfter
#    Scenario Outline: Projects: add custom hardware product
#        When I open the pdp "<product_id>"
#        And I prepare options for product "<product_id>" and sku "<full_sku_id>"
#        When I select custom options:
#            | field                  | value                     |
#            | Finish                 | Brushed Brass             |
#            | Size                   | Medium Rod                |
#            | Length                 | 80                        |
#            | Rod Type               | Single Rod                |
#            | Bracket Shape          | Round                     |
#            | Include Rings          | With Clip Rings           |
#            | Room                   | Bedroom 4                 |
#            | Window Description     | test order                |
#        And I select quantity "1"
#        And I add the product to my project with the Add All To Project button
#        Then I see the product in my project
#        And I verify the product has the options I selected
#
#        Examples:
#            | product_id   | title                                                       | full_sku_id     |
#            | prod2970180 | Custom Estate Metal Square Finials                           | 12260133 ABRS   |
