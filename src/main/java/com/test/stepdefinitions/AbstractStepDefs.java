package com.test.stepdefinitions;

import com.test.pageObject.*;
import com.test.utility.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.awaitility.Awaitility.await;
import static org.testng.Assert.assertTrue;

public class AbstractStepDefs {

    WebDriver webDriver = Hooks.getWebDriver();
    ConciergeOrderHistoryForm conciergeOrderHistoryForm = new ConciergeOrderHistoryForm(webDriver);
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage(webDriver);
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen(webDriver);
    WebDriverWait wait = new WebDriverWait(webDriver, 20);
    Actions actions = new Actions(webDriver);
    PaymentScreen paymentScreen = new PaymentScreen(webDriver);
    ReviewOrderScreen reviewOrderScreen = new ReviewOrderScreen(webDriver);
    ConfirmationOrderScreen confirmationOrderScreen = new ConfirmationOrderScreen(webDriver);
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen(webDriver);
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();


    @When("I clicks on a random menu item")
    public void iClicksOnARandomMenuItem() {
//        generalStepDefs.isElementVisible("//h1[@class='MuiTypography-root MuiTypography-h1']");
//        wait.until(ExpectedConditions.textToBePresentInElement(conciergeUserAccountPage.getDashboardTitle(), "DASHBOARD"));
//        wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getOrderHistoryButton()));

        generalStepDefs.isElementVisible("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-justify-xs-space-between']//div");
        actions.moveToElement(conciergeUserAccountPage.getMenuItems().get(0));
        conciergeUserAccountPage.getMenuItems().get(0).click();
        conciergeUserAccountPage.getMenuItems().get(0).click();
wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getArtButtonMenu()));

        wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getItemSubCategory().get(2)));
        generalStepDefs.isElementVisible("//div[2]//ul[@class='MuiList-root']/li[@class='MuiListItem-root'][2]");
        actions.moveToElement(conciergeUserAccountPage.getItemSubCategory().get(2));
        conciergeUserAccountPage.getItemSubCategory().get(2).click();
        System.out.println();
    }


    @When("I clicks on o random item")
    public void iClicksOnORandomItem() {
        generalStepDefs.waitForPageLoad(webDriver);
        wait.until(ExpectedConditions.elementToBeClickable(conciergeItemsScreen.getItems().get(0)));
        generalStepDefs.isElementVisible("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-true']/div/ul//li[@class='MuiGridListTile-root']");
        conciergeItemsScreen.getItems().get(0).click();
    }


    @When("I fill all options for item")
    public void iFillAllOptionsForItem() {
        generalStepDefs.waitForPageLoad(webDriver);
        generalStepDefs.isElementVisible("//h2[@class='MuiTypography-root MuiTypography-h2']");
        String currentUrl = webDriver.getCurrentUrl();
        String currentProduct;
        if (currentUrl.contains("&")) {
            currentProduct = currentUrl.substring(currentUrl.indexOf("="), currentUrl.indexOf("&")).
                    replace("=", "");
        } else {
            currentProduct = currentUrl.substring(currentUrl.indexOf("="), 96).replace("=", "");
            WebElement sizeOption = webDriver.findElement(By.xpath("//select[@id='optionSelect-" + currentProduct + "-Size']"));
            Select selectSize = new Select(sizeOption);
            selectSize.selectByIndex((1));

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='optionSelect-" + currentProduct + "-Color']")));
            WebElement colorOption = webDriver.findElement(By.xpath("//select[@id='optionSelect-" + currentProduct + "-Color']"));
            Select selectColorOption = new Select(colorOption);
            selectColorOption.selectByIndex((1));
        }

        generalStepDefs.isElementVisible("//select[@id='" + currentProduct + "-qty-input']//option[3]");
        WebElement quantity = webDriver.findElement(By.xpath("//select[@id='" + currentProduct + "-qty-input']//option[3]"));
        await().forever().until(quantity::isDisplayed);
        wait.until(ExpectedConditions.elementToBeClickable(quantity));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", quantity);
        quantity.click();
    }

    @When("I click on checkout button")
    public void iClickOnCheckoutButton() {
        generalStepDefs.isElementVisible("//select[@id='element-orderclassification']");
        Select select = new Select(conciergeCartPageScreen.getOrderClassificationSelect());
        select.selectByIndex(1);
        wait.until(ExpectedConditions.elementToBeClickable(conciergeItemsScreen.getCheckoutButton()));
        generalStepDefs.isElementVisible("//div[contains(@class,'MuiGrid-root MuiGrid-container MuiGrid-item')][2]//button");
        conciergeItemsScreen.getCheckoutButton().click();

        wait.until(ExpectedConditions.visibilityOf(conciergeItemsScreen.getClosePopUpButton()));
        conciergeItemsScreen.getClosePopUpButton().click();
    }

    @When("I introduces payment details")
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
        generalStepDefs.isElementVisible("//button[contains(@class,'MuiButton-contained MuiButton-containedPrimary')]");
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
        generalStepDefs.waitForPageLoad(webDriver);
        try {
            if (conciergeUserAccountPage.getClientButton().getText().equals("CLIENT")) {
                conciergeUserAccountPage.getClientButton().click();
                generalStepDefs.isElementVisible("//span[normalize-space()='Client Lookup']");
                conciergeUserAccountPage.getClientLookupHeaderBtn().click();
                wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getClientLookupFirstName()));
                conciergeUserAccountPage.getClientLookupFirstName().sendKeys("Mihail");
                conciergeUserAccountPage.getClientLookupLastName().sendKeys("Dovbenco");
                conciergeUserAccountPage.getClientLookupSearchButton().click();
                wait.until(ExpectedConditions.textToBePresentInElement(conciergeOrderHistoryForm.getCustomerFirstName(), "NAME"));
                conciergeUserAccountPage.getFirstResultOfClientLookup().click();
                wait.until(ExpectedConditions.textToBePresentInElement(conciergeUserAccountPage.getClientButton(), "Mihail"));
            }
        } catch (Exception e) {
            System.out.println("Client is selected");
        }

    }


    @When("I fill all fields from address screen")
    public void iFillAllFieldsFromAddressScreenForBrands() {
        try {
            generalStepDefs.fillAddressFields();
            generalStepDefs.fillZipCodeStateCountry("12345", "US", "");
        } catch (Exception e) {
            System.out.println("Address fields are not available");
        }

    }

    @When("I clicks on a random menu item for brands")
    public void iClicksOnARandomMenuItemForBrands() {
        await().forever().until(() -> conciergeUserAccountPage.getMenuItems().get(0).isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getMenuItems().get(0)));
        actions.moveToElement(conciergeUserAccountPage.getMenuItems().get(0));
        conciergeUserAccountPage.getMenuItems().get(0).click();

        wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getItemSubCategory().get(0)));
        actions.moveToElement(conciergeUserAccountPage.getItemSubCategory().get(0));
        conciergeUserAccountPage.getItemSubCategory().get(0).click();
    }

}

