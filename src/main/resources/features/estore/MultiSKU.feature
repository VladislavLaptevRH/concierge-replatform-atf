@estoreTestRun

Feature: MultiSKU

  Scenario: Verifiy the multisku ID is showing up once the line item is configured and add to cart button is enabled
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I remove all items from estore cart
    When I open product page with "prod12300102" and "m000001198111" for estore
    Then I verify the multisku ID is showing up once the line item is configured
    And I verify that add to cart button is active

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

  Scenario: Verify the interim copy "This item includes multiple components. Individual components will be listed in your cart" should show up above the lien item dropdowns and below the line item title
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I remove all items from estore cart
    When I open product page with "prod12300102" and "m000001198111" for estore
    Then I verify that "This item includes multiple components. Individual components will be listed in your cart" message is displayed "above" the lien item dropdown
    Then I verify that "This item includes multiple components. Individual components will be listed in your cart" message is displayed "bellow" the lien item dropdown

  Scenario: Verify the message Product Name should be shown on cart against every component of MultiSKU
    Given I log into eStore as "regular" user
    When I choose country for concierge from footer
    When I remove all items from estore cart
    When I open product page with "prod12300102" and "m000001198111" for estore
    When I click on add to cart estore button
    When I click on aggree&add estore button
    When I click on view cart estore button
    Then I verify the message "This is a component of the ORIGINAL LANCASTER THREE-SEAT-CUSHION LEFT-ARM L-SECTIONAL" should be shown on cart against every component of multisku

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
