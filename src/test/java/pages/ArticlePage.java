package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticlePage extends BasePage {
    private By favoriteButton = By.cssSelector("button[fx-action$='/favorite']");
    private By unfavoriteButton = By.cssSelector("button[fx-action$='/unfavorite']");

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed(String title){
        By titleLocator = By.xpath("//h1[normalize-space()='" + title + "']");
        return waitForVisibility(titleLocator).isDisplayed();
    }

    public void favorite(){
        waitForClickable(favoriteButton).click();
    }

    public boolean isFavorited(){
        return waitForVisibility(unfavoriteButton).isDisplayed();
    }
}
