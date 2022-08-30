package Pages;

import Pages.BasePage;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;

public class YahooRegisterPage extends BasePage {

    By continueButton = By.cssSelector("#reg-submit-button");
    By passwordInput = By.cssSelector("#usernamereg-password");

    By emailInput = By.cssSelector("#usernamereg-userId");
    By firstName = By.cssSelector("#usernamereg-firstName");
    By lastName = By.cssSelector("#usernamereg-lastName");
    By birthYear = By.cssSelector("#usernamereg-birthYear");
    By emailErrorMsg = By.cssSelector("#reg-error-userId");

    By passwordErrorMsg = By.cssSelector("#reg-error-password");
    public YahooRegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    @Step("Click continue with empty email field all the rest fields are correct" +
            " and print the error message")
    public void clickContinueWithEmptyEmail()
    {
        typeInto("yair",firstName);
        typeInto("slonim",lastName);
        typeInto("123123123",passwordInput);
        typeInto("1997",birthYear);
        click(continueButton);
        waitUntilVisibilityElementLocated(emailErrorMsg);
        System.out.println("empty email msg : "+findElem(emailErrorMsg).getText());
        Allure.addAttachment("error message after click continue with empty email", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    @Step("Click continue with only numbers in email field all the rest fields are correct" +
            " and print the error message")
    public void clickContinueWithOnlyNumbersInEmail()
    {
        typeInto("yair",firstName);
        typeInto("slonim",lastName);
        typeInto("123123", emailInput);
        typeInto("123123123",passwordInput);
        typeInto("1997",birthYear);
        click(continueButton);
        waitUntilVisibilityElementLocated(emailErrorMsg);
        System.out.println("email with no letter msg : "+findElem(emailErrorMsg).getText());
        Allure.addAttachment("error message after click continue with wrong email", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    @Step("Click continue with empty password field all the rest fields are correct" +
             " and print the error message")
    public void clickContinueWithNoPassword()
    {
        typeInto("yair",firstName);
        typeInto("slonim",lastName);
        typeInto("yairslonim", emailInput);
        typeInto("1997",birthYear);
        click(continueButton);
        waitUntilVisibilityElementLocated(passwordErrorMsg);
        System.out.println("empty password msg : "+findElem(passwordErrorMsg).getText());
        Allure.addAttachment("Go to Yahoo.com", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    @Step("Click continue with only numbers in password field all the rest fields are correct" +
            " and print the error message")
    public void clickContinueWithOnlyNumbersInPassword()
    {
        typeInto("yair",firstName);
        typeInto("slonim",lastName);
        typeInto("yairslonim", emailInput);
        typeInto("123123123",passwordInput);
        typeInto("1997",birthYear);
        click(continueButton);
        waitUntilVisibilityElementLocated(passwordErrorMsg);
        System.out.println("email with no letter msg : "+findElem(passwordErrorMsg).getText());
        Allure.addAttachment("error message after click continue with wrong password", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    @Step("Delete all fields values")
    public void deleteFromFields()
    {
        removeInput(firstName,findElem(firstName).getAttribute("value"));
        removeInput(lastName,findElem(lastName).getAttribute("value"));
        removeInput(emailInput,findElem(emailInput).getAttribute("value"));
        removeInput(birthYear,findElem(birthYear).getAttribute("value"));
        Allure.addAttachment("empty form", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    @Step("Click continue with correct values")
    public void clickContinueWithCorrectFields()
    {
        typeInto("yair",firstName);
        typeInto("slonim",lastName);
        typeInto("yairslonim", emailInput);
        typeInto("@123123123Aa",passwordInput);
        typeInto("1997",birthYear);
        click(continueButton);
        Allure.addAttachment("continue with correct fields", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
