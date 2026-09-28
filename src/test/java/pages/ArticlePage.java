package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticlePage extends BasePage {
    private By favoriteButton = By.cssSelector("button[fx-action$='/favorite']");
    private By unfavoriteButton = By.cssSelector("button[fx-action$='/unfavorite']");
    private By editButton = By.xpath("//a[normalize-space()='Edit Article']");
    private By deleteButton = By.xpath("//button[normalize-space()='Delete Article']");
    private By commentTextArea = By.name("body");
    private By postCommentButton = By.xpath("//button[normalize-space()='Post Comment']");

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed(String title){
        By titleLocator = By.xpath("//h1[normalize-space()='" + title + "']");
        return waitForVisibility(titleLocator).isDisplayed();
    }

    public void favorite() {
        waitForClickable(favoriteButton).click();
        waitUntilFavorited();
    }

    public void unfavorite() {
        waitForClickable(unfavoriteButton).click();
        waitUntilUnfavorited();
    }

    public boolean isFavorited() {
        wait.until(driver ->
                !driver.findElements(favoriteButton).isEmpty()
                        || !driver.findElements(unfavoriteButton).isEmpty()
        );

        return !driver.findElements(unfavoriteButton).isEmpty();
    }

    public void waitUntilFavorited(){
        wait.until(driver ->
                !driver.findElements(unfavoriteButton).isEmpty());
    }

    public void waitUntilUnfavorited(){
        wait.until(driver ->
                !driver.findElements(favoriteButton).isEmpty());
    }

    public ArticleEditorPage clickEditArticle() {
        waitForClickable(editButton).click();
        return new ArticleEditorPage(driver);
    }

    public HomePage clickDeleteArticle() {
        waitForClickable(deleteButton).click();
        return new HomePage(driver);
    }

    public void enterComment(String comment){
        waitForVisibility(commentTextArea).sendKeys(comment);
    }

    public void clickPostComment() {
        waitForClickable(postCommentButton).click();
    }

    public boolean isCommentDisplayed(String comment){
        By commentLocator = By.xpath("//p[contains(@class, 'card-text')][normalize-space()='" + comment + "']");

        return wait.until(driver ->
                !driver.findElements(commentLocator).isEmpty());
    }
}
