package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.Setter;
import org.openqa.selenium.By;
import tests.concierge.pageObject.ConciergeSearchScreen;
import tests.concierge.pageObject.PdpScreen;
import tests.estore.stepdefinitions.EstoreHomePageStepDefs;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.*;

public class ConciergeSearchStepDefs {

    Pdp pdp = new Pdp();

    ConciergeSearchScreen conciergeSearchScreen = new ConciergeSearchScreen();

    PdpScreen pdpScreen = new PdpScreen();

    public static int result;



    @Then("I verify that {string} on search page")
    public void iVerifyOnSearchPage(String data) {
        switch (data) {
            case "PG Search Page has title (TABLE) and text \"Results\" and \"Sort\" are present":
                String title = Pdp.result;
                assertEquals(title.toLowerCase(), $(By.xpath("//*[text() = '" + title + "']")).getText().toLowerCase());
                if(!$(By.xpath("//*[text() = 'RESULTS']")).isDisplayed()){
                    WebDriverRunner.getWebDriver().navigate().refresh();
                }
                $(By.xpath("//*[text() = 'RESULTS']")).should(Condition.visible, Duration.ofSeconds(15));
                $(By.xpath("//*[text() = 'sort']")).should(Condition.visible, Duration.ofSeconds(15));
                break;
            case "PG pictures of all items are visible":
                for(int i = 1; i <= $$(By.xpath("//*[@id = 'component-rh-image_wrapper']//img")).size(); i++){
                    $(By.xpath("(//*[@id = 'component-rh-image_wrapper']//img)[" + i + "]")).should(Condition.visible, Duration.ofSeconds(15));
                }
                break;
            case "page is loaded until footer":
                $(By.xpath("//*[@id = 'footer']")).scrollIntoView(true);
                $(By.xpath("//*[@id = 'footer']")).should(Condition.visible, Duration.ofSeconds(15));
                break;
            case "PG page is returned with RESULTS(0) present and search text \"234ADF\" is present":
                $(By.xpath("//*[text() = '234adf']")).should(Condition.visible, Duration.ofSeconds(15));
                $(By.xpath("//*[text() = 'RESULTS']")).shouldHave(text("RESULTS (0)"));
                break;
            case "customer experience":
                $(By.xpath("//*[@data-testid = 'customer-service-link' and @href = '/us/en/customer-experience/contact-us']/p[text() = 'Customer Experience']")).should(Condition.visible, Duration.ofSeconds(15));
                break;
            case "customer experience page is opened":
                assertEquals(Hooks.getCurrentUrl(), "https://stg2-concierge.restorationhardware.com/us/en/customer-experience/contact-us");
                break;
            case "footer is present":
                $(By.xpath("//*[text() = 'LEGAL']")).should(Condition.visible, Duration.ofSeconds(15));
                break;
            case "PG page is returned with text  RESULTS (IN RH BABY & CHILD)":
                $(By.xpath("//*[text() = 'RESULTS']")).shouldHave(text("IN RH BABY & CHILD )"));
                break;
            case "VIEW RH BABY & CHILD RESULTS button is present":
                $(By.xpath("//*[@data-testid = 'add-to-cart-dialog-opener' ]/span[text() = 'VIEW RH BABY & CHILD RESULTS']")).should(Condition.visible, Duration.ofSeconds(15));
                break;
            case "Filters such as Material Filters, Size Filters, Brand":
                conciergeSearchScreen.getMaterialFilter().should(Condition.visible, Duration.ofSeconds(15));
                conciergeSearchScreen.getSizeFilter().should(Condition.visible, Duration.ofSeconds(15));
                conciergeSearchScreen.getBrandFilter().should(Condition.visible, Duration.ofSeconds(15));
                break;
            default: break;
        }
    }

    @Then("Sofa products too should be searched")
    public void sofaProductsShouldBeSearched(){
        conciergeSearchScreen.getBrandFilter().should(visible, Duration.ofSeconds(3));
    }

    @Then("All RH products should be searched")
    public void allRHProductShouldBeSearched(){
       assertTrue(Integer.parseInt(pdpScreen.getResults().getText().replaceAll("[^0-9]", "")) > 10000);
    }

    @Then("Seating Collections products should be displayed")
    public void seatingConnectionProductsShouldBeDisplayed(){
        conciergeSearchScreen.getSeatingCollection().should(visible, Duration.ofSeconds(15));
    }

    @Then("verify the count of products")
    public void verifyTheCountOfProduct(){
        result = Integer.parseInt(pdpScreen.getResults().getText().replaceAll("[^0-9]", ""));
    }

    @Then("Product's count should be shown as per the availability of the products in that country")
    public void productsCountShouldBeShown(){
       assertEquals(result,Integer.parseInt(pdpScreen.getResults().getText().replaceAll("[^0-9]", "")));
    }

    @Then("I click on {string} button on search page")
    public void iClickOnSwitchButton(String button) {
        switch (button) {
            case "customer experience":
                $(By.xpath("//*[@data-testid = 'customer-service-link' and @href = '/us/en/customer-experience/contact-us']/p[text() = 'Customer Experience']")).shouldBe(visible, Duration.ofSeconds(15));
                $(By.xpath("//*[@data-testid = 'customer-service-link' and @href = '/us/en/customer-experience/contact-us']/p[text() = 'Customer Experience']")).click();
                break;
            case "VIEW RH BABY & CHILD RESULTS":
                $(By.xpath("//*[@data-testid = 'add-to-cart-dialog-opener' ]/span[text() = 'VIEW RH BABY & CHILD RESULTS']")).click();
                break;
            case "BRAND facet":
               conciergeSearchScreen.getBrandFilter().click();
                break;
            case "select any brand":
                conciergeSearchScreen.getBrandFilterInteriorsCheckBox().click();
                break;
            default: break;
        }
    }
    @Then("I verify that relevant items are returned on search page {string}")
    public void iVerifyTgatRelevantItemsAreReturnedOnSearchPage(String items) {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        $(By.xpath("(//*[@id = 'component-product-grid']//p/span[contains(text(), '" + items + "')])[1]")).shouldBe(visible, Duration.ofSeconds(15));
        assertTrue($$(By.xpath("//*[@id = 'component-product-grid']//p/span[contains(text(), '" + items + "')]")).size() > 10);
        for(int i = 1; i < $$(By.xpath("//*[@id = 'component-product-grid']//p/span[contains(text(), '" + items + "')]")).size(); i++) {
            $(By.xpath("(//*[@id = 'component-product-grid']//p/span[contains(text(), '" + items + "')])[" + i + "]")).shouldHave(text("" + items + ""));
        }
    }

}
