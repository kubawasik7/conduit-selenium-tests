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
    void shouldRejectLoginWithNonexistentEmail() {
        loginPage.login("test@invalidmail.com", testUser.getPassword());
        assertTrue(loginPage.isCredentialsInvalidErrorDisplayed());
    }

    @Test
    void shouldRejectInvalidEmailFormat() {
        loginPage.login("test@invalid_format_email.pl", testUser.getPassword());
        assertFalse(loginPage.isEmailFieldValid());
    }

    @Test
    void shouldRejectEmptyEmail(){
        loginPage.login("", testUser.getPassword());
        assertFalse(loginPage.isEmailFieldValid());
    }

    @Test
    void shouldRejectEmptyPassword(){
        loginPage.login(testUser.getEmail(), "");
        assertFalse(loginPage.isPasswordFieldValid());
    }
}
