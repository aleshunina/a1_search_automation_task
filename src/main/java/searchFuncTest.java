import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SearchPage;
import popup.Modal;



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
            Assert.assertTrue(driver.findElement(By.xpath("//li[@data-qa-selector-value='2015'and@data-qa-selector='active-filter']")).isDisplayed());

            searchPage.filterByBiggestPrice();
            Assert.assertTrue(driver.findElement(By.xpath("//li[@data-qa-selector-value='100.000'and@data-qa-selector='active-filter']")).isDisplayed());
        }
        catch (NoSuchElementException ex){
            Modal modal=new Modal().dealwithmodal(driver);
        }

    }

    @AfterTest
    public void endSession(){
        driver.quit();
    }
}
