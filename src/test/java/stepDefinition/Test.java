package stepDefinition;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.FlightSearchPage;
import Pages.HomePage;


public class Test {
    WebDriver driver;

    HomePage objHomePage;
    FlightSearchPage objFlightSearchPage;
    @Given("^Successfully Navigated to Make my trip Home Page$")
    public void firstGivenClause()throws Throwable {
        Path workspacePath = Paths.get(System.getProperty("user.dir"),"chromedriver.exe");
        File file = new File(workspacePath.toString());
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.makemytrip.com/flights");
        Thread.sleep(5000);
    }
    @When("^I enter all the valid data to search flights between destinations and click on submit$")
    public void firstWhenenClause(DataTable table)throws Throwable {
        objHomePage = new HomePage(driver);
        //objHomePage.clickOnOneWay();
        System.out.println(table);
        List<List<String>> data=table.raw();
        System.out.println(data.get(1).get(1));
        objHomePage.enterFromAndTo(data.get(1).get(1),data.get(2).get(1));
        Thread.sleep(2000);
        objHomePage.enterFromAndToDate();
    }
    @Then("^It should list down all the flights available with fare filtered based on departure time$")
    public void firstThenClause()throws Throwable {
        objFlightSearchPage = new FlightSearchPage(driver);
        Thread.sleep(3000);
        objFlightSearchPage.cheapestFare();
        objFlightSearchPage.clickOnFilter();
        driver.quit();
    }
}