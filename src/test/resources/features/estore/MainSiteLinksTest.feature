@helloWorld @smoke @criticalpath @chandana
Feature:
	As a developer
    I want to be able to test main links and if each page has their correct title

Background:

Scenario: Site Links verify RH Landing Page
	Given I open the site "/"
#	 When I click on the element ".close"
	 Then I expect that the title is "RH"

Scenario: Site Links verify RH Modern Site
	Given the title is not "RH Modern"
	When I click RH Modern in the header
	Then I expect that the title is "RH Modern Homepage"
     And I expect page to not scroll horizontally

Scenario: Site Links verify RH Baby Site
	Given the title is not "RH Baby"
    When I click RH Baby & Child in the header
	Then  I expect that the title is "RH Baby & Child Homepage"
	#"RH Baby & Child Homepage - Baby Furniture, Luxury Baby and Children's Furnishings, Child and Baby Crib Bedding, Baby Cribs, Baby Registry"
    And I expect page to not scroll horizontally

Scenario: Site Links verify RH Teen
	Given the title is not "RH TEEN Homepage"
    When I click RH Teen in the header
	Then  I expect that the title is "RH TEEN Homepage"
    And I expect page to not scroll horizontally

Scenario: Site Links verify RH Ski House
	Given the title is not "SkiHouse | RH"
    When I click RH Ski House in the header
	Then  I expect that the title is "SkiHouse | RH"
    And I expect page to not scroll horizontally

Scenario: Site Links verify RH Beach House
	Given the title is not "BeachHouse | RH"
    When I click RH Beach House in the header
	Then  I expect that the title is "BeachHouse | RH"
    And I expect page to not scroll horizontally

Scenario: Site Links verify Outdoor
	Given the title is not "Outdoor | RH"
    When I click Outdoor in the header
	Then  I expect that the title is "Outdoor | RH"
    And I expect page to not scroll horizontally



