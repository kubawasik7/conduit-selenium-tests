package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{
    public static final By USERNAME = By.name("username");
    public static final By PASSWORD = By.name("password");
    public static final By EMAIL = By.name("email");
    public static final By SIGN_UP_BUTTON = By.xpath("//button[normalize-space()='Sign Up']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username){
        waitForVisibility(USERNAME).sendKeys(username);
    }

    public void enterPassword(String password){
        waitForVisibility(PASSWORD).sendKeys(password);
    }

    public void enterEmail(String email){
        waitForVisibility(EMAIL).sendKeys(email);
    }

    public void register(String username, String password, String email){
        enterUsername(username);
        enterEmail(email);
        enterPassword(password);

    }

    public void clickSignUpButton(){
        waitForClickable(SIGN_UP_BUTTON).click();
    }
}
