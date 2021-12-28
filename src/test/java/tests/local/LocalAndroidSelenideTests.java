package tests.local;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.GettingStartedPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.*;


@Tag("local_android")
public class LocalAndroidSelenideTests extends LocalTestBase {

    MainPage mainPage = new MainPage();
    GettingStartedPage gettingStartedPage = new GettingStartedPage();

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        back();
        mainPage
                .enterSearchValue("BrowserStack")
                .verifyContentFound();
    }

    @Test
    @DisplayName("Successful getting started test in wikipedia android app")
    void gettingStartedTest() {
        gettingStartedPage
                .verifyTitle("The Free Encyclopedia …in over 300 languages")
                .clickContinue()
                .verifyTitle("New ways to explore")
                .clickContinue()
                .verifyTitle("Reading lists with sync")
                .clickContinue()
                .verifyTitle("Send anonymous data")
                .clickGetStarted();
        mainPage.checkMainPageIsOpened();
    }
}
