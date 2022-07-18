package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstoreLoginPage {
    private final SelenideElement usernameField = $(By.xpath("//input[@id='username']"));

    private final SelenideElement passwordField = $(By.xpath("//input[@id='password']"));

    private final SelenideElement sumbitButton = $(By.xpath("//button[@class='login-form__submit']"));

    private final SelenideElement location = $(By.xpath("//select[@id='location']"));

    private final SelenideElement continueButton = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12'][2]//button"));

    private final SelenideElement locationNewPortBeach = $(By.xpath("//*[@id='location']/option[2]"));

    private final SelenideElement locationWestHolywood = $(By.xpath("//*[@id='location']/option[36]"));

    private final SelenideElement signInButton = $(By.xpath("//button[@class='login-form__submit']"));
}
