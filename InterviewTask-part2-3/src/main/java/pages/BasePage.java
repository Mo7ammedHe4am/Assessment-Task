package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;
    protected WebDriverWait wait;

    protected JavascriptExecutor js;

    protected Actions actions;



    protected BasePage(WebDriver driver){
        BasePage.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    protected void click (By locator){
        WebElement element = driver.findElement(locator);
        element.click();
    }

    protected void SendKeys(String text , By locator){
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }



}
