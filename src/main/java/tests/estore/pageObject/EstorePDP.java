package tests.estore.pageObject;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class EstorePDP {
    @Then("I verify that user can see product details correctly mentioned for a product")
    public void iVerifyThatUserCanSeeProductDetailsCorrectlyMentionedForAProduct() {
        $(By.xpath("//*[text()='DETAILS']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='DETAILS']")).click();
        $(By.xpath("//*[text()='Loomed to a rich 802 grams per square meter']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Made of the finest 100% cotton terry cloth from Turkey']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Bath sheets and towels are luxuriously oversized for enveloping comfort']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Bath sheets, bath towels and hand towels may be monogrammed; placement will be front and center, just above the dobby']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Add a 1-initial or 3-initial monogram with choice of font color and style; choose Tone-on-Tone color option to match towel color']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Personalized items may not be returned and are not eligible for expedited shipping']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Care']")).shouldBe(Condition.visible, Duration.ofSeconds(20));
    }
}
