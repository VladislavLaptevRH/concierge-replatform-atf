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

    @When("I remove all items from estore cart")
    public void iRemoveAllItemsFromEstoreCart() {
        estoreUserAccountPage.getCartButton().should(visible, Duration.ofMinutes(3));
        sleep(3000);
        if (!estoreUserAccountPage.getCartButton().getText().equals("")) {
            int countOfProducts = Integer.parseInt(estoreUserAccountPage.getCartButton().getText());
            estoreUserAccountPage.getCartButton().click();
            estoreGeneralStepDefs.waitForJSandJQueryToLoad();
            estoreCartPage.getCartTitle().shouldHave(text("CART"), Duration.ofSeconds(12));
            try {
                for (int i = 0; i < countOfProducts; i++) {
                    estoreCartPage.getRemoveButton().should(visible, Duration.ofSeconds(30));
                    estoreCartPage.getRemoveButton().click();
                    estoreCartPage.getRemoveButton().should(visible, Duration.ofSeconds(30));
                }
            } catch (com.codeborne.selenide.ex.ElementNotFound e) {
                System.out.println("Agree&add to cart button is not displayed");
                estoreUserAccountPage.getRhEstoreLogo().should(visible, Duration.ofSeconds(15));
                estoreUserAccountPage.getRhEstoreLogo().click();
            }
        }
    }

    @When("I click on view cart estore button")
    public void iClickOnViewCartButton() {
        sleep(3000);
        generalStepDefs.waitForJSandJQueryToLoad();
//        estoreCartPage.getItemAddedToYourCart().should(visible, Duration.ofMinutes(1));
//        estoreCartPage.getItemAddedToYourCart().shouldHave(text("Added To Your Cart"), Duration.ofSeconds(30));
        estoreItemPage.getViewCartButton().shouldHave(text("View Cart"), Duration.ofSeconds(60));
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
        estoreCartPage.getUserNameEmployeeDiscount().should(visible, Duration.ofSeconds(20));
        estoreCartPage.getUserNameEmployeeDiscount().setValue("ediscount");
        estoreCartPage.getPasswordEmployeeDiscount().should(visible, Duration.ofSeconds(20));
        estoreCartPage.getPasswordEmployeeDiscount().setValue("p6K6K6Mx");
        estoreCartPage.getApplyEmpDiscountBtn().should(visible, Duration.ofSeconds(15));
        estoreCartPage.getApplyEmpDiscountBtn().click();
        estoreCartPage.getTotalAditionalProdDiscount().should(visible, Duration.ofSeconds(20));
    }

    @And("I remove promotion from estore cart")
    public void iRemovePromotionFromCart() {
        estoreCartPage.getRemovePromotionBtn().should(visible, Duration.ofSeconds(15));
        estoreCartPage.getRemovePromotionBtn().click();
    }

    @Then("I verify that I'm able to remove estore employee discount")
    public void iVerifyThatIMAbleToRemoveEstoreEmployeeDiscount() {
        estoreCartPage.getRemoveButton().should(visible, Duration.ofSeconds(20));
        estoreCartPage.getRemoveButton().click();
        estoreCartPage.getTotalAditionalProdDiscount().shouldNotBe(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that I'm able to apply promotion code")
    public void iVerifyThatIMAbleToApplyPromotionCode() {
        estoreCartPage.getPromotionCodeField().should(visible, Duration.ofSeconds(20));
        estoreCartPage.getPromotionCodeField().setValue("HM4TS96");
        estoreCartPage.getApplyPromocodeBtn().should(visible, Duration.ofSeconds(20));
        estoreCartPage.getApplyPromocodeBtn().click();
    }

    @When("I click on zipcode estore button")
    public void iClickOnZipcodeEstoreButton() {
        estoreAddressScreen.getEnterZipCodeBtn().should(visible, Duration.ofSeconds(20));
        estoreAddressScreen.getEnterZipCodeBtn().click();
    }

    @Then("I verify US zip code validation in estore cart")
    public void iVerifyZipCodeValidationInEstoreCart() {
        estoreCartPage.getZipCodeField().should(visible, Duration.ofSeconds(20));
        estoreCartPage.getZipCodeField().clear();
        estoreCartPage.getZipCodeField().setValue("54106");
        estoreAddressScreen.getSubmitZipCode().click();
        clickOkZipCodeButton();

        $(By.xpath("//*[text()='Enter ZIP Code']")).shouldNotBe(visible, Duration.ofSeconds(20));
    }

    @And("I verify CA zip code validation in estore cart")
    public void iVerifyCAZipCodeValidationInEstoreCart() {
        $(By.xpath("//*[text()='54106']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='54106']")).click();
        sleep(3000);
        estoreCartPage.getZipCodeField().clear();
        estoreCartPage.getZipCodeField().setValue("A1A1A1");
        sleep(3000);
        estoreAddressScreen.getSubmitZipCode().click();
        $(By.xpath("//*[contains(text(),'entered is in Canada.')]")).should(visible, Duration.ofSeconds(20));
        clickOkZipCodeButton();
    }

    public void clickOkZipCodeButton() {
        try {
            estoreAddressScreen.getOkButton().should(visible, Duration.ofSeconds(20));
            estoreAddressScreen.getOkButton().click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Ok button is not displayed");
        }
    }

    @Then("I verify membership price in banner")
    public void iVerifyMembershipPriceInBanner() {
        estoreCartPage.getJoinRhMemberProgramTitle().should(visible, Duration.ofSeconds(20));
        estoreCartPage.getMemberLabel().should(visible, Duration.ofSeconds(20));
        estoreCartPage.getMemberPrice().should(visible, Duration.ofSeconds(20));
    }

    @When("I choose qty for item from estore cart")
    public void iChooseQtyForItemFromCart() {
        Select qtySelect = new Select(estoreCartPage.getQuantitySelect());
        estoreCartPage.getQuantitySelect().should(visible, Duration.ofSeconds(20));
        qtySelect.selectByValue("2");
    }

    @Then("I verify that estore line item price should be update according to user selected qty")
    public void iVerifyThatLineItemPriceShouldBeUpdateAccrodingToUserSelectedQty() {
        estoreCartPage.getTotalLineItemPrice().should(visible, Duration.ofSeconds(20));
        estoreCartPage.getTotalLineItemPrice().shouldHave(text("C$1,390.00"), Duration.ofSeconds(20));
    }

    @And("I verify that subtotal should be updated according to quantity selected")
    public void iVerifyThatSubtotalShouldBeUpdatedAccordingToQuantitySelected() {
        $(By.xpath("(//*[text()='C$1,390.00'])[2]")).should(visible, Duration.ofSeconds(20));
    }

    @When("I click on continue as guest estore button")
    public void iClickOnContinueAsGuestEstoreButton() {
        estoreCheckoutAddressScreen.getContinueAsGuestButton().should(visible, Duration.ofSeconds(20));
        estoreCheckoutAddressScreen.getContinueAsGuestButton().click();
    }

    @When("I update postal code in cart")
    public void iUpdatePostalCodeInCart() {
        estoreCartPage.getZipCodeField().should(visible, Duration.ofSeconds(20));
        estoreCartPage.getZipCodeField().clear();
        estoreCartPage.getZipCodeField().setValue("10007");
        estoreAddressScreen.getSubmitZipCode().click();
        clickOkZipCodeButton();
    }

    @Then("I verify UFD in cart")
    public void iVerifyUFDInCart() {
        $(By.xpath("//*[text()='$279.00']")).should(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[text()='$3,864.00']")).should(visible, Duration.ofSeconds(15));
    }

    @Then("I verify SURCHARGE fee on cart page")
    public void iVerifySURCHARGEFeeOnCartPage() {
        $(By.xpath("//*[text()='ADDITIONAL SHIPPING SURCHARGE $150']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='ADDITIONAL SHIPPING SURCHARGE']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='$150.00']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='$9,424.00']")).should(visible, Duration.ofSeconds(20));

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
        $(By.xpath("//*[contains(text(),'When gift boxed, your item will arrive ')]")).should(visible, Duration.ofSeconds(20));
        estoreCartPage.getPopupCloseButton().click();
        $(By.xpath("//*[text()='Gift Box Fee']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='$5.95']")).should(visible, Duration.ofSeconds(20));
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
        $(By.xpath("//*[text()='Subtotal with Member Savings']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='RH Members Program']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='RH Member Savings on this order']")).should(visible, Duration.ofSeconds(20));
    }

    @When("I update {string} postal code in cart")
    public void iUpdatePostalCodeInCart(String arg0) {
        estoreCartPage.getZipCodeField().should(visible, Duration.ofSeconds(20));
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
            $(By.xpath("//*[text()='10007']")).should(visible, Duration.ofSeconds(20));
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
            $(By.xpath("//*[text()='RH MEMBERS PROGRAM']")).should(visible, Duration.ofSeconds(20));
            $(By.xpath("//*[contains(text(),'Join the RH Members Program for $175')]")).should(visible, Duration.ofSeconds(20));
            estoreCartPage.getJoinNowCartEstoreButton().should(visible, Duration.ofSeconds(20));
        }
        if (arg0.equals("member user")) {
            $(By.xpath("//*[text()='RH MEMBERS PROGRAM']")).shouldNot(visible, Duration.ofSeconds(20));
            $(By.xpath("//*[contains(text(),'Join the RH Members Program for $175')]")).shouldNot(visible, Duration.ofSeconds(20));
            estoreCartPage.getJoinNowCartEstoreButton().shouldNot(visible, Duration.ofSeconds(20));
        }

    }

    @Then("I verify that the added product is in the cart during brand switching")
    public void iVerifyThatTheAddedProductIsInTheCartDuringBrandSwitching() {
        estoreUserAccountPage.getBrandButton().should(visible, Duration.ofSeconds(20));
        estoreUserAccountPage.getBrandButton().click();
        int countOfBrands = estoreUserAccountPage.getListOfBrands().size();
        for (int i = 1; i < countOfBrands; i++) {
            if (i > 1) {
                estoreUserAccountPage.getBrandButton().click();
            }
            estoreUserAccountPage.getListOfBrands().get(i).click();
            estoreUserAccountPage.getCartButton().shouldHave(text("1"), Duration.ofSeconds(40));
        }
    }

    @Then("I verify that I'm able to add products from all brands to cart")
    public void iVerifyThatIMAbleToAddProductsFromAllBrandsToCart() {
        estoreUserAccountPage.getBrandButton().should(visible, Duration.ofSeconds(20));
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
        estoreCartPage.getCartButtonOrderReview().should(visible, Duration.ofSeconds(20));
        estoreCartPage.getCartButtonOrderReview().click();
    }

    @When("I update item quantity in estore cart")
    public void iUpdateItemQuantityInEstoreCart() {
    }

    @Then("I verify that I'm able to increase item quantity with success")
    public void iVerifyThatItemQuantityWasIncreasedWithSuccess() {
        estoreItemPage.getSelectQuantity().should(visible, Duration.ofSeconds(20));
        estoreItemPage.getSelectQuantity().scrollIntoView(true);
        Select selectQuantity = new Select(estoreItemPage.getSelectQuantity());
        selectQuantity.selectByValue("2");
        $(By.xpath("//*[text()='$11,790.00']")).should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify that I'm able to decrease item quantity with success")
    public void iVerifyThatIMAbleToDecreaseItemQuantityWithSuccess() {
        estoreCartPage.getQuantitySelect().should(visible, Duration.ofSeconds(20));
        Select selectQuantity = new Select(estoreCartPage.getQuantitySelect());
        selectQuantity.selectByValue("1");
        $(By.xpath("//*[text()='$5,895.00']")).should(visible, Duration.ofSeconds(20));
    }

    @When("I click on add to wishlist button from cart")
    public void iClickOnAddToWishlistButtonFromCart() {
        sleep(2000);
        estoreCartPage.getAddToWishlistButton().should(visible, Duration.ofSeconds(20));
        estoreCartPage.getAddToWishlistButton().click();
    }

    @Then("I validate cart is empty")
    public void iValidateCartIsEmpty() {
        estoreUserAccountPage.getCartButton().click();
        estoreCartPage.getCartTitle().shouldHave(text("CART"), Duration.ofSeconds(12));
    }
}
