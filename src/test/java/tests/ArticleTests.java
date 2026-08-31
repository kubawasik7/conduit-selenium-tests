package tests;

import base.AuthenticatedTest;
import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.NewArticlePage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArticleTests extends AuthenticatedTest {
    @Test
    void shouldOpenArticleSuccessfully(){
        String articleTitle = "Middle-Out Compression: The Algorithm That Changed Everything";
        ArticlePage articlePage = homePage.clickArticle(articleTitle);
        assertTrue(articlePage.isTitleDisplayed(articleTitle));
    }

    @Test
    void shouldFavoriteArticleSuccessfully(){
        String articleTitle = "Middle-Out Compression: The Algorithm That Changed Everything";
        ArticlePage articlePage = homePage.clickArticle(articleTitle);

        if(articlePage.isFavorited()){
            articlePage.unfavorite();
        }

        articlePage.favorite();
        assertTrue(articlePage.isFavorited());
    }

    @Test
    void shouldUnfavoriteArticleSuccessfully(){
        String articleTitle = "Middle-Out Compression: The Algorithm That Changed Everything";
        ArticlePage articlePage = homePage.clickArticle(articleTitle);

        if (!articlePage.isFavorited()) {
            articlePage.favorite();
        }

        articlePage.unfavorite();

        assertFalse(articlePage.isFavorited());
    }

    @Test
    void shouldCreateArticleSuccessfully(){
        String articleTitle = "Selenium test article " + System.currentTimeMillis();
        NewArticlePage newArticlePage = homePage.clickNewArticle();
        newArticlePage.enterTitle(articleTitle);
        newArticlePage.enterDescription("test description");
        newArticlePage.enterBody("test body");
        newArticlePage.enterTags("test tag");
        ArticlePage articlePage = newArticlePage.clickPublishButton();
        assertTrue(articlePage.isTitleDisplayed(articleTitle));
    }
}
