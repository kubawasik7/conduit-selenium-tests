package base;

import data.TestDataReader;
import data.TestUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.HomePage;
import pages.LoginPage;

public class AuthenticatedTest extends BaseTest {
    private static TestUser testUser;
    protected HomePage homePage;

    @BeforeAll
    static void setUpTestData(){
        testUser = TestDataReader.getTestUser();
    }

    @BeforeEach
    void setUp(){
        homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickSignIn();
        loginPage.login(testUser.getEmail(), testUser.getPassword());
        this.homePage = new HomePage(driver);
    }
}
