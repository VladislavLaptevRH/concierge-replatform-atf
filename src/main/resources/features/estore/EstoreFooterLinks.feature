@estoreTestRun
@estoreFooterLinks

Feature: Footer Links

  Scenario Outline: Verify footer resources section links
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then I verify that I'm able to access "<link>"
    Examples:
      | link                  |
      | LOCATE A GALLERY      |
      | VIEW SOURCE BOOKS     |
      | REQUEST A SOURCE BOOK |
      | RH MEMBERS PROGRAM    |
      | RH TRADE              |
      | RH CREDIT CARD        |
      | SITE MAP              |

  Scenario Outline: Verify footer customer experience links
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then I verify that I'm able to access "<link>"
    Examples:
      | link                |
      | CONTACT US          |
      | PLACING AN ORDER    |
      | SHIPPING & DELIVERY |
      | RETURNS & EXCHANGES |
      | RH GIFT CARD        |
      | GIFT REGISTRY       |
      | FAQS                |

  Scenario Outline: Verify our company
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then I verify that I'm able to access "<link>"
    Examples:
      | link                 |
      | LETTERS FROM THE CEO |
      | LEADERSHIP TEAM      |
      | INVESTOR RELATIONS   |
      | PRESS                |
      | CAREERS              |

  Scenario Outline: Verify legal links
    Given I log into eStore as "regular" user
    When I choose country for eStore from footer
    Then I verify that I'm able to access "<link>"
    Examples:
      | link                 |
      | PRIVACY              |
      | TERMS OF USE         |
      | TEXT MESSAGING TERMS |
      | RH IN CANADA         |
      | SAFETY RECALLS       |

  Scenario: Verify the country dropdown.
    Given I log into eStore as "regular" user
    When I scroll to bottom of Home Page
    Then I verify country dropdown form footer

  Scenario: Verify the copyright icon and year.
    Given I log into eStore as "regular" user
    When I scroll to bottom of Home Page
    Then I verify the copyright icon and year