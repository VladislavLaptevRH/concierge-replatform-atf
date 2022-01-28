@search @smoke @presentation @synonymoneway @synonym
Feature:
    As a guest user & logged in user
    I want to verify synonym feature on search page for RH, MODERN, BABY & CHILD, TEEN brands

    Background:
        Given I have a new session

    Scenario Outline: guest user should be able to view synonym products for RH brand
        Given I am on the site as a guest user
        When I click on the search icon
        When Search for product <searchTerms>
        When I press "Enter"
        #Then scroll down
        Then verify the one way synonym rule with "<searchTerms>" and "<synonyms>"


        Examples:
        |searchTerms|synonyms|
        |furniture|furniture, table, chair, desk, bed, dresser, sofa|
        |tv |media           |
        |office   |desk, office|
        |rugs|rug|
        |pintuck    | pin-tuck, french pleat, pintucked  |
        |clearance  | sale                            |
        |teepee           |  tee pee |
