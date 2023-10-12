package tests.concierge.stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.ElementNotFound;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.testng.Assert;
import tests.concierge.pageObject.ConciergeItemsScreen;
import tests.concierge.pageObject.ConciergePGScreen;
import tests.utility.Hooks;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class ConciergePGStepsDefs {

    ConciergeItemsScreen conciergeItemsScreen = new ConciergeItemsScreen();

    public static String result;
    public static List<Integer> beforeSortingRegularItems;
    public static List<Integer> afterSortingRegularItems;
    public static List<Integer> beforeSortingMemberItems;
    public static List<Integer> afterSortingMemberItems;
    public static List<Integer> beforeSortingTradeItems;
    public static List<Integer> afterSortingTradeItems;
    public static List<Integer> beforeSortingSaleItems;
    public static List<Integer> afterSortingSaleItems;
    private static int size;
;
    ConciergePGScreen conciergePGScreen = new ConciergePGScreen();

    @Then("I navigate to menu {string}")
    public void INavigateToMenu(String menu) {
        if(conciergePGScreen.getTopNavManuByName(menu).isDisplayed()){
            conciergePGScreen.getTopNavManuByName(menu).click();
        } else {
            $(By.xpath("//*[contains(text(), '" + menu + "')]")).click();
        }
    }
    @Then("I navigate to sub menu {string}")
    public void INavigateToSubMenu(String subMenu) {
        if(conciergePGScreen.getTopNavSubManuByName(subMenu).isDisplayed()){
            conciergePGScreen.getTopNavSubManuByName(subMenu).hover();
        } else {
            $(By.xpath("//li/span[contains(text(), '" + subMenu + "')]")).hover();
        }
        result = subMenu;
    }
    @Then("I navigate to gallery {string}")
    public void stepByStepINavigateTo(String collection) {
        if(conciergePGScreen.getTopNavGalleryByName(collection).isDisplayed()){
            conciergePGScreen.getTopNavGalleryByName(collection).click();
        } else {
            if(conciergePGScreen.getTopNavSubManuByName(result).isDisplayed()){
                conciergePGScreen.getTopNavSubManuByName(result).click();
            } else {
                $(By.xpath("//span[text() = '" + collection + "']")).click();
            }
        }
        with().pollInterval(5, SECONDS).await().until(() -> true);
        if(!$(By.xpath("(//*[contains(@class, 'MuiTypography-body1')])[1]")).isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
        }
        if(!$(By.xpath("(//*[contains(@class, 'MuiTypography-body1')])[1]")).isDisplayed()){
            WebDriverRunner.getWebDriver().navigate().refresh();
        }
        $(By.xpath("(//*[contains(@class, 'MuiTypography-body1')])[1]")).shouldBe(visible, Duration.ofSeconds(30));
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
                with().pollInterval(5, SECONDS).await().until(() -> true);
                $(By.xpath("//*[@id = 'component-refine-menu-dropdown']//p[text() = 'RESULTS']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("(//*[text() = 'Starting at'])[1]")).shouldBe(visible, Duration.ofSeconds(20));
                for(int i = 1; i < $$(By.xpath("//*[text() = 'Starting at']")).size(); i++) {
                    $(By.xpath("(//*[text() = 'Starting at'])[" + i + "]")).shouldHave(text("Starting at"));
                }
                $(By.xpath("(//*[@id = 'price-label']/following-sibling::p[1])[1]")).shouldBe(visible, Duration.ofSeconds(10));
                for(int i = 1; i < $$(By.xpath("//*[@id = 'price-label']/following-sibling::p[1]")).size(); i++) {
                    $(By.xpath("(//*[@id = 'price-label']/following-sibling::p[1])[" + i + "]")).shouldHave(text(" / "));
                }
                if($(By.xpath("(//*[@data-testid = 'price-for-member'])[1]")).isDisplayed()) {
                    for (int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-for-member']")).size(); i++) {
                        $(By.xpath("(//*[@data-testid = 'price-for-member'])[" + i + "]")).shouldHave(text("$"));
                    }
                } else {
                    for (int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-for-trade']")).size(); i++) {
                        $(By.xpath("(//*[@data-testid = 'price-for-trade'])[" + i + "]")).shouldHave(text("$"));
                    }
                }
                $(By.xpath("(//*[@data-testid = 'price-for-sale'])[1]")).shouldBe(visible, Duration.ofSeconds(10));
                for(int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-for-sale']")).size(); i++) {
                    $(By.xpath("(//*[@data-testid = 'price-for-sale'])[" + i + "]")).shouldHave(text("$"));;
                }
                $(By.xpath("(//*[@data-testid = 'price-for-regular'])[1]")).shouldBe(visible, Duration.ofSeconds(10));
                for(int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-for-regular']")).size(); i++) {
                    $(By.xpath("(//*[@data-testid = 'price-for-regular'])[" + i + "]")).shouldHave(text("$"));;
                }
                if( $(By.xpath("(//*[@data-testid = 'price-label-member'])[1]")).isDisplayed()) {
                    for (int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-label-member']")).size(); i++) {
                        $(By.xpath("(//*[@data-testid = 'price-label-member'])[" + i + "]")).shouldHave(text("Member"));
                    }
                } else {
                    for (int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-label-trade']")).size(); i++) {
                        $(By.xpath("(//*[@data-testid = 'price-label-trade'])[" + i + "]")).shouldHave(text("Trade"));
                    }
                }
                $(By.xpath("(//*[@data-testid = 'price-label-regular'])[1]")).shouldBe(visible, Duration.ofSeconds(10));
                for(int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-label-regular']")).size(); i++) {
                    $(By.xpath("(//*[@data-testid = 'price-label-regular'])[" + i + "]")).shouldHave(text("Regular"));
                }
//                $(By.xpath("(//*[text() = 'VIEW SELECT ITEMS ON SALE'])[1]")).shouldBe(visible, Duration.ofSeconds(20));
//                assertTrue($$(By.xpath("//*[text() = 'VIEW SELECT ITEMS ON SALE']")).size() > 10);
//                for(int i = 1; i < $$(By.xpath("//*[text() = 'VIEW SELECT ITEMS ON SALE']")).size(); i++) {
//                    $(By.xpath("(//*[text() = 'VIEW SELECT ITEMS ON SALE'])[" + i + "]")).shouldHave(text("VIEW SELECT ITEMS ON SALE"));
//                }
                $(By.xpath("(//*[contains(text(), 'Regular')])[2]")).shouldBe(visible, Duration.ofSeconds(10));
                for(int i = 2; i < $$(By.xpath("//*[contains(text(), 'Regular')]")).size(); i++) {
                    $(By.xpath("(//*[contains(text(), 'Regular')])[" + i + "]")).shouldHave(text("Regular"));
                }
                if($(By.xpath("(//*[contains(text(), 'Member')])[2]")).isDisplayed()) {
                    for (int i = 2; i < $$(By.xpath("//*[contains(text(), 'Member')]")).size(); i++) {
                        $(By.xpath("(//*[contains(text(), 'Member')])[" + i + "]")).shouldHave(text("Member"));
                    }
                } else {
                    for (int i = 2; i < $$(By.xpath("//*[contains(text(), 'Trade')]")).size(); i++) {
                        $(By.xpath("(//*[contains(text(), 'Trade')])[" + i + "]")).shouldHave(text("Trade"));
                    }
                }
//                $(By.xpath("(//button/p[contains(text(), 'SALE')])[1]")).shouldBe(visible, Duration.ofSeconds(10));
//                assertTrue($$(By.xpath("//button/p[contains(text(), 'SALE')]")).size() > 10);
//                for(int i = 1; i < $$(By.xpath("//button/p[contains(text(), 'SALE')]")).size(); i++) {
//                    $(By.xpath("(//button/p[contains(text(), 'SALE')])[" + i + "]")).shouldHave(text("SALE"));
//                }
                for(int i = 1; i < $$(By.xpath("//*[@id = 'rh-price-range-display']/..//p/span")).size(); i++) {
                    $(By.xpath("(//*[@id = 'rh-price-range-display']/..//p/span)[" + i + "]")).shouldBe(visible, Duration.ofSeconds(20));
                }
//                $(By.xpath("(//*[@id = 'rh-price-range-display']/..//p/span)[1]")).shouldBe(visible, Duration.ofSeconds(10));
                break;
            case "Verify that all products have text Frame $ / $ Sale / $ Member":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                $(By.xpath("//*[@id = 'component-refine-menu-dropdown']//p[text() = 'RESULTS']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("(//*[contains(text(), 'Starting at')])[1]")).shouldBe(visible, Duration.ofSeconds(20));
                for(int i = 1; i < $$(By.xpath("//*[contains(text(), 'tarting at')]")).size(); i++) {
                    $(By.xpath("(//*[contains(text(), 'tarting at')])[" + i + "]")).shouldHave(text("tarting at"));
                }
                $(By.xpath("(//*[@id = 'price-label']/following-sibling::p[1])[1]")).shouldBe(visible, Duration.ofSeconds(10));
                for(int i = 1; i < $$(By.xpath("//*[@id = 'price-label']/following-sibling::p[1]")).size(); i++) {
                    $(By.xpath("(//*[@id = 'price-label']/following-sibling::p[1])[" + i + "]")).shouldHave(text(" / "));
                }
                if($(By.xpath("(//*[@data-testid = 'price-for-member'])[1]")).isDisplayed()) {
                    for (int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-for-member']")).size(); i++) {
                        $(By.xpath("(//*[@data-testid = 'price-for-member'])[" + i + "]")).shouldHave(text("$"));
                    }
                } else {
                    for (int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-for-trade']")).size(); i++) {
                        $(By.xpath("(//*[@data-testid = 'price-for-trade'])[" + i + "]")).shouldHave(text("$"));
                    }
                }
                $(By.xpath("(//*[@data-testid = 'price-for-sale'])[1]")).shouldBe(visible, Duration.ofSeconds(10));
                for(int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-for-sale']")).size(); i++) {
                    $(By.xpath("(//*[@data-testid = 'price-for-sale'])[" + i + "]")).shouldHave(text("$"));;
                }
                $(By.xpath("(//*[@data-testid = 'price-for-regular'])[1]")).shouldBe(visible, Duration.ofSeconds(10));
                for(int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-for-regular']")).size(); i++) {
                    $(By.xpath("(//*[@data-testid = 'price-for-regular'])[" + i + "]")).shouldHave(text("$"));;
                }
                if( $(By.xpath("(//*[@data-testid = 'price-label-member'])[1]")).isDisplayed()) {
                    for (int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-label-member']")).size(); i++) {
                        $(By.xpath("(//*[@data-testid = 'price-label-member'])[" + i + "]")).shouldHave(text("Member"));
                    }
                } else {
                    for (int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-label-trade']")).size(); i++) {
                        $(By.xpath("(//*[@data-testid = 'price-label-trade'])[" + i + "]")).shouldHave(text("Trade"));
                    }
                }
                $(By.xpath("(//*[@data-testid = 'price-label-regular'])[1]")).shouldBe(visible, Duration.ofSeconds(10));
                for(int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-label-regular']")).size(); i++) {
                    $(By.xpath("(//*[@data-testid = 'price-label-regular'])[" + i + "]")).shouldHave(text("Regular"));
                }
//                $(By.xpath("(//*[text() = 'VIEW SELECT ITEMS ON SALE'])[1]")).shouldBe(visible, Duration.ofSeconds(20));
//                assertTrue($$(By.xpath("//*[text() = 'VIEW SELECT ITEMS ON SALE']")).size() > 10);
//                for(int i = 1; i < $$(By.xpath("//*[text() = 'VIEW SELECT ITEMS ON SALE']")).size(); i++) {
//                    $(By.xpath("(//*[text() = 'VIEW SELECT ITEMS ON SALE'])[" + i + "]")).shouldHave(text("VIEW SELECT ITEMS ON SALE"));
//                }
                $(By.xpath("(//*[contains(text(), 'Regular')])[2]")).shouldBe(visible, Duration.ofSeconds(10));
                for(int i = 2; i < $$(By.xpath("//*[contains(text(), 'Regular')]")).size(); i++) {
                    $(By.xpath("(//*[contains(text(), 'Regular')])[" + i + "]")).shouldHave(text("Regular"));
                }
                if($(By.xpath("(//*[contains(text(), 'Member')])[2]")).isDisplayed()) {
                    for (int i = 2; i < $$(By.xpath("//*[contains(text(), 'Member')]")).size(); i++) {
                        $(By.xpath("(//*[contains(text(), 'Member')])[" + i + "]")).shouldHave(text("Member"));
                    }
                } else {
                    for (int i = 2; i < $$(By.xpath("//*[contains(text(), 'Trade')]")).size(); i++) {
                        $(By.xpath("(//*[contains(text(), 'Trade')])[" + i + "]")).shouldHave(text("Trade"));
                    }
                }
//                $(By.xpath("(//button/p[contains(text(), 'SALE')])[1]")).shouldBe(visible, Duration.ofSeconds(10));
//                assertTrue($$(By.xpath("//button/p[contains(text(), 'SALE')]")).size() > 10);
//                for(int i = 1; i < $$(By.xpath("//button/p[contains(text(), 'SALE')]")).size(); i++) {
//                    $(By.xpath("(//button/p[contains(text(), 'SALE')])[" + i + "]")).shouldHave(text("SALE"));
//                }
                for(int i = 1; i < $$(By.xpath("//*[@id = 'rh-price-range-display']/..//p/span")).size(); i++) {
                    $(By.xpath("(//*[@id = 'rh-price-range-display']/..//p/span)[" + i + "]")).shouldBe(visible, Duration.ofSeconds(20));
                }
//                $(By.xpath("(//*[@id = 'rh-price-range-display']/..//p/span)[1]")).shouldBe(visible, Duration.ofSeconds(10));
                break;
            case "user is able to sign out":
                $(By.xpath("//button[@class = 'login-form__submit']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "grid view is set to 1-grid view":
                $(By.xpath("//*[ local-name() = 'svg' and @column = '1' and @data-active = 'true']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "grid view is set to 2-grid view":
                $(By.xpath("//*[ local-name() = 'svg' and @column = '2' and @data-active = 'true']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "grid view is set to 3-grid view":
                $(By.xpath("//*[ local-name() = 'svg' and @column = '3' and @data-active = 'true']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "Dashboard is displayed":
                $(By.xpath("//*[text() = 'Concierge']/following-sibling::h1[text() = 'Dashboard']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "CG is displayed":
                $(By.xpath("(//*[@id = 'collection-gallery-grid'])[1]")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "PG is displayed":
                $(By.xpath("(//*[@id = 'component-rh-image'])[1]")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "PG has SALE and IN-STOCK filters, text RESULTS (n), faucet with text SORT":
                $(By.xpath("//*[@id = 'refinementOptionData_checkbox-Sale']//p[text() = 'sale']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[@id = 'refinementOptionData_checkbox-In-Stock']//p[text() = 'in-stock']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'brand ss']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'RESULTS']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'sort']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'Featured']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "IN-STOCK products are returned":
                with().pollInterval(9, SECONDS).await().until(() -> true);
                for(int i = 1; i <= 46; i++) {
                        $(By.xpath("(//*[@id = 'listColumn1-Finish'])[" + i + "]")).scrollIntoView(true);
                        $(By.xpath("(//*[@id = 'listColumn1-Finish'])[" + i + "]")).shouldHave(text("Finish"));
                        $(By.xpath("(//*[@id = 'listColumn2-Finish'])[" + i + "]")).shouldBe(visible, Duration.ofSeconds(20));
                        $(By.xpath("(//*[@id = 'listColumn1-Size'])[" + i + "]")).shouldHave(text("Size"));
                        $(By.xpath("(//*[@id = 'listColumn2-Size'])[" + i + "]")).shouldBe(visible, Duration.ofSeconds(20));

                }
                break;
            case "CLEAR ALL is present when filter(s) are selected":
                $(By.xpath("//*[@id = 'refineMenuDropdown_clear-In-Stock-btn']")).shouldHave(text("in-stock"));
            $(By.xpath("//*[@id = 'refineMenuDropdown_clearAll-btn']")).shouldHave(text("Clear All"));
            break;
            case "all products returned have $ SALE price in their descriptions":
                $(By.xpath("//*[@id = 'component-refine-menu-dropdown']//p[text() = 'RESULTS']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("(//*[text() = 'Starting at'])[1]")).shouldBe(visible, Duration.ofSeconds(20));
                for(int i = 1; i < $$(By.xpath("//*[text() = 'Starting at']")).size(); i++) {
                    $(By.xpath("(//*[text() = 'Starting at'])[" + i + "]")).shouldHave(text("Starting at"));
                }
                $(By.xpath("(//*[@id = 'price-label']/following-sibling::p[1])[1]")).shouldBe(visible, Duration.ofSeconds(10));
                for(int i = 1; i < $$(By.xpath("//*[@id = 'price-label']/following-sibling::p[1]")).size(); i++) {
                    $(By.xpath("(//*[@id = 'price-label']/following-sibling::p[1])[" + i + "]")).shouldHave(text(" / "));;
                }
                if($(By.xpath("(//*[@data-testid = 'price-for-member'])[1]")).isDisplayed()) {
                    for (int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-for-member']")).size(); i++) {
                        $(By.xpath("(//*[@data-testid = 'price-for-member'])[" + i + "]")).shouldHave(text("$"));
                    }
                } else {
                    for (int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-for-trade']")).size(); i++) {
                        $(By.xpath("(//*[@data-testid = 'price-for-trade'])[" + i + "]")).shouldHave(text("$"));
                    }
                }
                $(By.xpath("(//*[@data-testid = 'price-for-sale'])[1]")).shouldBe(visible, Duration.ofSeconds(10));
                for(int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-for-sale']")).size(); i++) {
                    $(By.xpath("(//*[@data-testid = 'price-for-sale'])[" + i + "]")).shouldHave(text("$"));;
                }
                $(By.xpath("(//*[@data-testid = 'price-for-regular'])[1]")).shouldBe(visible, Duration.ofSeconds(10));
                for(int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-for-regular']")).size(); i++) {
                    $(By.xpath("(//*[@data-testid = 'price-for-regular'])[" + i + "]")).shouldHave(text("$"));;
                }
                if( $(By.xpath("(//*[@data-testid = 'price-label-member'])[1]")).isDisplayed()) {
                    for (int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-label-member']")).size(); i++) {
                        $(By.xpath("(//*[@data-testid = 'price-label-member'])[" + i + "]")).shouldHave(text("Member"));
                    }
                } else {
                    for (int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-label-trade']")).size(); i++) {
                        $(By.xpath("(//*[@data-testid = 'price-label-trade'])[" + i + "]")).shouldHave(text("Trade"));
                    }
                }
                $(By.xpath("(//*[@data-testid = 'price-label-regular'])[1]")).shouldBe(visible, Duration.ofSeconds(10));
                for(int i = 1; i < $$(By.xpath("//*[@data-testid = 'price-label-regular']")).size(); i++) {
                    $(By.xpath("(//*[@data-testid = 'price-label-regular'])[" + i + "]")).shouldHave(text("Regular"));;
                }
                $(By.xpath("(//*[contains(text(), 'Regular')])[2]")).shouldBe(visible, Duration.ofSeconds(10));
                for(int i = 2; i < $$(By.xpath("//*[contains(text(), 'Regular')]")).size(); i++) {
                    $(By.xpath("(//*[contains(text(), 'Regular')])[" + i + "]")).shouldHave(text("Regular"));;
                }
                if($(By.xpath("(//*[contains(text(), 'Member')])[2]")).isDisplayed()) {
                    for (int i = 2; i < $$(By.xpath("//*[contains(text(), 'Member')]")).size(); i++) {
                        $(By.xpath("(//*[contains(text(), 'Member')])[" + i + "]")).shouldHave(text("Member"));
                    }
                } else {
                    assertTrue($$(By.xpath("//*[contains(text(), 'Trade')]")).size() > 10);
                    for (int i = 2; i < $$(By.xpath("//*[contains(text(), 'Trade')]")).size(); i++) {
                        $(By.xpath("(//*[contains(text(), 'Trade')])[" + i + "]")).shouldHave(text("Trade"));
                    }
                }
//                $(By.xpath("(//button/p[contains(text(), 'Sale')])[1]")).shouldBe(visible, Duration.ofSeconds(10));
//                assertTrue($$(By.xpath("//button/p[contains(text(), 'Sale')]")).size() >= count);
//                for(int i = 1; i < $$(By.xpath("//button/p[contains(text(), 'Sale')]")).size(); i++) {
//                    $(By.xpath("(//button/p[contains(text(), 'Sale')])[" + i + "]")).shouldHave(text("Sale"));;
//                }
//                $(By.xpath("(//*[@id = 'rh-price-range-display']/..//span)[5]")).shouldBe(visible, Duration.ofSeconds(10));
                break;
            case "PG has filters: IN-STOCK, SALE, SIZE, SHAPE, BRAND, RESULTS and SORT is present":
                $(By.xpath("//*[@id = 'refinementOptionData_checkbox-Sale']//p[text() = 'sale']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[@id = 'refinementOptionData_checkbox-In-Stock']//p[text() = 'in-stock']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'Shape']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'Size']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'brand ss']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'RESULTS']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'sort']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "text on banner SAVE UP TO 70% AS AN RH MEMBER":
                $(By.xpath("//h4[text() = 'SAVE UP TO 75% OFF SELECT ITEMS']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//h4[text() = 'WITH RH MEMBERSHIP']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "PG has filters: IN-STOCK, SALE, SIZE, MATERIAL, BRAND, RESULTS and SORT is present":
                $(By.xpath("//*[@id = 'refinementOptionData_checkbox-Sale']//p[text() = 'sale']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[@id = 'refinementOptionData_checkbox-In-Stock']//p[text() = 'in-stock']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'Size']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'Material']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'brand ss']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'RESULTS']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'sort']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "PG has filters: CONCEPTS, IN-STOCK, SALE, BRAND, RESULTS and SORT is present":
                $(By.xpath("//*[text() = 'CONCEPTS']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[@id = 'refinementOptionData_checkbox-Sale']//p[text() = 'sale']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[@id = 'refinementOptionData_checkbox-In-Stock']//p[text() = 'in-stock']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'new arrivals']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'brand ss']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'RESULTS']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'sort']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "CONCEPT dropdown returns various RH Brands":
                $(By.xpath("//*[text() = 'CONCEPTS']")).click();
                List<String> rhExpectedItems = new ArrayList(Arrays.asList("RH", "RH INTERIORS", "RH MODERN", "RH OUTDOOR", "RH BEACH HOUSE", "RH SKI HOUSE", "RH BABY & CHILD", "RH TEEN", "RH CONTEMPORARY"));
                $$(By.xpath("//*[@class = 'MuiList-root']//p")).size();
                for (int i = 1; i <= $$(By.xpath("//*[@class = 'MuiList-root']//p")).size(); i++) {
                       assertEquals(rhExpectedItems.get(i-1), $(By.xpath("(//*[@class = 'MuiList-root']//p)[" + i + "]")).getText());
                }
                break;
            case "Italian Travertine Plinth Rectangular Fire Table is returned":
                $(By.xpath("//*[text() = 'Caprera Concrete Rectangular Coffee Table']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "user can select SIZE -> Length -> 30 and respective products are returned":
                $(By.xpath("//*[text() = 'Size']")).click();
                $(By.xpath("//*[text() = 'Length']")).click();
                $(By.xpath("(//*[contains(text(), '30\" ')])[1]")).click();
                $(By.xpath("(//*[text() = 'Size'])[2]")).click();
                $(By.xpath("//*[text() = '30\"']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'Length']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            default: break;
        }
    }

    @When("I verify that PG loads")
    public void IConfirmThatPGLoads() {
        if($(By.xpath("(//*[@id = 'component-rh-image_wrapper'])[1]")).isDisplayed()){
            $(By.xpath("//*[ local-name() = 'svg' and @column = '3']")).shouldBe(visible, Duration.ofSeconds(20));
            $(By.xpath("//*[ local-name() = 'svg' and @column = '3']")).click();
            $(By.xpath("//*[ local-name() = 'svg' and @column = '3' and @data-active = 'true']")).shouldBe(visible, Duration.ofSeconds(20));
            if(!$(By.xpath("//*[@id = 'footer']")).isDisplayed()){
                WebDriverRunner.getWebDriver().navigate().refresh();
            }
            while (!$$(By.xpath("//*[@id = 'component-rh-image_wrapper']")).last().isDisplayed()){
                $$(By.xpath("//*[@id = 'component-rh-image_wrapper']")).last().scrollIntoView(true);
                with().pollInterval(2, SECONDS).await().until(() -> true);
            }
            $$(By.xpath("//*[@id = 'component-rh-image_wrapper']")).last().shouldBe(visible, Duration.ofSeconds(20));
            $(By.xpath("//*[@id = 'footer']")).shouldBe(visible, Duration.ofSeconds(20));
        } else {
            if(!$(By.xpath("//*[@id = 'component-refine-menu-dropdown']//p[text() = 'RESULTS']")).isDisplayed()){
                WebDriverRunner.getWebDriver().navigate().refresh();
            }
            $(By.xpath("//*[@id = 'component-refine-menu-dropdown']//p[text() = 'RESULTS']")).shouldBe(visible, Duration.ofSeconds(20));
            $(By.xpath("(//*[@id = 'flip-carousel-div']//img)[1]")).shouldBe(visible, Duration.ofSeconds(20));
            if(!$(By.xpath("//*[@id = 'footer']")).isDisplayed()){
                WebDriverRunner.getWebDriver().navigate().refresh();
            }
            if($(By.xpath("//*[@id = 'itemsPerPage']")).isDisplayed()){
                while (!$(By.xpath("//*[@id = 'itemsPerPage']")).getText().equals("Load All")) {
                    $(By.xpath("//*[@id = 'itemsPerPage']")).scrollIntoView(true);
                        with().pollInterval(5, SECONDS).await().until(() -> true);
                        $(By.xpath("//*[@id = 'itemsPerPage']")).scrollIntoView(true);
                        $(By.xpath("//*[@id = 'itemsPerPage']")).click();
                        $(By.xpath("//*[text() = 'Load All']")).click();
                        with().pollInterval(5, SECONDS).await().until(() -> true);
                        $(By.xpath("//*[@id = 'itemsPerPage']")).scrollIntoView(true);
                        $(By.xpath("//*[text() = 'Items per page']")).shouldBe(visible, Duration.ofSeconds(20));
                    }
                } else {
                while (!$$(By.xpath("//*[@id = 'flip-carousel-div']//img")).last().isDisplayed()){
                    $$(By.xpath("//*[@id = 'flip-carousel-div']//img")).last().scrollIntoView(true);
                    with().pollInterval(2, SECONDS).await().until(() -> true);
                }
            }

            $$(By.xpath("//*[@id = 'flip-carousel-div']//img")).last().shouldBe(visible, Duration.ofSeconds(20));
            $(By.xpath("//*[@id = 'footer']")).shouldBe(visible, Duration.ofSeconds(20));
        }
    }

    @When("I verify that page loads")
    public void IConfirmThatPageLoads() {
        if ($(By.xpath("(//*[@id = 'component-rh-image_wrapper'])[1]")).isDisplayed()) {
            $(By.xpath("//*[ local-name() = 'svg' and @column = '3']")).shouldBe(visible, Duration.ofSeconds(20));
            $(By.xpath("//*[ local-name() = 'svg' and @column = '3']")).click();
            $(By.xpath("//*[ local-name() = 'svg' and @column = '3' and @data-active = 'true']")).shouldBe(visible, Duration.ofSeconds(20));
            if (!$(By.xpath("//*[@id = 'footer']")).isDisplayed()) {
                WebDriverRunner.getWebDriver().navigate().refresh();
            }
            if($(By.xpath("//*[@id = 'itemsPerPage']")).isDisplayed()){
                while (!$(By.xpath("//*[@id = 'itemsPerPage']")).getText().equals("Load All")) {
                    $(By.xpath("//*[@id = 'itemsPerPage']")).scrollIntoView(true);
                    with().pollInterval(5, SECONDS).await().until(() -> true);
                    $(By.xpath("//*[@id = 'itemsPerPage']")).scrollIntoView(true);
                    $(By.xpath("//*[@id = 'itemsPerPage']")).click();
                    $(By.xpath("//*[text() = 'Load All']")).click();
                    with().pollInterval(5, SECONDS).await().until(() -> true);
                    $(By.xpath("//*[@id = 'itemsPerPage']")).scrollIntoView(true);
                    $(By.xpath("//*[text() = 'Items per page']")).shouldBe(visible, Duration.ofSeconds(20));
                }
            } else {
                while (!$$(By.xpath("//*[@id = 'flip-carousel-div']//img")).last().isDisplayed()){
                    $$(By.xpath("//*[@id = 'flip-carousel-div']//img")).last().scrollIntoView(true);
                    with().pollInterval(5, SECONDS).await().until(() -> true);
                }
            }
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
                    with().pollInterval(9, SECONDS).await().until(() -> true);
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
            case "first collection from the list":
                $(By.xpath("(//*[@id = 'collection-gallery-grid'])[1]")).click();
                break;
            case "first product from the list":
                $(By.xpath("(//*[@id = 'component-rh-image'])[1]")).click();
                break;
            case "SORT and confirm that Modal has text FEATURED, Price Low to High, Price High to Low":
                $(By.xpath("//*[text() = 'sort']")).click();
                $(By.xpath("(//*[text() = 'Featured'])[2]")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'Price Low to High']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text() = 'Price High to Low']")).shouldBe(visible, Duration.ofSeconds(20));
                $(By.xpath("(//*[text() = 'Featured'])[2]")).click();
                break;
            case "Price Low to High and verify price is sorted":
                with().pollInterval(5, SECONDS).await().until(() -> true);
                IConfirmThatPageLoads();
                beforeSortingRegularItems =  $$(By.xpath("//*[@data-testid = 'price-for-regular']")).stream()
                        .map(SelenideElement::getText)
                        .map(x -> x.replaceAll("[^0-9]", ""))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

//                beforeSortingSaleItems = $$(By.xpath("//*[@data-testid = 'price-for-sale']")).stream()
//                        .map(SelenideElement::getText)
//                        .map(x -> x.replaceAll("[^0-9]", ""))
//                        .map(Integer::parseInt)
//                        .collect(Collectors.toList());

//                if($(By.xpath("(//*[@data-testid = 'price-for-member'])[1]")).isDisplayed()){
//                    beforeSortingMemberItems = $$(By.xpath("//*[@data-testid = 'price-for-member']")).stream()
//                            .map(SelenideElement::getText)
//                            .map(x -> x.replaceAll("[^0-9]", ""))
//                            .map(Integer::parseInt)
//                            .collect(Collectors.toList());
//                } else {
//                    beforeSortingTradeItems = $$(By.xpath("//*[@data-testid = 'price-for-trade']")).stream()
//                            .map(SelenideElement::getText)
//                            .map(x -> x.replaceAll("[^0-9]", ""))
//                            .map(Integer::parseInt)
//                            .collect(Collectors.toList());
//                }
                $(By.xpath("//*[text() = 'sort']")).click();
                $(By.xpath("//*[text() = 'Price Low to High']")).click();
                with().pollInterval(5, SECONDS).await().until(() -> true);
                IConfirmThatPageLoads();
                afterSortingRegularItems = $$(By.xpath("//*[@data-testid = 'price-for-regular']")).stream()
                        .map(SelenideElement::getText)
                        .map(x -> x.replaceAll("[^0-9]", ""))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                assertEquals(beforeSortingRegularItems.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()), afterSortingRegularItems);

//                afterSortingSaleItems = $$(By.xpath("//*[@data-testid = 'price-for-sale']")).stream()
//                        .map(SelenideElement::getText)
//                        .map(x -> x.replaceAll("[^0-9]", ""))
//                        .map(Integer::parseInt)
//                        .collect(Collectors.toList());
//                assertEquals(beforeSortingSaleItems.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()), afterSortingSaleItems);
//
//                if($(By.xpath("(//*[@data-testid = 'price-for-member'])[1]")).isDisplayed()){
//                    afterSortingMemberItems = $$(By.xpath("//*[@data-testid = 'price-for-member']")).stream()
//                            .map(SelenideElement::getText)
//                            .map(x -> x.replaceAll("[^0-9]", ""))
//                            .map(Integer::parseInt)
//                            .collect(Collectors.toList());
//                    assertEquals(beforeSortingMemberItems.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()), afterSortingMemberItems);
//                } else {
//                    afterSortingTradeItems = $$(By.xpath("//*[@data-testid = 'price-for-trade']")).stream()
//                            .map(SelenideElement::getText)
//                            .map(x -> x.replaceAll("[^0-9]", ""))
//                            .map(Integer::parseInt)
//                            .collect(Collectors.toList());
//                    assertEquals(beforeSortingTradeItems.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()), afterSortingTradeItems);
//                }
                break;
            case "Price High to Low and verify price is sorted":
                $(By.xpath("//*[text() = 'sort']")).click();
                $(By.xpath("//*[text() = 'Featured']")).click();
                with().pollInterval(5, SECONDS).await().until(() -> true);
                IConfirmThatPageLoads();
                beforeSortingRegularItems =  $$(By.xpath("//*[@data-testid = 'price-for-regular']")).stream()
                        .map(SelenideElement::getText)
                        .map(x -> x.replaceAll("[^0-9]", ""))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

//                beforeSortingSaleItems = $$(By.xpath("//*[@data-testid = 'price-for-sale']")).stream()
//                        .map(SelenideElement::getText)
//                        .map(x -> x.replaceAll("[^0-9]", ""))
//                        .map(Integer::parseInt)
//                        .collect(Collectors.toList());
//
//                if($(By.xpath("(//*[@data-testid = 'price-for-member'])[1]")).isDisplayed()){
//                    beforeSortingMemberItems = $$(By.xpath("//div[2]/p[@data-testid = 'price-for-member']")).stream()
//                            .map(SelenideElement::getText)
//                            .map(x -> x.replaceAll("[^0-9]", ""))
//                            .map(Integer::parseInt)
//                            .collect(Collectors.toList());
//                } else {
//                    beforeSortingTradeItems = $$(By.xpath("//div[2]/p[@data-testid = 'price-for-trade']")).stream()
//                            .map(SelenideElement::getText)
//                            .map(x -> x.replaceAll("[^0-9]", ""))
//                            .map(Integer::parseInt)
//                            .collect(Collectors.toList());
//                }
                $(By.xpath("//*[text() = 'sort']")).click();
                executeJavaScript("arguments[0].click();", $(By.xpath("//*[text() = 'Price High to Low']")));
                with().pollInterval(5, SECONDS).await().until(() -> true);
                IConfirmThatPageLoads();
                afterSortingRegularItems = $$(By.xpath("//*[@data-testid = 'price-for-regular']")).stream()
                        .map(SelenideElement::getText)
                        .map(x -> x.replaceAll("[^0-9]", ""))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                assertEquals(beforeSortingRegularItems.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()), afterSortingRegularItems);

//                afterSortingSaleItems = $$(By.xpath("//*[@data-testid = 'price-for-sale']")).stream()
//                        .map(SelenideElement::getText)
//                        .map(x -> x.replaceAll("[^0-9]", ""))
//                        .map(Integer::parseInt)
//                        .collect(Collectors.toList());
//                assertEquals(beforeSortingSaleItems.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()), afterSortingSaleItems);
//
//                if($(By.xpath("(//*[@data-testid = 'price-for-member'])[1]")).isDisplayed()){
//                    afterSortingMemberItems = $$(By.xpath("//div[2]/p[@data-testid = 'price-for-member']")).stream()
//                            .map(SelenideElement::getText)
//                            .map(x -> x.replaceAll("[^0-9]", ""))
//                            .map(Integer::parseInt)
//                            .collect(Collectors.toList());
//                    assertEquals(beforeSortingMemberItems.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()), afterSortingMemberItems);
//                } else {
//                    afterSortingTradeItems = $$(By.xpath("//div[2]/p[@data-testid = 'price-for-trade']")).stream()
//                            .map(SelenideElement::getText)
//                            .map(x -> x.replaceAll("[^0-9]", ""))
//                            .map(Integer::parseInt)
//                            .collect(Collectors.toList());
//                    assertEquals(beforeSortingTradeItems.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()), afterSortingTradeItems);
//                }
                break;
            case "IN-STOCK Filter":
                $(By.xpath("//*[@id = 'refinementOptionData_checkbox-In-Stock']//p[text() = 'in-stock']")).click();
                break;
            case "RH Outdoor":
                $(By.xpath("//*[@class = 'MuiList-root']//p[text() = 'RH OUTDOOR']")).click();
                break;
            default: break;
        }
    }

    @Then("I Change the PG Grid view to {string} - grid view and confirm changing")
    public void iChangeThePGGridAndConfirmChanging(String view) {
        $(By.xpath("//*[ local-name() = 'svg' and @column = '" + view + "']")).click();
        $(By.xpath("//*[ local-name() = 'svg' and @column = '" + view + "' and @data-active = 'true']")).shouldBe(visible, Duration.ofSeconds(20));
        if(view.equals("1")) {
            int i = 1;
            with().pollInterval(1, SECONDS).await().until(() -> true);
            while (!$(By.xpath("//*[@class = 'MuiButtonBase-root MuiFab-root' and not(contains(@style, 'hidden'))]")).isDisplayed()) {
                with().pollInterval(1, SECONDS).await().until(() -> true);
                $(By.xpath("(//*[@id='component-rh-image'])[" + i + "]")).scrollIntoView(true);
                i++;
                with().pollInterval(1, SECONDS).await().until(() -> true);
            }
            assertEquals(3, i);
        }
        if(view.equals("2")){
            int i = 1;
            while (!$(By.xpath("//*[@class = 'MuiButtonBase-root MuiFab-root' and not(contains(@style, 'hidden'))]")).isDisplayed()) {
                $(By.xpath("(//*[@id='component-rh-image'])[" + i + "]")).scrollIntoView(true);
                i++;
                with().pollInterval(1, SECONDS).await().until(() -> true);
            }
            assertEquals(2, i);
        }
        if(view.equals("3")){
            int i = 1;
            with().pollInterval(1, SECONDS).await().until(() -> true);
            while (!$(By.xpath("//*[@class = 'MuiButtonBase-root MuiFab-root' and not(contains(@style, 'hidden'))]")).isDisplayed()) {
                with().pollInterval(1, SECONDS).await().until(() -> true);
                $(By.xpath("(//*[@id='component-rh-image'])[" + i + "]")).scrollIntoView(true);
                i++;
                with().pollInterval(1, SECONDS).await().until(() -> true);
            }
            assertEquals(2, i);
        }
    }

    @When("I open product page with {string}")
    public void iOpenProductPageWithAnd(String productId) {
        String URL = Hooks.conciergeBaseURL + "/catalog/product/product.jsp?productId=" + productId + "";
        open(URL);
        conciergeItemsScreen.getAddToCartButton().scrollTo();
        conciergeItemsScreen.getAddToCartButton().should(visible, Duration.ofSeconds(10));
    }

    @When("I verify that {string} title is present in PG top left")
    public void iVerifyThatTitleIsPresentInPGTopLeft(String title) {
        $(By.xpath("//*[contains(@class, 'MuiTypography-body1') and text() = '" + title + "']")).should(visible, Duration.ofSeconds(10));
    }


    @Then("I Verify i return to {string} PG page")
    public void iVerifyireturntopgpage(String title){
        Assert.assertEquals(title.toLowerCase(), $(By.xpath("//*[text() = '" + title + "']")).getText().toLowerCase());
        conciergePGScreen.getResult().should(Condition.visible, Duration.ofSeconds(15));
        conciergePGScreen.getSort().should(Condition.visible, Duration.ofSeconds(15));
    }
}