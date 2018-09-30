import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SearchPage;

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

            SearchPage searchPage=new SearchPage(driver);

            searchPage.filterByYear("2015");
            searchPage.assertYearFilterPresence("2015");

            searchPage.filterByBiggestPrice();
            searchPage.assertPriceFilterPresence("100.000");

        }

    @AfterTest
    public void endSession(){
        driver.quit();
    }
}
