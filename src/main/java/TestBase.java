import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase


{
    public static WebDriver driver;
    public static Properties prop;


    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/config");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");

        if (browserName.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

            driver = new ChromeDriver();
        } else if (browserName.equals("Chrome_headless")) {
            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");

            driver = new ChromeDriver(options);

        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().window().setSize(new Dimension(Integer.valueOf(prop.getProperty("WINDOW_WIDTH")), Integer.valueOf(prop.getProperty("WINDOW_HEIGHT"))));
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));

    }

}
