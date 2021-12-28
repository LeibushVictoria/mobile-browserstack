package pages;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    @Step("Search on main page")
    public MainPage enterSearchValue(String text) {
        $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val(text);
        return this;
    }

    @Step("Verify content found")
    public void verifyContentFound() {
        $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
    }

    @Step("Check if main page is opened")
    public void checkMainPageIsOpened() {
        $(MobileBy.id("org.wikipedia.alpha:id/search_container")).shouldBe(Condition.visible);
    }

    @Step("Open found page")
    public void openFoundPage(String text) {
        $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).findBy(text(text)).click();
    }

    @Step("Click menu button")
    public void clickMenuButton() {
        $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
    }
}
