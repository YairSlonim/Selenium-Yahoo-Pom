package Tests;

import Pages.YahooSportPage;
import jdk.jfr.Timespan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YahooSportTest {

    private WebDriver driver;
    private WebDriverWait wait;

    public YahooSportTest(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void runTests()
    {
        YahooSportPage a = new YahooSportPage(driver,wait);
        a.HoverSport();
        a.getAllNbaTeamsNames();
        a.searchNbaTeamsFromExel();
    }
}
