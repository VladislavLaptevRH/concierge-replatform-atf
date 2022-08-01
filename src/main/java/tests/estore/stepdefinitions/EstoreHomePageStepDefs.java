package tests.estore.stepdefinitions;

import io.cucumber.java.en.Then;
import tests.estore.pageObject.EstoreHomePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class EstoreHomePageStepDefs {
    EstoreHomePage estoreHomePage = new EstoreHomePage();
    @Then("I expect that I am on the eStore Dashboard page")
    public void iExpectThatIAmOnTheEStoreDashboardPage() {
    }

    @Then("I Verify list of Navigation bars")
    public void iVerifyListOfNavigationBars() {
        List<String> items = new ArrayList<>();
        List<String> expectedItems = new ArrayList(Arrays.asList("LIVING", "DINING" , "BED", "BATH", "LIGHTING", "TEXTILES", "RUGS", "WINDOWS", "DÉCOR", "ART", "OUTDOOR", "SALE"));
        for (int i = 0; i < estoreHomePage.getListOfNavigationBar().size(); i++) {
            items.add(estoreHomePage.getListOfNavigationBar().get(i).getText());
        }
        assertEquals(items, expectedItems);
    }
}
