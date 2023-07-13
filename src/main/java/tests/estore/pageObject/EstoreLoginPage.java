package tests.estore.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstoreLoginPage {
    private final SelenideElement logoutFromContractUser = $(By.xpath("//*[text()='LOGOUT FROM CONTRACT USER']"));
    private final SelenideElement logoutFromTradeUser = $(By.xpath("//*[text()='LOGOUT FROM TRADE USER']"));
    private final SelenideElement paragraphContent = $(By.xpath("//*[text()='You have successfully signed in to your RH Contract account. Contract pricing will be reflected in the cart.']"));
    private final SelenideElement paragraphContentTrade = $(By.xpath("//*[text()='You have successfully signed in to your RH Trade account. Trade pricing will be reflected in the cart.']"));
    private final SelenideElement contractTradePasswordField = $(By.xpath("//input[@id='password']"));
    private final SelenideElement contractTradeEmailField = $(By.xpath("//input[@id='email']"));
    private final SelenideElement usernameField = $(By.xpath("//input[@id='username']"));
    private final SelenideElement passwordField = $(By.xpath("//input[@id='login-password']"));
    private final SelenideElement signInButton = $(By.xpath("//input[@id='kc-login']"));
    private final SelenideElement accountIcon = $(By.xpath("//a[@data-analytics-nav='account-icon']"));
    private final SelenideElement accountIconStg4 = $(By.xpath("//div[@data-analytics-nav='account-icon']"));
    private final SelenideElement forgotPasswordButton = $(By.xpath("//a[@class='forgot-password']"));

    public void clickToAccountIcon() {
        accountIcon.should(Condition.interactable, Duration.ofSeconds(20));
        accountIcon.click();
    }
}
