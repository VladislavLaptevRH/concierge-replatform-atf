package com.test.stepdefinitions;

import com.test.pageObject.*;
import com.test.utility.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.awaitility.Awaitility.await;

public class ConciergeE2EStepDefs {
    WebDriver webDriver = Hooks.getWebDriver();
    WebDriverWait wait = new WebDriverWait(webDriver, 20);
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen(webDriver);
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage(webDriver);
    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen(webDriver);
    RestrictionPopUp restrictionPopUp = new RestrictionPopUp(webDriver);
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    AbstractStepDefs abstractStepDefs = new AbstractStepDefs();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen(webDriver);
    String usState = "";

    @When("I click on add to project button")
    public void userClickOnAddToProjectButton() {
        wait.until(ExpectedConditions.visibilityOf(conciergeItemsScreen.getAddToProjectButton()));
        conciergeItemsScreen.getAddToProjectButton().click();

        wait.until(ExpectedConditions.elementToBeClickable(conciergeItemsScreen.getSaveProjectPopUpButton()));
        conciergeItemsScreen.getSaveProjectPopUpButton().click();

        generalStepDefs.isElementVisible("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4'][1]//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained')]");
        conciergeItemsScreen.getGoToProjectButton().click();
    }

    @When("I click on go to project button")
    public void iClickOnGoToProjectButton() throws InterruptedException {
        generalStepDefs.isElementVisible("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4'][1]//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained')]");
        wait.until(ExpectedConditions.elementToBeClickable(conciergeItemsScreen.getContinueShoppingButton()));
        conciergeItemsScreen.getGoToProjectButton().click();
    }

    @When("I click on add to cart button from project screen")
    public void iClickOnAddToCartButtonFromProjectScreen() throws InterruptedException {
        generalStepDefs.isElementVisible("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth']/span[@class='MuiButton-label']");
        WebElement element = webDriver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-fullWidth']/span[@class='MuiButton-label']"));
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", element);
    }

    @When("I choose random brand from menu")
    public void iChooseRandomBrandFromMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getDashboardTitle()));
        wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getOrderHistoryButton()));
        conciergeUserAccountPage.getBrandButton().click();
        conciergeUserAccountPage.getListOfBrands().get(1).click();

    }

    @When("I go to item which has {string} restriction")
    public void iGoToItemWhichHasRestriction(String state) {
        usState = state;
        if (state.equals("NY")) {
            generalStepDefs.waitForPageLoad(webDriver);
            conciergeUserAccountPage.getSearchItemField().sendKeys("112411 BLSH BUMP");
        }
        if (state.equals("CA")) {
            generalStepDefs.waitForPageLoad(webDriver);
            conciergeUserAccountPage.getSearchItemField().sendKeys("10061229 CTCN");
        }
        conciergeUserAccountPage.getSearchButton().click();
        try {
            if (conciergeUserAccountPage.getSeeResultsButton().isDisplayed()) {
                conciergeUserAccountPage.getSeeResultsButton().click();
            }
        } catch (Exception e) {
            System.out.println("See results button is not displayed");
        }

    }

    @When("I click on add to cart button")
    public void iClickOnAddToCartButton() {
        generalStepDefs.isElementVisible("//div[1]/div[@class='MuiFormControl-root MuiFormControl-fullWidth']/button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary']");
        conciergeItemsScreen.getAddToCartButton().click();

        if (usState.equals("CA")) {
            try {
                await().forever().until(() -> conciergeItemsScreen.getAggreeeAndAddToCardButton().isDisplayed());
                conciergeItemsScreen.getAggreeeAndAddToCardButton().click();
            } catch (Exception e) {
                System.out.println("Agree&add to card button is not displayed");
            }
        }
        wait.until(ExpectedConditions.visibilityOf(conciergeItemsScreen.getViewCartButton()));
        conciergeItemsScreen.getViewCartButton().click();

    }


    @When("I fill all fields from address with {string} zip code")
    public void iFillAllFieldsFromAddressWithZipCode(String state) throws InterruptedException {
        generalStepDefs.waitForPageLoad(webDriver);
        generalStepDefs.fillAddressFields();

        if (state.equals("NY")) {
            generalStepDefs.fillZipCodeStateCountry("10001", "US", "NY");
        }
        if (state.equals("CA")) {
            generalStepDefs.fillZipCodeStateCountry("A1A1A1", "CA", "");

        }
        generalStepDefs.continueToPaymentAfterAddressCheckout();
    }

    @Then("I verify that restrictions pop up is displayed")
    public void iVerifyThatRestrictionsPopUpIsDisplayed() {
        if (usState.equals("NY")) {
            usState = "New York";
        } else {
            usState = "Canada";
        }
        generalStepDefs.isElementVisible("//h2[@class='MuiTypography-root MuiTypography-h2']");

        restrictionPopUp.getShippingRestricitonsTitle().getText().equals("SHIPPING ERROR");
        restrictionPopUp.getRestrictionsMessage().getText().equals("One or more items in your cart ($Savannah Ultra-Fine Organic Cotton Crib Bumper) cannot be shipped to the state of  " + usState + "  due to state regulations.Please remove the item(s) from your cart, or provide a different shipping address for this order.");
    }

    @When("I remove all items from cart")
    public void iRemoveAllItemsFromCart() {
        await().forever().until(() -> conciergeUserAccountPage.getCartButton().isDisplayed());
        if (!conciergeUserAccountPage.getCartButton().getText().equals("CART 0")) {
            try {
                conciergeUserAccountPage.getCartButton().click();
                generalStepDefs.isElementVisible("//div[7]//div[1]/div/div/div/div[2]//div[2]/div[4]/div[1]/a/span");
                WebElement webElement = webDriver.findElement(By.xpath("//div[7]//div[1]/div/div/div/div[2]//div[2]/div[4]/div[1]/a/span"));
                if (webElement.isDisplayed()) {
                    while (webElement.isDisplayed()) {
                        await().forever().until(() -> webElement.isDisplayed());
                        webElement.click();
                    }
                }
            } catch (Exception e) {
                System.out.println("");
            }
            conciergeCartPageScreen.getPleaseContinueBrowsingButton().click();
        }
    }

    @When("I continue to payment")
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
}

