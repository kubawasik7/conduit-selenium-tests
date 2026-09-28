package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArticleEditorPage extends BasePage{
    private static final By TITLE_INPUT = By.name("title");
    private static final By DESCRIPTION_INPUT = By.cssSelector("input[name='description']");
    private static final By BODY_INPUT = By.name("body");
    private static final By TAGS_INPUT = By.className("tag-input-field");
    private static final By PUBLISH_BUTTON = By.xpath("//button[normalize-space()='Publish Article']");

    public ArticleEditorPage(WebDriver driver) {
        super(driver);
    }

    public void enterTitle(String title) {
        waitForVisibility(TITLE_INPUT).sendKeys(title);
    }

    public void enterDescription(String description) {
        waitForVisibility(DESCRIPTION_INPUT).sendKeys(description);
    }

    public void enterBody(String body) {
        waitForVisibility(BODY_INPUT).sendKeys(body);
    }

    public void enterTags(String tags) {
        waitForVisibility(TAGS_INPUT).sendKeys(tags, Keys.ENTER);
    }

    public void updateTitle(String title) {
        WebElement titleField = waitForVisibility(TITLE_INPUT);
        titleField.clear();
        titleField.sendKeys(title);
    }

    public ArticlePage submitArticle() {
        waitForClickable(PUBLISH_BUTTON).click();
        return new ArticlePage(driver);
    }

    public void clickPublishArticle() {
        waitForClickable(PUBLISH_BUTTON).click();
    }
}
