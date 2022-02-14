package com.test.stepdefinitions;

import com.test.pageObject.CheckoutAddressScreen;
import com.test.pageObject.ConciergeLoginPage;
import com.test.pageObject.ConciergeUserAccountPage;
import com.test.pageObject.PaymentScreen;
import com.test.utility.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

public class GeneralStepDefs {
    WebDriver webDriver = Hooks.getWebDriver();
    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage(webDriver);
    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen(webDriver);
    WebDriverWait wait = new WebDriverWait(webDriver, 15);
    PaymentScreen paymentScreen = new PaymentScreen(webDriver);
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage(webDriver);
    Actions actions = new Actions(webDriver);


    /**
     * This method login in system with selected role
     *
     * @param accountRole
     */
    public void loginAsRole(String accountRole) {
        if (accountRole.equals("associate")) {
            conciergeLoginPage.getUsernameField().sendKeys(Hooks.associateLogin);
            conciergeLoginPage.getPasswordField().sendKeys(Hooks.associatePassword);
        } else {
            conciergeLoginPage.getUsernameField().sendKeys(Hooks.leaderLogin);
            conciergeLoginPage.getPasswordField().sendKeys(Hooks.leaderPassword);
        }
        conciergeLoginPage.getSignInButton().click();
        conciergeLoginPage.getLocationNewPortBeach().click();
        conciergeLoginPage.getContinueButton().click();
    }


    /**
     * This method is clear required field
     *
     * @param field
     */
    public void clearField(WebElement field) {
        field.click();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        if (!field.getAttribute("value").isEmpty()) {
            js.executeScript("arguments[0].value='';", field);
        }
    }


    /**
     * This method wait for page load
     *
     * @param webDriver
     */
    public void waitForPageLoad(WebDriver webDriver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(pageLoadCondition);
    }


    /**
     * This method fill all fields from checkout address screen
     */
    public void fillAddressFields() {
        waitForPageLoad(webDriver);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@class='MuiGrid-root MuiGrid-container']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-6 MuiGrid-justify-xs-center']/div[1]/div[1]/div[3]/div/input")));
        clearField(checkoutAddressScreen.getFirstNameInpt());
        checkoutAddressScreen.getFirstNameInpt().sendKeys("QA1");

        clearField(checkoutAddressScreen.getLastNameField());
        checkoutAddressScreen.getLastNameField().sendKeys("Automation");

        clearField(checkoutAddressScreen.getCompanyNameField());
        checkoutAddressScreen.getCompanyNameField().sendKeys("AutomationCompany");

        clearField(checkoutAddressScreen.getStreetAddressField());
        checkoutAddressScreen.getStreetAddressField().sendKeys("QaStreet");

        clearField(checkoutAddressScreen.getAptFloorSuiteField());
        checkoutAddressScreen.getAptFloorSuiteField().sendKeys("QaApartment");

        clearField(checkoutAddressScreen.getCityField());
        checkoutAddressScreen.getCityField().sendKeys("qaCity");

        checkoutAddressScreen.getPhoneField().sendKeys("+124131231");

        isElementVisible("//div[@id='billingAddresslbl']/h3");
        isElementVisible("//div[@id='billingAddresslbl']//span[@class='MuiIconButton-label']/input[@type='checkbox']");
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", checkoutAddressScreen.getBillingAddressAsShippingCheckBox());
        isElementVisible("//div[@id='billingAddresslbl']/h3");
        isElementVisible("//div[@id='billingAddresslbl']//span[@class='MuiIconButton-label']/input[@type='checkbox']");
        checkoutAddressScreen.getBillingAddressAsShippingCheckBox().click();
    }


    /**
     * Fill zip code, state, country for address checkout
     *
     * @param zipCode
     * @param country
     * @param state
     */
    public void fillZipCodeStateCountry(String zipCode, String country, String state) {
        waitForPageLoad(webDriver);

        Select countrySelect = new Select(checkoutAddressScreen.getCountryField());
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", countrySelect);
        countrySelect.selectByValue(country);

        if (state.equals("")) {
            Select selectState = new Select(checkoutAddressScreen.getStateField());
            selectState.selectByIndex(ThreadLocalRandom.current().nextInt(1, 4));
        }

        clearField(checkoutAddressScreen.getZipPostalCodeField());
        checkoutAddressScreen.getZipPostalCodeField().sendKeys(zipCode);
        if (state.equals("NY")) {
            WebElement stateButton = webDriver.findElement(By.xpath("(//div[contains(@class,'Mui')]//select[contains(@class,'Mui')])[2]//option[@value='" + state + "']"));
            stateButton.click();
        }

    }


    /**
     * Click on continue to payment buttons
     */
    public void continueToPaymentAfterAddressCheckout() {
        await().forever().until(() -> checkoutAddressScreen.getContinuePaymentButton().isDisplayed());
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", checkoutAddressScreen.getContinuePaymentButton());
        checkoutAddressScreen.getContinuePaymentButton().click();

        try {
            wait.until(ExpectedConditions.elementToBeClickable(checkoutAddressScreen.getContinueButton()));
            JavascriptExecutor executor = (JavascriptExecutor) webDriver;
            executor.executeScript("arguments[0].click();", checkoutAddressScreen.getContinueButton());
        } catch (Exception e) {
            System.out.println("Continue from popup is not displayed");
        }

    }

    /**
     * This method verify if element is visible
     *
     * @param xPath
     * @return
     */
    public boolean isElementVisible(String xPath) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Test");
            return false;
        }
    }


    /**
     * @param paymentType
     * @param number
     * @param cvc
     * @param expirationDate This method execute payment with provided method
     */
    public void payWith(String paymentType, String number, String cvc, String expirationDate) {
        wait.until(ExpectedConditions.textToBePresentInElement(paymentScreen.getChoosePaymentMethodBtn(), "RH"));
        Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment.selectByValue(paymentType);

        WebElement webElement = webDriver.findElement(By.cssSelector("iframe[title='Iframe for secured card data input field']"));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webDriver.switchTo().frame(webElement);
        paymentScreen.getCardNumberField().sendKeys(number);
        webDriver.switchTo().defaultContent();

        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//div[contains(@class,'securityCode')]//iframe[@class='js-iframe']")));
        paymentScreen.getCvcField().sendKeys(cvc);
        webDriver.switchTo().defaultContent();

        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//div[contains(@class,'expiryDate')]//iframe[@title='Iframe for secured card data input field']")));
        paymentScreen.getExpiryDateField().sendKeys(expirationDate);
        webDriver.switchTo().defaultContent();
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
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-justify-xs-space-between']//div")));
        actions.moveToElement(conciergeUserAccountPage.getMenuItems().get(indexItem));
        conciergeUserAccountPage.getMenuItems().get(indexItem).click();
        conciergeUserAccountPage.getMenuItems().get(indexItem).click();
        System.out.println();
        for (int i = 0; i < conciergeUserAccountPage.getItemSubCategory().size(); i++) {
            isElementVisible("//div[2]//ul[@class='MuiList-root']/li[@class='MuiListItem-root']");
            categoryInStockActual.add(conciergeUserAccountPage.getItemSubCategory().get(i).getText());
        }
        assertThat(categoryInStockActual).hasSameElementsAs(categoryInStockExpected);
    }


    /**
     * @param min
     * @param max Generate random number in range
     * @return
     */
    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}


