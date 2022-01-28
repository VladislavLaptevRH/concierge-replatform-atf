module.exports = {
    smoke: [
        './src/features/estore/pdp/AddItems.feature',
        './src/features/estore/pdp/PDPCurrencyTest.feature'
        //   './src/features/estore/cart/GroupingInCart.feature'
    ],
    features: [
        './src/features/estore/pdp/AddItems.feature',
        './src/features/estore/pdp/PDPCurrencyTest.feature'
        //  './src/features/estore/cart/GroupingInCart.feature'
    ],
    integration: [],
    staging: [
        './src/features/estore/pdp/AddItems.feature',
        './src/features/estore/pdp/PDPCurrencyTest.feature'
    ],
    prod: [
        './src/features/estore/pdp/AddItems.feature',
        './src/features/estore/pdp/PDPCurrencyTest.feature',
        './src/features/estore/pdp/PDPColorization.feature'
    ]
};
