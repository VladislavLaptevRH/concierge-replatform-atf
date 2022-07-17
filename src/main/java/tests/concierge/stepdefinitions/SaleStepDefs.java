package tests.concierge.stepdefinitions;

import com.codeborne.selenide.WebDriverRunner;
import tests.concierge.pageObject.SaleScreen;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.sleep;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertEquals;


public class SaleStepDefs {
    SaleScreen saleScreen = new SaleScreen();
    GeneralStepDefs generalStepDefs = new GeneralStepDefs();

    @When("I click on sale")
    public void iClickOnSale() {
        saleScreen.getSaleOption().should(visible, Duration.ofMinutes(1));
        saleScreen.getSaleOption().click();
    }

    @Then ("I verify sale navigation bars are displayed")
    public void iVerifySaleNavigationBarsAreDisplayed () {
        List<String> items = new ArrayList<>();
        List<String> expectedItems = new ArrayList(Arrays.asList("LIVING", "DINING" , "BED", "BATH", "LIGHTING", "TEXTILES", "RUGS", "WINDOWS", "DÉCOR", "ART", "OUTDOOR", "SALE", "LIVING", "DINING" , "BED", "BATH", "LIGHTING", "TEXTILES", "RUGS", "WINDOWS", "DÉCOR", "OUTDOOR"));
        for (int i = 0; i < saleScreen.getListOfNavigationBars().size(); i++) {
            items.add(saleScreen.getListOfNavigationBars().get(i).getText());
        }
        assertEquals(items, expectedItems);

    }

    @When ("I click on sale menu item")
    public void iCLickOnSaleMenuItem () {
        sleep(7000);
        generalStepDefs.waitForJSandJQueryToLoad();
        saleScreen.getCatLiving().should(visible, Duration.ofSeconds(60));
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(saleScreen.getCatLiving());
        saleScreen.getCatLiving().click();
    }

    @When("I click on sub category and navigate PDP")
    public void iClickOnSubCategory() {
        saleScreen.getSubCatChair().should(visible, Duration.ofSeconds(30));
        saleScreen.getSubCatChair().click();
        saleScreen.getRandomProduct().click();
    }

    @Then("I verify prices on product page")
    public void iVerifyPricesOnProductPage() {

        sleep(7000);
        assertEquals(saleScreen.getMemberPrice().getText(), "Member");
        assertEquals(saleScreen.getFinalPrice().getText(), "Final Sale");
        assertEquals(saleScreen.getRegularPrice().getText(), "Regular");
    }
}
