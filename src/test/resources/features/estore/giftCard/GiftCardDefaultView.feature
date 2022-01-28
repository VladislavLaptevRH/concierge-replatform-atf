@smoke @customerService
Feature:
    As a user
    I want to visit gift card balance page.

Scenario Outline: Gift card balance inquiry page returns card balances when valid card details are entered
        Given I am on gift card balance inquiry page
        When  I enter following gift card details in the fields:
            | giftCardNumber  |  pin  |
            | <giftCardNumber>| <pin> |
        Then  I see gift card balance and usage details

    Examples:
    |giftCardNumber     | pin|
    |6006493887999902120|3612|
    |6006493887999902138|4345|
    |6006493887999902146|8422|
