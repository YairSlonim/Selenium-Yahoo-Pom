import Tests.*;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyMain {

    WebDriver wd ;

    @BeforeClass
    public void createDriver()
    {
         wd = Utils.chooseBrowser(2);
    }

    @Test
    @Epic("Website Flow")
    @Feature("Loading Website")
    @Story("Going to Register Page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Visit Yahoo and Click Register")
    public void testCase1()
   {
        YahooHomeTest testA = new YahooHomeTest(wd);
        testA.runTests();
    }

    @Test
    @Epic("Registration Flow")
    @Feature("Registration Form")
    @Story("Test Multiple Error Cases")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Validate Registration  Inputs")
    public void testCase2()
    {
        YahooRegisterTest testB = new YahooRegisterTest(wd);
        testB.runTests();
    }

//    @Test
//    @Epic("Website Flow")
//    @Feature("Back to HomePage")
//    @Story("Going From Register To Login")
//    @Severity(SeverityLevel.MINOR)
//    @Description("Going From Register To Login")
//    public void testCase3()
//    {
//        YahooHomeTest testC = new YahooHomeTest(wd);
//        testC.runTests2();
//    }
//
//    @Test
//    @Epic("Login Flow")
//    @Feature("Login Form")
//    @Story("Test Multiple Error Cases")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Validate Login, Email And Password Inputs")
//    public void testCase4()
//    {
//        YahooLoginTest testD = new YahooLoginTest(wd);
//        testD.runTests();
//    }
//
//    @Test
//    @Epic("HomePage Flow")
//    @Feature("Back to HomePage")
//    @Story("Moving From HomePage To SportPAge")
//    @Severity(SeverityLevel.MINOR)
//    @Description("Moving From HomePage To SportPAge")
//    public void testCase5()
//    {
//        YahooHomeTest testE = new YahooHomeTest(wd);
//        testE.runTests3();
//    }
//
//    @Test
//    @Epic("SportPage Flow")
//    @Feature("Write To Excel And Read From Excel")
//    @Story("Search Nba Teams Names")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Take Nba Teams Names From Site Then Write them to File Then Read From" +
//            "This File Each Name And Search It And Take the Rebound Avg And Print it.")
//    public void testCase6()
//    {
//        YahooSportTest testF = new YahooSportTest(wd);
//        testF.runTests();
//    }


    @AfterTest
    public void Teardown() {
        wd.quit();
    }

}
