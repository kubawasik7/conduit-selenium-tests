package tests;

import base.BaseTest;
import data.TestDataReader;
import data.TestUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTests extends BaseTest {
    private static TestUser testUser;
    private RegisterPage registerPage;

    @BeforeAll
    static void setUpTestData(){
        testUser = TestDataReader.getRegistrationUser();
    }

    @BeforeEach
    void setUp(){
        HomePage homePage = new HomePage(driver);
        registerPage = homePage.clickSignUp();
    }

    @Test
    void shouldRegisterUserSuccessfully() {
        registerPage.register(testUser.getUsername(), testUser.getEmail(), testUser.getPassword());
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isUserProfileDisplayed());
    }

    @Test
    void shouldNotRegisterUserWithEmptyUsername() {
        registerPage.enterEmail(testUser.getEmail());
        registerPage.enterPassword(testUser.getPassword());
        registerPage.clickSignUpButton();
        assertTrue(driver.getCurrentUrl().contains("/register"));
    }

    @Test
    void shouldNotRegisterUserWithEmptyPassword() {
        registerPage.enterUsername(testUser.getUsername());
        registerPage.enterEmail(testUser.getEmail());
        registerPage.clickSignUpButton();
        assertTrue(driver.getCurrentUrl().contains("/register"));
    }

    @Test
    void shouldNotRegisterUserWithEmptyEmail() {
        registerPage.enterUsername(testUser.getUsername());
        registerPage.enterPassword(testUser.getPassword());
        registerPage.clickSignUpButton();
        assertTrue(driver.getCurrentUrl().contains("/register"));
    }

    @Test
    void shouldNotRegisterUserWithInvalidEmail(){
        registerPage.register(testUser.getUsername(), "invalidEmail-gmail.com", testUser.getPassword());
        assertTrue(driver.getCurrentUrl().contains("/register"));
    }

    @Test
    void shouldNotRegisterUserWithExistingEmail(){
        registerPage.register(testUser.getUsername(), testUser.getEmail(), testUser.getPassword());
        assertTrue(registerPage.isRegistrationErrorDisplayed());
    }

    @Test
    void shouldNotRegisterUserWithExistingUsername(){
        registerPage.register(testUser.getUsername(), "NonExistingEmail@gmail.com", testUser.getPassword());
        assertTrue(registerPage.isRegistrationErrorDisplayed());
    }
}
