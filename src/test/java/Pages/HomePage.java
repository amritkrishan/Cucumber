package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By homePageOneWay=By .xpath("//span[@class='radio_state']");
    /*By homePageRoundTrip=By .xpath("//input[@name='way_fields' and @value='round_trip']");
    By homePageMultiCity=By .xpath("//input[@name='way_fields' and @value='multi_city']");*/
    By homePageFrom=By .xpath("//input[@id='from_typeahead1']");
    By homePageTo=By .xpath("//input[@id='to_typeahead1']");
    By homePageFromDate=By .xpath("//*[@class='selctdate']");
    By homePageFromDateSelect=By .xpath("//td[@fare-date='22-6-2016']");
    By homePageToDate=By .xpath("//a[contains(@id,'return_date_sec') and .//text()='Select Date']");
    By homePageToDateSelect=By .xpath("//td[@fare-date='21-7-2016']");
    By homePageSubmit=By .xpath("//a[@id='flights_submit']");

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void clickOnOneWay()
    {
        driver.findElement(homePageOneWay).click();
    }
    public void enterFromAndTo(String from,String to) throws InterruptedException
    {
        driver.findElement(homePageFrom).sendKeys(from);
        driver.findElement(homePageTo).click();
        driver.findElement(homePageTo).sendKeys(to);
        Thread.sleep(2000);
    }
    public void enterFromAndToDate() throws InterruptedException
    {
        driver.findElement(homePageFromDate).click();
        driver.findElement(homePageFromDateSelect).click();
        driver.findElement(homePageToDate).click();
        driver.findElement(homePageToDateSelect).click();
        Thread.sleep(2000);
        driver.findElement(homePageSubmit).click();
        Thread.sleep(20000);
    }

}
