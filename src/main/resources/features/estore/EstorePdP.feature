@estoreRegression
@estorepdp
Feature: Estore PDP

  Scenario: Verify user can see the Product Details correctly mentioned for a product
    Given I log into eStore as "regular" user
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
    Then I verify that user can see product details correctly mentioned for a product

