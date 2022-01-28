import AddressService from '../../../serviceobjects/account/address.service.js';
import PaymentMethodService from '../../../serviceobjects/account/payment.service.js';
import { ESTORE_USERS } from '../../../support/constants/logins';
import {
    createUser,
    createUserWebAccount
} from '../../../support/lib/accountUtils';

const { Given } = require('cucumber');

Given(/^I am the web customer:$/, function(data) {
    const userData = data.hashes();

    createUserWebAccount({
        email: userData[0].email,
        password: userData[0].password,
        first: userData[0].first,
        last: userData[0].last
    });
});

Given(/^I am the new web customer:$/, function(data) {
    const userData = data.hashes();

    //creating a login
    const newUser = createUser(userData[0]);

    createUserWebAccount({
        email: newUser.email,
        password: newUser.password,
        first: newUser.first,
        last: newUser.last
    });
});

Given(/^The web customer "([^"]*)?" exists$/, function(username) {
    const userData = ESTORE_USERS[username];

    createUserWebAccount({
        email: userData.email,
        password: userData.password,
        first: userData.firstName,
        last: userData.lastName,
        logout: true
    });
});

Given(/^I have the following saved address:$/, function(data) {
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

Given(/^I have the following saved credit card:$/, function(data) {
    var ccData = data.hashes();

    // clear all payment methods on the user
    console.log('Clearing profile of existing cards.');
    var removeAllResult = PaymentMethodService.removeAll();

    console.log(removeAllResult.value.status);
    console.log(removeAllResult.value.body);

    expect(
        removeAllResult.value.status,
        'Unable to clear payment methods from profile.'
    ).to.equal(200);

    console.log('Adding new credit card.');

    var postResult = PaymentMethodService.create(ccData[0]);
    console.log(postResult.value.status);
    console.log(postResult.value.body);
    expect(
        postResult.value.status,
        'Failure adding credit card to user.'
    ).to.equal(200);
});

Given(/^I have the following saved credit card and address:$/, function(data) {
    var ccData = data.hashes();

    // clear all payment methods and addresses off user
    console.log('Clearing profile of existing cards and addresses.');
    var removeAllResult = AddressService.removeAll();
    console.log(removeAllResult.value.status);
    console.log(removeAllResult.value.body);

    expect(
        removeAllResult.value.status,
        'Unable to clear addresses from profile.'
    ).to.equal(200);

    removeAllResult = PaymentMethodService.removeAll();
    console.log(removeAllResult.value.status);
    console.log(removeAllResult.value.body);

    expect(
        removeAllResult.value.status,
        'Unable to clear payment methods from profile.'
    ).to.equal(200);

    var postResult = AddressService.create(ccData[0]);
    console.log(postResult.value.status);
    console.log(postResult.value.body);
    expect(postResult.value.status, 'Failure adding address to user.').to.equal(
        200
    );

    postResult = PaymentMethodService.create(ccData[0]);
    console.log(postResult.value.status);
    console.log(postResult.value.body);
    expect(
        postResult.value.status,
        'Failure adding credit card to user.'
    ).to.equal(200);
});

Given(/^I have no saved credit cards$/, function() {
    // clear all payment methods on the user
    console.log('Clearing profile of existing cards.');
    var removeAllResult = PaymentMethodService.removeAll();

    console.log(removeAllResult.value.status);
    console.log(removeAllResult.value.body);

    expect(
        removeAllResult.value.status,
        'Unable to clear saved cards from profile.'
    ).to.equal(200);
});
