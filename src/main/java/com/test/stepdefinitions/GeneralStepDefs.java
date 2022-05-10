package com.test.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.test.pageObject.*;
import com.test.utility.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class GeneralStepDefs {
    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage();
    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen();
    PaymentScreen paymentScreen = new PaymentScreen();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeAddressScreen conciergeAddressScreen = new ConciergeAddressScreen();


    /**
     * This method login in system with selected role
     *
     * @param accountRole - account role
     */
    public void loginAsRole(String accountRole) {
        conciergeLoginPage.getPasswordField().shouldBe(visible, Duration.ofMinutes(5));
        conciergeLoginPage.getUsernameField().shouldBe(visible, Duration.ofSeconds(20));
        if (accountRole.equals("associate")) {
            conciergeLoginPage.getUsernameField().setValue(Hooks.associateLogin);
            conciergeLoginPage.getPasswordField().setValue(Hooks.associatePassword);
        }
        if (accountRole.equals("employee")) {
            conciergeLoginPage.getUsernameField().setValue("ediscount");
            conciergeLoginPage.getPasswordField().setValue("p6K6K6Mx");
        }
        if(accountRole.equals("leader")) {
            conciergeLoginPage.getUsernameField().setValue(Hooks.leaderLogin);
            conciergeLoginPage.getPasswordField().setValue(Hooks.leaderPassword);
        }

        conciergeLoginPage.getSignInButton().shouldBe(visible, Duration.ofSeconds(30));
        conciergeLoginPage.getSignInButton().click();

        conciergeLoginPage.getLocationNewPortBeach().shouldBe(visible, Duration.ofSeconds(30));
        conciergeLoginPage.getLocationNewPortBeach().click();
        conciergeLoginPage.getContinueButton().shouldBe(visible, Duration.ofSeconds(30));
        sleep(3000);
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
//        $(By.xpath("//form[@class='MuiGrid-root MuiGrid-container']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-6 MuiGrid-justify-xs-center']/div[1]/div[1]/div[3]/div/input")).shouldBe(visible, Duration.ofSeconds(30));
        conciergeAddressScreen.getShippingAddressText().shouldHave(text("Shipping Address"), Duration.ofSeconds(40));
        conciergeAddressScreen.getBillingAddressText().shouldHave(text("Billing Address"), Duration.ofSeconds(40));
        executeJavaScript("arguments[0].click();", checkoutAddressScreen.getBillingAddressAsShippingCheckBox());
        clearField(checkoutAddressScreen.getFirstNameInpt());
        checkoutAddressScreen.getFirstNameInpt().setValue("QA1");

        clearField(checkoutAddressScreen.getLastNameField());
        checkoutAddressScreen.getLastNameField().setValue("Automation");

        clearField(checkoutAddressScreen.getCompanyNameField());
        checkoutAddressScreen.getCompanyNameField().setValue("AutomationCompany");

        clearField(checkoutAddressScreen.getStreetAddressField());
        checkoutAddressScreen.getStreetAddressField().setValue("QaStreet");

        clearField(checkoutAddressScreen.getAptFloorSuiteField());
        checkoutAddressScreen.getAptFloorSuiteField().setValue("QaApartment");

        clearField(checkoutAddressScreen.getCityField());
        checkoutAddressScreen.getCityField().setValue("qaCity");

        clearField(checkoutAddressScreen.getPhoneField());
        checkoutAddressScreen.getPhoneField().setValue("+124131231");

        conciergeAddressScreen.getBillingAddressText().shouldBe(visible, Duration.ofSeconds(12));
    }


    /**
     * Fill zip code, state, country for address checkout
     *
     * @param zipCode - zipcode
     * @param country - country
     * @param state   - state
     */
    public void fillZipCodeStateCountry(String zipCode, String country, String state) {
        checkoutAddressScreen.getCountryField().shouldBe(visible, Duration.ofSeconds(50));
        Select countrySelect = new Select(checkoutAddressScreen.getCountryField());
        executeJavaScript("arguments[0].scrollIntoView(true);", countrySelect);
        countrySelect.selectByValue(country);

        if (state.equals("")) {
            checkoutAddressScreen.getStateField().shouldBe(visible, Duration.ofSeconds(15));
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


    /**
     * Click on continue to payment buttons
     */
    public void continueToPaymentAfterAddressCheckout() {
        checkoutAddressScreen.getContinuePaymentButton().shouldBe(visible, Duration.ofSeconds(15));
        executeJavaScript("arguments[0].scrollIntoView(true);", checkoutAddressScreen.getContinuePaymentButton());
        checkoutAddressScreen.getContinuePaymentButton().click();

        try {
            checkoutAddressScreen.getContinueButton().shouldBe(visible, Duration.ofSeconds(15));
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
            $(By.xpath(xPath)).shouldBe(visible, Duration.ofSeconds(40));
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
            conciergeUserAccountPage.getClientButton().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(25));
            conciergeUserAccountPage.getClientButton().click();

            conciergeUserAccountPage.getClientLookupHeaderBtn().shouldBe(visible, Duration.ofSeconds(20));
            conciergeUserAccountPage.getClientLookupHeaderBtn().click();

            conciergeUserAccountPage.getClientLookupFirstName().shouldBe(visible, Duration.ofSeconds(20));
            if (field.equals("email")) {
                conciergeUserAccountPage.getClientLookupEmail().shouldBe(Condition.be(visible), Duration.ofSeconds(25));
                conciergeUserAccountPage.getClientLookupEmail().setValue("test@mailinator.com");
            }
            if (field.equals("lastName")) {
                conciergeUserAccountPage.getClientLookupLastName().shouldBe(Condition.be(visible), Duration.ofSeconds(25));
                conciergeUserAccountPage.getClientLookupLastName().setValue("NonMember");
            }
            if (field.equals("memberID")) {
                conciergeUserAccountPage.getMemberIdField().shouldBe(Condition.be(visible), Duration.ofSeconds(25));
                conciergeUserAccountPage.getMemberIdField().setValue("101318450");
            }
            if (field.equals("businessAccountNumber")) {
                conciergeUserAccountPage.getBusinessAcNumber().shouldBe(Condition.be(visible), Duration.ofSeconds(25));
                conciergeUserAccountPage.getBusinessAcNumber().setValue("20211221164476");
            }
            if (field.equals("phone number,postal code,company")) {

            }
            conciergeUserAccountPage.getClientLookupSearchButton().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(25));

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
        sleep(3000);
        paymentScreen.getChoosePaymentMethodBtn().shouldBe(Condition.be(visible), Duration.ofSeconds(35));
        Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment.selectByValue(paymentType);

        $(By.cssSelector("iframe[title='Iframe for secured card data input field']")).shouldBe(Condition.be(visible), Duration.ofMinutes(2));
        SelenideElement selenideElement = $(By.cssSelector("iframe[title='Iframe for secured card data input field']"));
        switchTo().frame(selenideElement);
        paymentScreen.getCardNumberField().setValue(number);
        switchTo().defaultContent();

        $(By.xpath("//div[contains(@class,'securityCode')]//iframe[@class='js-iframe']")).shouldBe(Condition.be(visible), Duration.ofMinutes(2));
        switchTo().frame($(By.xpath("//div[contains(@class,'securityCode')]//iframe[@class='js-iframe']")));

        paymentScreen.getCvcField().setValue(cvc);
        switchTo().defaultContent();

        $(By.xpath("//div[contains(@class,'expiryDate')]//iframe[@title='Iframe for secured card data input field']")).shouldBe(Condition.be(visible), Duration.ofMinutes(2));
        switchTo().frame($(By.xpath("//div[contains(@class,'expiryDate')]//iframe[@title='Iframe for secured card data input field']")));

        paymentScreen.getExpiryDateField().setValue(expirationDate);
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
        conciergeUserAccountPage.getMenuItems().get(0).shouldBe(visible, Duration.ofSeconds(10));
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


