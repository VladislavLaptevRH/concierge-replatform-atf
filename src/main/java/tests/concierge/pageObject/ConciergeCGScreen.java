package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ConciergeCGScreen {
    private final SelenideElement price = $(By.xpath("//*[text()='$']"));
    private final SelenideElement seatingCollectionTitle = $(By.xpath("//*[text()='SEATING COLLECTIONS']/ancestor::*[contains(@style,'left')]"));
    private final SelenideElement seatingCollectionTitleLowerCase = $(By.xpath("//*[text()='Seating  collections']/ancestor::*[contains(@style,'left')]"));

    private final SelenideElement RHMemberProgram = $(By.xpath("//*[text()='RH MEMBERS PROGRAM.' ]/ancestor::p[text()=' SAVE 25% ON EVERYTHING*']/ancestor::div[contains(@style,'center')]"));
    private final SelenideElement availableText = $(By.xpath("//*[text()='Available in multiple sizes & finishes']"));
}
