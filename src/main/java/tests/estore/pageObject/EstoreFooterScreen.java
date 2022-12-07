package tests.estore.pageObject;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class EstoreFooterScreen {

    private final SelenideElement locateAGallery = $(By.xpath("//a[@href='/store-locations/stores.jsp']"));

    private final SelenideElement viewSourceBooks = $(By.xpath("//a[@href='https://catalogs.rh.com/BookshelfView/']"));

    private final SelenideElement requestASource = $(By.xpath("//a[@href='/customer-service/catalog-request.jsp']"));

    private final SelenideElement requestACatalog = $(By.xpath("//a[@href='/customer-service/catalog-request.jsp']"));

    private final SelenideElement emailSignUp = $(By.xpath("//a[@href='/customer-service/email-signup.jsp']"));

    private final SelenideElement membershipProgram = $(By.xpath("//a[@href='/membership']"));

    private final SelenideElement rhTradeLink = $(By.xpath("//a[@href='/trade']"));

    private final SelenideElement rhCreditCardLink = $(By.xpath("//a[@href='/customer-experience/credit-card']"));

    private final SelenideElement siteMapLink = $(By.xpath("//a[@href='/sitemap.jsp']"));


    private final SelenideElement contactUS = $(By.xpath("//a[@href='/customer-service/contact-us.jsp']"));

    private final SelenideElement placingAnOrderLink = $(By.xpath("//a[@href='/customer-experience/placing-an-order']"));

    private final SelenideElement shippingDeliveryLink = $(By.xpath("//a[@href='/customer-experience/shipping-and-delivery']"));

    private final SelenideElement returnExchangesLink = $(By.xpath("//a[@href='/customer-service/return-policy.jsp']"));

    private final SelenideElement rhGiftCardLink = $(By.xpath("//a[@href='/catalog/category/products.jsp?categoryId=cat7440069']"));

    private final SelenideElement rhGiftRegistryLink = $(By.xpath("//a[@href='/gift-registry']"));

    private final SelenideElement faqSLink = $(By.xpath("//a[@href='/customer-experience/frequently-asked-questions']"));


    private final SelenideElement lettersFromCeoLink = $(By.xpath("//a[@href='https://rh.online/letters-blog']"));

    private final SelenideElement leadershipTeamLink = $(By.xpath("//a[@href='https://ir.rh.com/corporate-governance/leadership']"));

    private final SelenideElement investoreRelationsLink = $(By.xpath("//a[@href='https://ir.rh.com/']"));

    private final SelenideElement pressLink = $(By.xpath("//a[@href='https://rh.online/']"));

    private final SelenideElement careersLink = $(By.xpath("//a[@href='https://hcqq.fa.us2.oraclecloud.com/hcmUI/CandidateExperience/en/sites/CX_1']"));


    private final SelenideElement privacyLink = $(By.xpath("//a[@href='/our-company/privacy-policy']"));

    private final SelenideElement termsOfUseLink = $(By.xpath("//a[@href='/our-company/terms-of-use']"));

    private final SelenideElement textMessagingTerms = $(By.xpath("//a[@href='/our-company/text-messaging-terms']"));

    private final SelenideElement rhInCanada = $(By.xpath("//a[@href='/our-company/text-messaging-terms']"));

    private final SelenideElement safetyRecallsLink = $(By.xpath("//a[@href='/customer-experience/safety-recalls']"));


}
