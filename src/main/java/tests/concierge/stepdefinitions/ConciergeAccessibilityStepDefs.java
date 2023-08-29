package tests.concierge.stepdefinitions;

//import jdk.internal.org.jline.utils.Display;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.concierge.pageObject.ConciergeLoginPage;
import tests.concierge.pageObject.ConciergeUserAccountPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;

public class ConciergeAccessibilityStepDefs {
    private static final Logger Log = LoggerFactory.getLogger(ConciergeAccessibilityStepDefs.class);
    ConciergeLoginPage conciergeLoginPage = new ConciergeLoginPage();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();

    @Given("^user opens the tests.concierge site$")
    public void User_Ppens_The_Concierge_Site() {
        Log.debug("User opens the tests.concierge product");
        conciergeLoginPage.getUsernameField().should(visible, Duration.ofMinutes(5));
        conciergeLoginPage.getSignInButton().should(visible, Duration.ofMinutes(5));
    }

    @Then("user expects that no accessibility errors")
    public void userExpectsThatNoAccessibilityErrors() {
        conciergeUserAccountPage.getArtButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getBathButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getBedButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getArtButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getProjectsButton().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getLocationButton().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getInStockButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getLivingButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getDiningButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getBedButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getBathButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getLightingButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getTextilesButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getRugsButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getWindowsButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getDecorButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getArtButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getOutdoorButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getGiftsButtonMenu().should(visible, Duration.ofSeconds(10));
        conciergeUserAccountPage.getSaleButtonMenu().should(visible, Duration.ofSeconds(10));
    }

    @When("user sign in tests.concierge portal")
    public void userSignInConciergePortal() {
        conciergeLoginPage.getUsernameField().should(visible, Duration.ofMinutes(1));
        conciergeLoginPage.getUsernameField().setValue("automationassociate");
        conciergeLoginPage.getPasswordField().setValue("S3pUgx4W");
        conciergeLoginPage.getSignInButton().click();
        conciergeLoginPage.getLocationNewPortBeach().click();
        conciergeLoginPage.getContinueButton().click();
    }

    public void checkMenu(List menuItem) {
        try {
            List<String> rhItems = new ArrayList<>();
            conciergeUserAccountPage.getMenuItems().get(2).should(visible, Duration.ofSeconds(60));
            for (int i = 0; i < conciergeUserAccountPage.getMenuItems().size(); i++) {
                rhItems = new ArrayList(Arrays.asList(conciergeUserAccountPage.getMenuItems().get(i).getText()));
            }
            GeneralStepDefs.compareList(menuItem, rhItems);

        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            checkMenu(menuItem);
        }

    }

    public void accessSubMenu(String each) {
        with().pollInterval(5, SECONDS).await().until(() -> true);
        try {
            $(By.xpath("//div[@class='MuiGrid-root MuiGrid-container MuiGrid-wrap-xs-nowrap MuiGrid-justify-xs-space-between']//descendant::span[text()='" + each + "']"))
                    .should(visible, Duration.ofSeconds(30)).click();
            conciergeUserAccountPage.getFirstSubMenu().should(visible, Duration.ofSeconds(40)).click();
//            with().pollInterval(5, SECONDS).await().until(() -> true);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
            accessSubMenu(each);
        }
    }

    @Then("User verifies that all items from menu are displayed for {string}")
    public void userVerifiesThatAllItemsFromMenuAreDisplayed(String brand) {
        switch (brand) {
            case "RH":
                List<String> rhExpectedItems = new ArrayList(Arrays.asList("Living", "Dining", "Bed", "Bath", "Lighting", "Textiles", "Rugs", "Windows", "Décor", "Outdoor", "BABY & CHILD", "TEEN", "SALE"));
                checkMenu(rhExpectedItems);
                for (String each : rhExpectedItems) {
                    if (each.equals("BABY & CHILD") || each.equals("TEEN")) {
                        continue;
                    } else {
                        accessSubMenu(each);
                    }
                }
                break;
            case "RH CONTEMPORARY":
                List<String> rhConExpectedItems = new ArrayList(Arrays.asList("Living", "Dining", "Bed", "Lighting", "Textiles", "Rugs", "Windows", "Décor", "Art", "Outdoor", "SALE"));
                checkMenu(rhConExpectedItems);
                for (String each : rhConExpectedItems) {
                    accessSubMenu(each);
                }
                break;
            case "RH INTERIORS":
                List<String> rhIntExpectedItems = new ArrayList(Arrays.asList("Living", "Dining", "Bed", "Bath", "Lighting", "Textiles", "Rugs", "Windows", "Décor", "Outdoor", "SALE"));
                checkMenu(rhIntExpectedItems);
                for (String each : rhIntExpectedItems) {
                    accessSubMenu(each);
                }
                break;
            case "RH MODERN":
                List<String> rhModExpectedItems = new ArrayList(Arrays.asList("Living", "Dining", "Bed", "Bath", "Lighting", "Textiles", "Rugs", "Windows", "Décor", "Outdoor", "SALE"));
                checkMenu(rhModExpectedItems);
                for (String each : rhModExpectedItems) {
                    if (each.equals("Outdoor")) {
                        continue;
                    } else {
                        accessSubMenu(each);
                    }
                }
                break;
            case "RH BEACH HOUSE":
                List<String> rhBeachExpectedItems = new ArrayList(Arrays.asList("Living", "Dining", "Bed", "Bath", "Lighting", "Textiles", "Rugs", "Décor", "Art", "Outdoor", "SALE"));
                checkMenu(rhBeachExpectedItems);
                for (String each : rhBeachExpectedItems) {
                    accessSubMenu(each);
                }
                break;
            case "RH SKI HOUSE":
                List<String> rhSkiExpectedItems = new ArrayList(Arrays.asList("Living", "Dining", "Bed", "Bath", "Lighting", "Textiles", "Rugs", "Décor", "Outdoor", "SALE"));
                checkMenu(rhSkiExpectedItems);
                for (String each : rhSkiExpectedItems) {
                    accessSubMenu(each);
                }
                break;
            case "RH BABY & CHILD":
                List<String> rhBathExpectedItems = new ArrayList(Arrays.asList("Furniture", "Bedding", "Nursery", "Décor", "Lighting", "Rugs", "Windows", "Storage", "Playroom", "Gifts", "TEEN", "SALE"));
                checkMenu(rhBathExpectedItems);
                for (String each : rhBathExpectedItems) {
                    if (each.equals("TEEN")) {
                        continue;
                    } else {
                        accessSubMenu(each);
                    }
                }
                break;
            case "RH TEEN":
                List<String> rhTeenExpectedItems = new ArrayList(Arrays.asList("Furniture", "Bedding", "Décor", "Lighting", "Rugs", "Windows", "Storage", "Study", "Gifts", "BATH & CHILD", "SALE"));
                checkMenu(rhTeenExpectedItems);
                for (String each : rhTeenExpectedItems) {
                    if (each.equals("BATH & CHILD")) {
                        continue;
                    } else {
                        accessSubMenu(each);
                    }
                }
                break;
        }
    }
}