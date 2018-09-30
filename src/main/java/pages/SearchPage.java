package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import page_elements.Filter;
import utility.ElementMaxValue;

public class SearchPage {

    private static final String URL="https://www.autohero.com/de/search/";
    private WebDriver driver;

    @FindBy(xpath = "//div[@data-qa-selector='filter-year']")
    private WebElement yearFilter;

    @FindBy(xpath = "//select[@data-qa-selector='select'and@name='yearRange.min']")
    private WebElement yearFilterSelector;

    @FindBy(xpath = "//div[@data-qa-selector='filter-price']")
    private WebElement priceFilter;

    @FindBy(xpath = "//select[@data-qa-selector='select'and@name='priceRange.max']")
    private WebElement priceFilterSelector;



    public SearchPage(WebDriver driver) {

        if (!driver.getCurrentUrl().contains(URL)) {
            throw new IllegalStateException(
                    "This is not the page you are expected"
            );
        }

        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public SearchPage filterByYear(String year){

        Filter filter=new Filter();

        filter.waitAndClick(yearFilter, driver);
        filter.waitAndClick(yearFilterSelector, driver);
        WebElement choosevaluefilter = driver.findElement(By.xpath("//option[@data-qa-selector-value='"+year+"']"));
        filter.waitAndClick(choosevaluefilter, driver);
        filter.waitAndClick(yearFilterSelector, driver);

        By filterbanner=By.xpath("//li[@data-qa-selector-value='"+year+"'and@data-qa-selector='active-filter']");
        filter.presenceOfElementLocated(filterbanner, driver);

        return new SearchPage(driver);

    }

    public SearchPage filterByBiggestPrice () {

        ElementMaxValue value = new ElementMaxValue();
        Filter filter = new Filter();

        filter.waitAndClick(priceFilter, driver);
        filter.waitAndClick(priceFilterSelector, driver);
        WebElement choosevaluefilter = driver.findElement(By.xpath("//option[@data-qa-selector-value='"+value.sortmaxvalue(driver, By.xpath("//select[@data-qa-selector='select'and@name='priceRange.max']//option"))+"']"));
        filter.waitAndClick(choosevaluefilter, driver);
        filter.waitAndClick(priceFilterSelector, driver);

        By filterbanner=By.xpath("//li[@data-qa-selector-value='100.000'and@data-qa-selector='active-filter']");
        filter.presenceOfElementLocated(filterbanner, driver);

        return new SearchPage(driver);
    }

    public SearchPage assertYearFilterPresence (String yearvalue){

        Assert.assertTrue(driver.findElement(By.xpath("//li[@data-qa-selector-value='"+yearvalue+"'and@data-qa-selector='active-filter']")).isDisplayed(), "Assertion on year filter wasn't successful");

        return new SearchPage(driver);
    }

    public SearchPage assertPriceFilterPresence (String pricevalue){

        Assert.assertTrue(driver.findElement(By.xpath("//li[@data-qa-selector-value='"+pricevalue+"'and@data-qa-selector='active-filter']")).isDisplayed(), "Assertion on price filter wasn't successful");

        return new SearchPage(driver);
    }

}
