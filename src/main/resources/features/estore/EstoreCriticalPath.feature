#@estoreTestRun
#Feature: Estore critical path
#
#  Scenario Outline: Verify top menu navigation
#    Given I log into eStore as guest
#    When I choose country for concierge from footer
#    Then  I change the brand to "<brand>" for eStore
#    Then User verifies that all items from menu are displayed for "<brand>"
#    And user verifies search button, account icon, cart button are displayed
#    Examples:
#      | brand             |
#      | RH                |
#      | RH CONTEMPORARY   |
#      | RH INTERIORS      |
#      | RH MODERN         |
#      | RH OUTDOOR        |
#      | RH BEACH HOUSE    |
#      | RH SKI HOUSE      |
#      | RH TEEN           |
#      | BABY & CHILD      |
#      | VIEW SOURCE BOOKS |
#
#  Scenario Outline: CG - Test CGS in all menu items (All brands)
#    Given I log into eStore as "guest" user
#    When I choose country for eStore from footer
#    When I goes to "<brands>" estore collection page
#    Then I verify CGS all menu items
#    Examples:
#      | brands         |
#      | rh             |
#      | rhcontemporary |
#      | rhinteriors    |
#      | rhmodern       |
#      | rhoutdoor      |
#      | rhbeachhouse   |
#      | rhskihouse     |
#      | rhbabyandchild |
#      | rhteen         |
#
#
#  Scenario: Verify collection name,image (regular,member,sale(applicable) on collection banner
#    Given I log into eStore as "guest" user
#    When I choose country for eStore from footer
#    When I goes to estore collection page
#    Then I verify collection name, image on collection banner
#
#  Scenario: CG-Verify Back To top Button
#    Given I log into eStore as "guest" user
#    When I choose country for eStore from footer
#    When I goes to estore collection page
#    When I scroll on the page till back to top button is visible
#    Then I verify that back to top button is clickable
#    And I verify that after click on back to top button user is scrolled to top on the page
#
#  Scenario: Verify 1,2,3 grid views are working fine
#    Given I log into eStore as "guest" user
#    When I choose country for eStore from footer
#    When I goes to estore collection page
#    Then I validate "1","2" and "3" grid view should work
#
#  Scenario: Verify single Grid View is as default on CG
#    Given I log into eStore as "guest" user
#    When I choose country for eStore from footer
#    When I goes to estore collection page
#    Then I verify that single grid view is selected on CG page by default
#
#  Scenario: Change the grid view, go to PG, go back from PG, CG page should render in the same grid view that you previously selected
#    Given I log into eStore as "guest" user
#    When I choose country for eStore from footer
#    When I go to "FABRIC CHAIR COLLECTIONS" on eStore
#    When I select "3" grid view on estore CG page
#    When I go to estore item "white and blue corner leather sofa" from search field
#    When I go to "SEATING COLLECTIONS" on eStore
#    Then I verify that page render in the same grid view that previously selected
#
##PDP
#  Scenario Outline: Verify Line Items functionality:
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I remove all items from estore cart
#    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
#    Then I verify line items "<functional>"
#    Examples:
#      | functional            |
#      | lineitemimage         |
#      | customizeanproduct    |
#      | addtowishlist         |
#      | locationfunctionality |
#
#  Scenario: eStore Verify Guest checkout
#    Given I log into eStore as "guest" user
#    When I choose country for eStore from footer
#    When I remove all items from estore cart
#    When I open product page with "prod13800635" and "17050042" with "IRON" for estore
#    When I click on add to cart estore button
#    And I click on view cart estore button
#    When I click on estore checkout button
#    When I click on estore no thanks button
#    When I click on continue as guest estore button
#    When I fill estore shipping address
#    When I fill estore shipping email address
#    When I click on same as estore shipping address checkbox
#    When I click on continue to payment estore button
#    When I click on continue with original address estore button
#    When I remove payment method which was used earlier
#    When I execute payment with credit card on estore
#    When I click on a place estore order button
#    Then I verify that estore thank you page is displayed
#
#  Scenario: Verify registered user checkout in estore
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I remove all items from estore cart
#    When I open product page with "prod2020027" and "17050043" with "NOCT" for estore
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
#
#  Scenario: Verify member user checkout in estore
#    Given I log into eStore as "member" user
#    When I choose country for eStore from footer
#    When I remove all items from estore cart
#    When I open product page with "prod2020027" and "17050043" with "NOCT" for estore
#    When I click on add to cart estore button
#    And I click on view cart estore button
#    When I click on estore checkout button
#    When I fill estore shipping address
#    When I click on same as estore shipping address checkbox
#    When I click on continue to payment estore button
#    When I click on continue with original address estore button
#    When I remove payment method which was used earlier
#    When I execute payment with credit card on estore
#    When I click on a place estore order button
#    Then I verify that estore thank you page is displayed
#
##Verify the Payment flow
#  Scenario Outline: eStore - Major CC - US
#    Given I log into eStore as "noaddresses" user
#    When I choose country for eStore from footer
#    When I remove all items from estore cart
#    When I add item to cart via API for estore
#    When I open estore cart
#    When I click on estore checkout button
#    And I click on estore no thanks button
#    When I fill estore shipping address
#    When I click on same as estore shipping address checkbox
#    When I click on continue to payment estore button
#    When I click on continue with original address estore button
#    When I remove payment method which was used earlier
#    When I execute estore payment for "<cardType>"
#    When I click on a place estore order button
#    Examples:
#      | cardType |
#      | VI       |
#      | MC       |
#      | AX       |
#      | DI       |
#
#  Scenario: eStore Split Payment
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I remove all items from estore cart
#    When I add item to cart via API for estore
#    When I open estore cart
#    When I click on estore checkout button
#    And I click on estore no thanks button
#    When I fill estore shipping address
#    When I click on same as estore shipping address checkbox
#    When I click on continue to payment estore button
#    When I click on continue with original address estore button
#    When I remove split payment which was used earlier
#    When I refresh current estore page
#    Then I verify that I'm able to execute estore split payment
#
#  Scenario: eStore RHCC
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I remove all items from estore cart
#    When I add item to cart via API for estore
#    When I open estore cart
#    When I click on estore checkout button
#    And I click on estore no thanks button
#    When I fill estore shipping address
#    When I click on same as estore shipping address checkbox
#    When I click on continue to payment estore button
#    When I click on continue with original address estore button
#    When I remove payment method which was used earlier
#    When I pay with RHCC for estore item
#    When I click on estore continue button
#    When I click on a place estore order button
#    Then I verify that estore thank you page is displayed
#
#  Scenario: GC/ Balance check
#    Given I log into eStore as "mastercard" user
#    When I choose country for eStore from footer
#    When I remove all items from estore cart
#    When I add item to cart via API for estore
#    When I open estore cart
#    When I click on estore checkout button
#    And I click on estore no thanks button
##    When I fill estore shipping address
##    When I click on same as estore shipping address checkbox
#    When I click on continue to payment estore button
#    When I click on continue with original address estore button
#    When I remove payment method which was used earlier
#    When I choose "RH Gift Card" from payment method
#    When I click on check balance button
#    Then I verify that gift card balance info is displayed for estore
#
##Verify the cart updates, remove line, add to wish lsit, update qty, add membership
#  Scenario: Verify that user is able to add multiple item to cart, total price is correct
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I remove all items from estore cart
#    When I open product page with "prod13800635" and "17050042" with "IRON" for estore
#    When I update item quantity in estore pdp
#    When I click on add to cart estore button
#    When I click on view cart estore button
#    Then that was added "2" quantity of item in cart
#    And I verify that total price is correct for "prod13800635" and "17050042" with "IRON" for estore
#    When I change item quantity to "1" for "prod13800635" and "17050042" with "IRON" for estore
#
#  Scenario: Remove line item
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I remove all items from estore cart
#    When I open product page with "prod13800635" and "17050042" with "IRON" for estore
#    When I update item quantity in estore pdp
#    When I click on add to cart estore button
#    When I click on view cart estore button
#    When I click on remove button from estore cart page
#    Then I verify that shopping cart is empty for estore
#
#  Scenario: Remove item from wishlist
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I open product page with "prod2020027" and "17050043" with "FOG" for estore
#    When I click on add to wishlist button
#    Then I verify that I'm able to remove wishlist from cart
#
#
#  Scenario: User is a non member user then it will show a banner to "Join Membership" click on link to join the membership
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I remove all items from estore cart
#    When I add item to cart via API for estore
#    When I open estore cart
#    Then I verify membership estore banner for "nonmember user"
#
##Verify the Instock and On sale functionality
#  Scenario: Verify the Instock and On sale functionality
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I open product page with "prod2020027" and "17050043" with "FOG" for estore
#    Then I verify link bellow "View In-Stock Items" is displayed
#
##Verify the availability , delivery and return messages in PDP
#  Scenario: Verify the availability , delivery and return messages in PDP
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I open product page with "prod2020027" and "17050043" with "FOG" for estore
#    Then I verify availability , delivery and return messages in PDP
#
##Verify the dropdown selection and add to cart
#  Scenario: Verify the dropdown selection and add to cart
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I open product page with "prod2020027" and "17050043" with "FOG" for estore
#    Then I verify that add to cart button is active
#    When I unselect the size option for "prod2020027" and "17050043" with "FOG" for estore
#    And I verify that add to cart button is inactive
#
##Verify the pricing based on country  - ?
#  Scenario: Configure this item to view delivery information for your Location, price update
#    Given I log into eStore as "regular" user
#    When I remove all items from estore cart
#    When I choose country for eStore from footer
#    When I open product page with "prod2020027" and "17050043" with "FOG" for estore
#    When I update "CAN" postal code on pdp page
#    Then I verify that price is showing for regular and member user
#    And I verify that price for "prod2020027" and "17050043" with "FOG" was updated for "CAN"
#
##Verify the Postal code updates incart, PDP
#  Scenario: Verify the product price as per the selected country in the dropdown
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I remove all items from estore cart
#    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
#    When I update "CAN" postal code on pdp page
#    Then I verify the product price for product "prod13800635" and "17050043" with "INDG" for the selected "CAN" country
#
#  Scenario: Verify the prices it is showing for regular user
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I open product page with "prod13800635" and "17050043" with "INDG" for estore
#    Then I verify that price is showing for regular and member user
#
##Verify the SIgn in /Login
#  Scenario: Verify that user is not able to login with invalid email and password
#    Given I introduce wrong login and password
#    Then I verify that error message about invalid credentials is displayed
#
#  Scenario: Forgot Password option should be present with proper functionality
#    Given when I click on forgot password button
#    Then I verify that forgot password options works
#
##Order review page
#  Scenario: Edit payment
#    Given I log into eStore as "orderreview" user
#    When I choose country for eStore from footer
#    When I remove all items from estore cart
#    When I add item to cart via API for estore
#    When I open estore cart
#    When I click on estore checkout button
#    When I click on estore no thanks button
#    When I fill estore shipping address
#    When I click on same as estore shipping address checkbox
#    When I click on continue to payment estore button
#    When I click on continue with original address estore button
#    When I remove payment method which was used earlier
#    When I execute payment with credit card on estore
#    When I click on estore edit payment button on order review page
#    When I remove existing payment method on payment estore page
#    When I execute payment with credit card on estore
#    Then I verify that payment has been changed
#
#  Scenario: Edit Shipping
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I remove all items from estore cart
#    When I open product page with "prod13800635" and "17050042" with "IRON" for estore
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
#    Then I verify that I'm able to edit shipping and billing address
#    When I click on continue to payment estore button
#    When I click on continue with original address estore button
#    When I click on continue button from payment page
#    Then I verify that shipping address was edited
#
#  Scenario: Edit Billing Address
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I remove all items from estore cart
#    When I open product page with "prod13800635" and "17050042" with "IRON" for estore
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
#    When I click on edit estore billing address button
#    When I click on edit billing adress button on address page
#    Then I verify that I'm able to edit billing address from order review page
#    When I click on continue to payment estore button
#    When I click on continue with original address estore button
#    When I click on continue button from payment page
#    Then I verify that billing address was edited
#
##Order replacement
#  Scenario: Order replacement
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I remove all items from estore cart
#    When I add item to cart via API for estore
#    When I open estore cart
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
#    When I go to estore home page from thank you page
#    When I remove all items from estore cart
#    When I add item to cart via API for estore
#    When I open estore cart
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
#    When I click on order details button
#    And I verify billing and shipping address are correct
#
##Verify the Sign in /Login
#  Scenario: Verify that user is able to create account
#    Given I click on estore my account icon for guest user
#    When I click on create account button
#    When I introduces the required details
#    When I click on agree privacy policy checkbox
#    When I click on create account button from form
#    When I click on estore my account icon for registered user
#    Then I verify that I'm able to create the new account
#
##Verify My account dropdowm
#  Scenario: Verify the personal Info displayed after Sign in - First, last name and email
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I goes to my account for estore
#    Then I verify that the personal info is displayed
#
##Membership page and functionality
#  Scenario: eStore Membership
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I navigate to the member tab
#    Then I validate membership title
#
#  Scenario: Verify the membership Terms and Conditions Link
#    Given I log into eStore as "member" user
#    When I choose country for eStore from footer
#    When I navigate to the member tab
#    When I click on terms & condition link
#    Then I verify that rh members program terms & condition pop up is displayed
#
#  Scenario: Verify the email address displayed in membership page
#    Given I log into eStore as "member" user
#    When I choose country for eStore from footer
#    When I navigate to the member tab
#    Then I verify that email address displayed in membership page
#
#  Scenario: Verfiy membership FAQa link
#    Given I log into eStore as "member" user
#    When I choose country for eStore from footer
#    When I navigate to the member tab
#    When I click on FAQa link for estore
#    Then I verfiy that frequently asked questions page is displayed
#
#  Scenario: Verify the membership page when the membership is canceled
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I navigate to the member tab
#    Then I verify that membership is cancelled
#
##Order history and details
#  Scenario: Verify accessing order history - orders displayed for registered user
#    Given I log into eStore as "member" user
#    When I choose country for eStore from footer
#    When I click on estore my account icon
#    When I click on estore order history
#    Then I verify that estore order history page is displayed
#
#  Scenario: Verify no Orders display for new registered user - verify the copy provided
#    Given I log into eStore as "notregistered" user
#    When I choose country for eStore from footer
#    When I click on estore my account icon
#    When I click on estore order history
#    Then I verify that no orders for new registered user
#
#  Scenario: Verify the fields - ORDER DATE, EST. ORDER TOTAL, ORDER NUMBER,	SHIPPED TO,	ORDER DESCRIPTION
#    Given I log into eStore as "member" user
#    When I choose country for eStore from footer
#    When I click on estore my account icon
#    When I click on estore order history
#    Then I verify order date and order total fields
#    When I click on details and tracking order history
#    Then I verify the fileds for estore order history
#
##Billing summary
#  Scenario: Verify the Billing summary link for order - Order to be in shipped/delivered state
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I click on estore my account icon
#    When I click on estore order history
#    Then I verify the billing summary link for order history
#
##Wishlist
#  Scenario: Wishlist for registered users
#    Given I log into eStore as "wishlist-registered" user
#    When I choose country for eStore from footer
#    When I navigate to the wishlist
#    Then I validate items in wishlist
#
#  Scenario: Add an item from cart to wishlist
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I remove all items from estore cart
#    When I add item to cart via API for estore
#    When I open estore cart
#    When I click on add to wishlist button from cart
#    When I click on view wishlist button
#    Then I validate items in wishlist
#
##Logout
#  Scenario: Logout
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I click on estore account
#    When I click on estore signout button
#    When I click on estore my account icon for not logged user
#    Then I verify that user is able to signout
#
##Search
#  Scenario: Verify count of search result and product
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I go to estore item "towels" from search field
#    Then I verify count of search results
#
#  Scenario: Verify the Back to top button
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
#    When I scroll to the bottom of the estore page
#    When I click on estore back to top button
#
#  Scenario: Verify the in stock facet selection and in stock product
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I go to estore item "sofa" from search field
#    Then I verify in stock facet selection
#
#  Scenario: Place order: search with any key term, select high to low. navigate to first product PDP
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I go to estore item "white and blue corner leather sofa" from search field
#    When I select high to low for estore
#    When I navigate for the first product PDP
#    When I select size option on the PDP page
#    When I select finish option on the PDP page
#    When I click on add to cart estore button
#    When I click on view cart estore button
#    When I click on estore checkout button
#    When I click on estore no thanks button
#    When I click on same as estore shipping address checkbox
#    When I click on continue to payment estore button
#    When I click on continue with original address estore button
#    When I remove payment method which was used earlier
#    When I execute payment with credit card on estore
#    When I click on a place estore order button
#    Then I verify that estore thank you page is displayed
#
#  Scenario: Place order: search with any key term, select Low to High. navigate to first product PDP
#    Given I log into eStore as "regular" user
#    When I choose country for eStore from footer
#    When I go to estore item "white" from search field
#    When I select low to high for estore
#    When I navigate for the first product PDP
#    When I select size option on the PDP page
#    When I click on add to cart estore button
#    When I click on view cart estore button
#    When I click on estore checkout button
#    When I click on estore no thanks button
#    When I click on same as estore shipping address checkbox
#    When I click on continue to payment estore button
#    When I click on continue with original address estore button
#    When I remove payment method which was used earlier
#    When I execute payment with credit card on estore
#    When I click on a place estore order button
#    Then I verify that estore thank you page is displayed
#
# #Trade
#  Scenario: Verify the trade login and checkout
#    Given I log into eStore as trade
#    When I choose country for eStore from footer
#    When I remove all items from estore cart
#    When I add item to cart via API for estore
#    When I open estore cart
#    When I click on estore checkout button
#    When I click on same as estore shipping address checkbox
#    When I click on continue to payment estore button
#    When I click on continue with original address estore button
#    When I remove payment method which was used earlier
#    When I execute payment with credit card on estore
#    When I click on a place estore order button
#    Then I verify that estore thank you page is displayed
#
##Contract
#  Scenario: Verify the contract login and checkout
#    Given I log into eStore as contract
#    When I choose country for eStore from footer
#    When I remove all items from estore cart
#    When I open product page with "prod13800635" and "17050042" with "IRON" for estore
#    When I click on add to cart estore button
#    And I click on view cart estore button
#    When I click on estore checkout button
#    When I click on same as estore shipping address checkbox
#    When I click on continue to payment estore button
#    When I click on continue with original address estore button
#    When I remove payment method which was used earlier
#    When I execute payment with credit card on estore
#    When I click on a place estore order button
#    Then I verify that estore thank you page is displayed
#
# #GuestHouse
#  Scenario: Verify dinning room page
#    Given I go to estore guesthouse home page
#    When I click on the estore guesthouse dining room page
#    Then I verify that estore guesthouse dining room page is accessible
#
#  Scenario: Verify Champagne Caviar bar page
#    Given I go to estore guesthouse home page
#    When I click on the estore Champagne Caviar bar page
#    Then I verify that estore Champagne Caviar bar page is displayed
#
#  Scenario: Verify Guest rooms Suites page
#    Given I go to estore guesthouse home page
#    When I click on estore guest rooms suites page
#    Then I verify that estore guesthouse rooms suites page is displayed
#
#  Scenario: Verify Rooftop pool page
#    Given I go to estore guesthouse home page
#    When I click on estore guesthouse rooftop pool page
#    Then I verify that estore guesthouse rooftop pool page is displayed