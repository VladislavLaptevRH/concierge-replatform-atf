@search @smoke @presentation @browse page
Feature:
    As a guest user & logged in user
    I want to verify browse page feature on search page for RH brand

    Background:
        Given I have a new session

    Scenario Outline: guest user should be able to view search page title on RH brand
        Given I am on the site as a guest user
        When I click on the search icon
        When Search for product <searchedTerm>
        When I press "Enter"
        When I navigate via "<topNave>",and "<category>"
        When I click on the subCategory "<subCategory>"
        Then Verify that checkbox is autoselected "<subCategory>" in refinement "<facets>"

        Examples:
            |searchedTerm|topNave|category|subCategory|facets|
            |" "|Rugs|Rugs By Size   |12' X 15' Rugs  |SIZE|

