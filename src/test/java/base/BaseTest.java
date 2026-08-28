package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected WebDriver webDriver;

    @BeforeEach
    void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        webDriver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown(){
        webDriver.quit();
    }
}
