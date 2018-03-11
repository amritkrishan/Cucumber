package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightSearchPage {
    WebDriver driver;
    By flightSearchCheapest=By .xpath("//p[@class='stk_btm_price text-right spcl_prce ng-binding']");
    By flightSearchDepFilter=By .xpath("//span[@class='make_blockElm filter_dep_time hidden-xs hidden-sm visible-md hidden-lg ng-binding']");
    public FlightSearchPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void cheapestFare()
    {
        System.out.println(driver.findElement(flightSearchCheapest).getText());
    }
    public void clickOnFilter()
    {
        driver.findElement(flightSearchDepFilter).click();
    }
}
