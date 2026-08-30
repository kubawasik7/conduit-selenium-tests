package tests;

import base.BaseTest;
import data.TestDataReader;
import data.TestUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseTest {
    private static TestUser user;
    private LoginPage loginPage;

    @BeforeAll
    static void setUpDataTest(){
        user = TestDataReader.getTestUser();
    }

    @BeforeEach
    void setUp(){
        HomePage homePage = new HomePage(driver);
        loginPage = homePage.clickSignIn();
    }

    @Test
    void shouldLoginSuccessfully() {
        loginPage.login(user.getEmail(), user.getPassword());
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isUserProfileDisplayed());
    }

    @Test
    void shouldRejectLoginWithInvalidPassword() {
        loginPage.login(user.getEmail(), "invalid_password");
        assertTrue(loginPage.isCredentialsInvalidErrorDisplayed());
    }

    @Test
    void shouldRejectLoginWithInvalidEmail() {
        loginPage.login("test@invalid_mail.com", user.getPassword());
        assertTrue(loginPage.isCredentialsInvalidErrorDisplayed());
    }

    @Test
    void shouldNotLoginWithEmptyEmail() {
        loginPage.enterEmail("");
        loginPage.enterPassword(user.getPassword());
        assertFalse(loginPage.isSignInButtonEnabled());
    }

    @Test
    void shouldNotLoginWithEmptyPassword() {
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword("");
        assertFalse(loginPage.isSignInButtonEnabled());
    }
}
