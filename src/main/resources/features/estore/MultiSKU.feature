
Feature: MultiSKU

  @estoreParallelTestRun
  Scenario: Verifiy the multisku ID is showing up once the line item is configured and add to cart button is enabled
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I open product page with "prod12300102" and "m000001198111" for estore
    Then I verify the multisku ID is showing up once the line item is configured
    And I verify that add to cart button is active

  @estoreParallelTestRun
  Scenario: Verify the multisku id  is getting displayed
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I remove all items from estore cart
    When I open product page with "prod12300102" and "m000001198111" for estore
    Then I verify the multisku ID is showing up once the line item is configured

  @estoreTestRun
  Scenario: Verify that the ETA on PDP and cart are matching or should match with the latest ETA of the bundle components on cart page
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I remove all items from estore cart
    When I open product page with "prod12300102" and "m000001198111" for estore
    Then I verify that the ETA on PDP
    When I click on add to cart estore button
    When I click on aggree&add estore button
    When I click on view cart estore button
    Then I verify that the ETA on PDP and cart are matching

  @estoreParallelTestRun
  Scenario: Verify the interim copy "This item includes multiple components.Individual components will be listed in your cart" should show up above the line item dropdowns and below the line item title
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I open product page with "prod12300102" and "m000001198111" for estore
    Then I verify that "This item includes multiple components. Individual components will be listed in your cart" message is displayed "above" the line item dropdown

  @estoreTestRun
  Scenario: Verify the message "This is a component of the ORIGINAL LANCASTER THREE-SEAT-CUSHION LEFT-ARM L-SECTIONAL" should be shown on cart against every component of multisku
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I remove all items from estore cart
    When I open product page with "prod12300102" and "m000001198111" for estore
    When I click on add to cart estore button
    When I click on aggree&add estore button
    When I click on view cart estore button
    Then I verify the message "This is a component of the ORIGINAL LANCASTER THREE-SEAT-CUSHION LEFT-ARM L-SECTIONAL" should be shown on cart against every component of multisku

  @estoreTestRun
  Scenario: Verfiy user is able to place order with MultiSKU
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I remove all items from estore cart
    When I open product page with "prod12300102" and "m000001198111" for estore
    When I click on add to cart estore button
    When I click on aggree&add estore button
    When I click on view cart estore button
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

  @estoreTestRun
  Scenario: Verify the quantity added in PDP is matching with the quantity added on cart page
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I remove all items from estore cart
    When I open product page with "prod12300102" and "m000001198111" for estore
    When I update item quantity in estore pdp
    When I click on add to cart estore button
    When I click on aggree&add estore button
    When I click on view cart estore button
    Then that was added "2" quantity of item in cart

  @estoreParallelTestRun
  Scenario: Verify the configurations after changing the quantity
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I open product page with "prod12300102" and "m000001198111" for estore
    When I select estore debth option
    Then I verify that sku id is equal to "m000001196925" on estore PDP
    When I update item quantity in estore pdp
    Then I verify that sku id is equal to "m000001196925" on estore PDP

  @estoreTestRun
  Scenario: Verify that the above message is showing up on order review page
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I remove all items from estore cart
    When I open product page with "prod12300102" and "m000001198111" for estore
    When I click on add to cart estore button
    When I click on aggree&add estore button
    When I click on view cart estore button
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    Then I verify the message "This is a component of the ORIGINAL LANCASTER THREE-SEAT-CUSHION LEFT-ARM L-SECTIONAL" should be shown on "order review" page

  @estoreTestRun
  Scenario: Verify that the above message is showing up on Thank you page
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I remove all items from estore cart
    When I open product page with "prod12300102" and "m000001198111" for estore
    When I click on add to cart estore button
    When I click on aggree&add estore button
    When I click on view cart estore button
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    When I click on a place estore order button
    When I click on estore order details button
    Then I verify the message "This is a component of the ORIGINAL LANCASTER THREE-SEAT-CUSHION LEFT-ARM L-SECTIONAL" should be shown on "thank you" page

  @estoreTestRun
  Scenario: Verify the message that indicates it is part of the main product on cart page against every indiviual component of multisku
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I remove all items from estore cart
    When I open product page with "prod12300102" and "m000001198111" for estore
    When I click on add to cart estore button
    When I click on aggree&add estore button
    When I click on view cart estore button
    Then I verify the message "This is a component of the ORIGINAL LANCASTER THREE-SEAT-CUSHION LEFT-ARM L-SECTIONAL" should be shown on "cart" page

  @estoreParallelTestRun
  Scenario: Verfiy the multisku line item is configurable
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I open product page with productID "prod12300102" for estore
    When I select estore debth option
    When I select estore fill option
    When I select estore color option
    When I select armless sofa option
    When I select estore fabric option
    Then I verify that add to cart button is active

  @estoreParallelTestRun
  Scenario: Verify the multisku line item is showing all the ETA and return messages after line item is configured
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I open product page with "prod12300102" and "m000001198111" for estore
    When I select item option for line item
    When I select color option for line item
    When I select fabric option for line item
    Then I verify the multisku line item is showing all the ETA and return messages after line item is configured

  @estoreParallelTestRun
  Scenario: Verify the "Interim copy" for multisku is showing up at line item once the item is configured in all devices
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I open product page with productID "prod12300102" for estore
    When I select estore debth option
    When I select estore fill option
    When I select estore color option
    When I select armless sofa option
    When I select estore fabric option
    Then I verify that "This item includes multiple components. Individual components will be listed in your cart" message is displayed "above" the line item dropdown

  @estoreParallelTestRun
  Scenario: Verify that SPO panel is triggered with all the details in it when a dropship multisku is added to cart
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I open product page with "prod12300102" and "m000001198111" for estore
    When I click on add to cart estore button
    Then I verify that SPO panel is triggered with all the details for all the dropsku multiskus

  @estoreTestRun
  Scenario: Verify that all the components of the bundle are added to cart
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I remove all items from estore cart
    When I open product page with "prod12300102" and "m000001198111" for estore
    When I click on add to cart estore button
    When I click on aggree&add estore button
    When I click on view cart estore button
    Then I verify that all the components of the bundle are added to cart


