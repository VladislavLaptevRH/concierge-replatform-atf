@smoke @criticalpath
Feature:
    As a user
    I want to verify that a SignIn user is always able to find "Add to Registry" button on PDP page

    Background:
        Given I have a new session

    Scenario Outline: SignIn User can find a Add to Registry for Line Item
        Given I log into the site as "logInAndOutTest"
        And I crete registry if pre existing registry is not available
        And I click <brand> in the header  
        When I open the pdp "<product_id>" for brand
        Then I am able to find "Add to Registry" button for the product "<product_id>"
        And I prepare options for product "<product_id>" and sku "<full_sku_id>"
        When I select the options
        When I click on Add to Registry Button for the product "<product_id>" and select registry from modal and again click on Add to Registry
        Then I can see a message "1 ITEM ADDED TO YOUR REGISTRY"

        Examples:
            |brand |product_id |full_sku_id |
             |RH    |prod11600084 | 68270648 LBBM  |
             |RH Modern|prod7440119|11930477 BWMR  |
             |RH Baby & Child|rhbc_prod790028|109273 BLBK|
             |RH Teen        |rhtn_prod102355| 106580 FOX|

