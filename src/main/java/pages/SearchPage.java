package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selector.sorting.getmaxvalue;

public class SearchPage {

    private WebDriver driver;
    public static final String URL="https://www.autohero.com/de/search/";

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

yearFilter.click();
yearFilterSelector.click();
        WebElement choosevaluefilter = driver.findElement(By.xpath("//option[@data-qa-selector-value='"+year+"']"));
        choosevaluefilter.click();
        yearFilterSelector.click();

        WebElement filter = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@data-qa-selector-value='"+year+"'and@data-qa-selector='active-filter']")));

        return new SearchPage(driver);

    }

    public SearchPage filterByBiggestPrice () {
        getmaxvalue value=new getmaxvalue();

        priceFilter.click();
        priceFilterSelector.click();
        WebElement choosevaluefilter = driver.findElement(By.xpath("//option[@data-qa-selector-value='"+value.sortmaxvalue(driver, By.xpath("//select[@data-qa-selector='select'and@name='priceRange.max']//option"))+"']"));
        choosevaluefilter.click();
        priceFilterSelector.click();
        WebElement filter = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@data-qa-selector-value='100.000'and@data-qa-selector='active-filter']")));

        return new SearchPage(driver);
    }

}
