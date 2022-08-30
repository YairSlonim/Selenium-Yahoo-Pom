package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void visitSite(String url)
    {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void waitUntilVisibilityElementLocated(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement findElem(By locator)
    {
       return driver.findElement(locator);
    }

    public List<WebElement> findElems(By locator)
    {
        return driver.findElements(locator);
    }
    public List<String> findElemsText(By locator)
    {
        List<String> stringList = new ArrayList<>();
        List<WebElement> tempList =  driver.findElements(locator);
                for(WebElement index: tempList)
                {
                    stringList.add(index.getText());
                };
                return stringList;
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void typeInto(String Text, By locator){
        findElem(locator).sendKeys(Text);
        //return findElem(locator);
    }

    public void click(By locator) {
        findElem(locator).click();
    }

    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void removeInput(By locator, String str) {
        for (int i = 0; i < str.length(); i++) {
            findElem(locator).sendKeys(Keys.BACK_SPACE);
        }
    }

    public void impWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void fluentWait(By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return findElem(locator);
            }
        });
    }

    public void selectFromDropDownListByValue(By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }
}
