import {
    createUser,
    createNewSession
} from '../../../support/lib/accountUtils';
import Header from '../../../pageobjects/estoreHeader.page';
import MiniCartPage from '../../../pageobjects/checkout/minicart.page';
import LoginPage from '../../../pageobjects/account/estoreLogin.page';
import LogoutPage from '../../../pageobjects/account/estoreLogout.page';
import MyAccountPage from '../../../pageobjects/account/myAccount.page';
import AccountNavigation from '../../../pageobjects/estoreAccountNavigation.page';
import AddressBook from '../../../pageobjects/estoreAddressBook.page';
import AddressBookDeleteModal from '../../../pageobjects/estoreAddressBookDeleteModal.page';
import AddressBookEditModal from '../../../pageobjects/estoreAddressBookEditModal.page';
import openWebsite from '../../../support/action/openWebsite';
import setCookie from '../../../support/action/setCookie';
var rootConfig = require('../../../../wdio.conf.js').config;

const { Given, When, Then } = require('cucumber');

Given(/^I have a new session$/, function() {
    createNewSession();
});

Given(/^I am on the site as a guest user$/, function() {
    openWebsite('site', '/');
    browser.pause(rootConfig.newPlatformLowPauseTimeout);
    browser.pause(rootConfig.newPlatformLowPauseTimeout);
    if (Header.isUserSignedIn()) {
        //relaunches a browser (clearing out session)
        browser.reload();
        openWebsite('site', '/');
    }
    setCookie('platform', 'new');
    setCookie('fusion_search', 'true');
});

Given(/^I (?:am logged|log) into the site as "([^"]*)?"$/, function(username) {
    LoginPage.loginOrRegister({ username });
});

Given(/^I am logged into the site as new user "([^"]*)"$/, function(user) {
    //creating a login
    const newUser = createUser({ user });

    //keep this around in case we need in future steps.
    this.logins = {} || this.logins;
    this.logins[user] = newUser;

    // register user
    LoginPage.register(newUser);
});

//TODO: replace step with ajax set up
Given(/^I have the following addresses in the address book:$/, function(data) {
    const addresses = data.hashes();

    AddressBook.open();

    browser.pause(5000);

    // save the relationship between the key from our data hash
    // and the actual address id in addressBookIdMap
    if (!this.addressBookIdMap) {
        this.addressBookIdMap = {};
    }

    addresses.forEach(address => {
        const addressMatchId = AddressBook.findMatchingAddress(address);
        // check if address exists in address book already
        // if so, save a reference to it
        if (addressMatchId) {
            this.addressBookIdMap[address.test_data_key] = addressMatchId;
        } else {
            // otherwise, create the address
            // save list of addresses in address book before
            const idList = AddressBook.getAddressIds();

            AddressBook.clickAddAddressButton();
            AddressBookEditModal.fillAddressForm(address);

            browser.pause(5000);

            //get list of addresses in address book after and find the new id.
            const updatedIdList = AddressBook.getAddressIds();
            this.addressBookIdMap[
                address.test_data_key
            ] = AddressBook.getNewAdressId(idList, updatedIdList);
        }
    });

    // rid ourselves of those pesky extras
    let addressesBookValues = Object.keys(this.addressBookIdMap).map(
        k => this.addressBookIdMap[k]
    );
    //AddressBook.removeAddressesNotInList(Object.values(this.addressBookIdMap));
    AddressBook.removeAddressesNotInList(addressesBookValues);
});

Given(/^I have no addresses in the address book$/, function() {
    AddressBook.removeAllAddresses();
});

When(
    /^I create a new account with name "([^"]*)" and password "([^"]*)"$/,
    function(user, password) {
        //creating a login
        const newUser = createUser({ user, password });

        //keep this around in case we need in future steps.
        this.logins = {} || this.logins;
        this.logins[user] = newUser;

        // register user
        LoginPage.register(newUser);
    }
);

When(/^I sign in as "([^"]*)" with password "([^"]*)"$/, function(
    email,
    password
) {
    //login user
    LoginPage.fillLoginForm({ email, password });
});

When(/^I sign in as "([^"]*)"$/, function(user) {
    //login user
    LoginPage.fillLoginForm(this.logins[user]);
});

When(/^I click on the sign out button on the sign out page$/, function() {
    LogoutPage.clickLogoutButton();
    // save session id
    this.jsessionId = browser.getCookie('JSESSIONID');
});

When(/^I log out$/, function() {
    LogoutPage.open();
    LogoutPage.clickLogoutButton();
    // save session id
    this.jsessionId = browser.getCookie('JSESSIONID');
});

When(/^I click the Create Address button$/, function() {
    AddressBook.clickAddAddressButton();
});

When(/^I save the following address in the (New|Edit) Address Form:$/, function(
    mode,
    data
) {
    const address = data.hashes()[0];
    if (mode === 'New') {
        const addressId = AddressBookEditModal.fillAddressFormAndReturnId(
            address
        );
        //save the relationship between the key from our data hash and the actual address id.
        if (!this.addressBookIdMap) {
            this.addressBookIdMap = {};
        }
        this.addressBookIdMap[address.test_data_key] = addressId;
    } else {
        AddressBookEditModal.fillAddressForm(address);
    }
});

When(/^I click on the edit link for address "([^"]*)?"$/, function(addressKey) {
    browser.pause(3000);
    const addressId = this.addressBookIdMap[addressKey];
    AddressBook.clickEditAddressLinkById(addressId);
});

When(/^I click on the delete link for address "([^"]*)?"$/, function(
    addressKey
) {
    browser.pause(3000);
    const addressId = this.addressBookIdMap[addressKey];
    AddressBook.clickDeleteAddressLinkById(addressId);
});

When(/^I click the delete button in the delete address modal$/, function() {
    AddressBookDeleteModal.clickDeleteButtonInModal();
});

When(/^I click on the default checkbox for address "([^"]*)?"$/, function(
    addressKey
) {
    browser.pause(3000);
    const addressId = this.addressBookIdMap[addressKey];
    AddressBook.clickDefaultAddressById(addressId);
});

When(/^I open my account page$/, function() {
    MyAccountPage.open();
});

Then(
    /^I expect that I am( not)* signed in( on old page)*( with name "([^"]*)?")*$/,
    (isGuest, page, name) => {
        if (page) {
            Header.checkUserMenuStateForOldPage(isGuest);
        } else {
            Header.checkUserMenuState(isGuest);
        }
        if (name) {
            Header.checkForNameInMenu(name);
        }
    }
);

Then(/^I expect to( not)* be on the login page$/, function(falseCase) {
    LoginPage.checkLoginPage(!!falseCase);
});

Then(/^I expect to be on the logout page$/, function() {
    LogoutPage.checkLogoutPage();
});

Then(
    /^I expect to( not)* see the "([^"]*)" link in the account navigation$/,
    function(falseCase, link) {
        AccountNavigation.checkForLink(link, !!falseCase);
    }
);

Then(/^I expect to( not)* see the Address Book login message/, function(
    falseCase
) {
    AddressBook.checkForLoginMessage(!!falseCase);
});

Then(/^I expect to( not)* see the Address Book$/, function(falseCase) {
    AddressBook.checkForAddressBook(!!falseCase);
});

Then(/^I see the following address in the address list:$/, function(data) {
    const address = data.hashes()[0];
    const addressId = this.addressBookIdMap[address.test_data_key];

    AddressBook.checkAddressItemInAddressBook(addressId, address);
});

Then(/^I see the following address in the delete address modal:$/, function(
    data
) {
    const address = data.hashes()[0];
    AddressBookDeleteModal.checkAddressItemInDeleteModal(address);
});

Then(
    /^I expect the address "([^"]*)?" has been removed from the list$/,
    function(addressKey) {
        const addressId = this.addressBookIdMap[addressKey];
        AddressBook.checkAddressExists(addressId, true);
    }
);

Then(/^I expect the address "([^"]*)?" is the default address$/, function(
    addressKey
) {
    const addressId = this.addressBookIdMap[addressKey];
    AddressBook.checkAddressIsDefault(addressId);
});

Then(/^I expect to( not)* be on the my account page$/, function(falseCase) {
    MyAccountPage.checkMyAccountPageLayout(!!falseCase);
});

Then(/^I expect the account menu title to( not)* be "([^"]*)"$/, function(
    falseCase,
    menuTitle
) {
    AccountNavigation.checkAccountMenuTitle(menuTitle, !!falseCase);
});

Then(/^I see the following account menu options:$/, function(data) {
    const menuItems = data.hashes();
    AccountNavigation.checkAccountMenuItems(menuItems);
});
