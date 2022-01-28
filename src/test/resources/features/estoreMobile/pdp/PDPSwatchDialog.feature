@pdp @swatchDialog @smoke @mobile
Feature:
  As a user
  I can see the Swatch Dialog

  Scenario Outline: PDP Swatch Dialog displays swatch group messages
    Given I open the pdp "<product_id>" on mobile
    When I open the Swatch Panel Dialog
    Then I expect to see the "<messaging>" and "<spo_messaging>" delivery messaging

    Examples:
    | product_id | messaging | spo_messaging |
    | prod9740156 | (Ready for delivery in 3-7 days.) | (Delivery times vary) |