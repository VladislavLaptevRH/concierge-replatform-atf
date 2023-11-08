@estoreCriticalPathTestRun
Feature: Estore critical path


  Scenario Outline: Verify top menu navigation
    Given I log into eStore as guest
    When I choose country for eStore from footer
    Then  I change the brand to "<brand>" for eStore
    Then User verifies that all items from menu are displayed for "<brand>" on eStore
    And user verifies search button, account icon, cart button are displayed
    Examples:
      | brand           |
      | RH              |
      | RH CONTEMPORARY |
      | RH INTERIORS    |
      | RH MODERN       |
      | RH OUTDOOR      |
      | RH BEACH HOUSE  |
      | RH SKI HOUSE    |
      | RH TEEN         |
      | RH BABY & CHILD |


  Scenario Outline: CG - Test CGS in all menu items (All brands)
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I goes to "<brands>" estore collection page
    Then I verify CGS all menu items
    Examples:
      | brands         |
      | rh             |
      | rhcontemporary |
#      | rhinteriors    |
#      | rhmodern       |
#      | rhoutdoor      |
#      | rhbeachhouse   |
#      | rhskihouse     |
#      | rhbabyandchild |
#      | rhteen         |


  Scenario Outline: Verify product thumbnail is correctly loaded
    Given  I change the brand to "<brand>" for eStore
    When I go to estore item "sofa" from search field
    Then I verify that product thumbnail is correctly loaded
    Examples:
      | brand          |
      | RH             |
#      | RH CONTEMPORARY |
#      | RH MODERN       |
#      | RH OUTDOOR      |
      | RH BEACH HOUSE |
#      | RH SKI HOUSE    |
#      | RH TEEN         |
#      | RH BABY & CHILD |


  Scenario: Verify it shows price range below the thumbnail
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I go to estore item "sofa" from search field
    Then user verifies that price range is displayed below the thumbnail


  Scenario Outline: PG - Back to Top button
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    Then  I change the brand to "<brand>" for eStore
    When I goes to estore collection page
    When I scroll on the page till back to top button is visible
    Then I verify that back to top button is clickable
    And I verify that after click on back to top button user is scrolled to top on the page
    Examples:
      | brand     |
      | RH        |
#      | RH CONTEMPORARY |
#      | RH INTERIORS    |
      | RH MODERN |
#      | RH OUTDOOR      |
#      | RH BEACH HOUSE  |
#      | RH SKI HOUSE    |
#      | RH TEEN         |
#      | RH BABY & CHILD |


  Scenario Outline: PG - Verify the Sale Price on PG pages for Sale Items
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then  I change the brand to "<brand>" for eStore
    When I go to Sale product page
    Then I verify sale prices on PG pages for sale items
    Examples:
      | brand          |
      | RH             |
#      | RH CONTEMPORARY |
#      | RH INTERIORS    |
#      | RH MODERN       |
#      | RH OUTDOOR      |
      | RH BEACH HOUSE |
#      | RH SKI HOUSE    |
#      | RH TEEN         |
#      | RH BABY & CHILD |


  Scenario Outline: PG - Verify sorting - low to high - is working as expected
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    Then  I change the brand to "<brand>" for eStore
    When I go to estore item "sofa" from search field
    When I select low to high for estore
    Then I verify that sorting low to high is working as expected
    Examples:
      | brand |
      | RH    |
#      | RH CONTEMPORARY |
#      | RH INTERIORS    |
#      | RH MODERN       |
      | RH OUTDOOR      |
#      | RH BEACH HOUSE  |
#      | RH SKI HOUSE    |
#      | RH TEEN         |
#      | RH BABY & CHILD |


  Scenario Outline: PG - Verify sorting - high to low - is working as expected
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    Then  I change the brand to "<brand>" for eStore
    When I go to estore item "sofa" from search field
    When I select high to low for estore
    Then I verify that sorting high to low is working as expected
    Examples:
      | brand           |
      | RH              |
#      | RH CONTEMPORARY |
#      | RH INTERIORS    |
#      | RH MODERN       |
#      | RH OUTDOOR      |
#      | RH BEACH HOUSE  |
#      | RH SKI HOUSE    |
#      | RH TEEN         |
      | RH BABY & CHILD |


  Scenario Outline: PG - Verify the Member Price Text On PG page after selecting the specifications
    Given I log into eStore as "member" user
    When I choose country for eStore from footer
    Then  I change the brand to "<brand>" for eStore
    When I navigate to PG page from top menu
    Then I verify the member price on PG page after selecting the specifications
    Examples:
      | brand |
      | RH    |
#      | RH CONTEMPORARY |
#      | RH INTERIORS    |
#      | RH MODERN       |
#      | RH OUTDOOR      |
#      | RH BEACH HOUSE  |
#      | RH SKI HOUSE    |
#      | RH TEEN         |
#      | RH BABY & CHILD |


  Scenario Outline: CG - Verify collection name,image (regular,member,sale(applicable) on collection banner
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    Then  I change the brand to "<brand>" for eStore
    When I goes to estore collection page
    Then I verify collection name, image on collection banner
    Examples:
      | brand |
      | RH    |
#      | RH CONTEMPORARY |
#      | RH INTERIORS    |
#      | RH MODERN       |
#      | RH OUTDOOR      |
#      | RH BEACH HOUSE  |
#      | RH SKI HOUSE    |
#      | RH TEEN         |
#      | RH BABY & CHILD |


  Scenario Outline: CG-Verify Back To top Button
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    Then  I change the brand to "<brand>" for eStore
    When I goes to estore collection page
    When I scroll on the page till back to top button is visible
    Then I verify that back to top button is clickable
    And I verify that after click on back to top button user is scrolled to top on the page
    Examples:
      | brand |
      | RH    |
#      | RH CONTEMPORARY |
#      | RH INTERIORS    |
#      | RH MODERN       |
#      | RH OUTDOOR      |
#      | RH BEACH HOUSE  |
#      | RH SKI HOUSE    |
#      | RH TEEN         |
#      | RH BABY & CHILD |

  Scenario Outline: CG - Verify 1,2,3 grid views are working fine
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    Then  I change the brand to "<brand>" for eStore
    When I goes to estore collection page
    Then I validate "1","2" and "3" grid view should work
    Examples:
      | brand |
      | RH    |
#      | RH CONTEMPORARY |
#      | RH INTERIORS    |
#      | RH MODERN       |
#      | RH OUTDOOR      |
#      | RH BEACH HOUSE  |
#      | RH SKI HOUSE    |
#      | RH TEEN         |
#      | RH BABY & CHILD |


  Scenario Outline: CG - Verify single Grid View is as default on CG
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    Then  I change the brand to "<brand>" for eStore
    When I goes to estore collection page
    Then I verify that single grid view is selected on CG page by default
    Examples:
      | brand |
      | RH    |
#      | RH CONTEMPORARY |
#      | RH INTERIORS    |
#      | RH MODERN       |
#      | RH OUTDOOR      |
#      | RH BEACH HOUSE  |
#      | RH SKI HOUSE    |
#      | RH TEEN         |
#      | RH BABY & CHILD |


  Scenario Outline: CG - Change the grid view, go to PG, go back from PG, CG page should render in the same grid view that you previously selected
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    Then  I change the brand to "<brand>" for eStore
    When I go to "FABRIC CHAIR COLLECTIONS" on eStore
    When I select "3" grid view on estore CG page
    When I click on random item from collection page with applied "3" grid view
    When I navigate back from "collection page" page
    Then I verify that page render in the same grid view that previously selected
    Examples:
      | brand |
      | RH    |
#      | RH CONTEMPORARY |
#      | RH INTERIORS    |
#      | RH MODERN       |
#      | RH OUTDOOR      |
#      | RH BEACH HOUSE  |
#      | RH SKI HOUSE    |
#      | RH TEEN         |
#      | RH BABY & CHILD |
    #click on random product from collection (PG) after click on  back button from browser


  Scenario Outline: CG - From home page goto a collection and click on any Product, It should redirect user to PG
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    Then  I change the brand to "<brand>" for eStore
    When I goes to estore collection page
    When I click on random product on collection page
    Then I verify that PG page is displayed for eStore
    Examples:
      | brand |
      | RH    |
#      | RH CONTEMPORARY |
#      | RH INTERIORS    |
#      | RH MODERN       |
#      | RH OUTDOOR      |
#      | RH BEACH HOUSE  |
#      | RH SKI HOUSE    |
#      | RH TEEN         |
#      | RH BABY & CHILD |
    #use fabric seating - sofas: check title, grid view

  Scenario: CG - Browser back button from search to CG page
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to "SEATING COLLECTIONS" on eStore
    When I go to estore item "sofa" from search field
    When I navigate back from "PDP" page
    Then I verify that CG page is displayed

#PDP - Add to wishList
  Scenario Outline: PDP - Verify Line Items functionality:
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod19500002" and "17050045" with "STWL" for estore
    Then I verify line items "<functional>"
    Examples:
      | functional            |
      | lineitemimage         |
      | customizeanproduct    |
      | addtowishlist         |
      | locationfunctionality |


  Scenario: Guest - eStore Verify Guest checkout
    Given I log into eStore as "guest" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    Then I chose the '1' line item selections one by one
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
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed


  Scenario: Verify registered user checkout in estore
    Given I log into eStore as "e2eflowcriticalpath" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    Then I chose the '1' line item selections one by one
    When I open product page with "prod19500002" and "17050045" with "STWL" for estore
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


  Scenario: Member - Verify member user checkout in estore
    Given I log into eStore as "member" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod19500002" and "17050045" with "STWL" for estore
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that order estimate is calculcated based on member prices
    When I click on estore checkout button
    Then user verify that membership pop up is not displayed on eStore
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

#Verify the Payment flow

  Scenario Outline: Payment - eStore - Major CC - US
    Given I log into eStore as "noaddresses" user
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
    When I execute estore payment for "<cardType>"
    When I click on a place estore order button
    Examples:
      | cardType |
      | VI       |
      | MC       |
      | AX       |
      | DI       |



  Scenario: Payment - Verify combining different cards(MC+Visa) + split payment
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

#should be updated - FIX

  Scenario: Payment - Verify combining different cards(RH Credit Card+Gift Card) + split payment
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
    Then I verify that I'm able to execute estore split payment with RH Credit Card+Gift Card


  Scenario: Payment - eStore RHCC
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


  Scenario: Payment - GC/ Balance check
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
    When I choose "RH Gift Card" from payment method
    When I click on check balance button
    Then I verify that gift card balance info is displayed for estore

#Verify the cart updates, remove line, add to wish lsit, update qty, add membership

  Scenario: Cart - Verify that user is able to add multiple item to cart, total price is correct
    Given I log into eStore as "nonmember" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod19500002" and "17050045" with "STWL" for estore
    When I update item quantity in estore pdp
    When I click on add to cart estore button
    When I click on view cart estore button
    Then that was added "2" quantity of item in cart
    And I verify the total price for product in the cart
    When I change item quantity to "1" for "prod19500002" and "17050045" with "NCKL" for estore
    And I verify the total price for product in the cart


  Scenario: Cart - Add Membership and verify order total in order estimate
    Given I log into eStore as "regularAddMembership" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I click on join now membership button
    Then I verify estore order total in order estimate for membership for "42100241 GREY"
    When I click on remove membership estore button


  Scenario: Cart - Remove line item
    Given I log into eStore as "cartremoveitem" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod19500002" and "17050045" with "STWL" for estore
    When I update item quantity in estore pdp
    When I click on add to cart estore button
    When I click on view cart estore button
    When I click on remove button from estore cart page
    Then I verify that shopping cart is empty for estore


  Scenario: Cart - User is a non member user then it will show a banner to "Join Membership" click on link to join the membership
    Given I log into eStore as "joinmembershipbanner" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    Then I verify membership estore banner for "nonmember user"

#Verify the Instock and On sale functionality

  Scenario: Verify the In stock functionality
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I open product page with "prod19500002" and "17050045" with "STWL" for estore
    Then I verify link bellow "View In-Stock Items" is displayed
    And I verify that "View In-Stock" popup is displayed


  Scenario: Verify the On sale functionality
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I open product page with "prod19500002" and "17050045" with "STWL" for estore
    Then I verify link bellow "View On Sale Items" is displayed
    And I verify that "View On Sale" popup is displayed


  Scenario: PDP - Verify the availability , delivery and return messages in PDP
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    Then I verify availability , delivery and return messages in PDP

#Verify the dropdown selection and add to cart

  Scenario: PDP - Verify the dropdown selection and add to cart case 1
    Given I log into eStore as guest
    When I choose country for eStore from footer
    When I open product page with "prod19500002" and "17050045" with "STWL" for estore
    Then I verify that add to cart button is active
    And  I verify special messages on PDP page
    When I unselect the size option for "prod19500002" and "17050045" with "NCKL" for estore
    And I verify that add to cart button is inactive


  Scenario: PDP - Verify the dropdown selection and add to cart case 2
    Given I log into eStore as "verifythedropdowncartcase2" user
    When I choose country for eStore from footer
    When I open product page with "prod2020027" and "" with "" for estore
    Then I verify that add to cart button is inactive
    When I select size option on the PDP page
    When I select color option on the PDP page
    Then I verify that add to cart button is active
    And I verify special messages on PDP page

  Scenario: PDP - Configure this item to view delivery information for your Location, price update
    Given I log into eStore as "pdpconfigurepdpthisitemtoview" user
    When I remove all items from estore cart
    When I choose country for eStore from footer
    When I open product page with "prod2020027" and "17050045" with "STWL" for estore
    When I get prices for US for eStore
    When I update "CAN" postal code on pdp page
    Then I verify that prices for "CAN" was updated
    When I update "GB" postal code on pdp page
    Then I verify that prices for "GB" was updated

  #check price not with hardcoded values
#Verify the Postal code updates incart, PDP

  Scenario: PDP - Verify the product price as per the selected country in the dropdown
    Given I log into eStore as "verifytheproductpriceasperselectedcountry" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod2020027" and "17050045" with "STWL" for estore
    Then I chose the '1' line item selections one by one
    When I update "CAN" postal code on pdp page
    Then I verify the product price for product "prod2020027" and "17050045" with "NCKL" for the selected "CAN" country
    When I click on add to cart estore button
    When I click on view cart estore button
    Then I verify that price in cart is the same as on PDP


  Scenario: PDP - Verify the prices it is showing for regular user
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I open product page with "prod13800635" and "17050042" with "WHEA" for estore
    Then I verify that price is showing for regular and member user


  Scenario: Cart - Zip code validation in cart
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    When I click on zipcode estore button
    Then I verify US zip code validation in estore cart
    And I verify CA zip code validation in estore cart


  Scenario: Cart - eStore - Membership price in cart
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I goes to estore cart for estore
    Then I verify membership price in banner

  #Verify the add to cart funtionality
  Scenario: Cart - Verify the Add to cart functionality
    Given I log into eStore as "cartverifyaddtocartfunctionality" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod30750071" and "17050045" with "STWL" for estore
    When I update "CAN" postal code on pdp page
    Then I verify price for member and regular user on PDP
    Then I verify the product price for product "prod30750071" and "17050045" with "NCKL" for the selected "CAN" country
    When I click on add to cart estore button
    And I click on view cart estore button
    Then I verify that price in cart is the same as on PDP
    And I verify the total price for product in the cart
    And I verify the cart item quantity is equal to "1" on eStore

#Verify the SIgn in /Login

  Scenario: Verify that user is not able to login with invalid email and password
    Given I introduce wrong login and password
    Then I verify that error message about invalid credentials is displayed


  Scenario: Forgot Password option should be present with proper functionality
    Given when I click on forgot password button
    Then I verify that forgot password options works


  Scenario: Verify that user is able to create account
    Given I click on estore my account icon for guest user
    When I click on create account button
    When I introduces the required details
    When I click on agree privacy policy checkbox
    When I click on create account button from form
    When I click on estore my account icon for registered user
    Then I verify that I'm able to create the new account

# Verify my account dropdown

  Scenario Outline: Account - Verify My account dropdowm
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on my account button
    When I click on the "<option>" from my account dropdown
    Then I verify that "<option>" is available for eStore
    And I verify that required page for "<option>" is displayed
    Examples:
      | option        |
      | order-history |
      | wish-list     |
      | membership    |
      | gift-registry |
      | profile       |
      | signout       |

  #Verify My account dropdowm

  Scenario:Account - Verify the personal Info displayed after Sign in - First, last name and email
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I goes to my account for estore
    When I click on my account button if page is not loaded
    Then I verify that the personal info is displayed

#Order review page

  Scenario: Order review - Edit payment
    Given I log into eStore as "orderrevieweditpayment" user
    When I choose country for eStore from footer
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
    When I click on estore edit payment button on order review page
    When I remove existing payment method on payment estore page
    When I execute payment with credit card on estore
    Then I verify that payment has been changed


  Scenario:Order review -  Edit Shipping
    Given I log into eStore as "orderrevieweditshipping" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod19500002" and "17050045" with "STWL" for estore
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
    Then I verify that I'm able to edit shipping and billing address
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I click on continue button from payment page
    Then I verify that shipping address was edited


  Scenario:Order review - Edit Billing Address
    Given I log into eStore as "orderrevieweditbillingaddress" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod19500002" and "17050045" with "STWL" for estore
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
    When I click on edit estore billing address button
    When I click on edit billing adress button on address page
    Then I verify that I'm able to edit billing address from order review page
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I click on continue button from payment page
    Then I verify that billing address was edited

#Order replacement

  Scenario: Order replacement
    Given I log into eStore as "orderreplacement" user
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
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed
    When I go to estore home page from thank you page
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
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed
    And I verify billing and shipping address are correct

#Membership page and functionality

  Scenario: Membership - Verify the add to cart button on membership page
    Given I log into eStore as "nonmember" user
    When I choose country for eStore from footer
    When I click on estore my account icon
    When I navigate to the member tab
    When I click to add to cart on membership page
    When I verify membership was added to cart
    And I click on remove membership estore button


  Scenario: eStore Membership
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore my account icon
    When I navigate to the member tab
    Then I validate membership title


  Scenario: Membership - Verify the membership Terms and Conditions Link
    Given I log into eStore as "member" user
    When I choose country for eStore from footer
    When I goes to my account for estore
    When I click on my account button if page is not loaded
    When I click on estore my account icon
    When I navigate to the member tab
    When I click on terms & condition link
    Then I verify that rh members program terms & condition pop up is displayed


  Scenario: Membership - Verify the email address displayed in membership page
    Given I log into eStore as "member" user
    When I choose country for eStore from footer
    When I goes to my account for estore
    When I click on my account button if page is not loaded
    When I click on estore my account icon
    When I navigate to the member tab
    Then I verify that email address displayed in membership page


  Scenario: Membership - Verfiy membership FAQa link
    Given I log into eStore as "member" user
    When I choose country for eStore from footer
    When I click on my account button if page is not loaded
    When I click on estore my account icon
    When I navigate to the member tab
    When I click on FAQa link for estore
    Then I verfiy that frequently asked questions page is displayed


  Scenario: Membership - Verify the membership page when the membership is canceled
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I goes to my account for estore
    When I click on my account button if page is not loaded
    When I click on estore my account icon
    When I navigate to the member tab
    Then I verify that membership is cancelled

#Order history and details

  Scenario: Order history - Verify accessing order history - orders displayed for registered user
    Given I log into eStore as "member" user
    When I choose country for eStore from footer
    When I click on estore my account icon
    When I click on estore order history
    Then I verify that estore order history page is displayed


  Scenario: Order history - Verify no Orders display for new registered user - verify the copy provided
    Given I log into eStore as "notregistered" user
    When I choose country for eStore from footer
    When I click on estore my account icon
    When I click on estore order history
    Then I verify that no orders for new registered user

#Billing summary

  Scenario:  Order history - Verify the Billing summary link for order - Order to be in shipped/delivered state
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I click on estore my account icon
    When I click on estore order history
    Then I verify the billing summary link for order history

#Wishlist

  Scenario: WishList - Wishlist for registered users
    Given I log into eStore as "wishlist-registered" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on add to wishlist button from cart
    When I click on view wishlist button
    When I click on my account button if page is not loaded
    Then I validate items in wishlist

  #Add to wishlist

  Scenario: WishList - Add an item from cart to wishlist
    Given I log into eStore as "addanitemfromcarttowishlist" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I add item to cart via API for estore
    When I open estore cart
    When I click on add to wishlist button from cart
    When I click on view wishlist button
    When I click on my account button if page is not loaded
    Then I validate items in wishlist


  Scenario: WishList - Remove item from wishlist
    Given I log into eStore as "removeitemfromwishlist" user
    When I choose country for eStore from footer
    When I open product page with "prod13800635" and "17050045" with "BLK" for estore
    When I click on my account button if page is not loaded
    When I click on add to wishlist button
    Then I verify that I'm able to remove wishlist from cart

#Logout

  Scenario: Logout
    Given I log into eStore as "checklogoutuser" user
    When I choose country for eStore from footer
    When I click on estore account
    When I click on estore signout button
    Then I verify that can logout without any issue

#Search

  Scenario: Search - Verify count of search result and product
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "towels" from search field
    Then I verify count of search results


  Scenario: Search - Verify the Back to top button
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "802-GRAM TURKISH TOWEL COLLECTION" from search field
    When I scroll to the bottom of the estore page
    When I click on estore back to top button


  Scenario: Search - Verify the in stock facet selection and in stock product
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I go to estore item "sofa" from search field
    Then I verify in stock facet selection


  Scenario: Search - Place order: search with any key term, select high to low. navigate to first product PDP
    Given I log into eStore as "placeorderselecthightolow" user
    When I choose country for eStore from footer
    When I go to estore item "white and blue corner leather sofa" from search field
    When I select high to low for estore
    When I navigate for the first product PDP
    When I select size option on the PDP page
    When I select finish option on the PDP page
    When I click on add to cart estore button
    When I click on view cart estore button
    When I click on estore checkout button
    When I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed


  Scenario: Search - Place order: search with any key term, select Low to High. navigate to first product PDP
    Given I log into eStore as "placeordersearchwithanykey" user
    When I choose country for eStore from footer
    When I go to estore item "white and blue corner leather sofa" from search field
    When I select low to high for estore
    When I navigate for the first product PDP
    When I select size option on the PDP page
    When I click on add to cart estore button
    When I click on view cart estore button
    When I click on estore checkout button
    When I click on estore no thanks button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed


  Scenario: Verify the trade login and checkout
    Given I log into eStore as trade
    When I choose country for eStore from footer
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
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

#Contract
  Scenario: Verify the contract login and checkout
    Given I log into eStore as contract
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When I open product page with "prod14280116" and "17050045" with "STWL" for estore
    Then I chose the '1' line item selections one by one
    When I click on add to cart estore button
    And I click on view cart estore button
    When I click on estore checkout button
    When I fill estore shipping address
    When I click on same as estore shipping address checkbox
    When I click on continue to payment estore button
    When I click on continue with original address estore button
    When I remove payment method which was used earlier
    When I execute payment with credit card on estore
    When I click on a place estore order button
    Then I verify that estore thank you page is displayed

  #Return & Exchange
  Scenario: Return & Exchange
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    When I open product page with "prod19500002" and "17050045" with "STWL" for estore
    When user clicks on return policy link
    Then user verifies that user is redirected to a return policy page

  #Checkout in BC
  Scenario: Checkout in BC
    Given I log into eStore as "checkoutbc" user
    When I choose country for eStore from footer
    When I remove all items from estore cart
    When  I change the brand to "RH BABY & CHILD" for eStore
    When I open product page with "prod19500002" and "17050045" with "STWL" for estore
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

 #GuestHouse
#  Scenario: GuestHouse- Verify dinning room page
#    Given I go to estore guesthouse home page
#    When I click on the estore guesthouse dining room page
#    Then I verify that estore guesthouse dining room page is accessible
#
#  Scenario: GuestHouse - Verify Champagne Caviar bar page
#    Given I go to estore guesthouse home page
#    When I click on the estore Champagne Caviar bar page
#    Then I verify that estore Champagne Caviar bar page is displayed
#
#  Scenario: GuestHouse - Verify Guest rooms Suites page
#    Given I go to estore guesthouse home page
#    When I click on estore guest rooms suites page
#    Then I verify that estore guesthouse rooms suites page is displayed
#
#  Scenario: GuestHouse - Verify Rooftop pool page
#    Given I go to estore guesthouse home page
#    When I click on estore guesthouse rooftop pool page
#    Then I verify that estore guesthouse rooftop pool page is displayed


  Scenario: Verify Monogrammed products
    Given I log into eStore as "verifymonogramproducts" user
    When I choose country for eStore from footer
    When I open product page with "prod19500002" and "17050045" with "STWL" for estore
    Then I chose the '1' line item selections one by one
    When I click on add monogram checkbox
    When I choose monogram properties
    When I click on add to cart estore button
    When I click on view cart estore button
    Then I verify that monogram was added
    When I edit monogram
    Then I verify that monogram was edited
    When I refresh current estore page
    When I remove monogram
    Then I verify that monogram was removed


  Scenario: Verify user is able to edit Monogram product incart
    Given I log into eStore as "monogramproductincart" user
    When I choose country for eStore from footer
    When I open product page with "prod19500002" and "17050045" with "STWL" for estore
    When I click on add monogram checkbox from pdp on eStore
    When I add monogram to product on eStore
    Then I verify that monogram was added
    Then I verify that monogram was added for pdp on eStore
    #Then I verify that monogram was added
    When I click on add to cart estore button
    When I click on view cart estore button
    Then I verify monogram was added to cart for eStore
    And I verify that I'm able to edit monogram product in cart
