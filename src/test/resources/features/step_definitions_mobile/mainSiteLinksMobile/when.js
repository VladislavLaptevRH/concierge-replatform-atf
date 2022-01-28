import mobileHeader from '../../../pageObjectsMobile/estoreHeaderMobile.page';
const { Given, When, Then } = require('cucumber');

When(
    /^I click on the hamburger menu and select (RH Modern|RH SKI HOUSE|RH BEACH HOUSE|RH Baby & Child|RH Teen|My Account) on mobile$/,
    function(hamburgerMenuLink) {
        mobileHeader.clickHamburgerMenuAndVisitLink(hamburgerMenuLink);
    }
);

When(
    /^I click on the hamburger menu, scroll and select (Rh Interior Design|Rh Galleries|Rh Restaurants) on mobile$/,
    function(hamburgerMenuLink) {
        mobileHeader.clickHamburgerMenuAndVisitLink(hamburgerMenuLink, true);
    }
);
