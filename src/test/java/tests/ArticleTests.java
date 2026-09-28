package tests;

import base.AuthenticatedTest;
import org.junit.jupiter.api.Test;
import pages.ArticlePage;
import pages.ArticleEditorPage;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArticleTests extends AuthenticatedTest {
    private static final String EXISTING_ARTICLE_TITLE =
            "Middle-Out Compression: The Algorithm That Changed Everything";
    private static final String ARTICLE_DESCRIPTION = "example description";
    private static final String ARTICLE_BODY = "example body";
    private static final String ARTICLE_TAG = "example tag";

    @Test
    void shouldOpenArticleSuccessfully(){
        ArticlePage articlePage = homePage.clickArticle(EXISTING_ARTICLE_TITLE);
        assertTrue(articlePage.isTitleDisplayed(EXISTING_ARTICLE_TITLE));
    }

    @Test
    void shouldFavoriteArticleSuccessfully(){
        ArticlePage articlePage = homePage.clickArticle(EXISTING_ARTICLE_TITLE);

        if(articlePage.isFavorited()){
            articlePage.unfavorite();
        }

        articlePage.favorite();
        assertTrue(articlePage.isFavorited());
    }

    @Test
    void shouldUnfavoriteArticleSuccessfully(){
        ArticlePage articlePage = homePage.clickArticle(EXISTING_ARTICLE_TITLE);

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
        articleEditorPage.enterDescription(ARTICLE_DESCRIPTION);
        articleEditorPage.enterBody(ARTICLE_BODY);
        articleEditorPage.enterTags(ARTICLE_TAG);
        ArticlePage articlePage = articleEditorPage.submitArticle();
        assertTrue(articlePage.isTitleDisplayed(articleTitle));
    }

    @Test
    void shouldNotCreateArticleWithoutTitle(){
        ArticleEditorPage articleEditorPage = homePage.clickNewArticle();

        articleEditorPage.enterDescription(ARTICLE_DESCRIPTION);
        articleEditorPage.enterBody(ARTICLE_BODY);
        articleEditorPage.enterTags(ARTICLE_TAG);
        articleEditorPage.clickPublishArticle();

        assertTrue(driver.getCurrentUrl().contains("/editor"));
    }

    @Test
    void shouldEditArticleSuccessfully(){
        String uniqueId = String.valueOf(System.currentTimeMillis());
        String articleTitle = "Selenium test article " + uniqueId;
        String updatedTitle = "Updated Selenium test article " + uniqueId;

        ArticleEditorPage editorPage = homePage.clickNewArticle();
        editorPage.enterTitle(articleTitle);
        editorPage.enterDescription(ARTICLE_DESCRIPTION);
        editorPage.enterBody(ARTICLE_BODY);
        editorPage.enterTags(ARTICLE_TAG);
        ArticlePage articlePage = editorPage.submitArticle();

        ArticleEditorPage editPage = articlePage.clickEditArticle();
        editPage.updateTitle(updatedTitle);

        articlePage = editPage.submitArticle();
        assertTrue(articlePage.isTitleDisplayed(updatedTitle));
    }

    @Test
    void shouldDeleteArticleSuccessfully(){
        String uniqueId = String.valueOf(System.currentTimeMillis());
        String articleTitle = "Selenium test article " + uniqueId;

        ArticleEditorPage editorPage = homePage.clickNewArticle();
        editorPage.enterTitle(articleTitle);
        editorPage.enterDescription(ARTICLE_DESCRIPTION);
        editorPage.enterBody(ARTICLE_BODY);
        editorPage.enterTags(ARTICLE_TAG);
        ArticlePage articlePage = editorPage.submitArticle();
        homePage = articlePage.clickDeleteArticle();
        assertFalse(homePage.isArticleDisplayed(articleTitle));
    }
}
