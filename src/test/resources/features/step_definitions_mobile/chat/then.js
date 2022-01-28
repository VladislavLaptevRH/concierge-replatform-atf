import checkTitle from '../../../support/check/checkTitle';
import clickElementIfExist from '../../../support/action/clickElementIfExist';
import mobileHeader from '../../../pageObjectsMobile/estoreHeaderMobile.page';

const { Then } = require('cucumber');

Then(/^I expect chat request window is opened$/, function() {
    mobileHeader.chatRequestWindow();
});

Then(/^I expect chat button does not exist on mobile$/, function() {
    mobileHeader.chatButtonNotExist();
});
