@smoke @criticalpath @logoutConciergeAfter 
Feature:  
 I want to test the search functionality for the all the RH, RHBC,RHTEEN and RH Modern for the concierge user 

Background: 
	Given I login into Concierge with valid credentials for the store "146: West Hollywood" 
	
Scenario Outline:Concierge user can search by a search term for any given portal 
	Given I am on concierge dashboard for the store "146: West Hollywood" 
	Given I navigate to "<portal>" on concierge 
	When I enter the "<search term>" 
	Then I landed on the "search result" page 
	Then I see the products in the of the types "<search term>" 
	When I sort by "Price Low To High" and take the price on the first product on the list 
	When I sort by "Price High To Low" and take the price on the first product on the list 
	Then I verify price on the first product from "Price Low To High" sorting is less than from "Price High To Low" 
	Examples: 
		| portal        | search term |
		| RH            | CHAIR       |
		|RHBC           | TOWEL       |
		
Scenario Outline: Concierge user can search a sku for any given portal 
	Given I am on concierge dashboard for the store "146: West Hollywood" 
	Given I navigate to "<portal>" on concierge 
	When I enter the "<SKUs>" 
	Then I landed on the "PDP" page 
	Then I see "<SKUs>" in "PDP" page 
	Examples: 
		| portal        | SKUs |
		|RHBC           |  106012 GREY TWIN       |
		
Scenario Outline: Concierge user can search a quote for any given portal 
	Given I am on concierge dashboard for the store "146: West Hollywood" 
	When I click on "Quotes" button on "Dashboard" page 
	Then I landed on the "Quote Listing" page 
	When I search by "Client Email" for the email "<emailId>" in quote search 
	Then I verify column "ID, Client, Created By, Created On, Status, Amount" present on "Quote Listing" page 
	Examples: 
		| portal      | SKUs                    |emailId|
		| RH           |  106012 GREY TWIN       |aassociate@restorationhardware.com|
		
Scenario Outline:
Concierge user can search by a search term for any given portal and navigate for various categories 
	Given I am on concierge dashboard for the store "146: West Hollywood" 
	Given I navigate to "<portal>" on concierge 
	When I enter the "<search term>" 
	Then I landed on the "search result" page 
	Then I see the products in the of the types "<search term>" 
	When I click on refine search option with text "RH TEEN" 
	Then I see the products in the of the types "<search term>" 
	When I click on refine search option with text "RH BABY & CHILD" 
	Then I see the products in the of the types "<search term>" 
	When I click on refine search option with text "RH MODERN" 
	Then I see the products in the of the types "<search term>" 
	When I click on refine search option with text "RH BABY & CHILD" 
	Then I see the products in the of the types "<search term>" 
	When I click on refine search option with text "RH" 
	Then I see the products in the of the types "<search term>" 
	When I click on refine search option with text "RH BABY & CHILD" 
	Then I see the products in the of the types "<search term>" 
	When I click on "<category option>" category from left navigation 
	Then I see the products in the of the types "<search term>" 
	Examples: 
		| portal        | search term |category option|
		| RH            | TABLE       |FURNITURE |
