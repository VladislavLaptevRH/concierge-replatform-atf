@addressbook @smoke
Feature:
    As a user
    I want to be able to delete an address from my address book

    Background:
        Given I have a new session
        And I am logged into the site as "addressBookUser"

    Scenario: Address book delete a shipping address
        Given I have the following addresses in the address book:
            | test_data_key  | isDefault | firstName | lastName | address1       | address2 | city          | state | postalCode | phone        | altPhone     |
            | test_address_1 | true    | Penelope  | Prim     | 123 Ascot Dr   | #100     | Valdosta      | GA    | 33903      | 123-123-1234 | 123-345-0986 |
            | test_address_2 | false   | Tim       | Thompson | 300 Vermont St |          | San Francisco | CA    | 94118      | 1234567890   |              |
        When I open the "Address Book" page
        And I click on the delete link for address "test_address_2"
        Then I see the following address in the delete address modal:
            | test_data_key  | name         | street         | citystate            | postalCode | phone               | altPhone |
            | test_address_2 | Tim Thompson | 300 Vermont St | San Francisco, CA    | 94118      | Phone: 123.456.7890   |          |
        When I click the delete button in the delete address modal
        Then I expect the address "test_address_2" has been removed from the list

    Scenario: Address book delete the default shipping address
        Given I have the following addresses in the address book:
            | test_data_key  | isDefault | firstName | lastName | address1       | address2 | city          | state | postalCode | phone        | altPhone     |
            | test_address_1 | true    | Penelope  | Prim     | 123 Ascot Dr   | #100     | Valdosta      | GA    | 33903      | 123-123-1234 | 123-345-0986 |
            | test_address_2 | false   | Tim       | Thompson | 300 Vermont St |          | San Francisco | CA    | 94118      | 1234567890   |              |
        When I open the "Address Book" page
        And I click on the delete link for address "test_address_1"
        Then I see the following address in the delete address modal:
            | test_data_key  | name         | street         |street2| citystate            | postalCode | phone               | altPhone |
            | test_address_1 | Penelope Prim | 123 Ascot Dr  | #100  |Valdosta, GA | 33903      | Phone: 123.123.1234 | Alternate Phone: 123.345.0986 |
        When I click the delete button in the delete address modal
        Then I expect the address "test_address_1" has been removed from the list
        And I expect the address "test_address_2" is the default address
