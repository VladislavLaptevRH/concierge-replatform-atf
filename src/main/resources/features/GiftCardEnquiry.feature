@conciergeRegression
Feature:GiftCardEnquiry

  Scenario: Gift Card Balance Enquiry
    Given I log into Concierge as "associate"
    When I click on gift card enquiry
    When I enter gift card information
    Then I verify transaction details


  Scenario: Purchase Gift Card
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I remove client from header
    When I click on gift card enquiry
    When I enter gift card information
    Then I verify transaction details
    When I click on purchase gift card
    Then I verify gift card PDP page is loaded
    When I select options
    When I click on add to cart button
    When I click on agree and add to cart button
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    When I click on no thanks button
    When I choose client who is a "nonmember"
    When I fill all fields from address screen
    When I continue to payment
    When I choose POP for payment method
    And I verify that review screen is displayed
    When I click on a place order button
    Then I verify that confirmation order screen is displayed


