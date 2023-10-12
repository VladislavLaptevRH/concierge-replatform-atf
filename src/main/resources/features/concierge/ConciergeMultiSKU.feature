@conciergeMultiSKU
@conciergeTestRun
Feature: Multi SKU

 Scenario: Verify the multisku ID is showing up once the line item is configured and add to cart button is enabled
  Given I log into Concierge as "associate"
  When I choose country for concierge from footer
  When I remove all items from cart via UI
  When I go to concierge item 'prod9300694' from search field
  When I click on the first project search result with parameters 'prod9300694''m000000113569'
  Then I Verify that 'PDP title' is present
  Then I chose the '1' line item selections one by one
  Then I verify presence of MultiSKU


  Scenario: Verify that the ETA on PDP and cart are matching or should match with the latest ETA of the bundle components on cart page
   Given I log into Concierge as "associate"
   When I choose country for concierge from footer
   When I remove all items from cart via UI
   When I go to concierge item 'prod9300694' from search field
   When I click on the first project search result with parameters 'prod9300694''m000000113569'
   Then I Verify that 'PDP title' is present
   Then I chose the '1' line item selections one by one
   When I click on add to cart button
   When I click on view cart button
   Then I verify that availability, Delivery and returns messaging is displayed for "SO"


 Scenario: Verify the message Product Name should be shown on cart against every component of multisku
  Given I log into Concierge as "associate"
  When I choose country for concierge from footer
  When I remove all items from cart via UI
  When I go to concierge item 'prod9300694' from search field
  When I click on the first project search result with parameters 'prod9300694''m000000113569'
  Then I Verify that 'PDP title' is present
  Then I chose the '1' line item selections one by one
  When I click on add to cart button
  When I click on view cart button
  Then I verify product name in cart page


 Scenario: Verify user is able to place order with multisku
  Given I log into Concierge as "associate"
  When I choose country for concierge from footer
  When I remove all items from cart via UI
  When I go to concierge item 'prod9300694' from search field
  When I click on the first project search result with parameters 'prod9300694''m000000113569'
  Then I Verify that 'PDP title' is present
  Then I chose the '1' line item selections one by one
  When I click on add to cart button
  When I click on view cart button
  Then I verify product name in cart page
  When I choose order classification
  When I click on checkout button
  When I click on no thanks button
  When I choose client who is a "Non-Member"
  When I fill all fields from address screen
  When I continue to payment
  When I click on continue with original address button
  When I execute payment for "VI"
  And I verify that review screen is displayed
  When I click on a place order button
  Then I verify that confirmation order screen is displayed


 Scenario: Verify the interim copy "This item includes multiple components. Individual components will be listed in your cart" should show up above the lien item dropdowns and below the line item title
  Given I log into Concierge as "associate"
  When I choose country for concierge from footer
  When I remove all items from cart via UI
  When I go to concierge item 'prod9300694' from search field
  When I click on the first project search result with parameters 'prod9300694''m000000113569'
  Then I Verify that 'PDP title' is present
  Then I chose the '1' line item selections one by one
  Then I verify "This item includes multiple components. Individual components will be listed in your cart" is present


 Scenario: Verify the user is able to add the multisku to project
  Given I log into Concierge as "associate"
  When I choose country for concierge from footer
  When I remove all items from cart via UI
  When I go to concierge item 'prod9300694' from search field
  When I click on the first project search result with parameters 'prod9300694''m000000113569'
  Then I Verify that 'PDP title' is present
  Then I chose the '1' line item selections one by one
  When I click on add to project button
  When I click on go to project button
  Then I verify multiSKU added in project "prod9300694"
  Then I verify multiSKU added in project "m000000113569"


 Scenario: Verify the quantity added in PDP is matching with the quantity added on cart page
  Given I log into Concierge as "associate"
  When I choose country for concierge from footer
  When I remove all items from cart via UI
  When I go to concierge item 'prod9300694' from search field
  When I click on the first project search result with parameters 'prod9300694''m000000113569'
  Then I Verify that 'PDP title' is present
  Then I chose the '1' line item selections one by one
  When I click on add to cart button
  When I click on view cart button
  Then I verify product count in cart page


 Scenario: Verify the quantity added in PDP is matching with the quantity added on project pop up and project page
  Given I log into Concierge as "associate"
  When I choose country for concierge from footer
  When I remove all items from cart via UI
  When I go to concierge item 'prod9300694' from search field
  When I click on the first project search result with parameters 'prod9300694''m000000113569'
  Then I Verify that 'PDP title' is present
  Then I chose the '1' line item selections one by one
  When I click on add to project button
  When I click on go to project button
  Then I verify product count in project page