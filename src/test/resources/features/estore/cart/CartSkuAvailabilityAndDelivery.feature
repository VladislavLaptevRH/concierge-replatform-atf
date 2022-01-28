@cart @skuAvailability @smoke
Feature:
    As a customer
    I want to be able to see when the items I am considering for purchase will be delivered and any terms that apply

Background:
    Given I open the url "/my-account/sign-in.jsp"
    Given I set a cookie "pc" with the content "94111"

@PHOE-385
Scenario: Cart verify delivery information displays for items except service skus.
    Given I have the following items in the cart:
        | product_id                    | title                                   | full_sku_id     | qty | service_sku |
        | Interior-Design-Services-Hrly | Design Services Hourly Fee              | 91020004 HRLY   | 1   | true        |
        | Membership-Enrollment         | RH Members Program                      | 91020001 RH     | 1   | true        |
        | prod11600084                  | Rectangular Column Table Lamp           | 68270648 LBBM   | 1   | false       |
        | prod15970044                  | Salvage Wood Trestle Round Dining Table | 62870008 NATL   | 1   | false       |
        | prod1283065                   | LUGARNO KNOB                            | 24120451 PC     | 1   |false        |
    When  I visit the cart
    Then  I expect the availability messages to be shown for non-service skus only
    And   I expect the delivery messages to be shown for non-service skus only
    And   I expect the returns messages to be shown for non-service skus only

