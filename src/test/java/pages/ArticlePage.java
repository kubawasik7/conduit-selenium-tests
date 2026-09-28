package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticlePage extends BasePage {
    private static final By FAVORITE_BUTTON =
            By.cssSelector("button[fx-action$='/favorite']");
    private static final By UNFAVORITE_BUTTON =
            By.cssSelector("button[fx-action$='/unfavorite']");
    private static final By EDIT_BUTTON =
            By.xpath("//a[normalize-space()='Edit Article']");
    private static final By DELETE_BUTTON =
            By.xpath("//button[normalize-space()='Delete Article']");
    private static final By COMMENT_TEXT_AREA =
            By.name("body");
    private static final By POST_COMMENT_BUTTON =
            By.xpath("//button[normalize-space()='Post Comment']");
    private static final By COMMENT_ERROR =
            By.xpath("//div[@id='comment-list'][contains(., 'Comment body is required')]");

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed(String title) {
        return waitForVisibility(articleTitle(title)).isDisplayed();
    }

    public void favorite() {
        waitForClickable(FAVORITE_BUTTON).click();
        waitUntilFavorited();
    }

    public void unfavorite() {
        waitForClickable(UNFAVORITE_BUTTON).click();
        waitUntilUnfavorited();
    }

    public boolean isFavorited() {
        wait.until(driver ->
                !driver.findElements(FAVORITE_BUTTON).isEmpty()
                        || !driver.findElements(UNFAVORITE_BUTTON).isEmpty()
        );

        return !driver.findElements(UNFAVORITE_BUTTON).isEmpty();
    }

    public void waitUntilFavorited() {
        wait.until(driver ->
                !driver.findElements(UNFAVORITE_BUTTON).isEmpty());
    }

    public void waitUntilUnfavorited() {
        wait.until(driver ->
                !driver.findElements(FAVORITE_BUTTON).isEmpty());
    }

    public ArticleEditorPage clickEditArticle() {
        waitForClickable(EDIT_BUTTON).click();
        return new ArticleEditorPage(driver);
    }

    public HomePage clickDeleteArticle() {
        waitForClickable(DELETE_BUTTON).click();
        return new HomePage(driver);
    }

    public void enterComment(String comment) {
        waitForVisibility(COMMENT_TEXT_AREA).sendKeys(comment);
    }

    public void clickPostComment() {
        waitForClickable(POST_COMMENT_BUTTON).click();
    }

    public boolean isCommentDisplayed(String comment) {
        return wait.until(driver ->
                !driver.findElements(comment(comment)).isEmpty());
    }

    public void deleteComment(String comment) {
        waitForClickable(deleteCommentButton(comment)).click();
    }

    public boolean isCommentRemoved(String comment) {
        return wait.until(driver ->
                driver.findElements(comment(comment)).isEmpty());
    }

    public boolean isCommentErrorDisplayed() {
        return waitForVisibility(COMMENT_ERROR).isDisplayed();
    }

    private By articleTitle(String title) {
        return By.xpath("//h1[normalize-space()='" + title + "']");
    }

    private By comment(String comment) {
        return By.xpath(
                "//p[contains(@class, 'card-text')][normalize-space()='" + comment + "']"
        );
    }

    private By deleteCommentButton(String comment) {
        return By.xpath(
                "//p[contains(@class, 'card-text')][normalize-space()='" + comment + "']" +
                        "/ancestor::div[contains(@class, 'card')]//i[@fx-method='DELETE']"
        );
    }
}