@estoreRegression
Feature: Estore Membership

  Scenario: eStore Membership
    Given I log into eStore as "regular"
    When I navigate to the member tab
    Then I validate membership title

  Scenario: eStore Membership renewal details
    Given I log into eStore as "regular"
    When I navigate to the member tab
    Then I validate membership details

  Scenario: eStore Membership Add to Cart button
    Given I log into eStore as "nonmember"
    When I navigate to the member tab
    When I goes to click on cart button from header
    Then I validate cart

  Scenario: eStore Link to Membership
    Given I log into eStore as "member"
    When I navigate to the member tab
    Then I validate membership details
    Then I validate email address field and link to membership button

  Scenario: eStore Membership details - Member User
    Given I log into eStore as "member"
    When I navigate to the member tab
    Then I validate membership details for member user

  Scenario: eStore Cancel Membership
    Given I log into eStore as "member"
    When I navigate to the member tab
    Then I validate membership details for member user
    When I click on cancel membership link
    Then I validate cancel membership content
