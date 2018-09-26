package popup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by daleshun on 25.09.2018.
 */
public class popup {
    private final WebDriverWait wait;
    private final By closeElementLocator = By.className("close");
    private final By popupIdLocator = By.className("modal-open");

    public popup(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 5);
    }

    public void close() throws InterruptedException {
        if (isDisplayed()) {
            WebElement closeElement = wait.until(
                    visibilityOfElementLocated(closeElementLocator));
            closeElement.click();
        }
    }

    private Boolean isDisplayed() throws InterruptedException {
        try {
            WebElement popup = wait.until(
                    visibilityOfElementLocated(popupIdLocator));
            return popup.isDisplayed();
        }
        catch (Exception ex) {
            return false;
        }
    }
}
