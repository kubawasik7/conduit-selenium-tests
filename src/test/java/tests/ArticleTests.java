package tests;

import base.AuthenticatedTest;
import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.ArticleEditorPage;

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
        ArticleEditorPage articleEditorPage = homePage.clickNewArticle();
        articleEditorPage.enterTitle(articleTitle);
        articleEditorPage.enterDescription("test description");
        articleEditorPage.enterBody("test body");
        articleEditorPage.enterTags("test tag");
        ArticlePage articlePage = articleEditorPage.submitArticle();
        assertTrue(articlePage.isTitleDisplayed(articleTitle));
    }

    @Test
    void shouldEditArticleSuccessfully(){
        String uniqueId = String.valueOf(System.currentTimeMillis());
        String articleTitle = "Selenium test article " + uniqueId;
        String updatedTitle = "Updated Selenium test article " + uniqueId;

        ArticleEditorPage editorPage = homePage.clickNewArticle();
        editorPage.enterTitle(articleTitle);
        editorPage.enterDescription("test description");
        editorPage.enterBody("test body");
        editorPage.enterTags("test tag");
        ArticlePage articlePage = editorPage.submitArticle();

        ArticleEditorPage editPage = articlePage.clickEditArticle();
        editPage.updateTitle(updatedTitle);

        articlePage = editPage.submitArticle();
        assertTrue(articlePage.isTitleDisplayed(updatedTitle));
    }
}
