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
import org.openqa.selenium.support.ui.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
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
    WebDriverWait wait = new WebDriverWait(webDriver, 20);
    Actions actions = new Actions(webDriver);
    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen(webDriver);
    PaymentScreen paymentScreen = new PaymentScreen(webDriver);
    ReviewOrderScreen reviewOrderScreen = new ReviewOrderScreen(webDriver);
    ConfirmationOrderScreen confirmationOrderScreen = new ConfirmationOrderScreen(webDriver);
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen(webDriver);


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


    private void clearField(WebElement field) {
        field.click();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        if (!field.getAttribute("value").isEmpty()) {
            js.executeScript("arguments[0].value='';", field);
        }
    }

    @When("I clicks on a random menu item")
    public void iClicksOnARandomMenuItem() {
        wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getDashboardTitle()));
        wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getOrderHistoryButton()));

        wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getMenuItems().get(0)));
        actions.moveToElement(conciergeUserAccountPage.getMenuItems().get(0));
        conciergeUserAccountPage.getMenuItems().get(0).click();

        wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getItemSubCategory().get(0)));
        actions.moveToElement(conciergeUserAccountPage.getItemSubCategory().get(0));
        conciergeUserAccountPage.getItemSubCategory().get(0).click();
    }


    @When("I clicks on o random item")
    public void iClicksOnORandomItem() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(conciergeItemsScreen.getItems().get(0)));
        conciergeItemsScreen.getItems().get(0).click();

    }


    @When("I fill all options for item")
    public void iFillAllOptionsForItem() {
        WebElement webElement = webDriver.findElement(By.xpath("//h2[@class='MuiTypography-root MuiTypography-h2']"));
        wait.until(ExpectedConditions.visibilityOf(webElement));

        String currentUrl = webDriver.getCurrentUrl();
        String currentProduct = currentUrl.substring(currentUrl.indexOf("="), currentUrl.indexOf("&")).replace("=", "");
        WebElement quantity = webDriver.findElement(By.xpath("//select[@id='" + currentProduct + "-qty-input']//option[3]"));
        wait.until(ExpectedConditions.elementToBeClickable(quantity));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", quantity);
        quantity.click();
    }

    @When("I click on add to cart button")
    public void iClickOnAddToCartButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(conciergeItemsScreen.getAddToCartButton()));
        conciergeItemsScreen.getAddToCartButton().click();
        wait.until(ExpectedConditions.visibilityOf(conciergeItemsScreen.getViewCartButton()));
        conciergeItemsScreen.getViewCartButton().click();
    }

    @When("I click on checkout button")
    public void iClickOnCheckoutButton() {
        Select select = new Select(conciergeCartPageScreen.getOrderClassificationSelect());
        select.selectByIndex(1);
        wait.until(ExpectedConditions.elementToBeClickable(conciergeItemsScreen.getCheckoutButton()));
        conciergeItemsScreen.getCheckoutButton().click();

        wait.until(ExpectedConditions.visibilityOf(conciergeItemsScreen.getClosePopUpButton()));
        conciergeItemsScreen.getClosePopUpButton().click();
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
        wait.until(ExpectedConditions.visibilityOf(conciergeUserAccountPage.getClientButton()));
        if (conciergeUserAccountPage.getClientButton().getText().equals("CLIENT")) {

            conciergeUserAccountPage.getClientButton().click();
            conciergeUserAccountPage.getClientLookupHeaderBtn().click();
            wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getClientLookupFirstName()));
            conciergeUserAccountPage.getClientLookupFirstName().sendKeys("Mihail");
            conciergeUserAccountPage.getClientLookupLastName().sendKeys("Dovbenco");
            conciergeUserAccountPage.getClientLookupSearchButton().click();
            wait.until(ExpectedConditions.textToBePresentInElement(conciergeOrderHistoryForm.getCustomerFirstName(), "NAME"));
            conciergeUserAccountPage.getFirstResultOfClientLookup().click();
        }
    }


    @When("I fill all fields from address screen")
    public void iFillAllFieldsFromAddressScreenForBrands() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutAddressScreen.getFirstNameInpt()));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutAddressScreen.getLastNameField()));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutAddressScreen.getCompanyNameField()));
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
        clearField(checkoutAddressScreen.getZipPostalCodeField());
        checkoutAddressScreen.getZipPostalCodeField().sendKeys("12345");
        checkoutAddressScreen.getPhoneField().sendKeys("+124131231");

        wait.until(ExpectedConditions.elementToBeClickable(checkoutAddressScreen.getFirstNameInpt()));
        wait.until(ExpectedConditions.visibilityOf(checkoutAddressScreen.getFirstNameInpt()));
        checkoutAddressScreen.getBillingAddressAsShippingCheckBox().click();
        Select selectState = new Select(checkoutAddressScreen.getStateField());
        selectState.selectByIndex(ThreadLocalRandom.current().nextInt(1, 15));
        checkoutAddressScreen.getContinuePaymentButton().click();
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", checkoutAddressScreen.getContinueButton());
        wait.until(ExpectedConditions.elementToBeClickable(checkoutAddressScreen.getContinueButton()));
        checkoutAddressScreen.getContinueButton().click();
    }

    @When("I clicks on a random menu item for brands")
    public void iClicksOnARandomMenuItemForBrands() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getMenuItems().get(0)));
        actions.moveToElement(conciergeUserAccountPage.getMenuItems().get(0));
        conciergeUserAccountPage.getMenuItems().get(0).click();

        wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getItemSubCategory().get(0)));
        actions.moveToElement(conciergeUserAccountPage.getItemSubCategory().get(0));
        conciergeUserAccountPage.getItemSubCategory().get(0).click();
    }

}

