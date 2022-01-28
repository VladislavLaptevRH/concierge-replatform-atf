import ContractUserPage from '../../../pageobjects/contract/contractUser.page';
import TradeUserPage from '../../../pageobjects/trade/tradeUser.page';
var logger = require('../../../../wdio.log4js.js').log();

const { Given } = require('cucumber');

Given(/^I open the "([^"]*)?" Sign In page$/, function(page) {
    if (page === 'Contract') {
        ContractUserPage.open();
    } else if (page === 'Trade') {
        TradeUserPage.openSignInPage();
    } else {
        logger.error('Invalid Sign In page');
    }
});

Given(/^I open the the "([^"]*)" page$/, function(page){
    if (page === 'Contract') {
        ContractUserPage.open();
    } else if (page === 'Trade') {
        TradeUserPage.open();
    } else {
        logger.error('Invalid Sign In page');
    }
});