@estoreRegression
@estorePayment
Feature:Estore Payment

  Scenario: eStore Split Payment
    Given I log into eStore as "regular"
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

  Scenario: eStore Saved Cards
    Given I log into eStore as "userWithSavedMasterCardVisa"
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
    When I choose saved card "VI" from payment method dropdown
    When I click on estore continue button
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

  Scenario: eStore Edit Payment
    Given I log into eStore as "regular"
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
    Given I log into eStore as "regular"
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
    When I edit estore billing address from PG
    When I click on continue to payment estore button
    When I click on continue with original address estore button

  Scenario: eStore unavailability of RHCC for CAN address
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on edit estore billing address button
    When I fill estore shipping address
    When I update shipping address for CAN
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    Then I verify unavailability for RHCC

  Scenario: eStore RHCC
    Given I log into eStore as "regular"
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
    Given I log into eStore as "regular"
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

  Scenario: eStore Update address (Impacting change) after making payment
    Given I log into eStore as "regular"
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
    Given I log into eStore as "regular"
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
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050045" with "WHT" for estore
    When I update item quantity in estore pdp
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    And I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    And I introduces payment details for estore guest user
    When I open estore cart
    Then I verify that I'm able to decrease item quantity with success
    When I open product page with "prod13800635" and "17050045" with "WHT" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I click on estore continue button
    Then I validate updated order estimate and card details for decrease item

  Scenario: eStore Billing address based on saved payment method
    Given I log into eStore as "userWithSavedMasterCardVisa"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I choose saved card "VI" from payment method dropdown
    When I click on continue payment method estore button
    Then I validate that billing address based on saved payment method

  Scenario: eStore Add new payment method
    Given I log into eStore as "addnewpayment"
    When I go to profile payment method
    When I remove added before cart
    When I add new card for estore
    Then I verify that new payment was added

  Scenario: eStore unavailability of Discover for CAN address
    Given I log into eStore as "regular"
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
    Then I verify unavailability of Discover for CAN address

  Scenario: eStore unavailability of Saved Discover for CAN shipping address
    Given I log into eStore as "savedRhCcDiscover"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on edit estore billing address button
    When I fill estore shipping address
    When I update shipping address for CAN
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    Then I verify that discover is unavailable

  Scenario: eStore unavailability of Saved RHCC for CAN shipping address
    Given I log into eStore as "savedRhCc"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on edit estore billing address button
    When I choose address with CAN zip code
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    Then I verify unavailability of saved for RHCC

  Scenario: eStore Update address (Change Country) after making payment
    Given I log into eStore as "regular"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
#    When I fill estore shipping address
#    When I click on same as estore shipping address checkbox
#    When I click on continue to payment estore button
#    When I click on continue with original address estore button
#    When I refresh current estore page
#    When I remove payment method which was used earlier
#    When I execute payment with credit card on estore
#    When I click on edit shipping address button on estore order review page
#    When I click on edit shipping address button on estore address page
#    When I choose address with CAN zip code
#    When I click on continue to payment estore button
#    Then I verify that current currency is canadian dollar
#    When I remove payment method which was used earlier
#    When I execute payment with credit card on estore
#    When I click on continue payment method estore button
#    When I click on a place estore order button
#    Then I verify that estore thank you page is displayed

  Scenario: eStore masked CC
    Given I log into eStore as "mastercard"
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
    When I choose saved card "MC" from payment method dropdown
    When I click on continue payment method estore button
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

  Scenario: eStore Saved credit cards
    Given I log into eStore as "userWithSavedMasterCardVisa"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    Then I verify that I'm able to execute estore split payment with saved CC

  Scenario: GC/ Balance check
    Given I log into eStore as "mastercard"
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
    When I choose RH Gift Card from payment method
    When I click on check balance button
    Then I verify that gift card balance info is displayed for estore

  Scenario: Verify that user is able to execute payment via GC for USA
    Given I log into eStore as "mastercard"
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
    When I choose RH Gift Card from payment method
    When I click on continue payment method estore button
    When I click on a place estore order button

  Scenario: Verify that user is able to execute payment via GC for CAN
    Given I log into eStore as "savedRhCc"
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    And I click on estore no thanks button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address
    When I update shipping address for CAN
    When I click on edit estore billing address button
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I choose RH Gift Card from payment method
    When I click on continue payment method estore button
    When I click on a place estore order button

  Scenario: Verify the saving AMEX payment method
    Given I log into eStore as "addnewpayment"
    When I go to profile payment method
    When I remove added before cart
    When I added new card "AMEX" for estore
    Then I verify that I'm able to add "AMEX"
    When I remove added before cart

  Scenario: Verify the saving DI payment method
    Given I log into eStore as "addnewpayment"
    When I go to profile payment method
    When I remove added before cart
    When I added new card "DISCOVER" for estore
    Then I verify that I'm able to add "DISCOVER"
    When I remove added before cart









