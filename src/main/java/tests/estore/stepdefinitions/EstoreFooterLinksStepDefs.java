package tests.estore.stepdefinitions;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import tests.estore.pageObject.EstoreFooterScreen;
import tests.estore.pageObject.EstoreUserAccountPage;
import tests.utility.Hooks;

import java.time.Duration;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static tests.utility.Hooks.getWindowsHandles;

public class EstoreFooterLinksStepDefs {

    EstoreFooterScreen estoreFooterScreen = new EstoreFooterScreen();
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    @Then("I verify that I'm able to access {string}")
    public void iVerifyThatIMAbleToAccess(String link) {
//        sleep(3000);
//        executeJavaScript("window.scrollTo(0, 970)");
        estoreUserAccountPage.getRhEstoreLogo().should(visible, Duration.ofSeconds(15));
        estoreFooterScreen.getLocateAGallery().scrollIntoView(true);
        with().pollInterval(3, SECONDS).await().until(() -> true);

        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        js.executeScript("window.scrollBy(0,-250)", "");

        if (link.equals("LOCATE A GALLERY")) {
            estoreFooterScreen.getLocateAGallery().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getLocateAGallery().click();
            if (Hooks.profile.equals("stg4")) {
                $(By.xpath("//*[text()='FIND A']")).should(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[text()='GALLERY']")).should(visible, Duration.ofSeconds(20));
            }
        }
        if (link.equals("VIEW SOURCE BOOKS")) {
            estoreFooterScreen.getViewSourceBooks().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getViewSourceBooks().click();
            if (Hooks.profile.equals("stg4")) {
                $("title").shouldHave(attribute("text", "RH Source Books"));
            }
        }
        if (link.equals("REQUEST A SOURCE BOOK")) {
            estoreFooterScreen.getRequestASource().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getRequestASource().click();
            if (Hooks.profile.equals("stg4")) {
                $(By.xpath("//*[contains(text(),'Request Our Source Books')]")).should(visible, Duration.ofSeconds(20));
            }
        }
        if (link.equals("SIGNUP FOR EMAILS")) {
            estoreFooterScreen.getEmailSignUp().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getEmailSignUp().click();
            if (Hooks.profile.equals("stg4")) {
                $(By.xpath("//*[contains(text(),'Sign Up For Emails')]")).should(visible, Duration.ofSeconds(20));
            }
        }
        if (link.equals("RH MEMBERS PROGRAM")) {
            estoreFooterScreen.getMembershipProgram().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getMembershipProgram().click();
            if (Hooks.profile.equals("stg4")) {

            }
        }
        if (link.equals("RH TRADE")) {
            estoreFooterScreen.getRhTradeLink().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getRhTradeLink().click();
            if (Hooks.profile.equals("stg4")) {

            }
        }
        if (link.equals("RH CREDIT CARD")) {

        }
        if (link.equals("SITE MAP")) {
            estoreFooterScreen.getSiteMapLink().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getSiteMapLink().click();
            if (Hooks.profile.equals("stg4")) {
                $(By.xpath("//*[contains(text(),'RH Site Map')]")).should(visible, Duration.ofSeconds(20));
            }
        }
        if (link.equals("CONTACT US")) {
            estoreFooterScreen.getContactUS().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getContactUS().click();
            if (Hooks.profile.equals("stg4")) {
                $(By.xpath("(//*[contains(text(),'Contact Us')])[3]")).should(visible, Duration.ofSeconds(20));
            }
        }
        if (link.equals("PLACING AN ORDER")) {
            estoreFooterScreen.getPlacingAnOrderLink().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getPlacingAnOrderLink().click();
            if (Hooks.profile.equals("stg4")) {
                $(By.xpath("//*[contains(text(),'Place An Order')]")).should(visible, Duration.ofSeconds(20));
            }
        }

        if (link.equals("SHIPPING & DELIVERY")) {
            estoreFooterScreen.getShippingDeliveryLink().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getShippingDeliveryLink().click();
            if (Hooks.profile.equals("stg4")) {
                $(By.xpath("//*[contains(text(),'Shipping')]")).should(visible, Duration.ofSeconds(20));
            }
        }
        if (link.equals("RETURNS & EXCHANGES")) {
            estoreFooterScreen.getReturnExchangesLink().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getReturnExchangesLink().click();
            if (Hooks.profile.equals("stg4")) {
                $(By.xpath("//*[contains(text(),'RETURNS')]")).should(visible, Duration.ofSeconds(20));
            }
        }
        if (link.equals("RH GIFT CARD")) {
            estoreFooterScreen.getRhGiftCardLink().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getRhGiftCardLink().click();
            if (Hooks.profile.equals("stg4")) {
                $(By.xpath("(//*[contains(text(),'All RH Gift Cards')])[2]")).should(visible, Duration.ofSeconds(20));
            }
        }
        if (link.equals("GIFT REGISTRY")) {
            estoreFooterScreen.getRhGiftRegistryLink().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getRhGiftRegistryLink().click();
            if (Hooks.profile.equals("stg4")) {
                $(By.xpath("//*[contains(text(),'RH GIFT')]")).should(visible, Duration.ofSeconds(20));
                $(By.xpath("//*[contains(text(),'Registry')]")).should(visible, Duration.ofSeconds(20));
            }
        }
        if (link.equals("FAQS")) {
            estoreFooterScreen.getFaqSLink().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getFaqSLink().click();
            if (Hooks.profile.equals("stg4")) {
                $(By.xpath("//*[contains(text(),'FAQS')]")).should(visible, Duration.ofSeconds(20));
            }
        }

        if (link.equals("LETTERS FROM THE CEO")) {
            estoreFooterScreen.getLettersFromCeoLink().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getLettersFromCeoLink().click();
            if (Hooks.profile.equals("stg4")) {
                ArrayList<String> tabs = new ArrayList<>(getWindowsHandles());
                switchTo().window(tabs.get(1));
                $(By.xpath("(//*[contains(text(),'LETTERS FROM THE CEO')])[4]")).should(visible, Duration.ofSeconds(20));
            }
        }
        if (link.equals("INVESTOR RELATIONS")) {
            estoreFooterScreen.getInvestoreRelationsLink().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getInvestoreRelationsLink().click();
            if (Hooks.profile.equals("stg4")) {
                ArrayList<String> tabs = new ArrayList<>(getWindowsHandles());
                switchTo().window(tabs.get(1));
                $(By.xpath("//*[contains(text(),'Financials & Filings')]")).should(visible, Duration.ofSeconds(20));
            }
        }

        if (link.equals("PRESS")) {
            estoreFooterScreen.getPressLink().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getPressLink().click();
            if (Hooks.profile.equals("stg4")) {
                ArrayList<String> tabs = new ArrayList<>(getWindowsHandles());
                switchTo().window(tabs.get(1));
                $(By.xpath("//*[contains(text(),'in the news')]")).should(visible, Duration.ofSeconds(20));
            }
        }

        if (link.equals("CAREERS")) {
            estoreFooterScreen.getCareersLink().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getCareersLink().click();
            if (Hooks.profile.equals("stg4")) {
                ArrayList<String> tabs = new ArrayList<>(getWindowsHandles());
                switchTo().window(tabs.get(1));
                $(By.xpath("(//*[contains(text(),'EXPLORE OUR RESTAURANTS')])[2]")).should(visible, Duration.ofSeconds(20));
            }
        }

        if (link.equals("PRIVACY")) {
            estoreFooterScreen.getPrivacyLink().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getPrivacyLink().click();
            if (Hooks.profile.equals("stg4")) {
                $(By.xpath("(//*[contains(text(),'RH PRIVACY POLICY')])")).should(visible, Duration.ofSeconds(20));
            }
        }
        if (link.equals("TERMS OF USE")) {
            estoreFooterScreen.getTermsOfUseLink().should(visible, Duration.ofSeconds(20));
            estoreFooterScreen.getTermsOfUseLink().click();
            if (Hooks.profile.equals("stg4")) {

            }
        }
    }
}