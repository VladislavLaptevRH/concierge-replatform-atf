package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.EstoreCGScreen;
import tests.estore.pageObject.EstoreSaleScreen;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;

public class EstoreSaleStepDefs {

    EstoreCGScreen estoreCGScreen = new EstoreCGScreen();
    EstoreSaleScreen estoreSaleScreen = new EstoreSaleScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();
    String URL;

    @When("I click on estore sale button")
    public void iClickOnEstoreSaleButton() {
        estoreSaleScreen.getSaleButtonMenu().should(visible, Duration.ofSeconds(20));
        estoreSaleScreen.getSaleButtonMenu().click();
    }

    @Then("I verify that I'm able to navigate different category")
    public void iVerifyThatIMAbleToNavigateDifferentCategory() {
        estoreSaleScreen.getMainSaleList().should(Condition.and("Visible, interactable", Condition.interactable, visible), Duration.ofSeconds(20));
        estoreSaleScreen.getMainSaleList().click();
    }

    @Then("I verify sale category for estore")
    public void iVerifySaleCategoryForEstore() {
        estoreSaleScreen.getSaleLivingCategory().should(visible, Duration.ofSeconds(20));
        estoreSaleScreen.getSaleDiningCategory().should(visible, Duration.ofSeconds(20));
        estoreSaleScreen.getBedLivingCategory().should(visible, Duration.ofSeconds(20));
        estoreSaleScreen.getTextilesSaleCategory().should(visible, Duration.ofSeconds(20));
    }

    @Then("I verify the back button from sale PDP page")
    public void iVerifyTheBackButtonFromSalePDPPage() {
        WebDriverRunner.getWebDriver().navigate().back();
    }

    @When("I go to sale estore category")
    public void iGoToSaleEstoreCategory() {
        URL = "https://stg2.rhnonprod.com/catalog/category/products.jsp?categoryId=cat10240094&pgterm=RH+Dressers&sale=true&topCatId=cat3890154&parentCatId=cat780002";
        open(URL);
    }
}