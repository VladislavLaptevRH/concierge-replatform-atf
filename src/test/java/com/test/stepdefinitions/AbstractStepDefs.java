package com.test.stepdefinitions;

import com.test.pageObject.*;
import com.test.utility.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertTrue;

@Getter
@Configuration
@PropertySource("classpath:credentials.properties")

public class AbstractStepDefs {

    @Value("${leaderLogin}")
    private String leaderLogin;

    @Value("${leaderPassword}")
    private String leaderPassword;

    @Value("${associateLogin}")
    private String associateLogin;

    @Value("${associatePassword}")
    private String associatePassword;


    WebDriver webDriver = Hooks.getWebDriver();
    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage(webDriver);
    ConciergeOrderHistoryForm conciergeOrderHistoryForm = new ConciergeOrderHistoryForm(webDriver);
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage(webDriver);
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen(webDriver);
    WebDriverWait wait = new WebDriverWait(webDriver, 15);
    Actions actions = new Actions(webDriver);
    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen(webDriver);
    PaymentScreen paymentScreen = new PaymentScreen(webDriver);
    ReviewOrderScreen reviewOrderScreen = new ReviewOrderScreen(webDriver);
    ConfirmationOrderScreen confirmationOrderScreen = new ConfirmationOrderScreen(webDriver);


    /**
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


    @When("I clicks on a random menu item")
    public void iClicksOnARandomMenuItem() throws InterruptedException {
        conciergeUserAccountPage.getMenuItems().get(0).click();
        wait.until(ExpectedConditions.visibilityOf(conciergeUserAccountPage.getItemSubCategory().get(0)));
        conciergeUserAccountPage.getItemSubCategory().get(0).click();
    }


    @When("I clicks on o random item")
    public void iClicksOnORandomItem() {
        wait.until(ExpectedConditions.visibilityOf(conciergeItemsScreen.getItems().get(0)));
        conciergeItemsScreen.getItems().get(0).click();
    }


    @When("I fill all options for item")
    public void iFillAllOptionsForItem() {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", conciergeItemsScreen.getQuantityButton());
        wait.until(ExpectedConditions.elementToBeClickable(conciergeItemsScreen.getQuantityOne()));
        conciergeItemsScreen.getQuantityOne().click();
    }

    @When("I click on add to cart button")
    public void iClickOnAddToCartButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(conciergeItemsScreen.getAddToCartButton()));
        conciergeItemsScreen.getAddToCartButton().click();
        wait.until(ExpectedConditions.visibilityOf(conciergeItemsScreen.getViewCartButton()));
        conciergeItemsScreen.getViewCartButton().click();
    }

    @When("I click on checkout button")
    public void iClickOnCheckoutButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(conciergeItemsScreen.getCheckoutButton()));
        WebElement webElement1 = webDriver.findElement(By.xpath("//select[@id='element-orderclassification']//option[2]"));
        webElement1.click();
        conciergeItemsScreen.getCheckoutButton().click();
        wait.until(ExpectedConditions.elementToBeClickable(conciergeItemsScreen.getClosePopUpButton()));
        conciergeItemsScreen.getClosePopUpButton().click();
    }

    @When("I fill all fields from address screen")
    public void iFillAllFieldsFromAddressScreen() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutAddressScreen.getBillingAddressAsShippingCheckBox()));
        checkoutAddressScreen.getFirstNameField().click();
        checkoutAddressScreen.getFirstNameField().clear();
        checkoutAddressScreen.getFirstNameField().sendKeys("QA1");
//        checkoutAddressScreen.getLastNameField().clear();
//        checkoutAddressScreen.getLastNameField().sendKeys("Automation");
//        checkoutAddressScreen.getCompanyNameField().clear();
//        checkoutAddressScreen.getCompanyNameField().sendKeys("AutomationCompany");
//        checkoutAddressScreen.getStreetAddressField().clear();
//        checkoutAddressScreen.getStreetAddressField().sendKeys("QaStreet");
//        checkoutAddressScreen.getAptFloorSuiteField().clear();
//        checkoutAddressScreen.getAptFloorSuiteField().sendKeys("QaApartment");
//        checkoutAddressScreen.getCityField().clear();
//        checkoutAddressScreen.getCityField().sendKeys("qaCity");
////        checkoutAddressScreen.getZipPostalCodeField().click();
//        checkoutAddressScreen.getZipPostalCodeField().clear();
////        checkoutAddressScreen.getZipPostalCodeField().sendKeys("12345");
//        checkoutAddressScreen.getPhoneField().clear();
//        checkoutAddressScreen.getPhoneField().sendKeys("+12413123124354");

        checkoutAddressScreen.getBillingAddressAsShippingCheckBox().click();
        Select selectState = new Select(checkoutAddressScreen.getStateField());
        selectState.selectByIndex(ThreadLocalRandom.current().nextInt(1, 15));
        checkoutAddressScreen.getContinuePaymentButton().click();
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", checkoutAddressScreen.getContinueButton());
        wait.until(ExpectedConditions.elementToBeClickable(checkoutAddressScreen.getContinueButton()));
        checkoutAddressScreen.getContinueButton().click();

    }

    @When("I click on continue to payment button")
    public void iClickOnContinueToPaymentButton() {
        wait.until(ExpectedConditions.textToBePresentInElement(paymentScreen.getChoosePaymentMethodBtn(), "Choose a payment method"));
        Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment.selectByIndex(3);

        WebElement webElement = webDriver.findElement(By.cssSelector("iframe[title='Iframe for secured card data input field']"));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webDriver.switchTo().frame(webElement);
        paymentScreen.getCardNumberField().sendKeys("4678475330157543");
        webDriver.switchTo().defaultContent();

        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//div[contains(@class,'securityCode')]//iframe[@class='js-iframe']")));
        paymentScreen.getCvcField().sendKeys("737");
        webDriver.switchTo().defaultContent();

        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//div[contains(@class,'expiryDate')]//iframe[@title='Iframe for secured card data input field']")));
        paymentScreen.getExpiryDateField().sendKeys("0330");
        webDriver.switchTo().defaultContent();

        paymentScreen.getContinueToReview().click();

    }

    @Then("I verify that review screen is displayed")
    public void iVerifyThatReviewScreenIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(reviewOrderScreen.getBillingAddress()));
        wait.until(ExpectedConditions.visibilityOf(reviewOrderScreen.getShippingAddress()));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", reviewOrderScreen.getPlaceOrderButton());
    }

    @When("I click on a place order button")
    public void iClickOnPlaceOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(reviewOrderScreen.getPlaceOrderButton()));
        reviewOrderScreen.getPlaceOrderButton().click();
    }

    @Then("I verify that confirmation order screen is displayed")
    public void iVerifyThatOrderDetailsScreenIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(confirmationOrderScreen.getThankYouTitle()));
        assertTrue(confirmationOrderScreen.getYourOrderHasBeenPlaced().isDisplayed());
        assertTrue(confirmationOrderScreen.getThankYouTitle().isDisplayed());

    }


    @When("I choose client from header")
    public void iChooseClientFromHeader() {
        String test = conciergeUserAccountPage.getClientButton().getText();
        System.out.println();
        if (conciergeUserAccountPage.getClientButton().getText().equals("CLIENT")) {

            conciergeUserAccountPage.getClientButton().click();
            conciergeUserAccountPage.getClientLookupHeaderBtn().click();
            wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getClientLookupFirstName()));
            conciergeUserAccountPage.getClientLookupFirstName().sendKeys("Mihail");
            conciergeUserAccountPage.getClientLookupLastName().sendKeys("Dovbenco");
            conciergeUserAccountPage.getClientLookupSearchButton().click();
            wait.until(ExpectedConditions.textToBePresentInElement(conciergeOrderHistoryForm.getCustomerFirstName(),"NAME"));
            conciergeUserAccountPage.getFirstResultOfClientLookup().click();
        }
    }
}

