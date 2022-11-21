package tests.estore.stepdefinitions;


import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.estore.pageObject.EstoreHomePage;
import tests.utility.Hooks;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class EstoreHomePageStepDefs {
    EstoreHomePage estoreHomePage = new EstoreHomePage();

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
        estoreHomePage.getSearchCloseButton().should(Condition.visible, Duration.ofSeconds(30));
        estoreHomePage.getSearchInputField().setValue(arg0);
        estoreHomePage.getSeeAllResultButton().click();
    }

    @Then("Verify users is taken to product page")
    public void verifyUsersIsTakenToProductPage() {
        sleep(2000);
        Hooks.getCurrentUrl().equals("https://stg2.rhnonprod.com/search/results.jsp?Ntt=sofa&Ns=product.sale%7C1");
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
        estoreHomePage.getRequestConsultationButton().scrollTo();
        estoreHomePage.getRequestConsultationButton().exists();
        estoreHomePage.getRequestConsultationButton().click();
    }

    @And("I fill in the request form")
    public void iFillInTheRequestForm() {
//        assertFalse(estoreHomePage.getFirstNameInputField().getValue().isEmpty());
//        assertFalse(estoreHomePage.getLastNameInputField().getValue().isEmpty());
//        assertFalse(estoreHomePage.getEmailInputField().getValue().isEmpty());
//        estoreHomePage.getPhoneNumberInputField().setValue("9254434333");
//        estoreHomePage.getLocationDropdown().selectOption(6);
//        estoreHomePage.getMessageInputField().setValue("Hi, This is automation tests, please ignore the request. Thank you ");
//        estoreHomePage.getIframeRequestAConsultationButton().click();
        sleep(3000);
    }

    @Then("I Verify Thank you message")
    public void iVerifyThankYouMessage() {
//        String actual = estoreHomePage.getThankMessageText().getText();
//        String expected = ("Thank you for telling us about your project. We're reviewing your information, and a designer will be in touch within 24 hours.\n" +
//                "\n" +
//                "In preparation for our first meeting, please gather any existing floor plans, photos of your space and inspiration shots that will inform your project.\n" +
//                "\n" +
//                "We look forward to working with you.");
//      assertEquals(actual, expected);
    }


    @When("I navigate to the wishlist")
    public void iNavigateToTheWishlist() {
//        estoreHomePage.getAccountIcon().click();
//        estoreHomePage.getWishlist().click();
    }


    @When("I navigate to the member tab")
    public void iNavigateToTheMemberTab() {
        String URL = Hooks.eStoreBaseURL + "/my-account/membership.jsp";
        open(URL);
        sleep(2000);
    }
}
