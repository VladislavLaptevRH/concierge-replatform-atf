package tests.estore.stepdefinitions;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import tests.estore.pageObject.EstoreLoginPage;
import tests.utility.Hooks;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;

public class EstoreLoginStepDefs {

    EstoreLoginPage estoreLoginPage = new EstoreLoginPage();
    public static String USER_ID_STG4;
    public static String USER_ID_STG2;

    public static String USER_ID_STG3;

    public static String userEmail;


    @Given("I log into eStore as {string} user")
    public boolean iLogIntoEStoreAs(String arg0) {
        try {
            loginAsRole(arg0);
//            if (Hooks.profile.equals("stg3")) {
//                with().pollInterval(2, SECONDS).await().until(() -> true);
//                $(By.xpath("//*[text()='ACCEPT ALL']")).click();
//            }
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            return true;
        }
        return true;
    }

    public void loginAsRole(String accountRole) {
        if (!estoreLoginPage.getAccountIcon().isDisplayed()) {
            WebDriverRunner.getWebDriver().navigate().refresh();
            with().pollInterval(5, SECONDS).await().until(() -> true);
        }
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

            if (accountRole.equals("cancelMembership")) {
                estoreLoginPage.getUsernameField().setValue("cancelmembership1@rh.com");
                estoreLoginPage.getPasswordField().setValue("Password1234");
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
                USER_ID_STG4 = "d1eaef74-754a-4721-855d-ee6aa01d998d";
                USER_ID_STG2 = "c34f7501-0d56-4872-97d3-8d3254d1ff66";
                userEmail = "addresspage@rh.com";
            }

            if (accountRole.equals("savedRhCcDiscover")) {
                estoreLoginPage.getUsernameField().setValue("bnamdeo+0010@rh.com");
                estoreLoginPage.getPasswordField().setValue("Resto123");
                USER_ID_STG2 = "589c669f-02ee-4e0a-aa21-8e674c6c7469";
            }

            if (accountRole.equals("notregistered")) {
                estoreLoginPage.getUsernameField().setValue("notregistereduser@rh.com");
                estoreLoginPage.getPasswordField().setValue("Resto123");
                USER_ID_STG2 = "589c669f-02ee-4e0a-aa21-8e674c6c7469";
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
                USER_ID_STG4 = "cb8ad3e1-53e8-4185-bafb-9016299145af";
                USER_ID_STG2 = "af6c40e5-ca61-4489-acb1-052ab4f8a512";
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
                USER_ID_STG4 = "eb0c0066-ef64-4218-bb73-23753fe2fc2d";
                USER_ID_STG2 = "7bb560b2-cda2-4b2e-9ab5-5788a88e34da";
                userEmail = "mastercard@rh.com";
            }

            if (accountRole.equals("regular")) {
                if (Hooks.profile.equals("stg3")) {
                    estoreLoginPage.getUsernameField().setValue("testautomation01@rh.com");
                    estoreLoginPage.getPasswordField().setValue("Rh123456");
                    USER_ID_STG3 = "49e2da34-3970-4636-bd1b-1bf1c7c709ff";
                    userEmail = "testautomation01@rh.com";
                } else {
                    if (!estoreLoginPage.getUsernameField().isDisplayed()) {
                        WebDriverRunner.getWebDriver().navigate().refresh();
                        with().pollInterval(5, SECONDS).await().until(() -> true);
                    }
                    estoreLoginPage.getUsernameField().setValue("regularautomation@rh.com");
                    estoreLoginPage.getPasswordField().setValue("Qwerty@123");
                    USER_ID_STG4 = "dc6f68a3-a223-4670-b7ab-737f1c45927b";
                    USER_ID_STG2 = "6d7c77ad-59bf-4fe9-a841-f790b97487c0";
                }
            }

            if (accountRole.equals("addnewpayment")) {
                estoreLoginPage.getUsernameField().setValue("addpaymentmethod@rh.com");
                estoreLoginPage.getPasswordField().setValue("Test12345");
                USER_ID_STG2 = "c0a8f13e-bc39-4261-ab11-51aeed2e25ed";
                USER_ID_STG4 = "c044fe4b-1e08-48d2-a45a-7d720ee43aa4";
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
                USER_ID_STG2 = "99214352-923b-454d-afe8-849bab4fb2b9";
                USER_ID_STG4 = "32285754-7f49-4714-a94e-8be5d26f9734";
            }

            if (accountRole.equals("member")) {
                estoreLoginPage.getUsernameField().setValue("automationmember@rh.com");
                estoreLoginPage.getPasswordField().setValue("Resto123");
                USER_ID_STG2 = "e8d13de6-7249-4070-983e-c70034ee7051";
                USER_ID_STG4 = "bb062529-f70d-4933-b0cc-99f0105839bc";
            }

            if (accountRole.equals("nonmember")) {
                estoreLoginPage.getUsernameField().setValue("nonmember1@rh.com");
                estoreLoginPage.getPasswordField().setValue("Qwert1234");
                USER_ID_STG2 = "2dddc45b-1949-41fa-8609-c156f793463e";
                USER_ID_STG4 = "9c8d59b2-fee6-485d-adc3-78559483bc81";
            }
            if (accountRole.equals("regularAddMembership")) {
                estoreLoginPage.getUsernameField().setValue("atfregularaddmembershiprole@rh.com");
                estoreLoginPage.getPasswordField().setValue("Qwert1234");
                USER_ID_STG2 = "a9b2aed7-665d-45d8-b9cb-b914e9fed772";
                if (Hooks.profile.contains("stg4")) {
                    estoreLoginPage.getUsernameField().setValue("regulartomember@rh.com");
                    estoreLoginPage.getPasswordField().setValue("Qwert1234");
                    USER_ID_STG4 = "4303ef90-7890-4333-8336-795f0d9b7542";
                }

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
        open(Hooks.eStoreBaseURL + "/contract-sales/contract-sign-in.jsp");
        estoreLoginPage.getContractTradeEmailField().should(visible, Duration.ofSeconds(10));
        estoreLoginPage.getContractTradeEmailField().setValue("rboorla+2222@rh.com");
        estoreLoginPage.getContractTradePasswordField().setValue("20211221164476");
        estoreLoginPage.getSignInButton().should(visible, Duration.ofSeconds(30));
        estoreLoginPage.getSignInButton().click();
        if (Hooks.profile.equals("stg2")) {
            USER_ID_STG2 = "c394260f-0ced-4e20-b4ee-3bce53851f21";
        } else {
            USER_ID_STG4 = "12fe9c72-c443-43b8-8185-2f627dbda8da";
        }

    }

    @Given("I log into eStore as trade")
    public void iLogIntoEStoreAsTrade() {
        with().pollInterval(2, SECONDS).await().until(() -> true);

        try {
            open(Hooks.eStoreBaseURL + "/trade-sales/trade-sign-in.jsp");
            estoreLoginPage.getContractTradeEmailField().should(visible, Duration.ofSeconds(60));
            estoreLoginPage.getContractTradeEmailField().setValue("rboorla+700@rh.com");
            estoreLoginPage.getContractTradePasswordField().setValue("20230220167059");
            estoreLoginPage.getSignInButton().should(visible, Duration.ofSeconds(30));
            estoreLoginPage.getSignInButton().click();
            USER_ID_STG2 = "21e477e0-c989-48db-82ff-4422172805e2";
        } catch (com.codeborne.selenide.ex.ElementNotFound e) {
            $(By.xpath("//a[@data-analytics-nav='account-icon']")).should(visible, Duration.ofSeconds(20));
            $(By.xpath("//a[@data-analytics-nav='account-icon']")).click();
            estoreLoginPage.getContractTradeEmailField().setValue("rboorla@rh.com");
            estoreLoginPage.getContractTradePasswordField().setValue("20211221164474");
            estoreLoginPage.getSignInButton().should(visible, Duration.ofSeconds(30));
            estoreLoginPage.getSignInButton().click();
        }
    }

    @When("I introduce wrong login and password")
    public void iIntroduceWrongLoginAndPassword() {
        estoreLoginPage.getAccountIcon().should(visible, Duration.ofMinutes(15));
        estoreLoginPage.getAccountIcon().click();

        estoreLoginPage.getUsernameField().should(visible, Duration.ofSeconds(15));
        estoreLoginPage.getPasswordField().should(visible, Duration.ofMinutes(15));
        estoreLoginPage.getUsernameField().setValue("wrongemail@mailinator.com");
        estoreLoginPage.getPasswordField().setValue("wrongpassword");

        estoreLoginPage.getSignInButton().should(visible, Duration.ofSeconds(20));
        estoreLoginPage.getSignInButton().click();


    }

    @Then("I verify that error message about invalid credentials is displayed")
    public void iVerifyThatErrorMessageAboutInvalidCredentialsIsDisplayed() {
        $(By.xpath("//*[text()='Invalid email address or password.']")).should(visible, Duration.ofSeconds(20));
    }

    @Given("when I click on forgot password button")
    public void whenIClickOnForgotPasswordButton() {
        estoreLoginPage.getAccountIcon().should(visible, Duration.ofMinutes(15));
        estoreLoginPage.getAccountIcon().click();
        estoreLoginPage.getForgotPasswordButton().should(visible, Duration.ofSeconds(20));
        estoreLoginPage.getForgotPasswordButton().click();
    }

    @Then("I verify that forgot password options works")
    public void iVerifyThatForgotPasswordOptionsWorks() {
        $(By.xpath("//*[text()='Forgot Password']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//input[@name='username']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//input[@id='submit']")).should(visible, Duration.ofSeconds(20));
    }

    @When("I click on estore account")
    public void iClickOnEstoreAccount() {
        estoreLoginPage.getAccountIconStg4().should(visible, Duration.ofSeconds(20));
        estoreLoginPage.getAccountIconStg4().click();
    }

    @When("I click on estore signout button")
    public void iClickOnEstoreSignoutButton() {
        $(By.xpath("//*[text()='SIGN OUT']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='SIGN OUT']")).click();
        $(By.xpath("//*[text()='Sign Out']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Sign Out']")).click();
    }

    @Then("I verify that user is able to signout")
    public void iVerifyThatUserIsAbleToSignout() {
        estoreLoginPage.getUsernameField().should(visible, Duration.ofSeconds(20));
        estoreLoginPage.getPasswordField().should(visible, Duration.ofSeconds(20));
    }
}
