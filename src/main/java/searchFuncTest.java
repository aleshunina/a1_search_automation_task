import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import selector.Selector;


public class searchFuncTest {
    public static final String URL="https://www.autohero.com/de/search/";
    WebDriver driver;

    @BeforeTest
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get(URL);
    }

    @Test
    public void searchSortFilterTest(){
        Selector selector=new Selector();

        try {
            selector.filter(driver, "year", "2015");

            Assert.assertTrue(driver.findElement(By.xpath("//li[@data-qa-selector-value='2015'and@data-qa-selector='active-filter']")).isDisplayed());

            selector.sortbymaxvalue(driver, "price");

            Assert.assertTrue(driver.findElement(By.xpath("//li[@data-qa-selector-value='100.000'and@data-qa-selector='active-filter']")).isDisplayed());
        }
        catch (NoSuchElementException ex){

            WebElement modal = driver.findElement(By.xpath("//button[@class='close'and@type='button']"));
            modal.click();
            WebElement filter = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-qa-selector='filter-year']")));

        }

    }

    @AfterTest
    public void endSession(){
        driver.quit();
    }
}
