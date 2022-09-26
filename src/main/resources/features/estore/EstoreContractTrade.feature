@estoreRegression
Feature: eStore Contract and Trade

  Scenario: eStore Contract Login
    Given I log into eStore as contract
    Then I verify that contract paragraph is displayed
    And I verify that logout from contract user is displayed

  Scenario: eStore Contract - Price in the cart - RH
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I open direct product page on estore
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that contract price is used in cart

  Scenario: eStore Contract - Price on increasing the QTY in the cart
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I open direct product page on estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I choose qty for item from estore cart
    Then I verify that the price get increased in multiple of QTY

  Scenario: eStore Contract - Validate the currency for US Zip
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I open direct product page on estore
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that price for product&line should be in US dollars

  Scenario: eStore Contract - Validate the currency for CAN Zip
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I open direct product page on estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I introduces CAN zip code for estore cart
    When I click on confirm button from pop up zip code
    Then I verify that current currency is canadian dollar

  Scenario: eStore Contract - Validate the dropdown's are enabled
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I click on bed
    When I click on beds
    Then I verify that the dropdown's are enabled

  Scenario: eStore Contract - Price in the cart - MO
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I go to MO brand
    When I go to estore item "17050042 WHT" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that contract price is used for each product

  Scenario: eStore Contract - Price in the cart - B&C
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I go to B&C brand
    When I go to estore item "17050042 WHT" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that contract price is used for each B&C product

  Scenario: eStore Contract - Price in the cart - TN
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I go to TN brand
    When I go to estore item "17050042 WHT" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that contract price is used for each TN product

  Scenario: eStore Contract - Verify RHCC payment option for Contract user
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I go to estore item "17050042 WHT" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    When I click on same as estore shipping address checkbox
    When I continue to estore payment after address page
    When I pay with RHCC for estore item
    When I click on continue payment method estore button
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

#Trade
  Scenario: eStore Trade Login
    Given I log into eStore as trade
    Then I verify that trade paragraph is displayed
    And I verify that logout from trade user is displayed

  Scenario: eStore Trade - Price in the cart - RH
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I go to estore item "17050042 WHT" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that trade price is used in cart

  Scenario: eStore Trade - Price on increasing the QTY in the cart
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I go to estore item "17050042 WHT" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    When I choose qty for item from estore cart
    Then I verify that the price for trade get increased in multiple of QTY

  Scenario: eStore Trade - Validate the currency for US Zip
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I go to estore item "17050042 WHT" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that price for product&line should be in US dollars

  Scenario: eStore Trade - Validate the currency for CAN Zip
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I go to estore item "17050042 WHT" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    When I introduces CAN zip code for estore cart
    Then I verify that current currency is canadian dollar

  Scenario: eStore Trade - Validate the dropdown's are enabled
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I click on bed
    When I click on beds
    Then I verify that the dropdown's are enabled

  Scenario: eStore Trade - Price in the cart - MO
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I go to MO brand
    When I go to estore item "17050042 WHT" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that trade price is used for each product

  Scenario: eStore Trade - Price in the cart - B&C
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I go to B&C brand
    When I go to estore item "17050042 WHT" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that trade price is used for each B&C product

  Scenario: eStore Trade - Price in the cart - TN
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I go to TN brand
    When I go to estore item "17050042 WHT" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that trade price is used for each TN product









