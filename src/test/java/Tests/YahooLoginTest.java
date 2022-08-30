package Tests;

import Pages.YahooLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YahooLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    public YahooLoginTest(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void runTests()
    {
        YahooLoginPage a = new YahooLoginPage(driver,wait);
        a.clickNextWithEmptyEmail();
        a.clickNextWithOnlyLettersInEmailField();
        a.delete();
        a.clickNextWithOnlyNumbersInEmailField();
        a.delete();
        a.clickNextWithCorrectEmail();
        a.clickNextWithWrongPassword();
        a.clickNextWithCorrectDetails();

    }
}
