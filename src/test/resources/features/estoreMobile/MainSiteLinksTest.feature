@helloWorld @criticalpath @mobile @monitor
Feature:
    As a developer
    I want to be able to test brand/site links are clickable on hamburger menu and if each page has their correct title

    Scenario: Site Links verify RH Landing Page
        Given I open the site "/" on mobile
        Then I expect that the title is "RH" on mobile
        Then I dismiss the membership popup if exists

    Scenario: Site Links verify RH Modern Site
        Given I open the site "/" on mobile
        When I click on the hamburger menu and select RH Modern on mobile
        Then I expect the url to contain "rhmodern"

    Scenario: Site Links verify RH Baby Site
        Given I open the site "/" on mobile
        When I click on the hamburger menu and select RH Baby & Child on mobile
        Then I expect the url to contain "rhbabyandchild"
   
    Scenario: Site Links verify RH Teen
        Given I open the site "/" on mobile
        When I click on the hamburger menu and select RH Teen on mobile
        Then I expect the url to contain "rhteen"