package Tests;

import Pages.YahooHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YahooHomeTest {

    private WebDriver driver;
    private WebDriverWait wait;

    public YahooHomeTest(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void runTests()
    {
        YahooHomePage a = new YahooHomePage(driver,wait);
        a.visitSite();
        a.enterRegister();
    }

    public void runTests2()
    {
        YahooHomePage b = new YahooHomePage(driver,wait);
        b.visitSite();
        b.enterLogin();
    }

    public void runTests3()
    {
        YahooHomePage c = new YahooHomePage(driver,wait);
        c.enterSport();

    }
}
