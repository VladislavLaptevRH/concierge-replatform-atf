/**
 * Common steps that can be reused across different pages.
 */

import { Before, Given } from 'cucumber';
import { get, set } from 'lodash';

Before(function() {
    this.data = {};

    this.set = (path, value) => set(this.data, path, value);

    this.get = path => get(this.data, path);
});

Given(/^the "(.*)"(?: [^ ]+)? is:$/, function(key, value) {
    this.set(key, value);
});
