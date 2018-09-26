package selector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selector.sorting.getmaxvalue;

/**
 * Created by daleshun on 25.09.2018.
 */

public class selector {
    //possible values for type are price and year
    public void filter(WebDriver driver, String type, String value){
        WebElement locatefilter = driver.findElement(By.xpath("//div[@data-qa-selector='filter-"+type+"']"));
        locatefilter.click();
        WebElement openfilter = driver.findElement(By.xpath("//select[@data-qa-selector='select'and@name='"+type+"Range.min']"));
        openfilter.click();
        WebElement choosevaluefilter = driver.findElement(By.xpath("//option[@data-qa-selector-value='"+value+"']"));
        choosevaluefilter.click();
        openfilter.click();
    }

    public void sortbymaxvalue(WebDriver driver, String type){

        getmaxvalue value=new getmaxvalue();

        WebElement locatefilter = driver.findElement(By.xpath("//div[@data-qa-selector='filter-"+type+"']"));
        locatefilter.click();
        WebElement openfilter = driver.findElement(By.xpath("//select[@data-qa-selector='select'and@name='"+type+"Range.max']"));
        openfilter.click();
        WebElement choosevaluefilter = driver.findElement(By.xpath("//option[@data-qa-selector-value='"+value.sortmaxvalue(driver, By.className("option___2yqJT"))+"']"));
        choosevaluefilter.click();
    }


}
