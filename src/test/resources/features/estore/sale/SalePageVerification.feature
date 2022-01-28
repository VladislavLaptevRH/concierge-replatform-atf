@smoke @criticalpath
Feature:
    As a user
    I want to verify that Title and sale banner should be present on Sale page. 
    Also For few categories sale items should be displayed on Sale PG page.
   
    Scenario Outline: Verify Sale Title and Sale Banner on sale page 
        Given I am on the site as a guest user
        And I click <brand> in the header
        When I click on Sale Section
        Then I expect that the title contains "Sale"
        Then I verify RH Sale banner displayed on page

        Examples:
            |brand |
            |RH    |
            |RH Modern|
            |RH Baby & Child|
            |RH Teen   |     


    Scenario Outline: Verify Nav verification on Each brand Sale page
        Given I am on the site as a guest user
        And I click <brand> in the header
        When I click on Sale Section
        When I hover over "<topCategory1>" and select the first subcategory from menu
        Then I verify Sale page contains "Sale" products
        When I hover over "<topCategory2>" and select the first subcategory from menu
        Then I verify Sale page contains "Sale" products
        When I hover over "<topCategory3>" and select the first subcategory from menu
        Then I verify Sale page contains "Sale" products
        When I hover over "<topCategory4>" and select the first subcategory from menu
        Then I verify Sale page contains "Sale" products

        Examples:
         |brand    |topCategory1|topCategory2|topCategory3|topCategory4|
         |RH       | Living     |Dining      |Lighting    |Outdoor     | 
         |RH Modern|Living      |Dining      |Lighting    |Outdoor     |
         |RH Ski House|Living   |Dining      |Lighting    |Outdoor     | 
         |RH Beach House|Living |Dining      |Lighting    |Outdoor     | 
         |RH Baby & Child|Furniture|Bedding  |Nursery     |Lighting    | 
         |RH Teen   |Furniture   |Bedding    |Lighting    |Rugs        |


    