package tests.concierge.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class ConciergeLoginPage {
    private final SelenideElement usernameField = $(By.xpath("//input[@id='username']"));

    private final SelenideElement passwordField = $(By.xpath("//input[@id='password']"));

    private final SelenideElement sumbitButton = $(By.xpath("//button[@class='login-form__submit']"));

    private final SelenideElement location = $(By.xpath("//select[@id='location']"));

    private final SelenideElement continueButton = $(By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12'][2]//button"));

    private final SelenideElement locationNewPortBeach = $(By.xpath("//*[@id='location']/option[2]"));

    private final SelenideElement locationDropDownList = $(By.xpath("//*[contains(text(), 'Location')]/..//*[contains(@class , 'MuiInputBase-root')]"));

    private final SelenideElement currentLocation = $(By.xpath("//label[text()='Current Location']"));
    private final SelenideElement locationListButton = $(By.xpath("//button[@aria-label = 'Open']"));
    private final SelenideElement inputGallery = $(By.xpath("//input[@type='text']"));

    private final SelenideElement inputGalleryList = $(By.xpath("//select[@id='location']"));
    private final SelenideElement locationWestHolywood = $(By.xpath("//*[@id='location']/option[36]"));

    private final SelenideElement signInButton = $(By.xpath("//button[@class='login-form__submit']"));
    private final SelenideElement RHIcon = $(By.xpath("//*[@alt='RH']"));
    private final SelenideElement locationInput = $(By.xpath("//select[@id = 'location']"));
    private final SelenideElement dashboard = $(By.xpath("//h1[text()='Dashboard']"));
    private final SelenideElement projects = $(By.xpath("//h3[text()='Projects']"));
    private final SelenideElement registry = $(By.xpath("//h1[contains(text(),'Registry')]"));
    //*[@alt='RH']
}
