#@concierge-All
#@concierge-PDP
#Feature: Concierge PDP
#
#  Scenario: Monogram
#    Given I log into Concierge as "associate"
#    When I remove all items from cart via UI
#    When I open product page with productId "prod19500002"
#    When I click on add monogram checkbox from pdp
#    When I choose monogram properties for pdp
#    Then I verify that monogram was added for pdp
#
#  Scenario: In stock
#    Given I log into Concierge as "associate"
#    When I go to item "60450996 BLNL" from search field
#    When I click on view in stock items
#    Then I verify that in stock modal pop up is displayed
#
#  Scenario: On Sale
#    Given I log into Concierge as "associate"
#    When I go to item "10024887 WGRY" from search field
#    When I click on view sale items
#    Then I verify that on sale modal pop up is displayed
#
#  Scenario: Custom rugs
#    Given I log into Concierge as "associate"
#    When I choose "RH Teen" from brand menu
#    When I go to custom rugs
#    Then I verify that custom rugs are displayed
#
#  Scenario: Custom Jewelry
#    Given I log into Concierge as "associate"
#    When I choose "RH Teen" from brand menu
#    When I go to custom rugs
#    Then I verify that custom rugs are displayed
#
#  Scenario: Custom Windows
#    Given I log into Concierge as "associate"
#    When I click on windows from top menu
#    Then I verify that custom windows are displayed
#
#  Scenario: YAML carousel
#    Given I log into Concierge as "associate"
#    When I remove all items from cart via UI
#    When I open product page with productId "prod14900056"
#    Then I verify that YAML carousel is displayed
#
#  Scenario: Mattress Recycling Fee
#    Given I log into Concierge as "associate"
#    When I remove all items from cart via UI
#    When I go to item "10004670 NONE" from search field
#    Then I verify mattress recycling fee
#
#  Scenario: Replacement Items
#    Given I log into Concierge as "associate"
#    When I remove all items from cart via UI
#    When I go to item "10004670 NONE" from search field
#    Then I verify that check for replacements parts button is displayed
#    And I verify that replacements parts modal pop up is displayed
#
#  Scenario: Colorization
#    Given I log into Concierge as "associate"
#    When I remove all items from cart via UI
#    When I go to item "10115451 BWMR" from search field
#    When I click on special order fabrics
#    When I choose color from special order fabrics
#    Then I verify that color has been chosen
#
#  Scenario Outline: Availability, Delivery and Returns messaging for <items>
#    Given I log into Concierge as "associate"
#    When I remove all items from cart via UI
#    When I go to item "<skuID>" from search field
#    Then I verify that availability, Delivery and returns messaging is displayed for "<items>"
#    Examples:
#      | items | skuID         |
#      | SO    | 19970830 CTIC |
#      | BO    | 17050043 FOG  |
#
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
#
#  Scenario: Pricing - verify that price on PDP is the same as price from Cart page
#    Given I log into Concierge as "associate"
#    When I choose country for concierge from footer
#    When I remove all items from cart via UI
#    When I open product page with "prod1617188" and "63130001"
#    When I click on add to cart button
#    When I click on view cart button
#    Then I verify price in cart is the same as price on PDP page
#
#  Scenario: SLP (Swatch Landing Page)
#    Given I log into Concierge as "associate"
#    When I choose country for concierge from footer
#    When I go to Swatch Landing Page
#    Then I verify that swatch landing page is displayed