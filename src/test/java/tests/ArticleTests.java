package tests;

import base.AuthenticatedTest;
import base.BaseTest;
import data.TestDataReader;
import data.TestUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArticleTests extends AuthenticatedTest {
    @Test
    void shouldOpenArticleSuccessfully(){
        String articleTitle = "Middle-Out Compression: The Algorithm That Changed Everything";
        ArticlePage articlePage = homePage.clickArticle(articleTitle);
        assertTrue(articlePage.isTitleDisplayed(articleTitle));
    }
}
