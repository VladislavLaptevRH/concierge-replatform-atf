/**
 * Common steps that can be reused across different pages.
 */

import { When } from 'cucumber';
import { queryByText } from '../../../packages/testing-library';

When(/^I click on \"(.*)\"$/, function(text) {
    queryByText(text).click();
});
