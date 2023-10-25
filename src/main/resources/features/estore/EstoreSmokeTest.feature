@estoreTestRun
@Smoke @SmokeTest

Feature: SmokeTest for eStore

  Scenario: Top Nav Check in RH
	Given I log into eStore as "regular" user
	When I choose country for eStore from footer
	Then I Verify list of Navigation bars
	Then I validate each cat and sub-cat for eStore
	When I click on RH dropdown
	Then I verify RH dropdown and list of brand names
	When I click on Hamburger menu
	Then I verify list of items in hamburger menu

  Scenario: Basic search functionality, PG check
	Given I log into eStore as "regular" user
	When I choose country for eStore from footer
	When I go to estore item "white and blue corner leather sofa" from search field
	Then I verify that search results for "white and blue corner leather sofa" is displayed
	When I change a grid view from default 3 grid view to 2 grid view
	Then I verify that two grids are default view in PG

  Scenario: Add to Cart and proceed to Payment page
	Given I log into eStore as "regular" user
	When I choose country for eStore from footer
	When I remove all items from estore cart
	When I open product page with "prod2020027" and "17050043" with "CHAR" for estore
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
