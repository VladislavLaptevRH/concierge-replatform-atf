package com.test.stepdefinitions;

import com.test.pageObject.ConciergeItemsScreen;
import com.test.pageObject.ConciergeProjectScreen;
import com.test.pageObject.ConciergeUserAccountPage;
import com.test.utility.Hooks;
import gherkin.lexer.Ja;
import gherkin.lexer.Th;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class ConciergeE2EStepDefs {
    WebDriver webDriver = Hooks.getWebDriver();
    WebDriverWait wait = new WebDriverWait(webDriver, 20);
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen(webDriver);
    ConciergeProjectScreen conciergeProjectScreen = new ConciergeProjectScreen(webDriver);
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage(webDriver);
    Random random = new Random();

    @When("I click on add to project button")
    public void userClickOnAddToProjectButton() {
        wait.until(ExpectedConditions.visibilityOf(conciergeItemsScreen.getAddToProjectButton()));
        conciergeItemsScreen.getAddToProjectButton().click();

        wait.until(ExpectedConditions.elementToBeClickable(conciergeItemsScreen.getSaveProjectPopUpButton()));
        conciergeItemsScreen.getSaveProjectPopUpButton().click();

//        wait.until(ExpectedConditions.visibilityOf(conciergeItemsScreen.getViewCartButton()));
//        conciergeItemsScreen.getViewCartButton().click();
    }

    @When("I click on go to project button")
    public void iClickOnGoToProjectButton() {
        wait.until(ExpectedConditions.elementToBeClickable(conciergeItemsScreen.getGoToProjectButton()));
        conciergeItemsScreen.getGoToProjectButton().click();
    }

    @When("I click on add to cart button from project screen")
    public void iClickOnAddToCartButtonFromProjectScreen() {
        wait.until(ExpectedConditions.visibilityOf(conciergeProjectScreen.getProjectTitle()));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;js.executeScript("window.scrollBy(0,3000)");
        wait.until(ExpectedConditions.textToBePresentInElement(conciergeProjectScreen.getAddToCartButton(),"ADD TO CART"));
        conciergeProjectScreen.getAddToCartButton().click();
        wait.until(ExpectedConditions.elementToBeClickable(conciergeProjectScreen.getContinueButtonPopUp()));
        conciergeProjectScreen.getContinueButtonPopUp().click();
    }

    @When("I choose random brand from menu")
    public void iChooseRandomBrandFromMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getDashboardTitle()));
        wait.until(ExpectedConditions.elementToBeClickable(conciergeUserAccountPage.getOrderHistoryButton()));
        conciergeUserAccountPage.getBrandButton().click();
        conciergeUserAccountPage.getListOfBrands().get(1).click();

    }
}
