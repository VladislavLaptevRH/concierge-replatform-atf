@smoke @presentation
Feature:
    As a developer
    I want to be able to test the cart presentation

    Scenario: Empty Cart page displays after clicking cart link in header
        Given I am on the site as a guest user
        When I click the cart button in the header
        Then I expect to be on the empty cart page
        And I expect page to not scroll horizontally

    Scenario: Cart page displays after clicking cart link in header
        Given I am on the site as a guest user
        And I have the following items in the cart:
            |product_id   | title                                   | full_sku_id     | qty |
            |prod11600084 | Rectangular Column Table Lamp           | 68270648 LBBM   | 2   |
        When I click the cart button in the header
        Then I expect to be on the cart page
        And I expect page to not scroll horizontally
