@projects @smoke
Feature:
    As a concierge user
    I want to be able to add products to my project with the inline add to project button

    @deleteProjectAfter
    Scenario Outline: Projects: add product to project from inline button
        Given I am logged into Concierge as "aassociate"
        And I have a new project
        When I open the pdp "<product_id>"
        And I prepare options for product "<product_id>" and sku "<full_sku_id>"
        And I select the options and quantity "1"
        And I add the product to my project with the Add To Project button
        Then I see the product in my project

        Examples:
            | product_id   | title                                   | full_sku_id     |
            | prod10770022 | ULTRA-SOFT TURKISH BATH TOWEL           | 17110459 WHT    |
            | prod8760140  | Maxwell Sofa                            | 58840005 BLBK   |
