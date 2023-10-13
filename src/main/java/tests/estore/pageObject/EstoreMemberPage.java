package tests.estore.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class EstoreMemberPage {
    private final SelenideElement membershipNumberText = $(By.xpath("//*[text()='Membership Number: ']"));
    private final SelenideElement membershipNumberValue = $(By.xpath("//*[text()='102003851']"));
    private final SelenideElement membershipEnrollmentText = $(By.xpath("//*[text()='Enrollment: ']"));
    private final SelenideElement membershipEnrollmentValue = $(By.xpath("//*[text()='Jan  10,  2023']"));
    private final SelenideElement membershipMopText = $(By.xpath("//*[text()='Method of Payment: ']"));
    private final SelenideElement membershipEmailText = $(By.xpath("//*[text()='Email: ']"));
    private final SelenideElement membershipEmailValue = $(By.xpath("//*[text()='automationmember@rh.com']"));
    private final SelenideElement membershipRenewalText = $(By.xpath("//*[text()='You will be charged ']"));
    private final SelenideElement membershipRenewalAmount = $(By.xpath("//*[text()='$175.00']"));

    private final SelenideElement memberTitle = $(By.xpath("(//div[@class='MuiGrid-root MuiGrid-item'])[6]/p"));
    private final List<SelenideElement> membershipDetails = $$(By.xpath("(//div[@class='MuiGrid-root MuiGrid-container MuiGrid-direction-xs-column'])[2]/div/p"));
    private final SelenideElement addToCart = $(By.xpath("//span[@class='MuiButton-label' and text() = 'ADD TO CART']"));
    private final SelenideElement emailField = $(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input']"));
    private final SelenideElement linkEmailButton = $(By.xpath("//span[@class='MuiButton-label' and text() = 'LINK TO MEMBERSHIP']"));
    private final SelenideElement messageAlert = $(By.xpath("//div[@class='MuiAlert-message']"));
    private final SelenideElement cancelLink = $(By.xpath("//*[@data-analytics-id='link' and text() = 'Cancel Membership']"));
    private final SelenideElement confirmCncelMembershipButton = $(By.xpath("//*[text()='Cancel Membership']"));
    private final SelenideElement rhProgramProfile = $(By.xpath("//*[text()='RH MEMBERS PROGRAM PROFILE']"));
    private final SelenideElement areYouSureYouWantToCancelMembershipMsg = $(By.xpath("//*[text()='Are you sure you want to cancel your RH Members Program enrollment?']"));
    private final SelenideElement addToCartButton = $(By.id("addToCartMembershipDialog_becomeMember-btn"));
    private final SelenideElement emailAddressField = $(By.xpath("(//input[@type='text'])[2]"));
    private final SelenideElement frequentlyAskedQuestionsMsg = $(By.xpath("//*[text()='FREQUENTLY ASKED QUESTIONS']"));
    //cancel membership page
    private List<SelenideElement> benefitsList = $$(By.xpath("//*[@class='MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-direction-xs-column']/ul/li"));

    private final SelenideElement continueMembershipButton = $(By.xpath("//span[@class='MuiButton-label' and text() = 'Continue Membership']"));

    private final SelenideElement cancelMembershipButton = $(By.xpath("//span[@class='MuiButton-label' and text() = 'Cancel Membership']"));

    private final SelenideElement cancelMessage = $(By.xpath("//*[@class='MuiGrid-root MuiGrid-container MuiGrid-item MuiGrid-direction-xs-column MuiGrid-grid-xl-8']/p"));

    private final SelenideElement linkToMembership = $(By.xpath("//*[text()='LINK TO MEMBERSHIP']"));

    private final SelenideElement programDetailsLink = $(By.xpath("//*[text()='RH Members Program Details']"));


    public void clickToProgramDetailsLink() {
        programDetailsLink.should(Condition.visible).click();
    }

    public void programDetailsLinkDetails() {
        $(By.xpath("//*[text()='25% savings']")).should(Condition.visible);
        $(By.xpath("//*[contains(text(),'25% savings on all full-priced items')] ")).should(Condition.visible);
    }

    public void setValueForLinkMembershipEmail(String email) {
        emailAddressField.should(Condition.visible).setValue(email);
    }

    public void linkToMembershipIsDisplayed() {
        linkToMembership.should(Condition.visible);
    }

    public void clickToLinkToMembership() {
        linkToMembership.should(Condition.visible).click();
    }

    public void membershipDataIsDisplayed() {
        membershipNumberText.should(Condition.visible);
        membershipNumberValue.should(Condition.visible);
        membershipEnrollmentText.should(Condition.visible);
        membershipEnrollmentValue.should(Condition.visible);
        membershipMopText.should(Condition.visible);
        membershipEmailText.should(Condition.visible);
        membershipEmailValue.should(Condition.visible);
        membershipRenewalText.should(Condition.visible);
        membershipRenewalAmount.should(Condition.visible);
    }

    public void membershipDataIsNotDisplayed() {
        membershipNumberText.shouldNot(Condition.visible);
        membershipNumberValue.shouldNot(Condition.visible);
        membershipEnrollmentText.shouldNot(Condition.visible);
        membershipEnrollmentValue.shouldNot(Condition.visible);
        membershipMopText.shouldNot(Condition.visible);
        membershipEmailText.shouldNot(Condition.visible);
        membershipEmailValue.shouldNot(Condition.visible);
        membershipRenewalText.shouldNot(Condition.visible);
        membershipRenewalAmount.shouldNot(Condition.visible);
    }
}
