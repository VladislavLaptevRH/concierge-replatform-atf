package com.test.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.test.pageObject.*;
import com.test.utility.Hooks;
import io.cucumber.java.en.And;
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
    String totalPriceCart;
    DecimalFormat digitFormatDoubleZero = new DecimalFormat("0.00");
    PaymentScreen paymentScreen = new PaymentScreen();
    SelectOption selectOption = new SelectOption();
    ProjectSettingsScreen projectSettingsScreen = new ProjectSettingsScreen();
    ConciergeProjectScreen conciergeProjectScreen = new ConciergeProjectScreen();
    CheckoutAddressScreen checkoutAddressScreen = new CheckoutAddressScreen();


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
            conciergeCartPageScreen.getItemAddedToYourCart().shouldHave(text("Added To Your Cart"), Duration.ofSeconds(30));
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
        $(By.xpath("//input[@id='adjustment']")).click();
        sleep(2000);
        executeJavaScript("arguments[0].value='';", $(By.xpath("//input[@id='adjustment']")));
        sleep(2000);
        $(By.xpath("//input[@id='adjustment']")).setValue("50");
    }

    @When("I choose reason code for price override")
    public void iChooseReasonCodeForPriceOverride() {
        Select select = new Select($(By.xpath("//select[@id='reason_code']")));
        select.selectByValue("G");
    }

    @When("I click on apply uppercase button for {string}")
    public void iClickOnApplyUppercaseButton(String method) {
        $(By.xpath("//*[text()='APPLY']")).shouldBe(visible, Duration.ofMinutes(1));
        sleep(3000);
        $(By.xpath("//*[text()='APPLY']")).click();
    }

    @Then("I verify line items prices for {string}")
    public void iVerifyLineItemsPricesFor(String arg0) {
        conciergeCartPageScreen.getTotalMemberPrice().shouldBe(visible, Duration.ofMinutes(1));
        if (arg0.equals("PERCENT_OFF")) {
            sleep(2000);
            String lineItemPriceValueAfterOverride = conciergeCartPageScreen.getTotalMemberPrice().getText().replaceAll(",", "").replaceAll("\\$", "").replaceAll("C", "");
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
            sleep(10000);
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

        try {
            sleep(3000);
            $(By.xpath("//*[text()='Accept']")).shouldBe(visible, Duration.ofMinutes(1));
            $(By.xpath("//*[text()='Accept']")).click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }
    }

    @When("I introduces promo code for promo codes field")
    public void iIntroducesPromoCodeForPromoCodesField() {
        conciergeCartPageScreen.getPromotionCodeField().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getPromotionCodeField().scrollIntoView(true);
        conciergeCartPageScreen.getPromotionCodeField().setValue("FEMAD");

        totalPriceCart = conciergeCartPageScreen.getTotalMemberPrice().getText();
    }

    @Then("I verify that promocode was approved for cart items")
    public void iVerifyThatPromocodeWasApprovedForCartItems() {
        assertEquals(conciergeCartPageScreen.getTotalMemberPrice().getText(), "$1,617.00");
    }

    @Then("I verify that total price from cart and from payment page is the same")
    public void iVerifyThatTotalPriceFromCartAndFromPaymentPageIsTheSame() {
        $(By.xpath("//*[text()='" + totalPriceCart + "']")).shouldBe(visible, Duration.ofMinutes(1));
    }

    @When("I choose POP for payment method")
    public void iChoosePOPForPaymentMethod() {
        paymentScreen.getChoosePaymentMethodBtn().shouldHave(text("Choose a payment method"), Duration.ofMinutes(1));
        sleep(2000);
        paymentScreen.getChoosePaymentMethodBtn().shouldBe(Condition.be(visible), Duration.ofSeconds(35));
        Select selectPayment = new Select(paymentScreen.getChoosePaymentMethodBtn());
        selectPayment.selectByValue("POS");
        conciergeCartPageScreen.getPosRegisterField().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getPosRegisterField().setValue("1234");
        conciergeCartPageScreen.getPosTransactionField().setValue("1234");
        paymentScreen.getContinueToReview().shouldBe(Condition.and("clickable", visible, enabled), Duration.ofMinutes(1));
        sleep(4000);
        paymentScreen.getContinueToReview().click();

    }

    @Then("I verify that Total Additional Product Discount message is {string} on review page")
    public void iVerifyThatTotalAdditionalProductDiscountMessageIsOnReviewPage(String arg0) {
        if (arg0.equals("displayed")) {
            $(By.xpath("//*[text()='Total Additional Product Discount']")).shouldBe(visible, Duration.ofMinutes(1));
            $(By.xpath("//*[text()='$539.00']")).shouldBe(visible, Duration.ofMinutes(1));
        } else {
            $(By.xpath("//*[text()='Total Additional Product Discount']")).shouldNotBe(visible, Duration.ofMinutes(1));
        }
    }

    @Then("I verify that promo code was removed")
    public void iVerifyThatPromoCodeWasRemoved() {
        $(By.xpath("//*[text()='Members have the privilege of receiving 25% off full priced items or 20% off sale items, whichever is the best price. Tax, shipping and surcharges are not included in calculating discount. Not valid for gift cards, personalization and gift boxes.']")).shouldNotBe(visible, Duration.ofMinutes(1));
    }

    @When("I select size option {int} for item")
    public void iSelectSizeOptionForItem(int sizeValue) {
        sleep(10000);
        try {
            selectOption.getSelectSizeElement().shouldBe(Condition.and("", visible, enabled), Duration.ofSeconds(5));
            Select size = new Select(selectOption.getSelectSizeElement());
            size.selectByIndex(sizeValue);
        } catch (
                com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Element is not displayed");
        }
    }

    @When("I click on add new space button")
    public void iClickOnAddNewSpaceButton() {
        sleep(1);
        projectSettingsScreen.getAddNewSpaceButton().shouldBe(visible, Duration.ofSeconds(20));
        projectSettingsScreen.getAddNewSpaceButton().click();
    }

    @When("I choose {string} project from move to project pop up")
    public void iChooseProjectFromMoveToProjectPopUp(String arg0) {
        conciergeProjectScreen.getProjectName().shouldBe(visible, Duration.ofSeconds(15));
        Select selectProjectName = new Select(conciergeProjectScreen.getProjectName());
        sleep(2000);
        selectProjectName.selectByVisibleText("additemtocorrectspace");
    }

    @When("I choose {string} space from move to project pop up")
    public void iChooseSpaceFromMoveToProjectPopUp(String arg0) {
        conciergeProjectScreen.getProjectName().shouldBe(visible, Duration.ofSeconds(15));
        Select selectProjectName = new Select(conciergeProjectScreen.getSelectSpaceName());
        sleep(2000);
        selectProjectName.selectByVisibleText(arg0);
    }

    @Then("I verify that spaces are displayed in space dropdown")
    public void iVerifyThatSpacesAreDisplayedInSpaceDropdown() {
        $(By.xpath("//div[1]/button//div[contains(@class,'MuiGrid-root MuiGrid-container')]")).shouldBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//div[1]/button//div[contains(@class,'MuiGrid-root MuiGrid-container')]")).click();
        $(By.xpath("//*[text()='correctspace']")).shouldBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='wrongspace']")).shouldBe(visible, Duration.ofMinutes(1));
    }

    @When("I click on update button from price override pop up")
    public void iClickOnUpdateButtonFromPriceOverridePopUp() {
        conciergeCartPageScreen.getUpdateButton().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getUpdateButton().click();
    }

    @Then("I verify that mini cart value is equal to {int}")
    public void iVerifyThatMiniCartValueIsEqualTo(int arg0) {
        conciergeUserAccountPage.getCartButton().shouldHave(text("CART " + randomQuantity));
    }

    @Then("I verify member banner for {string} client")
    public void iVerifyMemberBannerForClient(String arg0) {
        conciergeCartPageScreen.getMembersProgramTitle().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getJoinRhMemberProgramTitle().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getJoinNow().shouldBe(visible, Duration.ofMinutes(1));
    }

    @Then("I verify member banner for {string} client not displayed")
    public void iVerifyMemberBannerForClientNotDisplayed(String arg0) {
        conciergeCartPageScreen.getMembersProgramTitle().shouldNotBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getJoinRhMemberProgramTitle().shouldNotBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getJoinNow().shouldNotBe(visible, Duration.ofMinutes(1));
    }

    @Then("I verify that membership popup for {string} is displayed")
    public void iVerifyThatMembershipPopupForIsDisplayed(String arg0) {
        conciergeCartPageScreen.getNoThanksButton().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getBecomeAmemberNow().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getMembersProgramTitle().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getJoinRhMemberProgramTitle().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getRhMembershipImmediatlyPay().shouldBe(visible, Duration.ofMinutes(1));
    }

    @Then("I verify that ship to, bill to, sold to addresses are displayed")
    public void iVerifyThatShipToBillToSoldToAddressesAreDisplayed() {
        conciergeCartPageScreen.getSoldToAddressTitle().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getBillingAddressTitle().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getShippingAddressTitle().shouldBe(visible, Duration.ofMinutes(1));
    }

    @And("I edit ship to, bill to, sold to addresses")
    public void iEditShipToBillToSoldToAddresses() {
        $(By.xpath("(//*[text()='Edit'])[1]")).click();
        checkoutAddressScreen.getCompanyNameField().shouldBe(visible, Duration.ofMinutes(1));
        generalStepDefs.clearField(checkoutAddressScreen.getCompanyNameField());
        checkoutAddressScreen.getCompanyNameField().setValue("changedCompanyNameSoldAddress");
        $(By.xpath("(//*[text()='Edit'])[10]")).scrollIntoView(true);
        $(By.xpath("(//*[text()='Edit'])[10]")).click();
        $(By.xpath("(//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input)[2]")).shouldBe(visible, Duration.ofMinutes(1));
        generalStepDefs.clearField($(By.xpath("(//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input)[2]")));
        $(By.xpath("(//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input)[2]")).setValue("changedCompanyNameBillingAddress");

        $(By.xpath("(//*[text()='Edit'])[1]")).click();
        $(By.xpath("(//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input)[3]")).shouldBe(visible, Duration.ofMinutes(1));
        generalStepDefs.clearField($(By.xpath("(//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input)[3]")));
        $(By.xpath("(//div[3]/div[contains(@class,'MuiOutlinedInput-root')]/input)[3]")).setValue("changedCompanyNameShippingAddress");

    }

    @Then("I verify that membership price displayed as total price")
    public void iVerifyThatMembershipPriceDisplayedAsTotalPrice() {
        conciergeCartPageScreen.getTotalMemberPrice().shouldHave(text("$1,724.00"), Duration.ofMinutes(1));
    }

    @When("I click on postpone shipment")
    public void iClickOnPostponeShipment() {
        conciergeCartPageScreen.getPostponeShipment().shouldBe(visible, Duration.ofMinutes(1));
        conciergeCartPageScreen.getPostponeShipment().click();
    }

    @When("I choose postpone shipment")
    public void iChoosePostponeShipment() {
        conciergeCartPageScreen.getPostponeShipment().scrollIntoView(true);
        conciergeCartPageScreen.getPostponeShipment().click();
        Select postponeReasonCode = new Select(conciergeCartPageScreen.getPostponeSelectReasonCode());
        postponeReasonCode.selectByValue("Construction/Remodel");
    }

    @Then("I verify that postpone shipment was applied")
    public void iVerifyThatPostponeShipmentWasApplied() {
        conciergeCartPageScreen.getPostponeShipOnOrAfterDate().shouldHave(text("Ship on or after: "), Duration.ofMinutes(1));
    }

    @When("I click add gift box")
    public void iClickAddGiftBox() {
        sleep(7000);
        conciergeItemsScreen.getAddGiftCheckBox().click();
    }

    @Then("I verify that gift box was added")
    public void iVerifyThatGiftBoxWasAdded() {
        $(By.xpath("//*[text()='Gift Box Fee']")).shouldBe(visible, Duration.ofMinutes(1));
    }

    @When("I click on remove gift box button")
    public void iClickOnRemoveGiftBoxButton() {
        sleep(5000);
        conciergeItemsScreen.getAddGiftCheckBox().click();
    }

    @Then("I verify that gift box was removed")
    public void iVerifyThatGiftBoxWasRemoved() {
        $(By.xpath("//*[text()='Gift Box Fee']")).shouldNotBe(visible, Duration.ofMinutes(1));
    }

    @Then("I verify that member savings for a {string} user")
    public void iVerifyThatMemberSavingsForAUser(String arg0) {
        conciergeCartPageScreen.getTotalMemberPrice().shouldHave(text("$2,156.00"), Duration.ofMinutes(1));
    }

    @When("I click on cart button from header")
    public void iClickOnCartButtonFromHeader() {
        conciergeCartPageScreen.getShippingAddressTitle().shouldBe(visible, Duration.ofMinutes(1));
        conciergeUserAccountPage.getCartButton().click();
    }

    @Then("I verify {string} savings for a {string} user")
    public void iVerifyThatSavingsForAUser(String arg0, String arg1) {
        if (arg1.equals("nonmember") || (arg1.equals("contract"))) {
            conciergeCartPageScreen.getTotalMemberPrice().shouldHave(text("$2,156.00"), Duration.ofMinutes(1));
        }
        if (arg1.equals("trade")) {
            $(By.xpath("//*[text()='Trade savings']")).shouldBe(visible, Duration.ofMinutes(1));
            $(By.xpath("//*[text()='$432.00']")).shouldBe(visible, Duration.ofMinutes(1));
        }
        if (arg1.equals("member")) {
            $(By.xpath("//*[text()='Member Savings']")).shouldBe(visible, Duration.ofMinutes(1));
            $(By.xpath("//*[text()='$432.00']")).shouldBe(visible, Duration.ofMinutes(1));
        }

    }

    @When("I goes to address page from review screen")
    public void iGoesToAddressPageFromReviewScreen() {
        conciergeCartPageScreen.getAddressButton().shouldBe(visible, Duration.ofMinutes(1));
        sleep(3000);
        conciergeCartPageScreen.getAddressButton().click();
    }

    @Then("I verify that address saved in address page")
    public void iVerifyThatAddressSavedInAddressPage() {
        checkoutAddressScreen.getFirstNameInpt().shouldHave(value("QA1"), Duration.ofMinutes(1));
        checkoutAddressScreen.getLastNameField().shouldHave(value("Automation"), Duration.ofMinutes(1));
    }

    @Then("I verify that monogram was added")
    public void iVerifyThatMonoramWasAdded() {
        $(By.xpath("//*[text()='PERSONALIZATION']")).shouldBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Bauer Bodoni 2 (BDNI-HD)']")).shouldBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Champagne Metallic (MCHA)']")).shouldBe(visible, Duration.ofMinutes(1));

    }

    @When("I edit monogram")
    public void iEditMonogram() {
        sleep(5000);
        $(By.xpath("(//*[text()='Edit'])[2]")).shouldBe(visible, Duration.ofMinutes(1));
        $(By.xpath("(//*[text()='Edit'])[2]")).click();

        $(By.xpath("(//ul[@class='MuiGridList-root'])[2]//li[@class='MuiGridListTile-root'][5]")).click();
        $(By.xpath("//*[text()='add monogram']")).click();

    }

    @Then("I verify that monogram was edited")
    public void iVerifyThatMonogramWasEdited() {
        $(By.xpath("//*[text()='Light Silver Metallic (MLSL)']")).shouldBe(visible, Duration.ofMinutes(1));
    }

    @When("I remove monogram")
    public void iRemoveMonogram() {
        sleep(5000);
        $(By.xpath("(//*[text()='Remove'])[1]")).shouldBe(visible, Duration.ofMinutes(1));
        $(By.xpath("(//*[text()='Remove'])[1]")).click();
    }

    @Then("I verify that monogram was removed")
    public void iVerifyThatMonogramWasRemoved() {
        $(By.xpath("//*[text()='PERSONALIZATION']")).shouldNotBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Bauer Bodoni 2 (BDNI-HD)']")).shouldNotBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Champagne Metallic (MCHA)']")).shouldNotBe(visible, Duration.ofMinutes(1));
    }

    @Then("I verify that availability, Delivery and Returns messaging in cart")
    public void iVerifyThatAvailabilityDeliveryAndReturnsMessagingInCart() {
        $(By.xpath("//*[contains(text(),'This item is in stock and will be ready for delivery between 05/11/22 and 05/15/22')]")).shouldBe(visible, Duration.ofSeconds(10));
        $(By.xpath("//*[contains(text(),'This item is final sale and cannot be returned.')]")).shouldBe(visible, Duration.ofMinutes(1));
    }

    @Then("I verify alternate addresses for client with multipel addresses")
    public void iVerifyAlternateAddressesForClientWithMultipelAddresses() {
        $(By.xpath("//td[@class='MuiTableCell-root MuiTableCell-body'][2]")).shouldBe(visible, Duration.ofMinutes(1));
    }

    @Then("I verify membership popup for guest user")
    public void iVerifyMembershipPopupForGuestUser() {
        $(By.xpath("//*[text()='Join the RH Members Program for $175.00, and save ']")).shouldBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='Your RH Membership immediately pays for itself.']")).shouldBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='BECOME A MEMBER NOW']")).shouldBe(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='NO, THANKS']")).shouldBe(visible, Duration.ofMinutes(1));

    }
}