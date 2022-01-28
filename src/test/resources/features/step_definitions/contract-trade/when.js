import ContractUserPage from '../../../pageobjects/contract/contractUser.page';
import TradeUserPage from '../../../pageobjects/trade/tradeUser.page';

const { When } = require('cucumber');

When(/^I enter "([^"]*)?" credentials for "([^"]*)?"$/, function(
    user,
    username
) {
    ContractUserPage.userLogin(user, { username });
});

When(/^I click on Sign out Of my "([^"]*)?" Id$/, function(user) {
    ContractUserPage.clickOnSignOut(user);
});

When(/^I click on "([^"]*)?" link$/, function(link){
    TradeUserPage.clickOnLink(link);    
});

When(/^I fill the service request form for "([^"]*)?" and submit it$/, function(username){
    TradeUserPage.fillserviceReuestForm(username);
});