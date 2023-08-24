@concierge-All
@concierge-HomePage
Feature:Concierge Homepage

  Scenario: Login as associate and Verify that home page is accessible
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then  I expect that I am on the Concierge Dashboard page

  Scenario Outline: Verify Top Nav is present, clickable and responsive in HPs of all brands
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then  I change the brand to "<brand>"
    Then User verifies that all items from menu are displayed for "<brand>"
    Examples:
      | brand |
      | RH    |
      |RH CONTEMPORARY|
      |RH INTERIORS   |
      |RH MODERN      |
      |RH OUTDOOR     |
      |RH BEACH HOUSE |
      |RH SKI HOUSE   |
      |RH BABY & CHILD|
      |RH TEEN        |

  Scenario Outline: Verify Logo is present in HPs of all brands
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then  I change the brand to "<brand>"
    Then I verify the logo
    Examples:
      |brand|
      |RH|
      |RH CONTEMPORARY|
      |RH INTERIORS   |
      |RH MODERN      |
      |RH OUTDOOR     |
      |RH BEACH HOUSE |
      |RH SKI HOUSE   |
      |RH BABY & CHILD|
      |RH TEEN        |

  Scenario Outline: Verify Brand Dropdown is present and functional in HPs of all brands
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I change the brand to "<brand>"
    Then I verify that RH Brand dropdown is present in "<currentBrandName>" home page
    Examples:
      |brand          |currentBrandName|
      |RH             |RH              |
      |RH CONTEMPORARY|CN              |
      |RH INTERIORS   |IN              |
      |RH MODERN      |MO              |
      |RH OUTDOOR     |OD              |
      |RH BEACH HOUSE |BH              |
      |RH SKI HOUSE   |SH              |
      |RH BABY & CHILD|BC              |
      |RH TEEN        |TN              |

  Scenario Outline: Verify the Footer links are present and clickable in HPs
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I change the brand to "<brand>"
    Then I verify footer links for brand "<brand>"
    Examples:
      | brand |
      | RH    |
      |RH CONTEMPORARY|
      |RH INTERIORS   |
      |RH MODERN      |
      |RH OUTDOOR     |
      |RH BEACH HOUSE |
      |RH SKI HOUSE   |
      |RH BABY & CHILD|
      |RH TEEN        |

  Scenario: Verify the content for the HP for Concierge
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
    Then I verify button "RH card lookup" on homepage
    Then I verify button "Gift card enquiry" on homepage
    Then I verify button "RH.COM Profile" on homepage
    Then I verify search item field and search button

  Scenario: Change store number in concierge from dashboard
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I change my store to number "10"
    Then I verify I see store Palo Alto in the header

  Scenario: Verify that all galleries are present in list
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When user clicks on gallery button from header
    Then user verifies list of galleries which have default value "5: Newport Beach"