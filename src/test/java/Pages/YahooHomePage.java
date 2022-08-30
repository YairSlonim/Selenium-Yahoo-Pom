package Pages;

import Pages.BasePage;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;


public class YahooHomePage extends BasePage {

    By loginButton = By.cssSelector("._yb_17snh");
    By registerButton = By.cssSelector("#createacc");
    By sportButton = By.cssSelector("#root_4");

    public YahooHomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    @Step("Go to Yahoo.com")
    public void visitSite() {
        visitSite("https://www.yahoo.com");
        Allure.addAttachment("Go to Yahoo.com", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    @Step("Click on login and from there click on register")
    public void enterRegister() {
        click(loginButton);//i had to go into sing in first
        waitUntilVisibilityElementLocated(registerButton);
        click(registerButton);
        Allure.addAttachment("click on register", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));

    }
    @Step("click on  login")
    public void enterLogin() {
        click(loginButton);
        Allure.addAttachment("click on login", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    @Step("Click on sport button")
    public void enterSport()
    {
        waitUntilVisibilityElementLocated(sportButton);
        click(sportButton);
        Allure.addAttachment("click on sport button", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }


}

