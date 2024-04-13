package pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testdata.JsonDataReader;

import java.io.IOException;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    JsonDataReader Reader = new JsonDataReader();

    protected final By userProfileMenu = By.id("userProfileMenu");

    protected final By xIcon = By.className("banner-close-button");

    protected final By firstItem = By.xpath("//p[contains(text(),'AirPod 2 + Wired Charging Case')]");

    protected final By secondItem = By.xpath("//p[contains(text(),'Apple Watch Series 9 GPS 45mm')]");

    protected final By addToCartButton = By.className("add-to-cart");

    protected final By Language = By.className("language");

    protected final By searchBar = By.id("searchInput");

    protected final By productResult = By.xpath("//p[contains(text(),'In Smart Phones')]");

    protected final By cartButton = By.className("cart-btn");

    protected final By successMessage = By.xpath("//p[contains(text(),'Item added to cart successfully!')]");

    protected final By thirdProduct = By.xpath("//p[contains(text(),'iPhone 14')]");

    public void navigateToLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(xIcon));
        click(xIcon);
        try {
            click(xIcon);
        } catch (ElementClickInterceptedException e) {
            wait.until(ExpectedConditions.elementToBeClickable(xIcon));
            click(xIcon);
        }
        wait.until(ExpectedConditions.elementToBeClickable(userProfileMenu));
        click(userProfileMenu);
    }

    public void addFirstItemToTheCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Language));
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        wait.until(ExpectedConditions.elementToBeClickable(firstItem));
        try {
            click(firstItem);
        } catch (ElementClickInterceptedException | StaleElementReferenceException | TimeoutException e) {
            wait.until(ExpectedConditions.elementToBeClickable(firstItem));
            click(firstItem);
        }
        try {
            click(addToCartButton);
        } catch (ElementClickInterceptedException | StaleElementReferenceException | TimeoutException e) {
            wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            click(addToCartButton);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
    }

    public void goBackToHomePage() {
        driver.navigate().back();
    }

    public void addSecondItemToTheCart() throws InterruptedException {
      //  Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(secondItem));
        try {
            click(secondItem);
        } catch (ElementClickInterceptedException | StaleElementReferenceException | TimeoutException e) {
            wait.until(ExpectedConditions.elementToBeClickable(secondItem));
            click(secondItem);
        }
        try {
            click(addToCartButton);
        } catch (ElementClickInterceptedException | StaleElementReferenceException | TimeoutException e) {
            wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            click(addToCartButton);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
    }

    public void addThirdItemToTheCart() throws InterruptedException {
        driver.findElement(searchBar).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productResult));
        try {
            click(productResult);
        } catch (ElementClickInterceptedException | StaleElementReferenceException | TimeoutException e) {
            wait.until(ExpectedConditions.elementToBeClickable(productResult));
            click(productResult);
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(thirdProduct));
            click(thirdProduct);
        } catch (ElementClickInterceptedException | StaleElementReferenceException | TimeoutException e) {
            wait.until(ExpectedConditions.elementToBeClickable(thirdProduct));
            click(thirdProduct);
        }

        try {
            click(addToCartButton);
        } catch (ElementClickInterceptedException | StaleElementReferenceException | TimeoutException e) {
            wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            click(addToCartButton);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));

    }

    public void searchForThirdItem() throws IOException, ParseException, InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        Reader.jsonReader();
        SendKeys(Reader.searchdata, searchBar);
    }

    public void goToCart() throws InterruptedException {
        click(cartButton);
    }

    public boolean isFirstItemDisplayed() {
        try {
            return driver.findElement(firstItem).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }

    }

    public boolean isSecondItemDisplayed() {
        try {
            return driver.findElement(secondItem).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }

    }

    public boolean isThirdItemDisplayed() {
        try {
            return driver.findElement(thirdProduct).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }

}
