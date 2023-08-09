@estoreTestRun

Feature: Estore Guest house

  Scenario: Verify dinning room page

    Given I go to estore guesthouse home page
    When I choose country for eStore from footer
    When I click on the estore guesthouse dining room page
    Then I verify that estore guesthouse dining room page is accessible

  Scenario: Verify Champagne Caviar bar page
    Given I go to estore guesthouse home page
    When I choose country for eStore from footer
    When I click on the estore Champagne Caviar bar page
    Then I verify that estore Champagne Caviar bar page is displayed

  Scenario: Verify Guest rooms Suites page

    Given I go to estore guesthouse home page
    When I choose country for eStore from footer
    When I click on estore guest rooms suites page
    Then I verify that estore guesthouse rooms suites page is displayed

  Scenario: Verify Rooftop pool page
    Given I go to estore guesthouse home page
    When I choose country for eStore from footer
    When I click on estore guesthouse rooftop pool page
    Then I verify that estore guesthouse rooftop pool page is displayed
