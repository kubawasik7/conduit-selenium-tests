package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticlePage extends BasePage {
    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed(String title){
        By titleLocator = By.xpath("//h1[normalize-space()='" + title + "']");
        return waitForVisibility(titleLocator).isDisplayed();
    }
}
