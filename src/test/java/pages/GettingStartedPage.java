package pages;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class GettingStartedPage {
    @Step("Click continue")
    public GettingStartedPage clickContinue() {
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        return this;
    }

    @Step("Verify content on page")
    public GettingStartedPage verifyTitle(String text) {
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(Condition.text(text));
        return this;
    }

    @Step("Click get started")
    public void clickGetStarted() {
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
    }
}
