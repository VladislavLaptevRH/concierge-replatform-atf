import mobileHeader from '../../../pageObjectsMobile/estoreHeaderMobile.page';
const { Given, When, Then } = require('cucumber');

When(/^I click on the chat button on mobile$/, function() {
    mobileHeader.clickChatButton();
});

When(/^I close the chat window on mobile$/, function() {
    mobileHeader.closeChatRequestWindow();
});
