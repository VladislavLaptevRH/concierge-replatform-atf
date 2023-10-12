@conciergeTestRun
@conciergeProject
Feature: Concierge Project

  Scenario Outline: Availability, Delivery and Returns messaging for Instock, BO, SPO, SPO Instock Items
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "availabilitydeliveryreturnsmessaging" by provided "projectName"
    When I click on the first project search result
    Then I verify that availability, Delivery and Returns messaging for "<items>" is displayed
    #Need test data for stg4 - project
    Examples:
      | items    |
      | SPO      |
      | In stock |
#      | SPO In stock Items |
#      | BO                |

  Scenario: Verify the Projects load for a logged in associate
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    Then I verify that search result is displayed

  Scenario Outline: Verify that user is able to find project by <searchBy>
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "test" by provided "<searchBy>"
    Then I verify that search result is displayed
    Examples:
      | searchBy    |
      | projectName |
      | projectID   |
      | createdBy   |
      | editedBy    |

  Scenario Outline: Verify that user is able to find project by pricing type - <pricingType>
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project by "<pricingType>"
    Then I verify that search result for pricing type is displayed
    Examples:
      | pricingType |
      | regular     |
      | member      |
      | trade       |

#   Works only for prodsupport
  Scenario Outline: Verify that user is able to create project for client - <businessClient>

    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    When I click on new project button
    When I introduces "<businessClient>" first and last name
#    When I introduces details for new project
    Then I verify that new project for <"businessClient"> was created
    Examples:
      | businessClient       |
      | member               |
      | nonmember            |
      | trade                |
      | unclassifiedBusiness |

  Scenario: Verify project settings are available
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "test" by provided "projectName"
    When I click on the first project search result
    When I click on settings button
    Then I verify that project setting screen is displayed

  Scenario: Verify project list moodboard
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "test" by provided "projectName"
    When I click on the first project search result
    When I click on the moodboard button
    Then moodboard screen is displayed

  Scenario: Verify that user is able to add new space and edit
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "test" by provided "projectName"
    When I click on the first project search result
    When I click on settings button
    When I introduces space name
    When I click on add space button
    Then I verify that new space was created
    When I click on add space button

  Scenario: Verify that user is able to create new opportunity and add items
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "test" by provided "projectName"
    When I click on the first project search result
    Then I click on remove button from project
    When I click on add new opportunity button
    When I introduce opportunity name
    When I choose preferred contact method
    When I click on create opportunity button
    When I click on rh concierge logo
    When I go to item "63130001" from search field
    Then I chose the '1' line item selections one by one
    And I select count of product
    When I add item to created opportunity
    When I click on save button
    Then I verify that item was added
    Then I click on remove button from project

  Scenario Outline: Verify email estimation - send to client verify the email address received and sent for <email>

    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "modifyitemsoptions" by provided "projectName"
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
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "modifyitemsoptions" by provided "projectName"
    When I click on the first project search result
    When I click on email estimate button from project screen
    When I click on bcc associate checkbox
    When I introduces client email from email estimate pop up
    When I introduces email in send copies of this project to additional emails
    When I click on email estimate button
    Then I verify that the client received the letter on the "client"

  Scenario Outline: Verify the Project list and switching between the projects -CART/PDP
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart
    When I go to item "<skuid>" from search field
    Then I chose the '1' line item selections one by one
    And I select count of product
    When I click on add to cart button
    When I click on view cart button
    When I click on move to project button
    Then I verify that project list is displayed
    Examples:
      | skuid    |
      | 63130001 |

  Scenario: Verify the Opportunities list and switching between the opportunities -CART/PDP
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart
    When I go to item "63130001" from search field
    Then I chose the '1' line item selections one by one
    And I select count of product
    When I click on add to cart button
    When I click on view cart button
    When I click on move to project button
    Then I verify that opportunity list is displayed

  Scenario: Verify the Spaces list and switching between the Spaces -CART/PDP
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I open product page with "prod1617188" and "63130001"
    Then I chose the '1' line item selections one by one
    When I click on add to cart button
    When I click on view cart button
    When I click on move to project button
    Then I verify that spaces list is displayed

  Scenario: Verify that user is able to update item option
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "modifyitemsoptions" by provided "projectName"
    When I click on the first project search result
    When I click on edit options button for update item
    When I choose color from option
    Then verify that color was changed

  Scenario: Verify that user is able to update item quantity
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "subototalforecastupdatingqty" by provided "projectName"
    When I click on the first project search result
    When I click on edit options button
    When I choose quantity for item from project
    Then verify that quantity for item was changed

  Scenario: Verify that user is able to remove items from project
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart
    When I go to item "63130001" from search field
    Then I chose the '1' line item selections one by one
    And I select count of product
    When I click on add to project button
    And I choose project by project name "removeitemsfromproject"
    When I click on save button
    When I click on go to project button
    When I click on remove button from project for added item
    Then I verify that item was removed

  Scenario: Verify price override for item from project
    Given I log into Concierge as "leader"
    When I choose country for concierge from footer
    When I remove all items from cart
    When I click on projects button
    When I search project "overridePrice" by provided "projectName"
    When I click on the first project search result
    Then I click on remove button from project
    When I click on rh concierge logo
    And I remove client from header
    When I go to item "10072181 LOAK" from search field
    Then I chose the '1' line item selections one by one
    And I select count of product
    When I click on add to project button
    And I choose project by project name "overridePrice"
    When I click on save button
    When I click on go to project button
    And I click on regular price for item projects
    But I choose "percentOff" method for price override
    And I introduce "10" percent discount
    When I introduce "G" for reason code
    When I click on apply button
    Then I verify that overriden price displayed
    When I click on adjusted price
    When I removed adjusted price
    When Adjusted price was removed
    Then I click on remove button from project

  Scenario: Verify shipping overrides in projects

    Given I log into Concierge as "leader"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "overrideshipping" by provided "projectName"
    When I click on the first project search result
    Then I click on remove button from project
    When I click on rh concierge logo
    When I click on projects button
    When I search project "overrideshipping" by provided "projectName"
    When I click on the first project search result
    And I click on unlimited furniture delivery price
    When I introduces "50" in dollar amount field
    And I choose "CustomerDelight" reason
    Then I verified that override price for shipping displayed

  Scenario: Verify subtotal/forecast by updating qty for items
    Given I log into Concierge as "leader"
    When I choose country for concierge from footer
    When I remove all items from cart
    When I click on projects button
    When I search project "subototalforecastupdatingqty" by provided "projectName"
    When I click on the first project search result
    Then I click on remove button from project
    When I click on rh concierge logo
    And I remove client from header
    When I go to item "10072181 LOAK" from search field
    Then I chose the '1' line item selections one by one
    And I select count of product
    When I click on add to project button
    And I choose project by project name "subototalforecastupdatingqty"
    When I click on save button
    When I click on go to project button
    When I choose quantity for item from project
    Then I verify that subtotal amount updated according by quantity of items
    Then I click on remove button from project

  Scenario: Verify subtotal/forecast by updating by hide/unhide items
    Given I log into Concierge as "leader"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "hideunhideitems" by provided "projectName"
    When I click on the first project search result
    Then I verify that forecast value is updated after hiding the item

  Scenario: Verify subtotal/forecast by updating qty hide/unhide spaces
    Given I log into Concierge as "leader"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "hideunhidespace" by provided "projectName"
    When I click on the first project search result

  Scenario: Verify test project list and moodboard print - moodboard CMD+P or Browser print only
    Given I log into Concierge as "leader"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "overrideshipping" by provided "projectName"
    When I click on the first project search result
    When I click on "PRINT" button
    When I click on "YES" button

  Scenario: Verify subtotal/forecast by updating qty overriding line items (all types/ one or more items - apply all functionality)

    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart
    When I click on projects button
    When I search project "overridinglineitems" by provided "projectName"
    When I click on the first project search result
    Then I click on remove button from project
    When I click on rh concierge logo
    And I remove client from header
    When I go to item "10072181 BLK" from search field
    Then I chose the '1' line item selections one by one
    And I select count of product
    When I click on add to project button
    And I choose project by project name "overridinglineitems"
    When I click on save button
    When I click on go to project button
    When I click on edit options button
    When I choose quantity for item from project
    Then I verify that forecast value is update according to quantity of item
    Then I click on remove button from project

 #10011392 SS
  Scenario Outline: Verity the Subtotal, Forecast , tax updated by changing the pricing type - NON-MEMBER, MEMBER

    Given I log into Concierge as "leader"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "verifyforecastbypricingtype" by provided "projectName"
    When I click on the first project search result
    Then I click on remove button from project
    When I remove all items from cart
    When I click on rh concierge logo
    And I remove client from header
    When I go to item "10072181 LOAK" from search field
    Then I chose the '1' line item selections one by one
    And I select count of product
    When I click on add to project button
    And I choose project by project name "verifyforecastbypricingtype"
    When I click on save button
    When I click on go to project button
    When I click on edit options button
    When I choose quantity for item from project
    When I choose pricing type "<pricingType>"
    Then I verify forecast for "<pricingType>"
    Then I click on remove button from project
    Examples:
      | pricingType |
      | NON-MEMBER  |
      | MEMBER      |

  Scenario: Verify switch between pages in Myprojects List
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    Then user verifies that project page is displayed
    When user go to the next page "2" of projects
    Then user verifies that project page is displayed

  Scenario: Verify Tax exempt in projects for Trade projects
    Given I log into Concierge as "leader"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "TEST_TRADE_3MAR_1PM" by provided "projectName"
    When I click on the first project search result
    When I choose pricing type "TRADE"
    Then I verify that tax is not displayed

  Scenario Outline: Verify Member/non Member /Trade/ Non Trade toggle pricing for unclassified business client project
    #Need data for stg4
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "pricingunclassifiedbusiness" by provided "projectName"
    When I click on the first project search result
    Then I click on remove button from project
    When I remove all items from cart
    When I click on rh concierge logo
    And I remove client from header
    When I go to item "12320938 CHR" from search field
    Then I chose the '1' line item selections one by one
    And I select count of product
    When I click on add to project button
    And I choose project by project name "pricingunclassifiedbusiness"
    When I click on save button
    When I click on go to project button
    When I choose quantity for item from project
    When I choose "<pricing>" for unclassified business client project
    Then I verify "<pricing>" for unclassified business client project
    Then I click on remove button from project
    Examples:
      | pricing    |
      | NON_MEMBER |
      | MEMBER     |
      | NON_TRADE  |
      | TRADE      |

  Scenario Outline: Verify transition between spaces
    #Need data for stg4
    Given I log into Concierge as "leader"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "transitionbetweenspaces" by provided "projectName"
    When I click on the first project search result
    When user choose space "<space>"
    Then user verify that items for "<space>" are displayed
    Examples:
      | space  |
      | space1 |
      | space2 |

  Scenario: Verify rapid selection/deselction of project Moodboard items
    #Need data for stg4
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "selectdeselectmoodboarditems" by provided "projectName"
    When I click on the first project search result
    When I click on the moodboard button
    When I verify selections and deselection of project moodboard items

#   Works only for prodsupport
  Scenario Outline: Create New project - Gallery, Design, Trade project types

    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    When I click on new project button
    When I introduces "member" first and last name
    When I choose "<project type>"
    When I choose preferred contact method for projectType
    When I introduces project name for new project for "<project type>"
    When I choose currency for create a project pop up
    When I click on create project button
    Then I verify that project for "<project type>" was created
    Examples:
      | project type |
      | GALLERY      |
      | DESIGN       |
      | TRADE        |

  Scenario: Verify the Add to Project Modal in CART/PDP - Projects list in dropdown
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "10010966" from search field
    Then I chose the '1' line item selections one by one
    And I select count of product
    When I click on add to project button
    Then I verify that project list is displayed from add to project modal

  Scenario: Verify the Add to Project Modal in CART/PDP - Opportunities list in dropdown
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "10010966" from search field
    Then I chose the '1' line item selections one by one
    And I select count of product
    When I click on add to project button
    Then I verify that opportunities list in dropdown is displayed from add to project modal

  Scenario: Verify the Add to Project Modal in CART/PDP - Spaces list in dropdown
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I go to item "10010966" from search field
    Then I chose the '1' line item selections one by one
    And I select count of product
    When I click on add to project button
    Then I verify that space list in dropdown is displayed from add to project modal

  Scenario: Verify add new Space in the modal and add items to the selected space -CART/PDP

    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart
    When I go to item "10010966" from search field
    Then I chose the '1' line item selections one by one
    And I select count of product
    When I click on add to project button
    When I click on add new space button
    When I introduces space name
    When I click on save button uppercase
    When I click on save button
    When I click on go to project button
    Then I verify that item was added to the selected space

  Scenario: Verify the address page, pre filled address details and Email address once the project added to cart

    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart via UI
    When I remove client from header
    When I go to item "10010966" from search field
    Then I chose the '1' line item selections one by one
    And I select count of product
    When I click on add to project button
    When I click on add to cart button from project screen
    When I click on view cart button
    When I choose order classification
    When I click on checkout button
    Then I click on no thanks button
    When I choose client who is a "Non-Member"
    When I fill all fields from address screen
    Then I verify the address page, prefilled address and email address must be filled

  Scenario: Add Item to Project from Cart - Verify item added and project load in correct space/oppty

    #Need data for stg4
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I remove all items from cart
    When I go to item "10010966 BRN" from search field
    Then I chose the '1' line item selections one by one
    And I select count of product
    When I click on add to cart button
    When I click on view cart button
    When I click on move to project button
    When I choose "ADDITEMTOCORRECTSPACE" project from move to project pop up
    When I click on save button
    Then I verify that item added and project load in correct space and oppty

  Scenario: Space Dropdown in projects - multiple spaces in projects
    #Need data for stg4
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "ADDITEMTOCORRECTSPACE" by provided "projectName"
    When I click on the first project search result
    Then I verify that spaces are displayed in space dropdown

  Scenario: Verify Forecast Set in SF for a project - Selected spaces and entire oppty
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "OVERRIDESHIPPING" by provided "projectName"
    When I click on the first project search result
    When I click on forecast set button
    When I click on entire opportunity radio button
    When I click on save button uppercase
    When I click on forecast set button
    When I click on Selected items & spaces radio button
    Then I verify forecast amount for selected items & spaces

  Scenario: Verify that SKU id has been updated after making edits for line item in the project

    #Need data for stg4
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "selectdeselectmoodboarditems" by provided "projectName"
    When I click on the first project search result
    When I click on view all button from space dropdown
    Then I verify that sku id has been updated after changes

  Scenario: Verify the view all functionality for spaces in project

    # Need data for stg4
    Given I log into Concierge as "associate"
    When I choose country for concierge from footer
    When I click on projects button
    When I search project "selectdeselectmoodboarditems" by provided "projectName"
    When I click on the first project search result
    When I click on view all button from space dropdown
    Then I verify that items from all spaces are displayed