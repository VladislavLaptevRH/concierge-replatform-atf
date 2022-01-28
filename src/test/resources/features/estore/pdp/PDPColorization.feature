@smoke @criticalpath
Feature:
    As a user
    I want to verify Colorization functionality for different types of colorizable products

    Background:
        Given I have a new session

    Scenario Outline:: Colorization of hero image and line item on selecting swatch from panel for static and dynamic color products
        Given I open the pdp "<product_id>"
        When I select swatch on PDP page
        Then I verify "Hero" image is changed as per selection
        Then I verify "Line-Item" image is changed as per selection
        Then I verify the option is selected for "<product_id>" as per selection

        Examples:
        |brand |product_id |type|
        |RH    |prod2020027|static-color|
        |RH    |prod10730039|dynamic-color|

    Scenario Outline:: Colorization of hero image and line item on selecting swatch from panel for multi-color:dynamic-material:dynamic-color product
        Given I open the pdp "<product_id>"
        When I click on "Swatch panel" link on PDP page
        When I select swatch from swatch panel
        Then I close swatch panel modal
        Then I verify "Hero" image is changed as per selection
        Then I verify "Line-Item" image is changed as per selection
        When I select swatch on PDP page
        Then I verify "Hero" image is changed as per selection
        Then I verify "Line-Item" image is changed as per selection
        Then I verify the option is selected for "<product_id>" as per selection

        Examples:
        |brand |product_id |type|
        |RH    |prod12230007|multi-color:dynamic-material:dynamic-color|


    Scenario Outline:: Colorization of hero image and line item on selecting swatch from panel for multi-color:dynamic-material:dynamic-material product
        Given I open the pdp "<product_id>" by "<brand>" brand
        When I click on "Swatch panel" link on PDP page
        When I select swatch from swatch panel
        Then I close swatch panel modal
        Then I verify "Hero" image is changed as per selection
        Then I verify "Line-Item" image is changed as per selection
        Then I verify the option is selected for "<product_id>" as per selection
        
        Examples:
        |brand |product_id |type|
        |bc   |rhbc_prod962396|multi-color:dynamic-material:dynamic-color|

    Scenario Outline:: Colorization of hero image and line item on selecting swatch from panel for multi-color:dynamic-color:dynamic-material product
        Given I open the pdp "<product_id>"
        When I select swatch on PDP page for product
        Then I verify "Hero" image is changed as per selection
        Then I verify "first" "Line-Item" image is changed as per selection
        Then I verify the option is selected for "<product_id>" as per selection
        When I click on "Swatch panel" link on PDP page
        When I select swatch from swatch panel for product
        Then I close swatch panel modal
        Then I verify "Hero" image is changed as per selection
        Then I verify "second" "Line-Item" image is changed as per selection  
        Then I verify the option is selected for child product "<child_product_id>" as per selection

        Examples:
        |brand |product_id |child_product_id|type|
        |RH    |prod10330200|prod10330201|multi-color:dynamic-color:dynamic-material|
