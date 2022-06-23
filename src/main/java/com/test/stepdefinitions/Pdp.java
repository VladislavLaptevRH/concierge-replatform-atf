package com.test.stepdefinitions;

import com.test.pageObject.ConciergeCartPageScreen;
import com.test.pageObject.ConciergeItemsScreen;
import com.test.pageObject.ConciergeUserAccountPage;
import com.test.pageObject.PdpScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Pdp {
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();
    PdpScreen pdpScreen = new PdpScreen();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();

    @When("I click on add monogram checkbox from pdp")
    public void iClickOnAddMonogramCheckboxFromPdp() {
        sleep(3000);
        conciergeItemsScreen.getAddMonogramCheckBoxPdp().click();
    }

    @When("I choose monogram properties for pdp")
    public void iChooseMonogramPropertiesForPdp() {
//        conciergeCartPageScreen.getMonogramColors().get(2).should(visible, Duration.ofMinutes(1));
        sleep(3000);
        conciergeCartPageScreen.getMonogramColors().get(2).scrollIntoView(true);
        conciergeCartPageScreen.getMonogramColors().get(2).click();
//        conciergeItemsScreen.getMonogramColorChampagne().should(visible, Duration.ofSeconds(20));
        sleep(2000);
        conciergeItemsScreen.getMonogramColorChampagne().scrollIntoView(true);
        conciergeItemsScreen.getMonogramColorChampagne().click();
        conciergeCartPageScreen.getMonogramText().setValue("test");
        conciergeCartPageScreen.getAddMonogramButton().click();
    }

    @Then("I verify that monogram was added for pdp")
    public void iVerifyThatMonogramWasAddedForPdp() {
        $(By.xpath("//*[text()='Bauer Bodoni 1 (BDNI-HC)']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Text']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Style']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Color']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='MCHA']")).should(visible, Duration.ofSeconds(20));
    }

    @When("I click on view in stock items")
    public void iClickOnViewInStockItems() {
        $(By.xpath("//*[text()='In-Stock']")).shouldHave(text("In-Stock"), Duration.ofSeconds(20));
        $(By.xpath("//*[text()='In-Stock']")).scrollIntoView(true);
        $(By.xpath("//*[text()='In-Stock']")).click();
    }

    @Then("I verify that in stock modal pop up is displayed")
    public void iVerifyThatInStockModalPopUpIsDisplayed() {
        $(By.xpath("//*[text()='IN STOCK']")).shouldHave(text("IN STOCK"), Duration.ofSeconds(15));
        $(By.xpath("//*[text()='These options are available for']")).shouldBe(visible, Duration.ofSeconds(15));
    }

    @When("I click on view sale items")
    public void iClickOnViewSaleItems() {
        $(By.xpath("//*[text()='Sale']")).shouldHave(text("Sale"), Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Sale']")).scrollIntoView(true);
        $(By.xpath("//*[text()='Sale']")).click();
    }

    @Then("I verify that on sale modal pop up is displayed")
    public void iVerifyThatOnSaleModalPopUpIsDisplayed() {
        $(By.xpath("//*[text()='ON SALE']")).shouldHave(text("ON SALE"), Duration.ofSeconds(20));
    }

    @When("I go to custom rugs")
    public void iGoToCustomRugs() {
        $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item'][5]/h6")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item'][5]/h6")).click();
        $(By.xpath("//ul[@class='MuiList-root']/li[@class='MuiListItem-root'][13]")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//ul[@class='MuiList-root']/li[@class='MuiListItem-root'][13]")).click();
    }

    @Then("I verify that custom rugs are displayed")
    public void iVerifyThatCustomRugsAreDisplayed() {
        $(By.xpath("//*[text()=' Custom Braided Wool Rug']")).should(visible, Duration.ofSeconds(25));
        $(By.xpath("//*[text()='Custom Sized Rugs']")).should(visible, Duration.ofSeconds(25));
    }

    @When("I click on windows from top menu")
    public void iClickOnWindowsFromTopMenu() {
        $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item'][8]/h6")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item'][8]/h6")).click();

        $(By.xpath("(//li[@class='MuiListItem-root'][2]//p)[1]")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("(//li[@class='MuiListItem-root'][2]//p)[1]")).click();
    }

    @Then("I verify that custom windows are displayed")
    public void iVerifyThatCustomWindowsAreDisplayed() {
        $(By.xpath("//*[text()='Custom Drapery']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Custom Shades']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Custom Window Hardware']")).should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that YAML carousel is displayed")
    public void iVerifyThatYAMLCarouselIsDisplayed() {
        $(By.xpath("//*[text()='The Cloud Collection']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='The Cloud Collection']")).scrollIntoView(true);
    }

    @Then("I verify mattress recycling fee")
    public void iVerifyMattressRecyclingFee() {
        $(By.xpath("//*[text()='mattress recycling fee']")).should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that replacements parts modal pop up is displayed")
    public void iVerifyThatReplacementsPartsModalPopUpIsDisplayed() {
        $(By.xpath("//*[text()='REPLACEMENT PARTS']")).should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that check for replacements parts button is displayed")
    public void iVerifyThatCheckForReplacementsPartsButtonIsDisplayed() {
        $(By.xpath("//*[text()='CHECK FOR REPLACEMENT PARTS']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='CHECK FOR REPLACEMENT PARTS']")).click();
    }

    @When("I click on special order fabrics")
    public void iClickOnSpecialOrderFabrics() {
        pdpScreen.getSpecialOrdersButton().should(visible, Duration.ofSeconds(20));
        pdpScreen.getSpecialOrdersButton().click();
    }

    @When("I choose color from special order fabrics")
    public void iChooseColorFromSpecialOrderFabrics() {
        pdpScreen.getFogSpecialOrderColor().should(visible, Duration.ofSeconds(20));
        pdpScreen.getFogSpecialOrderColor().click();
    }

    @Then("I verify that color has been chosen")
    public void iVerifyThatColorHasBeenChosen() {
        pdpScreen.getCloseSpecialOrderPopUpButton().click();
        pdpScreen.getFogSelectedOption().shouldHave(text("Fog"), Duration.ofSeconds(20));

    }

    @Then("I verify that availability, Delivery and returns messaging is displayed for {string}")
    public void iVerifyThatAvailabilityDeliveryAndReturnsMessagingIsDisplayedFor(String arg0) {
        if (arg0.equals("SO")) {
            $(By.xpath("//*[contains(text(),'This item is special order and will be ready for delivery between ')]")).should(visible, Duration.ofSeconds(50));
        }
        if (arg0.equals("BO")) {
            $(By.xpath("//*[contains(text(),'This item can be returned within 30 days of delivery.')]")).should(visible, Duration.ofSeconds(50));
        }
    }

    @Then("I verify price in cart is the same as price on PDP page")
    public void iVerifyPriceInCartIsTheSameAsPriceOnPDPPage() {
        conciergeCartPageScreen.getTotalMemberPrice().shouldHave(text("$1,327.00"), Duration.ofSeconds(20));
    }

    @When("I go to Swatch Landing Page")
    public void iGoToSwatchLandingPage() {
        conciergeUserAccountPage.getInStockButtonMenu().should(visible, Duration.ofSeconds(15));
        conciergeUserAccountPage.getInStockButtonMenu().click();
        $(By.xpath("//li[@class='MuiListItem-root'][13]")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//li[@class='MuiListItem-root'][13]")).click();
    }

    @Then("I verify that swatch landing page is displayed")
    public void iVerifyThatSwatchLandingPageIsDisplayed() {
        $(By.xpath("//*[text()='Premium Fabrics']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='Premium Leathers']")).should(visible, Duration.ofSeconds(15));
    }
}
