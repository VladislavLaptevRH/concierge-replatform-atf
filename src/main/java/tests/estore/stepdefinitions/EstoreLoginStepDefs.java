package tests.estore.stepdefinitions;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Cookie;
import tests.estore.pageObject.EstoreLoginPage;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class EstoreLoginStepDefs {

    EstoreLoginPage estoreLoginPage = new EstoreLoginPage();

    @Given("I log into eStore as {string}")
    public void iLogIntoEStoreAs(String arg0) {
        loginAsRole(arg0);
        if (Hooks.eStoreURL.contains("stg4")) {
            Hooks.setupEstoreCookies();
        }
    }

    public void loginAsRole(String accountRole) {
        if (!accountRole.equals("guest")) {
            estoreLoginPage.getAccountIcon().should(visible, Duration.ofMinutes(15));
            estoreLoginPage.getAccountIcon().click();

            estoreLoginPage.getUsernameField().should(visible, Duration.ofSeconds(15));
            estoreLoginPage.getPasswordField().should(visible, Duration.ofMinutes(15));


            if (accountRole.equals("orderreview")) {
                estoreLoginPage.getUsernameField().setValue("orderreview@rh.com");
                estoreLoginPage.getPasswordField().setValue("Orderreview1234");
            }

            if (accountRole.equals("noaddresses")) {
                estoreLoginPage.getUsernameField().setValue("addressno@rh.com");
                estoreLoginPage.getPasswordField().setValue("Password1234");
            }

            if (accountRole.equals("addresspage")) {
                estoreLoginPage.getUsernameField().setValue("addresspage@rh.com");
                estoreLoginPage.getPasswordField().setValue("Address1234");
            }

            if (accountRole.equals("savedRhCcDiscover")) {
                estoreLoginPage.getUsernameField().setValue("bnamdeo+0010@rh.com");
                estoreLoginPage.getPasswordField().setValue("Resto123");
            }

            if(accountRole.equals("savedaddress")){
                estoreLoginPage.getUsernameField().setValue("addresssaved@rh.com");
                estoreLoginPage.getPasswordField().setValue("Address1234");
            }

            if (accountRole.equals("savedRhCc")) {
                estoreLoginPage.getUsernameField().setValue("savedrhcc@rh.com");
                estoreLoginPage.getPasswordField().setValue("Resto123");
            }

            if (accountRole.equals("userWithSavedMasterCardVisa")) {
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

            if (accountRole.equals("addnewpayment")) {
                estoreLoginPage.getUsernameField().setValue("addpaymentmethod@rh.com");
                estoreLoginPage.getPasswordField().setValue("Test12345");
            }

            if (accountRole.equals("userCAAddress")) {
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

            if (accountRole.equals("wishlist-registered")) {
                estoreLoginPage.getUsernameField().setValue("wish@listautomation.com");
                estoreLoginPage.getPasswordField().setValue("Qwert1234");
            }

            if (accountRole.equals("member")) {
                estoreLoginPage.getUsernameField().setValue("bnamdeo+0073@rh.com");
                estoreLoginPage.getPasswordField().setValue("Resto123");
            }

            if (accountRole.equals("nonmember")) {
                estoreLoginPage.getUsernameField().setValue("nonmember1@rh.com");
                estoreLoginPage.getPasswordField().setValue("Qwert1234");
            }
            estoreLoginPage.getSignInButton().should(visible, Duration.ofSeconds(30));
            estoreLoginPage.getSignInButton().click();
        }

    }

    @Given("I log into eStore as contract")
    public void iLogIntoEStoreAsContract() {
        sleep(2000);
        open("https://stg4.rhnonprod.com/contract-sales/contract-sign-in.jsp");
        estoreLoginPage.getContractTradeEmailField().setValue("rboorla@rh.com");
        estoreLoginPage.getContractTradePasswordField().setValue("20211221164476");
        estoreLoginPage.getSignInButton().should(visible, Duration.ofSeconds(30));
        estoreLoginPage.getSignInButton().click();
    }

    @Given("I log into eStore as trade")
    public void iLogIntoEStoreAsTrade() {
        sleep(2000);
        open("https://stg4.rhnonprod.com/trade-sales/trade-sign-in.jsp");
        estoreLoginPage.getContractTradeEmailField().setValue("rboorla@rh.com");
        estoreLoginPage.getContractTradePasswordField().setValue("20211221164474");
        estoreLoginPage.getSignInButton().should(visible, Duration.ofSeconds(30));
        estoreLoginPage.getSignInButton().click();
    }
}
