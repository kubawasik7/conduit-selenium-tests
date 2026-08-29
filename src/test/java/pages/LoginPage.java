package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private By passwordInput = By.name("password");
    private By emailInput = By.name("email");
    private By signInButton = By.xpath("//button[normalize-space()='Sign in']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email){
        waitForVisibility(emailInput).sendKeys(email);
    }

    public void enterPassword(String password){
        waitForVisibility(passwordInput).sendKeys(password);
    }

    public HomePage clickSignIn(){
        waitForClickable(signInButton).click();
        return new HomePage(driver);
    }

    public boolean isEmailFieldDisplayed(){
        return waitForVisibility(emailInput).isDisplayed();
    }
}
