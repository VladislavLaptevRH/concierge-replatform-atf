@estoreRegression
@estoreContractTradePage
Feature: eStore Contract and Trade

  Scenario: eStore Contract Login
    Given I log into eStore as contract
    Then I verify that contract paragraph is displayed
    And I verify that logout from contract user is displayed

  Scenario: eStore Contract - Price in the cart - RH
    Given I log into eStore as contract
    When I add item to cart via API for estore
    When I open estore cart
    Then I verify that contract price is used in cart

  Scenario: eStore Contract - Price on increasing the QTY in the cart
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I choose qty for item from estore cart
    Then I verify that the price get increased in multiple of QTY

  Scenario: eStore Contract - Validate the currency for US Zip
    Given I log into eStore as contract
    When I add item to cart via API for estore
    When I open estore cart
    Then I verify that price for product&line should be in US dollars

  Scenario: eStore Contract - Validate the currency for CAN Zip
    Given I log into eStore as "noaddresses" user
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I update shipping address for CAN
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
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
#    When I go to MO brand
#    When I go to estore item "17050042 WHT" from search field
#    When I click on add to cart estore button
#    And I click on view cart estore button
#    Then I verify that contract price is used for each product

  Scenario: eStore Contract - Price in the cart - B&C
    Given I log into eStore as contract
    When I remove all items from estore cart
#    When I go to B&C brand
#    When I go to estore item "17050042 WHT" from search field
#    When I click on add to cart estore button
#    And I click on view cart estore button
#    Then I verify that contract price is used for each B&C product

  Scenario: eStore Contract - Price in the cart - TN
    Given I log into eStore as contract
    When I remove all items from estore cart
#    When I go to TN brand
#    When I go to estore item "17050042 WHT" from search field
#    When I click on add to cart estore button
#    And I click on view cart estore button
#    Then I verify that contract price is used for each TN product

  Scenario: eStore Contract - Verify RHCC payment option for Contract user with editing

    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I click on estore checkout button
    When I click on edit estore billing address button
    When I fill all fields from address screen
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I pay with RHCC for estore item
    When I click on continue payment method estore button

  Scenario: eStore Contract - Split Payment
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on edit estore billing address button
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove split payment which was used earlier
    When I refresh current estore page
    Then I verify that I'm able to execute estore split payment

  Scenario: estore Contract - Full Payment

    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on edit estore billing address button
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore

  Scenario: estore Contract - RHCC
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I pay with RHCC for estore item
    When I click on estore continue button
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

  Scenario: estore Contract - GC/ Balance check
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on edit estore billing address button
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I choose "RH Gift Card" from payment method
    When I click on check balance button
    Then I verify that gift card balance info is displayed for estore

  Scenario: eStore Contract - Edit Payment
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on edit estore billing address button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    Then I verify that I'm able to edit payment

  Scenario: estore Contract - Checkout and place order
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050045" with "WHT" for estore

  Scenario: eStore Contract Login
    Given I log into eStore as contract
    Then I verify that contract paragraph is displayed
    And I verify that logout from contract user is displayed

  Scenario: eStore Contract - Price in the cart - RH
    Given I log into eStore as contract
    When I add item to cart via API for estore
    When I open estore cart
    Then I verify that contract price is used in cart

  Scenario: eStore Contract - Price on increasing the QTY in the cart
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I choose qty for item from estore cart
    Then I verify that the price get increased in multiple of QTY

  Scenario: eStore Contract - Validate the currency for US Zip
    Given I log into eStore as contract
    When I add item to cart via API for estore
    When I open estore cart
    Then I verify that price for product&line should be in US dollars

  Scenario: eStore Contract - Validate the currency for CAN Zip
    Given I log into eStore as "noaddresses" user
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I update shipping address for CAN
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
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
#    When I go to MO brand
#    When I go to estore item "17050042 WHT" from search field
#    When I click on add to cart estore button
#    And I click on view cart estore button
#    When I click on estore checkout button
#    And I click on estore no thanks button
#    When I fill estore shipping address
#    When I click on same as estore shipping address checkbox
#    When I click on continue to payment estore button
#    When I click on continue with original address estore button
#    When I remove payment method which was used earlier
#    When I execute payment with credit card on estore
#    When I click on a place estore order button
#    Then I verify that estore thank you page is displayed

  Scenario: eStore Contract - Verify UFD for different zip codes
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add product "prod1617188" and sku "63130001 NATL" to cart via API for estore
    When I open estore cart
    When I click on zipcode estore button
    When I update postal code in cart
    Then I verify UFD in cart

  Scenario: Change zip code  in cart to US, currency should be in US$
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050045" with "WHT" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    And I click on estore no thanks button

  Scenario Outline: Verify different payment types on payment page
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute estore payment for "<cardType>"
    When I click on a place estore order button
    Examples:
      | cardType |
      | VI       |
      | MC       |
      | AX       |
      | DI       |


  Scenario: Change zip code  in cart to CAN, currency should be in US$
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050045" with "WHT" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    And I click on estore no thanks button
    Then I verify that contract price is used for each TN product

  Scenario: eStore Contract - Verify RHCC payment option for Contract user
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I click on estore checkout button
    When I fill all fields from address screen
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I pay with RHCC for estore item
    When I click on continue payment method estore button

  Scenario: eStore Contract - Split Payment
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove split payment which was used earlier
    When I refresh current estore page
    Then I verify that I'm able to execute estore split payment

  Scenario: estore Contract - Full Payment
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore

  Scenario: estore Contract - RHCC
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I pay with RHCC for estore item
    When I click on estore continue button
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

  Scenario: estore Contract - GC/ Balance check
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I choose "RH Gift Card" from payment method
    When I click on check balance button
    Then I verify that gift card balance info is displayed for estore

  Scenario: eStore Contract - Edit Payment
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    Then I verify that I'm able to edit payment

  Scenario: estore Contract - Checkout and place order
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050045" with "WHT" for estore
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

  Scenario: eStore Contract - Verify UFD for different zip codes
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add product "prod1617188" and sku "63130001 NATL" to cart via API for estore
    When I open estore cart
    When I click on zipcode estore button
    When I update postal code in cart
    Then I verify UFD in cart

  Scenario: Change zip code  in cart to US, currency should be in US$
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050045" with "WHT" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    And I click on estore no thanks button

  Scenario Outline: Verify different payment types on payment page
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute estore payment for "<cardType>"
    When I click on a place estore order button
    Examples:
      | cardType |
      | VI       |
      | MC       |
      | AX       |
      | DI       |


  Scenario: Change zip code  in cart to CAN, currency should be in US$
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050045" with "WHT" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    And I click on estore no thanks button

  Scenario: estore Contract - Edit address
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I edit estore billing address from PG
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    Then I see new Billing address

  Scenario: estore Contract - Edit address
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I edit estore billing address from PG
    When I click on continue to payment estore button
    When I click on continue with original address estore button

  Scenario Outline: eStore Contract - Major CC
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute estore payment for "<cardType>"
    When I click on a place estore order button
    Examples:
      | cardType |
      | VI       |
      | MC       |
      | AX       |
      | DI       |

  Scenario: eStore Contract - Validate the currency for US Zip in cart
    Given I log into eStore as contract
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart

#Trade
  Scenario: eStore Trade Login
    Given I log into eStore as trade
    Then I verify that trade paragraph is displayed
    And I verify that logout from trade user is displayed

  Scenario: eStore Trade - Price in the cart - RH
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    Then I verify that trade price is used in cart

  Scenario: eStore Trade - Price on increasing the QTY in the cart
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I choose qty for item from estore cart
    Then I verify that the price for trade get increased in multiple of QTY

  Scenario: eStore Trade - Validate the currency for US Zip
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    Then I verify that price for product&line should be in US dollars

  Scenario: eStore Trade - Validate the currency for CAN Zip

    Given I log into eStore as trade
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I introduces CAN zip code for estore cart
    When I click on confirm button from pop up zip code
    Then I verify that current currency is canadian dollar

  Scenario: eStore Trade - Validate the dropdown's are enabled
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I click on bed
    When I click on beds
    Then I verify that the dropdown's are enabled

  Scenario: eStore Trade - Split Payment
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove split payment which was used earlier
    When I refresh current estore page
    Then I verify that I'm able to execute estore split payment

  Scenario: estore Trade - Full Payment
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore

  Scenario: estore Trade - RHCC
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I pay with RHCC for estore item
    When I click on estore continue button
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

  Scenario: estore Trade - GC/ Balance check
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I choose "RH Gift Card" from payment method
    When I click on check balance button
    Then I verify that gift card balance info is displayed for estore

  Scenario: eStore Trade - Edit Payment
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    Then I verify that I'm able to edit payment

  Scenario Outline: estore Trade - Major CC
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute estore payment for "<cardType>"
    When I click on a place estore order button
    Examples:
      | cardType |
      | VI       |
      | MC       |
      | AX       |
      | DI       |

  Scenario: estore Trade - Checkout and place order
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050045" with "WHT" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on edit estore billing address button
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

  Scenario: eStore Trade - Verify UFD for different zip codes
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I add product "prod1617188" and sku "63130001 NATL" to cart via API for estore
    When I open estore cart
    When I click on zipcode estore button
    When I update postal code in cart
    Then I verify UFD in cart

  Scenario: Change zip code in cart to US, currency should be in US$
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050045" with "WHT" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    And I click on estore no thanks button

  Scenario: Change zip code in cart to CAN, currency should be in US$
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050045" with "WHT" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    And I click on estore no thanks button

  Scenario: estore Trade - Edit address
    Given I log into eStore as trade
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on edit estore billing address button
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I click on edit estore billing address button
    When I edit estore billing address from PG
    When I click on continue to payment estore button
    When I click on continue with original address estore button

  Scenario: eStore Trade - Price in the cart - MO
    Given I log into eStore as trade
    When I remove all items from estore cart
#    When I go to MO brand
#    When I go to estore item "17050042 WHT" from search field
#    When I click on add to cart estore button
#    And I click on view cart estore button
#    Then I verify that trade price is used for each product

  Scenario: eStore Trade - Price in the cart - B&C
    Given I log into eStore as trade
    When I remove all items from estore cart
#    When I go to B&C brand
#    When I go to estore item "17050042 WHT" from search field
#    When I click on add to cart estore button
#    And I click on view cart estore button
#    Then I verify that trade price is used for each B&C product

  Scenario: eStore Trade - Price in the cart - TN
    Given I log into eStore as trade
#    When I remove all items from estore cart
#    When I go to TN brand
#    When I go to estore item "17050042 WHT" from search field
#    When I click on add to cart estore button
#    And I click on view cart estore button
#    Then I verify that trade price is used for each TN product