package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private static final By SIGN_IN_LINK = By.cssSelector("a[href='/login']");
    private static final By USER_LINK = By.cssSelector("a[href^='/profile/']");
    private static final By NEW_ARTICLE_LINK = By.cssSelector("a[href='/editor']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickSignIn() {
        waitForClickable(SIGN_IN_LINK).click();
        return new LoginPage(driver);
    }

    public ArticlePage clickArticle(String title) {
        waitForClickable(articleLink(title)).click();
        return new ArticlePage(driver);
    }

    public ArticleEditorPage clickNewArticle() {
        waitForClickable(NEW_ARTICLE_LINK).click();
        return new ArticleEditorPage(driver);
    }

    public boolean isUserProfileDisplayed() {
        return waitForVisibility(USER_LINK).isDisplayed();
    }

    public boolean isArticleDisplayed(String title) {
        return !driver.findElements(articleLink(title)).isEmpty();
    }

    private By articleLink(String title) {
        return By.xpath(
                "//a[contains(@class, 'preview-link')]" +
                        "[.//h1[normalize-space()='" + title + "']]"
        );
    }
}