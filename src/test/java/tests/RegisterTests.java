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
}
