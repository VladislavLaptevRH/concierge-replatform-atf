package tests.concierge.stepdefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import tests.concierge.pageObject.ConciergeHomePage;
import tests.utility.Hooks;

import static com.codeborne.selenide.Selenide.$;


public class ConciergeHomePageStepDefs {

    ConciergeHomePage conciergeHomePage = new ConciergeHomePage();

    public static String countryTmp;

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
            if (Hooks.country == null || Hooks.country.equals("US")) {
                System.out.println("Country is US");
            }
        } catch (NullPointerException e){
            System.out.println("Exception");
        }
    }

    @When("I choose {string} country")
    public void iChooseCountryFor(String country) {
            countryTmp = country;
        try {
            if (country.equals("GB")) {
                conciergeHomePage.chooseGBCountry();
            }
        } catch (NullPointerException e) {
            System.out.println("Exception");
        }
        try {
            if (country.equals("CA")) {
                conciergeHomePage.chooseCACountry();
            }
        } catch (NullPointerException e) {
            System.out.println("Exception");
        }
        try {
            if (country.equals("US")) {
                conciergeHomePage.chooseUSCountry();
            }
        } catch (NullPointerException e) {
            System.out.println("Exception");
        }
    }

    @Then("I Verify {string} is present")
    public void iVerifySale(String value){
        $(By.xpath("//*[text()='"+value+"']")).isDisplayed();
    }
}
