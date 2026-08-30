package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTests extends BaseTest {
    @Test
    void shouldOpenLoginPageSuccessfully() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickSignIn();
        assertTrue(loginPage.isEmailFieldDisplayed());
    }
}
