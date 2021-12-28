package tests.selenoid;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


@Tag("selenoid_android")
public class SelenoidAndroidSelenideTests extends SelenoidTestBase {

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        back();
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("BrowserStack");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Successful getting started test in wikipedia android app")
    void gettingStartedTest() {
        step("Verify content on page 1", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia …in over 300 languages")));
        step("Click continue", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());
        step("Verify content on page 2", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore")));
        step("Click continue", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());
        step("Verify content on page 3", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists with sync")));
        step("Click continue", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());
        step("Verify content on page 4", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Send anonymous data")));
        step("Click get started", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click());
        step("Check if main page is opened", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/search_container")).shouldBe(Condition.visible));
    }
}