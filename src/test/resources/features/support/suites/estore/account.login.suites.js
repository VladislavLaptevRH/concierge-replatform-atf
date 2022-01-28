module.exports = {
    smoke: [
        './src/features/estore/account/Login.feature',
        // './src/features/estore/account/MyAccountHome.feature',
        //  './src/features/estore/account/Register.feature',
        './src/features/estore/account/Logout.feature'
    ],
    features: [
        './src/features/estore/account/Login.feature',
        //'./src/features/estore/account/MyAccountHome.feature',
        // './src/features/estore/account/Register.feature',
        './src/features/estore/account/Logout.feature'
    ],
    integration: [],
    staging: [
        './src/features/estore/account/Login.feature',
        './src/features/estore/account/Logout.feature'
    ]
};
