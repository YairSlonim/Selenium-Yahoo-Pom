package Pages;

import Pages.BasePage;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.List;

public class YahooSportPage extends BasePage {
    By nbaButton = By.cssSelector("#root_3");
    By nbaTeamsNames = By.cssSelector("#subnavhtml-NBA > div >  div:nth-child(1) > div > div");
    By searchInput = By.cssSelector("#ybar-sbq");
    By searchResultOptions = By.cssSelector("#ybar-sf > div:nth-child(6) > div > div > ul:nth-child(2)");
    By resultOption = By.cssSelector("div:nth-child(2)>div>span");
    By teamReboundAvg = By.cssSelector("#Col1-0-Team-Proxy > div > div:nth-child(1) > div > div:nth-child(2) > div > ul > li:nth-child(4) > div:nth-child(2) > div > a > span");

    public YahooSportPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    @Step("Put the mouse hover nba button for open menu with teams names")
    public void HoverSport() {

        waitUntilVisibilityElementLocated(nbaButton);
        WebElement element = findElem(nbaButton);
        Actions action = new Actions(getDriver());
        action.moveToElement(element).perform();
        Allure.addAttachment("Go to Yahoo.com", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    @Step("Save first five teams names in a list and write them into new excel file")
    public void getAllNbaTeamsNames() {
        waitUntilVisibilityElementLocated(nbaTeamsNames);
        // List<WebElement> temp = findElems(By.cssSelector("#subnavhtml-NBA > div > div:nth-child(1)> div:nth-child(1) > div:nth-child(2) > div"));

        List<WebElement> listOfNbaTeams = findElems(By.cssSelector("#subnavhtml-NBA > div > div:nth-child(1)> div:nth-child(1) > div:nth-child(2) > div"));
        writeListToFile(listOfNbaTeams);
        click(nbaButton);
        Allure.addAttachment("Go to Yahoo.com", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    @Step("Write list into new excel file")
    public void writeListToFile(List<WebElement> lst) {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("src/test/java/DataBase/NbaTeamsNames.csv"));
            for (WebElement index : lst) {
                bw.write(index.getText() + "\n");
            }
            bw.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        Allure.addAttachment("Go to Yahoo.com", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    @Step("Read teams names from excel then send each one separately, then print the avg team rebounds" +
            " that returned from the search function")
    public void searchNbaTeamsFromExel() {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("src/test/java/DataBase/NbaTeamsNames.csv"));
            String s;
            int count = 0;
            while ((s = br.readLine()) != null && count < 5) {
                count++;
                search(s);

                WebElement elem = findElem(teamReboundAvg);
                System.out.println("rebound avg: " + elem.getText());
            }
            br.close();
        } catch (Exception ex) {
            System.out.println(ex);

        }
        Allure.addAttachment("Go to Yahoo.com", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    @Step("type into search field the team name then search for the correct result and click on it ")
    public void search(String teamName) {
        typeInto(teamName, searchInput);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement dropdown = findElem(searchResultOptions);
        List<WebElement> options = dropdown.findElements(By.tagName("li"));
        for (WebElement option : options) {
            if (option.findElement(resultOption).getText().equals("NBA")) {
                option.click();
                break;
            }
        }
        Allure.addAttachment("Go to Yahoo.com", new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
