package tests.estore.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.EstoreCartPage;
import tests.estore.pageObject.EstoreItemPage;
import tests.estore.pageObject.EstoreUserAccountPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class EstoreCartPageStepDefs {
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstoreCartPage estoreCartPage = new EstoreCartPage();
    EstoreGeneralStepDefs estoreGeneralStepDefs = new EstoreGeneralStepDefs();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    EstoreItemPage estoreItemPage = new EstoreItemPage();

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
        estoreCartPage.getItemAddedToYourCart().should(visible, Duration.ofMinutes(1));
        estoreCartPage.getItemAddedToYourCart().shouldHave(text("Added To Your Cart"), Duration.ofSeconds(30));
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
        $(By.xpath("//*[text()='12345']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='12345']")).click();
    }

    @Then("I verify US zip code validation in estore cart")
    public void iVerifyZipCodeValidationInEstoreCart() {
        estoreCartPage.getZipCodeField().should(visible, Duration.ofSeconds(20));
        estoreCartPage.getZipCodeField().clear();
        estoreCartPage.getZipCodeField().setValue("54106");
        $(By.xpath("(//button[@type='submit'])[3]")).click();

        $(By.xpath("//*[text()='Enter ZIP Code']")).shouldNotBe(visible, Duration.ofSeconds(20));
    }

    @And("I verify CA zip code validation in estore cart")
    public void iVerifyCAZipCodeValidationInEstoreCart() {
        $(By.xpath("//*[text()='54106']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='54106']")).click();
        estoreCartPage.getZipCodeField().clear();
        estoreCartPage.getZipCodeField().setValue("A1A1A1");
        $(By.xpath("(//button[@type='submit'])[3]")).click();

        $(By.xpath("//*[contains(text(),'entered is in Canada.')]")).should(visible, Duration.ofSeconds(20));
    }
}
