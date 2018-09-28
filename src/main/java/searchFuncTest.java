import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SearchPage;
import popup.Modal;
import utility.ElementMaxValue;

public class searchFuncTest {

    public static final String URL="https://www.autohero.com/de/search/";
    WebDriver driver;

    @BeforeTest
    public void initialize(){
        driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver.get(URL);
    }

    @Test
    public void searchSortFilterTest(){

        try {

            SearchPage searchPage=new SearchPage(driver);

            searchPage.filterByYear("2015");
            searchPage.assertPriceFilterPresence("2015");

            searchPage.filterByBiggestPrice();
            searchPage.assertPriceFilterPresence("100.000");

        }
        catch (Exception ex){

            Modal modal = new Modal().dealwithmodal(driver);

        }

    }

    @AfterTest
    public void endSession(){
        driver.quit();
    }
}
