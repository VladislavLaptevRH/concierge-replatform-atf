import SelfSchedulerPage from '../../../pageobjects/selfScheduler/scheduler.page';

const { Given, When, Then } = require('cucumber');

Given(/^I visit the self scheduler with token "([^"]*)?"$/, tokenId => {
    SelfSchedulerPage.open(tokenId);
});

Then(/^I expect the self scheduler to present a valid health check$/, () => {
    SelfSchedulerPage.assertHealthCheck();
});
