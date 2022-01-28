@search @smoke 
Feature:
    As a user
    I want to serach for an item by SKU Id

    Background:
        Given I have a new session

    Scenario Outline: User should be able to search an item by SKU Id
        Given I am on the site as a guest user
        And I click <brand> in the header
        When I search for "<SKUID>" in search box and click on See All 
        Then I verify "<SKUID>" fullSkuId on PDP page

    Examples:
        |brand|SKUID| 
        |RH   |50400843 CLMR |
        # |RH Modern|11930477 BWMR  |
        # |RH Baby & Child|109273 BLBK|
        # |RH Teen   | 106580 FOX|


