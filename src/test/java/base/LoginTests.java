package base;

import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseTest {
    @Test
    void shouldOpenLoginPageSuccessfully()
    {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickSignIn();
        assertTrue(loginPage.isEmailFieldDisplayed());
    }
}
