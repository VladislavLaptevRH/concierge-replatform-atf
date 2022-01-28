import Header from '../../../pageObjectsMobile/estoreHeaderMobile.page';
import MyAccountPageMobile from '../../../pageObjectsMobile/myaccount/myaccount.page';
import { createUser } from '../../../support/lib/accountUtils';

const { When } = require('cucumber');

When(/^I log into the site as "([^"]*)?" on mobile$/, function(username) {
    Header.openWebsite();
    Header.signIn(username);
});
When(
    /^I create a new account with name "([^"]*)" and password "([^"]*)" on mobile$/,
    function(user, password) {
        //creating a login
        const newUser = createUser({ user, password });

        // //keep this around in case we need in future steps.
        // this.logins = {} || this.logins;
        // this.logins[user] = newUser;

        // register user
        Header.register(newUser);
    }
);
When(/^I click on the sign out button on the my account page$/, function() {
    MyAccountPageMobile.clickSignOutButton();
    // save session id
    // this.jsessionId = browser.getCookie('JSESSIONID');
});
