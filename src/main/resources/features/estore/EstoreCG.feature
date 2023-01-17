#@estoreRegression
#@estoreCGPage
#Feature: Estore CG
#
#  Scenario: CG-Verify Collection Name
#    Given I log into eStore as "guest"
#    When I goes to estore collection page
#    Then I validate the collection name is not empty
#
#  Scenario: CG-Verify Shop In Stock Link
#    Given I log into eStore as "regular"
#    When I remove all items from estore cart
#
#  Scenario: CG-Verify Back To top Button
#    Given I log into eStore as "guest"
#    When I goes to estore collection page
#    When I scroll on the page till back to top button is visible
#    Then I verify that back to top button is clickable
#    And I verify that after click on back to top button user is scrolled to top on the page
#
#  Scenario: Verify single Grid View is as default on CG
#    Given I log into eStore as "guest"
#    When I goes to estore collection page
#    Then I verify that single grid view is selected on CG page by default
#
#  Scenario: Verify collection name,image,prices(regular,member,sale(applicable) on collection banner
#    Given I log into eStore as "guest"
#    When I goes to estore collection page
#    Then I verify collection name, image, prices on collection banner

  #Scenario: Verify CG name is visible on Preview the collection model
    #Given I log into eStore as "guest"
    #When I goes to estore collection page
    #When I click on preview the collection link
    #Then I verify that I'm landing on preview the collection model

  #Scenario: Verify the close button on Preview the Collection Modal
    #Given I log into eStore as "guest"
    #When I goes to estore collection page
    #When I click on preview the collection link
    #When I click on close button on preview the collection modal pop up
    #Then I verify after click on X icon model gets closed

  #Scenario: Verify Preview the Collection Modal is scrollable and after scrooling all products are visible on the model
    #Given I log into eStore as "guest"
    #When I goes to estore collection page
    #When I click on preview the collection link
    #Then I verify that collection modal is scrollable

  #Scenario: Verify Product image,name and prices are visible for each product on the model
    #Given I log into eStore as "guest"
    #When I goes to estore collection page
    #When I click on preview the collection link
    #Then I verify product image, name and prices are visible for each product on the model

  #Scenario: Verify after clicking on any product from the Preview Collection model user lands on the PDP page
    #Given I log into eStore as "guest"
    #When I goes to estore collection page
    #When I click on preview the collection link
    #When I click on any product from the preview collection model
    #Then I verify that estore PDP page is displayed

  #Scenario: Verify Textile CG having "Enjoy Free Shipping On All Textiles" banner
    #Given I log into eStore as "guest"
    #When user clicks on textile menu
    #When user goes to bedding collections test
    #Then I verify that Enjoy Free Shipping On All Textiles banner is displayed
