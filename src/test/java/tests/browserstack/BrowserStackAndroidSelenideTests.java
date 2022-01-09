package tests.browserstack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FoundPage;
import pages.MainPage;
import pages.MenuPage;

@Tag("browserstack_android")
public class BrowserStackAndroidSelenideTests extends BrowserStackTestBase {

    MainPage mainPage = new MainPage();
    FoundPage foundPage = new FoundPage();
    MenuPage menuPage = new MenuPage();

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        mainPage
                .enterSearchValue("BrowserStack")
                .verifyContentFound();
    }

    @Test
    @DisplayName("Search Gradle in wikipedia android app")
    void searchGradleTest() {
        mainPage
                .enterSearchValue("Gradle")
                .openFoundPage("Gradle");
        foundPage.verifyContentOnTheFoundPage("Gradle");
    }

    @Test
    @DisplayName("Open Settings in wikipedia android app")
    void openSettingsTest() {
        mainPage.clickMenuButton();
        menuPage
                .clickSettingsButton()
                .checkSettingsPage();
    }
}