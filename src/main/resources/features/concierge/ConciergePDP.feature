@concierge-All
@concierge-PDP
Feature: Concierge PDP

  Scenario: Verify the PDP title and pricing
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I navigate to "sofas"
    Then I remember the name of the first product and regular, member prices in PG and navigate to that PDP
    Then I Verify that the PDP title is present and prices match those prices in PG

  Scenario: Verify the content of PDP for Concierge
    Given I log into Concierge as "associate"
    When I go to item "37730826 LLCG" from search field
    Then I Verify that "PDP title is present" is present

  Scenario: Verify the PDP hero Image, zoom, line items

  Scenario: Verify In Stock functionality
    Given I log into Concierge as "associate"
    When I go to item "60450996 BLNL" from search field
    When I click on "view in stock items" link
    Then Verify that "In Stock modal" 'opens'
    Then Verify that "In Stock modal" 'has title'
    Then Verify that "In Stock modal" 'has item#'
    Then Verify that "In Stock modal" 'has price and member price'
    Then Verify that "In Stock modal" 'has qty dropdown'
    Then Verify that "In Stock modal" 'has "add to cart" and "add to project" buttons'
    Then Verify that "In Stock modal" 'has an item can be added to cart from modal'
    Then Verify that "In Stock modal" 'has an item can be added to project from modal'

  Scenario: Verify On Sale functionality
    Given I log into Concierge as "associate"
    When I go to item "60450996 BLNL" from search field
    When I click on "view select items on sale" link
    Then Verify that "Sale modal" 'opens'
    Then Verify that "Sale modal" 'has title'
    Then Verify that "Sale modal" 'has item#'
    Then Verify that "Sale modal" 'has price, member and sale price'
    Then Verify that "Sale modal" 'has qty dropdown'
    Then Verify that "Sale modal" 'has "add to cart" and "add to project" buttons'
    Then Verify that "Sale modal" 'has an item can be added to cart from modal'
    Then Verify that "Sale modal" 'has an item can be added to project from modal'

  Scenario Outline: Availability, Delivery and Returns messaging for <items>
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I go to item "<skuID>" from search field
    Then I verify that availability, Delivery and returns messaging is displayed for "<items>"
    Examples:
      | items | skuID         |
      | SO    | 19970830 CTIC |
      | BO    | 17050043 FOG  |

  Scenario: Verify the dropdown selection and add to cart

  Scenario: Verify Colorization options
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I go to item "10115451 BWMR" from search field
    When I click on special order fabrics
    When I choose color from special order fabrics
    Then I verify that color has been chosen

  Scenario: Verify Monogram functionality
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I open product page with productId "prod19500002"
    When I click on add monogram checkbox from pdp
    When I choose monogram properties for pdp
    Then I verify that monogram was added for pdp

  Scenario: Add To Cart (Instock, SPO, BO) functionality

#  Scenario: ATC SPO - add to cart
#    Given I log into Concierge as "associate"
#    When I choose country for concierge from footer
#    When I remove all items from cart via UI
#    When I go to item "10105809 BWDV" from search field
#    When I click on add to cart button
#    When I click on agree&add button
#    When I click on view cart button
#    Then I verify that availability, Delivery and returns messaging is displayed for "SO"
#
#  Scenario: ATC BO - add to cart
#    Given I log into Concierge as "associate"
#    When I choose country for concierge from footer
#    When I remove all items from cart via UI
#    When I go to item "10060297 CLR" from search field
#    When I click on add to cart button
#    When I click on view cart button
#    Then I verify that availability, Delivery and returns messaging is displayed for "BO"

  Scenario: Verify Custom Drapery PDP
    Given I log into Concierge as "associate"
    When I choose "RH Teen" from brand menu
    When I go to custom rugs
    Then I verify that custom rugs are displayed

  Scenario: Verify YAML Carousel
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I open product page with productId "prod14900056"
    Then I verify that YAML carousel is displayed

  Scenario: SLP (Swatch Landing Page)
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to Swatch Landing Page
    Then I verify that swatch landing page is displayed

  Scenario: Verify the Postal code updates in PDP

  Scenario: Sale PDP: Regular/Member/Final Price validation

  Scenario Outline: Verify Mattress Recycling Fee
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I go to item "10004670 NONE" from search field
    When I change state for "<state>" with zip code "<zipCode>"
    Then I verify that text ""<state>" requires a mattress recycling fee to be collected at checkout state" is present in PDP
    When I click on add to cart button
    When I click on view cart button
    Then I verify text "Mattress fee" and amount in checkout is present for state "<state>"
    Examples:
      | state | zipCode|
      | CA    | 94925  |
      | RI    | 02860  |
      | CT    | 06902  |

  Scenario: Custom Jewelry
    Given I log into Concierge as "associate"
    When I choose "RH Teen" from brand menu
    When I go to custom rugs
    Then I verify that custom rugs are displayed

  Scenario: Custom Windows
    Given I log into Concierge as "associate"
    When I click on windows from top menu
    Then I verify that custom windows are displayed

  Scenario: Replacement Items
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I go to item "10004670 NONE" from search field
    Then I verify that check for replacements parts button is displayed
    And I verify that replacements parts modal pop up is displayed