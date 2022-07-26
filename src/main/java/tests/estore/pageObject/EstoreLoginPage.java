package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstoreLoginPage {
    private final SelenideElement usernameField = $(By.xpath("//input[@id='username']"));
    private final SelenideElement passwordField = $(By.xpath("//input[@id='login-password']"));
    private final SelenideElement signInButton = $(By.xpath("//input[@id='kc-login']"));
    private final SelenideElement accountIcon = $(By.xpath("//a[@data-analytics-nav= 'account-icon']"));

}
