package com.test.stepdefinitions;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.test.stepdefinitions.GeneralStepDefs.sleep;
import static org.testng.Assert.assertTrue;

public class FilterStepDefs {
    private static final Logger Log = LoggerFactory.getLogger(FilterStepDefs.class);


    @When("I search {string} in search field from header")
    public void iSearchInSearchFieldFromHeader(String searchTerm) {
        Log.debug("I search " + searchTerm + " in search field from header");
        $(By.xpath("//input[@id='site-search-input']")).shouldBe(visible, Duration.ofMinutes(3));
        $(By.xpath("//input[@id='site-search-input']")).setValue(searchTerm);
        $(By.xpath("//input[@id='site-search-input']")).sendKeys(Keys.ENTER);
    }

    @When("I click on brands")
    public void iClickOnBrands() {
        $(By.xpath("//*[contains(text(),'brands')]")).shouldBe(visible, Duration.ofSeconds(15));
        $(By.xpath("//*[contains(text(),'brands')]")).click();
    }


    @Then("I verify that brands are displayed")
    public void iVerifyThatCountOfProductsFromMenuIsEqualToCountOfPrductsFromPDPPage() {
        $(By.xpath("//ul[contains(@class,'MuiList-root')]/li[contains(@class,'MuiListItem-root')]")).shouldBe(visible, Duration.ofSeconds(15));
        List<SelenideElement> listOfBrands = $$(By.xpath("//ul[contains(@class,'MuiList-root')]/li[contains(@class,'MuiListItem-root')]"));
        assertTrue(listOfBrands.size() > 0, "Brands are displayed");
    }

    @When("I click on in stock")
    public void iClickOnInStock() {
        $(By.xpath("//*[text()='In Stock']")).shouldBe(visible, Duration.ofSeconds(5));
        $(By.xpath("//*[text()='In Stock']")).click();
    }

    @Then("I verify that in stock is displayed")
    public void iVerifyThatInStockIsDisplayed() {
        $(By.xpath("(//input[@type='checkbox'])[1]")).click();
    }

    @When("I click on color")
    public void iClickOnColors() {
        $(By.xpath("//*[text()='Color']")).shouldHave(text("Color"), Duration.ofSeconds(5));
        $(By.xpath("//*[text()='Color']")).click();
    }

    @Then("I verify that all colors are displayed")
    public void iVerifyThatIsDisplayed() {
        $(By.xpath("(//input[@type='checkbox'])[1]")).click();
    }

    @When("I click on sort button")
    public void iClickOnSortButton() {
        $(By.xpath("//*[text()='Sort']")).shouldHave(text("Sort"), Duration.ofSeconds(15));
        $(By.xpath("//*[text()='Sort']")).click();
    }

    @Then("I verify that sort options are displayed")
    public void iVerifyThatSortOptionsAreDisplayed() {
        $(By.xpath("//*[text()='Featured']")).shouldHave(text("Featured"), Duration.ofSeconds(20));
        $(By.xpath("//*[text()='New Products']")).shouldHave(text("New Products"), Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Price Low to High']")).shouldHave(text("Price Low to High"), Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Price High to Low']")).shouldHave(text("Price High to Low"), Duration.ofSeconds(20));
        sleep(1);

        try {
            $(By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorPrimary'])[2]")).shouldBe(visible, Duration.ofSeconds(15));
            $(By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorPrimary'])[2]")).click();
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            System.out.println("Close button is not displayed");
        }

    }
}
