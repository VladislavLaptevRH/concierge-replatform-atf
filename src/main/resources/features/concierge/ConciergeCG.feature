@concierge-All
@concierge-CG
@conciergeCriticalPathTestRun
Feature: Concierge CG Page

  Scenario: Browser back button from search to CG page
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    Then I navigate to menu 'Windows'
    Then I navigate to sub menu 'Drapery'
    Then I navigate to gallery 'Drapery Collections'
    Then I verify that 'Back to top Button is present'
    Then I click 'Back to Top button'
    Then I verify that 'user is brought to the top of the page'
    Then I change the brand to "RH"
    Then I verify that RH Brand dropdown is present in "RH" home page
    Then I navigate to menu 'Bath'
    Then I navigate to sub menu 'Furniture'
    Then I navigate to gallery 'Bath Collections'
    Then I verify that 'Back to top Button is present'
    Then I click 'Back to Top button'
    Then I verify that 'user is brought to the top of the page'
    Then I change the brand to "RH INTERIORS"
    Then I verify that RH Brand dropdown is present in "IN" home page
    Then I navigate to menu 'Living'
    Then I navigate to sub menu 'Shelving & Cabinets'
    Then I navigate to gallery 'Cabinet Collections'
    Then I verify that 'Back to top Button is present'
    Then I click 'Back to Top button'
    Then I verify that 'user is brought to the top of the page'
    Then I change the brand to "RH OUTDOOR"
    Then I verify that RH Brand dropdown is present in "OD" home page
    Then I navigate to menu 'Textiles'
    Then I navigate to sub menu 'Pillows'
    Then I navigate to gallery 'Outdoor Pillow Collections'
    Then I verify that 'Back to top Button is present'
    Then I click 'Back to Top button'
    Then I verify that 'user is brought to the top of the page'
    Then I change the brand to "RH TEEN"
    Then I verify that RH Brand dropdown is present in "TN" home page
    Then I navigate to menu 'Furniture'
    Then I navigate to sub menu 'Lounge & Media'
    Then I navigate to gallery 'Lounge & Media Collections'
    Then I verify that 'Back to top Button is present'
    Then I click 'Back to Top button'
    Then I verify that 'user is brought to the top of the page'