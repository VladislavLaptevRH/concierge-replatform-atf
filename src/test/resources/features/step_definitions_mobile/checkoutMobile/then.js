import OrderReviewMobilePage from '../../../pageObjectsMobile/checkout/orderReview.page';
import ThankYouMobilePage from '../../../pageObjectsMobile/checkout/thankyou.page';

const { Then } = require('cucumber');

Then(/^I expect the review page to be displayed on mobile$/, () => {
    OrderReviewMobilePage.verifyReviewPageDisplay();
    browser.pause(5000);
});

Then(
    /^I land on Thank you page and I see the Order Number on mobile$/,
    function() {
        ThankYouMobilePage.verifyOnThankYouPage();
        ThankYouMobilePage.getOrderNumber();
    }
);

Then(
    /^I verify payment information for estore under payment information section on checkout thank you page on mobile$/,
    function(data) {
        var paymentFields = data.hashes();
        ThankYouMobilePage.verifyPaymentInformationOnCheckoutThankYouPageForSingleCard(
            paymentFields[0]
        );
    }
);
Then(
    /^Payment information is "([^"]*)?" on checkOut Thank you page on mobile$/,
    function(cardInfo) {
        ThankYouMobilePage.verifyPaymentInformationOnCheckoutThankYouPage(
            cardInfo
        );
    }
);
