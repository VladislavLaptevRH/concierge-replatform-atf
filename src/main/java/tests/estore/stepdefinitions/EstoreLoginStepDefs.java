package tests.estore.stepdefinitions;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import tests.estore.pageObject.EstoreLoginPage;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class EstoreLoginStepDefs {

    EstoreLoginPage estoreLoginPage = new EstoreLoginPage();
    @Given("I log into eStore as {string}")
    public void iLogIntoEStoreAs(String arg0) {
        loginAsRole(arg0);
    }

    public void loginAsRole(String accountRole) {
        estoreLoginPage.getAccountIcon().should(visible, Duration.ofMinutes(15));
        estoreLoginPage.getAccountIcon().click();

        estoreLoginPage.getUsernameField().should(visible, Duration.ofSeconds(15));
        estoreLoginPage.getPasswordField().should(visible, Duration.ofMinutes(15));

        if(accountRole.equals("savedRhCcDiscover")){
            estoreLoginPage.getUsernameField().setValue("bnamdeo+0010@rh.com");
            estoreLoginPage.getPasswordField().setValue("Resto123");
        }
        if(accountRole.equals("savedRhCc")){
            estoreLoginPage.getUsernameField().setValue("savedrhcc@rh.com");
            estoreLoginPage.getPasswordField().setValue("Resto123");
        }

        if(accountRole.equals("userWithSavedMasterCardVisa")){
            estoreLoginPage.getUsernameField().setValue("mastervisa@rh.com");
            estoreLoginPage.getPasswordField().setValue("Resto123");
        }

        if (accountRole.equals("mastercard")) {
            estoreLoginPage.getUsernameField().setValue("mastercard@rh.com");
            estoreLoginPage.getPasswordField().setValue("Qwerty@123");
        }

        if (accountRole.equals("regular")) {
            estoreLoginPage.getUsernameField().setValue("new02@rh.com");
            estoreLoginPage.getPasswordField().setValue("Qwerty@123");
        }
        if(accountRole.equals("userCAAddress")){
            estoreLoginPage.getUsernameField().setValue("automationcastate@mailinator.com");
            estoreLoginPage.getPasswordField().setValue("Qwerty@123");
        }
        if (accountRole.equals("employee")) {
            estoreLoginPage.getUsernameField().setValue("ediscount");
            estoreLoginPage.getPasswordField().setValue("p6K6K6Mx");
        }
        if (accountRole.equals("leader")) {
            estoreLoginPage.getUsernameField().setValue(Hooks.leaderLogin);
            estoreLoginPage.getPasswordField().setValue(Hooks.leaderPassword);
        }
        estoreLoginPage.getSignInButton().should(visible, Duration.ofSeconds(30));
        estoreLoginPage.getSignInButton().click();
    }
}
