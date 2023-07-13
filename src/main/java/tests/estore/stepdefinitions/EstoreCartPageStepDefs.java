package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.ls.LSOutput;
import tests.concierge.pageObject.SaleScreen;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.*;
import tests.utility.Hooks;

import java.io.IOException;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.netty.handler.codec.rtsp.RtspHeaders.Values.URL;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;

public class EstoreCartPageStepDefs {
    EstoreE2EStepDefs estoreE2EStepDefs = new EstoreE2EStepDefs();
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstoreCartPage estoreCartPage = new EstoreCartPage();
    EstoreCheckoutAddressScreen estoreCheckoutAddressScreen = new EstoreCheckoutAddressScreen();
    EstoreGeneralStepDefs estoreGeneralStepDefs = new EstoreGeneralStepDefs();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    EstoreItemPage estoreItemPage = new EstoreItemPage();
    EstoreAddressScreen estoreAddressScreen = new EstoreAddressScreen();
    SaleScreen saleScreen = new SaleScreen();
    EstorePaymentPage estorePaymentPage = new EstorePaymentPage();
    EstorePDPScreen estorePDPScreen = new EstorePDPScreen();

    private static Response response;
    int itemQuantity;
    int lineItemPrice;

    @When("I remove all items from estore cart")
    public void iRemoveAllItemsFromEstoreCart() {
        generalStepDefs.waitForJSandJQueryToLoad();
        if (Hooks.cookie.contains("userservice")) {

            int countOfCartItems = 0;

            if (estoreUserAccountPage.getCartButtonUserService().isDisplayed()) {
                Actions actions = new Actions(WebDriverRunner.getWebDriver());
                actions.moveToElement(estoreUserAccountPage.getCartButtonUserService()).build().perform();

                String countOfProducts = estoreUserAccountPage.getCartButtonUserService().getText();
                countOfCartItems = Integer.valueOf(countOfProducts);
            } else {
                System.out.println("Cart is empty");
            }

            if (countOfCartItems > 0) {
                estoreGeneralStepDefs.removeFromCart(countOfCartItems);
            } else {
                System.out.println("Cart is empty");
            }

        } else {
            estoreUserAccountPage.getCartButton().should(visible, Duration.ofMinutes(4));

            int countOfCartItems = 0;

            try {
                String countOfProducts = estoreUserAccountPage.getCartButton().getText();
                countOfCartItems = Integer.valueOf(countOfProducts);
            } catch (Exception e) {
                System.out.println("Cart is empty");
            }
            if (countOfCartItems > 0) {
                estoreGeneralStepDefs.removeFromCart(countOfCartItems);
            }
        }

        if (Hooks.profile.contains("stg4")) {
            estoreUserAccountPage.getCartButtonStg4().should(visible, Duration.ofMinutes(3));

            int countOfCartItems = 0;

            try {
                String countOfProducts = estoreUserAccountPage.getCartButtonStg4().getText();
                countOfCartItems = Integer.valueOf(countOfProducts);
            } catch (Exception e) {
                System.out.println("Cart is empty");
            }

            if (countOfCartItems > 0) {
                estoreGeneralStepDefs.removeFromCart(countOfCartItems);
            }
        }
    }

    @When("I click on view cart estore button")
    public void iClickOnViewCartButton() {

        generalStepDefs.waitForJSandJQueryToLoad();
        estoreItemPage.getViewCartButton().shouldHave(text("View Cart"), Duration.ofSeconds(80));
        estoreItemPage.getViewCartButton().should(visible, Duration.ofSeconds(60));
        estoreCartPage.getKeepShopping().should(visible, Duration.ofSeconds(15));
        estoreItemPage.getViewCartButton().click();
    }

    @When("I choose estore order classification")
    public void iChooseOrderClassification() {
        generalStepDefs.waitForJSandJQueryToLoad();
        Select selectOrder = new Select(estoreCartPage.getOrderClassificationSelect());
        estoreCartPage.getOrderClassificationSelect().selectOptionContainingText("Select an Option");
        estoreCartPage.getOrderClassificationSelect().shouldHave(text("Select an Option"), Duration.ofSeconds(5));

        for (int i = 0; i < 10; i++) {
            selectOrder.selectByValue("RH Gallery Order");
            estoreCartPage.getOrderClassificationSelect().shouldHave(value("RH Gallery Order"), Duration.ofSeconds(5));
        }
        generalStepDefs.waitForJSandJQueryToLoad();
    }

    @When("I click on remove button from estore cart page")
    public void iClickOnRemoveButtonFromEstoreCartPage() {
        estoreCartPage.getRemoveButton().should(visible, Duration.ofSeconds(15));
        estoreCartPage.getRemoveButton().click();
    }

    @Then("I verify that item from estore cart has been removed")
    public void iVerifyThatItemFromEstoreCartHasBeenRemoved() {
        $(By.xpath("//*[text()='1930S MARTINI ROUND SIDE TABLE']")).shouldNotBe(visible, Duration.ofSeconds(15));
    }

    @When("I apply employee discount for estore")
    public void iApplyEmployeeDiscountForEstore() {
//        sleep(3000);
//        $(By.xpath("//*[text()='RH Employee Discount']")).scrollIntoView(true);
//        estoreCartPage.getUserNameEmployeeDiscount().should(visible, Duration.ofSeconds(40));
//        estoreCartPage.getUserNameEmployeeDiscount().click();
//        estoreCartPage.getUserNameEmployeeDiscount().setValue("ediscount");
//        estoreCartPage.getPasswordEmployeeDiscount().should(visible, Duration.ofSeconds(40));
//        estoreCartPage.getPasswordEmployeeDiscount().click();
//        estoreCartPage.getPasswordEmployeeDiscount().setValue("p6K6K6Mx");
//        estoreCartPage.getApplyEmpDiscountBtn().should(visible, Duration.ofSeconds(15));
//        estoreCartPage.getApplyEmpDiscountBtn().click();
//        estoreCartPage.getTotalAditionalProdDiscount().should(visible, Duration.ofSeconds(40));
    }

    @And("I remove promotion from estore cart")
    public void iRemovePromotionFromCart() {
        try {
            estoreCartPage.getRemovePromotionBtn().should(visible, Duration.ofSeconds(15));
            estoreCartPage.getRemovePromotionBtn().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Promotion code was not applied");
        }

    }

    @Then("I verify that I'm able to remove estore employee discount")
    public void iVerifyThatIMAbleToRemoveEstoreEmployeeDiscount() {
//        estoreCartPage.getRemoveButton().should(visible, Duration.ofSeconds(40));
//
//        estoreCartPage.getRemoveButton().click();
//
//        estoreCartPage.getTotalAditionalProdDiscount().shouldNotBe(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that I'm able to apply promotion code")
    public void iVerifyThatIMAbleToApplyPromotionCode() {
        estoreCartPage.getPromotionCodeField().should(visible, Duration.ofSeconds(40));
        estoreCartPage.getPromotionCodeField().setValue("HM4TS96");
        estoreCartPage.getApplyPromocodeBtn().should(visible, Duration.ofSeconds(40));
        estoreCartPage.getApplyPromocodeBtn().click();
    }

    @When("I click on zipcode estore button")
    public void iClickOnZipcodeEstoreButton() {

        estoreAddressScreen.getEnterZipCodeBtn().scrollIntoView(true);
        estoreAddressScreen.getEnterZipCodeBtn().should(visible, Duration.ofSeconds(40));
        estoreAddressScreen.getEnterZipCodeBtn().click();

        try {

            executeJavaScript("arguments[0].click();", estoreAddressScreen.getEnterZipCodeBtn());
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Enter zipcode button is not displayed");
        }
    }

    @Then("I verify US zip code validation in estore cart")
    public void iVerifyZipCodeValidationInEstoreCart() {
//        sleep(2000);
//        estoreCartPage.getZipCodeField().should(visible, Duration.ofSeconds(40));
//        estoreCartPage.getZipCodeField().clear();
//        estoreCartPage.getZipCodeField().click();
//        estoreCartPage.getZipCodeField().sendKeys("54106");
//        sleep(2000);
//        estoreAddressScreen.getSubmitZipCode().click();
//
//        clickOkZipCodeButton();
//        $(By.xpath("//*[text()='Enter ZIP Code']")).shouldNotBe(visible, Duration.ofSeconds(20));
    }

    @And("I verify CA zip code validation in estore cart")
    public void iVerifyCAZipCodeValidationInEstoreCart() {
//        $(By.xpath("//*[text()='54106']")).should(visible, Duration.ofSeconds(40));
//        $(By.xpath("//*[text()='54106']")).click();
//        sleep(3000);
//        estoreCartPage.getZipCodeField().clear();
//        estoreCartPage.getZipCodeField().setValue("A1A1A1");
//        sleep(3000);
//        estoreAddressScreen.getSubmitZipCode().click();
//    }
//
//    public void clickOkZipCodeButton() {
//        try {
//            estoreAddressScreen.getOkButton().should(visible, Duration.ofSeconds(40));
//            estoreAddressScreen.getOkButton().click();
//        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
//            System.out.println("Ok button is not displayed");
//        }
    }

    @Then("I verify membership price in banner")
    public void iVerifyMembershipPriceInBanner() {
        estoreCartPage.getJoinRhMemberProgramTitle().should(visible, Duration.ofSeconds(40));
        estoreCartPage.getMemberLabel().should(visible, Duration.ofSeconds(40));
        estoreCartPage.getMemberPrice().should(visible, Duration.ofSeconds(40));
    }

    @When("I choose qty for item from estore cart")
    public void iChooseQtyForItemFromCart() {

        Select qtySelect = new Select(estoreCartPage.getQuantitySelect());
        estoreCartPage.getQuantitySelect().should(visible, Duration.ofSeconds(40));
        itemQuantity = 2;
        qtySelect.selectByValue(String.valueOf(itemQuantity));
    }

    @Then("I verify that estore line item price should be update according to user selected qty")
    public void iVerifyThatLineItemPriceShouldBeUpdateAccrodingToUserSelectedQty() {
        estoreCartPage.getRegularItemPrice().should(visible, Duration.ofSeconds(20));
        String itemPrice = estoreCartPage.getRegularItemPrice().getText().replace("$", "").replace(".00", "");
        lineItemPrice = Integer.parseInt(itemPrice) * itemQuantity;
        estoreCartPage.getTotalLineItemPrice().shouldHave(text(String.valueOf(lineItemPrice)), Duration.ofSeconds(40));
    }

    @And("I verify that subtotal should be updated according to quantity selected")
    public void iVerifyThatSubtotalShouldBeUpdatedAccordingToQuantitySelected() {
        $(By.xpath("(//*[text()='" + "$" + lineItemPrice + ".00" + "'])[2]")).should(Condition.and("", visible, enabled, interactable), Duration.ofSeconds(50));
    }

    @When("I click on continue as guest estore button")
    public void iClickOnContinueAsGuestEstoreButton() {
        estoreCheckoutAddressScreen.getContinueAsGuestButton().should(visible, Duration.ofSeconds(40));
        estoreCheckoutAddressScreen.getContinueAsGuestButton().should(interactable, Duration.ofSeconds(40));
        estoreCheckoutAddressScreen.getContinueAsGuestButton().click();
    }

    @When("I update postal code in cart")
    public void iUpdatePostalCodeInCart() {

        estoreCartPage.getZipCodeField().scrollIntoView(true);
        estoreCartPage.getZipCodeField().should(visible, Duration.ofSeconds(40));
        estoreCartPage.getZipCodeField().clear();
        estoreCartPage.getZipCodeField().click();
        estoreCartPage.getZipCodeField().sendKeys("10007");

        estoreAddressScreen.getSubmitZipCode().should(visible, Duration.ofSeconds(20));
        estoreAddressScreen.getSubmitZipCode().click();
    }

    @Then("I verify UFD in cart")
    public void iVerifyUFDInCart() {
        $(By.xpath("//*[text()='Unlimited Furniture Delivery']")).should(visible, Duration.ofSeconds(15));
    }

    @Then("I verify SURCHARGE fee on cart page")
    public void iVerifySURCHARGEFeeOnCartPage() {
        $(By.xpath("//*[text()='ADDITIONAL SHIPPING SURCHARGE']")).should(interactable, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='ADDITIONAL SHIPPING SURCHARGE']")).should(visible, Duration.ofSeconds(40));
    }

    @When("I click on gift box estore button")
    public void iClickOnRemoveGiftBoxButton() {
        generalStepDefs.waitForJSandJQueryToLoad();

        estoreItemPage.getAddGiftCheckBox().click();
    }

    @Then("I verify gift box fee in estore cart")
    public void iVerifyGiftBoxFeeInEstoreCart() {
        estoreCartPage.getViewGiftBoxBtn().should(visible, Duration.ofSeconds(15));
        estoreCartPage.getViewGiftBoxBtn().click();
        $(By.xpath("//*[contains(text(),'When gift boxed, your item will arrive ')]")).should(visible, Duration.ofSeconds(40));
        estoreCartPage.getPopupCloseButton().click();
        $(By.xpath("//*[text()='Gift Box Fee']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='$5.95']")).should(visible, Duration.ofSeconds(40));
    }

    @When("I click on join the rh members program from footer")
    public void iClickOnJoinTheRhMembersProgramFromFooter() {
        estoreCartPage.getRhMemberFooterLink().shouldHave(text("RH MEMBERS PROGRAM"), Duration.ofSeconds(20));
        estoreCartPage.getRhMemberFooterLink().click();
    }

    @When("I click on join now membership button")
    public void iClickOnJoinNowMembershipButton() {
        estoreCartPage.getJoinNow().should(visible, Duration.ofSeconds(10));
        estoreCartPage.getJoinNow().should(interactable, Duration.ofSeconds(10));
        estoreCartPage.getJoinNow().shouldHave(text("JOIN NOW"), Duration.ofSeconds(10));
        estoreCartPage.getJoinNow().click();
    }

    @Then("I verify order estimate section in cart")
    public void iVerifyOrderEstimateSectionInCart() {
        $(By.xpath("//*[text()='Subtotal with Member Savings']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='RH Members Program']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='RH Member Savings on this order']")).should(visible, Duration.ofSeconds(40));
    }

    @When("I update {string} postal code in cart")
    public void iUpdatePostalCodeInCart(String arg0) {
        estoreCartPage.getZipCodeField().should(visible, Duration.ofSeconds(40));
        estoreCartPage.getZipCodeField().clear();
        if (arg0.equals("US")) {
            estoreCartPage.getZipCodeField().setValue("10007");
        }
        if (arg0.equals("CA")) {
            estoreCartPage.getZipCodeField().setValue("A1A1A1");
        }
        estoreAddressScreen.getSubmitZipCode().click();
    }

    @When("I click on {string} postal code in cart")
    public void iClickOnPostalCodeInCart(String arg0) {
        if (arg0.equals("US")) {
            $(By.xpath("//*[text()='10007']")).should(visible, Duration.ofSeconds(40));
            $(By.xpath("//*[text()='10007']")).click();
        }
    }

    @Then("I verify {string} shipping restriction")
    public void iVerifyShippingRestriction(String arg0) {
        if (arg0.equals("NY")) {
            $(By.xpath("//*[text()='cannot be shipped to the state of']")).should(interactable, Duration.ofSeconds(20));
            $(By.xpath("//*[text()='cannot be shipped to the state of']")).should(visible, Duration.ofSeconds(20));
            $(By.xpath("//*[contains(text(),'New York')]")).should(visible, Duration.ofSeconds(20));
        }
        if (arg0.equals("CAN")) {

        }
    }

    @Then("I verify that continue as guest user option is not available")
    public void iVerifyThatContinueAsGuestUserOptionIsNotAvailable() {
        estoreCheckoutAddressScreen.getContinueAsGuestButton().shouldNotBe(visible, Duration.ofSeconds(20));
    }

    @When("I click on join now on estore cart page membership button")
    public void iClickOnJoinNowOnEstoreCartPageMembershipButton() {
        estoreCartPage.getVariableJoinButtonByName("JOIN NOW").should(visible, Duration.ofSeconds(20));
        estoreCartPage.getVariableJoinButtonByName("JOIN NOW").click();
    }

    @Then("I verify membership estore banner for {string}")
    public void iVerifyMembershipEstoreBannerFor(String arg0) {
        if (arg0.equals("nonmember user")) {

            $(By.xpath("//*[text()='RH MEMBERS PROGRAM']")).should(interactable, Duration.ofSeconds(40));
            $(By.xpath("//*[text()='RH MEMBERS PROGRAM']")).should(visible, Duration.ofSeconds(40));
            $(By.xpath("//*[contains(text(),'Join the RH Members Program for')]")).should(visible, Duration.ofSeconds(40));
        }
        if (arg0.equals("member user")) {

            $(By.xpath("//*[text()='RH MEMBERS PROGRAM']")).should(visible, Duration.ofSeconds(40));
            $(By.xpath("//*[contains(text(),'Automation, ')]")).should(visible, Duration.ofSeconds(30));
        }
    }

    @Then("I verify that the added product is in the cart during brand switching")
    public void iVerifyThatTheAddedProductIsInTheCartDuringBrandSwitching() {
        estoreUserAccountPage.getBrandButton().should(visible, Duration.ofSeconds(20));
        estoreUserAccountPage.getBrandButton().click();
        for (int i = 1; i < 3; i++) {
            if (i > 1) {
                estoreUserAccountPage.getBrandButton().click();
            }


            estoreUserAccountPage.getListOfBrands().get(i).should(visible, Duration.ofSeconds(20));
            String brandUrl = estoreUserAccountPage.getListOfBrands().get(i).getText().replaceAll(" ", "").toLowerCase();
            String estoreUrlNoHttps = Hooks.eStoreURL.replaceAll("https://", "");
            estoreUserAccountPage.getListOfBrands().get(i).click();
            iStopEStorePageLoad();
            open("https://" + brandUrl + "." + estoreUrlNoHttps);
            estoreUserAccountPage.getCartButton().shouldHave(text("1"), Duration.ofSeconds(80));
        }
    }

    @Then("I verify that I'm able to add products from all brands to cart")
    public void iVerifyThatIMAbleToAddProductsFromAllBrandsToCart() {

        WebDriverRunner.getWebDriver().navigate().refresh();

        estoreUserAccountPage.getBrandButton().should(visible, Duration.ofSeconds(40));
        estoreUserAccountPage.getBrandButton().click();
    }

    @When("I click on estore order details button")
    public void iClickOnOrderDetailsButton() {
        estoreUserAccountPage.getOrderDetailsButton().should(visible, Duration.ofSeconds(15));
        estoreUserAccountPage.getOrderDetailsButton().click();
    }

    @When("I click on estore cart button from header")
    public void iClickOnEstoreCartButtonFromHeader() {

        estoreCartPage.getCartButtonOrderReview().should(visible, Duration.ofSeconds(40));
        executeJavaScript("arguments[0].click();", estoreCartPage.getCartButtonOrderReview());
    }

    @When("I update item quantity in estore cart")
    public void iUpdateItemQuantityInEstoreCart() {
    }

    @Then("I verify that I'm able to increase item quantity with success after payment")
    public void iVerifyThatItemQuantityWasIncreasedWithSuccess() {

        estoreItemPage.getSelectQuantityCartPage().should(visible, Duration.ofSeconds(40));
        estoreItemPage.getSelectQuantityCartPage().scrollIntoView(true);
        Select selectQuantity = new Select(estoreItemPage.getSelectQuantityCartPage());
        selectQuantity.selectByValue("2");

    }

    @Then("I verify that I'm able to decrease item quantity with success")
    public void iVerifyThatIMAbleToDecreaseItemQuantityWithSuccess() {
        estoreCartPage.getQuantitySelect().should(visible, Duration.ofSeconds(40));
        Select selectQuantity = new Select(estoreCartPage.getQuantitySelect());
        selectQuantity.selectByValue("1");
    }

    @When("I click on add to wishlist button from cart")
    public void iClickOnAddToWishlistButtonFromCart() {

        estoreCartPage.getAddToWishlistButton().should(visible, Duration.ofSeconds(40));
        estoreCartPage.getAddToWishlistButton().click();
    }

    @Then("I verify that contract price is used in cart")
    public void iVerifyThatContractPriceIsUsedInCart() {
        estoreUserAccountPage.getContractText().should(visible, Duration.ofSeconds(40));
    }

    @Then("I verify that trade price is used in cart")
    public void iVerifyThatTradePriceIsUsedInCart() {
        estoreUserAccountPage.getTradeText().should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='35']")).should(visible, Duration.ofSeconds(40));
    }


    @Then("I verify that the price get increased in multiple of QTY")
    public void iVerifyThatThePriceGetIncreasedInMultipleOfQTY() {
        $(By.xpath("//*[text()='$70.00']")).should(visible, Duration.ofSeconds(40));
    }

    @Then("I verify that price for product&line should be in US dollars")
    public void iVerifyThatPriceForProductLineShouldBeInUS$() {
        $(By.xpath("//*[contains(text(),'$')]")).should(visible, Duration.ofSeconds(40));
    }


    @When("I introduces CAN zip code for estore cart")
    public void iIntroducesCANZipCodeForEstoreCart() {

        $(By.xpath("//div[@id='component-order-summary']//p//span")).scrollIntoView(true);
        $(By.xpath("//div[@id='component-order-summary']//p//span")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//div[@id='component-order-summary']//p//span")).click();
        $(By.xpath("//div[@id='country-zipcode-selection']")).should(visible, Duration.ofSeconds(20)).click();
        $(By.xpath("//li[@data-value='CA']")).should(visible, Duration.ofSeconds(20)).click();
        $(By.xpath("//input[@id='postal-code-international']")).clear();
        $(By.xpath("//input[@id='postal-code-international']")).setValue("M4J 3S3");
    }

    @Then("I verify that the price for trade get increased in multiple of QTY")
    public void iVerifyThatThePriceForTradeGetIncreasedInMultipleOfQTY() {

        $(By.xpath("//*[contains(text(),'70.00')]")).should(visible, Duration.ofSeconds(40));
    }

    @Then("I verify that trade price is used for each product")
    public void iVerifyThatTradePriceIsUsedForEachProduct() {
        $(By.xpath("//*[text()='Trade']")).should(visible, Duration.ofSeconds(30));
    }

    @When("I open estore cart")
    public void iOpenCart() {
        String URL = Hooks.eStoreBaseURL + "/us/en/checkout/shopping_cart.jsp";
        open(URL);

        WebDriverRunner.getWebDriver().navigate().refresh();
    }


    @When("I add item to estore cart")
    public void iAddItemToCartViaAPI() {
        RestAssured.baseURI = "https://development.internal.rhapsodynonprod.com";
        RequestSpecification request = RestAssured.given();
        request.headers("Content-Type", "application/json");
        request.headers("Cookie", "PF_AEM_PATHS=%5E%2F(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~IN%7C~IN)%7C(%3F%3Aalison-berger(%3F%3A%2F(%3F%3Aaperture%7C(%3F%3A(%3F%3Afulcrum%7Cpearl%7Crain)%7Cice))~R%7C~R)%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)R)H%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)OD%7C(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)IN%7C(%3F%3A(%3F%3A(%3F%3A(%3F%3Atuuci%2F(%3F%3Aoceanmastermax%7Cbaymaster)~%7Ctuuci(%3F%3A%2Foceanmaster)%3F~)%7Ctuuci%2Fall~)%7Cheatsail~)%7Cgift-registry~)MO%7Cinterior-design~BC%7Cgift-registry~RH%7Cstrada-ledoux~MO)%24; endpoint=develop; fusion_search=true; ui_asset_path=/concierge-ui-v1/");

        response = request.body("\"quantity\":1,\n" +
                "        \"brand\":\"RH\",\n" +
                "        \"sku\":\"17050042 WHT\"").post("/carts/R85882693/items");

        String jsonString = response.asString();
        System.out.println(jsonString);
        String id = JsonPath.from(jsonString).get("id");
    }


    @Then("I verify that gift card balance info is displayed for estore")
    public void iVerifyThatGiftCardBalanceInfoIsDisplayed() {
        estoreCartPage.getRhGiftCardBalance().shouldHave(text("RH Gift Card ending 2229 has balance of "), Duration.ofSeconds(25));
    }

    @Then("I verify that estore order estimate is not displayed")
    public void iVerifyThatEstoreLineItemWasRemoved() {
        $(By.xpath("//*[text()='ORDER ESTIMATE']")).shouldNotBe(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that regular price is displayed for estore cart")
    public void iVerifyThatRegularPriceIsDisplayedForEstoreCart() {
        saleScreen.getRegularPrice().should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that {string} prices for {string} was applied")
    public void iVerifyThatMemberPricesForWasApplied(String priceType, String skuId) {
        if (skuId.equals("17050042WHT") && (priceType.equals("member"))) {
            $(By.xpath("  //*[text()='$35.00']")).should(visible, Duration.ofSeconds(20));
        }
        if (skuId.equals("17050042WHT") && (priceType.equals("regular"))) {
            $(By.xpath("  //*[text()='$47.00']")).should(visible, Duration.ofSeconds(20));
        }
    }

    @When("I click on remove membership estore button")
    public void iClickOnRemoveMembershipEstoreButton() {
        with().pollInterval(2, SECONDS).await().until(() -> true);
        if (estoreCartPage.getRemoveMembershipButton().isDisplayed()) {
            try {
                estoreCartPage.getRemoveMembershipButton().scrollIntoView(true);
                estoreCartPage.getRemoveMembershipButton().should(visible, Duration.ofSeconds(20));
                estoreCartPage.getRemoveMembershipButton().click();
                estoreCartPage.getJoinNow().should(visible, Duration.ofSeconds(15));
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                System.out.println("Remove membership button is not displayed");
            }
        }
    }


    @Then("I verify state field empty dropdown issue for International billing address")
    public void iVerifyStateFieldEmptyDropdownIssueForInternationalBillingAddress() {

        $(By.xpath("//*[text()='State required.']")).should(visible, Duration.ofSeconds(30));
    }

    @When("I choose estore empty state")
    public void iChooseEstoreEmptyState() {
        estoreAddressScreen.getShippingAddressState().scrollIntoView(true);

        Select selectState = new Select(estoreAddressScreen.getShippingAddressState());
        selectState.selectByValue("");


    }

    @Then("I verify estore order total in order estimate for membership for {string}")
    public void iVerifyEstoreOrderTotalInOrderEstimateForMembershipFor(String arg0) {
        $(By.xpath("//*[text()='Subtotal with Member Savings']")).should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify the standard delivery charges for estore")
    public void iVerifyTheStandardDeliveryChargesForEstore() {
        $(By.xpath("//*[text()='Standard Delivery Shipping']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Standard Delivery Shipping']")).click();
        $(By.xpath("//*[text()='Standard Shipping']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Standard Shipping']")).click();
        $(By.xpath("//*[text()='U.S. Standard Shipping']")).should(visible, Duration.ofSeconds(20));

    }

    @When("I add item to cart via API for estore")
    public void iAddItemToCartViaAPIforEstore() {
        if (Hooks.profile.equals("stg4")) {
            estoreGeneralStepDefs.addLineItemsToEstoreCart();
        } else if (Hooks.profile.equals("stg3")) {
            estoreGeneralStepDefs.addLineItemsToEstoreCartStg3();
        } else {
            estoreGeneralStepDefs.addLineItemsToEstoreCartStg2();
        }

        WebDriverRunner.getWebDriver().navigate().refresh();
    }

    @When("I goes to estore cart for estore")
    public void iGoesToEstoreCartForEstore() {
        if ((Hooks.cookie.contains("userservice")) && (Hooks.profile.equals("stg2"))) {
            open(Hooks.eStoreBaseURL + "/us/en/checkout/shopping_cart.jsp");
        }

        if (Hooks.profile.equals("stg3")) {
            $(By.xpath("//a[@href='/us/en/checkout/shopping_cart.jsp']")).should(visible, Duration.ofSeconds(20));
            $(By.xpath("//a[@href='/us/en/checkout/shopping_cart.jsp']")).click();
        }
        if (!(Hooks.cookie.contains("userservice")) && (Hooks.profile.equals("stg2"))) {
            open(Hooks.eStoreBaseURL + "/us/en/checkout/shopping_cart.jsp");
//            estoreCartPage.getEstoreCartButton().should(visible, Duration.ofSeconds(40));
//            estoreCartPage.getEstoreCartButton().click();
        }
    }

    @When("I add item {string} to cart via API for estore")
    public void iAddItemToCartViaAPIForEstore(String arg0) {

    }

    @When("I add item {string}  and prod id {string} to cart via API for estore")
    public void iAddItemAndProdIdToCartViaAPIForEstore(String arg0, String arg1) throws IOException {
        if (Hooks.profile.contains("stg4")) {
            estoreGeneralStepDefs.addLineItemsToEstoreCartWithProvidedSkuStg4(arg0, arg1);
        } else if (Hooks.profile.contains("stg2")) {
            estoreGeneralStepDefs.addLineItemsToEstoreCartWithProvidedSkuStg2(arg0, arg1);
        }
    }

    @When("I add product {string} and sku {string} to cart via API for estore")
    public void iAddProductAndSkuToCartViaAPIForEstore(String product, String sku) throws IOException {
        if (Hooks.profile.contains("stg4")) {
            estoreGeneralStepDefs.addLineItemsToEstoreCartWithProvidedSkuStg4(product, sku);
        } else if (Hooks.profile.contains("stg2")) {
            estoreGeneralStepDefs.addLineItemsToEstoreCartWithProvidedSkuStg2(product, sku);
        }
    }


    @When("I verify for back button from cart page")
    public void iVerifyForBackButtonFromCartPage() {

        WebDriverRunner.getWebDriver().navigate().back();
        estoreUserAccountPage.getRhEstoreLogo().should(visible, Duration.ofSeconds(20));
    }

    @And("I introduces payment details for estore guest user for cart")
    public void iIntroducesPaymentDetailsForEstoreGuestUserForCart() {
        if (!estorePaymentPage.getChoosePaymentMethodBtn().isDisplayed()) {
            WebDriverRunner.getWebDriver().navigate().refresh();

        }

        estorePaymentPage.getChoosePaymentMethodBtn().shouldHave(text("Credit Card"), Duration.ofSeconds(20));
        Select selectPayment = new Select(estorePaymentPage.getChoosePaymentMethodBtn());
        selectPayment.selectByIndex(1);

        switchTo().frame($(By.cssSelector("iframe[title='Iframe for secured card number']")).should(visible, Duration.ofMinutes(1)));
        estorePaymentPage.getCardNumberField().setValue("4111111145551142");
        switchTo().defaultContent();

        switchTo().frame($(By.xpath("//div[contains(@class,'securityCode')]//iframe[@class='js-iframe']")).should(visible, Duration.ofMinutes(1)));
        estorePaymentPage.getCvcField().setValue("737");
        switchTo().defaultContent();

        switchTo().frame($(By.xpath("//div[contains(@class,'expiryDate')]//iframe[@title='Iframe for secured card expiry date']")).should(visible, Duration.ofMinutes(1)));
        estorePaymentPage.getExpiryDateField().setValue("0330");
        switchTo().defaultContent();

        $(By.xpath("//*[text()='CONTINUE']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='CONTINUE']")).click();
    }

    @And("I introduces payment details for estore guest user for payment")
    public void iIntroducesPaymentDetailsForEstoreGuestUserForPayment() {
        if (!estorePaymentPage.getChoosePaymentMethodBtn().isDisplayed()) {
            String URL = Hooks.conciergeBaseURL + "/us/en/checkout/shopping_cart.jsp";

        }

//        estorePaymentPage.getChoosePaymentMethodBtn().shouldHave(text("Visa ####-7543"), Duration.ofMinutes(2));
        Select selectPayment = new Select(estorePaymentPage.getChoosePaymentMethodBtn());
        selectPayment.selectByVisibleText("Visa ####-7543");

        switchTo().frame($(By.xpath("//iframe[@class='js-iframe']")).should(visible, Duration.ofMinutes(1)));
        estorePaymentPage.getCvcField().setValue("737");
        switchTo().defaultContent();

        $(By.xpath("//*[text()='CONTINUE']")).should(visible, Duration.ofMinutes(1));
        $(By.xpath("//*[text()='CONTINUE']")).click();
    }

    @When("I open product page with NY restriction item")
    public void iOpenProductPageWithNYRestrictionItem() {
        String productId = "rhbc_prod961678";
        String skuId = "112685";
        String url = null;
        if (Hooks.profile.equals("stg2")) {
            url = Hooks.eStoreBaseURL + "/catalog/product/product.jsp?productId=" + productId + "&fullSkuId=" + skuId + "+" + "AGPT" + "&categoryId=search";
        }
        open(url);


        if (estoreItemPage.getAddToCartDisabledButton().isDisplayed()) {
            Select finishList = new Select(estoreItemPage.getSelectFinish());
            finishList.selectByVisibleText("Antiqued Brass");
            Select fabricList = new Select(estoreItemPage.getSelectFabric());
            fabricList.selectByVisibleText("Perennials Performance Textured Linen Weave");
            Select quantityList = new Select(estoreItemPage.getSelectQTY());
            quantityList.selectByVisibleText("1");
            Select colorList = new Select(estoreItemPage.getSelectColor());
            colorList.selectByVisibleText("White");
        } else {
            System.out.println("Everything is ok");
        }
    }

    @When("I choose {string} country from footer")
    public void iChooseCANCountryFromFooter(String country) {
        $(By.xpath("//div[@id='country-selection']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//div[@id='country-selection']")).scrollIntoView(true);
        $(By.xpath("//div[@id='country-selection']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//div[@id='country-selection']")).click();
        if (country.equals("CAN")) {
            $(By.xpath("//li[@data-value='CA']")).should(visible, Duration.ofSeconds(20));
            $(By.xpath("//li[@data-value='CA']")).click();
        }
        if (country.equals("US")) {
            $(By.xpath("//li[@data-value='US']")).should(visible, Duration.ofSeconds(20));
            $(By.xpath("//li[@data-value='US']")).click();
        }
        $(By.xpath("//*[text()='Checkout']")).shouldHave(text("Checkout"), Duration.ofSeconds(30));
    }

    @When("I stop eStore page load")
    public void iStopEStorePageLoad() {
        executeJavaScript("window.stop();");
    }

    @Then("that was added {string} quantity of item in cart")
    public void thatWasAddedQuantityOfItemInCart(String quantity) {
        if (quantity.equals("2")) {
            $(By.xpath("//*[contains(@id,'quantity') and contains(@id,'_2')]")).should(visible, Duration.ofSeconds(20));
        }
    }

    @And("I verify that total price is correct for {string} and {string} with {string} for estore")
    public void iVerifyThatTotalPriceIsCorrectForAndWithForEstore(String prodId, String skuID, String skuOptions) {
        $(By.xpath("(//*[text()='$94.00'])[3]")).should(visible, Duration.ofSeconds(20));
    }

    @When("I change item quantity to {string} for {string} and {string} with {string} for estore")
    public void iChangeItemQuantityToForAndWithForEstore(String arg0, String arg1, String arg2, String arg3) {
        estoreCartPage.getQuantitySelect().should(visible, Duration.ofSeconds(20));
        estoreCartPage.getQuantitySelect().click();

        if (arg0.equals("1")) {
            $(By.xpath("//option[@value='1']")).should(visible, Duration.ofSeconds(20)).click();
        }
    }

    @Then("I verify that shopping cart is empty for estore")
    public void iVerifyThatLineItemWasRemovedForEstore() {
        $(By.xpath("//*[text()='YOUR SHOPPING CART IS EMPTY']")).should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that item was added to cart for estore")
    public void iVerifyThatItemWasAddedToCartForEstore() {
        $(By.xpath("//*[text()='802-GRAM TURKISH TOWEL COLLECTION']")).
                should(visible, Duration.ofSeconds(30));
    }

    @Then("I verify that add to cart button is active")
    public void iVerifyThatAddToCartButtonIsActive() {
        estorePDPScreen.getAddToCartInactiveButton().shouldNotBe(visible, Duration.ofSeconds(30));
    }

    @And("I verify that add to cart button is inactive")
    public void iVerifyThatAddToCartButtonIsInactive() {
        estorePDPScreen.getAddToCartInactiveButton().shouldBe(visible, Duration.ofSeconds(30));
    }
}