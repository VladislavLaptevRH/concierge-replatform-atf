@addressbook @smoke
Feature:
    As a user
    I want to be able to edit addresses from my Address Book

    Background:
        Given I have a new session
        And I am logged into the site as "addressBookUser"

    Scenario: Address book edit a shipping address
        Given I have the following addresses in the address book:
            | test_data_key  | isDefault | firstName | lastName | address1     | address2 | city     | state | postalCode | phone        | altPhone     |
            | test_address_1 | true    |Penelope  | Prim     | 123 Ascot Dr | #100     | Valdosta | GA    | 33903      | 123-123-1234 | 123-345-0986 |
        When I open the "Address Book" page
        And I click on the edit link for address "test_address_1"
        And I save the following address in the Edit Address Form:
            | test_data_key  | firstName | lastName | address1      | address2 | city     | state | postalCode | phone        | altPhone     |
            | test_address_1 | Penny     | Prime    | 123 Ascot Way |          | Athens | GA    | 33903      | 1112223333 | 333-222-1111 |
        Then I see the following address in the address list:
            | test_data_key  | name        | street        | citystate  | postalCode | phone               | altPhone                      |
            | test_address_1 | Penny Prime | 123 Ascot Way | Athens, GA | 33903      | Phone: 111.222.3333 | Alternate Phone: 333.222.1111 |

    Scenario: Address book change the default shipping address
        Given I have the following addresses in the address book:
            | test_data_key  | isDefault| firstName | lastName | address1       | address2 | city          | state | postalCode | phone        | altPhone     |
            | test_address_1 | true   | Penelope  | Prim     | 123 Ascot Dr   | #100     | Valdosta      | GA    | 33903      | 123-123-1234 | 123-345-0986 |
            | test_address_2 | false  | Tim       | Thompson | 300 Vermont St |          | San Francisco | CA    | 94118      | 1234567890   |              |
        When I open the "Address Book" page
        And I click on the default checkbox for address "test_address_2"
        Then I expect the address "test_address_2" is the default address
