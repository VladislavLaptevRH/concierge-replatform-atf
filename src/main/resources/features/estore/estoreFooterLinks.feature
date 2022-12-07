@estoreRegression
@estoreCGPage
Feature: Footer Links

  Scenario Outline: Verify footer resources section links
    Given I log into eStore as "regular"
    Then I verify that I'm able to access "<link>"
    Examples:
      | link                  |
      | LOCATE A GALLERY      |
      | VIEW SOURCE BOOKS     |
      | REQUEST A SOURCE BOOK |
      | SIGNUP FOR EMAILS     |
      | RH MEMBERS PROGRAM    |
      | RH TRADE              |
      | RH CREDIT CARD        |
      | SITE MAP              |

  Scenario Outline: Verify footer customer experience links
    Given I log into eStore as "regular"
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
    Given I log into eStore as "regular"
    Then I verify that I'm able to access "<link>"
    Examples:
      | link    |
      | LETTERS FROM THE CEO |
      | LEADERSHIP TEAM      |
      | INVESTOR RELATIONS   |
      | PRESS                |
      | CAREERS |

  Scenario Outline: Verify legal links
    Given I log into eStore as "regular"
    Then I verify that I'm able to access "<link>"
    Examples:
      | link                 |
      | PRIVACY              |
      | TERMS OF USE         |
      | TEXT MESSAGING TERMS |
      | RH IN CANADA         |
      | SAFETY RECALLS       |