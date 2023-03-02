package tests.estore.stepdefinitions;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.estore.pageObject.EstorePGScreen;
import tests.estore.pageObject.EstoreSearchScreen;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;

public class EstorePgStepDefs {

    EstoreSearchScreen estoreSearchScreen = new EstoreSearchScreen();
    EstorePGScreen estorePGScreen = new EstorePGScreen();

    @Then("I validate {string},{string} and {string} grid view should work")
    public void iValidateAndGridViewShouldWork(String arg0, String arg1, String arg2) {
        if (arg2.equals(3)) {
            estoreSearchScreen.getThreeColumnsInRowGridButton().should(visible, Duration.ofSeconds(20));
            estoreSearchScreen.getThreeColumnsInRowGridButton().click();
            estoreSearchScreen.getThreeColumnsInRowGridElement().should(visible, Duration.ofSeconds(20));
        }
        if (arg1.equals("2")) {
            estoreSearchScreen.getTwoColumnsInRowGridElement().should(visible, Duration.ofSeconds(20));
        }
        if (arg0.equals("1")) {
            estoreSearchScreen.getOneColumnInRowGridButton().should(visible, Duration.ofSeconds(20));
            estoreSearchScreen.getOneColumnInRowGridButton().click();
        }
    }


    @Then("I verify that two grids are default view in PG")
    public void iVerifyThatTwoGridsAreDefaultViewInPG() {
        estoreSearchScreen.getTwoColumnsInRowGridElement().should(visible, Duration.ofSeconds(20));
    }

    @When("I goes to estore product sale page")
    public void iGoesToEstorePg() {
        String URL = Hooks.eStoreBaseURL + "/search/results.jsp?Ntt=tables&Ns=product.sale%7C1";
        open(URL);
        with().pollInterval(2, SECONDS).await().until(() -> true);
        WebDriverRunner.getWebDriver().navigate().refresh();
    }

    @When("I apply In stock to Sale filter")
    public void iApplyInStockToSaleFilter() {
        estorePGScreen.getSaleButtonFilter().shouldHave(text("sale"), Duration.ofSeconds(20));
        executeJavaScript("arguments[0].click();", estorePGScreen.getSaleButtonFilter());
    }

    @Then("I verify that search results page is displayed with newly searched products")
    public void iVerifyThatSearchResultsPageIsDisplayedWithNewlySearchedProducts() {
        estoreSearchScreen.getTurkish802towel().should(visible, Duration.ofSeconds(20));
    }
}
