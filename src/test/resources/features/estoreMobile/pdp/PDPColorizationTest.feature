@smoke @criticalpath
Feature:
    As a user
    I want to verify Colorization functionality for different types of colorizable products

    Background:
        Given I have a new session

    Scenario Outline:: Colorization of hero image and line item on selecting swatch from panel for static and dynamic color products
        Given I open the pdp "<product_id>" on mobile by "<brand>" brand
        When I select swatch on PDP page on mobile
        Then I can see swatch preview with selected swatch and i close it
        Then I verify "Hero" image is changed as per selection on mobile
        Then I verify "Line-Item" image is changed as per selection on mobile
        Then I verify the option is selected for "<product_id>" as per selection on mobile

        Examples:
        |brand |product_id |type|
        |rh    |prod2020027|static-color|
        |rh    |prod10730039|dynamic-color|

    Scenario Outline:: Colorization of hero image and line item on selecting swatch from panel for multi-color:dynamic-material:dynamic-color product
        Given I open the pdp "<product_id>" on mobile by "<brand>" brand
        When I click on "Swatch panel" fabric link on PDP page on mobile
        When I select swatch from swatch panel on mobile
        Then I can see swatch preview with selected swatch and i close it
        Then I close swatch panel modal on mobile
        Then I verify "Hero" image is changed as per selection on mobile
        Then I verify "Line-Item" image is changed as per selection on mobile
        When I select swatch on PDP page on mobile
        Then I can see swatch preview with selected swatch and i close it
        Then I verify "Hero" image is changed as per selection on mobile
        Then I verify "Line-Item" image is changed as per selection on mobile
        Then I verify the option is selected for "<product_id>" as per selection on mobile
        Examples:
        |brand |product_id |type|
        |rh    |prod12230007|multi-color:dynamic-material:dynamic-color|


    Scenario Outline:: Colorization of hero image and line item on selecting swatch from panel for multi-color:dynamic-material:dynamic-material product
        Given I open the pdp "<product_id>" on mobile by "<brand>" brand
        When I click on "Swatch panel" fabric link on PDP page on mobile
        When I select swatch from swatch panel on mobile
        Then I can see swatch preview with selected swatch and i close it
        Then I close swatch panel modal on mobile
        Then I verify "Hero" image is changed as per selection on mobile
        Then I verify "Line-Item" image is changed as per selection on mobile
        Then I verify the option is selected for "<product_id>" as per selection on mobile
        
        Examples:
        |brand |product_id |type|
        |bc   |rhbc_prod962396|multi-color:dynamic-material:dynamic-material|

    Scenario Outline:: Colorization of hero image and line item on selecting swatch from panel for multi-color:dynamic-color:dynamic-material product
        Given I open the pdp "<product_id>" on mobile by "<brand>" brand
        When I select swatch on PDP page for product on mobile
        Then I can see swatch preview with selected swatch and i close it
        Then I verify "Hero" image is changed as per selection on mobile
        Then I verify "first" "Line-Item" image is changed as per selection on mobile
        Then I verify the option is selected for "<product_id>" as per selection on mobile
        When I click on "Swatch panel" link on PDP page for product on mobile
        When I select swatch from swatch panel on mobile
        Then I can see swatch preview with selected swatch and i close it
        Then I close swatch panel modal on mobile
        Then I verify "Hero" image is changed as per selection on mobile
        Then I verify "second" "Line-Item" image is changed as per selection on mobile
        Then I verify the option is selected for child product "<child_product_id>" as per selection on mobile

        Examples:   
        |brand |product_id |child_product_id|type|
        |rh    |prod10330200|prod10330201|multi-color:dynamic-color:dynamic-material|