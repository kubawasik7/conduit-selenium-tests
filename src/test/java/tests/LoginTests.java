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
    private static TestUser testUser;
    private LoginPage loginPage;

    @BeforeAll
    static void setUpDataTest(){
        testUser = TestDataReader.getTestUser();
    }

    @BeforeEach
    void setUp(){
        HomePage homePage = new HomePage(driver);
        loginPage = homePage.clickSignIn();
    }

    @Test
    void shouldLoginSuccessfully() {
        loginPage.login(testUser.getEmail(), testUser.getPassword());
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isUserProfileDisplayed());
    }

    @Test
    void shouldRejectLoginWithInvalidPassword() {
        loginPage.login(testUser.getEmail(), "invalid_password");
        assertTrue(loginPage.isCredentialsInvalidErrorDisplayed());
    }

    @Test
    void shouldRejectLoginWithInvalidEmail() {
        loginPage.login("test@invalid_mail.com", testUser.getPassword());
        assertTrue(loginPage.isCredentialsInvalidErrorDisplayed());
    }

    @Test
    void shouldRejectEmptyEmail(){
        loginPage.enterEmail("");
        loginPage.enterPassword(testUser.getPassword());
        loginPage.clickSignIn();
        assertFalse(loginPage.isEmailFieldValid());
    }

    @Test
    void shouldRejectEmptyPassword(){
        loginPage.enterEmail(testUser.getEmail());
        loginPage.enterPassword("");
        loginPage.clickSignIn();
        assertFalse(loginPage.isPasswordFieldValid());
    }
}
