package AbstractWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseWebUI {
    protected WebDriver driver;
    private WebDriverWait wait;
    private int timeoutWaitForPageLoaded = 30;

    public BaseWebUI(WebDriver driver){
        this.driver = driver;
//       wait = new WebDriverWait(driver, 10);
    }

    public void setText(By element, String value){
        System.out.println("element: " + element);
        System.out.println("value: " + value);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).sendKeys(value);
    }

    public void clearText(By element){
        System.out.println("element: " + element);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).clear();
    }
    public void clickElement(By element){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).click();
    }

}
