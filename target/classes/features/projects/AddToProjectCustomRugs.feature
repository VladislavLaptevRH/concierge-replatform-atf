#@projects @smoke
#Feature:
#    As a concierge user
#    I want to be able to add products to my project with the inline add to project button
#
#    @deleteProjectAfter
#    Scenario Outline: Projects: add custom rug to project
#        Given I am logged into Concierge as "aassociate"
#        And I have a new project
#        When I open the pdp "<product_id>"
#        And I prepare options for product "<product_id>" and sku "<full_sku_id>"
#        When I select options and custom options:
#            | field                  | value               |
#            | Trim Color             | Linen               |
#            | Rug Width              | 10'4"               |
#            | Rug Length             | 10'4"               |
#        And I select quantity "1"
#        And I add the product to my project with the Add All To Project button
#        Then I see the product in my project
#        And I verify the product has the options I selected
#
#        Examples:
#            | product_id   | title                                   | full_sku_id     |
#            | prod1871355  | Custom Belgian Looped Wool Sisal Rug    | 15020143 CRM    |
