package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private By emailInput = By.name("email");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEmailFieldDisplayed(){
        return waitForVisibility(emailInput).isDisplayed();
    }
}
