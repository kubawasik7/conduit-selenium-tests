package tests;

import base.AuthenticatedTest;
import org.junit.jupiter.api.Test;
import pages.ArticleEditorPage;
import pages.ArticlePage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArticleTests extends AuthenticatedTest {

    private static final String EXISTING_ARTICLE_TITLE =
            "Middle-Out Compression: The Algorithm That Changed Everything";
    private static final String ARTICLE_TITLE = "Selenium test article";
    private static final String ARTICLE_DESCRIPTION = "example description";
    private static final String ARTICLE_BODY = "example body";
    private static final String ARTICLE_TAG = "example tag";

    @Test
    void shouldOpenArticleSuccessfully() {
        ArticlePage articlePage = homePage.clickArticle(EXISTING_ARTICLE_TITLE);

        assertTrue(articlePage.isTitleDisplayed(EXISTING_ARTICLE_TITLE));
    }

    @Test
    void shouldFavoriteArticleSuccessfully() {
        ArticlePage articlePage = homePage.clickArticle(EXISTING_ARTICLE_TITLE);

        if (articlePage.isFavorited()) {
            articlePage.unfavorite();
        }

        articlePage.favorite();

        assertTrue(articlePage.isFavorited());
    }

    @Test
    void shouldUnfavoriteArticleSuccessfully() {
        ArticlePage articlePage = homePage.clickArticle(EXISTING_ARTICLE_TITLE);

        if (!articlePage.isFavorited()) {
            articlePage.favorite();
        }

        articlePage.unfavorite();

        assertFalse(articlePage.isFavorited());
    }

    @Test
    void shouldCreateArticleSuccessfully() {
        String articleTitle = generateUniqueArticleTitle();

        ArticlePage articlePage = createArticle(articleTitle);

        assertTrue(articlePage.isTitleDisplayed(articleTitle));
    }

    @Test
    void shouldNotCreateArticleWithoutTitle() {
        ArticleEditorPage editorPage = homePage.clickNewArticle();

        editorPage.enterDescription(ARTICLE_DESCRIPTION);
        editorPage.enterBody(ARTICLE_BODY);
        editorPage.enterTags(ARTICLE_TAG);
        editorPage.clickPublishArticle();

        assertTrue(driver.getCurrentUrl().contains("/editor"));
    }

    @Test
    void shouldNotCreateArticleWithoutDescription() {
        ArticleEditorPage editorPage = homePage.clickNewArticle();

        editorPage.enterTitle(EXISTING_ARTICLE_TITLE);
        editorPage.enterBody(ARTICLE_BODY);
        editorPage.enterTags(ARTICLE_TAG);
        editorPage.clickPublishArticle();

        assertTrue(driver.getCurrentUrl().contains("/editor"));
    }

    @Test
    void shouldNotCreateArticleWithoutBody() {
        ArticleEditorPage editorPage = homePage.clickNewArticle();

        editorPage.enterTitle(EXISTING_ARTICLE_TITLE);
        editorPage.enterDescription(ARTICLE_DESCRIPTION);
        editorPage.enterTags(ARTICLE_TAG);
        editorPage.clickPublishArticle();

        assertTrue(driver.getCurrentUrl().contains("/editor"));
    }

    @Test
    void shouldEditArticleSuccessfully() {
        String articleTitle = generateUniqueArticleTitle();
        String updatedTitle = "Updated Selenium test article " + System.currentTimeMillis();

        ArticlePage articlePage = createArticle(articleTitle);

        ArticleEditorPage editorPage = articlePage.clickEditArticle();
        editorPage.updateTitle(updatedTitle);

        articlePage = editorPage.submitArticle();

        assertTrue(articlePage.isTitleDisplayed(updatedTitle));
    }

    @Test
    void shouldDeleteArticleSuccessfully() {
        String articleTitle = generateUniqueArticleTitle();

        ArticlePage articlePage = createArticle(articleTitle);

        homePage = articlePage.clickDeleteArticle();

        assertFalse(homePage.isArticleDisplayed(articleTitle));
    }

    @Test
    void shouldAddCommentSuccessfully() {
        ArticlePage articlePage = homePage.clickArticle(EXISTING_ARTICLE_TITLE);
        String comment = generateUniqueComment();

        articlePage.enterComment(comment);
        articlePage.clickPostComment();

        assertTrue(articlePage.isCommentDisplayed(comment));
    }

    @Test
    void shouldDeleteCommentSuccessfully() {
        ArticlePage articlePage = homePage.clickArticle(EXISTING_ARTICLE_TITLE);
        String comment = generateUniqueComment();

        articlePage.enterComment(comment);
        articlePage.clickPostComment();

        assertTrue(articlePage.isCommentDisplayed(comment));

        articlePage.deleteComment(comment);

        assertTrue(articlePage.isCommentRemoved(comment));
    }

    @Test
    void shouldNotAddEmptyComment() {
        ArticlePage articlePage = homePage.clickArticle(EXISTING_ARTICLE_TITLE);

        articlePage.clickPostComment();

        assertTrue(articlePage.isCommentErrorDisplayed());
    }

    private ArticlePage createArticle(String title) {
        ArticleEditorPage editorPage = homePage.clickNewArticle();

        editorPage.enterTitle(title);
        editorPage.enterDescription(ARTICLE_DESCRIPTION);
        editorPage.enterBody(ARTICLE_BODY);
        editorPage.enterTags(ARTICLE_TAG);

        return editorPage.submitArticle();
    }

    private String generateUniqueArticleTitle() {
        return ARTICLE_TITLE + " " + System.currentTimeMillis();
    }

    private String generateUniqueComment() {
        return "Selenium test comment " + System.currentTimeMillis();
    }
}