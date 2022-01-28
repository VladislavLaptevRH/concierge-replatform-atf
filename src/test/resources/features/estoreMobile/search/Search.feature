@criticalpath @mobile @monitor
Feature:
    As a customer
    I can search from home page by search values

    Background:

    Scenario Outline: Home page search returns results
        Given I open the site "/" on mobile
        When I expect that the title is "RH Homepage" on mobile
        Then I dismiss the membership popup if exists
        Then  I enter "<search_value>" in the search field and verify search results url

        Examples:
            | search_value |
            | chair        |
