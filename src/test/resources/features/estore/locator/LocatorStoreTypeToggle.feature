@locator @smoke
Feature:
    As a customer
    I can toggle stores by type in the locator form

    #note that gallery is selected by default, so don't put gallery first in list.
    Scenario: Gallery Locator filter by store type
        Given I open the gallery locator page
        Then  I click on the store type filter and see updated results:
            | store_type |
            | all        |
            | gallery    |
            | outlet     |
