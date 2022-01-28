@smoke @criticalpath
Feature:
    As a developer
    I want to be able to test that CG, PG or PDP page are never returning 404 or blank page.

    Scenario Outline: CG opens and displays information
        Given I am on the site as a guest user
        And I click <brand> in the header
        And I open the cg page with "<category_id>"
        When I expect that the title not contains "RH 404 Error"
        Then I verify for the collection gallery list

        Examples:
            |brand      |category_id|
            |RH         |cat10210005|             
            |RH         |cat10250052|
            |RH         |cat15790016|
            |RH         |cat3200001|
            |RH         |cat11230028|
            |RH Modern  |cat7030238|
            |RH Modern  |cat7030165|
            |RH Modern  |cat7030147|
            |RH Modern  |cat6960018|
            |RH Baby & Child|rhbc_cat101050|
            |RH Baby & Child|rhbc_cat358022|
            |RH Baby & Child|rhbc_cat379006|
            |RH Teen   |rhbc_cat509013|
            |RH Teen   |rhbc_cat509014|
            |RH Teen   |rhbc_cat509015|

     Scenario Outline: PG opens and displays information
        Given I am on the site as a guest user
        And I click <brand> in the header
        And I open the pg page with "<category_id>"
        When I expect that the title not contains "RH 404 Error"
        Then I verify for the product gallery list

        Examples:
            |brand      |category_id|
            |RH         |cat18490019|             
            |RH         |cat19320096|
            |RH         |cat10170020|
            |RH         |cat1512021|
            |RH         |cat21240024|
            |RH Modern  |cat7150063|
            |RH Modern  |cat16860002|
            |RH Modern  |cat7030136|
            |RH Modern  |cat19470043|
            |RH Baby & Child|rhbc_cat338027|
            |RH Baby & Child|rhbc_cat377471|
            |RH Baby & Child|rhbc_cat361051|
            |RH Teen   |rhbc_cat481012|
            |RH Teen   |rhbc_cat481006|
            |RH Teen   |rhbc_cat481041|

    

     Scenario Outline: PDP opens and displays information
        Given I am on the site as a guest user
        And I click <brand> in the header
        When I open the pdp "<product_id>" for brand
        When I expect that the title not contains "RH 404 Error"
        Then I expect the pdp page have this product "<product_id>"

        Examples:
            |brand      |product_id  |
            |RH         |prod7630086|             
            |RH         |prod10810132|
            |RH         |prod20670281|
            |RH         |prod18910158|
            |RH         |prod190091|
            |RH Modern  |prod20560159|
            |RH Modern  |prod14970086|
            |RH Modern  |prod18200047|
            |RH Modern  |prod22630052|
            |RH Baby & Child|rhbc_prod963097|
            |RH Baby & Child|rhbc_prod731098|
            |RH Baby & Child|rhbc_prod963601|
            |RH Teen   |rhtn_prod104549|
            |RH Teen   |rhtn_prod106372|
            |RH Teen   |rhtn_prod106785|

     
