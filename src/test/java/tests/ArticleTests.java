package tests;

import base.AuthenticatedTest;
import org.junit.jupiter.api.Test;
import pages.ArticlePage;

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
}
