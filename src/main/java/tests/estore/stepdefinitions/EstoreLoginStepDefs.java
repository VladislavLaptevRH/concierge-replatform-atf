package tests.estore.stepdefinitions;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import tests.estore.pageObject.EstoreLoginPage;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class EstoreLoginStepDefs {

    EstoreLoginPage estoreLoginPage = new EstoreLoginPage();
    public static String USER_ID_STG4;
    public static String USER_ID_STG2;
    public static String userEmail;


    @Given("I log into eStore as {string}")
    public boolean iLogIntoEStoreAs(String arg0) {
        try {
            loginAsRole(arg0);
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            return true;
        }
        return true;
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
                USER_ID_STG4 = "d5049647-af70-4971-84cd-6c2b58701cb0";
                USER_ID_STG2 = "cfaa13c0-0704-43cc-a97c-0dbc72627b28";
                userEmail = "orderreview@rh.com";
            }

            if (accountRole.equals("noaddresses")) {
                estoreLoginPage.getUsernameField().setValue("addressno@rh.com");
                estoreLoginPage.getPasswordField().setValue("Password1234");
                USER_ID_STG4 = "e519cb53-99c5-4d2a-81bb-7a41ede5fe30";
                USER_ID_STG2 = "08c3d65b-d29f-4d5f-bae6-0b09bbb258af";
                userEmail = "addressno@rh.com";
            }

            if (accountRole.equals("addresspage")) {
                estoreLoginPage.getUsernameField().setValue("addresspage@rh.com");
                estoreLoginPage.getPasswordField().setValue("Address1234");
//                USER_ID_STG4="d1eaef74-754a-4721-855d-ee6aa01d998d";
                USER_ID_STG2 = "c34f7501-0d56-4872-97d3-8d3254d1ff66";
                userEmail = "addresspage@rh.com";
            }

            if (accountRole.equals("savedRhCcDiscover")) {
                estoreLoginPage.getUsernameField().setValue("bnamdeo+0010@rh.com");
                estoreLoginPage.getPasswordField().setValue("Resto123");

            }

            if (accountRole.equals("savedaddress")) {
                estoreLoginPage.getUsernameField().setValue("addresssaved@rh.com");
                estoreLoginPage.getPasswordField().setValue("Address1234");
                USER_ID_STG4 = "70ea8bfa-d915-472c-9ecb-db7af54efa23";
                USER_ID_STG2 = "48c86406-7a20-4f60-811c-f63f385caf99";
                userEmail = "addresssaved@rh.com";
            }

            if (accountRole.equals("savedRhCc")) {
                estoreLoginPage.getUsernameField().setValue("savedrhcc@rh.com");
                estoreLoginPage.getPasswordField().setValue("Resto123");
//                USER_ID_STG4="b860df1a-dc0a-4091-a24e-77658c6e49a2";
                USER_ID_STG2 = "48c86406-7a20-4f60-811c-f63f385caf99";
                userEmail = "savedrhcc@rh.com";
            }

            if (accountRole.equals("userWithSavedMasterCardVisa")) {
                estoreLoginPage.getUsernameField().setValue("mastervisa@rh.com");
                estoreLoginPage.getPasswordField().setValue("Resto123");
                USER_ID_STG4 = "f1103ccf-4919-46f0-b59e-3be6065c6317";
                USER_ID_STG2 = "25230889-ca67-45bd-b640-46868050f4eb";
                userEmail = "mastervisa@rh.com";
            }

            if (accountRole.equals("mastercard")) {
                estoreLoginPage.getUsernameField().setValue("mastercard@rh.com");
                estoreLoginPage.getPasswordField().setValue("Qwerty@123");
                USER_ID_STG2 = "7bb560b2-cda2-4b2e-9ab5-5788a88e34da";
                userEmail = "mastercard@rh.com";
            }

            if (accountRole.equals("regular")) {
                estoreLoginPage.getUsernameField().setValue("new02@rh.com");
                estoreLoginPage.getPasswordField().setValue("Qwerty@123");
                USER_ID_STG4 = "dc6f68a3-a223-4670-b7ab-737f1c45927b";
                USER_ID_STG2 = "e3401e67-8f0b-4d75-bf48-63fa022cb34e";
            }

            if (accountRole.equals("addnewpayment")) {
                estoreLoginPage.getUsernameField().setValue("addpaymentmethod@rh.com");
                estoreLoginPage.getPasswordField().setValue("Test12345");
                USER_ID_STG2 = "c0a8f13e-bc39-4261-ab11-51aeed2e25ed";
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
                estoreLoginPage.getUsernameField().setValue("automationmember@rh.com");
                estoreLoginPage.getPasswordField().setValue("Resto123");
                USER_ID_STG2 = "e8d13de6-7249-4070-983e-c70034ee7051";
            }

            if (accountRole.equals("nonmember")) {
                estoreLoginPage.getUsernameField().setValue("nonmember1@rh.com");
                estoreLoginPage.getPasswordField().setValue("Qwert1234");
                USER_ID_STG2 = "2dddc45b-1949-41fa-8609-c156f793463e";
            }
            if (accountRole.equals("regularAddMembership")) {
                estoreLoginPage.getUsernameField().setValue("atfregularaddmembershiprole@rh.com");
                estoreLoginPage.getPasswordField().setValue("Qwert1234");
                USER_ID_STG2 = "8e303621-c2a8-4310-95f4-c6f8f85fb12b";
            }
            if (accountRole.equals("emptyStateField")) {
                estoreLoginPage.getUsernameField().setValue("automationemptystatefield@rh.com");
                estoreLoginPage.getPasswordField().setValue("Password1234");
            }

            estoreLoginPage.getSignInButton().should(visible, Duration.ofSeconds(30));
            estoreLoginPage.getSignInButton().click();
        }

    }

    @Given("I log into eStore as contract")
    public void iLogIntoEStoreAsContract() {
        sleep(2000);
        open(Hooks.eStoreBaseURL + "/contract-sales/contract-sign-in.jsp");
        estoreLoginPage.getContractTradeEmailField().setValue("rboorla@rh.com");
        estoreLoginPage.getContractTradePasswordField().setValue("20211221164476");
        estoreLoginPage.getSignInButton().should(visible, Duration.ofSeconds(30));
        estoreLoginPage.getSignInButton().click();
        USER_ID_STG2 = "a70584e9-5de4-4bfb-8892-8d292bfa374c";
    }

    @Given("I log into eStore as trade")
    public void iLogIntoEStoreAsTrade() {
        sleep(2000);

        try {
            open(Hooks.eStoreURL + "/trade-sales/trade-sign-in.jsp");
            estoreLoginPage.getContractTradeEmailField().setValue("rboorla@rh.com");
            estoreLoginPage.getContractTradePasswordField().setValue("20211221164474");
            estoreLoginPage.getSignInButton().should(visible, Duration.ofSeconds(30));
            estoreLoginPage.getSignInButton().click();
            USER_ID_STG2 = "c42863ab-8179-4bd6-a72d-628a95fac78b";
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            $(By.xpath("//a[@data-analytics-nav='account-icon']")).should(visible, Duration.ofSeconds(20));
            $(By.xpath("//a[@data-analytics-nav='account-icon']")).click();
            estoreLoginPage.getContractTradeEmailField().setValue("rboorla@rh.com");
            estoreLoginPage.getContractTradePasswordField().setValue("20211221164474");
            estoreLoginPage.getSignInButton().should(visible, Duration.ofSeconds(30));
            estoreLoginPage.getSignInButton().click();
        }
    }
}
