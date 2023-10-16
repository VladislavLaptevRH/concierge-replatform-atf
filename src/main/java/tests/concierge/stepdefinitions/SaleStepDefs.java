package tests.concierge.stepdefinitions;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tests.concierge.pageObject.SaleScreen;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.Assert.assertEquals;


public class SaleStepDefs {
    SaleScreen saleScreen = new SaleScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();

    @When("I click on sale")
    public void iClickOnSale() {
        saleScreen.getSaleOption().should(visible, Duration.ofMinutes(1));
        saleScreen.getSaleOption().click();
        with().pollInterval(2, SECONDS).await().until(() -> true);
    }

    @Then("I verify sale navigation bars are displayed")
    public void iVerifySaleNavigationBarsAreDisplayed() {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        List<String> items = new ArrayList<>();
        List<String> expectedItems = new ArrayList(Arrays.asList("Living", "Dining", "Bed", "Bath", "Outdoor" , "Lighting", "Textiles", "Rugs", "Décor", "Baby & Child", "Teen"));
        for (int i = 0; i < saleScreen.getListOfSaleMainCategory().size(); i++) {
            items.add(saleScreen.getListOfSaleMainCategory().get(i).getText());
        }
        assertEquals(items, expectedItems);

    }

    @When("I click on sale menu item")
    public void iCLickOnSaleMenuItem() {
        $(By.xpath("(//*[text()='Décor'])[2]")).should(interactable).click();
    }

    @When("I click on sub category and navigate PDP")
    public void iClickOnSubCategory() {
        with().pollInterval(2, SECONDS).await().until(() -> true);
        int randomSubCategory = generalStepDefs.getRandomNumber(1, saleScreen.getListOfSaleSubCategory().size());
        saleScreen.getListOfSaleSubCategory().get(randomSubCategory).click();
        with().pollInterval(1, SECONDS).await().until(() -> true);
        /*int randomCollection = generalStepDefs.getRandomNumber(1, saleScreen.getListOfSaleCollection().size());
        saleScreen.getListOfSaleCollection().get(randomCollection).click();
        with().pollInterval(1, SECONDS).await().until(() -> true);*/

        int randomProduct = generalStepDefs.getRandomNumber(1, saleScreen.getRandomProduct().size());
        saleScreen.getRandomProduct().get(randomProduct).click();
        with().pollInterval(1, SECONDS).await().until(() -> true);
    }

    @Then("I verify prices on product page")
    public void iVerifyPricesOnProductPage() {
        with().pollInterval(3, SECONDS).await().until(() -> true);
        if (!saleScreen.getPrice().isDisplayed()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
        assertEquals(saleScreen.getPrice().getText(), "Sale");
    }
}