@search @smoke 
Feature:
    As a user
    I want to serach for an item and apply refinements

    Background:
        Given I have a new session

    Scenario Outline: User should be able to apply refinements for searched product
        Given I am on the site as a guest user
        And I click <brand> in the header
        When I search for "<searchItem>" in search box and click on See All 
        Then I verify the first two products on top contain the word "<searchItem>"
        When I click "<categoryName>" filter item from left "<refineOption1>" navigation
        Then I see "<categoryName>" category refinement selected
        Then I verify the first two products on top contain the word "<searchItem>" 
        When I click "2" filter item from left "<refineOption2>" navigation
        Then I verify the first two products on top contain the word "<searchItem>"
        Then I verify filter "2" is selected
    
    Examples:
        |brand|searchItem|categoryName|refineOption1|refineOption2|
          |RH|Chair |Living|category|finish|
        #   |RH Modern|Chair |Living|category|leather|
        #   |RH Baby & Child|Chair |Furniture|category|finish|
        #  |RH Teen  |Chair |Furniture|category|fabric|