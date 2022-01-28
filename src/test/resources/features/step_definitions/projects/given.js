import browserApiUtils from '../../../support/lib/browserApiUtils';

const { Given } = require('cucumber');

Given(/^I have a new project$/, function() {
    if (!this.projectId) {
        const payload = {
            project: {}
        };
        const sessionConfirmationResult = browser.executeAsync(
            browserApiUtils.get,
            {
                path: '/rh/api/profile/v1/sessionConf'
            }
        );
        const postResult = browser.executeAsync(browserApiUtils.post, {
            path: '/rh/api/project/v1',
            sessionConfirmation:
                sessionConfirmationResult.value.body.sessionConfirmation,
            body: payload
        });
        this.projectId = postResult.value.body.project.projectId;
        this.divisionId = postResult.value.body.project.divisions[0].divisionId;
    }
});
