@projects @smoke
Feature:
    As a concierge user
    I want to be able to add custom products to my project

    Background:
        Given I am logged into Concierge as "aassociate"
        And I have a new project

    @deleteProjectAfter
    Scenario Outline: Projects: add roman shade to project
        When I open the pdp "<product_id>"
        And I prepare options for product "<product_id>" and sku "<full_sku_id>"
        When I select custom options:
            | field                  | value               |
            | Color                  | White               |
            | Mount Type             | Inside              |
            | Width                  | 26 1/4              |
            | Length                 | 30 7/8              |
            | Control Type           | Standard Cord Lock  |
            | Control Length         | 20                  |
            | Control Position       | Right               |
            | Lining                 | Blackout            |
            | Room                   | Kitchen             |
            | Window Description     | test order          |
        And I select quantity "1"
        And I add the product to my project with the Add All To Project button
        Then I see the product in my project
        And I verify the product has the options I selected

        Examples:
            | product_id   | title                                               | full_sku_id     |
            | prod15980105 | Belgian Linen Textural Basketweave Flat Roman Shade | 10001685 WHT    |


    @deleteProjectAfter
    Scenario Outline: Projects: add roller shade to project
        When I open the pdp "<product_id>"
        And I prepare options for product "<product_id>" and sku "<full_sku_id>"
        When I select custom options:
            | field                  | value               |
            | Color                  | Ivory               |
            | Mount Type             | Inside              |
            | Width                  | 26 1/4              |
            | Length                 | 30 7/8              |
            | Control Type           | Motorized           |
            | Control Position       | Right               |
            | Hardware Finish        | Bronze              |
            | Roll Type              | Regular             |
            | Room                   | Kitchen             |
            | Window Description     | test order          |
        And I select quantity "1"
        And I add the product to my project with the Add All To Project button
        Then I see the product in my project
        And I verify the product has the options I selected

        Examples:
            | product_id   | title                                               | full_sku_id     |
            | prod2820292  | Burlap Natural Roller Shade                         | 13870076 IVOR   |

    @deleteProjectAfter
    Scenario Outline: Projects: add wood blinds to project
        When I open the pdp "<product_id>"
        And I prepare options for product "<product_id>" and sku "<full_sku_id>"
        When I select custom options:
            | field                     | value               |
            | Color                     | Ebony               |
            | Mount Type                | Inside              |
            | Width                     | 26 1/4              |
            | Length                    | 30 7/8              |
            | Control Length            | 20                  |
            | Tilt Type                 | Wand                |
            | Control and Tilt Position | Same Side - Left    |
            | Room                      | Kitchen             |
            | Window Description        | test order          |
        And I select quantity "1"
        And I add the product to my project with the Add All To Project button
        Then I see the product in my project
        And I verify the product has the options I selected

        Examples:
            | product_id   | title                                               | full_sku_id     |
            | prod2500137  | Wood Blinds                                         | 13870082 EBNY   |
