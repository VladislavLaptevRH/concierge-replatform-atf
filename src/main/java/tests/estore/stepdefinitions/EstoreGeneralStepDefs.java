package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.Actions;
import tests.concierge.pageObject.*;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.*;
import tests.utility.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.with;

@Getter
public class EstoreGeneralStepDefs {
    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage();
    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen();
    PaymentScreen paymentScreen = new PaymentScreen();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeAddressScreen conciergeAddressScreen = new ConciergeAddressScreen();
    EstoreAddressScreen estoreAddressScreen = new EstoreAddressScreen();
    EstorePaymentPage estorePaymentPage = new EstorePaymentPage();
    EstoreCartPage estoreCartPage = new EstoreCartPage();
    EstoreCheckoutAddressScreen estoreCheckoutAddressScreen = new EstoreCheckoutAddressScreen();
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();

    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(30));

    public static String id;
    private static Response response;
    private static String authEndpoint;
    private static String clientSecret;
    private static String USER_ID;
    private static final String USEREMAIL = EstoreLoginStepDefs.userEmail;
    public static final String BASE_URL = Hooks.eStoreBaseURL;
    private static String addItemEndpoint;
    private static String cartId;

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete");
        wait.until(pageLoadCondition);
    }

    protected static String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }

    public boolean waitForJSandJQueryToLoad() {
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    public void removeFromCart(int countOfCartItems) {
        if (Hooks.cookie.equals("userservice")) {
            with().pollInterval(3, SECONDS).await().until(() -> true);
            Actions actions = new Actions(WebDriverRunner.getWebDriver());
            actions.moveToElement(estoreUserAccountPage.getCartButtonUserService());
            estoreUserAccountPage.getCartButtonUserService().should(visible, Duration.ofSeconds(20));
            estoreUserAccountPage.getCartButtonUserService().click();
        } else {
            estoreUserAccountPage.getCartButtonStg4().click();

        }
        try {
            for (int i = 0; i < countOfCartItems; i++) {
                estoreCartPage.getRemoveButton().should(visible, Duration.ofSeconds(30));
                estoreCartPage.getRemoveButton().click();
                with().pollInterval(3, SECONDS).await().until(() -> true);
            }
            estoreUserAccountPage.getRhEstoreLogo().should(visible, Duration.ofSeconds(15));
            estoreUserAccountPage.getRhEstoreLogo().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Agree&add to cart button is not displayed");
            estoreUserAccountPage.getRhEstoreLogo().should(visible, Duration.ofSeconds(15));
            estoreUserAccountPage.getRhEstoreLogo().click();
        }
    }


    /**
     * This method login in system with selected role
     *
     * @param accountRole - account role
     */
    public void loginAsRole(String accountRole) {
        conciergeLoginPage.getPasswordField().should(visible, Duration.ofMinutes(5));
        conciergeLoginPage.getUsernameField().should(visible, Duration.ofSeconds(40));
        if (accountRole.equals("associate")) {
            conciergeLoginPage.getUsernameField().setValue(Hooks.associateLogin);
            conciergeLoginPage.getPasswordField().setValue(Hooks.associatePassword);
        }
        if (accountRole.equals("employee")) {
            conciergeLoginPage.getUsernameField().setValue("ediscount");
            conciergeLoginPage.getPasswordField().setValue("p6K6K6Mx");
        }
        if (accountRole.equals("leader")) {
            conciergeLoginPage.getUsernameField().setValue(Hooks.leaderLogin);
            conciergeLoginPage.getPasswordField().setValue(Hooks.leaderPassword);
        }

        conciergeLoginPage.getSignInButton().should(visible, Duration.ofSeconds(30));
        conciergeLoginPage.getSignInButton().click();

        conciergeLoginPage.getLocationNewPortBeach().should(visible, Duration.ofSeconds(30));
        conciergeLoginPage.getLocationNewPortBeach().click();
        conciergeLoginPage.getContinueButton().should(visible, Duration.ofSeconds(30));

        conciergeLoginPage.getContinueButton().click();
    }


    /**
     * This method is clear required field
     *
     * @param field - field
     */
    public void clearField(SelenideElement field) {
        field.click();
        try {
            if (!field.getAttribute("value").isEmpty()) {
                executeJavaScript("arguments[0].value='';", field);
            }
        } catch (Exception exception) {
            System.out.println("Attribute value is null");
        }

    }


    /**
     * This method fill all fields from checkout address screen
     */
    public void fillAddressFields() {
//        $(By.xpath("//form[@class='MuiGrid-root MuiGrid-container']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-6 MuiGrid-justify-xs-center']/div[1]/div[1]/div[3]/div/input")).should(visible, Duration.ofSeconds(30));
        estoreAddressScreen.getShippingAddressTitle().shouldHave(text("Shipping Address"), Duration.ofSeconds(40));
        estoreAddressScreen.getBillingAddressTitle().shouldHave(text("Billing Address"), Duration.ofSeconds(40));
        clearField(estoreCheckoutAddressScreen.getFirstNameInpt());
        estoreCheckoutAddressScreen.getFirstNameInpt().setValue("QA1");

        clearField(estoreCheckoutAddressScreen.getLastNameField());
        estoreCheckoutAddressScreen.getLastNameField().setValue("Automation");

//        clearField(estoreCheckoutAddressScreen.getCompanyNameField());
//        estoreCheckoutAddressScreen.getCompanyNameField().setValue("AutomationCompany");

        clearField(estoreCheckoutAddressScreen.getStreetAddressField());
        estoreCheckoutAddressScreen.getStreetAddressField().setValue("QaStreet");

        clearField(estoreCheckoutAddressScreen.getAptFloorSuiteField());
        estoreCheckoutAddressScreen.getAptFloorSuiteField().setValue("QaApartment");

        clearField(estoreCheckoutAddressScreen.getCityField());
        estoreCheckoutAddressScreen.getCityField().setValue("qaCity");

        clearField(estoreCheckoutAddressScreen.getPhoneField());
        estoreCheckoutAddressScreen.getPhoneField().setValue("334-229-4667");

        try {
            clearField(estoreAddressScreen.getEmailField());
            estoreAddressScreen.getEmailField().setValue("test@mail.com");
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Email field is not displayed");
        }
        try {
            clearField(estoreAddressScreen.getConfirmEmail());
            estoreAddressScreen.getConfirmEmail().setValue("test@mail.com");
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Email field is not displayed");
        }


        estoreAddressScreen.getBillingAddressTitle().should(visible, Duration.ofSeconds(12));
    }


    /**
     * Fill zip code, state, country for address checkout
     *
     * @param zipCode - zipcode
     * @param country - country
     * @param state   - state
     */
    public void fillZipCodeStateCountry(String zipCode, String country, String state) {
        checkoutAddressScreen.getCountryField().should(visible, Duration.ofSeconds(50));
        Select countrySelect = new Select(checkoutAddressScreen.getCountryField());
        executeJavaScript("arguments[0].scrollIntoView(true);", countrySelect);
        countrySelect.selectByValue(country);

        if (state.equals("")) {
            checkoutAddressScreen.getStateField().should(visible, Duration.ofSeconds(15));
            Select selectState = new Select(checkoutAddressScreen.getStateField());
            selectState.selectByIndex(ThreadLocalRandom.current().nextInt(1, 4));
        }

        clearField(checkoutAddressScreen.getZipPostalCodeField());
        checkoutAddressScreen.getZipPostalCodeField().setValue(zipCode);

        if (state.equals("NY")) {
            SelenideElement stateNyButton = $(By.xpath("(//div[contains(@class,'Mui')]//select[contains(@class,'Mui')])[2]//option[@value='" + state + "']"));
            stateNyButton.click();
        }

    }

    public void executePaymentWithCard(String cardType) {
        estorePaymentPage.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(5));

        if (cardType.equals("visa")) {
            Select selectPayment = new Select(estorePaymentPage.getChoosePaymentMethodBtn());
            selectPayment.selectByIndex(2);

            switchTo().frame($(By.cssSelector("iframe[title='Iframe for secured card number']")).should(visible, Duration.ofMinutes(1)));
            estorePaymentPage.getCardNumberField().setValue("4678475330157543");
            switchTo().defaultContent();

            switchTo().frame($(By.xpath("//div[contains(@class,'securityCode')]//iframe[@class='js-iframe']")).should(visible, Duration.ofMinutes(1)));
            estorePaymentPage.getCvcField().setValue("737");
            switchTo().defaultContent();

            switchTo().frame($(By.xpath("//div[contains(@class,'expiryDate')]//iframe[@title='Iframe for secured card expiry date']")).should(visible, Duration.ofMinutes(1)));
            estorePaymentPage.getExpiryDateField().setValue("0330");
            switchTo().defaultContent();
        }
        if (cardType.equals("mastercard")) {
            Select selectPayment = new Select(estorePaymentPage.getChoosePaymentMethodBtn());
            selectPayment.selectByIndex(2);

            switchTo().frame($(By.cssSelector("iframe[title='Iframe for secured card number']")).should(visible, Duration.ofMinutes(1)));
            estorePaymentPage.getCardNumberField().setValue("2222400010000008");
            switchTo().defaultContent();

            switchTo().frame($(By.xpath("//div[contains(@class,'securityCode')]//iframe[@class='js-iframe']")).should(visible, Duration.ofMinutes(1)));
            estorePaymentPage.getCvcField().setValue("737");
            switchTo().defaultContent();

            switchTo().frame($(By.xpath("//div[contains(@class,'expiryDate')]//iframe[@title='Iframe for secured card expiry date']")).should(visible, Duration.ofMinutes(1)));
            estorePaymentPage.getExpiryDateField().setValue("0330");
            switchTo().defaultContent();
        }

    }


    /**
     * Click on continue to payment buttons
     */
    public void continueToPaymentAfterAddressCheckout() {
        checkoutAddressScreen.getContinuePaymentButton().should(visible, Duration.ofSeconds(15));
        executeJavaScript("arguments[0].scrollIntoView(true);", checkoutAddressScreen.getContinuePaymentButton());
        checkoutAddressScreen.getContinuePaymentButton().click();

        try {
            checkoutAddressScreen.getContinueButton().should(visible, Duration.ofSeconds(15));
            executeJavaScript("arguments[0].click();", checkoutAddressScreen.getContinueButton());
        } catch (Exception e) {
            System.out.println("Continue from popup is not displayed");
        }

    }

    /**
     * This method verify if element is visible
     *
     * @param xPath - xpath for selenide element
     * @return
     */
    public boolean isElementVisible(String xPath) {
        try {
            $(By.xpath(xPath)).should(visible, Duration.ofSeconds(40));
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Test");
            return false;
        }
    }


    /**
     * @param field - find by provided field
     */
    public void searchClientBy(String field) {
        try {
            conciergeUserAccountPage.getClientButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(25));
            conciergeUserAccountPage.getClientButton().click();
            conciergeUserAccountPage.getClientLookupHeaderBtn().should(visible, Duration.ofSeconds(40));
            conciergeUserAccountPage.getClientLookupHeaderBtn().click();

            conciergeUserAccountPage.getClientLookupFirstName().should(visible, Duration.ofSeconds(40));
            if (field.equals("email")) {
                conciergeUserAccountPage.getClientLookupEmail().should(Condition.be(visible), Duration.ofSeconds(25));
                conciergeUserAccountPage.getClientLookupEmail().setValue("test@mailinator.com");
            }
            if (field.equals("lastName")) {
                conciergeUserAccountPage.getClientLookupLastName().should(Condition.be(visible), Duration.ofSeconds(25));
                conciergeUserAccountPage.getClientLookupLastName().setValue("NonMember");
            }
            if (field.equals("memberID")) {
                conciergeUserAccountPage.getMemberIdField().should(Condition.be(visible), Duration.ofSeconds(25));
                conciergeUserAccountPage.getMemberIdField().setValue("101318450");
            }
            if (field.contains("businessAccountNumberContract")) {
                conciergeUserAccountPage.getBusinessAcNumber().should(Condition.be(visible), Duration.ofSeconds(25));
                conciergeUserAccountPage.getBusinessAcNumber().setValue("20211221164476");
            }
            if (field.contains("businessAccountNumberTrade")) {
                conciergeUserAccountPage.getBusinessAcNumber().should(Condition.be(visible), Duration.ofSeconds(25));
                conciergeUserAccountPage.getBusinessAcNumber().setValue("20211221164474");
            }
            if (field.equals("phone number,postal code,company")) {

            }
            conciergeUserAccountPage.getClientLookupSearchButton().should(Condition.and("", visible, enabled), Duration.ofSeconds(25));

            conciergeUserAccountPage.getClientLookupSearchButton().click();
        } catch (
                Exception e) {
            System.out.println("Client is selected");
        }
    }

    /**
     * @returns access_token
     */

    public static String getAuthToken() {
        if (Hooks.eStoreBaseURL.contains("stg2")) {
            authEndpoint = "staging";
            clientSecret = "2119483c-ab18-42b4-9bdc-05d16720d173";
        } else {
            authEndpoint = "qa";
            clientSecret = "a2e447ae-abc8-4ed3-bf46-94d3a4c88031";
        }
        RestAssured.baseURI = "https://auth.rhnonprod.com";
        RequestSpecification request = RestAssured.given();
        request.headers("Content-Type", "application/x-www-form-urlencoded");
        request.param("grant_type", "client_credentials");
        request.param("scope", "rhapsody-user-svc");
        request.param("client_id", "rh-experience-layer");
        request.param("client_secret", clientSecret);
        request.relaxedHTTPSValidation();

        response = request.post("/auth/realms/" + authEndpoint + "/protocol/openid-connect/token");

        String jsonString = response.asString();
        return JsonPath.from(jsonString).get("access_token");
    }


    /**
     * @param userId
     * @return cart Id
     * This method returns estore cartId for both stg2 and st4 environment
     */
    public static String getEstoreCartId(String userId, String email) {
        String getCartProjectionEndpoint;
        if (Hooks.profile.equals("stg2") || Hooks.profile.equals("stg4")) {
            getCartProjectionEndpoint = "/rh-experience-layer-v1-search/graphql";
        } else {
            getCartProjectionEndpoint = "/rh-experience-layer-v1-stg3/graphql";
        }
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.headers("Content-Type", "application/json");
        response = request.body("{\n" +
                "    \"query\": \"query CartProjection(\\n    $userId: String!, \\n    $email: String!\\n) { \\n    cartProjection(\\n        userId: $userId\\n        email: $email\\n    ) { \\n        id cartType totalLines totalItemQuantity\\n    } \\n} \",\n" +
                "    \"variables\": {\n" +
                "        \"userId\": \"" + userId + "\",\n" +
                "        \"email\": \"" + email + "\"\n" +
                "    }\n" +
                "}").post(getCartProjectionEndpoint);

        String jsonString = response.asString();
        return JsonPath.from(jsonString).get("data.cartProjection.id");
    }


    /**
     * This method set up user configuration based on environment
     */
    public static void setUserEnvironment() {

        if (BASE_URL.contains("stg2")) {
            USER_ID = EstoreLoginStepDefs.USER_ID_STG2;
            addItemEndpoint = "/rh-experience-layer-v1-stg2/graphql";
        } else if (BASE_URL.contains("stg4")) {
            addItemEndpoint = "/rh-experience-layer-v1-search/graphql";
            USER_ID = EstoreLoginStepDefs.USER_ID_STG4;
        } else if (BASE_URL.contains("stg3")) {
            addItemEndpoint = "/rh-experience-layer-v1-stg3/graphql";
            USER_ID = EstoreLoginStepDefs.USER_ID_STG3;
        }
    }

    public void addLineItemsToEstoreCartStg2() {
        setUserEnvironment();

        cartId = getEstoreCartId(USER_ID, USEREMAIL);
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.headers("Content-Type", "application/json");
        request.headers("Cookie", "PF_AEM_PATHS=%5E%2F(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~IN%7C~IN)%7C(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~R%7C~R)%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)R)H%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)OD%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)IN%7C(%3F%3A(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)%7Cgift-registry~)MO%7Cinterior-design~BC%7Cgift-registry~RH%7Cstrada-ledoux~MO)%24; endpoint=develop; fusion_search=true; ui_asset_path=/concierge-ui-v1/");
        response = request.body("{\n" +
                "    \"operationName\": \"AddLineItemsToCart\",\n" +
                "    \"variables\": {\n" +
                "        \"email\": \"" + USEREMAIL + "\",\n" +
                "        \"cartId\": \"" + cartId + "\",\n" +
                "        \"lineItemsInput\": {\n" +
                "            \"items\": [\n" +
                "                {\n" +
                "                    \"productId\": \"prod13800635\",\n" +
                "                    \"sku\": \"17050042 WHT\",\n" +
                "                    \"fusionId\": \"iXzwEtMB1A~prod14280121~search\",\n" +
                "                    \"quantity\": 1,\n" +
                "                    \"brand\": \"RH\",\n" +
                "                    \"giftTo\": \"\",\n" +
                "                    \"giftFrom\": \"\",\n" +
                "                    \"giftMessage\": \"\",\n" +
                "                    \"spoTermsAccepted\": false,\n" +
                "                    \"spoTerms\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    },\n" +
                "    \"query\": \"mutation AddLineItemsToCart($email: String!, $cartId: String!, $lineItemsInput: LineItemsInput!) {\\n  addLineItemsToCart(\\n    email: $email\\n    cartId: $cartId\\n    lineItemsInput: $lineItemsInput\\n  ) {\\n    ...Cart\\n    __typename\\n  }\\n}\\n\\nfragment Cart on CartType {\\n  __typename\\n  id\\n  requestedDeliveryDate\\n  postalCode\\n  country\\n  coordGroupType\\n  coordGroupGroupable\\n  coordGroupUserSelected\\n  orderNumber\\n  cartSavings\\n  isUserMember\\n  giftBoxFee\\n  hasGiftBox\\n  hasGiftFromRegistry\\n  giftRegistryIdList\\n  guest {\\n    userId\\n    ctId\\n    atgUserId\\n    cwUserId\\n    email\\n    type\\n    typeId\\n    sourceCode\\n    shopperRef\\n    __typename\\n  }\\n  removedItems {\\n    invalidRegion {\\n      sku\\n      product {\\n        displayName\\n        imageUrl\\n        targetUrl\\n        alternateImages {\\n          imageUrl\\n          caption\\n          __typename\\n        }\\n        colorizeInfo {\\n          colorizable\\n          colorizeType\\n          multicolor\\n          __typename\\n        }\\n        __typename\\n      }\\n      options {\\n        type\\n        value\\n        __typename\\n      }\\n      __typename\\n    }\\n    __typename\\n  }\\n  lineItems {\\n    restrictions {\\n      ...LineItemRestrictions\\n      __typename\\n    }\\n    restrictionsApply\\n    giftFrom\\n    giftTo\\n    personalizeInfo {\\n      feeHigh\\n      feeLow\\n      selectedFont {\\n        id\\n        displayName\\n        previewImage\\n        image\\n        borders {\\n          id\\n          __typename\\n        }\\n        __typename\\n      }\\n      selectedBorder {\\n        id\\n        image\\n        displayName\\n        minLength\\n        maxLength\\n        numberOfLines\\n        __typename\\n      }\\n      selectedStyle {\\n        id\\n        image\\n        minLength\\n        maxLength\\n        numberOfLines\\n        displayName\\n        previewImage\\n        __typename\\n      }\\n      selectedColor {\\n        id\\n        displayName\\n        image\\n        __typename\\n      }\\n      __typename\\n    }\\n    isMonogramFee\\n    shouldWaiveMonogramFee\\n    shipVia\\n    shipViaCode\\n    isMonogrammable\\n    isPersonalizable\\n    fusionId\\n    monogram {\\n      styleId\\n      description\\n      maxLines\\n      fontCode\\n      fontColorCode\\n      borderCode\\n      lines\\n      fulfillmentCode\\n      __typename\\n    }\\n    lineId\\n    quantity\\n    maxCartQuantity\\n    sku\\n    skuType\\n    brand\\n    displayName\\n    giftBoxDetail {\\n      giftBoxFee\\n      giftBoxCurrencyCode\\n      __typename\\n    }\\n    giftWrap\\n    deliveryEta\\n    deliveryEtaStart\\n    deliveryEtaEnd\\n    coordGroup\\n    registryId\\n    spoTerms\\n    spoTermsAccepted\\n    spoTermsAcceptedDate\\n    isMembershipSku\\n    availabilityInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n        __typename\\n      }\\n      __typename\\n    }\\n    deliveryInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n        __typename\\n      }\\n      __typename\\n    }\\n    productId\\n    product {\\n      displayName\\n      imageUrl\\n      targetUrl\\n      alternateImages {\\n        imageUrl\\n        caption\\n        __typename\\n      }\\n      colorizeInfo {\\n        colorizable\\n        colorizeType\\n        multicolor\\n        __typename\\n      }\\n      __typename\\n    }\\n    price {\\n      itemPrice\\n      memberPrice\\n      priceStatus\\n      priceType\\n      currencyCode\\n      originalPrice\\n      totalPrice\\n      salePrice\\n      finalPrice\\n      salePriceLabel\\n      isOnClearance\\n      isOnSale\\n      showMemberPrice\\n      fees\\n      itemShippingSurcharge\\n      __typename\\n    }\\n    options {\\n      type\\n      value\\n      __typename\\n    }\\n    isGiftFromRegistry\\n    webPurchasable\\n    linkedLineItemId\\n    skuCustomization {\\n      type\\n      mountType\\n      lining\\n      panel\\n      controlType\\n      controlPosition\\n      controlLength\\n      tiltType\\n      controlAndTilt\\n      trim\\n      width\\n      length\\n      diameter\\n      roomLabel\\n      bracketColor\\n      rollType\\n      fulfillmentCode\\n      __typename\\n    }\\n    childSafety\\n    availabilityStatus\\n    __typename\\n  }\\n  shipVia\\n  cartPrice {\\n    subtotal\\n    tax\\n    taxDetail {\\n      amount\\n      name\\n      country\\n      state\\n      imposition\\n      rate\\n      __typename\\n    }\\n    totalPrice\\n    feeTotal\\n    currencyCode\\n    isFree\\n    fees {\\n      feeType\\n      quantity\\n      value\\n      unitCost\\n      linkedLineItemId\\n      __typename\\n    }\\n    freightPrice {\\n      unlimitedFurnitureDelivery\\n      ground\\n      next\\n      second\\n      shippingSurcharge\\n      __typename\\n    }\\n    discounts {\\n      discountCodeTotal\\n      __typename\\n    }\\n    preBillAmount\\n    remainingToBill\\n    __typename\\n  }\\n  shipAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    postalCode\\n    phone\\n    email\\n    firstName\\n    lastName\\n    __typename\\n  }\\n  billAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    postalCode\\n    phone\\n    email\\n    firstName\\n    lastName\\n    __typename\\n  }\\n  payments {\\n    totalAmountRemaining\\n    totalAmountCovered\\n    appliedPayments {\\n      id\\n      paymentMethodType\\n      paymentType\\n      lastFour\\n      amountCovered\\n      currencyCode\\n      rhPaymentPlan\\n      __typename\\n    }\\n    __typename\\n  }\\n  importantInformation {\\n    type\\n    displayText\\n    __typename\\n  }\\n  createdAt\\n  lastModifiedAt\\n  totalLines\\n  discountCodes {\\n    code\\n    name\\n    description\\n    __typename\\n  }\\n  brand\\n  gallery {\\n    galleryId\\n    __typename\\n  }\\n  shipLabelSidemark\\n  giftMessage\\n}\\n\\nfragment LineItemRestrictions on LineItemRestrictionsType {\\n  type\\n  sku\\n  category\\n  states\\n  countries\\n  postalRanges\\n  __typename\\n}\\n\"\n" +
                "}").post(addItemEndpoint);

        String jsonString = response.asString();
        id = JsonPath.from(jsonString).get("data.addLineItemsToCart.id");
        WebDriverRunner.getWebDriver().navigate().refresh();
        generalStepDefs.waitForJSandJQueryToLoad();
    }


    public void addLineItemsToEstoreCartStg3() {
        setUserEnvironment();

        cartId = getEstoreCartId(USER_ID, USEREMAIL);
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.headers("Content-Type", "application/json");
        request.headers("Cookie", "PF_AEM_PATHS=%5E%2F(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~IN%7C~IN)%7C(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~R%7C~R)%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)R)H%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)OD%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)IN%7C(%3F%3A(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)%7Cgift-registry~)MO%7Cinterior-design~BC%7Cgift-registry~RH%7Cstrada-ledoux~MO)%24; endpoint=develop; fusion_search=true; ui_asset_path=/concierge-ui-v1/");
        response = request.body("{\n" +
                "    \"operationName\": \"AddLineItemsToCart\",\n" +
                "    \"variables\": {\n" +
                "        \"email\": \"" + USEREMAIL + "\",\n" +
                "        \"cartId\": \"" + cartId + "\",\n" +
                "        \"lineItemsInput\": {\n" +
                "            \"items\": [\n" +
                "                {\n" +
                "                    \"productId\": \"prod18940179\",\n" +
                "                    \"sku\": \"10024831 WBRN\",\n" +
                "                    \"fusionId\": \"\",\n" +
                "                    \"quantity\": 1,\n" +
                "                    \"brand\": \"RH\",\n" +
                "                    \"giftTo\": \"\",\n" +
                "                    \"giftFrom\": \"\",\n" +
                "                    \"giftMessage\": \"\",\n" +
                "                    \"spoTermsAccepted\": false,\n" +
                "                    \"spoTerms\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    },\n" +
                "    \"query\": \"mutation AddLineItemsToCart($email: String!, $cartId: String!, $lineItemsInput: LineItemsInput!) {\\n  addLineItemsToCart(\\n    email: $email\\n    cartId: $cartId\\n    lineItemsInput: $lineItemsInput\\n  ) {\\n    ...Cart\\n    __typename\\n  }\\n}\\n\\nfragment Cart on CartType {\\n  __typename\\n  id\\n  requestedDeliveryDate\\n  postalCode\\n  country\\n  coordGroupType\\n  coordGroupGroupable\\n  coordGroupUserSelected\\n  orderNumber\\n  cartSavings\\n  isUserMember\\n  giftBoxFee\\n  hasGiftBox\\n  hasGiftFromRegistry\\n  giftRegistryIdList\\n  guest {\\n    userId\\n    ctId\\n    atgUserId\\n    cwUserId\\n    email\\n    type\\n    typeId\\n    sourceCode\\n    shopperRef\\n    __typename\\n  }\\n  removedItems {\\n    invalidRegion {\\n      sku\\n      product {\\n        displayName\\n        imageUrl\\n        targetUrl\\n        alternateImages {\\n          imageUrl\\n          caption\\n          __typename\\n        }\\n        colorizeInfo {\\n          colorizable\\n          colorizeType\\n          multicolor\\n          __typename\\n        }\\n        __typename\\n      }\\n      options {\\n        type\\n        value\\n        __typename\\n      }\\n      __typename\\n    }\\n    __typename\\n  }\\n  lineItems {\\n    restrictions {\\n      ...LineItemRestrictions\\n      __typename\\n    }\\n    restrictionsApply\\n    giftFrom\\n    giftTo\\n    personalizeInfo {\\n      feeHigh\\n      feeLow\\n      selectedFont {\\n        id\\n        displayName\\n        previewImage\\n        image\\n        borders {\\n          id\\n          __typename\\n        }\\n        __typename\\n      }\\n      selectedBorder {\\n        id\\n        image\\n        displayName\\n        minLength\\n        maxLength\\n        numberOfLines\\n        __typename\\n      }\\n      selectedStyle {\\n        id\\n        image\\n        minLength\\n        maxLength\\n        numberOfLines\\n        displayName\\n        previewImage\\n        __typename\\n      }\\n      selectedColor {\\n        id\\n        displayName\\n        image\\n        __typename\\n      }\\n      __typename\\n    }\\n    isMonogramFee\\n    shouldWaiveMonogramFee\\n    shipVia\\n    shipViaCode\\n    isMonogrammable\\n    isPersonalizable\\n    fusionId\\n    monogram {\\n      styleId\\n      description\\n      maxLines\\n      fontCode\\n      fontColorCode\\n      borderCode\\n      lines\\n      fulfillmentCode\\n      __typename\\n    }\\n    lineId\\n    quantity\\n    maxCartQuantity\\n    sku\\n    skuType\\n    brand\\n    displayName\\n    giftBoxDetail {\\n      giftBoxFee\\n      giftBoxCurrencyCode\\n      __typename\\n    }\\n    giftWrap\\n    deliveryEta\\n    deliveryEtaStart\\n    deliveryEtaEnd\\n    coordGroup\\n    registryId\\n    spoTerms\\n    spoTermsAccepted\\n    spoTermsAcceptedDate\\n    isMembershipSku\\n    availabilityInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n        __typename\\n      }\\n      __typename\\n    }\\n    deliveryInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n        __typename\\n      }\\n      __typename\\n    }\\n    productId\\n    product {\\n      displayName\\n      imageUrl\\n      targetUrl\\n      alternateImages {\\n        imageUrl\\n        caption\\n        __typename\\n      }\\n      colorizeInfo {\\n        colorizable\\n        colorizeType\\n        multicolor\\n        __typename\\n      }\\n      __typename\\n    }\\n    price {\\n      itemPrice\\n      memberPrice\\n      priceStatus\\n      priceType\\n      currencyCode\\n      originalPrice\\n      totalPrice\\n      salePrice\\n      finalPrice\\n      salePriceLabel\\n      isOnClearance\\n      isOnSale\\n      showMemberPrice\\n      fees\\n      itemShippingSurcharge\\n      __typename\\n    }\\n    options {\\n      type\\n      value\\n      sortPriority\\n      __typename\\n    }\\n    isGiftFromRegistry\\n    webPurchasable\\n    linkedLineItemId\\n    skuCustomization {\\n      type\\n      mountType\\n      lining\\n      panel\\n      controlType\\n      controlPosition\\n      controlLength\\n      tiltType\\n      controlAndTilt\\n      trim\\n      width\\n      length\\n      diameter\\n      roomLabel\\n      bracketColor\\n      rollType\\n      fulfillmentCode\\n      __typename\\n    }\\n    childSafety\\n    availabilityStatus\\n    __typename\\n  }\\n  shipVia\\n  cartPrice {\\n    subtotal\\n    tax\\n    taxDetail {\\n      amount\\n      name\\n      country\\n      state\\n      imposition\\n      rate\\n      __typename\\n    }\\n    totalPrice\\n    feeTotal\\n    currencyCode\\n    isFree\\n    fees {\\n      feeType\\n      quantity\\n      value\\n      unitCost\\n      linkedLineItemId\\n      __typename\\n    }\\n    freightPrice {\\n      unlimitedFurnitureDelivery\\n      ground\\n      next\\n      second\\n      shippingSurcharge\\n      __typename\\n    }\\n    discounts {\\n      discountCodeTotal\\n      __typename\\n    }\\n    preBillAmount\\n    remainingToBill\\n    __typename\\n  }\\n  shipAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    postalCode\\n    phone\\n    email\\n    firstName\\n    lastName\\n    __typename\\n  }\\n  billAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    postalCode\\n    phone\\n    email\\n    firstName\\n    lastName\\n    __typename\\n  }\\n  payments {\\n    totalAmountRemaining\\n    totalAmountCovered\\n    appliedPayments {\\n      id\\n      paymentMethodType\\n      paymentType\\n      lastFour\\n      amountCovered\\n      currencyCode\\n      rhPaymentPlan\\n      __typename\\n    }\\n    __typename\\n  }\\n  importantInformation {\\n    type\\n    displayText\\n    __typename\\n  }\\n  createdAt\\n  lastModifiedAt\\n  totalLines\\n  discountCodes {\\n    code\\n    name\\n    description\\n    __typename\\n  }\\n  brand\\n  gallery {\\n    galleryId\\n    __typename\\n  }\\n  shipLabelSidemark\\n  giftMessage\\n}\\n\\nfragment LineItemRestrictions on LineItemRestrictionsType {\\n  type\\n  sku\\n  category\\n  states\\n  countries\\n  postalRanges\\n  __typename\\n}\\n\"\n" +
                "}").post(addItemEndpoint);

        String jsonString = response.asString();
        id = JsonPath.from(jsonString).get("data.addLineItemsToCart.id");
        WebDriverRunner.getWebDriver().navigate().refresh();
        generalStepDefs.waitForJSandJQueryToLoad();
    }

    public void addLineItemsToEstoreCartWithProvidedSkuStg2(String prod, String skuid) {
        setUserEnvironment();

        cartId = getEstoreCartId(USER_ID, USEREMAIL);
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.headers("Content-Type", "application/json");
        request.headers("Cookie", "PF_AEM_PATHS=%5E%2F(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~IN%7C~IN)%7C(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~R%7C~R)%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)R)H%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)OD%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)IN%7C(%3F%3A(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)%7Cgift-registry~)MO%7Cinterior-design~BC%7Cgift-registry~RH%7Cstrada-ledoux~MO)%24; endpoint=develop; fusion_search=true; ui_asset_path=/concierge-ui-v1/");
        response = request.body("{\n" +
                "    \"operationName\": \"AddLineItemsToCart\",\n" +
                "    \"variables\": {\n" +
                "        \"email\": \"" + USEREMAIL + "\",\n" +
                "        \"cartId\": \"" + cartId + "\",\n" +
                "        \"lineItemsInput\": {\n" +
                "            \"items\": [\n" +
                "                {\n" +
                "                    \"productId\": \"" + prod + "\",\n" +
                "                    \"sku\": \"" + skuid + "\",\n" +
                "                    \"fusionId\": \"\",\n" +
                "                    \"quantity\": 1,\n" +
                "                    \"brand\": \"RH\",\n" +
                "                    \"giftTo\": \"\",\n" +
                "                    \"giftFrom\": \"\",\n" +
                "                    \"giftMessage\": \"\",\n" +
                "                    \"spoTermsAccepted\": false,\n" +
                "                    \"spoTerms\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    },\n" +
                "    \"query\": \"mutation AddLineItemsToCart($email: String!, $cartId: String!, $lineItemsInput: LineItemsInput!) {\\n  addLineItemsToCart(\\n    email: $email\\n    cartId: $cartId\\n    lineItemsInput: $lineItemsInput\\n  ) {\\n    ...Cart\\n    __typename\\n  }\\n}\\n\\nfragment Cart on CartType {\\n  __typename\\n  id\\n  requestedDeliveryDate\\n  postalCode\\n  country\\n  coordGroupType\\n  coordGroupGroupable\\n  coordGroupUserSelected\\n  orderNumber\\n  cartSavings\\n  isUserMember\\n  giftBoxFee\\n  hasGiftBox\\n  hasGiftFromRegistry\\n  giftRegistryIdList\\n  guest {\\n    userId\\n    ctId\\n    atgUserId\\n    cwUserId\\n    email\\n    type\\n    typeId\\n    sourceCode\\n    shopperRef\\n    __typename\\n  }\\n  removedItems {\\n    invalidRegion {\\n      sku\\n      product {\\n        displayName\\n        imageUrl\\n        targetUrl\\n        alternateImages {\\n          imageUrl\\n          caption\\n          __typename\\n        }\\n        colorizeInfo {\\n          colorizable\\n          colorizeType\\n          multicolor\\n          __typename\\n        }\\n        __typename\\n      }\\n      options {\\n        type\\n        value\\n        __typename\\n      }\\n      __typename\\n    }\\n    __typename\\n  }\\n  lineItems {\\n    restrictions {\\n      ...LineItemRestrictions\\n      __typename\\n    }\\n    restrictionsApply\\n    giftFrom\\n    giftTo\\n    personalizeInfo {\\n      feeHigh\\n      feeLow\\n      selectedFont {\\n        id\\n        displayName\\n        previewImage\\n        image\\n        borders {\\n          id\\n          __typename\\n        }\\n        __typename\\n      }\\n      selectedBorder {\\n        id\\n        image\\n        displayName\\n        minLength\\n        maxLength\\n        numberOfLines\\n        __typename\\n      }\\n      selectedStyle {\\n        id\\n        image\\n        minLength\\n        maxLength\\n        numberOfLines\\n        displayName\\n        previewImage\\n        __typename\\n      }\\n      selectedColor {\\n        id\\n        displayName\\n        image\\n        __typename\\n      }\\n      __typename\\n    }\\n    isMonogramFee\\n    shouldWaiveMonogramFee\\n    shipVia\\n    shipViaCode\\n    isMonogrammable\\n    isPersonalizable\\n    fusionId\\n    monogram {\\n      styleId\\n      description\\n      maxLines\\n      fontCode\\n      fontColorCode\\n      borderCode\\n      lines\\n      fulfillmentCode\\n      __typename\\n    }\\n    lineId\\n    quantity\\n    maxCartQuantity\\n    sku\\n    skuType\\n    brand\\n    displayName\\n    giftBoxDetail {\\n      giftBoxFee\\n      giftBoxCurrencyCode\\n      __typename\\n    }\\n    giftWrap\\n    deliveryEta\\n    deliveryEtaStart\\n    deliveryEtaEnd\\n    coordGroup\\n    registryId\\n    spoTerms\\n    spoTermsAccepted\\n    spoTermsAcceptedDate\\n    isMembershipSku\\n    availabilityInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n        __typename\\n      }\\n      __typename\\n    }\\n    deliveryInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n        __typename\\n      }\\n      __typename\\n    }\\n    productId\\n    product {\\n      displayName\\n      imageUrl\\n      targetUrl\\n      alternateImages {\\n        imageUrl\\n        caption\\n        __typename\\n      }\\n      colorizeInfo {\\n        colorizable\\n        colorizeType\\n        multicolor\\n        __typename\\n      }\\n      __typename\\n    }\\n    price {\\n      itemPrice\\n      memberPrice\\n      priceStatus\\n      priceType\\n      currencyCode\\n      originalPrice\\n      totalPrice\\n      salePrice\\n      finalPrice\\n      salePriceLabel\\n      isOnClearance\\n      isOnSale\\n      showMemberPrice\\n      fees\\n      itemShippingSurcharge\\n      __typename\\n    }\\n    options {\\n      type\\n      value\\n      __typename\\n    }\\n    isGiftFromRegistry\\n    webPurchasable\\n    linkedLineItemId\\n    skuCustomization {\\n      type\\n      mountType\\n      lining\\n      panel\\n      controlType\\n      controlPosition\\n      controlLength\\n      tiltType\\n      controlAndTilt\\n      trim\\n      width\\n      length\\n      diameter\\n      roomLabel\\n      bracketColor\\n      rollType\\n      fulfillmentCode\\n      __typename\\n    }\\n    childSafety\\n    availabilityStatus\\n    __typename\\n  }\\n  shipVia\\n  cartPrice {\\n    subtotal\\n    tax\\n    taxDetail {\\n      amount\\n      name\\n      country\\n      state\\n      imposition\\n      rate\\n      __typename\\n    }\\n    totalPrice\\n    feeTotal\\n    currencyCode\\n    isFree\\n    fees {\\n      feeType\\n      quantity\\n      value\\n      unitCost\\n      linkedLineItemId\\n      __typename\\n    }\\n    freightPrice {\\n      unlimitedFurnitureDelivery\\n      ground\\n      next\\n      second\\n      shippingSurcharge\\n      __typename\\n    }\\n    discounts {\\n      discountCodeTotal\\n      __typename\\n    }\\n    preBillAmount\\n    remainingToBill\\n    __typename\\n  }\\n  shipAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    postalCode\\n    phone\\n    email\\n    firstName\\n    lastName\\n    __typename\\n  }\\n  billAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    postalCode\\n    phone\\n    email\\n    firstName\\n    lastName\\n    __typename\\n  }\\n  payments {\\n    totalAmountRemaining\\n    totalAmountCovered\\n    appliedPayments {\\n      id\\n      paymentMethodType\\n      paymentType\\n      lastFour\\n      amountCovered\\n      currencyCode\\n      rhPaymentPlan\\n      __typename\\n    }\\n    __typename\\n  }\\n  importantInformation {\\n    type\\n    displayText\\n    __typename\\n  }\\n  createdAt\\n  lastModifiedAt\\n  totalLines\\n  discountCodes {\\n    code\\n    name\\n    description\\n    __typename\\n  }\\n  brand\\n  gallery {\\n    galleryId\\n    __typename\\n  }\\n  shipLabelSidemark\\n  giftMessage\\n}\\n\\nfragment LineItemRestrictions on LineItemRestrictionsType {\\n  type\\n  sku\\n  category\\n  states\\n  countries\\n  postalRanges\\n  __typename\\n}\\n\"\n" +
                "}").post(addItemEndpoint);

        String jsonString = response.asString();
        id = JsonPath.from(jsonString).get("data.addLineItemsToCart.id");
        WebDriverRunner.getWebDriver().navigate().refresh();
        generalStepDefs.waitForJSandJQueryToLoad();
    }

    /**
     * This method adds line items to cart
     */
    public void addLineItemsToEstoreCartWithProvidedSkuStg4(String skuid, String prod) {
        setUserEnvironment();
        cartId = getEstoreCartId(USER_ID, USEREMAIL);
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.headers("Content-Type", "application/json");
        request.headers("Cookie", "PF_AEM_PATHS=%5E%2F(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~IN%7C~IN)%7C(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~R%7C~R)%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)R)H%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)OD%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)IN%7C(%3F%3A(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)%7Cgift-registry~)MO%7Cinterior-design~BC%7Cgift-registry~RH%7Cstrada-ledoux~MO)%24; endpoint=develop; fusion_search=true; ui_asset_path=/concierge-ui-v1/");
        response = request.body("{\n" +
                "    \"operationName\": \"AddLineItemsToCart\",\n" +
                "    \"variables\": {\n" +
                "        \"email\": \"" + USEREMAIL + "\",\n" +
                "        \"cartId\": \"" + cartId + "\",\n" +
                "        \"lineItemsInput\": {\n" +
                "            \"items\": [\n" +
                "                {\n" +
                "                    \"productId\": \"" + prod + "\",\n" +
                "                    \"sku\": \"" + skuid + "\",\n" +
                "                    \"quantity\": 1,\n" +
                "                    \"brand\": \"RH\",\n" +
                "                    \"giftTo\": \"\",\n" +
                "                    \"giftFrom\": \"\",\n" +
                "                    \"giftMessage\": \"\",\n" +
                "                    \"spoTermsAccepted\": false,\n" +
                "                    \"spoTerms\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    },\n" +
                "    \"query\": \"mutation AddLineItemsToCart($email: String!, $cartId: String!, $lineItemsInput: LineItemsInput!) {\\n  addLineItemsToCart(\\n    email: $email\\n    cartId: $cartId\\n    lineItemsInput: $lineItemsInput\\n  ) {\\n    ...Cart\\n    __typename\\n  }\\n}\\n\\nfragment Cart on CartType {\\n  __typename\\n  id\\n  requestedDeliveryDate\\n  postalCode\\n  country\\n  coordGroupType\\n  coordGroupGroupable\\n  coordGroupUserSelected\\n  orderNumber\\n  cartSavings\\n  memberPrice\\n  isUserMember\\n  giftBoxFee\\n  hasGiftBox\\n  hasGiftFromRegistry\\n  giftRegistryIdList\\n  guest {\\n    userId\\n    ctId\\n    atgUserId\\n    cwUserId\\n    email\\n    type\\n    typeId\\n    sourceCode\\n    shopperRef\\n    __typename\\n  }\\n  removedItems {\\n    invalidRegion {\\n      sku\\n      product {\\n        displayName\\n        imageUrl\\n        targetUrl\\n        alternateImages {\\n          imageUrl\\n          caption\\n          __typename\\n        }\\n        colorizeInfo {\\n          colorizable\\n          colorizeType\\n          multicolor\\n          __typename\\n        }\\n        restrictions {\\n          spo\\n          returnPolicyMessage\\n          countryRestrictions\\n          mattressFeeLocation\\n          preBillMessage\\n          additionalMessages {\\n            curbsideMessage\\n            assemblyMessage\\n            giftCardMessage\\n            railroadMessage\\n            mattressFeeMessage\\n            cancellableMessage\\n            finalSaleMessage\\n            __typename\\n          }\\n          __typename\\n        }\\n        __typename\\n      }\\n      options {\\n        type\\n        value\\n        __typename\\n      }\\n      __typename\\n    }\\n    __typename\\n  }\\n  lineItems {\\n    giftFrom\\n    giftTo\\n    personalizeInfo {\\n      feeHigh\\n      feeLow\\n      selectedFont {\\n        id\\n        displayName\\n        previewImage\\n        image\\n        borders {\\n          id\\n          __typename\\n        }\\n        __typename\\n      }\\n      selectedBorder {\\n        id\\n        image\\n        displayName\\n        minLength\\n        maxLength\\n        numberOfLines\\n        __typename\\n      }\\n      selectedStyle {\\n        id\\n        image\\n        minLength\\n        maxLength\\n        numberOfLines\\n        displayName\\n        previewImage\\n        __typename\\n      }\\n      selectedColor {\\n        id\\n        displayName\\n        image\\n        __typename\\n      }\\n      __typename\\n    }\\n    isMonogramFee\\n    shouldWaiveMonogramFee\\n    shipVia\\n    shipViaCode\\n    isMonogrammable\\n    isPersonalizable\\n    fusionId\\n    monogram {\\n      styleId\\n      description\\n      maxLines\\n      fontCode\\n      fontColorCode\\n      borderCode\\n      lines\\n      fulfillmentCode\\n      __typename\\n    }\\n    lineId\\n    quantity\\n    maxCartQuantity\\n    sku\\n    skuType\\n    brand\\n    displayName\\n    giftBoxDetail {\\n      giftBoxFee\\n      giftBoxCurrencyCode\\n      __typename\\n    }\\n    giftWrap\\n    deliveryEta\\n    deliveryEtaStart\\n    deliveryEtaEnd\\n    coordGroup\\n    registryId\\n    spoTerms\\n    spoTermsAccepted\\n    spoTermsAcceptedDate\\n    isMembershipSku\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n        category\\n        __typename\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n        __typename\\n      }\\n      specialItemRestriction\\n      __typename\\n    }\\n    availabilityInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n        __typename\\n      }\\n      __typename\\n    }\\n    deliveryInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n        __typename\\n      }\\n      __typename\\n    }\\n    productId\\n    product {\\n      displayName\\n      imageUrl\\n      targetUrl\\n      alternateImages {\\n        imageUrl\\n        caption\\n        __typename\\n      }\\n      colorizeInfo {\\n        colorizable\\n        colorizeType\\n        multicolor\\n        __typename\\n      }\\n      restrictions {\\n        spo\\n        returnPolicyMessage\\n        countryRestrictions\\n        mattressFeeLocation\\n        preBillMessage\\n        additionalMessages {\\n          curbsideMessage\\n          assemblyMessage\\n          giftCardMessage\\n          railroadMessage\\n          mattressFeeMessage\\n          cancellableMessage\\n          finalSaleMessage\\n          __typename\\n        }\\n        __typename\\n      }\\n      __typename\\n    }\\n    price {\\n      itemPrice\\n      memberPrice\\n      priceStatus\\n      priceType\\n      currencyCode\\n      originalPrice\\n      totalPrice\\n      salePrice\\n      finalPrice\\n      salePriceLabel\\n      isOnClearance\\n      isOnSale\\n      showMemberPrice\\n      fees\\n      itemShippingSurcharge\\n      __typename\\n    }\\n    options {\\n      type\\n      value\\n      __typename\\n    }\\n    isGiftFromRegistry\\n    webPurchasable\\n    linkedLineItemId\\n    skuCustomization {\\n      type\\n      mountType\\n      lining\\n      panel\\n      controlType\\n      controlPosition\\n      controlLength\\n      tiltType\\n      controlAndTilt\\n      trim\\n      width\\n      length\\n      diameter\\n      roomLabel\\n      bracketColor\\n      rollType\\n      fulfillmentCode\\n      __typename\\n    }\\n    childSafety\\n    __typename\\n  }\\n  shipVia\\n  cartPrice {\\n    subtotal\\n    tax\\n    taxDetail {\\n      amount\\n      name\\n      country\\n      state\\n      imposition\\n      rate\\n      __typename\\n    }\\n    totalPrice\\n    feeTotal\\n    currencyCode\\n    isFree\\n    fees {\\n      feeType\\n      quantity\\n      value\\n      unitCost\\n      linkedLineItemId\\n      __typename\\n    }\\n    freightPrice {\\n      unlimitedFurnitureDelivery\\n      ground\\n      next\\n      second\\n      shippingSurcharge\\n      __typename\\n    }\\n    discounts {\\n      discountCodeTotal\\n      __typename\\n    }\\n    __typename\\n  }\\n  shipAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    postalCode\\n    phone\\n    email\\n    firstName\\n    lastName\\n    __typename\\n  }\\n  billAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    postalCode\\n    phone\\n    email\\n    firstName\\n    lastName\\n    __typename\\n  }\\n  payments {\\n    totalAmountRemaining\\n    totalAmountCovered\\n    appliedPayments {\\n      id\\n      paymentMethodType\\n      paymentType\\n      lastFour\\n      amountCovered\\n      currencyCode\\n      rhPaymentPlan\\n      __typename\\n    }\\n    __typename\\n  }\\n  importantInformation {\\n    type\\n    displayText\\n    __typename\\n  }\\n  createdAt\\n  lastModifiedAt\\n  totalLines\\n  discountCodes {\\n    code\\n    name\\n    description\\n    __typename\\n  }\\n  brand\\n  gallery {\\n    galleryId\\n    __typename\\n  }\\n  shipLabelSidemark\\n  giftMessage\\n}\\n\"\n" +
                "}").post(addItemEndpoint);

        String jsonString = response.asString();
        id = JsonPath.from(jsonString).get("data.addLineItemsToCart.id");
        WebDriverRunner.getWebDriver().navigate().refresh();
        generalStepDefs.waitForJSandJQueryToLoad();
    }

    /**
     * This method adds line items to cart
     */
    public void addLineItemsToEstoreCart() {
        setUserEnvironment();
        cartId = getEstoreCartId(USER_ID, USEREMAIL);
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.headers("Content-Type", "application/json");
        request.headers("Cookie", "PF_AEM_PATHS=%5E%2F(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~IN%7C~IN)%7C(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~R%7C~R)%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)R)H%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)OD%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)IN%7C(%3F%3A(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)%7Cgift-registry~)MO%7Cinterior-design~BC%7Cgift-registry~RH%7Cstrada-ledoux~MO)%24; endpoint=develop; fusion_search=true; ui_asset_path=/concierge-ui-v1/");
        response = request.body("{\n" +
                "    \"operationName\": \"AddLineItemsToCart\",\n" +
                "    \"variables\": {\n" +
                "        \"email\": \"" + USEREMAIL + "\",\n" +
                "        \"cartId\": \"" + cartId + "\",\n" +
                "        \"lineItemsInput\": {\n" +
                "            \"items\": [\n" +
                "                {\n" +
                "                    \"productId\": \"prod25280088\",\n" +
                "                    \"sku\": \"17050042 WHT\",\n" +
                "                    \"quantity\": 1,\n" +
                "                    \"brand\": \"RH\",\n" +
                "                    \"giftTo\": \"\",\n" +
                "                    \"giftFrom\": \"\",\n" +
                "                    \"giftMessage\": \"\",\n" +
                "                    \"spoTermsAccepted\": false,\n" +
                "                    \"spoTerms\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    },\n" +
                "    \"query\": \"mutation AddLineItemsToCart($email: String!, $cartId: String!, $lineItemsInput: LineItemsInput!) {\\n  addLineItemsToCart(\\n    email: $email\\n    cartId: $cartId\\n    lineItemsInput: $lineItemsInput\\n  ) {\\n    ...Cart\\n    __typename\\n  }\\n}\\n\\nfragment Cart on CartType {\\n  __typename\\n  id\\n  requestedDeliveryDate\\n  postalCode\\n  country\\n  coordGroupType\\n  coordGroupGroupable\\n  coordGroupUserSelected\\n  orderNumber\\n  cartSavings\\n  memberPrice\\n  isUserMember\\n  giftBoxFee\\n  hasGiftBox\\n  hasGiftFromRegistry\\n  giftRegistryIdList\\n  guest {\\n    userId\\n    ctId\\n    atgUserId\\n    cwUserId\\n    email\\n    type\\n    typeId\\n    sourceCode\\n    shopperRef\\n    __typename\\n  }\\n  removedItems {\\n    invalidRegion {\\n      sku\\n      product {\\n        displayName\\n        imageUrl\\n        targetUrl\\n        alternateImages {\\n          imageUrl\\n          caption\\n          __typename\\n        }\\n        colorizeInfo {\\n          colorizable\\n          colorizeType\\n          multicolor\\n          __typename\\n        }\\n        restrictions {\\n          spo\\n          returnPolicyMessage\\n          countryRestrictions\\n          mattressFeeLocation\\n          preBillMessage\\n          additionalMessages {\\n            curbsideMessage\\n            assemblyMessage\\n            giftCardMessage\\n            railroadMessage\\n            mattressFeeMessage\\n            cancellableMessage\\n            finalSaleMessage\\n            __typename\\n          }\\n          __typename\\n        }\\n        __typename\\n      }\\n      options {\\n        type\\n        value\\n        __typename\\n      }\\n      __typename\\n    }\\n    __typename\\n  }\\n  lineItems {\\n    giftFrom\\n    giftTo\\n    personalizeInfo {\\n      feeHigh\\n      feeLow\\n      selectedFont {\\n        id\\n        displayName\\n        previewImage\\n        image\\n        borders {\\n          id\\n          __typename\\n        }\\n        __typename\\n      }\\n      selectedBorder {\\n        id\\n        image\\n        displayName\\n        minLength\\n        maxLength\\n        numberOfLines\\n        __typename\\n      }\\n      selectedStyle {\\n        id\\n        image\\n        minLength\\n        maxLength\\n        numberOfLines\\n        displayName\\n        previewImage\\n        __typename\\n      }\\n      selectedColor {\\n        id\\n        displayName\\n        image\\n        __typename\\n      }\\n      __typename\\n    }\\n    isMonogramFee\\n    shouldWaiveMonogramFee\\n    shipVia\\n    shipViaCode\\n    isMonogrammable\\n    isPersonalizable\\n    fusionId\\n    monogram {\\n      styleId\\n      description\\n      maxLines\\n      fontCode\\n      fontColorCode\\n      borderCode\\n      lines\\n      fulfillmentCode\\n      __typename\\n    }\\n    lineId\\n    quantity\\n    maxCartQuantity\\n    sku\\n    skuType\\n    brand\\n    displayName\\n    giftBoxDetail {\\n      giftBoxFee\\n      giftBoxCurrencyCode\\n      __typename\\n    }\\n    giftWrap\\n    deliveryEta\\n    deliveryEtaStart\\n    deliveryEtaEnd\\n    coordGroup\\n    registryId\\n    spoTerms\\n    spoTermsAccepted\\n    spoTermsAcceptedDate\\n    isMembershipSku\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n        category\\n        __typename\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n        __typename\\n      }\\n      specialItemRestriction\\n      __typename\\n    }\\n    availabilityInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n        __typename\\n      }\\n      __typename\\n    }\\n    deliveryInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n        __typename\\n      }\\n      __typename\\n    }\\n    productId\\n    product {\\n      displayName\\n      imageUrl\\n      targetUrl\\n      alternateImages {\\n        imageUrl\\n        caption\\n        __typename\\n      }\\n      colorizeInfo {\\n        colorizable\\n        colorizeType\\n        multicolor\\n        __typename\\n      }\\n      restrictions {\\n        spo\\n        returnPolicyMessage\\n        countryRestrictions\\n        mattressFeeLocation\\n        preBillMessage\\n        additionalMessages {\\n          curbsideMessage\\n          assemblyMessage\\n          giftCardMessage\\n          railroadMessage\\n          mattressFeeMessage\\n          cancellableMessage\\n          finalSaleMessage\\n          __typename\\n        }\\n        __typename\\n      }\\n      __typename\\n    }\\n    price {\\n      itemPrice\\n      memberPrice\\n      priceStatus\\n      priceType\\n      currencyCode\\n      originalPrice\\n      totalPrice\\n      salePrice\\n      finalPrice\\n      salePriceLabel\\n      isOnClearance\\n      isOnSale\\n      showMemberPrice\\n      fees\\n      itemShippingSurcharge\\n      __typename\\n    }\\n    options {\\n      type\\n      value\\n      __typename\\n    }\\n    isGiftFromRegistry\\n    webPurchasable\\n    linkedLineItemId\\n    skuCustomization {\\n      type\\n      mountType\\n      lining\\n      panel\\n      controlType\\n      controlPosition\\n      controlLength\\n      tiltType\\n      controlAndTilt\\n      trim\\n      width\\n      length\\n      diameter\\n      roomLabel\\n      bracketColor\\n      rollType\\n      fulfillmentCode\\n      __typename\\n    }\\n    childSafety\\n    __typename\\n  }\\n  shipVia\\n  cartPrice {\\n    subtotal\\n    tax\\n    taxDetail {\\n      amount\\n      name\\n      country\\n      state\\n      imposition\\n      rate\\n      __typename\\n    }\\n    totalPrice\\n    feeTotal\\n    currencyCode\\n    isFree\\n    fees {\\n      feeType\\n      quantity\\n      value\\n      unitCost\\n      linkedLineItemId\\n      __typename\\n    }\\n    freightPrice {\\n      unlimitedFurnitureDelivery\\n      ground\\n      next\\n      second\\n      shippingSurcharge\\n      __typename\\n    }\\n    discounts {\\n      discountCodeTotal\\n      __typename\\n    }\\n    __typename\\n  }\\n  shipAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    postalCode\\n    phone\\n    email\\n    firstName\\n    lastName\\n    __typename\\n  }\\n  billAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    postalCode\\n    phone\\n    email\\n    firstName\\n    lastName\\n    __typename\\n  }\\n  payments {\\n    totalAmountRemaining\\n    totalAmountCovered\\n    appliedPayments {\\n      id\\n      paymentMethodType\\n      paymentType\\n      lastFour\\n      amountCovered\\n      currencyCode\\n      rhPaymentPlan\\n      __typename\\n    }\\n    __typename\\n  }\\n  importantInformation {\\n    type\\n    displayText\\n    __typename\\n  }\\n  createdAt\\n  lastModifiedAt\\n  totalLines\\n  discountCodes {\\n    code\\n    name\\n    description\\n    __typename\\n  }\\n  brand\\n  gallery {\\n    galleryId\\n    __typename\\n  }\\n  shipLabelSidemark\\n  giftMessage\\n}\\n\"\n" +
                "}").post(addItemEndpoint);

        String jsonString = response.asString();
        id = JsonPath.from(jsonString).get("data.addLineItemsToCart.id");
        WebDriverRunner.getWebDriver().navigate().refresh();
        generalStepDefs.waitForJSandJQueryToLoad();
    }

    /**
     * @param paymentType
     * @param number
     * @param cvc
     * @param expirationDate This method execute payment with provided method
     */
    public void payWith(String paymentType, String number, String cvc, String expirationDate) {

        if (!paymentScreen.getChoosePaymentMethodBtn().isDisplayed()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        paymentScreen.getChoosePaymentMethodBtn().should(Condition.be(visible), Duration.ofSeconds(60));
        Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment.selectByValue(paymentType);

        $(By.cssSelector("iframe[title='Iframe for secured card number']")).should(Condition.be(visible), Duration.ofMinutes(2));
        SelenideElement selenideElement = $(By.cssSelector("iframe[title='Iframe for secured card number']"));
        switchTo().frame(selenideElement);
        estorePaymentPage.getCardNumberField().setValue(number);
        switchTo().defaultContent();

        $(By.xpath("//div[contains(@class,'securityCode')]//iframe[@class='js-iframe']")).should(Condition.be(visible), Duration.ofMinutes(2));
        switchTo().frame($(By.xpath("//div[contains(@class,'securityCode')]//iframe[@class='js-iframe']")));

        estorePaymentPage.getCvcField().setValue(cvc);
        switchTo().defaultContent();

        $(By.xpath("//iframe[@title='Iframe for secured card expiry date']")).should(Condition.be(visible), Duration.ofMinutes(2));
        switchTo().frame($(By.xpath("//iframe[@title='Iframe for secured card expiry date']")));

        estorePaymentPage.getExpiryDateField().setValue(expirationDate);
        switchTo().defaultContent();
    }


    /**
     * @param ls1
     * @param ls2 This method compare two lists
     * @return
     */
    public static boolean compareList(List ls1, List ls2) {
        return ls1.toString().contentEquals(ls2.toString()) ? true : false;
    }


    public void verifyCategories(List<String> categoryInStockExpected, int indexItem) {
        List<String> categoryInStockActual = new ArrayList<>();
        conciergeUserAccountPage.getMenuItems().get(0).should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getMenuItems().get(indexItem).scrollIntoView(true);
        conciergeUserAccountPage.getMenuItems().get(indexItem).click();
        sleep(1);
        conciergeUserAccountPage.getMenuItems().get(indexItem).click();

        for (int i = 0; i < conciergeUserAccountPage.getItemSubCategory().size(); i++) {
            isElementVisible("//div[2]//ul[@class='MuiList-root']/li[@class='MuiListItem-root']");
            categoryInStockActual.add(conciergeUserAccountPage.getItemSubCategory().get(i).getText());
        }
        assertThat(categoryInStockActual).hasSameElementsAs(categoryInStockExpected);
    }


    /**
     * @param min - min border of value
     * @param max Generate random number in range
     * @return - random number in range
     */
    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


    /**
     * @param n - length of required string
     * @return - random string
     */
    public String getAlphaNumericString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
        StringBuilder stringBuilder = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (AlphaNumericString.length()
                    * Math.random());
            stringBuilder.append(AlphaNumericString
                    .charAt(index));
        }
        return stringBuilder.toString();
    }

    /**
     * @param min - min border of value
     * @param max - max border of value
     * @return
     */
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


}


