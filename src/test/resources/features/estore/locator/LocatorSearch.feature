@smoke @locator
Feature:
    As a customer
    I can search for stores by common address fields, like city, state, postal code.

    Scenario Outline: Gallery Locator search returns results
        Given I open the gallery locator page
        When  I enter "<search_value>" in the locator search field
        Then  I expect the map to display "gallery" locations
        And   I expect the list to display updated "gallery" locations

        Examples:
            | search_value |
            | 15228        |
            | Chicago      |
            | New York     |

    Scenario Outline: Gallery Locator displays no results message
        Given I open the gallery locator page
        When  I enter "<search_value>" in the locator search field
        Then  I see a no locations found message
        And   I expect the list and map to display all "gallery" locations


        Examples:
            | search_value |
            | Bismark, ND  |
