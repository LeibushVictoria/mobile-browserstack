package pages;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FoundPage {

    @Step("Verify content on the found page")
    public void verifyContentOnTheFoundPage(String text) {
        $(MobileBy.id("org.wikipedia.alpha:id/view_page_title_text")).shouldHave(text(text));
    }
}
