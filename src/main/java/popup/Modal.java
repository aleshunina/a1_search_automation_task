package popup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Modal {

    public Modal dealwithmodal(WebDriver driver){

        WebElement modal = driver.findElement(By.xpath("//button[@class='close'and@type='button']"));
        modal.click();
        WebElement filter = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-qa-selector='filter-year']")));
        return null;
    }
}
