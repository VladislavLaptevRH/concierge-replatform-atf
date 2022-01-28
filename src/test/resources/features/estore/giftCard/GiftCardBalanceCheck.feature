@smoke @customerService
Feature:
    As a user
    I want to check my gift card balance.
    
    Scenario: Gift card balance inquiry page returns error message when gift card details are not entered
        Given I am on gift card balance inquiry page
        When  Gift card number and pin is not entered
        Then  I expect error "Invalid card number, please re-enter. If you require additional assistance, please call Customer Service at 800.231.1773."

 Scenario Outline: RH Gift Card Balance Check with no card
        Given I am on gift card balance inquiry page
        When  I enter following gift card details in the fields:
            | giftCardNumber  |  pin  |
            | <giftCardNumber>  | <pin> |
        Then  I expect error "No Card Found. Please re-enter your card number and PIN number. If you require additional assistance, please call Customer Service at 800.231.1773."
        
        Examples:
        |giftCardNumber     | pin|
        |6006493887999902220|1980|
    
     Scenario Outline: RH Gift Card Balance Check with Inactive card
        Given I am on gift card balance inquiry page
        When  I enter following gift card details in the fields:
            | giftCardNumber  |  pin  |
            | <giftCardNumber>| <pin> |
        Then  I expect error "This card has not been activated, please call the number on the back of the card."
        
    Examples:
    |   giftCardNumber  | pin|
    |6006493887999902220|1980|
    
    Scenario Outline: RH Gift Card Balance Check with Invalid card number
        Given I am on gift card balance inquiry page
        When  I enter following gift card details in the fields:
        | giftCardNumber  |  pin  |
        | <giftCardNumber>| <pin> |
        Then  I expect error "Invalid card number, please re-enter. If you require additional assistance, please call Customer Service at 800.231.1773."
        
    Examples:
    |   giftCardNumber   | pin|
    |@6006qwerty777|###|
