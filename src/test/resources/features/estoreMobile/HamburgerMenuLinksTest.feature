@smoke @criticalpath @mobile
Feature:
    As a developer
    I want to be able to test other links on hamburger menu

    Background:

    Scenario: Links verify Rh Interior Design page
        Given I open the site "/" on mobile
        When I click on the hamburger menu, scroll and select Rh Galleries on mobile
        Then I expect that the title is "DesignGalleries | RH" on mobile
        Then I dismiss the membership popup if exists
        When I click on the hamburger menu, scroll and select Rh Interior Design on mobile
        Then I expect that the title is "Design Atelier | RH" on mobile

    Scenario: Links verify RH Galleries page
        Given the title is not "GalleriesLocator | RH" on mobile
        When I click on the hamburger menu, scroll and select Rh Galleries on mobile
        Then I expect that the title is "DesignGalleries | RH" on mobile
        #And I expect page to not scroll horizontally

    Scenario: Links verify RH Restaurants
        Given the title is not "RHRestaurants | RH" on mobile
        When I click on the hamburger menu, scroll and select Rh Restaurants on mobile
        Then  I expect that the title is "RHRestaurants | RH" on mobile
        And I expect page to not scroll horizontally


