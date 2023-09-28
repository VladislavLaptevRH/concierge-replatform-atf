
  Scenario: eStore - Gift Box fee in cart
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I open product page with "prod20000465" and "17110459" with "MIST" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I add item to cart via API for estore
    When I open estore cart
    When I click on zipcode estore button
    When I update postal code in cart
    When I click on gift box button
    Then I verify gift box fee in estore cart
