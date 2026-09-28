package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By EMAIL_INPUT = By.name("email");
    private static final By SIGN_IN_BUTTON = By.xpath("//button[normalize-space()='Sign in']");
    private static final By INVALID_CREDENTIALS_ERROR = By.xpath("//ul[contains(@class, 'error-messages')]//li[normalize-space()='Invalid email or password']");
    private final JavascriptExecutor js;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.js = (JavascriptExecutor) driver;
    }

    public void enterEmail(String email) {
        waitForVisibility(EMAIL_INPUT).sendKeys(email);
    }

    public void enterPassword(String password) {
        waitForVisibility(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickSignIn() {
        waitForClickable(SIGN_IN_BUTTON).click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSignIn();
    }

    public boolean isEmailFieldDisplayed() {
        return waitForVisibility(EMAIL_INPUT).isDisplayed();
    }

    public boolean isCredentialsInvalidErrorDisplayed() {
        return waitForVisibility(INVALID_CREDENTIALS_ERROR).isDisplayed();
    }

    public boolean isEmailFieldValid() {
        return isFieldValid(EMAIL_INPUT);
    }

    public boolean isPasswordFieldValid() {
        return isFieldValid(PASSWORD_INPUT);
    }

    private boolean isFieldValid(By fieldLocator) {
        WebElement field = waitForVisibility(fieldLocator);

        return (Boolean) js.executeScript(
                "return arguments[0].validity.valid;",
                field
        );
    }
}