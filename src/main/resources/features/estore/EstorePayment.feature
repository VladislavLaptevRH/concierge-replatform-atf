@estoreTestRun
@estorePayment
Feature: Estore Payment

  Scenario: eStore Split Payment
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
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
    Then I verify that I'm able to execute estore split payment

  Scenario: eStore Saved Cards
    Given I log into eStore as "userWithSavedMasterCardVisa" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I choose saved card "VI" from payment method dropdown
    When I click on estore continue button
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

  Scenario: eStore Edit Payment
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
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

  Scenario: eStore Edit Address
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
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
    When I click on edit estore billing address button on payment page
    When I click on continue to payment estore button
    When I click on continue with original address estore button

      #canada issue
  Scenario: eStore unavailability of RHCC for CAN address
    Given I log into eStore as "noaddresses" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I choose "CAN" country from footer
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address for CAN
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    Then I verify unavailability for RHCC

  Scenario: eStore RHCC
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
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
    When I pay with RHCC for estore item
    When I click on estore continue button
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

  Scenario: eStore Update address (Non impacting change) after making payment
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
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
    Then I verify that shipping address is displayed

  Scenario: eStore Update address (Impacting change) after making payment
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
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
    Then I verify that shipping address is displayed
    When I click on a place estore order button
    When I click on estore order details button
    Then I verify that shipping address is displayed


  Scenario: eStore Order total increased after making payment
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
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
    When I open estore cart
    Then I verify that I'm able to increase item quantity with success after payment
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I click on estore continue button
    Then I validate updated order estimate and card details
    When I click on a place estore order button
    Then I verify that confirmation estore order screen is displayed

  Scenario: eStore Order total decreased after making payment
    Given I log into eStore as "userWithSavedMasterCardVisa" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    When I update item quantity in estore pdp
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    And I introduces payment details for estore guest user for payment
    When I open estore cart
    Then I verify that I'm able to decrease item quantity with success
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I click on estore continue button
    Then I validate updated order estimate and card details for decrease item

  Scenario: eStore Billing address based on saved payment method
    Given I log into eStore as "userWithSavedMasterCardVisa" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I choose saved card "VI" from payment method dropdown
    When I click on continue payment method estore button
    Then I validate that billing address based on saved payment method

  Scenario: eStore Add new payment method
    Given I log into eStore as "addnewpayment" user
    When I choose country for eStore from footer
    When I go to profile payment method
    When I remove added before cart
    When I add new card for estore
    Then I verify that new payment was added

      #canada issue
  Scenario: eStore unavailability of Discover for CAN address
    Given I log into eStore as "noaddresses" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I choose "CAN" country from footer
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address for CAN
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    Then I verify unavailability of Discover for CAN address

      #canada issue
  Scenario: eStore unavailability of Saved Discover for CAN shipping address
    Given I log into eStore as "savedRhCcDiscover" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I choose "CAN" country from footer
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address for CAN
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    Then I verify that discover is unavailable

  #canada issue
  Scenario: eStore unavailability of Saved RHCC for CAN shipping address
    Given I log into eStore as "savedRhCc" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I choose "CAN" country from footer
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address for CAN
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    Then I verify unavailability of saved for RHCC

  #canada issue
  Scenario: eStore Update address (Change Country) after making payment
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
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
    When I open estore cart
    When I choose "CAN" country from footer
    When I click on estore checkout button
    When I click on estore no thanks button
#    When I click on edit shipping address button on estore order review page
#    When I click on edit shipping address button on estore address page
    When I fill estore shipping address for CAN
    When I click on same as estore shipping address checkbox
#    When I choose address with CAN zip code
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    Then I verify that current currency is canadian dollar
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

  Scenario: eStore masked CC
    Given I log into eStore as "mastercard" user
    When I choose country for eStore from footer
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
    When I choose saved card "MC" from payment method dropdown
    When I click on continue payment method estore button
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

  Scenario: GC/ Balance check
    Given I log into eStore as "mastercard" user
    When I choose country for eStore from footer
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

  Scenario: Verify that user is able to execute payment via GC for USA
    Given I log into eStore as "mastercard" user
    When I choose country for eStore from footer
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
    When I click on continue payment method estore button
    When I click on a place estore order button

#      canada issue
  Scenario: Verify that user is able to execute payment via GC for CAN
    Given I log into eStore as "savedRhCc" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I choose "CAN" country from footer
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address for CAN
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I choose "RH Gift Card" from payment method
    When I click on continue payment method estore button
    When I click on a place estore order button

  Scenario: Verify the saving AMEX payment method
    Given I log into eStore as "addnewpayment" user
    When I choose country for eStore from footer
    When I go to profile payment method
    When I click on my account button if page is not loaded
    When I remove added before cart
    When I added new card "AMEX" for estore
    Then I verify that I'm able to add "AMEX"
    When I remove added before cart

  Scenario: Verify the saving DI payment method
    Given I log into eStore as "addnewpayment" user
    When I choose country for eStore from footer
    When I go to profile payment method
    When I click on my account button if page is not loaded
    When I remove added before cart
    When I added new card "DISCOVER" for estore
    Then I verify that I'm able to add "DISCOVER"
    When I remove added before cart

  Scenario Outline: eStore - Major CC
    Given I log into eStore as "noaddresses" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on no thanks button
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

  Scenario Outline: eStore - Major CC - CAN
    Given I log into eStore as "noaddresses" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I choose "CAN" country from footer
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address for CAN
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

  Scenario: Verify the billing address updated in payment page based on the saved payment selected
    Given I log into eStore as "mastercard" user
    When I choose country for eStore from footer
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
    Then I verify that on the payment page the same address as for the saved mastercard

  Scenario: Verify that for US ship to all the payment types saved are reflected in payment page
    Given I log into eStore as "savedRhCc" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I choose "CAN" country from footer
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address for CAN
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    Then I verify unavailability of saved for RHCC