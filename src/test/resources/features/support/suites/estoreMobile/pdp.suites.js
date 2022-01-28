module.exports = {
    smoke: [
        // './src/features/estoreMobile/pdp/PDPCurrencyTest.feature',
        //'./src/features/estoreMobile/pdp/PDPSkuInformation.feature',
        './src/features/estoreMobile/pdp/PDPAddToCart.feature'
    ],
    features: [
        //'./src/features/estoreMobile/pdp/PDPCurrencyTest.feature',
        //'./src/features/estoreMobile/pdp/PDPSkuInformation.feature',
        './src/features/estoreMobile/pdp/PDPAddToCart.feature'
    ],
    integration: [],
    staging: ['./src/features/estoreMobile/pdp/PDPAddToCart.feature'],
    prod: ['./src/features/estoreMobile/pdp/PDPAddToCart.feature']
};
