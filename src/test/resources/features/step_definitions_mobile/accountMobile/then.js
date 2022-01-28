import Header from '../../../pageObjectsMobile/estoreHeaderMobile.page';

const { Then } = require('cucumber');

Then(
    /^I expect that I am( not)* signed in( with name "([^"]*)?")* on mobile$/,
    (isGuest, name) => {
        Header.checkUserMenuState(isGuest);
        if (name) {
            Header.checkForNameInMenu(name);
        }
    }
);
