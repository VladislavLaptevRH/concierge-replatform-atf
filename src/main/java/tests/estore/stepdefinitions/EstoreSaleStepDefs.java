package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.concierge.stepdefinitions.GeneralStepDefs;
import tests.estore.pageObject.EstoreCGScreen;
import tests.estore.pageObject.EstoreSaleScreen;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

public class EstoreSaleStepDefs {

    EstoreCGScreen estoreCGScreen = new EstoreCGScreen();
    EstoreSaleScreen estoreSaleScreen = new EstoreSaleScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();

    EstorePgStepDefs estorePgStepDefs = new EstorePgStepDefs();
    String URL;


    int memberSalePrice;
    int regularSalePrice;

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

    @Then("I verify sale prices on PG pages for sale items")
    public void iVerifySalePricesOnPGPagesForSaleItems() {
        regularSalePrice = Integer.parseInt(estoreSaleScreen.getRegularSalePrice().getText().replaceAll("\\$", "").replaceAll(",", ""));
        memberSalePrice = Integer.parseInt(estoreSaleScreen.getMemberSalePrice().getText().replaceAll("\\$", "").replaceAll(",", ""));

        assertTrue(memberSalePrice >= regularSalePrice, "Regular sale price is lower than member sale price");
    }

    @When("I go to Sale product page")
    public void iGoToSaleProductPage() {
        String saleUrl = "https://stg2.rhnonprod.com/us/en/catalog/category/products.jsp?categoryId=cat25450027&pgterm=" +
                "RH+Fabric+Sofas&sale=true&topCatId=cat3890154&parentCatId=cat160024?endpoint=" + Hooks.cookie;
        open(saleUrl);
    }

    @When("I go to the sale page with {string} on estore")
    public void iGoToTheSalePageWithOnEstore(String arg0) {
        String saleUrl = "";

        if (arg0.equals("sofas")) {
            saleUrl = Hooks.eStoreBaseURL + "/us/en/catalog/category/products.jsp?pgterm=RH+Fabric+Sofas&N=%7B%21tag%3Dsku_showOnly%7Dsku_showOnly%3A%28\"Sale\"%29&Ns=product.sale%7C1&categoryId=cat25450027" + Hooks.cookie;
        }
        open(saleUrl);
    }
}