package tests.estore.stepdefinitions;


import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import tests.concierge.pageObject.ConciergeUserAccountPage;
import tests.estore.pageObject.EstoreHomePage;
import tests.estore.pageObject.EstoreUserAccountPage;
import tests.utility.Hooks;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class EstoreHomePageStepDefs {
    EstoreHomePage estoreHomePage = new EstoreHomePage();
    ConciergeUserAccountPage conciergeUserAccountPage = new ConciergeUserAccountPage();
    EstoreGeneralStepDefs estoreGeneralStepDefs = new EstoreGeneralStepDefs();

    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();

    public static String result = "";

    @Then("I expect that I am on the eStore Dashboard page")
    public void iExpectThatIAmOnTheEStoreDashboardPage() {
    }

    @Then("I Verify list of Navigation bars")
    public void iVerifyListOfNavigationBars() {
//        List<String> items = new ArrayList<>();
//        List<String> expectedItems = new ArrayList(Arrays.asList("LIVING", "DINING" , "BED", "BATH", "LIGHTING", "TEXTILES", "RUGS", "WINDOWS", "DÉCOR", "ART", "OUTDOOR", "SALE"));
//        for (int i = 0; i < estoreHomePage.getListOfNavigationBar().size(); i++) {
//            items.add(estoreHomePage.getListOfNavigationBar().get(i).getText());
//        }
//        assertEquals(items, expectedItems);
    }

    @And("I click on search Icon")
    public void iClickOnSearchIcon() {
        estoreHomePage.getSearchIcon().should(Condition.visible, Duration.ofSeconds(30));
        estoreHomePage.getSearchIcon().click();
    }

    @And("I Type product name {string}")
    public void iTypeProductName(String arg0) {
        estoreHomePage.getSearchInputField().should(Condition.visible, Duration.ofSeconds(30));
        estoreHomePage.getSearchInputField().setValue(arg0);
        with().pollInterval(2, SECONDS).await().until(() -> true);
        estoreUserAccountPage.getSearchItemField().sendKeys(Keys.ENTER);
    }

    @Then("verify users is taken to search result page")
    public void verifyUsersIsTakenToProductPage() {
        assertTrue(Hooks.getCurrentUrl().contains("/search/results"));
    }


    @Then("I verify RH dropdown and list of brand names")
    public void iVerifyRHDropdownAndListOfBrandNames() {
        List<String> items = new ArrayList<>();
//        List<String> expectedItems = new ArrayList(Arrays.asList("RH", "RH CONTEMPORARY" , "RH INTERIORS", "RH MODERN", "RH OUTDOOR", "RH BEACH HOUSE", "RH SKI HOUSE", "RH BABY & CHILD", "RH TEEN"));
//        for (int i = 0; i < estoreHomePage.getListOfBrandNames().size(); i++) {
//            items.add(estoreHomePage.getListOfBrandNames().get(i).getText());
//        }
//        assertEquals(items, expectedItems);
    }

    @When("I click on RH dropdown")
    public void iClickOnRHDropdown() {
        estoreHomePage.getCategoryDropdown().should(Condition.visible, Duration.ofSeconds(20));
        estoreHomePage.getCategoryDropdown().click();
    }

    @When("I click on Hamburger menu")
    public void iClickOnHamburgerMenu() {
        estoreHomePage.getHamburgerIcon().isDisplayed();
        estoreHomePage.getHamburgerIcon().click();
    }

    @Then("I verify list of items in hamburger menu")
    public void iVerifyListOfItemsInHamburgerMenu() {
//        List<String> items = new ArrayList<>();
//        List<String> expectedItems = new ArrayList(Arrays.asList("RH", "RH CONTEMPORARY" , "RH INTERIORS", "RH MODERN", "RH OUTDOOR", "RH BEACH HOUSE", "RH SKI HOUSE", "RH BABY & CHILD", "RH TEEN", "RH MEMBERS PROGRAM", "RH ONE GULFSTREAM 650ER", "RH TWO GULFSTREAM 550", "RH THREE EXPEDITION YACHT"));
//        for (int i = 0; i < estoreHomePage.getListOfHamburgeritems().size(); i++) {
//            items.add(estoreHomePage.getListOfHamburgeritems().get(i).getText());
//        }
//        assertEquals(items, expectedItems);
    }

    @When("I scroll down to Request a design consultation and click")
    public void iScrollDownToRequestADesignConsultationAndClick() {
        with().pollInterval(4, SECONDS).await().until(() -> true);
        executeJavaScript("window.scrollTo(0, 15000)");
        estoreHomePage.getRequestConsultationButton().scrollIntoView(true);
        estoreHomePage.getRequestConsultationButton().should(visible);
        estoreHomePage.getRequestConsultationButton().click();
    }

    @And("I fill in the request form")
    public void iFillInTheRequestForm() {
        estoreHomePage.getPhoneNumberField().should(Condition.visible, Duration.ofSeconds(20));
        estoreHomePage.getPhoneNumberField().setValue("9254434333");
        estoreHomePage.getLocationDropdown().selectOption(6);
        estoreHomePage.getMessageInputField().click();
        estoreHomePage.getMessageInputField().setValue("Hi, This is automation tests, please ignore the request. Thank you ");
        estoreHomePage.getIframeRequestAConsultationButton().click();


    }

    @Then("I Verify Thank you message")
    public void iVerifyThankYouMessage() {
        estoreHomePage.getThankMessageText().should(Condition.visible, Duration.ofSeconds(25));
    }


    @When("I navigate to the wishlist")
    public void iNavigateToTheWishlist() {
        estoreHomePage.getAccountIcon().click();
        estoreHomePage.getWishlist().click();
    }


    @When("I navigate to the member tab")
    public void iNavigateToTheMemberTab() {
        with().pollInterval(2, SECONDS).await().until(() -> true);
        $(By.xpath("//*[@data-navigation-account-item-id='my-account/membership.jsp']")).
                should(Condition.and("", appear, Condition.interactable, visible), Duration.ofSeconds(40))
                .hover();
        $(By.xpath("//*[@data-navigation-account-item-id='my-account/membership.jsp']")).
                should(Condition.and("", appear, Condition.interactable, visible), Duration.ofSeconds(40))
                .click(ClickOptions.usingJavaScript());
    }

    @Then("I validate each cat and sub-cat for eStore")
    public void iValidateEachCatAndSubCatForEStore() {

        for (int main = 0; main < estoreHomePage.getListOfNavigationBar().size(); main++) {
            System.out.println("Main Category: " + estoreHomePage.getListOfNavigationBar().get(main).getText());
            estoreHomePage.getListOfNavigationBar().get(main).click();
            for (int sub = 0; sub < estoreHomePage.getListOfSubCategories().size(); sub++) {
                System.out.println("Sub Category: " + estoreHomePage.getListOfSubCategories().get(sub).getText());
                estoreHomePage.getListOfSubCategories().get(sub).click();

                for (int collection = 0; collection < estoreHomePage.getListOfCollection().size(); collection++) {
                    estoreHomePage.getListOfCollection().get(collection).click();

                    System.out.println(WebDriverRunner.getWebDriver().getTitle() + ": " + Hooks.getCurrentUrl());
                    assertFalse((WebDriverRunner.getWebDriver().getTitle().contains("404")));
                    if (!Hooks.getCurrentUrl().contains("rhnonprod")) {
                        open(Hooks.eStoreURL);

                    }
                    estoreHomePage.getListOfNavigationBar().get(main).click();

                    estoreHomePage.getListOfSubCategories().get(sub).click();

                }
            }
        }
    }

    @And("user verifies search button, account icon, cart button are displayed")
    public void userVerifiesSearchButtonAccountIconCartButtonAreDisplayed() {
        estoreHomePage.getAccountIcon().should(Condition.visible, Duration.ofSeconds(20));
        estoreHomePage.getSearchIconHomePage().should(Condition.visible, Duration.ofSeconds(20));
        estoreHomePage.getHeaderCartButton().should(Condition.visible, Duration.ofSeconds(20));
    }

}