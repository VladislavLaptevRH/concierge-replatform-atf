@criticalpath @mobile
Feature:
    As a developer
    I want to be find chat window on Homepage

    Background:

    Scenario: Chat availability on RH
        Given I open the site "/" on mobile
        And I dismiss the membership popup if exists
        When I click on the chat button on mobile
        Then I expect chat request window is opened
        And I close the chat window on mobile

    Scenario: Chat availability on MO
        Given the title is not "RH Modern" on mobile
        When I click on the hamburger menu and select RH Modern on mobile
        And I dismiss the membership popup if exists
        When I click on the chat button on mobile
        Then I expect chat request window is opened
        And I close the chat window on mobile

    Scenario: Chat availability on BC
        Given the title is not "RH Baby" on mobile
        When I click on the hamburger menu and select RH Baby & Child on mobile
        And I dismiss the membership popup if exists
        When I click on the chat button on mobile
        Then I expect chat request window is opened
        And I close the chat window on mobile

    Scenario: Chat availability on TN
        Given the title is not "RH TEEN"
        When I click on the hamburger menu and select RH Teen on mobile
        And I dismiss the membership popup if exists
        When I click on the chat button on mobile
        Then I expect chat request window is opened
        And I close the chat window on mobile

    Scenario: Chat availability on Swatch Landing page
        Given I open the site "/swatch/order.jsp" on mobile
        When I dismiss the membership popup if exists
        And I dismiss the swatch welcome popup if exists
        Then I expect chat button does not exist on mobile
