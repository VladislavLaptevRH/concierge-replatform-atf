@estoreTestRun
@estoreProdTest

Feature: Estore Production Test

  Scenario Outline: Verify homepage
	Given I log into eStore as "prod" user
	When I choose country "<country>" for eStore from footer
	Then I verify that hamburger icon is displayed for the main menu
	Then I verify that cart page icon is displayed
	Then I verify that my account icon is displayed
	Then I verify that home page load will all sections and links
	Then I verify that footer section should show at the bottom of the page along with copy right and year
	Then I Verify list of Navigation bars
	Then I click on search Icon
	Then I Type product name "<productname>"
	Then verify users is taken to search result page
	Examples:
	  | productname |
	  | towels      |
	  | sofa        |
	  | tables      |
	Examples:
	  | country |
	  | US      |
	  | CA      |
	  | GB      |

  Scenario Outline: Verify CG
	Given I log into eStore as "prod" user
	When I choose country "<country>" for eStore from footer
	When I click on "Living" for estore
	When I click on "Fabric Seating" for estore
	When I click on "Seating Collections" for estore
	Then I verify that the CG title on the top left corner of the page
	Then I verify that the top navigation, logo, hamburger icon,search should be displayed
	Then I verify that cart and my account icons should be displayed
	Then I verify that by default the single grid view should be selected
	Examples:
	  | country |
	  | US      |
	  | CA      |
	  | GB      |

  Scenario Outline: Verify PG
	Given I log into eStore as "prod" user
	When I choose country "<country>" for eStore from footer
	When I go to estore item "sofa" from search field
	Then I verify that PG page is displayed with all filter options
	Examples:
	  | country |
	  | US      |
	  | CA      |
	  | GB      |

  Scenario Outline: Verify PDP
	Given I log into eStore as "prod" user
	When I choose country "<country>" for eStore from footer
	When I go to estore item "sofa" from search field
	Then I verify that PG page is displayed with all filter options
    Then I remember the name of the first product and regular, member prices in PG and navigate to that PDP
    Then I Verify that the PDP title is present and prices match those prices in PG
	Examples:
	  | country |
	  | US      |
	  | CA      |
	  | GB      |

  Scenario Outline: Verify that user is able to buy item for estore
	Given I log into eStore as "prod" user
	When I choose country "<country>" for eStore from footer
	When I remove all items from estore cart
	When I go to estore item "sofa" from search field
	Then I verify that PG page is displayed with all filter options
	Then I remember the name of the first product and regular, member prices in PG and navigate to that PDP
	Then I Verify that the PDP title is present and prices match those prices in PG
	When I click on add to cart estore button
	And I click on view cart estore button
	When I click on estore checkout button
	And I click on estore no thanks button
	When I fill estore shipping address
	When I click on same as estore shipping address checkbox
	When I click on continue to payment estore button
	When I click on continue with original address estore button
	Examples:
	  | country |
	  | US      |
	  | CA      |
	  | GB      |