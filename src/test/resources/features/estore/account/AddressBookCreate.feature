@addressbook @smoke
Feature:
    As a user
    I want to be able to create a new address in the address book

    Background:
        Given I have a new session
        And I am logged into the site as "addressBookUser"
        And I have no addresses in the address book

    Scenario: Address Book create new shipping address
        Given I open the "Address Book" page
        And I click the Create Address button
        And I save the following address in the New Address Form:
            | test_data_key  | isDefault | firstName | lastName | address1     | address2 | city     | state | postalCode | phone        | altPhone     |
            | test_address_1 | true    |Penelope  | Prim     | 123 Ascot Dr | #100     | Valdosta | GA    | 33903      | 123-123-1234 | 123-345-0986 |
        Then I see the following address in the address list:
            | test_data_key  | name          | street        | street2 | citystate    | postalCode | phone               | altPhone                      |
            | test_address_1 | Penelope Prim | 123 Ascot Dr  | #100        |Valdosta, GA | 33903      | Phone: 123.123.1234 | Alternate Phone: 123.345.0986 |

