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
#    Scenario Outline: Projects: add custom drape product
#        When I open the pdp "<product_id>"
#        And I prepare options for product "<product_id>" and sku "<full_sku_id>"
#        When I select custom options:
#            | field                  | value               |
#            | Color                  | Cayenne             |
#            | Width                  | 22                  |
#            | Length                 | 40                  |
#            | Panels                 | Single              |
#            | Panel Side             | Right               |
#            | Lining                 | Privacy             |
#            | Room                   | Other               |
#            | Window Description     | test order          |
#        And I select quantity "1"
#        And I add the product to my project with the Add All To Project button
#        Then I see the product in my project
#        And I verify the product has the options I selected
#
#        Examples:
#            | product_id   | title                                                       | full_sku_id     |
#            | prod2970143 | Custom Belgian Heavyweight Linen 2-Fold French-Pleat Drapery | 13890481 CAYN   |
#
#    @deleteProjectAfter
#    Scenario Outline: Projects: add custom grommet drape product
#        When I open the pdp "<product_id>"
#        And I prepare options for product "<product_id>" and sku "<full_sku_id>"
#        When I select custom options:
#            | field                  | value               |
#            | Color                  | Bisque              |
#            | Finish                 | Black               |
#            | Width                  | 38                  |
#            | Length                 | 50                  |
#            | Panels                 | Pair                |
#            | Lining                 | Privacy             |
#            | Room                   | Office              |
#            | Window Description     | test order          |
#        And I select quantity "1"
#        And I add the product to my project with the Add All To Project button
#        Then I see the product in my project
#        And I verify the product has the options I selected
#
#        Examples:
#            | product_id   | title                                                       | full_sku_id     |
#            | prod8460487 | Custom Italian Textured Weave Grommet Drapery                | 13960536 BISQ   |
#
#    @deleteProjectAfter
#    Scenario Outline: Projects: add custom ripple-fold drape product
#        When I open the pdp "<product_id>"
#        And I prepare options for product "<product_id>" and sku "<full_sku_id>"
#        When I select custom options:
#            | field                  | value               |
#            | Color                  | Indigo              |
#            | Width                  | 21                  |
#            | Length                 | 40                  |
#            | Panels                 | Single              |
#            | Panel Side             | Left                |
##            | Control Type           | Cord                | disabled because of cord safety? track hardware?
##            | Control Side           | Left                |
##            | Hardware Type          | Wall                |
#            | Lining                 | Unlined             |
#            | Room                   | Bedroom 2           |
#            | Window Description     | test order          |
#        And I select quantity "1"
#        And I add the product to my project with the Add All To Project button
#        Then I see the product in my project
#        And I verify the product has the options I selected
#
#        Examples:
#            | product_id   | title                                                       | full_sku_id     |
#            | prod2970130 | Custom Basket Weave Linen Ripple-Fold Drapery | 13890191 INDG   |
