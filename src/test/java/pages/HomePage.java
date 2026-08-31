package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private By signInLink = By.cssSelector("a[href='/login']");
    private By userLink = By.cssSelector("a[href^='/profile/']");
    private By newArticleLink = By.cssSelector("a[href='/editor']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickSignIn(){
        waitForClickable(signInLink).click();
        return new LoginPage(driver);
    }

    public ArticlePage clickArticle(String title){
        By articleLink =
                By.xpath("//a[contains(@class, 'preview-link')][.//h1[normalize-space()='" + title + "']]");
        waitForClickable(articleLink).click();
        return new ArticlePage(driver);
    }

    public ArticleEditorPage clickNewArticle(){
        waitForClickable(newArticleLink).click();
        return new ArticleEditorPage(driver);
    }

    public boolean isUserProfileDisplayed(){
        return waitForVisibility(userLink).isDisplayed();
    }
}
