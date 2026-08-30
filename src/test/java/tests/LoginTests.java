package tests;

import base.BaseTest;
import data.TestDataReader;
import data.TestUser;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static data.TestDataReader.getTestUser;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseTest {
    @Test
    void shouldOpenLoginPageSuccessfully() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickSignIn();
        assertTrue(loginPage.isEmailFieldDisplayed());
    }

    @Test
    void shouldLoginSuccessfully() {
        TestUser user = TestDataReader.getTestUser();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickSignIn();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickSignIn();
        homePage = new HomePage(driver);
        assertTrue(homePage.isUserProfileDisplayed());
    }

}
