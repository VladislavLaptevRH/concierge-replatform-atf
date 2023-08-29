package tests.concierge.stepdefinitions;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import tests.concierge.pageObject.ConciergePGScreen;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.AssertJUnit.assertTrue;


public class ConciergePGStepsDefs {

    ConciergePGScreen conciergePGScreen = new ConciergePGScreen();

    @Then("I navigate to menu {string}")
    public void INavigateToMenu(String menu) {
        if(conciergePGScreen.getTopNavManuByName(menu).isDisplayed()){
            conciergePGScreen.getTopNavManuByName(menu).click();
        } else {
            $(By.xpath("//*[text() = '" + menu + "']")).click();
        }
    }
    @Then("I navigate to sub menu {string}")
    public void INavigateToSubMenu(String subMenu) {
        if(conciergePGScreen.getTopNavSubManuByName(subMenu).isDisplayed()){
            conciergePGScreen.getTopNavSubManuByName(subMenu).hover();
        } else {
            $(By.xpath("//*[text() = '" + subMenu + " ']")).hover();
        }
    }
    @Then("I navigate to gallery {string}")
    public void stepByStepINavigateTo(String collection) {
        conciergePGScreen.getTopNavGalleryByName(collection).click();
    }

    @Then("I verify that {string} on PG screen")
    public void iVerifyThatOnPGScreen(String data) {
        switch (data) {
            case "Grid View is present in top right":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                conciergePGScreen.getThreeGridView().shouldBe(visible, Duration.ofSeconds(15));
                conciergePGScreen.getTwoGridView().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case "Grid View in PG is set to 3-grid view by default":
                conciergePGScreen.getThreeGridViewIsActive().shouldBe(visible, Duration.ofSeconds(15));
                break;
            case "Back to top Button is present":
                $(By.xpath("//*[@id = 'footer']")).scrollIntoView(true);
                with().pollInterval(5, SECONDS).await().until(() -> true);
                $(By.xpath("//*[@class = 'MuiButtonBase-root MuiFab-root' and not(contains(@style, 'hidden'))]")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "user is brought to the top of the page":
                $(By.xpath("//*[@class = 'MuiButtonBase-root MuiFab-root' and contains(@style, 'hidden')]")).shouldBe(exist, Duration.ofSeconds(20));
                break;
            case "Verify that all products have text From $ / $ Sale / $ Member":
                $(By.xpath("(//*[text() = 'From'])[1]")).shouldBe(visible, Duration.ofSeconds(20));
                assertTrue($$(By.xpath("//*[text() = 'From']")).size() > 10);
                for(int i = 1; i < $$(By.xpath("//*[text() = 'From']")).size(); i++) {
                    $(By.xpath("(//*[text() = 'From'])[" + i + "]")).shouldHave(text("From"));
                }
                $(By.xpath("(//*[@id = 'price-label']/following-sibling::p[1])[1]")).shouldBe(visible, Duration.ofSeconds(10));
                assertTrue($$(By.xpath("//*[@id = 'price-label']/following-sibling::p[1]")).size() > 10);
                for(int i = 1; i < $$(By.xpath("//*[@id = 'price-label']/following-sibling::p[1]")).size(); i++) {
                    $(By.xpath("(//*[@id = 'price-label']/following-sibling::p[1])[" + i + "]")).shouldHave(text(" / "));;
                }
                if($(By.xpath("(//*[@data-testid = 'price-for-member'])[1]")).isDisplayed()) {
                    assertTrue($$(By.xpath("//*[@data-testid = 'price-for-member']")).size() > 10);
                    for (int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-for-member']")).size(); i++) {
                        $(By.xpath("(//*[@data-testid = 'price-for-member'])[" + i + "]")).shouldHave(text("$"));
                    }
                } else {
                    assertTrue($$(By.xpath("//*[@data-testid = 'price-for-trade']")).size() > 10);
                    for (int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-for-trade']")).size(); i++) {
                        $(By.xpath("(//*[@data-testid = 'price-for-trade'])[" + i + "]")).shouldHave(text("$"));
                    }
                }
                $(By.xpath("(//*[@data-testid = 'price-for-sale'])[1]")).shouldBe(visible, Duration.ofSeconds(10));
                for(int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-for-sale']")).size(); i++) {
                    $(By.xpath("(//*[@data-testid = 'price-for-sale'])[" + i + "]")).shouldHave(text("$"));;
                }
                $(By.xpath("(//*[@data-testid = 'price-for-regular'])[1]")).shouldBe(visible, Duration.ofSeconds(10));
                assertTrue($$(By.xpath("//*[@data-testid = 'price-for-regular']")).size() > 10);
                for(int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-for-regular']")).size(); i++) {
                    $(By.xpath("(//*[@data-testid = 'price-for-regular'])[" + i + "]")).shouldHave(text("$"));;
                }
                if( $(By.xpath("(//*[@data-testid = 'price-label-member'])[1]")).isDisplayed()) {
                    assertTrue($$(By.xpath("//*[@data-testid = 'price-label-member']")).size() > 10);
                    for (int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-label-member']")).size(); i++) {
                        $(By.xpath("(//*[@data-testid = 'price-label-member'])[" + i + "]")).shouldHave(text("Member"));
                    }
                } else {
                    assertTrue($$(By.xpath("//*[@data-testid = 'price-label-trade']")).size() > 10);
                    for (int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-label-trade']")).size(); i++) {
                        $(By.xpath("(//*[@data-testid = 'price-label-trade'])[" + i + "]")).shouldHave(text("Trade"));
                    }
                }
                $(By.xpath("(//*[@data-testid = 'price-label-regular'])[1]")).shouldBe(visible, Duration.ofSeconds(10));
                assertTrue($$(By.xpath("//*[@data-testid = 'price-label-regular']")).size() > 10);
                for(int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-label-regular']")).size(); i++) {
                    $(By.xpath("(//*[@data-testid = 'price-label-regular'])[" + i + "]")).shouldHave(text("Regular"));;
                }
                $(By.xpath("(//*[text() = 'VIEW SELECT ITEMS ON SALE'])[1]")).shouldBe(visible, Duration.ofSeconds(20));
                assertTrue($$(By.xpath("//*[text() = 'VIEW SELECT ITEMS ON SALE']")).size() > 10);
                for(int i = 1; i < $$(By.xpath("//*[text() = 'VIEW SELECT ITEMS ON SALE']")).size(); i++) {
                    $(By.xpath("(//*[text() = 'VIEW SELECT ITEMS ON SALE'])[" + i + "]")).shouldHave(text("VIEW SELECT ITEMS ON SALE"));;
                }
                $(By.xpath("(//*[contains(text(), 'Regular')])[1]")).shouldBe(visible, Duration.ofSeconds(10));
                assertTrue($$(By.xpath("//*[contains(text(), 'Regular')]")).size() > 10);
                for(int i = 1; i < $$(By.xpath("//*[contains(text(), 'Regular')]")).size(); i++) {
                    $(By.xpath("(//*[contains(text(), 'Regular')])[" + i + "]")).shouldHave(text("Regular"));;
                }
                if($(By.xpath("(//*[contains(text(), 'Member')])[1]")).isDisplayed()) {
                    assertTrue($$(By.xpath("//*[contains(text(), 'Member')]")).size() > 10);
                    for (int i = 1; i < $$(By.xpath("//*[contains(text(), 'Member')]")).size(); i++) {
                        $(By.xpath("(//*[contains(text(), 'Member')])[" + i + "]")).shouldHave(text("Member"));
                    }
                } else {
                    assertTrue($$(By.xpath("//*[contains(text(), 'Trade')]")).size() > 10);
                    for (int i = 1; i < $$(By.xpath("//*[contains(text(), 'Trade')]")).size(); i++) {
                        $(By.xpath("(//*[contains(text(), 'Trade')])[" + i + "]")).shouldHave(text("Trade"));
                    }
                }
                $(By.xpath("(//button/p[contains(text(), 'SALE')])[1]")).shouldBe(visible, Duration.ofSeconds(10));
                assertTrue($$(By.xpath("//button/p[contains(text(), 'SALE')]")).size() > 10);
                for(int i = 1; i < $$(By.xpath("//button/p[contains(text(), 'SALE')]")).size(); i++) {
                    $(By.xpath("(//button/p[contains(text(), 'SALE')])[" + i + "]")).shouldHave(text("SALE"));;
                }
                break;
            case "user is able to sign out":
                $(By.xpath("//button[@class = 'login-form__submit']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            default: break;
        }
    }

    @Then("I click {string} on PG screen")
    public void iClickOnPGScreen(String button) {
        switch (button) {
            case "Back to Top button":
                $(By.xpath("//*[@class = 'MuiButtonBase-root MuiFab-root' and not(contains(@style, 'hidden'))]")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[@class = 'MuiButtonBase-root MuiFab-root' and not(contains(@style, 'hidden'))]")).click();
                break;
                case "sale checkbox":
                    $(By.xpath("//p[text() = 'sale']")).shouldBe(visible, Duration.ofSeconds(10));
                if(!$(By.xpath("//*[@id = 'component-refine-menu-dropdown']//*[contains(@class, 'Mui-checked')]/following-sibling::span/p[text() = 'sale']")).isDisplayed()){
                    $(By.xpath("//*[@id = 'component-refine-menu-dropdown']//following-sibling::span/p[text() = 'sale']")).click();
                }
                break;
            case "french contemporary washstand collection":
                $(By.xpath("(//*[@id = 'collection-gallery-grid'])[3]")).shouldBe(visible, Duration.ofSeconds(10));
                $(By.xpath("(//*[@id = 'collection-gallery-grid'])[3]")).click();
                break;
            case "on Associate Name":
                $(By.xpath("(//*[text() = 'Automation Associate'])[1]")).should(visible, Duration.ofSeconds(15));
                $(By.xpath("(//*[text() = 'Automation Associate'])[1]")).click();
                break;
            case "on sign out button":
                $(By.xpath("//*[text() = 'SIGN OUT']")).should(visible, Duration.ofSeconds(15));
                $(By.xpath("//*[text() = 'SIGN OUT']")).click();
                break;
            case "Back Browser Button":
                WebDriverRunner.getWebDriver().navigate().back();
                break;
            default: break;
        }
    }
}
