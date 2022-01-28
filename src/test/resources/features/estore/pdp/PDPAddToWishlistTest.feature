@smoke @criticalpath
Feature:
    As a user
    I want to verify that I am able to find "Add to WishList" button on PDP page

Background:
    Given I have a new session

    Scenario Outline: SignIn User can find a Add to WishList for Line Item
        Given I log into the site as "logInAndOutTest"
        And I click <brand> in the header
        When I open the pdp "<product_id>" for brand
        When I scroll to link "700"
        Then I am able to find "Add to WishList" button for the product "<product_id>"
        Then I signed out

        Examples:
          |brand |product_id |
          | RH   |prod11600084 |
          |RH Modern|prod7440119|
           |RH Teen        |rhtn_prod106735|
           |RH Baby & Child|rhbc_prod790028|


    Scenario Outline: Guest User can find a Add to WishList for Line Item
        Given I am on the site as a guest user
        And I click <brand> in the header
        When I open the pdp "<product_id>" for brand
        When I scroll to link "700"
        Then I am able to find "Add to WishList" button for the product "<product_id>"

        Examples:
            |brand |product_id |
            |RH    |prod11600084 |
            |RH Modern|prod7440119|
            |RH Teen        |rhtn_prod102355|
            |RH Baby & Child|rhbc_prod498035|

