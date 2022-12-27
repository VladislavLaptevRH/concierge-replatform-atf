package tests.estore.stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tests.estore.pageObject.EstoreCGScreen;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class EstoreSaleStepDefs {

    EstoreCGScreen estoreCGScreen = new EstoreCGScreen();

    @When("I click on estore sale button")
    public void iClickOnEstoreSaleButton() {
        $(By.xpath("//*[text()='SALE']")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='SALE']")).click();
    }

    @Then("I verify that I'm able to navigate different category")
    public void iVerifyThatIMAbleToNavigateDifferentCategory() {
        $(By.xpath("(//div[@id='lower-nav']//div[1])[1]")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("(//div[@id='lower-nav']//div[1])[1]")).click();
        $(By.xpath("//*[text()='Sofas']")).should(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Sofas']")).click();

        $(By.xpath("//*[text()='Sofas']")).should(Condition.visible, Duration.ofSeconds(20));
    }

    @Then("I verify sale category for estore")
    public void iVerifySaleCategoryForEstore() {
        $(By.xpath("//*[text()='Living']")).should(Condition.visible,Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Dining']")).should(Condition.visible,Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Bed']")).should(Condition.visible,Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Textiles']")).should(Condition.visible,Duration.ofSeconds(20));
    }

    @Then("I verify the back button from sale PDP page")
    public void iVerifyTheBackButtonFromSalePDPPage() {
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        estoreCGScreen.getBackToTopButton().should(Condition.visible,Duration.ofSeconds(20));
        estoreCGScreen.getBackToTopButton().click();

    }
}
