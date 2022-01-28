@smoke
Feature:
    As a user
    I want to be able to see an account landing page with a menu of account management options

    Scenario: My Account Menu is limited for anonymous users
        Given I am on the site as a guest user
        When I open my account page
        Then I expect to be on the my account page
        And I expect the account menu title to be "My Account"
        And I see the following account menu options:
            | link_url                        | link_name       |
            | /my-account/sign-in.jsp         | Membership      |
            | /my-account/sign-in.jsp         | Sign in         |
            | /my-account/register.jsp        | Register        |
            | /my-account/forgot-password.jsp | Forgot Password |
            | /gift-registry/index.jsp        | Gift Registry   |
        And I expect page to not scroll horizontally

    Scenario: Login takes user to my account landing page
        Given I am on the site as a guest user
        And The web customer "logInAndOutTest" exists
        When I log into the site as "logInAndOutTest"
        Then I expect to be on the my account page
        And I expect the account menu title to be "My Account"
        And I see the following account menu options:
            | link_url                        | link_name       |
            | /my-account/membership.jsp      | Membership      |
            | /my-account/payment-info.jsp    | Payment Methods |
            | /my-account/order-history.jsp   | Order History   |
            | /my-account/wish-list.jsp       | Wish List       |
            | /my-account/address-book.jsp    | Address Book    |
            | /my-account/profile.jsp         | Account Profile |
            | /gift-registry/index.jsp        | Gift Registry   |
            | /my-account/quotes.jsp          | Quotes          |
            | /my-account/sign-out.jsp        | Sign out        |
        And I expect page to not scroll horizontally




