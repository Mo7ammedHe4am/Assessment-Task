package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

    public static WebDriver driver;
    public static Properties prop = new Properties();

    public static FileReader fr;

    public static WebDriver getDriver() throws IOException {

        if (driver == null) {
            fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
            prop.load(fr);
        }
        if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-cookies");

        } else if (prop.getProperty("Browser").equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();

        } else if (prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        return driver;
    }

    @Before
    public void setUp() throws IOException {
        driver = getDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("TestUrl"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
