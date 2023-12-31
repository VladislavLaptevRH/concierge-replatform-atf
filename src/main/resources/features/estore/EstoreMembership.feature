@estoreTestRun
@estoreMembership
Feature: Estore Membership

  Scenario: eStore Membership
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I goes to my account for estore
    When I click on estore my account icon for guest user
    When I navigate to the member tab
    Then I validate membership title

  Scenario: eStore Membership renewal details
    Given I log into eStore as "member" user
    When I choose country for eStore from footer
    When I goes to my account for estore
    When I click on estore my account icon for guest user
    When I navigate to the member tab
    Then I validate membership details

  Scenario: eStore Membership Add to Cart button
    Given I log into eStore as "nonmember" user
    When I choose country for eStore from footer
    When I goes to my account for estore
    When I click on estore my account icon for guest user
    When I navigate to the member tab
    When I goes to click on cart button from header
    Then I validate cart
    #check member price
    #check RH Members Program

  Scenario: eStore Link to Membership
    Given I log into eStore as "member" user
    When I choose country for eStore from footer
    When I goes to my account for estore
    When I click on estore my account icon for guest user
    When I navigate to the member tab
    Then I validate membership details
    Then I validate email address field and link to membership button

  Scenario: eStore Membership details - Member User
    Given I log into eStore as "member" user
    When I choose country for eStore from footer
    When I goes to my account for estore
    When I click on estore my account icon for guest user
    When I navigate to the member tab
    Then I validate membership details for member user

  Scenario: eStore Cancel Membership
    Given I log into eStore as "cancelMembership" user
    When I choose country for eStore from footer
    When I goes to my account for estore
    When I click on estore my account icon for guest user
    When I navigate to the member tab
    Then I validate membership details for member user
    When I click on cancel membership link
    Then I validate cancel membership content

  Scenario: Verify the membership Terms and Conditions Link
    Given I log into eStore as "member" user
    When I choose country for eStore from footer
    When I goes to my account for estore
    When I click on estore my account icon for guest user
    When I navigate to the member tab
    When I click on terms & condition link
    Then I verify that rh members program terms & condition pop up is displayed

  Scenario: Verify the email address displayed in membership page
    Given I log into eStore as "member" user
    When I choose country for eStore from footer
    When I goes to my account for estore
    When I click on estore my account icon for guest user
    When I navigate to the member tab
    Then I verify that email address displayed in membership page

  Scenario: Verfiy membership FAQa link
    Given I log into eStore as "member" user
    When I choose country for eStore from footer
    When I goes to my account for estore
    When I click on estore my account icon for guest user
    When I navigate to the member tab
    When I click on FAQa link for estore
    Then I verfiy that frequently asked questions page is displayed

  Scenario: Verify the membership page when the membership is canceled
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I goes to my account for estore
    When I click on estore my account icon for guest user
    When I navigate to the member tab
    Then I verify that membership is cancelled

  Scenario: User having membership on cart and navigates to Payment Page - "Save card to account" checkbox should be checked by default
    Given I log into eStore as "buymembership" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I click on remove membership estore button
    When I click on join now membership button
    When I click on estore checkout button
    When I fill estore shipping address
    When I click on edit estore billing address button
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    Then I verify that save card to account checkbox should be checked by defaults
    When I goes to estore cart for estore
    When I click on remove membership estore button

  Scenario: Verify the memberID, enrollment date, renewal date and price, MOP, for a Member User
    Given I log into eStore as "member" user
    When I choose country for eStore from footer
    When I goes to my account for estore
    When I click on my account button if page is not loaded
    When I click on estore my account icon for guest user
    When I navigate to the member tab
    Then I verify that the memberID, enrollment date, renewal date and price, MOP are displayed

  Scenario: Verify the Copy displayed in My Account - Membership page - Non Member
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I goes to my account for estore
    When I click on estore my account icon for guest user
    When I navigate to the member tab
    Then I verify that the copy is displayed for non member user
    And I verify that link to membership functionality is displayed

  Scenario: Verify the membership Program Details Link
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore my account icon for guest user
    When I navigate to the member tab
    Then I verify that membership program details link

  Scenario: Verify cancel membership link
    Given I log into eStore as "member" user
    When I choose country for eStore from footer
    When I click on my account button if page is not loaded
    When I click on estore my account icon for guest user
    When I navigate to the member tab
    When I click on cancel membership link
    Then I verify the membership cancel link

  Scenario: Verify the email address to enter and link the membership
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I goes to my account for estore
    When I click on my account button if page is not loaded
    When I click on estore my account icon for guest user
    When I navigate to the member tab
    When I introduce email address to link membership field
    When I click on link membership buttom
    Then I verify that user is able to link membership

  Scenario: Verify the Add to cart button
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I click on estore my account icon for guest user
    When I navigate to the member tab
    When I click to add to cart on membership page
    When I open estore cart
    Then I verify that membership was added to cart
    And I verify that total line price is equal to price for member
    When I click on remove membership estore button

