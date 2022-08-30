package Tests;

import Pages.YahooRegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YahooRegisterTest {

    private WebDriver driver;
    private WebDriverWait wait;

    public YahooRegisterTest(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void runTests()
    {
        YahooRegisterPage a = new YahooRegisterPage(driver, wait);
        a.clickContinueWithEmptyEmail();
        a.clickContinueWithOnlyNumbersInEmail();
        a.clickContinueWithNoPassword();
        a.clickContinueWithOnlyNumbersInPassword();
        a.deleteFromFields();
        a.clickContinueWithCorrectFields();
    }
}
