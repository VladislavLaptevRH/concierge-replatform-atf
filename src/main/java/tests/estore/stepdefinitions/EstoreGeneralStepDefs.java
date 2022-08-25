package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import lombok.Getter;
import tests.concierge.pageObject.*;
import tests.estore.pageObject.EstoreAddressScreen;
import tests.estore.pageObject.EstoreCheckoutAddressScreen;
import tests.estore.pageObject.EstorePaymentPage;
import tests.utility.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

@Getter
public class EstoreGeneralStepDefs {
    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage();
    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen();
    PaymentScreen paymentScreen = new PaymentScreen();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeAddressScreen conciergeAddressScreen = new ConciergeAddressScreen();
    EstoreAddressScreen estoreAddressScreen = new EstoreAddressScreen();
    EstorePaymentPage estorePaymentPage = new EstorePaymentPage();
    EstoreCheckoutAddressScreen estoreCheckoutAddressScreen = new EstoreCheckoutAddressScreen();
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(30));

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


    /**
     * This method login in system with selected role
     *
     * @param accountRole - account role
     */
    public void loginAsRole(String accountRole) {
        conciergeLoginPage.getPasswordField().should(visible, Duration.ofMinutes(5));
        conciergeLoginPage.getUsernameField().should(visible, Duration.ofSeconds(20));
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

        clearField(estoreAddressScreen.getEmailField());
        estoreAddressScreen.getEmailField().setValue("test@mail.com");

        clearField(estoreAddressScreen.getConfirmEmail());
        estoreAddressScreen.getConfirmEmail().setValue("test@mail.com");

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
            conciergeUserAccountPage.getClientLookupHeaderBtn().should(visible, Duration.ofSeconds(20));
            conciergeUserAccountPage.getClientLookupHeaderBtn().click();

            conciergeUserAccountPage.getClientLookupFirstName().should(visible, Duration.ofSeconds(20));
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


