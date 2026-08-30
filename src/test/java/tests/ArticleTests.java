package tests;

import base.BaseTest;
import data.TestDataReader;
import data.TestUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArticleTests extends BaseTest {
    private static TestUser testUser;

    @BeforeAll
    static void setUpTestData(){
        testUser = TestDataReader.getTestUser();
    }

    @Test
    void shouldOpenArticleSuccessfully(){
        String article = "Middle-Out Compression: The Algorithm That Changed Everything";
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickSignIn();
        loginPage.login(testUser.getEmail(), testUser.getPassword());
        homePage = new HomePage(driver);
        ArticlePage articlePage = homePage.clickArticle(article);
        assertTrue(articlePage.isTitleDisplayed(article));
    }
}
