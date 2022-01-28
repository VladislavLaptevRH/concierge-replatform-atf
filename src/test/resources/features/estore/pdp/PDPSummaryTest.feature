@smoke @criticalpath
Feature:
   As a developer
   I want to be able to test basic product information displayed on the PDP page

Background:
   Given I open the site "/"

Scenario Outline: PDP opens and displays basic information
   Given I open the pdp "<product_id>"
   Then  I expect that the title is "<Title>"
    And I expect page to not scroll horizontally

Examples:
    |product_id  | Title |
    |prod7630086 | Cylindrical Column Table Lamp |
