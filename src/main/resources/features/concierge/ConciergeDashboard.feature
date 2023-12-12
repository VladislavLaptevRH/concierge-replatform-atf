@conciergeDashboard
@conciergeTestRun

Feature:Concierge Dashboard

  Scenario Outline: Brand dropdown for US and CAD
    Given I log into Concierge as "associate"
    When I choose "US" country
    Then  I change the brand to "<brand>"
    When I choose "CA" country
    Then  I change the brand to "<brand>"
    Examples:
      | brand           |
      | RH              |
      | RH CONTEMPORARY |
      | RH INTERIORS    |
      | RH MODERN       |
      | RH OUTDOOR      |
      | RH BEACH HOUSE  |
      | RH SKI HOUSE    |
      | RH BABY & CHILD |
      | RH TEEN         |

  Scenario Outline: Verify top-nav, logo for all brands
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then  I change the brand to "<brand>"
    Then I verify the logo
    #Then User verifies that all items from menu are displayed for "<brand>"
    Examples:
      | brand           |
      | RH              |
      | RH CONTEMPORARY |
      | RH INTERIORS    |
      | RH MODERN       |
      | RH OUTDOOR      |
      | RH BEACH HOUSE  |
      | RH SKI HOUSE    |
      | RH BABY & CHILD |
      | RH TEEN         |

  Scenario Outline: Footer links
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I change the brand to "<brand>"
    Then I verify footer links for brand "<brand>"
    Examples:
      | brand           |
      | RH              |
      | RH CONTEMPORARY |
      | RH INTERIORS    |
      | RH MODERN       |
      | RH OUTDOOR      |
      | RH BEACH HOUSE  |
      | RH SKI HOUSE    |
      | RH BABY & CHILD |
      | RH TEEN         |

  Scenario: Homepage content
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I expect that I am on the Concierge Dashboard page
    Then I verify the username
    Then I verify the gallery
    Then I verify the logo
    Then I verify project button
    Then I Verify search leans
    Then I verify user icon
    Then I verify cart
    Then I verify flag icon for country selection
    Then I verify top nav
    Then I verify brand dropdown
    Then I verify page label
    Then I verify button "RH Orders" on homepage
    Then I verify button "Apply for RH Card" on homepage
    Then I verify button "RH Card lookup" on homepage
    Then I verify button "Gift card enquiry" on homepage
    Then I verify button "RH.COM Profile" on homepage
    Then I verify search item field and search button

  Scenario: Flags (Country Dropdown) : Verify switching between the Countries
    Given I log into Concierge as "associate"
    Then I choose "US" country
    Then I choose "CA" country
    Then I choose "GB" country

  Scenario: Verify Projects,cart,Search icon,Client Icon,Associate Name,Gallery Location in Top nav
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I expect that I am on the Concierge Dashboard page
    Then I verify the username
    Then I verify the gallery
    Then I verify the logo
    Then I verify project button
    Then I Verify search leans
    Then I verify user icon
    Then I verify cart
    Then I verify flag icon for country selection
    Then I verify top nav
    Then I verify brand dropdown


  Scenario: Verify user able to change gallery location
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I change my store to number "10"
    Then I verify I see store Palo Alto in the header


  Scenario: Verify Associate Signout button :User should be able to view the last accessed page after Signing again
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu "Living"
    Then I navigate to sub menu "Office"
    Then I navigate to gallery "Office Collections"
    Then I verify that 'grid view is present on top right' on CG screen
    When I sign out

