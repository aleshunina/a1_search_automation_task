import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selector.selector;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class testExecutor {
    public static final String URL="https://www.autohero.com/de/search/";

private static final By filterYearLocator = By.xpath("//div[@data-qa-selector='filter-year']");
private static final By openFilterYearLocator = By.xpath("//select[@data-qa-selector='select'and@name='yearRange.min']");
private static final By chooseFilterYearLocator = By.xpath("//option[@data-qa-selector-value='2015']");
private static final By filterPriceLocator = By.xpath("//div[@data-qa-selector='filter-price']");
private static final By openFilterPriceLocator = By.xpath("//select[@data-qa-selector='select'and@name='priceRange.max']");
private static final By PriceListLocator = By.className("option___2yqJT");

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\daleshun\\Desktop\\testtask_autohero\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get(URL);

        selector selector=new selector();

        selector.filter(driver,"year","2015");
        selector.filter(driver,"price","2000");
        //selector.sortbymaxvalue(driver, "price");



    }
}
