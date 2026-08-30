package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private By passwordInput = By.name("password");
    private By emailInput = By.name("email");
    private By signInButton = By.xpath("//button[normalize-space()='Sign in']");
    private By invalidCredentialsError = By.xpath("//ul[contains(@class, 'error-messages')]//li[normalize-space()='credentials invalid']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email){
        waitForVisibility(emailInput).sendKeys(email);
    }

    public void enterPassword(String password){
        waitForVisibility(passwordInput).sendKeys(password);
    }

    public void clickSignIn(){
        waitForClickable(signInButton).click();
    }

    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickSignIn();
    }

    public boolean isEmailFieldDisplayed(){
        return waitForVisibility(emailInput).isDisplayed();
    }

    public boolean isCredentialsInvalidErrorDisplayed(){
        return waitForVisibility(invalidCredentialsError).isDisplayed();
    }
}
