@estoreRegression
Feature: Estore E2E flow

  Scenario: Verify that user is able to buy item for estore
    Given I log into eStore as "regular"
    When I clicks on a random estore menu item
    When I click on estore collections item
    When I clicks on estore random item
    When I select estore debth option
    When I select estore fabric option
    When I select estore length option
    When I select estore color option
    When I click on add to cart estore button
    When I click on aggree&add estore button
    And I click on view cart estore button
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I execute payment with credit card on estore
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed