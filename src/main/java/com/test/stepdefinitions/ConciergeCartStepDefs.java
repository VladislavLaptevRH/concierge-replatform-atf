package com.test.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.test.pageObject.ConciergeCartPageScreen;
import com.test.pageObject.ConciergeItemsScreen;
import com.test.pageObject.ConciergeUserAccountPage;
import com.test.utility.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.text.DecimalFormat;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ConciergeCartStepDefs {
    WebDriver webDriver = Hooks.getWebDriver();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    ConciergeCartPageScreen conciergeCartPageScreen = new ConciergeCartPageScreen();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();
    int randomQuantity;
    int priceFirstLineItem;
    int priceSecondLineItem;
    String lineItemPriceValueBeforeOverride;
    DecimalFormat digitFormatDoubleZero = new DecimalFormat("0.00");


    @When("I navigate to the cart page")
    public void iNavigateToTheCartPage() {
        conciergeUserAccountPage.getCartButton().shouldBe(visible, Duration.ofSeconds(25));
        conciergeUserAccountPage.getCartButton().click();
    }

    @Then("I verify that products the following options {string},{string},{string} are in the shopping cart")
    public void iVerifyThatProductsTheFollowingOptionsAreInTheShoppingCart(String productId, String fullSkuId, String quanity) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(conciergeCartPageScreen.getGramTurkishTowel());

        if (fullSkuId.equals("62960714")) {
            assertEquals(conciergeCartPageScreen.getArlesRectangularDinigTableTitle().getText(), "ARLES RECTANGULAR DINING TABLE");
            assertEquals(conciergeCartPageScreen.getArlesRectangularDinigTableId().getText(), "62960714 LGRY");
            System.out.println();
        }
        if (fullSkuId.equals("17050042")) {
            actions.perform();
            assertEquals(conciergeCartPageScreen.getGramTurkishTowel().getText(), "17050042 NGRH");
            assertEquals(conciergeCartPageScreen.getGramTurkishTitle().getText(), "802-GRAM TURKISH TOWEL COLLECTION");
        }
        assertTrue(conciergeCartPageScreen.getQuantityButton().isDisplayed(), "Quantity button is displayed");
    }

    @Then("I verify that cart is displayed")
    public void iVerifyThatCartIsDisplayed() {
        conciergeCartPageScreen.getOrderClassificationSelect().shouldBe(visible, Duration.ofSeconds(15));
        assertTrue(conciergeCartPageScreen.getOrderClassificationSelect().isDisplayed(), "Order classification is displayed");
        assertTrue(conciergeItemsScreen.getCheckoutButton().isDisplayed(), "Checkout button is displayed");

    }

    @When("I click on view cart button")
    public void iClickOnViewCartButton() {
        try {
            conciergeCartPageScreen.getItemAddedToYourCart().shouldHave(text("1 Item  Added To Your Cart"), Duration.ofSeconds(60));
            conciergeItemsScreen.getViewCartButton().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(60));
            conciergeItemsScreen.getViewCartButton().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Agree&add to cart button is not displayed");
        }
    }

    @Then("I verify order classification")
    public void iVerifyOrderClassification() {
        conciergeCartPageScreen.getOrderClassificationSelect().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getOrderClassificationSelect().click();
        conciergeCartPageScreen.getOrderClassificationGalleryOrder().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getOrderClassificationInteriorDesign().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getOrderClassificationResidentialTrade().shouldBe(visible, Duration.ofMinutes(1));
    }

    @Then("I verify member banner for guest client")
    public void iVerifyMemberBannerForGuestClient() {
        conciergeCartPageScreen.getNoThanksButton().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getNoThanksButton().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getBecomeAmemberNow().shouldBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Rh Members Program']")).shouldBe(visible, Duration.ofMinutes(1));
        $(By.xpath("(//*[contains(text(),'Join the RH Members Program for ')])[2]")).shouldBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Your RH Membership immediately pays for itself.']")).shouldBe(visible, Duration.ofMinutes(1));
    }

    @When("I click on clear order button from cart")
    public void iClickOnClearOrderButtonFromCart() {
        conciergeCartPageScreen.getClearOrderButton().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getClearOrderButton().scrollIntoView(true);
        conciergeCartPageScreen.getClearOrderButton().click();
        $(By.xpath("//*[text()='CLEAR ORDER']")).shouldBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='CLEAR ORDER']")).click();
        $(By.xpath("(//a[@class='MuiTypography-root MuiLink-root MuiLink-underlineHover MuiTypography-colorPrimary'])[3]")).getText().equals("CART 0");
    }

    @When("I click on quantity line item button")
    public void iClickOnQuantityLineItemButton() {
        $(By.xpath("//select[contains(@id,'quantity')]")).shouldBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//select[contains(@id,'quantity')]")).click();
        randomQuantity = generalStepDefs.getRandomNumber(2, 5);
        sleep(3000);
        $(By.xpath("//option[@value='" + randomQuantity + "']")).shouldHave(text(Integer.toString(randomQuantity)), Duration.ofSeconds(10));
        $(By.xpath("//option[@value='" + randomQuantity + "']")).scrollIntoView(true);
        sleep(2000);
        $(By.xpath("//option[@value='" + randomQuantity + "']")).click();

    }

    @Then("I verify that quantity was updated")
    public void iVerifyThatQuantityWasUpdated() {
        $(By.xpath("(//a[@class='MuiTypography-root MuiLink-root MuiLink-underlineHover MuiTypography-colorPrimary'])[3]")).getText().equals("CART " + randomQuantity);
    }

    @When("I click on remove button from cart page")
    public void iClickOnRemoveButtonFromCartPage() {
        sleep(3000);
        $(By.xpath("//*[text()='Remove']")).shouldBe(visible, Duration.ofMinutes(1));
        executeJavaScript("window.scrollTo(0, 700)");
        sleep(3000);
        $(By.xpath("//*[text()='Remove']")).click();
    }

    @Then("I verify that line item was removed")
    public void iVerifyThatLineItemWasRemoved() {
        sleep(6000);
        $(By.xpath("//*[text()='Metal Box Frame Leaner Mirror']")).shouldNotBe(visible, Duration.ofMinutes(1));
    }

    @When("I click on total item line price")
    public void iClickOnTotalItemLinePrice() {
        conciergeCartPageScreen.getTotalMemberPrice().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getTotalMemberPrice().scrollIntoView(true);
        lineItemPriceValueBeforeOverride = conciergeCartPageScreen.getTotalMemberPrice().getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", "").replaceAll("C", "");
        conciergeCartPageScreen.getTotalMemberPrice().click();
    }

    @When("I select price override {string}")
    public void iSelectPriceOverride(String arg0) {
        $(By.xpath("//option[@value='" + arg0 + "']")).shouldBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//option[@value='" + arg0 + "']")).click();
    }

    @When("I introduces value for override price")
    public void iIntroducesValueForOverridePrice() {
        $(By.xpath("//input[@id='adjustment']")).shouldBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//input[@id='adjustment']")).setValue("");
        $(By.xpath("//input[@id='adjustment']")).setValue("50");
    }

    @When("I choose reason code for price override")
    public void iChooseReasonCodeForPriceOverride() {
        Select select = new Select($(By.xpath("//select[@id='reason_code']")));
        select.selectByValue("G");
    }

    @When("I click on apply uppercase button for {string}")
    public void iClickOnApplyUppercaseButton(String method) {
//        if (method.equals("PERCENT_OFF")) {
        $(By.xpath("//*[text()='APPLY']")).shouldBe(visible, Duration.ofMinutes(1));
        sleep(3000);
        $(By.xpath("//*[text()='APPLY']")).click();
        //        } else {
//            $(By.xpath("//*[text()='UPDATE']")).shouldBe(visible, Duration.ofMinutes(1));
//            $(By.xpath("//*[text()='UPDATE']")).click();
//        }
    }

    @Then("I verify line items prices for {string}")
    public void iVerifyLineItemsPricesFor(String arg0) {
        conciergeCartPageScreen.getTotalMemberPrice().shouldBe(visible, Duration.ofMinutes(1));
        if (arg0.equals("PERCENT_OFF")) {
            sleep(2000);
            String lineItemPriceValueAfterOverride = conciergeCartPageScreen.getTotalMemberPrice().getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", "").replaceAll("C", "");
            float line = Float.parseFloat(lineItemPriceValueBeforeOverride) / 2;

            assertEquals(digitFormatDoubleZero.format(line), lineItemPriceValueAfterOverride);
        }
        if (arg0.equals("AMOUNT_OFF")) {
            sleep(2000);
            String lineItemPriceValueAfterOverride = conciergeCartPageScreen.getTotalMemberPrice().getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", "").replaceAll("C", "");
            int expectedValuePriceValue = Integer.parseInt(lineItemPriceValueBeforeOverride) - 50;
            assertEquals(expectedValuePriceValue, Integer.parseInt(lineItemPriceValueAfterOverride));
        }
        if (arg0.equals("AMOUNT_OVERRIDE")) {
            sleep(2000);
            String lineItemPriceValueAfterOverride = conciergeCartPageScreen.getTotalMemberPrice().getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", "").replaceAll("C", "");
            assertEquals(lineItemPriceValueAfterOverride, "50");
        }
    }

    @When("I click on apply all checkbox")
    public void iClickOnApplyAllCheckbox() {
        sleep(3000);
        $(By.xpath("//input[@name='applyToCart']")).click();
    }

    @When("I save price for every line item")
    public void iSavePriceForEveryLineItem() {
        priceFirstLineItem = Integer.parseInt($(By.xpath("(//h5[@class='MuiTypography-root MuiTypography-h5 MuiTypography-alignRight'])[1]")).getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", ""));
        priceSecondLineItem = Integer.parseInt($(By.xpath("(//h5[@class='MuiTypography-root MuiTypography-h5 MuiTypography-alignRight'])[2]")).getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", ""));
    }

    @Then("I verify that price override was executed for all line items")
    public void iVerifyThatPriceOverrideWasExecutedForAllLineItems() {
        int priceFirstLineItemAfterOverride = Integer.parseInt($(By.xpath("(//h5[@class='MuiTypography-root MuiTypography-h5 MuiTypography-alignRight'])[1]")).getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", ""));
        int priceSecondLineItemAfterOverride = Integer.parseInt($(By.xpath("(//h5[@class='MuiTypography-root MuiTypography-h5 MuiTypography-alignRight'])[2]")).getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", ""));
        assertEquals(priceFirstLineItem, priceFirstLineItemAfterOverride / 2);
        assertEquals(priceSecondLineItem, priceSecondLineItemAfterOverride / 2);
    }

    @When("I click on remove button from price override")
    public void iClickOnRemoveButtonFromPriceOverride() {
        $(By.xpath("//*[text()='REMOVE']")).shouldBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='REMOVE']")).click();
    }

    @Then("I verify that price override was removed")
    public void iVerifyThatPriceOverrideWasRemoved() {
        String lineItemPriceValueAfterOverride = conciergeCartPageScreen.getTotalMemberPrice().getText().replaceAll(",", "").replaceAll(".00", "").replaceAll("\\$", "").replaceAll("C", "");
        assertEquals(lineItemPriceValueBeforeOverride, lineItemPriceValueAfterOverride, "Price override was removed");
    }

    @When("I click on UFD button from cart")
    public void iClickOnUFDButtonFromCart() {
        conciergeCartPageScreen.getUfdCartButton().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getUfdCartButton().scrollIntoView(true);
        conciergeCartPageScreen.getUfdCartButton().click();
    }

    @When("I click on apply promocode button")
    public void iClickOnApplyPromocodeButton() {
        conciergeCartPageScreen.getApplyPromocodeButton().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getApplyPromocodeButton().click();
    }

    @When("I introduces promo code for promo codes field")
    public void iIntroducesPromoCodeForPromoCodesField() {
        conciergeCartPageScreen.getPromotionCodeField().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getPromotionCodeField().scrollIntoView(true);
        conciergeCartPageScreen.getPromotionCodeField().setValue("HM4TS96");

    }
}
