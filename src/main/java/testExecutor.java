import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selector.Selector;



public class testExecutor {
    public static final String URL="https://www.autohero.com/de/search/";


public static void main(String[] args) throws InterruptedException {

        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\daleshun\\Desktop\\testtask_autohero\\chromedriver.exe");
    WebDriver driver = new FirefoxDriver();
        driver.get(URL);

        Selector selector=new Selector();

        try {
            selector.filter(driver,"year","2015");

            Assert.assertTrue(driver.findElement(By.xpath("//li[@data-qa-selector-value='2015'and@data-qa-selector='active-filter']")).isDisplayed());

            selector.sortbymaxvalue(driver,"price");
        }

        catch (NoSuchElementException ex){
            WebElement modal = driver.findElement(By.xpath("//button[@class='close'and@type='button']"));
            modal.click();
        }





    }
}
