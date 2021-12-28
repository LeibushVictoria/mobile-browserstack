package tests.browserstack;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Tag("browserstack_android")
public class BrowserStackAndroidSelenideTests extends BrowserStackTestBase {

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("BrowserStack");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Search Gradle in wikipedia android app")
    void searchGradleTest() {
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("Gradle");
        });
        step("Open page", () ->
            $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                    .findBy(text("Gradle")).click());
        step("Verify content on the page", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/view_page_title_text"))
                        .shouldHave(text("Gradle")));
    }

    @Test
    @DisplayName("Open Settings in wikipedia android app")
    void openSettingsTest() {
        step("Click menu button", () ->
            $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click());
        step("Click settings button", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click());
        step("Check settings page", () ->
                $$(MobileBy.id("android:id/title")).findBy(text("Wikipedia language")).shouldBe(visible));
    }
}