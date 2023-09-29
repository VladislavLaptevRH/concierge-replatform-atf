@estoreTestRun

Feature: Estore E2E flow

  Scenario: Verify that user is able to buy item for estore
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I remove all items from estore cart
    When I open product page with "prod19500002" and "17050045" with "NCKL" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed