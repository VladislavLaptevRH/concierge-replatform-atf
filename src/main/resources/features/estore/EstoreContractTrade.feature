

Feature: eStore Contract and Trade

  @estoreParallelTestRun
  Scenario: eStore Contract Login
    Given I log into eStore as contract
    When I choose country for eStore from footer
    Then I verify that contract paragraph is displayed
    And I verify that logout from contract user is displayed

  @estoreTestRun
  Scenario: eStore Contract - Price in the cart - RH
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I add item to cart via API for estore
    When I open estore cart
    Then I verify that contract price is used in cart

  @estoreTestRun
  Scenario: eStore Contract - Price on increasing the QTY in the cart
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I choose qty for item from estore cart
    Then I verify that the price get increased in multiple of QTY

  @estoreParallelTestRun
  Scenario: eStore Contract - Validate the currency for US-Zip on PDP
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I open product page with "prod2020027" and "17050043" with "INDG" for estore
    When I update "US" postal code on pdp page
    Then I verify that price for product&line should be in US dollars on PDP page

  @estoreParallelTestRun
  Scenario: eStore Contract - Validate the currency for CAN-Zip on PDP
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I open product page with "prod2020027" and "17050043" with "INDG" for estore
    When I update "CAN" postal code on pdp page
    Then I verify that price for product&line should be in US dollars on PDP page

  @estoreTestRun
  Scenario: eStore Contract - Validate the currency for US-Zip in cart
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I update "US" postal code on cart page
    Then I verify that currency should be in US dollar

  @estoreTestRun
  Scenario: eStore Contract - Validate the currency for CAN-Zip in cart
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I update "CA" postal code on cart page
    Then I verify that currency should be in US dollar

  @estoreParallelTestRun
  Scenario: eStore Contract - Validate the dropdown's are enabled
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I click on bed
    When I click on beds
    Then I verify that the dropdown's are enabled

  @estoreTestRun
  Scenario: eStore Contract - Shipping is different from billing
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address
    When I click on edit estore billing address button
    When I fill estore billing address
    When I click on continue to payment estore button

  @estoreTestRun
  Scenario: eStore Contract - Price in the cart - MO
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I go to "MO" brand
    When I go to estore item "17050045 NCKL" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that "contract" price is used for each "MO" product

  @estoreTestRun
  Scenario: eStore Contract - Price in the cart - B&C
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I go to "B&C" brand
    When I go to estore item "17050045 NCKL" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that "contract" price is used for each "B&C" product

  @estoreTestRun
  Scenario: eStore Contract - Price in the cart - TN
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I go to "TN" brand
    When I go to estore item "17050045 NCKL" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that "contract" price is used for each "TN" product

  @estoreTestRun
  Scenario: eStore Contract - Split Payment
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address for contract&trade
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove split payment which was used earlier
    Then I verify that I'm able to execute estore split payment

  @estoreTestRun
  Scenario: estore Contract - RHCC
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address for contract&trade
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I pay with RHCC for estore item
    When I click on estore continue button
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

  @estoreTestRun
  Scenario: estore Contract - GC/ Balance check
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address for contract&trade
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I choose "RH Gift Card" from payment method
    When I click on check balance button
    Then I verify that gift card balance info is displayed for estore

  @estoreTestRun
  Scenario: eStore Contract - Edit Payment
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address for contract&trade
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    Then I verify that I'm able to edit payment

  @estoreTestRun
  Scenario: eStore Contract - Verify UFD for different zip codes
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add product "prod7571021" and sku "63130001 NATL" to cart via API for estore
    When I open estore cart
    When I click on zipcode estore button
    When I update postal code in cart
    Then I verify UFD in cart

  @estoreTestRun
  Scenario Outline: eStore Contract - Verify different payment types on payment page
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address for contract&trade
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

  @estoreTestRun
  Scenario: eStore Contract - Verify RHCC payment option for Contract user
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I click on estore checkout button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address for contract&trade
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I pay with RHCC for estore item
    When I click on continue payment method estore button

  @estoreTestRun
  Scenario: estore Contract - Full Payment
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address for contract&trade
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore

  @estoreTestRun
  Scenario: estore Contract - Checkout and place order
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
#    When I open product page with "prod2020027" and "17050042" with "SND" for estore
#    When I click on add to cart estore button
#    And I click on view cart estore button
    When I open estore cart
    When I click on estore checkout button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address for contract&trade
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

  @estoreTestRun
  Scenario: estore Contract - Edit address
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address for contract&trade
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I click on edit estore billing address button on payment page
    When I edit estore billing address from PG

  @estoreTestRun
  Scenario: eStore Contract - Verify the subtotal, shipping fee, taxes based on postal code
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I update "CA" postal code on cart page
    Then I verify the subtotal, shipping fee, taxes based on postal code

  @estoreTestRun
  Scenario Outline: eStore Contract - Major CC
    Given I log into eStore as contract
    When I choose country for eStore from footer
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

  @estoreTestRun
  Scenario: eStore Contract - Verify the subtotal, shipping fee, taxes based on postal code
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I update "CA" postal code on cart page
    Then I verify the subtotal, shipping fee, taxes based on postal code

#Trade
  @estoreParallelTestRun
  Scenario: eStore Trade Login
    Given I log into eStore as trade
    When I choose country for eStore from footer
    Then I verify that trade paragraph is displayed
    And I verify that logout from trade user is displayed

  @estoreParallelTestRun
  Scenario: eStore Trade - Validate the currency for US-Zip on PDP
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I open product page with "prod2020027" and "17050043" with "INDG" for estore
    When I update "US" postal code on pdp page
    Then I verify that price for product&line should be in US dollars on PDP page

  @estoreParallelTestRun
  Scenario: eStore Trade - Validate the currency for CAN-Zip on PDP
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I open product page with "prod2020027" and "17050043" with "INDG" for estore
    When I update "CAN" postal code on pdp page
    Then I verify that price for product&line should be in US dollars on PDP page

  @estoreTestRun
  Scenario: eStore Trade - Validate the currency for CAN-Zip in cart
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I update "CA" postal code on cart page
    Then I verify that currency should be in US dollar

  @estoreTestRun
  Scenario: eStore Trade - Validate the currency for US-Zip in cart
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I update "US" postal code on cart page
    Then I verify that currency should be in US dollar

  @estoreTestRun
  Scenario: eStore Trade - Price in the cart - RH
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    Then I verify that trade price is used in cart

  @estoreTestRun
  Scenario: eStore Trade - Price on increasing the QTY in the cart
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I choose qty for item from estore cart
    Then I verify that the price for trade get increased in multiple of QTY

  @estoreTestRun
  Scenario: eStore Trade - Validate the dropdown's are enabled
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I click on bed
    When I click on beds
    Then I verify that the dropdown's are enabled

  @estoreTestRun
  Scenario: eStore Trade - Split Payment
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address for contract&trade
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove split payment which was used earlier
    Then I verify that I'm able to execute estore split payment

  @estoreTestRun
  Scenario: estore Trade - Full Payment
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout butto
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore

  @estoreTestRun
  Scenario: estore Trade - RHCC
    Given I log into eStore as trade
    When I choose country for eStore from footer
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
    When I pay with RHCC for estore item
    When I click on estore continue button
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

  @estoreTestRun
  Scenario: estore Trade - GC/ Balance check
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address for contract&trade
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I choose "RH Gift Card" from payment method
    When I click on check balance button
    Then I verify that gift card balance info is displayed for estore

  @estoreTestRun
  Scenario: eStore Trade - Edit Payment
    Given I log into eStore as trade
    When I choose country for eStore from footer
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
    Then I verify that I'm able to edit payment

  @estoreTestRun
  Scenario Outline: estore Trade - Major CC
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address
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

  @estoreTestRun
  Scenario: estore Trade - Checkout and place order
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod2020027" and "17050042" with "WHEA" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

  @estoreTestRun
  Scenario: eStore Trade - Verify UFD for different zip codes
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add product "prod7571021" and sku "63130001 NATL" to cart via API for estore
    When I open estore cart
    When I click on zipcode estore button
    When I update postal code in cart
    Then I verify UFD in cart

  @estoreTestRun
  Scenario: Change zip code in cart to US, currency should be in US$
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button

  @estoreTestRun
  Scenario: estore Trade - Edit address
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I stop eStore page load
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
    When I click on edit estore billing address button on payment page
    When I edit estore billing address from PG
    When I click on continue to payment estore button
    When I click on continue with original address estore button

  @estoreTestRun
  Scenario: eStore Trade - Price in the cart - MO
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I go to "MO" brand
    When I go to estore item "17050043 MIST" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that "trade" price is used for each "MO" product

  @estoreTestRun
  Scenario: eStore Trade - Price in the cart - B&C
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I go to "B&C" brand
    When I go to estore item "17050042 WHT" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that "trade" price is used for each "B&C" product

  @estoreTestRun
  Scenario: eStore Trade - Price in the cart - TN
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I go to "TN" brand
    When I go to estore item "17050042 WHT" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that "trade" price is used for each "TN" product

  @estoreTestRun
  Scenario: eStore Trade - Shipping is different from billing
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address for contract&trade
    When I click on edit estore billing address button
    When I fill estore billing address
    When I click on continue to payment estore button

  @estoreTestRun
  Scenario: eStore Trade - Verify the subtotal, shipping fee, taxes based on postal code
    Given I log into eStore as trade
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    Then I verify the subtotal, shipping fee, taxes based on postal code