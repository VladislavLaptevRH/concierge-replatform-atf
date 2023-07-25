package tests.concierge.stepdefinitions;

import com.codeborne.selenide.WebDriverRunner;

import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.support.ui.Select;
import tests.concierge.pageObject.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import tests.utility.Hooks;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.Assert.*;

public class Pdp {
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();
    PdpScreen pdpScreen = new PdpScreen();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    SelectOption selectOption = new SelectOption();
    @When("I click on add monogram checkbox from pdp")
    public void iClickOnAddMonogramCheckboxFromPdp() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        conciergeItemsScreen.getAddMonogramCheckBoxPdp().click();
    }

    @When("I choose monogram properties for pdp")
    public void iChooseMonogramPropertiesForPdp() {
//        conciergeCartPageScreen.getMonogramColors().get(2).should(visible, Duration.ofMinutes(1));
        with().pollInterval(3, SECONDS).await().until(() -> true);
        conciergeCartPageScreen.getMonogramColors().get(2).scrollIntoView(true);
        conciergeCartPageScreen.getMonogramColors().get(2).click();
//        conciergeItemsScreen.getMonogramColorChampagne().should(visible, Duration.ofSeconds(40));
        with().pollInterval(2, SECONDS).await().until(() -> true);
        conciergeItemsScreen.getMonogramColorChampagne().scrollIntoView(true);
        conciergeItemsScreen.getMonogramColorChampagne().click();
        conciergeCartPageScreen.getMonogramText().setValue("test");
        conciergeCartPageScreen.getAddMonogramButton().click();
    }

    @Then("I verify that monogram was added for pdp")
    public void iVerifyThatMonogramWasAddedForPdp() {
        $(By.xpath("//*[text()='Bauer Bodoni 1 (BDNI-HC)']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Text']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Style']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Color']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='MCHA']")).should(visible, Duration.ofSeconds(40));
    }

    @When("I click on \"view in stock items\" link")
    public void iClickOnViewInStockItems() {
        with().pollInterval(2, SECONDS).await().until(() -> true);
        $(By.xpath("//*[text()='In-Stock']")).shouldHave(text("In-Stock"), Duration.ofSeconds(20));
        $(By.xpath("//*[text()='In-Stock']")).scrollIntoView(true);
        $(By.xpath("//*[text()='In-Stock']")).click();
    }

    @Then("I verify that in stock modal pop up is displayed")
    public void iVerifyThatInStockModalPopUpIsDisplayed() {
        $(By.xpath("//*[text()='IN STOCK']")).shouldHave(text("IN STOCK"), Duration.ofSeconds(15));
        $(By.xpath("//*[text()='These options are available for']")).shouldBe(visible, Duration.ofSeconds(15));
    }

    @When("I click on \"view select items on sale\" link")
    public void iClickOnViewSaleItems() {
        with().pollInterval(2, SECONDS).await().until(() -> true);
        //$(By.xpath("//*[text()='Sale']")).shouldHave(text("Sale"), Duration.ofSeconds(20));
        if(!$(By.xpath("//*[text()='VIEW SELECT ITEMS ON SALE']")).isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        $(By.xpath("//*[text()='VIEW SELECT ITEMS ON SALE']")).scrollIntoView(true);
        $(By.xpath("//*[text()='VIEW SELECT ITEMS ON SALE']")).click();
    }

//    @When("Verify that \"Sale modal\" opens")
//    public void verifySaleModalOpens() {
//        $(By.xpath("//*[text()='ON SALE']")).should(visible, Duration.ofSeconds(20));
//    }

    @When("Verify that \"Sale modal\" {string}")
    public void verifySaleModalData(String data) {
       switch (data){
           case  "opens":
               $(By.xpath("//*[text()='ON SALE']")).should(visible, Duration.ofSeconds(20));;
               break;
           case  "has a title":
               $(By.xpath("//div/p[text()='French Contemporary Fabric Panel Bed']")).should(visible, Duration.ofSeconds(5));
               break;
           case  "has item#":
               $(By.xpath("//*[@id='listColumn1-Item#']")).shouldHave(text("Item#"), Duration.ofSeconds(5));
               $(By.xpath("//*[@id='listColumn2-Item#']")).shouldHave(text("60450998 BWMR"), Duration.ofSeconds(5));
               break;
           case  "has price, member and sale price":
               $(By.xpath("//*[text()='Price']")).should(visible, Duration.ofSeconds(5));
               $(By.xpath("//*[@id='sku-price-list']/div[2]/p[1]")).shouldHave(text("$3734"), Duration.ofSeconds(5));
               $(By.xpath("//*[@id='sku-price-list']/div[2]/p[3]")).shouldHave(text("$2734\n" + "Sale"), Duration.ofSeconds(5));
               $(By.xpath("//*[@id='sku-price-list']/div[2]/p[5]")).shouldHave(text("$2185"), Duration.ofSeconds(5));
               $(By.xpath("//*[@id='sku-price-list']/div[2]/p[6]")).shouldHave(text("Member"), Duration.ofSeconds(5));
               break;
           case  "has qty dropdown":
               $(By.xpath("//*[text()='Qty']")).should(visible, Duration.ofSeconds(5));
               $(By.xpath("//*[@data-testid='in-stock-qty-select']")).should(visible, Duration.ofSeconds(5));
               break;
           case  "has \"add to cart\" and \"add to project\" buttons":
               $(By.xpath("//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-cart-dialog-opener']")).should(visible, Duration.ofSeconds(5));
               $(By.xpath("//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-project-dialog-opener']")).should(visible, Duration.ofSeconds(5));
               break;
           case  "has an item can be added to cart from modal":
               $(By.xpath("//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-cart-dialog-opener']")).click();
               $(By.xpath("//*[@id = 'ajax-proceed-to-cart']/span[1]")).should(visible, Duration.ofSeconds(5));
               $(By.xpath("//*[@id = 'ajax-continue-shopping']/span[1]")).should(visible, Duration.ofSeconds(5));
               $(By.xpath("(//*[@data-testid = 'dialog-title-close-button'])[2]")).click();
               break;
           case  "has an item can be added to project from modal":
               $(By.xpath("//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-project-dialog-opener']")).click();
               $(By.xpath("//h3[text() = 'ADD TO PROJECT']")).should(visible, Duration.ofSeconds(5));
               $(By.xpath("//*[text() = 'CANCEL']")).should(visible, Duration.ofSeconds(5));
               $(By.xpath("//*[text() = 'SAVE']")).should(visible, Duration.ofSeconds(5));
               break;
           default:
               break;
       }
    }

    @When("Verify that \"In Stock modal\" {string}")
    public void verifyInStockModalData(String data) {
        switch (data){
            case  "opens":
                $(By.xpath("//*[text()='IN STOCK']")).shouldHave(text("IN STOCK"), Duration.ofSeconds(15));
                $(By.xpath("//*[text()='These options are available for']")).shouldBe(visible, Duration.ofSeconds(15));
                break;
            case  "has a title":
                $(By.xpath("//div/p[text()='French Contemporary Fabric Panel Bed']")).should(visible, Duration.ofSeconds(5));
                break;
            case  "has item#":
                $(By.xpath("(//*[@id='listColumn1-Item#'])[4]")).shouldHave(text("Item#"), Duration.ofSeconds(5));
                $(By.xpath("(//*[@id='listColumn2-Item#'])[4]")).shouldHave(text("60450996 BLNL"), Duration.ofSeconds(5));
                break;
            case  "has price and member price":
                $(By.xpath("(//*[text()='Price'])[4]")).should(visible, Duration.ofSeconds(5));
                $(By.xpath("(//*[@id='sku-price-list']/div[2]/p[1])[4]")).shouldHave(text("$3967"), Duration.ofSeconds(5));
                $(By.xpath("(//*[@id='sku-price-list']/div[2]/p[3])[4]")).shouldHave(text("$2975"), Duration.ofSeconds(5));
                $(By.xpath("(//*[@id='sku-price-list']/div[2]/p[4])[4]")).shouldHave(text("Member"), Duration.ofSeconds(5));
                break;
            case  "has qty dropdown":
                $(By.xpath("(//*[text()='Qty'])[1]")).should(visible, Duration.ofSeconds(5));
                $(By.xpath("(//*[@data-testid='in-stock-qty-select'])[4]")).should(visible, Duration.ofSeconds(5));
                break;
            case  "has \"add to cart\" and \"add to project\" buttons":
                $(By.xpath("(//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-cart-dialog-opener'])[4]")).should(visible, Duration.ofSeconds(5));
                $(By.xpath("(//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-project-dialog-opener'])[4]")).should(visible, Duration.ofSeconds(5));
                break;
            case  "has an item can be added to cart from modal":
                $(By.xpath("(//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-cart-dialog-opener'])[4]")).click();
                $(By.xpath("//*[@id = 'ajax-proceed-to-cart']/span[1]")).should(visible, Duration.ofSeconds(5));
                $(By.xpath("//*[@id = 'ajax-continue-shopping']/span[1]")).should(visible, Duration.ofSeconds(5));
                $(By.xpath("(//*[@data-testid = 'dialog-title-close-button'])[2]")).click();
                break;
            case  "has an item can be added to project from modal":
                $(By.xpath("(//*[contains(@class, 'MuiDialogContent-root')]//*[@data-testid = 'add-to-project-dialog-opener'])[4]")).click();
                $(By.xpath("//h3[text() = 'ADD TO PROJECT']")).should(visible, Duration.ofSeconds(5));
                $(By.xpath("//*[text() = 'CANCEL']")).should(visible, Duration.ofSeconds(5));
                $(By.xpath("//*[text() = 'SAVE']")).should(visible, Duration.ofSeconds(5));
                break;
            default:
                break;
        }
    }

    @When("I go to custom rugs")
    public void iGoToCustomRugs() {
        $(By.xpath("//div[@data-navigation-account-item-id='rhbc_cat479005']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//div[@data-navigation-account-item-id='rhbc_cat479005']")).click();
        $(By.xpath("//*[text()='Rugs By Fiber']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Rugs By Fiber']")).click();
    }
    //div[@class='MuiGrid-root MuiGrid-container MuiGrid-justify-xs-space-between']/div[6]
    @Then("I verify that custom rugs are displayed")
    public void iVerifyThatCustomRugsAreDisplayed() {
        $(By.xpath("//*[text()='Wool Rugs']")).should(visible, Duration.ofSeconds(25));
        $(By.xpath("//*[text()='Performance Fiber Rugs']")).should(visible, Duration.ofSeconds(25));
    }

    @When("I click on windows from top menu")
    public void iClickOnWindowsFromTopMenu() {
        $(By.xpath("//div[@data-navigation-account-item-id='cat160095']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//div[@data-navigation-account-item-id='cat160095']")).click();

        $(By.xpath("//*[text()='Custom Window Treatments']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Custom Window Treatments']")).click();
    }

    @Then("I verify that custom windows are displayed")
    public void iVerifyThatCustomWindowsAreDisplayed() {
        $(By.xpath("//*[text()='Custom Drapery Collections']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Custom Shades']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='Custom Window Hardware']")).should(visible, Duration.ofSeconds(40));
    }

    @Then("I verify that YAML carousel is displayed")
    public void iVerifyThatYAMLCarouselIsDisplayed() {
        $(By.xpath("//*[text()='YOU MIGHT ALSO LIKE']")).scrollTo();
        $(By.xpath("//*[text()='YOU MIGHT ALSO LIKE']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='YOU MIGHT ALSO LIKE']")).scrollIntoView(true);
        List<String> items1 = new ArrayList<>();
        List<String> items2 = new ArrayList<>();
        List<String> expectedItems = new ArrayList<>(Arrays.asList("CLOUD SOFA", "CLOUD TRACK ARM SOFA" , "CLOUD SLOPE ARM MODULAR CUSTOMIZABLE SECTIONAL"));
        for (int i = 0; i < 3; i++) {
            items1.add(pdpScreen.getTtemYAMLListByNumber(i+1).getText());
            with().pollInterval(1, SECONDS).await().until(() -> true);
        }
        with().pollInterval(1, SECONDS).await().until(() -> true);
        assertEquals(items1, expectedItems);
        $(By.xpath("(//*[text() = 'YOU MIGHT ALSO LIKE']/..//ul/div/div)[3]")).click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        for (int i = 3; i < 6 ; i++) {
            items2.add(pdpScreen.getTtemYAMLListByNumber(i+1).getText());
        }
        assertNotEquals(items2, expectedItems);
    }

    @Then("I verify text \"Mattress fee\" and amount in checkout is present for state {string}")
    public void iVerifyTextMattressFeeAndAmountInCheckout(String state) {
        if(state.equals("CA")) {
            assertEquals(pdpScreen.getMattressFeeText().getText(), "Mattress Fee");
            assertEquals($(By.xpath("//*[text() = 'Mattress Fee']/../..//p")).getText(), "$10.50");
        }
        if(state.equals("RI")){
            assertEquals(pdpScreen.getMattressFeeText().getText(), "Mattress Fee");
            assertEquals($(By.xpath("//*[text() = 'Mattress Fee']/../..//p")).getText(), "$16.00");
        }
        if(state.equals("CT")){
            assertEquals(pdpScreen.getMattressFeeText().getText(), "Mattress Fee");
            assertEquals($(By.xpath("//*[text() = 'Mattress Fee']/../..//p")).getText(), "$11.75");
        }

    }

    @Then("I verify that text \"{string} requires a mattress recycling fee to be collected at checkout state\" is present in PDP")
    public void iVerifyMattressRecyclingFee(String state) {
        if(state.equals("CA")) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            if (conciergeItemsScreen.getSelectSize().isDisplayed()) {
                try {
                    Select sizeList = new Select(conciergeItemsScreen.getSelectSize());
                    sizeList.selectByIndex(1);
                } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException | ElementNotFound e) {
                    System.out.println("Element Size not found");
                }
                with().pollInterval(2, SECONDS).await().until(() -> true);
            }
            if (conciergeItemsScreen.getSelectQTY().isDisplayed()) {
                try {
                    Select quantityList = new Select(conciergeItemsScreen.getSelectQTY());
                    quantityList.selectByIndex(2);
                    with().pollInterval(2, SECONDS).await().until(() -> true);
                } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException | ElementNotFound e) {
                    System.out.println("Element qty not found");
                }
            }
            assertEquals("California requires a mattress recycling fee to be collected at checkout.", pdpScreen.getMattressRecyclingFeeText().getText());
        }
        if(state.equals("RI")){
            WebDriverRunner.getWebDriver().navigate().refresh();
            if (conciergeItemsScreen.getSelectSize().isDisplayed()) {
                try {
                    Select sizeList = new Select(conciergeItemsScreen.getSelectSize());
                    sizeList.selectByIndex(1);
                } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException | ElementNotFound e) {
                    System.out.println("Element Size not found");
                }
                with().pollInterval(2, SECONDS).await().until(() -> true);
            }
            if (conciergeItemsScreen.getSelectQTY().isDisplayed()) {
                try {
                    Select quantityList = new Select(conciergeItemsScreen.getSelectQTY());
                    quantityList.selectByIndex(2);
                    with().pollInterval(2, SECONDS).await().until(() -> true);
                } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException | ElementNotFound e) {
                    System.out.println("Element qty not found");
                }
            }
            assertEquals("Rhode Island requires a mattress recycling fee to be collected at checkout.", pdpScreen.getMattressRecyclingFeeText().getText());
        }
        if(state.equals("CT")){
            WebDriverRunner.getWebDriver().navigate().refresh();
            if (conciergeItemsScreen.getSelectSize().isDisplayed()) {
                try {
                    Select sizeList = new Select(conciergeItemsScreen.getSelectSize());
                    sizeList.selectByIndex(1);
                } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException | ElementNotFound e) {
                    System.out.println("Element Size not found");
                }
                with().pollInterval(2, SECONDS).await().until(() -> true);
            }
            if (conciergeItemsScreen.getSelectQTY().isDisplayed()) {
                try {
                    Select quantityList = new Select(conciergeItemsScreen.getSelectQTY());
                    quantityList.selectByIndex(2);
                    with().pollInterval(2, SECONDS).await().until(() -> true);
                } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException | ElementNotFound e) {
                    System.out.println("Element qty not found");
                }
            }
            assertEquals("Connecticut requires a mattress recycling fee to be collected at checkout.", pdpScreen.getMattressRecyclingFeeText().getText());
        }
    }

    @Then("I verify that replacements parts modal pop up is displayed")
    public void iVerifyThatReplacementsPartsModalPopUpIsDisplayed() {
        $(By.xpath("//*[text()='REPLACEMENT PARTS']")).should(visible, Duration.ofSeconds(40));
    }

    @Then("I verify that check for replacements parts button is displayed")
    public void iVerifyThatCheckForReplacementsPartsButtonIsDisplayed() {
        $(By.xpath("//*[text()='CHECK FOR REPLACEMENT PARTS']")).scrollTo();
        $(By.xpath("//*[text()='CHECK FOR REPLACEMENT PARTS']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='CHECK FOR REPLACEMENT PARTS']")).click();
    }

    @When("I click on special order fabrics")
    public void iClickOnSpecialOrderFabrics() {
        WebDriverRunner.getWebDriver().navigate().refresh();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if (conciergeItemsScreen.getSelectSize().isDisplayed()) {
            try {
                Select sizeList = new Select(conciergeItemsScreen.getSelectSize());
                sizeList.selectByIndex(1);
            } catch (org.openqa.selenium.NoSuchElementException | java.lang.UnsupportedOperationException |
                     ElementNotFound e) {
                System.out.println("Element Size not found");
            }
            with().pollInterval(2, SECONDS).await().until(() -> true);
        }
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if(!pdpScreen.getSpecialOrdersButton().isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        pdpScreen.getSpecialOrdersButton().should(visible, Duration.ofSeconds(40));
        pdpScreen.getSpecialOrdersButton().click();
    }

    @When("I choose color from special order fabrics")
    public void iChooseColorFromSpecialOrderFabrics() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        pdpScreen.getFogSpecialOrderColor().should(visible, Duration.ofSeconds(40));
        pdpScreen.getFogSpecialOrderColor().hover();
        pdpScreen.getFogSpecialOrderColor().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
        pdpScreen.getCloseSpecialOrderPopUpButton().hover();
        pdpScreen.getCloseSpecialOrderPopUpButton().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
    }

    @Then("I verify that color has been chosen")
    public void iVerifyThatColorHasBeenChosen() {
        selectOption.getColorOption().shouldHave(text("Fog"), Duration.ofSeconds(20));
    }

    @Then("I change state for {string} with zip code {string}")
    public void iChangeZipCodeFor(String state, String zipCode) {
        if(state.equals("CA")) {
            if (pdpScreen.getZipCode().getText().replaceAll("\\.", "").equals(zipCode)) {
                System.out.println("It's California");
            } else {
                pdpScreen.getZipCode().should(visible, Duration.ofSeconds(40));
                pdpScreen.getZipCode().click();
                pdpScreen.getPostalCode().should(visible, Duration.ofSeconds(40));
                pdpScreen.getPostalCode().setValue(zipCode);
                pdpScreen.getConfirmationPostalCode().click();
                with().pollInterval(5, SECONDS).await().until(() -> true);
            }
        }
        if(state.equals("RI")){
            pdpScreen.getZipCode().should(visible, Duration.ofSeconds(40));
            pdpScreen.getZipCode().click();
            pdpScreen.getPostalCode().should(visible, Duration.ofSeconds(40));
            pdpScreen.getPostalCode().setValue(zipCode);
            pdpScreen.getConfirmationPostalCode().click();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        if(state.equals("CT")){
            pdpScreen.getZipCode().should(visible, Duration.ofSeconds(40));
            pdpScreen.getZipCode().click();
            pdpScreen.getPostalCode().should(visible, Duration.ofSeconds(40));
            pdpScreen.getPostalCode().setValue(zipCode);
            pdpScreen.getConfirmationPostalCode().click();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
    }
    @Then("I verify that availability, Delivery and returns messaging is displayed for {string}")
    public void iVerifyThatAvailabilityDeliveryAndReturnsMessagingIsDisplayedFor(String arg0) {

        if (arg0.equals("SO")) {
            if (!$(By.xpath("//*[contains(text(),'This item is special order and will be ready for delivery between ')]")).isDisplayed()) {
                WebDriverRunner.getWebDriver().navigate().refresh();
                with().pollInterval(5, SECONDS).await().until(() -> true);
            }
                $(By.xpath("//*[contains(text(),'This item is special order and will be ready for delivery between ')]")).scrollTo();
                $(By.xpath("//*[contains(text(),'This item is special order and will be ready for delivery between ')]")).should(visible, Duration.ofSeconds(30));

        }
        if (arg0.equals("BO")) {
            if (!$(By.xpath("//*[contains(text(),'This item can be returned within 30 days of delivery.')]")).isDisplayed()) {
                WebDriverRunner.getWebDriver().navigate().refresh();
                with().pollInterval(5, SECONDS).await().until(() -> true);
            }
            $(By.xpath("//*[contains(text(),'This item can be returned within 30 days of delivery.')]")).scrollTo();
            $(By.xpath("//*[contains(text(),'This item can be returned within 30 days of delivery.')]")).should(visible, Duration.ofSeconds(30));
        }
    }

    @Then("I verify price in cart is the same as price on PDP page")
    public void iVerifyPriceInCartIsTheSameAsPriceOnPDPPage() {
        conciergeCartPageScreen.getTotalMemberPrice().isDisplayed();
    }

    @When("I go to Swatch Landing Page")
    public void iGoToSwatchLandingPage() {
        String URL = Hooks.conciergeBaseURL + "/swatch/order.jsp";
        open(URL);
    }

    @Then("I verify that swatch landing page is displayed")
    public void iVerifyThatSwatchLandingPageIsDisplayed() {
        $(By.xpath("//*[text()='Premium Fabrics']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='Premium Leathers']")).should(visible, Duration.ofSeconds(15));
    }
}
