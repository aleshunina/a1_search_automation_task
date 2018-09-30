import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SearchPage;
import popup.Modal;
import utility.ElementMaxValue;

public class SearchTest {

    private static final String URL="https://www.autohero.com/de/search/";
    private WebDriver driver;

    @BeforeTest
    public void initialize(){
        driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver.get(URL);
    }

    @Test
    public void searchSortFilterTest(){

        //try {

            SearchPage searchPage=new SearchPage(driver);

            searchPage.filterByYear("2015");
            searchPage.assertYearFilterPresence("2015");

            searchPage.filterByBiggestPrice();
            searchPage.assertPriceFilterPresence("100.000");

        }
        //catch (ElementNotInteractableException ex){

            //Modal modal = new Modal().dealwithmodal(driver);

        //}

    //}

    @AfterTest
    public void endSession(){
        driver.quit();
    }
}
