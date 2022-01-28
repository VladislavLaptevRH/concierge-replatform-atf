@locator @smoke
Feature:
    As a customer
    I can enter search information into the large locator form at the top of the locator page

    Background:
        Given The Locator Search Promo is active

    Scenario Outline: Gallery Locator search from promo
        Given I open the gallery locator page
        When  I enter "<search_value>" in the locator search promo field
        Then  I expect the map to display "gallery" locations
        And   I expect the list to display "gallery" locations for "<search_value>"

        Examples:
            | search_value |
            | 15228        |
