package tests.estore.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class EstoreCartPageStepDefs {
    EstoreE2EStepDefs estoreE2EStepDefs = new EstoreE2EStepDefs();
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstoreCartPage estoreCartPage = new EstoreCartPage();
    EstoreCheckoutAddressScreen estoreCheckoutAddressScreen = new EstoreCheckoutAddressScreen();
    EstoreGeneralStepDefs estoreGeneralStepDefs = new EstoreGeneralStepDefs();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    EstoreItemPage estoreItemPage = new EstoreItemPage();
    EstoreAddressScreen estoreAddressScreen = new EstoreAddressScreen();
    int itemQuantity;
    int lineItemPrice;

    @When("I remove all items from estore cart")
    public void iRemoveAllItemsFromEstoreCart() {
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
            estoreUserAccountPage.getCartButton().click();
            try {
                for (int i = 0; i < countOfCartItems; i++) {
                    estoreCartPage.getRemoveButton().should(visible, Duration.ofSeconds(30));
                    estoreCartPage.getRemoveButton().click();
                    sleep(3000);
                }
                estoreUserAccountPage.getRhEstoreLogo().should(visible, Duration.ofSeconds(15));
                estoreUserAccountPage.getRhEstoreLogo().click();
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                System.out.println("Agree&add to cart button is not displayed");
                estoreUserAccountPage.getRhEstoreLogo().should(visible, Duration.ofSeconds(15));
                estoreUserAccountPage.getRhEstoreLogo().click();
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
        sleep(3000);
        $(By.xpath("//*[text()='RH Employee Discount']")).scrollIntoView(true);
        estoreCartPage.getUserNameEmployeeDiscount().should(visible, Duration.ofSeconds(40));
        estoreCartPage.getUserNameEmployeeDiscount().click();
        estoreCartPage.getUserNameEmployeeDiscount().setValue("ediscount");
        estoreCartPage.getPasswordEmployeeDiscount().should(visible, Duration.ofSeconds(40));
        estoreCartPage.getPasswordEmployeeDiscount().click();
        estoreCartPage.getPasswordEmployeeDiscount().setValue("p6K6K6Mx");
        estoreCartPage.getApplyEmpDiscountBtn().should(visible, Duration.ofSeconds(15));
        estoreCartPage.getApplyEmpDiscountBtn().click();
        estoreCartPage.getTotalAditionalProdDiscount().should(visible, Duration.ofSeconds(40));
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
        estoreCartPage.getRemoveButton().should(visible, Duration.ofSeconds(40));
        sleep(2000);
        estoreCartPage.getRemoveButton().click();
        sleep(2000);
        estoreCartPage.getTotalAditionalProdDiscount().shouldNotBe(visible, Duration.ofSeconds(20));
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
        sleep(2000);
        estoreAddressScreen.getEnterZipCodeBtn().scrollIntoView(true);
        estoreAddressScreen.getEnterZipCodeBtn().should(visible, Duration.ofSeconds(40));
        estoreAddressScreen.getEnterZipCodeBtn().click();
    }

    @Then("I verify US zip code validation in estore cart")
    public void iVerifyZipCodeValidationInEstoreCart() {
        sleep(2000);
        estoreCartPage.getZipCodeField().should(visible, Duration.ofSeconds(40));
        estoreCartPage.getZipCodeField().clear();
        estoreCartPage.getZipCodeField().click();
        estoreCartPage.getZipCodeField().sendKeys("54106");
        sleep(2000);
        estoreAddressScreen.getSubmitZipCode().click();

        clickOkZipCodeButton();
        $(By.xpath("//*[text()='Enter ZIP Code']")).shouldNotBe(visible, Duration.ofSeconds(20));
    }

    @And("I verify CA zip code validation in estore cart")
    public void iVerifyCAZipCodeValidationInEstoreCart() {
        $(By.xpath("//*[text()='54106']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='54106']")).click();
        sleep(3000);
        estoreCartPage.getZipCodeField().clear();
        estoreCartPage.getZipCodeField().setValue("A1A1A1");
        sleep(3000);
        estoreAddressScreen.getSubmitZipCode().click();
    }

    public void clickOkZipCodeButton() {
        try {
            estoreAddressScreen.getOkButton().should(visible, Duration.ofSeconds(40));
            estoreAddressScreen.getOkButton().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Ok button is not displayed");
        }
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
        $(By.xpath("(//*[text()='" + "$" + lineItemPrice + ".00" + "'])[2]")).should(visible, Duration.ofSeconds(40));
    }

    @When("I click on continue as guest estore button")
    public void iClickOnContinueAsGuestEstoreButton() {
        estoreCheckoutAddressScreen.getContinueAsGuestButton().should(visible, Duration.ofSeconds(40));
        estoreCheckoutAddressScreen.getContinueAsGuestButton().click();
    }

    @When("I update postal code in cart")
    public void iUpdatePostalCodeInCart() {
        sleep(2000);
        estoreCartPage.getZipCodeField().scrollIntoView(true);
        estoreCartPage.getZipCodeField().should(visible, Duration.ofSeconds(40));
        estoreCartPage.getZipCodeField().clear();
        estoreCartPage.getZipCodeField().click();
        estoreCartPage.getZipCodeField().sendKeys("10007");
        sleep(2000);
        estoreAddressScreen.getSubmitZipCode().click();
        clickOkZipCodeButton();
    }

    @Then("I verify UFD in cart")
    public void iVerifyUFDInCart() {
        $(By.xpath("//*[text()='$279.00']")).should(visible, Duration.ofSeconds(15));
    }

    @Then("I verify SURCHARGE fee on cart page")
    public void iVerifySURCHARGEFeeOnCartPage() {
        $(By.xpath("//*[text()='ADDITIONAL SHIPPING SURCHARGE']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='$150.00']")).should(visible, Duration.ofSeconds(40));
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
        estoreCartPage.getJoinNowMembershipButton().shouldHave(text("Join Now"), Duration.ofSeconds(20));
        estoreCartPage.getJoinNowMembershipButton().click();
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
        clickOkZipCodeButton();
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
        estoreUserAccountPage.getBrandButton().should(visible, Duration.ofSeconds(40));
        estoreUserAccountPage.getBrandButton().click();
        int countOfBrands = estoreUserAccountPage.getListOfBrands().size();
        for (int i = 1; i < countOfBrands; i++) {
            if (i > 1) {
                estoreUserAccountPage.getBrandButton().click();
            }
            estoreUserAccountPage.getListOfBrands().get(i).click();
            estoreE2EStepDefs.iGoToItemFromEstoreSearchField("10073234 CAML");
            estoreE2EStepDefs.iClickOnAddToCartButton();
            iClickOnViewCartButton();
        }

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

//        try {
//            estoreCartPage.getCartButtonOrderReview().click();
//        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
//            System.out.println("Cart button is not displayed");
//        }
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

    @Then("I validate cart is empty")
    public void iValidateCartIsEmpty() {
        estoreUserAccountPage.getCartButton().click();
        estoreCartPage.getCartTitle().shouldHave(text("CART"), Duration.ofSeconds(12));
    }

    @Then("I verify that contract price is used in cart")
    public void iVerifyThatContractPriceIsUsedInCart() {
        estoreUserAccountPage.getContractText().should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='345']")).should(visible, Duration.ofSeconds(40));
    }

    @Then("I verify that trade price is used in cart")
    public void iVerifyThatTradePriceIsUsedInCart() {
        estoreUserAccountPage.getTradeText().should(visible, Duration.ofSeconds(40));
        $(By.xpath("//*[text()='35']")).should(visible, Duration.ofSeconds(40));
    }


    @Then("I verify that the price get increased in multiple of QTY")
    public void iVerifyThatThePriceGetIncreasedInMultipleOfQTY() {
        $(By.xpath("//*[text()='$5,376.00']")).should(visible, Duration.ofSeconds(40));
    }

    @Then("I verify that price for product&line should be in US dollars")
    public void iVerifyThatPriceForProductLineShouldBeInUS$() {
        $(By.xpath("//*[contains(text(),'$')]")).should(visible, Duration.ofSeconds(40));
    }

    @When("I introduces CAN zip code for estore cart")
    public void iIntroducesCANZipCodeForEstoreCart() {
        $(By.xpath("(//span[@style='text-decoration: underline; cursor: pointer;'])[2]")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("(//span[@style='text-decoration: underline; cursor: pointer;'])[2]")).click();
        $(By.xpath("//input[@data-testid='postalcode-dialog-input']")).should(visible, Duration.ofSeconds(40));
        $(By.xpath("//input[@data-testid='postalcode-dialog-input']")).clear();
        $(By.xpath("//input[@data-testid='postalcode-dialog-input']")).setValue("A1A1A1");
    }

    @Then("I verify that the price for trade get increased in multiple of QTY")
    public void iVerifyThatThePriceForTradeGetIncreasedInMultipleOfQTY() {
        $(By.xpath("//*[text()='$642.00']")).should(visible, Duration.ofSeconds(40));
    }

    @Then("I verify that trade price is used for each product")
    public void iVerifyThatTradePriceIsUsedForEachProduct() {
        $(By.xpath("//*[text()='Trade']")).should(visible, Duration.ofSeconds(30));
    }
}
