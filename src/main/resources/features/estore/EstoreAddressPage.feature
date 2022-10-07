@estoreRegression
@estoreAddressPage
Feature: Estore Address Page

  Scenario: eStore Address for Guest user
    Given I log into eStore as "guest"
    When I remove all items from estore cart
    When I go to estore item "10097379 PYR" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    When I click on estore no thanks button
    When I click on continue as guest estore button
    When I fill estore shipping address
    When I fill estore shipping email address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    Then I validate "billing address" which we have entered earlier
    When I pay with RHCC for estore item
    Then I validate "billing address" which we have entered earlier

  Scenario: eStore Address for Registered user - To verify Add a new shipping Address option is present
    Given I log into eStore as "savedaddress"
    When I remove all items from estore cart
    When I go to estore item "10097379 PYR" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    When I click on estore no thanks button
    Then I verify add a new shipping address option is present

  Scenario: eStore Address Page - To verify Add address button
    Given I log into eStore as "addresspage"
    When I remove all items from estore cart
    When I click on estore my account icon
    When I click on estore profile button
    When I click on estore my account button
    When I click on address book estore button
    Then I verify that add address button is displayed

  Scenario: eStore Address Page - To verify mandatory field in New address
    Given I log into eStore as "addresspage"
    When I remove all items from estore cart
    When I click on estore my account icon
    When I click on estore profile button
    When I click on estore my account button
    When I click on address book estore button
    When I click on add address button
    When I click on save address button
    Then I verify that error messages are displayed for each mandatory field

  Scenario: eStore Address Page - To verify newly added address is present in shipping address list
    Given I log into eStore as "addresspage"
    When I remove all items from estore cart
    When I click on estore my account icon
    When I click on estore profile button
    When I click on estore my account button
    When I click on address book estore button
    When I remove added address before for address book
    When I click on add address button
    When I introduce data for new profile address
    When I click on save address button
    Then I verify that added address present in the grid
    When I go to estore item "10097379 PYR" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    When I click on estore no thanks button
    Then I verify that added address displayed as shipping address
    When I delete the first shipping address on address estore page
    When I click on delete address button from appeared pop up

  Scenario: eStore Address Page - To verify the deleted address removed from the shipping address list
    Given I log into eStore as "addresspage"
    When I remove all items from estore cart
    When I click on estore my account icon
    When I click on estore profile button
    When I click on estore my account button
    When I click on address book estore button
    When I remove added address before for address book
    When I click on add address button
    When I introduce data for new profile address
    When I click on save address button
    Then I verify that added address present in the grid
    When I remove added address before for address book
    When I go to estore item "10097379 PYR" from search field
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    When I click on estore no thanks button
    Then I verify that added address is not present in the grid

  Scenario: eStore Address Page - To verify the edited address updated in the shipping address list
    Given I log into eStore as "addresspage"
    When I remove all items from estore cart
    When I click on estore my account icon
    When I click on estore profile button
    When I click on estore my account button
    When I click on address book estore button
    When I remove added address before for address book
    When I click on add address button
    When I introduce data for new profile address
    When I click on save address button
    When I click on continue payment method estore button
    When I edit existing address on address book page
    When I click on save address button
    When I go to estore item "10097379 PYR" from search field
    When I click on add to cart estore button
    When I click on aggree&add estore button
    And I click on view cart estore button
    When I click on estore checkout button
    When I click on estore no thanks button
    Then I verify that added address is displayed in the shipping address list
#    Then I verify that added address edited address updated in the shipping address list
