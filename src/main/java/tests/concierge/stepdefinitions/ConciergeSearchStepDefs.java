package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import lombok.Setter;
import org.openqa.selenium.By;
import tests.estore.stepdefinitions.EstoreHomePageStepDefs;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.*;

public class ConciergeSearchStepDefs {

    EstoreHomePageStepDefs estoreHomePageStepDefs = new EstoreHomePageStepDefs();

    @Then("I verify that {string} on search page")
    public void iVerifyOnSearchPage(String data) {
        switch (data) {
            case "PG Search Page has title (TABLE) and text \"Results\" and \"Sort\" are present":
                String title = EstoreHomePageStepDefs.result;
                assertEquals(title.toLowerCase(), $(By.xpath("//*[text() = '" + title + "']")).getText().toLowerCase());
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
                $(By.xpath("//*[@id = 'footer']")).should(Condition.visible, Duration.ofSeconds(15));
                break;
            case "PG page is returned with text  RESULTS (IN RH BABY & CHILD)":
                $(By.xpath("//*[text() = 'RESULTS']")).shouldHave(text("RESULTS ( 230 IN RH BABY & CHILD )"));
                break;
            case "VIEW RH BABY & CHILD RESULTS button is present":
                $(By.xpath("//*[@data-testid = 'add-to-cart-dialog-opener' ]/span[text() = 'VIEW RH BABY & CHILD RESULTS']")).should(Condition.visible, Duration.ofSeconds(15));
                break;
            default: break;
        }
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
            default: break;
        }
    }

    @Then("I verify that relevant items are returned on search page {string}")
    public void iVerifyTgatRelevantItemsAreReturnedOnSearchPage(String items) {
        $(By.xpath("(//*[@id = 'component-product-grid']//p/span[contains(text(), '" + items + "')])[1]")).shouldBe(visible, Duration.ofSeconds(15));
        assertTrue($$(By.xpath("//*[@id = 'component-product-grid']//p/span[contains(text(), '" + items + "')]")).size() > 10);
        for(int i = 1; i < $$(By.xpath("//*[@id = 'component-product-grid']//p/span[contains(text(), '" + items + "')]")).size(); i++) {
            $(By.xpath("(//*[@id = 'component-product-grid']//p/span[contains(text(), '" + items + "')])[" + i + "]")).shouldHave(text("" + items + ""));
        }
    }

}
