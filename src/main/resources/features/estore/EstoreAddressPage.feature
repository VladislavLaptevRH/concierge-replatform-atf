@estoreRegression
@estoreAddressPage
Feature: Estore Address Page

  Scenario: eStore Address for Guest user
    Given I log into eStore as "guest" user
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050045" with "WHT" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    When I click on estore no thanks button
    When I click on continue as guest estore button
    When I fill estore shipping address
    When I fill estore shipping email address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    Then I validate "billing address" which we have entered earlier
    When I pay with RHCC for estore item
    Then I validate "billing address" which we have entered earlier

#  Scenario: eStore Address for Registered user - To verify Add a new shipping Address option is present
#    Given I log into eStore as "savedaddress" user
#    When I remove all items from estore cart
#    When I add item to cart via API for estore
#    When I open estore cart
#    When I click on estore checkout button
#    When I click on estore no thanks button
#    Then I verify add a new shipping address option is present
#
#  Scenario: eStore Address Page - To verify Add address button
#    Given I log into eStore as "addresspage" user
#    When I goes to my account for estore
#    When I click on estore my account button
#    When I click on address book estore button
#    Then I verify that add address button is displayed
#
#  Scenario: eStore Address Page - To verify mandatory field in New address
#    Given I log into eStore as "addresspage" user
#    When I goes to my account for estore
#    When I click on estore my account button
#    When I click on address book estore button
#    When I click on add address button
#    When I click on save address button
#    Then I verify that error messages are displayed for each mandatory field

  Scenario: eStore Address Page - To verify newly added address is present in shipping address list
    Given I log into eStore as "addresspage" user
    When I goes to my account for estore
    When I click on estore my account button
    When I click on address book estore button
    When I remove added address before for address book
    When I click on add address button
    When I introduce data for new profile address
    When I click on save address button
    When I click on continue with original address estore button
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on estore no thanks button
    Then I verify that added address displayed as shipping address
    When I delete the first shipping address on address estore page
    When I click on delete address button from appeared pop up

  Scenario: eStore Address Page - To verify the deleted address removed from the shipping address list
    Given I log into eStore as "addresspage" user
    When I remove all items from estore cart
    When I goes to my account for estore
#    When I click on estore my account button
    When I click on estore my account button
    When I click on address book estore button
    When I remove added address before for address book
    When I click on add address button
    When I introduce data for new profile address
    When I click on save address button
    When I click on continue with original address estore button
    When I remove added address before for address book
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on estore no thanks button
    Then I verify that added address is not present in the grid

  Scenario: eStore Address Page - To verify the edited address updated in the shipping address list
    Given I log into eStore as "addresspage" user
    When I remove all items from estore cart
    When I goes to my account for estore
    When I click on estore my account button
    When I click on address book estore button
    When I remove added address before for address book
    When I click on add address button
    When I introduce data for new profile address
    When I click on save address button
    When I click on continue with original address estore button
    When I edit existing address on address book page
    When I click on save address button
    When I click on continue with original address estore button
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on estore no thanks button
    Then I verify that added address is displayed in the shipping address list

  Scenario: eStore Address Page - Verify the scenario when saved address has missing required address fields - Missing phone number etc
    Given I log into eStore as "addresspage" user
    When I remove all items from estore cart
    When I goes to my account for estore
    When I click on estore my account button
    When I click on address book estore button
    When I remove added address before for address book
    When I click on add address button
    When I introduce data for new profile address without phone number
    When I click on save address button
    Then user verify that field is required message is displayed

  Scenario: eStore Address Page - Verify same as Billing address same as Shipping functionality - switch between the listed shipping addresses
    Given I log into eStore as "addresspage" user
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on estore no thanks button
    When I click on edit shipping address button on estore address page
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    Then I verify that billing address the same as shipping functionality

  Scenario: eStore Address Page - Verify the shipping and Billing address for registered User Order review and Order Confirmation page
    Given I log into eStore as "addresspage" user
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    Then I verify shipping and billing address on order review page
    When I click on a place estore order button
    When I click on order details button
    Then I verify shipping and billing address on order confirmation page

  Scenario: eStore Address Page - Verify Gift message and order description showing on the order review and TY page
    Given I log into eStore as "addresspage" user
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on estore checkout button
    When I click on estore no thanks button
    When I fill estore shipping address
    When I click on edit estore billing address button
    When I click on same as estore shipping address checkbox
    When I add gift message
    When I click on continue to payment estore button