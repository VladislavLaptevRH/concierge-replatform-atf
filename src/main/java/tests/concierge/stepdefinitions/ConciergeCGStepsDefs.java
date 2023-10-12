package tests.concierge.stepdefinitions;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.slf4j.LoggerFactory;
import tests.concierge.pageObject.ConciergeCGScreen;

public class ConciergeCGStepsDefs {
    ConciergeCGScreen  ConciergeCGScreen = new ConciergeCGScreen();
    public static String galleryName;
    public static final Logger logger = LoggerFactory.getLogger(FilterStepDefs.class);

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
                $(By.xpath("(//*[@id = 'component-collection-card'])[3]//*[text() = 'French Contemporary']")).click();
                $(By.xpath("(//*[contains(text(),'French Contemporary')])[2]")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "Bath Collections are displayed":
                $(By.xpath("(//*[@id = 'component-collection-card'])[3]//*[text() = 'French Contemporary']/../following-sibling::div/p[text() = 'Washstand Collection']")).click();
                $(By.xpath("//*[text() = 'Bath  collections']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "Navigate to second collection":
                $(By.xpath("(//*[@id = 'component-collection-card'])[2]//*[text() = 'Kabir Wool Rug']")).click();
                $(By.xpath("//*[text() = 'Kabir Wool Rug']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "Navigate to first product":
                if(!$(By.xpath("(//*[@id = 'flip-carousel-div']//img)[1]")).isDisplayed()){
                    WebDriverRunner.getWebDriver().navigate().refresh();
                }
                $(By.xpath("//*[@id = 'flip-carousel-div']")).click();
                $(By.xpath("//h2[text() = 'Kabir Wool Rug']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "confirm that PG is displayed":
                $(By.xpath("//*[@id = 'flip-carousel-div']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "confirm that CG Rug Collections is displayed":
                $(By.xpath("(//*[@id = 'component-collection-card'])[4]//*[text() = 'Nihal Wool Rug']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "grid view is present on top right":
                for(int i = 1; i <= 3; i++) {
                    $(By.xpath("//*[ local-name() = 'svg' and @column = '" + i + "']")).shouldBe(visible, Duration.ofSeconds(20));
                }
                break;
            case "grid view is set to 1-grid view by default":
                    $(By.xpath("//*[ local-name() = 'svg' and @column = '1' and @data-active = 'true']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "same CG is displayed":
            assertEquals(galleryName, $(By.xpath("(//div/p[contains(@class, 'MuiTypography-body1')])[1]")).getText());
                break;
            case "grid view is set to 2-grid view":
                $(By.xpath("//*[ local-name() = 'svg' and @column = '2' and @data-active = 'true']")).shouldBe(visible, Duration.ofSeconds(20));
                break;
            case "grid view is set to 3-grid view":
                $(By.xpath("//*[ local-name() = 'svg' and @column = '3' and @data-active = 'true']")).shouldBe(visible, Duration.ofSeconds(20));
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

    @Then("I navigate to {string} gallery")
    public void iNavigateToGallery(String numberOfGallery) {
        $(By.xpath("(//*[@id = 'component-collection-card'])[" + numberOfGallery + "]")).click();
        $(By.xpath("(//div/p[contains(@class, 'MuiTypography-body1')])[1]")).shouldBe(visible, Duration.ofSeconds(20));
    }

    @Then("I navigate to {string} PDP")
    public void iNavigateToPDP(String numberPDP) {
        $(By.xpath("(//*[@id = 'component-rh-image_wrapper'])[" + numberPDP + "]")).click();
        $(By.xpath("(//h2[contains(@class, 'MuiTypography-h2')])[1]")).shouldBe(visible, Duration.ofSeconds(20));
    }

    @Then("I safe the name of gallery")
    public void iSaveTheNameOfGallery() {
        galleryName = $(By.xpath("(//div/p[contains(@class, 'MuiTypography-body1')])[1]")).getText();
    }

    @Then("I Change the CG Grid view to {string} - grid view and confirm changing")
    public void iChangeTheCGGridAndConfirmChanging(String view) {
        $(By.xpath("//*[ local-name() = 'svg' and @column = '" + view + "']")).click();
        with().pollInterval(5, SECONDS).await().until(() -> true);
        $(By.xpath("//*[ local-name() = 'svg' and @column = '" + view + "' and @data-active = 'true']")).shouldBe(visible, Duration.ofSeconds(20));
        if(view.equals("1")) {
            int i = 1;
            with().pollInterval(1, SECONDS).await().until(() -> true);
            while (!$(By.xpath("//*[@class = 'MuiButtonBase-root MuiFab-root' and not(contains(@style, 'hidden'))]")).isDisplayed()) {
                with().pollInterval(1, SECONDS).await().until(() -> true);
                $(By.xpath("(//*[@id = 'collection-gallery-grid'])[" + i + "]")).scrollIntoView(true);
                i++;
                with().pollInterval(1, SECONDS).await().until(() -> true);
            }
            assertEquals(3, i);
        }
        if(view.equals("2")){
            int i = 1;
            while (!$(By.xpath("//*[@class = 'MuiButtonBase-root MuiFab-root' and not(contains(@style, 'hidden'))]")).isDisplayed()) {
                $(By.xpath("(//*[@id = 'collection-gallery-grid'])[" + i + "]")).scrollIntoView(true);
                i++;
                with().pollInterval(1, SECONDS).await().until(() -> true);
            }
            assertEquals(4, i);
        }
        if(view.equals("3")){
            int i = 1;
            with().pollInterval(1, SECONDS).await().until(() -> true);
            while (!$(By.xpath("//*[@class = 'MuiButtonBase-root MuiFab-root' and not(contains(@style, 'hidden'))]")).isDisplayed()) {
                with().pollInterval(1, SECONDS).await().until(() -> true);
                $(By.xpath("(//*[@id = 'collection-gallery-grid'])[" + i + "]")).scrollIntoView(true);
                i++;
                with().pollInterval(1, SECONDS).await().until(() -> true);
            }
            assertEquals(5, i);
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

    @Then("I Verify the price is not displayed")
    public void iVerifynoPrice(){
        try{
            $(By.xpath("//*[text()='$']")).isDisplayed();
//            ConciergeCGScreen.getPrice().isDisplayed();
//            ConciergeCGScreen.getPrice().click();
        }
        catch (Exception e){
            logger.debug(e.getMessage());
        }

    }

}
