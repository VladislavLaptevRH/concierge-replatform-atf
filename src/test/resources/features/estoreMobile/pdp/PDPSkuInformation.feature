@PHOE-381 @pdp @smoke @mobile
Feature:
    As a user
    I want to be informed of availability and delivery information regarding the sku I have selected.

    Scenario Outline: PDP displays curbside delivery
        Given I open the pdp "<product_id>" on mobile
        And I prepare options for product "<product_id>" and sku "<full_sku_id>" on mobile
        When I select the options on mobile
        Then I expect to see the "curbside" delivery message on mobile

        Examples:
        |product_id | title | full_sku_id |
        |prod1677187 | Provence Fountain | 42600037 GS |
