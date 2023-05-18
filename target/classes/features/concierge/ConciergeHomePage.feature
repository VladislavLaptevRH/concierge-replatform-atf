@concierge-All
@concierge-HomePage
Feature:Concierge Homepage

  Scenario: Login as associate and Verify that home page is accessible
    Given I log into Concierge as "associate"
    Then  I expect that I am on the Concierge Dashboard page

  Scenario Outline: Verify top menu navigation

    Given I log into Concierge as "associate"
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

  Scenario Outline: Verify the logo on "<brand>" brand
    Given I log into Concierge as "associate"
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

  Scenario Outline: Verify brand dropdown
    Given I log into Concierge as "associate"
    Then  I change the brand to "<brand>"
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

  Scenario Outline: Footer links
    Given I log into Concierge as "associate"
    Then I verify footer links for "<links>"
    Examples:
      | links     |
      | RH.COM    |
      | DASHBOARD |
      | PROJECTS  |
      | REGISTRY  |

  Scenario: Verify homepage content
    Given I log into Concierge as "associate"
    Then  I expect that I am on the Concierge Dashboard page
    Then I verify the username
    Then I verify the gallery
    Then I verify the logo
    Then I verify project button
    Then I Verify search leans
    Then I verify user icon
    Then I verify cart
    Then I verify brand is button
    Then I verify main menu
    Then I verify page label
    Then I verify button "RH Orders" on homepage
    Then I verify button "Apply for RH Card" on homepage
    Then I verify button "RH card lookup" on homepage
    Then I verify button "Gift card enquiry" on homepage
    Then I verify button "RH.COM Profile" on homepage
    Then I verify search item field and search button

  Scenario: Change store number in concierge from dashboard
    Given I log into Concierge as "associate"
    When I change my store to number "10"
    Then I verify I see store Palo Alto in the header

  Scenario: Verify that all galleries are present in list
    Given I log into Concierge as "associate"
    When user clicks on gallery button from header
    Then user verifies list of galleries which have default value "5: Newport Beach"