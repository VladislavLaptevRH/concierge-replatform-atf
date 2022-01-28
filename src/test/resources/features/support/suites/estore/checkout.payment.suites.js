module.exports = {
    smoke: [
        //'./src/features/estore/checkout/CheckoutTotals.feature',
        //'./src/features/estore/checkout/PaymentByGuestUser.feature',
        //'./src/features/estore/checkout/PaymentByRegisteredUser.feature'
        './src/features/estore/checkout/PaymentByGuestUserForProd.feature',
        './src/features/estore/checkout/PaymentByRegisteredUserForProd.feature'
    ],
    features: [
        //'./src/features/estore/checkout/CheckoutTotals.feature',
        //'./src/features/estore/checkout/PaymentByGuestUser.feature',
        //'./src/features/estore/checkout/PaymentByRegisteredUser.feature'
        './src/features/estore/checkout/PaymentByGuestUserForProd.feature',
        './src/features/estore/checkout/PaymentByRegisteredUserForProd.feature'
    ],
    integration: [],
    prod: [
        './src/features/estore/checkout/PaymentByGuestUserForProd.feature',
        './src/features/estore/checkout/PaymentByRegisteredUserForProd.feature'
        //'./src/features/estore/checkout/CheckoutTotals.feature',
        //'./src/features/estore/checkout/PaymentByGuestUser.feature',
        //'./src/features/estore/checkout/PaymentByRegisteredUser.feature'
    ]
};
