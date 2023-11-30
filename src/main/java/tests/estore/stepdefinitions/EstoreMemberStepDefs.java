package tests.estore.stepdefinitions;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.estore.pageObject.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;
import static org.testng.Assert.assertTrue;

public class EstoreMemberStepDefs {

    EstoreMemberPage estoreMemberPage = new EstoreMemberPage();
    EstoreGeneralStepDefs generalStepDefs = new EstoreGeneralStepDefs();
    EstoreItemPage estoreItemPage = new EstoreItemPage();
    EstoreCartPage estoreCartPage = new EstoreCartPage();
    EstoreUserAccountPage estoreUserAccountPage = new EstoreUserAccountPage();
    EstorePaymentPage estorePaymentPage = new EstorePaymentPage();

    //Non-members
    String expectedTitle = "RH MEMBERS PROGRAM PROFILE";
    String expectedRenewal = "Your membership will auto-renew each year for $175, plus applicable taxes.";
    String expectedCancel = "You may cancel auto-renewal by calling 800.762.1005.";
    String expectedParagraph = "The RH Members Program offers savings of 25% on everything RH.* Every day. Become a member for a $175, plus applicable taxes. annual fee, members will save 25% on RH, RH Modern, RH Baby & Child and RH TEEN, as well as 10% savings on all Sale. Benefits include complimentary services with RH Interior Design, concierge service to manage your orders, eligibility for preferred financing† plans on RH Credit Card and early access to clearance events. FAQs";
    String expectedParagraph2 = "*Limited exclusions apply. † Minimum payments are required for each Credit Plan. Valid for single transaction only. If the single transaction has multiple shipments, each shipment may result in a separate Credit Plan, subject to a separate minimum purchase requirement and minimum interest charge. Valid in US only. Visit an RH Gallery or RH.com for details.";
    String expectedCreditCard = "Credit card offers are subject to credit approval.";
    String expectedRHCreditCard = "RH Credit Card accounts are issued by Comenity Bank.";
    String expectedAnnual = "Annual membership fee for Canadian residents is C$200";
    String expectedEmail = "If you signed up for the RH Members Program using a different email address than the one associated with your RH account, you will need to link your membership.";
    String expectedEnterEmail = "Enter the email address you used to sign up for the RH Members Program below, and we will send you an email where you can validate the link.";

    //Members
    String expectedMembershipNumber = "Membership Number: 101319911";
    String expectedEnrollmentDate = "Enrollment: May 2, 2022";
    String expectedChargeAmount = "You will be charged C$200.00 plus tax C$9.00 on May 2, 2023, for your next year of membership.";
    String expectedPaymentMethod = "Method of Payment: Visa ****************7543 Update/Replace";
    String expectedOptOutMessage = "Opt out\nYou have chosen to receive an email notification 3 days prior to your billing date.";
    String expectedContactInfoHeading = "CONTACT INFORMATION";
    String expectedEmailAddress = "Email: bnamdeo+0073@rh.com";
    String expectedCancelLink = "Cancel Membership";
    String expectedCallNumber = "If you have any questions, contact the dedicated Membership Concierge at 800.089.4739.";
    String expectedFaq = "RH Members Program FAQs.";
    String expectedTermsAndCondition = "RH Members Program Terms & Conditions.";

    //Cancel membership
    String expectedSavings = "25% savings on all full-priced items from RH, RH Modern, RH Baby & Child and RH TEEN";
    String expectedAdditionalSavings = "Additional 20% savings on all sale items";
    String expectedComplimentary = "Complimentary services with RH Interior Design";
    String expectedConciergeService = "Concierge service to manage your orders";
    String expectedFinance = "Preferred financing† plans on the RH Credit Card available, subject to approval";
    String expectedEarlyAccess = "Early access to clearance events";
    String expectedCancelMessage = "† Promotional financing available with RH credit card accounts offered by Comenity Bank, which determines qualifications for credit and promotion eligibility. Minimum purchase and minimum monthly payments are required. Subject to credit approval and availability. Account must be in good standing at time of transaction.";


    @Then("I validate membership title")
    public void iValidateMembershipTitile() {
        $(By.xpath("//*[text()='RH MEMBERS PROGRAM PROFILE']")).should(visible, Duration.ofSeconds(20));
    }

    @Then("I validate membership details")
    public void iValidateMembershipDetails() {
        $(By.xpath("//*[text()='RH MEMBERS PROGRAM PROFILE']")).should(visible, Duration.ofSeconds(30));
        $(By.xpath("//*[text()='CONTACT INFORMATION']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='FAQs']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='Terms & Conditions']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='RH Members Program ']")).should(visible, Duration.ofSeconds(20));
    }

    @Then("I validate add to cart button")
    public void iValidateAddToCartButton() {

        assertTrue(estoreMemberPage.getAddToCart().isDisplayed());
    }

    @When("I click on add to cart button from membership")
    public void iClickOnAddToCartButtonFromMembership() {

        estoreMemberPage.getAddToCart().click();
    }

    @Then("I validate cart")
    public void iValidateCart() {
        $(By.xpath("//*[text()='JOIN NOW']")).should(visible, Duration.ofSeconds(10));
    }

    @Then("I validate email address field and link to membership button")
    public void iValidateEmailAddressFieldAndLinkToMembershipButton() {
        System.out.println();
//        estoreMemberPage.getEmailField().scrollTo();
//        estoreMemberPage.getEmailField().isDisplayed();
//        estoreMemberPage.getEmailField().click();
//
//        estoreMemberPage.getEmailField().setValue("invalidemail@");
//        assertTrue(estoreMemberPage.getLinkEmailButton().isEnabled());
//
//        estoreMemberPage.getLinkEmailButton().click();
//
//        assertEquals(estoreMemberPage.getMessageAlert().getText(), "Please enter valid email address.");
    }

    @Then("I validate membership details for member user")
    public void iValidateMembershipDetailsForMemberUser() {

        $(By.xpath("//*[text()='Membership Number: ']")).should(visible, Duration.ofSeconds(30));
        $(By.xpath("//*[text()='Enrollment: ']")).should(visible, Duration.ofSeconds(30));
        $(By.xpath("//*[text()='You will be charged ']")).should(visible, Duration.ofSeconds(30));
        $(By.xpath("//*[text()='Method of Payment: ']")).should(visible, Duration.ofSeconds(30));
    }

    @When("I click on cancel membership link")
    public void iClickOnCancelMembershipLink() {
        estoreMemberPage.getCancelLink().should(visible).click();
    }

    @Then("I validate cancel membership content")
    public void iValidateCancelMembershipContent() {

        $(By.xpath("//*[text()='25% savings on all full-priced items from RH, RH Modern, RH Baby & Child and RH TEEN']")).should(visible, Duration.ofSeconds(30));
        $(By.xpath("//*[text()='Additional 20% savings on all sale items']")).should(visible, Duration.ofSeconds(30));
        $(By.xpath("//*[text()='Complimentary services with RH Interior Design']")).should(visible, Duration.ofSeconds(30));
        $(By.xpath("//*[text()='Preferred financing† plans on the RH Credit Card available, subject to approval']")).should(visible, Duration.ofSeconds(30));
        $(By.xpath("//*[text()='Early access to clearance events']")).should(visible, Duration.ofSeconds(30));
        $(By.xpath("//*[text()='Continue Membership']")).should(visible, Duration.ofSeconds(30));
        $(By.xpath("//*[text()='Cancel Membership']")).should(visible, Duration.ofSeconds(30));

    }

    @When("I goes to click on cart button from header")
    public void iGoesToClickOnCartButtonFromHeader() {
        estoreUserAccountPage.getCartButton().should(visible, Duration.ofMinutes(1));
        estoreUserAccountPage.getCartButton().click();
    }

    @When("I click on terms & condition link")
    public void iClickOnTermsConditionLink() {
        $(By.xpath("//*[contains(text(),'Terms & Conditions')]")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[contains(text(),'Terms & Conditions')]")).click();
    }

    @Then("I verify that rh members program terms & condition pop up is displayed")
    public void iVerifyThatRhMembersProgramTermsCondition() {
        $(By.xpath("//*[text()='RH MEMBERS PROGRAM TERMS & CONDITIONS']")).should(visible, Duration.ofSeconds(30));
    }

    @Then("I verify that email address displayed in membership page")
    public void iVerifyThatEmailAddressDisplayedInMembershipPage() {
        $(By.xpath("//*[text()='automationmember@rh.com']")).should(visible, Duration.ofSeconds(25));
    }

    @When("I click on FAQa link for estore")
    public void iClickOnFAQaLinkForEstore() {
        $(By.xpath("//*[text()='FAQs']")).should(visible, Duration.ofSeconds(20));
        $(By.xpath("//*[text()='FAQs']")).click();
    }

    @Then("I verfiy that frequently asked questions page is displayed")
    public void iVerfiyThatFrequentlyAskedQuestionsPageIsDisplayed() {
        estoreMemberPage.getFrequentlyAskedQuestionsMsg().should(visible);
    }

    @Then("I verify that membership is cancelled")
    public void iVerifyThatMembershipIsCancelled() {
        $(By.xpath("//*[text()='You have successfully added the RH Members Program to your cart.']")).shouldNotBe(visible, Duration.ofSeconds(30));
    }

    @Then("I verify that save card to account checkbox should be checked by defaults")
    public void iVerifyThatSaveCardToAccountCheckboxShouldBeCheckedByDefaults() {
        $(By.cssSelector("select[id=\"page-checkout-payment_select-payment-method\"]")).should(Condition.and("", appear, exist, interactable), Duration.ofSeconds(20));
        with().pollInterval(3, SECONDS).await().until(() -> true);
        estorePaymentPage.getChoosePaymentMethodBtn().should(Condition.be(visible), Duration.ofSeconds(35));
        Select selectPayment = new Select(estorePaymentPage.getChoosePaymentMethodBtn());
        selectPayment.selectByValue("CC");
        $(By.xpath("//input[@type='checkbox']")).should(selected, Duration.ofSeconds(30));
    }

    @When("I click to add to cart on membership page")
    public void iClickToAddToCartOnMembershipPage() {
        estoreMemberPage.getAddToCartButton().should(interactable, Duration.ofSeconds(25));
        estoreMemberPage.getAddToCartButton().shouldHave(text("ADD TO CART"), Duration.ofSeconds(25));
        with().pollInterval(3, SECONDS).await().until(() -> true);
        estoreMemberPage.getAddToCartButton().should(visible, Duration.ofSeconds(25)).hover()
                .click(ClickOptions.usingJavaScript());
    }


    @Then("I verify that the memberID, enrollment date, renewal date and price, MOP are displayed")
    public void iVerifyThatTheMemberIDEnrollmentDateRenewalDateAndPriceMOPAreDisplayed() {
        estoreMemberPage.membershipDataIsDisplayed();
    }

    @Then("I verify that the copy is displayed for non member user")
    public void iVerifyThatTheCopyIsDisplayedForNonMemberUser() {
        estoreMemberPage.membershipDataIsNotDisplayed();
    }

    @And("I verify that link to membership functionality is displayed")
    public void iVerifyThatLinkToMembershipFunctionalityIsDisplayed() {
        estoreMemberPage.linkToMembershipIsDisplayed();
    }

    @Then("I verify that membership program details link")
    public void iVerifyThatMembershipProgramDetailsLink() {
        estoreMemberPage.clickToProgramDetailsLink();
        estoreMemberPage.programDetailsLinkDetails();
    }

    @Then("I verify that email address to enter and link the membership")
    public void iVerifyThatEmailAddressToEnterAndLinkTheMembership() {
        System.out.println();
    }

    @Then("I verify the membership cancel link")
    public void iVerifyTheMembershipCancelLink() {
        estoreMemberPage.getCancelMembershipButton().should(visible);
        estoreMemberPage.getRhProgramProfile().should(visible);
        estoreMemberPage.getAreYouSureYouWantToCancelMembershipMsg().should(visible);
    }

    @When("I introduce email address to link membership field")
    public void iIntroduceEmailAddressToLinkMembershipField() {
        estoreMemberPage.setValueForLinkMembershipEmail("automationmember@rh.com");
    }

    @Then("I verify that user is able to link membership")
    public void iVerifyThatUserIsAbleToLinkMembership() {
        System.out.println();
    }

    @When("I click on link membership buttom")
    public void iClickOnLinkMembershipButtom() {
        estoreMemberPage.clickToLinkToMembership();
    }

    @When("I click on add membership to cart button")
    public void iClickOnAddMembershipToCartButton() {
        System.out.println();
    }

}