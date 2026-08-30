package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    private By passwordInput = By.name("password");
    private By emailInput = By.name("email");
    private By signInButton = By.xpath("//button[normalize-space()='Sign in']");
    private By invalidCredentialsError = By.xpath("//ul[contains(@class, 'error-messages')]//li[normalize-space()='Invalid email or password']");

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

    public boolean isEmailFieldValid() {
        WebElement email = waitForVisibility(emailInput);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Boolean) js.executeScript(
                "return arguments[0].validity.valid;",
                email);
    }
    public boolean isPasswordFieldValid() {
        WebElement password = waitForVisibility(passwordInput);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Boolean) js.executeScript(
                "return arguments[0].validity.valid;",
                password);
    }
}
