import openUrl from '../../../support/action/openUrl';
import checkTitle from '../../../support/check/checkTitle';

const { Given } = require('cucumber');

Given(/^I open the (url|site) "([^"]*)?" on mobile$/, openUrl);

Given(/^the title is( not)* "([^"]*)?" on mobile$/, checkTitle);
