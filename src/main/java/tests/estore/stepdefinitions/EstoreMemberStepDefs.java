package tests.estore.stepdefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.Assert.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tests.estore.pageObject.EstoreCartPage;
import tests.estore.pageObject.EstoreItemPage;
import tests.estore.pageObject.EstoreMemberPage;
import tests.utility.Hooks;

public class EstoreMemberStepDefs {

    EstoreMemberPage estoreMemberPage = new EstoreMemberPage();
    EstoreGeneralStepDefs generalStepDefs = new EstoreGeneralStepDefs();
    EstoreItemPage estoreItemPage = new EstoreItemPage();
    EstoreCartPage estoreCartPage = new EstoreCartPage();

    //Non-members
    String expectedTitle = "RH MEMBERS PROGRAM PROFILE";
    String expectedRenewal =  "Your membership will auto-renew each year for $175, plus applicable taxes.";
    String expectedCancel = "You may cancel auto-renewal by calling the RH Members Program Concierge at 888.889.4739.";
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
        sleep(5000);
        assertEquals(estoreMemberPage.getMemberTitle().getText(), expectedTitle);
    }

    @Then("I validate membership details")
    public void iValidateMembershipDetails() {
        sleep(5000);
        List<String> items = new ArrayList<>();
        List<String> expectedItems = new ArrayList(Arrays.asList(expectedTitle, expectedParagraph, expectedParagraph2,
                expectedCreditCard, expectedRHCreditCard, expectedAnnual, expectedRenewal, expectedCancel, expectedEmail, expectedEnterEmail ));
        for (int i = 0; i < estoreMemberPage.getMembershipDetails().size(); i++) {
            items.add(estoreMemberPage.getMembershipDetails().get(i).getText());
        }
        assertEquals(items, expectedItems);
    }

    @Then("I validate add to cart button")
    public void iValidateAddToCartButton() {
        sleep(5000);
        assertTrue(estoreMemberPage.getAddToCart().isDisplayed());
        assertTrue(estoreMemberPage.getAddToCart().isEnabled());
    }

    @When("I click on add to cart button from membership")
    public void iClickOnAddToCartButtonFromMembership() {
        sleep(5000);
        estoreMemberPage.getAddToCart().click();
    }

    @Then("I validate cart")
    public void iValidateCart() {
        sleep(5000);
        String joinNowLink = "JOIN NOW";
        String removeLink = "REMOVE MEMBERSHIP";
        String membershipBannerTitle = "The RH MEMBERS PROGRAM";
        String membershipSavings = "You've elected to join the RH Members Program, and you'll save $1,474.00 on this order.";
        estoreCartPage.getCartTitle().shouldHave(text("CART"), Duration.ofSeconds(12));

        List<String> items = new ArrayList<>();
        List<String> expectedItems = new ArrayList(Arrays.asList(membershipBannerTitle, membershipSavings ));
        for (int i = 0; i < estoreCartPage.getMemberShipBannerList().size(); i++) {
            items.add(estoreCartPage.getMemberShipBannerList().get(i).getText());
        }
        assertEquals(items, expectedItems);

        assertEquals(estoreCartPage.getRemoveMembershipLink().getText(), removeLink);
        estoreCartPage.getRemoveMembershipLink().click();
        sleep(5000);
        assertEquals(estoreCartPage.getRemoveMembershipLink().getText(), joinNowLink);
    }

    @Then("I validate email address field and link to membership button")
    public void iValidateEmailAddressFieldAndLinkToMembershipButton() {
        estoreMemberPage.getEmailField().scrollTo();
        estoreMemberPage.getEmailField().isDisplayed();
        estoreMemberPage.getEmailField().click();

        estoreMemberPage.getEmailField().setValue("invalidemail@");
        assertTrue(estoreMemberPage.getLinkEmailButton().isEnabled());

        estoreMemberPage.getLinkEmailButton().click();

        assertEquals(estoreMemberPage.getMessageAlert().getText(), "Please enter valid email address.");
    }

    @Then("I validate membership details for member user")
    public void iValidateMembershipDetailsForMemberUser() {
        sleep(5000);
        List<String> items = new ArrayList<>();
        List<String> expectedItems = new ArrayList(Arrays.asList(expectedTitle, expectedMembershipNumber, expectedEnrollmentDate, expectedChargeAmount, expectedPaymentMethod,
                expectedOptOutMessage, expectedContactInfoHeading, expectedEmailAddress, expectedCancelLink, expectedCallNumber, expectedFaq, expectedTermsAndCondition ));
        for (int i = 0; i < estoreMemberPage.getMembershipDetails().size(); i++) {
            items.add(estoreMemberPage.getMembershipDetails().get(i).getText());
        }
        assertEquals(items, expectedItems);
    }

    @When("I click on cancel membership link")
    public void iClickOnCancelMembershipLink() {
        sleep(2000);
        assertTrue(estoreMemberPage.getCancelLink().isDisplayed());
        estoreMemberPage.getCancelLink().click();
    }

    @Then("I validate cancel membership content")
    public void iValidateCancelMembershipContent() {
        sleep(2000);
        Hooks.getCurrentUrl().equals("https://stg2.rhnonprod.com/my-account/membership-cancel.jsp");

        List<String> items = new ArrayList<>();
        List<String> expectedItems = new ArrayList(Arrays.asList(expectedSavings, expectedAdditionalSavings, expectedComplimentary,
                expectedConciergeService, expectedFinance, expectedEarlyAccess ));
        for (int i = 0; i < estoreMemberPage.getBenefitsList().size(); i++) {
            items.add(estoreMemberPage.getBenefitsList().get(i).getText());
        }
        assertEquals(items, expectedItems);
        assertTrue(estoreMemberPage.getContinueMembershipButton().isEnabled());
        assertTrue(estoreMemberPage.getCancelMembershipButton().isEnabled());
        assertEquals(estoreMemberPage.getCancelMessage().getText(), expectedCancelMessage);
    }
}
