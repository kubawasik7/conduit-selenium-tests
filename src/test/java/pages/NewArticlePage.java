package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class NewArticlePage extends BasePage{
    private By titleInput = By.name("title");
    private By descriptionInput = By.name("description");
    private By bodyInput = By.name("body");
    private By tagsInput = By.className("tag-input-field");
    private By publishButton = By.xpath("//button[normalize-space()='Publish Article']");

    public NewArticlePage(WebDriver driver) {
        super(driver);
    }

    public void enterTitle(String title){
        waitForVisibility(titleInput).sendKeys(title);
    }

    public void enterDescription(String description){
        waitForVisibility(descriptionInput).sendKeys(description);
    }

    public void enterBody(String body){
        waitForVisibility(bodyInput).sendKeys(body);
    }

    public void enterTags(String tags){
        waitForVisibility(tagsInput).sendKeys(tags, Keys.ENTER);
    }

    public ArticlePage clickPublishButton(){
        waitForClickable(publishButton).click();
        return new ArticlePage(driver);
    }
}
