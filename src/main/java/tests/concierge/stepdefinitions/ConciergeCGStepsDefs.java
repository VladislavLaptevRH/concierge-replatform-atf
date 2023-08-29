package tests.concierge.stepdefinitions;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.AssertJUnit.assertEquals;

public class ConciergeCGStepsDefs {

    @Then("I verify that {string} on CG screen")
    public void iVerifyThatOnCGScreen(String data) {
        switch (data) {
            case "Back to top Button is present":
                $(By.xpath("//*[@id = 'footer']")).scrollIntoView(true);
                with().pollInterval(5, SECONDS).await().until(() -> true);
                $(By.xpath("//*[@class = 'MuiButtonBase-root MuiFab-root' and not(contains(@style, 'hidden'))]")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "user is brought to the top of the page":
                $(By.xpath("//*[@class = 'MuiButtonBase-root MuiFab-root' and contains(@style, 'hidden')]")).shouldBe(exist, Duration.ofSeconds(20));
                break;
            case "Dashboard is displayed":
                $(By.xpath("//*[text() = 'Concierge']/following-sibling::h1[text() = 'Dashboard']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "Navigate to third collection":
                $(By.xpath("(//*[@id = 'component-collection-card'])[3]//*[text() = 'French Contemporary']/../following-sibling::div/p[text() = 'Washstand Collection']")).click();
                $(By.xpath("//*[text() = 'French Contemporary Washstand Collection']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "Bath Collections are displayed":
                $(By.xpath("(//*[@id = 'component-collection-card'])[3]//*[text() = 'French Contemporary']/../following-sibling::div/p[text() = 'Washstand Collection']")).click();
                $(By.xpath("//*[text() = 'Bath  collections']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "Navigate to fourth collection":
                $(By.xpath("(//*[@id = 'component-collection-card'])[4]//*[text() = 'Nihal Wool Rug']")).click();
                $(By.xpath("//*[text() = 'Nihal Wool Rug']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "Navigate to first product":
                $(By.xpath("(//*[contains(@id , 'RH')])[1]//*[text() = 'Nihal Wool Rug']")).click();
                $(By.xpath("//h2[text() = 'Nihal Wool Rug']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "confirm that PG is displayed":
                $(By.xpath("(//*[contains(@id , 'RH')])[1]//*[text() = 'Nihal Wool Rug']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "confirm that CG Rug Collections is displayed":
                $(By.xpath("(//*[@id = 'component-collection-card'])[4]//*[text() = 'Nihal Wool Rug']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            default: break;
        }
    }

    @Then("I click {string} on CG screen")
    public void iClickOnCGScreen(String button) {
        switch (button) {
            case "Back Browser Button":
                WebDriverRunner.getWebDriver().navigate().back();
                break;
            default: break;
        }
    }
    @Then("confirm that Seating {string} is present in {string} of {string}")
    public void iConfirmThatSearchingCollectionsIsPresentInLevelOfMenu(String gallery, String levelOfCollection, String subMenu) {
        if(!gallery.equals("")){
            if($(By.xpath("(//li[contains(@id, 'rhrCtalogNavigationDetails_concepts')])[" + levelOfCollection + "]/span")).isDisplayed()){
                assertEquals(gallery, $(By.xpath("(//li[contains(@id, 'rhrCtalogNavigationDetails_concepts')])[" + levelOfCollection + "]/span")).getText());
            } else {
                assertEquals(gallery, $(By.xpath("(//*[@role = 'tooltip']//*[contains(@class, 'MuiTypography')])[" + levelOfCollection + "]")).getText());
            }

        } else {
            if($(By.xpath("(//li[contains(@id, 'rhrCtalogNavigationDetails_navigation')])[" + levelOfCollection + "]/span")).isDisplayed()){
                assertEquals(subMenu, $(By.xpath("(//li[contains(@id, 'rhrCtalogNavigationDetails_navigation')])[" + levelOfCollection + "]/span")).getText());
            } else {
                assertEquals(subMenu, $(By.xpath("(//div[@role = 'tooltip']//span[contains(@class, 'MuiTypography')])[" + levelOfCollection + "]")).getText());
            }
        }

    }

}
