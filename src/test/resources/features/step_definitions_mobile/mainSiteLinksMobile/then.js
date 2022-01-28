import checkTitle from '../../../support/check/checkTitle';
import clickElementIfExist from '../../../support/action/clickElementIfExist';
import mobileHeader from '../../../pageObjectsMobile/estoreHeaderMobile.page';

const { Then } = require('cucumber');

Then(/^I expect that the title is( not)* "([^"]*)?" on mobile$/, checkTitle);

Then(/^I dismiss the membership popup if exists$/, function() {
    clickElementIfExist(
        'click',
        'element',
        mobileHeader.getMembershipPopupLinkSelector()
    );
});
