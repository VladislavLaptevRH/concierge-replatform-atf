@conciergeTestRun
Feature:Concierge Back Button

  Scenario: Verify that Search any product from home page and verify for back button
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click on search Icon
	When I type item name 'table'
	Then I verify that 'PG Search Page has title (TABLE) and text "Results" and "Sort" are present' on search page
	When I click browser back button
	Then I expect that I am on the Concierge Dashboard page


  Scenario: Verify that Search any product from CG and verify for back button
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	Then I navigate to menu 'Living'
	Then I navigate to sub menu 'Shelving & Cabinets'
	Then I navigate to gallery "Cabinet Collections"
  	Then I verify that 'grid view is present on top right' on CG screen
	When I click on search Icon
	When I type item name 'table'
	Then I verify that 'PG Search Page has title (TABLE) and text "Results" and "Sort" are present' on search page
	When I click browser back button
	Then I verify that 'grid view is present on top right' on CG screen


  Scenario: Verify that Search any product from PG and verify for back button
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I click on search Icon
	When I type item name 'table'
	Then I verify that 'PG Search Page has title (TABLE) and text "Results" and "Sort" are present' on search page
	When I click on search Icon
	When I type item name 'sofa'
	Then I verify that 'PG Search Page has title (SOFA) and text "Results" and "Sort" are present' on search page
	When I click browser back button
	Then I verify that 'PG Search Page has title (TABLE) and text "Results" and "Sort" are present' on search page


  Scenario: Verify that Search any product from PDP and verify for back button
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I remove all items from cart via UI
	When I navigate to "sofas"
	Then I remember the name of the first product and regular, member prices in PG and navigate to that PDP
	Then I Verify that the PDP title is present and prices match those prices in PG
	When I click on search Icon
	When I type item name 'table'
	Then I verify that 'PG Search Page has title (TABLE) and text "Results" and "Sort" are present' on search page
  	When I click browser back button
	Then I remember the name of the first product and regular, member prices in PG and navigate to that PDP
	Then I Verify that the PDP title is present and prices match those prices in PG


  Scenario: Verify that Search any product from cart page and verify for back button
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	When I remove all items from cart via UI
	When I add item to cart via API with "10146709 LOAK" and quantity '1'
	When I open cart
	Then I verify all the sums on the cart page
	When I click on search Icon
	When I type item name 'table'
	Then I verify that 'PG Search Page has title (TABLE) and text "Results" and "Sort" are present' on search page
	When I click browser back button
	Then I verify all the sums on the cart page


  Scenario: Verify that Search any product and change the grid layout to big and small and navigate to any PDP. Verify the back button. User should be able to view the same selected big OR small grid layout
	Given I log into Concierge as "associate"
	When I choose country for concierge from footer
	Then I navigate to menu 'Dining'
	Then I navigate to sub menu 'Seating'
	Then I navigate to gallery 'Leather Seating'
	Then I verify that 'Grid View is present in top right' on PG screen
	Then I verify that 'grid view is set to 3-grid view' on PG screen
	Then I Change the PG Grid view to '2' - grid view and confirm changing
	Then I click 'first product from the list' on PG screen
	When I click browser back button
	Then I verify that 'grid view is set to 2-grid view' on PG screen
