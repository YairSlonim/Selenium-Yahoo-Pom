package Pages;

import Pages.BasePage;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;

public class YahooLoginPage extends BasePage {

    By nextButton = By.cssSelector("#login-signin");
    By emailErrorMsg = By.cssSelector("#username-error");
    By emailInput = By.cssSelector("#login-username");
    By passwordInput = By.cssSelector("#login-passwd");
    By passwordErrorMsg = By.cssSelector(".error-msg");
    public YahooLoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    @Step("Click next with empty email field and print the error message")
    public void clickNextWithEmptyEmail()
    {
        click(nextButton);
        waitUntilVisibilityElementLocated(emailErrorMsg);
        System.out.println(findElem(emailErrorMsg).getText());
        Allure.addAttachment("Go to Yahoo.com", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    @Step("Click next with only letters in email field and print the error message")
    public void clickNextWithOnlyLettersInEmailField()
    {
        typeInto("aaaaasssdfg", emailInput);
        click(nextButton);
        waitUntilVisibilityElementLocated(emailErrorMsg);
        System.out.println(findElem(emailErrorMsg).getText());
        Allure.addAttachment("Go to Yahoo.com", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    @Step("Delete email field value")
    public void delete()
    {
        removeInput(emailInput,findElem(emailInput).getAttribute("value"));
        Allure.addAttachment("empty form", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    @Step("Click next with only numbers in email field and print the error message")
    public void clickNextWithOnlyNumbersInEmailField()
    {
        typeInto("11111122223", emailInput);
        click(nextButton);
        waitUntilVisibilityElementLocated(emailErrorMsg);
        System.out.println(findElem(emailErrorMsg).getText());
        Allure.addAttachment("Go to Yahoo.com", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    @Step("Click next correct email")
    public void clickNextWithCorrectEmail()
    {
        typeInto("yairslonim@yahoo.com", emailInput);
        click(nextButton);
        Allure.addAttachment("Go to Yahoo.com", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    @Step("Click next with wrong password and print the error message")
    public void clickNextWithWrongPassword()
    {
        waitUntilVisibilityElementLocated(passwordInput);
        typeInto("123123", passwordInput);
        click(nextButton);
        waitUntilVisibilityElementLocated(passwordErrorMsg);
        System.out.println(findElem(passwordErrorMsg));
        Allure.addAttachment("Go to Yahoo.com", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    @Step("Click next with correct password")
    public void clickNextWithCorrectDetails()
    {
        typeInto("@123123123Aa", passwordInput);
        click(nextButton);
        Allure.addAttachment("Go to Yahoo.com", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
