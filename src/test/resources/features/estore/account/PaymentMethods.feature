@payment @criticalpath @smoke
Feature:
    I want to test the payment page form for Add card and Delete card

    Background:
        Given I have a new session
        Given I open the url "/my-account/sign-in.jsp"
        Given I set a cookie "pc" with the content "94111"

    Scenario: Registered user can Add a CARD on account payment page
        Given I am the new web customer:
            | first   | last   |
            | Cucumber | User |
        And I clear the already present cards on the account payment page
        When I click on PAYMENT METHODS and enter card information after clicking on New Card on payment page:
            | first    | last | address1        | address2 | city    | state | country | country_full  | postal | phone      | cardType        | cardNumber       | expMonth | expYear | ccv  |
            | Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | United States | 98101  | 5555555555 | visa            | 4114360123456785 | 03      | 2030    | 111  |
            | Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | United States | 98101  | 5555555555 | americanExpress | 341134113411347  |02       | 2025    | 6765 |
        Then I expect the below cards should be displayed on account payment page
            | cardType        | cardNumber       |
            | visa            | 4114360123456785 |
            | americanExpress | 341134113411347  |
        Then I signed out

    Scenario: Registered user can Delete a CARD on account payment page
        Given I am the new web customer:
            | first    | last   |
            | Cucumber | User |
        When I clear the already present cards and add below cards on the account payment page:
            | first    | last | address1        | address2 | city    | state | country | country_full  | postal | phone      | cardType        | cardNumber       | expMonth | expYear | ccv  |
            | Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | United States | 98101  | 5555555555 | visa            | 4114360123456785 | 03       | 2030    | 111  |
            | Cucumber | User | 721 Pine Street |          | Seattle | WA    | US      | United States | 98101  | 5555555555 | americanExpress | 341134113411347  |02        | 2025    | 6765 |
        Then I expect the below cards should be displayed on account payment page
            | cardType        | cardNumber       |
            | americanExpress | 341134113411347  |
            | visa            | 4114360123456785 |
        When I delete "americanExpress" credit card on Payment method page
        Then I expect the below cards should be displayed on account payment page
            | cardType        | cardNumber       |
            | visa            | 4114360123456785 |
        When I delete "visa" credit card on Payment method page
        Then I expect the below cards should be displayed on account payment page
            | cardType        | cardNumber       |
            |                 |                  |
        Then I signed out
