package tests.concierge.stepdefinitions;

import io.cucumber.java.en.When;
import tests.concierge.pageObject.ConciergeHomePage;
import tests.utility.Hooks;


public class ConciergeHomePageStepDefs {

    ConciergeHomePage conciergeHomePage = new ConciergeHomePage();

    @When("I choose country for concierge from footer")
    public void iChooseCountryForConciergeFromFooter() {
        try {
            if (Hooks.country.equals("GB")) {
                conciergeHomePage.chooseGBCountry();
            }
        } catch (NullPointerException e){
            System.out.println("Exception");
        }
        try{
            if (Hooks.country.equals("CA")) {
                conciergeHomePage.chooseCACountry();
            }
        } catch (NullPointerException e){
            System.out.println("Exception");
        }
        try {
            if (Hooks.country == null) {
                System.out.println("Country is US");
            }
        } catch (NullPointerException e){
            System.out.println("Exception");
        }
    }
}
