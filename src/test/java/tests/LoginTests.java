package tests;

import base.BaseTest;
import data.TestDataReader;
import data.TestUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static data.TestDataReader.getTestUser;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseTest {
    private static TestUser user;

    @BeforeAll
    static void setUpDataTest(){
        user = TestDataReader.getTestUser();
    }

    @Test
    void shouldOpenLoginPageSuccessfully() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickSignIn();
        assertTrue(loginPage.isEmailFieldDisplayed());
    }

    @Test
    void shouldLoginSuccessfully() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickSignIn();
        loginPage.login(user.getEmail(), user.getPassword());
        homePage = new HomePage(driver);
        assertTrue(homePage.isUserProfileDisplayed());
    }

    @Test
    void shouldRejectLoginWithInvalidPassword() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickSignIn();
        loginPage.login(user.getEmail(), "invalid_password");
        assertTrue(loginPage.isCredentialsInvalidErrorDisplayed());
    }

    @Test
    void shouldRejectLoginWithInvalidEmail() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickSignIn();
        loginPage.login("test@invalid_mail.com", user.getPassword());
        assertTrue(loginPage.isCredentialsInvalidErrorDisplayed());
    }

    @Test
    void shouldNotLoginWithEmptyEmail() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickSignIn();
        loginPage.enterEmail("");
        loginPage.enterPassword(user.getPassword());
        assertFalse(loginPage.isSignInButtonEnabled());
    }

    @Test
    void shouldNotLoginWithEmptyPassword() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickSignIn();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword("");
        assertFalse(loginPage.isSignInButtonEnabled());
    }
}
