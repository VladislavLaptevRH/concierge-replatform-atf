Feature: Verify projects

  Scenario Outline: Verify that user is able to find project by <searchBy>
    Given I log into Concierge as "associate"
    When I click on projects button
    When I search project by provided "<searchBy>"
    Then I verify that search result is displayed
    Examples:
      | searchBy    |
      | projectName |
      | projectID   |
      | createdBy   |
      | editedBy    |

  Scenario Outline: Verify that user is able to find project by <pricingType>
    Given I log into Concierge as "associate"
    When I click on projects button
    When I search project by "<pricingType>"
    Then I verify that search result for pricing type is displayed
    Examples:
      | pricingType |
      | regular     |
      | member      |
      | trade       |

  Scenario Outline: Verify that user is able to create project for client - <businessClient>
    Given I log into Concierge as "associate"
    When I click on projects button
    When I click on new project button
    When I introduces "<businessClient>" first and last name
    When I introduces details for new project
    Then I verify that new project for <"businessClient"> was created
    Examples:
      | businessClient       |
      | member               |
      | nonmember            |
      | trade                |
      | unclassifiedBusiness |

  Scenario: Verify that user is able to move cart to project
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I choose client from header
    When I clicks on a random menu item
    When I clicks on o random item
    When I fill all options for item
    When I click on add to cart button
    When I click on move to project button
    When I choose project from move to project pop up
    When I click on save button
    Then I verify that projects screen is displayed

  Scenario: Verify project settings are available
    Given I log into Concierge as "associate"
    When I click on projects button
    When I search project by provided "projectName"
    When I click on the first project search result
    When I click on settings button
    Then I verify that project setting screen is displayed

  Scenario: Verify project list moodboard
    Given I log into Concierge as "associate"
    When I click on projects button
    When I search project by provided "projectName"
    When I click on the first project search result
    When I click on the moodboard button
    Then moodboard screen is displayed

  Scenario: Verify that user is able to add new space and edit
    Given I log into Concierge as "associate"
    When I click on projects button
    When I search project by provided "projectName"
    When I click on the first project search result
    When I click on settings button
    When I introduces space name
    When I click on add space button
    Then I verify that new space was created
    When I click on add space button

  Scenario: Verify that user is able to create new opportunity and add items
    Given I log into Concierge as "associate"
    When I click on projects button
    When I search project by provided "projectName"
    When I click on the first project search result
    When I click on add new opportunity button
    When I introduce opportunity name
    When I choose preferred contact method
    When I provide description for opportunity
    When I click on create opportunity button
    When I click on rh concierge logo
    When I go to item "112848 MULT" from search field
    And I select count of product
    When I add item to created opportunity
    Then I verify that item was added

  Scenario Outline: Verify email estimation - send to client verify the email address received and sent
    Given I log into Concierge as "associate"
    When I click on projects button
    When I search project by provided "projectName"
    When I click on the first project search result
    When I click on email estimate button from project screen
    When I introduces client email from email estimate pop up
    When I introduces email in send copies of this project to additional emails
    When I click on email estimate button
    Then I verify that the client received the letter on the "<email>"
    Examples:
      | email      |
      | client     |
      | additional |

  Scenario: Verify email estimation - send to bcc verify the email address received and sent
    Given I log into Concierge as "associate"
    When I click on projects button
    When I search project by provided "projectName"
    When I click on the first project search result
    When I click on email estimate button from project screen
    When I click on bcc associate checkbox
    When I introduces client email from email estimate pop up
    When I introduces email in send copies of this project to additional emails
    When I click on email estimate button
    Then I verify that the client received the letter on the "client"

  Scenario: Verify the Project list and switching between the projects -CART/PDP
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I choose client from header
    When I go to item "112848 MULT" from search field
    And I select count of product
    When I click on add to cart button
    When I click on move to project button
    Then I verify that project list is displayed

  Scenario: Verify the Opportunities list and switching between the opportunities -CART/PDP
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I choose client from header
    When I go to item "112848 MULT" from search field
    And I select count of product
    When I click on add to cart button
    When I click on move to project button
    Then I verify that opportunity list is displayed

  Scenario: Verify the Spaces list and switching between the Spaces -CART/PDP
    Given I log into Concierge as "associate"
    When I remove all items from cart
    When I choose client from header
    When I go to item "112848 MULT" from search field
    And I select count of product
    When I click on add to cart button
    When I click on move to project button
    Then I verify that spaces list is displayed











