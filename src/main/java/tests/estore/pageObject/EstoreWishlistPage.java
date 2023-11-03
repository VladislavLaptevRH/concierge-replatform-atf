package tests.estore.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class EstoreWishlistPage {
    private final SelenideElement removeButtonWishList = $(By.xpath("(//*[@data-testid='component-wishlist-line-item-card-actions_remove'])[1]"));

    private final List<SelenideElement> listOfWishItems = $$(By.xpath("//a[@class='MuiTypography-root MuiLink-root MuiLink-underlineHover MuiTypography-colorPrimary']"));

    private final SelenideElement whistItem = $(By.id("rh-line-item-card"));

    private final SelenideElement memberPrice = $(By.xpath("//p[@data-testid='price-label-member']"));

    private SelenideElement wishListTitle = $(By.xpath("(//*[text()='Wishlist'])[2]"));

    public void verifyThatWishListTitleIsDisplayed() {
        wishListTitle.should(Condition.visible, Duration.ofSeconds(15));
    }
}
