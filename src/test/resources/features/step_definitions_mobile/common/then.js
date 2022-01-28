/**
 * Common steps that can be reused across different pages.
 */

import { Then } from 'cucumber';
import { queryByText, waitFor } from '../../../packages/testing-library';

Then(
    /^I should see the "(.*)"(?: (?:text|link|button|element|message))?$/,
    function(keyOrMessage) {
        const message = this.get(keyOrMessage) || keyOrMessage;

        waitFor(() => queryByText(message));
    }
);

Then(
    /^I should see the "(.*)"(?: (?:text|link|button|element|message))? is gone$/,
    function(keyOrMessage) {
        const message = this.get(keyOrMessage) || keyOrMessage;

        waitFor(() => !queryByText(message));
    }
);
