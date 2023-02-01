package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.estore.pageObject.EstoreCGScreen;
import tests.estore.pageObject.EstoreSaleScreen;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class EstoreSaleStepDefs {

    EstoreCGScreen estoreCGScreen = new EstoreCGScreen();
    EstoreSaleScreen estoreSaleScreen = new EstoreSaleScreen();
    String URL;

    @When("I click on estore sale button")
    public void iClickOnEstoreSaleButton() {
        sleep(3000);
        estoreSaleScreen.getSaleButtonMenu().should(Condition.visible, Duration.ofSeconds(20));
        estoreSaleScreen.getSaleButtonMenu().click();
    }

    @Then("I verify that I'm able to navigate different category")
    public void iVerifyThatIMAbleToNavigateDifferentCategory() {
//        estoreSaleScreen.getMainSaleList().should(Condition.visible, Duration.ofSeconds(10));
//        executeJavaScript("arguments[0].click();", estoreSaleScreen.getMainSaleList());
//
//        estoreSaleScreen.getSubSaleList().should(Condition.visible, Duration.ofSeconds(10));
//        estoreSaleScreen.getSubSaleList().should(Condition.visible, Duration.ofSeconds(10));
    }

    @Then("I verify sale category for estore")
    public void iVerifySaleCategoryForEstore() {
        estoreSaleScreen.getSaleLivingCategory().should(Condition.visible, Duration.ofSeconds(20));
        estoreSaleScreen.getSaleDiningCategory().should(Condition.visible, Duration.ofSeconds(20));
        estoreSaleScreen.getBedLivingCategory().should(Condition.visible, Duration.ofSeconds(20));
        estoreSaleScreen.getTextilesSaleCategory().should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify the back button from sale PDP page")
    public void iVerifyTheBackButtonFromSalePDPPage() {
//        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
//        estoreCGScreen.getBackToTopButton().should(Condition.visible, Duration.ofSeconds(20));
//        estoreCGScreen.getBackToTopButton().click();
    }

    @When("I go to sale estore category")
    public void iGoToSaleEstoreCategory() {
//        URL = Hooks.eStoreURL + "/catalog/category/products.jsp?categoryId=cat10240094&pgterm=RH+Dressers&sale=true&topCatId=cat3890154&parentCatId=cat780002";
//        open(URL);
    }
}
