package tests.estore.stepdefinitions;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.concierge.pageObject.SaleScreen;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.*;
import tests.utility.Hooks;

import java.io.IOException;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.netty.handler.codec.rtsp.RtspHeaders.Values.URL;

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

    private static Response response;
    int itemQuantity;
    int lineItemPrice;

    @When("I remove all items from estore cart")
    public void iRemoveAllItemsFromEstoreCart() {
        generalStepDefs.waitForJSandJQueryToLoad();
        if (Hooks.profile.contains("stg4")) {
            estoreUserAccountPage.getCartButtonStg4().should(visible, Duration.ofMinutes(3));
            sleep(3000);
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


        if (Hooks.profile.contains("stg2")) {
            estoreUserAccountPage.getCartButton().should(visible, Duration.ofMinutes(3));
            sleep(3000);
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
    }

    @When("I click on view cart estore button")
    public void iClickOnViewCartButton() {
        sleep(5000);
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
        sleep(7000);
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
//        sleep(2000);
//        estoreCartPage.getRemoveButton().click();
//        sleep(2000);
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
        sleep(5000);
        estoreAddressScreen.getEnterZipCodeBtn().scrollIntoView(true);
        estoreAddressScreen.getEnterZipCodeBtn().should(visible, Duration.ofSeconds(40));
        estoreAddressScreen.getEnterZipCodeBtn().click();

        try {
            sleep(2000);
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
        sleep(7000);
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
        $(By.xpath("(//*[text()='" + "$" + lineItemPrice + ".00" + "'])[2]")).should(visible, Duration.ofSeconds(40));
    }

    @When("I click on continue as guest estore button")
    public void iClickOnContinueAsGuestEstoreButton() {
        estoreCheckoutAddressScreen.getContinueAsGuestButton().should(visible, Duration.ofSeconds(40));
        estoreCheckoutAddressScreen.getContinueAsGuestButton().click();
    }

    @When("I update postal code in cart")
    public void iUpdatePostalCodeInCart() {
        sleep(4000);
        estoreCartPage.getZipCodeField().scrollIntoView(true);
        estoreCartPage.getZipCodeField().should(visible, Duration.ofSeconds(40));
        estoreCartPage.getZipCodeField().clear();
        estoreCartPage.getZipCodeField().click();
        estoreCartPage.getZipCodeField().sendKeys("10007");
        sleep(5000);
        estoreAddressScreen.getSubmitZipCode().should(visible, Duration.ofSeconds(20));
        estoreAddressScreen.getSubmitZipCode().click();
    }

    @Then("I verify UFD in cart")
    public void iVerifyUFDInCart() {
        $(By.xpath("//*[text()='Unlimited Furniture Delivery']")).should(visible, Duration.ofSeconds(15));
    }

    @Then("I verify SURCHARGE fee on cart page")
    public void iVerifySURCHARGEFeeOnCartPage() {
        $(By.xpath("//*[text()='ADDITIONAL SHIPPING SURCHARGE']")).should(visible, Duration.ofSeconds(40));
    }

    @When("I click on gift box estore button")
    public void iClickOnRemoveGiftBoxButton() {
        generalStepDefs.waitForJSandJQueryToLoad();
        sleep(5000);
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
        estoreCartPage.getJoinNowCartEstoreButton().shouldHave(text("JOIN NOW"), Duration.ofSeconds(20));
        estoreCartPage.getJoinNowCartEstoreButton().click();
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
        estoreCartPage.getJoinNowCartEstoreButton().shouldHave(text("JOIN NOW"), Duration.ofSeconds(20));
        estoreCartPage.getJoinNowCartEstoreButton().click();
    }

    @Then("I verify membership estore banner for {string}")
    public void iVerifyMembershipEstoreBannerFor(String arg0) {
        if (arg0.equals("nonmember user")) {
            sleep(3000);
            $(By.xpath("//*[text()='RH MEMBERS PROGRAM']")).should(visible, Duration.ofSeconds(40));
            estoreCartPage.getJoinNowCartEstoreButton().should(visible, Duration.ofSeconds(40));
        }
        if (arg0.equals("member user")) {
            sleep(3000);
            estoreCartPage.getJoinNowCartEstoreButton().shouldNot(visible, Duration.ofSeconds(20));
        }

    }

    @Then("I verify that the added product is in the cart during brand switching")
    public void iVerifyThatTheAddedProductIsInTheCartDuringBrandSwitching() {
        estoreUserAccountPage.getBrandButton().should(visible, Duration.ofSeconds(40));
        estoreUserAccountPage.getBrandButton().click();
        for (int i = 1; i < 3; i++) {
            if (i > 1) {
                estoreUserAccountPage.getBrandButton().click();
            }
            sleep(2000);
            estoreUserAccountPage.getListOfBrands().get(i).click();
            estoreUserAccountPage.getCartButton().shouldHave(text("1"), Duration.ofSeconds(40));
        }
    }

    @Then("I verify that I'm able to add products from all brands to cart")
    public void iVerifyThatIMAbleToAddProductsFromAllBrandsToCart() {
        sleep(2000);
        WebDriverRunner.getWebDriver().navigate().refresh();
        sleep(2000);
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
        sleep(2000);
        estoreCartPage.getCartButtonOrderReview().should(visible, Duration.ofSeconds(40));
        executeJavaScript("arguments[0].click();", estoreCartPage.getCartButtonOrderReview());
    }

    @When("I update item quantity in estore cart")
    public void iUpdateItemQuantityInEstoreCart() {
    }

    @Then("I verify that I'm able to increase item quantity with success after payment")
    public void iVerifyThatItemQuantityWasIncreasedWithSuccess() {
        sleep(3000);
        estoreItemPage.getSelectQuantityCartPage().should(visible, Duration.ofSeconds(40));
        estoreItemPage.getSelectQuantityCartPage().scrollIntoView(true);
        Select selectQuantity = new Select(estoreItemPage.getSelectQuantityCartPage());
        selectQuantity.selectByValue("2");
        sleep(3000);
    }

    @Then("I verify that I'm able to decrease item quantity with success")
    public void iVerifyThatIMAbleToDecreaseItemQuantityWithSuccess() {
        estoreCartPage.getQuantitySelect().should(visible, Duration.ofSeconds(40));
        Select selectQuantity = new Select(estoreCartPage.getQuantitySelect());
        selectQuantity.selectByValue("1");
    }


    @When("I click on add to wishlist button from cart")
    public void iClickOnAddToWishlistButtonFromCart() {
        sleep(2000);
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
        sleep(3000);
        $(By.xpath("//div[@id='component-order-summary']//p//span")).scrollIntoView(true);
        $(By.xpath("//div[@id='component-order-summary']//p//span")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//div[@id='component-order-summary']//p//span")).click();
        $(By.xpath("//input[@data-testid='postalcode-dialog-input']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//input[@data-testid='postalcode-dialog-input']")).clear();
        $(By.xpath("//input[@data-testid='postalcode-dialog-input']")).setValue("A1A1A1");
    }

    @Then("I verify that the price for trade get increased in multiple of QTY")
    public void iVerifyThatThePriceForTradeGetIncreasedInMultipleOfQTY() {
        sleep(3000);
        $(By.xpath("//*[contains(text(),'102.00')]")).should(visible, Duration.ofSeconds(40));
    }

    @Then("I verify that trade price is used for each product")
    public void iVerifyThatTradePriceIsUsedForEachProduct() {
        $(By.xpath("//*[text()='Trade']")).should(visible, Duration.ofSeconds(30));
    }

    @When("I open estore cart")
    public void iOpenCart() {
        String URL = Hooks.eStoreBaseURL + "/checkout/shopping_cart.jsp";
        open(URL);
        sleep(2000);
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
        estoreCartPage.getRhGiftCardBalance().shouldHave(text("RH Gift Card ending 2500 has balance of "), Duration.ofSeconds(25));
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
        try {
            estoreCartPage.getRemoveMembershipButton().scrollIntoView(true);
            estoreCartPage.getRemoveMembershipButton().should(visible, Duration.ofSeconds(20));
            estoreCartPage.getRemoveMembershipButton().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Remove membership button is not displayed");
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
        selectState.selectByIndex(0);
        sleep(3000);
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
        sleep(2000);
        WebDriverRunner.getWebDriver().navigate().refresh();
    }

    @When("I goes to estore cart for estore")
    public void iGoesToEstoreCartForEstore() {
        sleep(2000);
        if (Hooks.profile.equals("stg3")) {
            $(By.xpath("//a[@href='/us/en/checkout/shopping_cart.jsp']")).should(visible, Duration.ofSeconds(20));
            $(By.xpath("//a[@href='/us/en/checkout/shopping_cart.jsp']")).click();
        } else {
            estoreCartPage.getEstoreCartButton().should(visible, Duration.ofSeconds(40));
            estoreCartPage.getEstoreCartButton().click();
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
        sleep(2000);
        WebDriverRunner.getWebDriver().navigate().back();
        estoreUserAccountPage.getRhEstoreLogo().should(visible, Duration.ofSeconds(20));
    }

    @And("I introduces payment details for estore guest user")
    public void iIntroducesPaymentDetailsForEstoreGuestUser() {
        estorePaymentPage.getChoosePaymentMethodBtn().shouldHave(text("RH Credit Card"), Duration.ofMinutes(2));
        Select selectPayment = new Select(estorePaymentPage.getChoosePaymentMethodBtn());
        selectPayment.selectByIndex(2);

        switchTo().frame($(By.cssSelector("iframe[title='Iframe for secured card number']")).should(visible, Duration.ofMinutes(1)));
        estorePaymentPage.getCardNumberField().setValue("4678475330157543");
        switchTo().defaultContent();

        switchTo().frame($(By.xpath("//div[contains(@class,'securityCode')]//iframe[@class='js-iframe']")).should(visible, Duration.ofMinutes(1)));
        estorePaymentPage.getCvcField().setValue("737");
        switchTo().defaultContent();

        switchTo().frame($(By.xpath("//div[contains(@class,'expiryDate')]//iframe[@title='Iframe for secured card expiry date']")).should(visible, Duration.ofMinutes(1)));
        estorePaymentPage.getExpiryDateField().setValue("0330");
        switchTo().defaultContent();

        estorePaymentPage.getContinueToCheckout().click();
    }

    @When("I open product page with NY restriction item")
    public void iOpenProductPageWithNYRestrictionItem() {
        String productId = "rhbc_prod961679";
        String skuId = "112686";
        String url = null;
        if (Hooks.profile.equals("stg2")) {
            url = Hooks.eStoreBaseURL + "/catalog/product/product.jsp?productId=" + productId + "&fullSkuId=" + skuId + "+" + "AGPT" + "&categoryId=search";
        }
        open(url);
    }
}
