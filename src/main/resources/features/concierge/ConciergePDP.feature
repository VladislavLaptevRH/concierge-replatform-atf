@concierge-All
@concierge-PDP
Feature: Concierge PDP

  Scenario: Verify Monogram functionality
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I open product page with productId "prod19500002"
    When I click on add monogram checkbox from pdp
    When I choose monogram properties for pdp
    Then I verify that monogram was added for pdp

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

  Scenario: Custom rugs
    Given I log into Concierge as "associate"
    When I choose "RH Teen" from brand menu
    When I go to custom rugs
    Then I verify that custom rugs are displayed

  Scenario: Custom Jewelry
    Given I log into Concierge as "associate"
    When I choose "RH Teen" from brand menu
    When I go to custom rugs
    Then I verify that custom rugs are displayed

  Scenario: Custom Windows
    Given I log into Concierge as "associate"
    When I click on windows from top menu
    Then I verify that custom windows are displayed

  Scenario: Verify YAML Carousel
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I open product page with productId "prod14900056"
    Then I verify that YAML carousel is displayed

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

  Scenario: Replacement Items
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I go to item "10004670 NONE" from search field
    Then I verify that check for replacements parts button is displayed
    And I verify that replacements parts modal pop up is displayed

  Scenario: Verify Colorization options
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I go to item "10115451 BWMR" from search field
    When I click on special order fabrics
    When I choose color from special order fabrics
    Then I verify that color has been chosen

  Scenario Outline: Availability, Delivery and Returns messaging for <items>
    Given I log into Concierge as "associate"
    When I remove all items from cart via UI
    When I go to item "<skuID>" from search field
    Then I verify that availability, Delivery and returns messaging is displayed for "<items>"
    Examples:
      | items | skuID         |
      | SO    | 19970830 CTIC |
      | BO    | 17050043 FOG  |

  Scenario: ATC SPO - add to cart
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "10105809 BWDV" from search field
    When I click on add to cart button
    When I click on agree&add button
    When I click on view cart button
    Then I verify that availability, Delivery and returns messaging is displayed for "SO"

  Scenario: ATC BO - add to cart
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I go to item "10060297 CLR" from search field
    When I click on add to cart button
    When I click on view cart button
    Then I verify that availability, Delivery and returns messaging is displayed for "BO"

  Scenario: Pricing - verify that price on PDP is the same as price from Cart page
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I open product page with "prod1617188" and "63130001"
    When I click on add to cart button
    When I click on view cart button
    Then I verify price in cart is the same as price on PDP page

  Scenario: SLP (Swatch Landing Page)
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to Swatch Landing Page
    Then I verify that swatch landing page is displayed