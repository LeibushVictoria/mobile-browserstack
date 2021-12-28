package pages;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MenuPage {

    @Step("Click settings button")
    public MenuPage clickSettingsButton() {
        $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click();
        return this;
    }

    @Step("Check settings page")
    public void checkSettingsPage() {
        $$(MobileBy.id("android:id/title")).findBy(text("Wikipedia language")).shouldBe(visible);
    }
}
