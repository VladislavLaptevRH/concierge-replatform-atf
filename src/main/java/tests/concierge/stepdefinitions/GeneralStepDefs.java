package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.concierge.pageObject.*;
import tests.utility.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.with;

public class GeneralStepDefs {
    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage();
    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen();
    PaymentScreen paymentScreen = new PaymentScreen();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeAddressScreen conciergeAddressScreen = new ConciergeAddressScreen();
    static WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(30));
    public static String id;
    public static String error;
    private static Response response;
    private static String authEndpoint;
    private static String clientSecret;
    private static String USER_ID;
    private static final String USEREMAIL = "automationassociate@rh.com";
    private static final String PASSWORD = "Test@@123";
    public static final String BASE_URL = Hooks.conciergeBaseURL;
    private static String addItemEndpoint;
    private static String cartId;
    private static Logger log = LoggerFactory.getLogger(FilterStepDefs.class);

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete");
        wait.until(pageLoadCondition);
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

        if(!conciergeLoginPage.getLocationDropDownList().isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }

        conciergeLoginPage.getLocationDropDownList().click();
        $(By.xpath("//*[text() = '5: Newport Beach']")).click();
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
        conciergeAddressScreen.getShippingAddressText().shouldHave(text("Shipping Address"), Duration.ofSeconds(40));
        conciergeAddressScreen.getBillingAddressText().shouldHave(text("Billing Address"), Duration.ofSeconds(40));

        if(conciergeAddressScreen.getSoldToTaxExempt().isDisplayed()){
            clearField(conciergeAddressScreen.getSoldToTaxExempt());
            conciergeAddressScreen.getSoldToTaxExempt().setValue("111");
        }

        clearField(checkoutAddressScreen.getFirstNameInpt());
        checkoutAddressScreen.getFirstNameInpt().setValue("QAFirst");

        clearField(checkoutAddressScreen.getLastNameField());
        checkoutAddressScreen.getLastNameField().setValue("Automation");

        if(checkoutAddressScreen.getCompanyNameField().isDisplayed()){
            clearField(checkoutAddressScreen.getCompanyNameField());
            checkoutAddressScreen.getCompanyNameField().setValue("AutomationCompany");
        } else {
            System.out.println("This field is unavailable");
        }

        clearField(checkoutAddressScreen.getStreetAddressField());
        checkoutAddressScreen.getStreetAddressField().setValue("North 16th Street");
        with().pollInterval(2, SECONDS).await().until(() -> true);
        checkoutAddressScreen.getStreetAddressField().sendKeys(Keys.ENTER);

        clearField(checkoutAddressScreen.getAptFloorSuiteField());
        checkoutAddressScreen.getAptFloorSuiteField().setValue("QaApartment");

        clearField(checkoutAddressScreen.getCityField());
        checkoutAddressScreen.getCityField().setValue("Phoenix");

        clearField(checkoutAddressScreen.getPhoneField());
        checkoutAddressScreen.getPhoneField().setValue("1241312319");

        executeJavaScript("arguments[0].click();", checkoutAddressScreen.getBillingAddressAsShippingCheckBox());

        conciergeAddressScreen.getBillingAddressText().should(visible, Duration.ofSeconds(12));
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

            Select selectState = new Select(checkoutAddressScreen.getStateField());
            selectState.selectByValue("AZ");
          if(checkoutAddressScreen.getZipPostalCodeField().isDisplayed()){
              clearField(checkoutAddressScreen.getZipPostalCodeField());
              checkoutAddressScreen.getZipPostalCodeField().setValue(zipCode);
              } else {
              System.out.println("Zip code unavailable");
          }

        if (state.equals("NY")) {
            SelenideElement stateNyButton = $(By.xpath("(//div[contains(@class,'Mui')]//select[contains(@class,'Mui')])[2]//option[@value='" + state + "']"));
            stateNyButton.click();
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
     * @param paymentType
     * @param number
     * @param cvc
     * @param expirationDate This method execute payment with provided method
     */
    public void payWith(String paymentType, String number, String cvc, String expirationDate) {

        paymentScreen.getChoosePaymentMethodBtn().should(Condition.be(visible), Duration.ofSeconds(35));
        Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment.selectByValue("CC");

        $(By.cssSelector("iframe[title='Iframe for secured card number']")).should(Condition.be(visible), Duration.ofMinutes(2));
        SelenideElement selenideElement = $(By.cssSelector("iframe[title='Iframe for secured card number']"));
        switchTo().frame(selenideElement);
        paymentScreen.getCardNumberField().setValue(number);
        switchTo().defaultContent();
        with().pollInterval(1, SECONDS).await().until(() -> true);
        $(By.xpath("//div[contains(@class,'securityCode')]//iframe[@class='js-iframe']")).should(Condition.be(visible), Duration.ofMinutes(2));
        switchTo().frame($(By.xpath("//div[contains(@class,'securityCode')]//iframe[@class='js-iframe']")));

        paymentScreen.getCvcField().setValue(cvc);
        switchTo().defaultContent();
        with().pollInterval(1, SECONDS).await().until(() -> true);
        $(By.xpath("//div[contains(@class,'expiryDate')]//iframe[@title='Iframe for secured card expiry date']")).should(Condition.be(visible), Duration.ofMinutes(2));
        switchTo().frame($(By.xpath("//div[contains(@class,'expiryDate')]//iframe[@title='Iframe for secured card expiry date']")));

        paymentScreen.getExpiryDateField().setValue(expirationDate);
        switchTo().defaultContent();
        with().pollInterval(1, SECONDS).await().until(() -> true);
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

    /**
     * @praram email
     * @param userId
     * @returns cartId
     * */
    public static String createtCartId (String email, String userId) {
        RestAssured.baseURI = "https://development.internal.rhapsodynonprod.com";
        RequestSpecification request = RestAssured.given();
        request.relaxedHTTPSValidation();
        request.headers("Content-Type", "application/json");
        request.headers("X-User-Scope", "ZDFlNjhkMDQ0NmM5NDRjNzhkZGFhNGE4MjQwZDVhNGZAc29tZS5jb206IFsic3RhbmRhcmQiXQ==");
        request.headers("X-B3-SpanID","1111111111111");
        response = request.body("{\n" +
                        "    \"postalCode\": \"12345\",\n" +
                        "    \"country\": \"US\",\n" +
                        "    \"guest\": {\n" +
                        "        \"email\": \""+email+"\",\n" +
                        "        \"userId\": \""+userId+"\"\n" +
                        "    }\n" +
                        "}").post("/rhdo-cart-broker-v1/carts");

        String jsonString = response.asString();
        return JsonPath.from(jsonString).get("id");
    }

    /**
     * @param userId
     * @returns cartId
     * */

    public static String getCurrentCartId(String userId) {

        if (Hooks.conciergeURL.contains("stg2")) {
            RestAssured.baseURI = "https://staging.internal.rhapsodynonprod.com/rhdo-cart-broker-v1/carts/agent/"+userId+"";
        } else {
            RestAssured.baseURI = "https://development.internal.rhapsodynonprod.com/rhdo-cart-broker-v1/carts/agent/"+userId+"";
        }

        RequestSpecification request = RestAssured.given();
        request.relaxedHTTPSValidation();

        if  (RestAssured.baseURI.contains("staging")) {
            String accessToken = getAuthToken();
            request.headers("Authorization", "Bearer "+accessToken+"");
        }
        response = request.get();

        String jsonString = response.asString();
        return JsonPath.from(jsonString).get("id");
    }

    /**
     * @returns access_token
     * */

    public static String getAuthToken() {
        if (Hooks.conciergeURL.contains("stg2")) {
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

        response = request.post("/auth/realms/"+authEndpoint+"/protocol/openid-connect/token");

        String jsonString = response.asString();
        return JsonPath.from(jsonString).get("access_token");
    }
    /**
     This method adds line items to cart
     */
    public static void addLineItemsToConciergeCart() {
        setUserEnvironment();
            if (USER_ID == "6192a475-4d00-4d61-aa0c-3e25c7000151") {
                cartId = getProdCartId(USER_ID);
            } else {
                cartId = getCurrentCartId(USER_ID);
            }
            RestAssured.baseURI = BASE_URL;
            RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
            request.headers("Content-Type", "application/json");
            request.headers("Cookie", "PF_AEM_PATHS=%5E%2F(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~IN%7C~IN)%7C(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~R%7C~R)%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)R)H%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)OD%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)IN%7C(%3F%3A(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)%7Cgift-registry~)MO%7Cinterior-design~BC%7Cgift-registry~RH%7Cstrada-ledoux~MO)%24; endpoint=develop; fusion_search=true; ui_asset_path=/concierge-ui-v1/");
            response = request.body("{\n" +
                    "    \"operationName\": \"addLineItemsToConciergeCart\",\n" +
                    "    \"variables\": {\n" +
                    "        \"email\": \"" + USEREMAIL + "\",\n" +
                    "        \"cartId\": \"" + cartId + "\",\n" +
                    "        \"lineItemsInput\": {\n" +
                    "            \"items\": [\n" +
                    "                {\n" +
                    "                    \"sku\": \"63130001 GREY\",\n" +
                    "                    \"quantity\": 1,\n" +
                    "                    \"brand\": \"RH\",\n" +
                    "                    \"giftTo\": \"\",\n" +
                    "                    \"giftFrom\": \"\",\n" +
                    "                    \"giftMessage\": \"\",\n" +
                    "                    \"productId\": \"prod1617188\",\n" +
                    "                    \"spoTermsAccepted\": false,\n" +
                    "                    \"spoTerms\": null\n" +
                    "                }\n" +
                    "            ]\n" +
                    "        }\n" +
                    "    },\n" +
                    "    \"query\": \"mutation addLineItemsToConciergeCart($email: String!, $cartId: String!, $lineItemsInput: ConciergeLineItemsInput!) {\\n  addLineItemsToConciergeCart(\\n    email: $email\\n    cartId: $cartId\\n    lineItemsInput: $lineItemsInput\\n  ) {\\n    ...Cart\\n  }\\n}\\n\\nfragment Cart on ConciergeCartType {\\n  __typename\\n  id\\n  requestedDeliveryDate\\n  requestedDeliveryDateReason\\n  postalCode\\n  country\\n  coordGroupType\\n  coordGroupGroupable\\n  coordGroupUserSelected\\n  orderNumber\\n  memberSavings\\n  cartSavings\\n  memberPrice\\n  isUserMember\\n  giftBoxFee\\n  hasGiftBox\\n  hasGiftFromRegistry\\n  giftRegistryIdList\\n  totalItemQuantity\\n  totalLines\\n  containsMembership\\n  guest {\\n    userId\\n    ctId\\n    atgUserId\\n    cwUserId\\n    email\\n    type\\n    typeId\\n    sourceCode\\n  }\\n  lineItems {\\n    giftFrom\\n    giftTo\\n    notes\\n    childSafety\\n    personalizeInfo {\\n      feeHigh\\n      feeLow\\n      selectedFont {\\n        id\\n        displayName\\n        previewImage\\n        image\\n        borders {\\n          id\\n        }\\n      }\\n      selectedBorder {\\n        id\\n        image\\n        displayName\\n        minLength\\n        maxLength\\n        numberOfLines\\n      }\\n      selectedStyle {\\n        id\\n        image\\n        minLength\\n        maxLength\\n        numberOfLines\\n        displayName\\n        previewImage\\n      }\\n      selectedColor {\\n        id\\n        displayName\\n        image\\n      }\\n    }\\n    isMonogramFee\\n    shouldWaiveMonogramFee\\n    shipVia\\n    shipViaCode\\n    isMonogrammable\\n    isPersonalizable\\n    monogram {\\n      styleId\\n      description\\n      maxLines\\n      fontCode\\n      fontColorCode\\n      borderCode\\n      lines\\n      fulfillmentCode\\n    }\\n    lineId\\n    quantity\\n    maxCartQuantity\\n    sku\\n    skuType\\n    brand\\n    displayName\\n    giftBoxDetail {\\n      giftBoxFee\\n      giftBoxCurrencyCode\\n    }\\n    giftWrap\\n    deliveryEta\\n    deliveryEtaStart\\n    deliveryEtaEnd\\n    coordGroup\\n    registryId\\n    spoTerms\\n    spoTermsAccepted\\n    spoTermsAcceptedDate\\n    isMembershipSku\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n    }\\n    availabilityInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n      }\\n    }\\n    deliveryInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n      }\\n    }\\n    productId\\n    product {\\n      displayName\\n      imageUrl\\n      targetUrl\\n      restrictions {\\n        spo\\n        returnPolicyMessage\\n        countryRestrictions\\n        mattressFeeLocation\\n        preBillMessage\\n        additionalMessages {\\n          curbsideMessage\\n          assemblyMessage\\n          giftCardMessage\\n          railroadMessage\\n          mattressFeeMessage\\n          cancellableMessage\\n          finalSaleMessage\\n        }\\n      }\\n    }\\n    price {\\n      itemPrice\\n      memberPrice\\n      discountPrice\\n      originalPrice\\n      overridePrice\\n      finalPrice\\n      priceStatus\\n      currencyCode\\n      totalPrice\\n      salePrice\\n      salePriceLabel\\n      priceType\\n      isOnClearance\\n      isOnSale\\n      showMemberPrice\\n      fees\\n      priceAdjustment {\\n        adjustment\\n        adjustmentType\\n        reason\\n        targetType\\n      }\\n      discounts {\\n        code\\n        name\\n        discountAmount\\n      }\\n    }\\n    options {\\n      type\\n      value\\n    }\\n    isGiftFromRegistry\\n    linkedLineItemId\\n    skuCustomization {\\n      type\\n      mountType\\n      lining\\n      panel\\n      controlType\\n      controlPosition\\n      controlLength\\n      tiltType\\n      controlAndTilt\\n      trim\\n      width\\n      length\\n      diameter\\n      roomLabel\\n      bracketColor\\n      rollType\\n      fulfillmentCode\\n    }\\n    galleryProjectId\\n    referenceId\\n    type\\n    tSSItem\\n    tSSInstallation\\n    skuRestrictions {\\n      spo\\n      membershipSku\\n      returnPolicyMessage\\n      restockingFee\\n      countryRestrictions\\n      mattressFeeLocation\\n      preBillMessage\\n      additionalMessages {\\n        curbsideMessage\\n        assemblyMessage\\n        giftCardMessage\\n        railroadMessage\\n        mattressFeeMessage\\n        cancellableMessage\\n        finalSaleMessage\\n      }\\n    }\\n    availabilityStatus\\n  }\\n  shipVia\\n  cartPrice {\\n    subtotal\\n    tax\\n    taxDetail {\\n      amount\\n      name\\n      country\\n      state\\n      imposition\\n      rate\\n    }\\n    totalPrice\\n    feeTotal\\n    currencyCode\\n    isFree\\n    fees {\\n      feeType\\n      quantity\\n      value\\n      unitCost\\n      linkedLineItemId\\n    }\\n    freightPrice {\\n      unlimitedFurnitureDelivery\\n      ground\\n      next\\n      second\\n      currency\\n      zoneCode\\n      surcharge\\n      shippingSurcharge\\n    }\\n    priceAdjustments {\\n      adjustment\\n      adjustmentType\\n      reason\\n      targetType\\n      adjustedPrice\\n      priceBeforeAdjustment\\n    }\\n  }\\n  soldToAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    companyName\\n    postalCode\\n    eveningPhone\\n    phone\\n    email\\n    firstName\\n    lastName\\n  }\\n  shipAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    companyName\\n    postalCode\\n    eveningPhone\\n    phone\\n    email\\n    firstName\\n    lastName\\n  }\\n  billAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    companyName\\n    postalCode\\n    phone\\n    email\\n    firstName\\n    lastName\\n  }\\n  payments {\\n    totalAmountRemaining\\n    totalAmountCovered\\n    appliedPayments {\\n      id\\n      paymentMethodType\\n      paymentType\\n      lastFour\\n      amountCovered\\n      currencyCode\\n      rhPaymentPlan\\n    }\\n  }\\n  importantInformation {\\n    type\\n    displayText\\n  }\\n  brand\\n  gallery {\\n    ctId\\n    designerCart\\n    galleryId\\n    key\\n    orderClassification\\n  }\\n  shipLabelSidemark\\n  giftMessage\\n  emailOverride\\n  commissions {\\n    available\\n    salesAttributions {\\n      agentLogin\\n      agentName\\n      percentage\\n      primary\\n    }\\n    total\\n  }\\n  discountCodes {\\n    code\\n    name\\n    description\\n  }\\n  shipRestrictedLineItems {\\n    displayName\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n    }\\n  }\\n  billRestrictedLineItems {\\n    displayName\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n    }\\n  }\\n  tSSEligible\\n  tSSApplied\\n  tSSFee\\n  taxExemptId\\n  totalAdditionalDiscount\\n}\\n\"\n" +
                    "}").post(addItemEndpoint);

            String jsonString = response.asString();
            id = JsonPath.from(jsonString).get("data.addLineItemsToConciergeCart.id");
    }

    /**
     This method removes all items from cart
     */
    public static void removeLineItemFromConciergeCart() {
        setUserEnvironment();
        if (USER_ID == "6192a475-4d00-4d61-aa0c-3e25c7000151") {
            cartId = getProdCartId(USER_ID);
        } else {
            cartId = getCurrentCartId(USER_ID);
        }
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.headers("Content-Type", "application/json");
        request.headers("Cookie", "PF_AEM_PATHS=%5E%2F(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~IN%7C~IN)%7C(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~R%7C~R)%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)R)H%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)OD%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)IN%7C(%3F%3A(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)%7Cgift-registry~)MO%7Cinterior-design~BC%7Cgift-registry~RH%7Cstrada-ledoux~MO)%24; endpoint=develop; fusion_search=true; ui_asset_path=/concierge-ui-v1/");
        response = request.body("{\n" +
                "    \"operationName\": \"removeLineItemFromConciergeCart\",\n" +
                "    \"variables\": {\n" +
                "        \"lineId\": \"null\",\n" +
                "        \"email\": \""+USEREMAIL+"\",\n" +
                "        \"cartId\": \""+cartId+"\",\n" +
                "        \"hasMonogram\": false\n" +
                "    },\n" +
                "    \"query\": \"mutation removeLineItemFromConciergeCart($lineId: String!, $cartId: String!, $email: String!, $hasMonogram: Boolean!) {\\n  removeLineItemFromConciergeCart(\\n    lineId: $lineId\\n    cartId: $cartId\\n    email: $email\\n    hasMonogram: $hasMonogram\\n  ) {\\n    ...Cart\\n  }\\n}\\n\\nfragment Cart on ConciergeCartType {\\n  __typename\\n  id\\n  requestedDeliveryDate\\n  requestedDeliveryDateReason\\n  postalCode\\n  country\\n  coordGroupType\\n  coordGroupGroupable\\n  coordGroupUserSelected\\n  orderNumber\\n  memberSavings\\n  cartSavings\\n  memberPrice\\n  isUserMember\\n  giftBoxFee\\n  hasGiftBox\\n  hasGiftFromRegistry\\n  giftRegistryIdList\\n  totalItemQuantity\\n  totalLines\\n  containsMembership\\n  guest {\\n    userId\\n    ctId\\n    atgUserId\\n    cwUserId\\n    email\\n    type\\n    typeId\\n    sourceCode\\n  }\\n  lineItems {\\n    giftFrom\\n    giftTo\\n    notes\\n    childSafety\\n    personalizeInfo {\\n      feeHigh\\n      feeLow\\n      selectedFont {\\n        id\\n        displayName\\n        previewImage\\n        image\\n        borders {\\n          id\\n        }\\n      }\\n      selectedBorder {\\n        id\\n        image\\n        displayName\\n        minLength\\n        maxLength\\n        numberOfLines\\n      }\\n      selectedStyle {\\n        id\\n        image\\n        minLength\\n        maxLength\\n        numberOfLines\\n        displayName\\n        previewImage\\n      }\\n      selectedColor {\\n        id\\n        displayName\\n        image\\n      }\\n    }\\n    isMonogramFee\\n    shouldWaiveMonogramFee\\n    shipVia\\n    shipViaCode\\n    isMonogrammable\\n    isPersonalizable\\n    monogram {\\n      styleId\\n      description\\n      maxLines\\n      fontCode\\n      fontColorCode\\n      borderCode\\n      lines\\n      fulfillmentCode\\n    }\\n    lineId\\n    quantity\\n    maxCartQuantity\\n    sku\\n    skuType\\n    brand\\n    displayName\\n    giftBoxDetail {\\n      giftBoxFee\\n      giftBoxCurrencyCode\\n    }\\n    giftWrap\\n    deliveryEta\\n    deliveryEtaStart\\n    deliveryEtaEnd\\n    coordGroup\\n    registryId\\n    spoTerms\\n    spoTermsAccepted\\n    spoTermsAcceptedDate\\n    isMembershipSku\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n    }\\n    availabilityInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n      }\\n    }\\n    deliveryInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n      }\\n    }\\n    productId\\n    product {\\n      displayName\\n      imageUrl\\n      targetUrl\\n      restrictions {\\n        spo\\n        returnPolicyMessage\\n        countryRestrictions\\n        mattressFeeLocation\\n        preBillMessage\\n        additionalMessages {\\n          curbsideMessage\\n          assemblyMessage\\n          giftCardMessage\\n          railroadMessage\\n          mattressFeeMessage\\n          cancellableMessage\\n          finalSaleMessage\\n        }\\n      }\\n    }\\n    price {\\n      itemPrice\\n      memberPrice\\n      discountPrice\\n      originalPrice\\n      overridePrice\\n      finalPrice\\n      priceStatus\\n      currencyCode\\n      totalPrice\\n      salePrice\\n      salePriceLabel\\n      priceType\\n      isOnClearance\\n      isOnSale\\n      showMemberPrice\\n      fees\\n      priceAdjustment {\\n        adjustment\\n        adjustmentType\\n        reason\\n        targetType\\n      }\\n      discounts {\\n        code\\n        name\\n        discountAmount\\n      }\\n    }\\n    options {\\n      type\\n      value\\n    }\\n    isGiftFromRegistry\\n    linkedLineItemId\\n    skuCustomization {\\n      type\\n      mountType\\n      lining\\n      panel\\n      controlType\\n      controlPosition\\n      controlLength\\n      tiltType\\n      controlAndTilt\\n      trim\\n      width\\n      length\\n      diameter\\n      roomLabel\\n      bracketColor\\n      rollType\\n      fulfillmentCode\\n    }\\n    galleryProjectId\\n    referenceId\\n    type\\n    tSSItem\\n    tSSInstallation\\n    skuRestrictions {\\n      spo\\n      membershipSku\\n      returnPolicyMessage\\n      restockingFee\\n      countryRestrictions\\n      mattressFeeLocation\\n      preBillMessage\\n      additionalMessages {\\n        curbsideMessage\\n        assemblyMessage\\n        giftCardMessage\\n        railroadMessage\\n        mattressFeeMessage\\n        cancellableMessage\\n        finalSaleMessage\\n      }\\n    }\\n    availabilityStatus\\n  }\\n  shipVia\\n  cartPrice {\\n    subtotal\\n    tax\\n    taxDetail {\\n      amount\\n      name\\n      country\\n      state\\n      imposition\\n      rate\\n    }\\n    totalPrice\\n    feeTotal\\n    currencyCode\\n    isFree\\n    fees {\\n      feeType\\n      quantity\\n      value\\n      unitCost\\n      linkedLineItemId\\n    }\\n    freightPrice {\\n      unlimitedFurnitureDelivery\\n      ground\\n      next\\n      second\\n      currency\\n      zoneCode\\n      surcharge\\n      shippingSurcharge\\n    }\\n    priceAdjustments {\\n      adjustment\\n      adjustmentType\\n      reason\\n      targetType\\n      adjustedPrice\\n      priceBeforeAdjustment\\n    }\\n  }\\n  soldToAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    companyName\\n    postalCode\\n    eveningPhone\\n    phone\\n    email\\n    firstName\\n    lastName\\n  }\\n  shipAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    companyName\\n    postalCode\\n    eveningPhone\\n    phone\\n    email\\n    firstName\\n    lastName\\n  }\\n  billAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    companyName\\n    postalCode\\n    phone\\n    email\\n    firstName\\n    lastName\\n  }\\n  payments {\\n    totalAmountRemaining\\n    totalAmountCovered\\n    appliedPayments {\\n      id\\n      paymentMethodType\\n      paymentType\\n      lastFour\\n      amountCovered\\n      currencyCode\\n      rhPaymentPlan\\n    }\\n  }\\n  importantInformation {\\n    type\\n    displayText\\n  }\\n  brand\\n  gallery {\\n    ctId\\n    designerCart\\n    galleryId\\n    key\\n    orderClassification\\n  }\\n  shipLabelSidemark\\n  giftMessage\\n  emailOverride\\n  commissions {\\n    available\\n    salesAttributions {\\n      agentLogin\\n      agentName\\n      percentage\\n      primary\\n    }\\n    total\\n  }\\n  discountCodes {\\n    code\\n    name\\n    description\\n  }\\n  shipRestrictedLineItems {\\n    displayName\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n    }\\n  }\\n  billRestrictedLineItems {\\n    displayName\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n    }\\n  }\\n  tSSEligible\\n  tSSApplied\\n  tSSFee\\n  taxExemptId\\n  totalAdditionalDiscount\\n}\\n\"\n" +
                "}").post(addItemEndpoint);

        String jsonString = response.asString();
    }

    /**
     This method removes all orders from cart
     */
    public static void clearOrder() {
        setUserEnvironment();
        if (USER_ID == "6192a475-4d00-4d61-aa0c-3e25c7000151") {
            cartId = getProdCartId(USER_ID);
        } else {
            cartId = getCurrentCartId(USER_ID);
        }
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.headers("Content-Type", "application/json");
        request.headers("Cookie", "PF_AEM_PATHS=%5E%2F(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~IN%7C~IN)%7C(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~R%7C~R)%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)R)H%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)OD%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)IN%7C(%3F%3A(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)%7Cgift-registry~)MO%7Cinterior-design~BC%7Cgift-registry~RH%7Cstrada-ledoux~MO)%24; endpoint=develop; fusion_search=true; ui_asset_path=/concierge-ui-v1/");
        response = request.body("{\n" +
                "    \"operationName\": \"clearOrder\",\n" +
                "    \"variables\": {\n" +
                "        \"email\": \""+USEREMAIL+"\",\n" +
                "        \"cartId\": \""+cartId+"\"\n" +
                "    },\n" +
                "    \"query\": \"mutation clearOrder($email: String!, $cartId: String!) {\\n  clearOrder(email: $email, cartId: $cartId) {\\n    ...Cart\\n  }\\n}\\n\\nfragment Cart on ConciergeCartType {\\n  __typename\\n  id\\n  requestedDeliveryDate\\n  requestedDeliveryDateReason\\n  postalCode\\n  country\\n  coordGroupType\\n  coordGroupGroupable\\n  coordGroupUserSelected\\n  orderNumber\\n  memberSavings\\n  cartSavings\\n  memberPrice\\n  isUserMember\\n  giftBoxFee\\n  hasGiftBox\\n  hasGiftFromRegistry\\n  giftRegistryIdList\\n  totalItemQuantity\\n  totalLines\\n  containsMembership\\n  guest {\\n    userId\\n    ctId\\n    atgUserId\\n    cwUserId\\n    email\\n    type\\n    typeId\\n    sourceCode\\n  }\\n  lineItems {\\n    giftFrom\\n    giftTo\\n    notes\\n    childSafety\\n    personalizeInfo {\\n      feeHigh\\n      feeLow\\n      selectedFont {\\n        id\\n        displayName\\n        previewImage\\n        image\\n        borders {\\n          id\\n        }\\n      }\\n      selectedBorder {\\n        id\\n        image\\n        displayName\\n        minLength\\n        maxLength\\n        numberOfLines\\n      }\\n      selectedStyle {\\n        id\\n        image\\n        minLength\\n        maxLength\\n        numberOfLines\\n        displayName\\n        previewImage\\n      }\\n      selectedColor {\\n        id\\n        displayName\\n        image\\n      }\\n    }\\n    isMonogramFee\\n    shouldWaiveMonogramFee\\n    shipVia\\n    shipViaCode\\n    isMonogrammable\\n    isPersonalizable\\n    monogram {\\n      styleId\\n      description\\n      maxLines\\n      fontCode\\n      fontColorCode\\n      borderCode\\n      lines\\n      fulfillmentCode\\n    }\\n    lineId\\n    quantity\\n    maxCartQuantity\\n    sku\\n    skuType\\n    brand\\n    displayName\\n    giftBoxDetail {\\n      giftBoxFee\\n      giftBoxCurrencyCode\\n    }\\n    giftWrap\\n    deliveryEta\\n    deliveryEtaStart\\n    deliveryEtaEnd\\n    coordGroup\\n    registryId\\n    spoTerms\\n    spoTermsAccepted\\n    spoTermsAcceptedDate\\n    isMembershipSku\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n    }\\n    availabilityInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n      }\\n    }\\n    deliveryInfo {\\n      displayText\\n      type\\n      props {\\n        href\\n      }\\n    }\\n    productId\\n    product {\\n      displayName\\n      imageUrl\\n      targetUrl\\n      restrictions {\\n        spo\\n        returnPolicyMessage\\n        countryRestrictions\\n        mattressFeeLocation\\n        preBillMessage\\n        additionalMessages {\\n          curbsideMessage\\n          assemblyMessage\\n          giftCardMessage\\n          railroadMessage\\n          mattressFeeMessage\\n          cancellableMessage\\n          finalSaleMessage\\n        }\\n      }\\n    }\\n    price {\\n      itemPrice\\n      memberPrice\\n      discountPrice\\n      originalPrice\\n      overridePrice\\n      finalPrice\\n      priceStatus\\n      currencyCode\\n      totalPrice\\n      salePrice\\n      salePriceLabel\\n      priceType\\n      isOnClearance\\n      isOnSale\\n      showMemberPrice\\n      fees\\n      priceAdjustment {\\n        adjustment\\n        adjustmentType\\n        reason\\n        targetType\\n      }\\n      discounts {\\n        code\\n        name\\n        discountAmount\\n      }\\n    }\\n    options {\\n      type\\n      value\\n    }\\n    isGiftFromRegistry\\n    linkedLineItemId\\n    skuCustomization {\\n      type\\n      mountType\\n      lining\\n      panel\\n      controlType\\n      controlPosition\\n      controlLength\\n      tiltType\\n      controlAndTilt\\n      trim\\n      width\\n      length\\n      diameter\\n      roomLabel\\n      bracketColor\\n      rollType\\n      fulfillmentCode\\n    }\\n    galleryProjectId\\n    referenceId\\n    type\\n    tSSItem\\n    tSSInstallation\\n    skuRestrictions {\\n      spo\\n      membershipSku\\n      returnPolicyMessage\\n      restockingFee\\n      countryRestrictions\\n      mattressFeeLocation\\n      preBillMessage\\n      additionalMessages {\\n        curbsideMessage\\n        assemblyMessage\\n        giftCardMessage\\n        railroadMessage\\n        mattressFeeMessage\\n        cancellableMessage\\n        finalSaleMessage\\n      }\\n    }\\n    availabilityStatus\\n  }\\n  shipVia\\n  cartPrice {\\n    subtotal\\n    tax\\n    taxDetail {\\n      amount\\n      name\\n      country\\n      state\\n      imposition\\n      rate\\n    }\\n    totalPrice\\n    feeTotal\\n    currencyCode\\n    isFree\\n    fees {\\n      feeType\\n      quantity\\n      value\\n      unitCost\\n      linkedLineItemId\\n    }\\n    freightPrice {\\n      unlimitedFurnitureDelivery\\n      ground\\n      next\\n      second\\n      currency\\n      zoneCode\\n      surcharge\\n      shippingSurcharge\\n    }\\n    priceAdjustments {\\n      adjustment\\n      adjustmentType\\n      reason\\n      targetType\\n      adjustedPrice\\n      priceBeforeAdjustment\\n    }\\n  }\\n  soldToAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    companyName\\n    postalCode\\n    eveningPhone\\n    phone\\n    email\\n    firstName\\n    lastName\\n  }\\n  shipAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    companyName\\n    postalCode\\n    eveningPhone\\n    phone\\n    email\\n    firstName\\n    lastName\\n  }\\n  billAddress {\\n    addressLine1\\n    addressLine2\\n    city\\n    state\\n    country\\n    companyName\\n    postalCode\\n    phone\\n    email\\n    firstName\\n    lastName\\n  }\\n  payments {\\n    totalAmountRemaining\\n    totalAmountCovered\\n    appliedPayments {\\n      id\\n      paymentMethodType\\n      paymentType\\n      lastFour\\n      amountCovered\\n      currencyCode\\n      rhPaymentPlan\\n    }\\n  }\\n  importantInformation {\\n    type\\n    displayText\\n  }\\n  brand\\n  gallery {\\n    ctId\\n    designerCart\\n    galleryId\\n    key\\n    orderClassification\\n  }\\n  shipLabelSidemark\\n  giftMessage\\n  emailOverride\\n  commissions {\\n    available\\n    salesAttributions {\\n      agentLogin\\n      agentName\\n      percentage\\n      primary\\n    }\\n    total\\n  }\\n  discountCodes {\\n    code\\n    name\\n    description\\n  }\\n  shipRestrictedLineItems {\\n    displayName\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n    }\\n  }\\n  billRestrictedLineItems {\\n    displayName\\n    itemRestrictions {\\n      shippingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n      billingRestrictions {\\n        countries\\n        postalRanges\\n        sku\\n        states\\n        type\\n      }\\n    }\\n  }\\n  tSSEligible\\n  tSSApplied\\n  tSSFee\\n  taxExemptId\\n  totalAdditionalDiscount\\n}\\n\"\n" +
                "}").post(addItemEndpoint);

        String jsonString = response.asString();
        id = JsonPath.from(jsonString).get("id");
    }

    /**
     * @param userId
     * @return cart Id
     This method returns production cartId
     */
    public static String getProdCartId (String userId) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.headers("Content-Type", "application/json");
        response = request.body("{\n" +
                "    \"query\": \"query CartProjection(\\n    $userId: String!, \\n    $email: String!\\n) { \\n    cartProjection(\\n        userId: $userId\\n        email: $email\\n    ) { \\n        id cartType totalLines totalItemQuantity\\n    } \\n} \",\n" +
                "    \"variables\": {\n" +
                "        \"userId\": \""+userId+"\",\n" +
                "        \"email\": \""+USEREMAIL+"\"\n" +
                "    }\n" +
                "}").post("/concierge-bff-v1/graphql");

        String jsonString = response.asString();
        return JsonPath.from(jsonString).get("data.cartProjection.id");
    }

    /**
     This method set up user configuration based on environment
     */
    public static void setUserEnvironment() {

        if (BASE_URL.contains("stg2")) {
            USER_ID = "4c5c1919-99d6-47a3-a0f5-7d5287911944";
            addItemEndpoint = "/concierge-bff-v1-stg2/graphql";
        } else if (BASE_URL.contains("stg4")) {
            addItemEndpoint = "/concierge-bff-v1/graphql";
            USER_ID = "3d6b15b6-eca1-4ef5-8c3c-cc39c6a2b8a8";
        } else {
            //production
            addItemEndpoint = "/concierge-bff-v1/graphql";
            USER_ID = "6192a475-4d00-4d61-aa0c-3e25c7000151";
        }
    }
}