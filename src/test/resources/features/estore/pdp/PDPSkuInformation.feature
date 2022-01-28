@PHOE-381 @pdp @smoke
Feature:
    As a user
    I want to be informed of availability and delivery information regarding the sku I have selected.

    Scenario Outline: PDP displays curbside delivery
        Given I open the pdp "<product_id>"
        And I prepare options for product "<product_id>" and sku "<full_sku_id>"
        When I select the options
        Then I expect to see the "curbside" delivery message

        Examples:
        |product_id | title | full_sku_id |
        |prod1677187 | Provence Fountain | 42600037 GS |
