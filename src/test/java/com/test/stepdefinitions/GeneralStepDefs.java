package com.test.stepdefinitions;

import com.test.pageObject.CheckoutAddressScreen;
import com.test.pageObject.ConciergeLoginPage;
import com.test.utility.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

import static org.awaitility.Awaitility.await;

public class GeneralStepDefs {
    WebDriver webDriver = Hooks.getWebDriver();
    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage(webDriver);
    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen(webDriver);
    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    /**
     * This method login in system with selected role
     *
     * @param accountRole
     */
    public void loginAsRole(String accountRole) {
        if (accountRole.equals("associate")) {
            conciergeLoginPage.getUsernameField().sendKeys("automationassociate");
            conciergeLoginPage.getPasswordField().sendKeys("S3pUgx4W");
        } else {
            conciergeLoginPage.getUsernameField().sendKeys("automationleader");
            conciergeLoginPage.getPasswordField().sendKeys("zJ6Kma55");
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
    private void clearField(WebElement field) {
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
        await().forever().until(() -> checkoutAddressScreen.getFirstNameInpt().isDisplayed());

        isElementVisible("//input[contains(@id,'firstName')and contains(@id,'shipping')]");
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

        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", checkoutAddressScreen.getBillingAddressAsShippingCheckBox());
        isElementVisible("//div[@id='billingAddresslbl']//span[@class='MuiIconButton-label']/input[@type='checkbox']");
        checkoutAddressScreen.getBillingAddressAsShippingCheckBox().click();
    }

    /**
     *
     * Fill zip code, state, country for address checkout
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
            JavascriptExecutor executor = (JavascriptExecutor)webDriver;
            executor.executeScript("arguments[0].click();", checkoutAddressScreen.getContinueButton());
        } catch (Exception e) {
            System.out.println("Continue from popup is not displayed");
        }

    }

    public boolean isElementVisible(String xPath) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Test");
            return false;
        }
    }
}
