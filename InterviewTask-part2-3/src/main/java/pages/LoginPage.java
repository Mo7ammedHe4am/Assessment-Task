package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    protected final By usernameField = By.id("username");
    protected final By passwordField = By.id("password");
    protected final By submitButton = By.id("submitBtn");

    public void login(String username, String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
       driver.findElement(usernameField).clear();
        SendKeys(username, usernameField);
      driver.findElement(passwordField).clear();
        SendKeys(password, passwordField);
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        try {
            click(submitButton);
        }
        catch (ElementClickInterceptedException e)
        {
            wait.until(ExpectedConditions.elementToBeClickable(submitButton));
            click(submitButton);
        }

    }


}
