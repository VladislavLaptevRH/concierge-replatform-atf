@criticalpath @checkout @payment @smoke @cwteamrequest
Feature:
    I want to verify Add To cart functionality regarding the sku I have selected.

    Background:
        Given I have a new session

    Scenario Outline: Add To cart functionality
        Given I am on the site as a guest user
        Given I open the pdp "<productId>"
        When I vertically scroll "<scrollValue>" to the line item
        Given I prepare options for product "<productId>" and sku "<fullSku_Id>" for "<postalCode>"
        When I select the options and add to cart

        Examples:
            |productId    |fullSku_Id    | scrollValue| postalCode |
            |prod6371042 | 57950995 BWMR | 650        | 75010      |
            |prod6371041 | 97890405 WHSA | 650        | 75010      |
