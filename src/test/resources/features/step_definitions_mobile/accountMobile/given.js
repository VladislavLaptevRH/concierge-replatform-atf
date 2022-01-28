import Header from '../../../pageObjectsMobile/estoreHeaderMobile.page';
import openUrl from '../../../support/action/openUrl';
import AddressService from '../../../serviceobjects/account/address.service';
import { ESTORE_USERS } from '../../../support/constants/logins';
import { createUserWebAccount } from '../../../support/lib/accountUtils';
import clickElementIfExist from '../../../support/action/clickElementIfExist';
import mobileHeader from '../../../pageObjectsMobile/estoreHeaderMobile.page';

const { Given } = require('cucumber');

Given(
    /^I am on the site and click on hamburger menu to verify guest user on mobile$/,
    function() {
        // openUrl;
        Header.openWebsite();
        if (Header.isUserSignedIn()) {
            //relaunches a browser (clearing out session)
            browser.reload();
            Header.openWebsite();
            //   openUrl;
        }
    }
);
Given(/^I am on the site as "([^"]*)?" registered user on mobile$/, function(
    username
) {
    Header.openWebsite();
    clickElementIfExist(
        'click',
        'element',
        mobileHeader.getMembershipPopupLinkSelector()
    );
    Header.signIn(username);
});

Given(/^I have the following saved address on mobile:$/, function(data) {
    var addressData = data.hashes();

    // clear all addresses on the user
    console.log('Clearing addresses from user profile.');
    var removeAllResult = AddressService.removeAll();

    console.log(removeAllResult.value.status);
    console.log(removeAllResult.value.body);

    // clear all payment methods on the user so billing address is also gone
    // console.log('Clearing profile of existing cards.');
    // removeAllResult = PaymentMethodService.removeAll();
    //
    // console.log(removeAllResult.value.status);
    // console.log(removeAllResult.value.body);
    //
    // expect(
    //     removeAllResult.value.status,
    //     'Unable to clear addresses from profile.'
    // ).to.equal(200);

    console.log('Adding new address');

    var postResult = AddressService.create(addressData[0]);
    console.log(postResult.value.status);
    console.log(postResult.value.body);
    expect(postResult.value.status, 'Failure adding address to user.').to.equal(
        200
    );
});

Given(/^The mWeb customer "([^"]*)?" exists$/, function(username) {
    const userData = ESTORE_USERS[username];

    createUserWebAccount({
        email: userData.email,
        password: userData.password,
        first: userData.firstName,
        last: userData.lastName,
        logout: true
    });
});
