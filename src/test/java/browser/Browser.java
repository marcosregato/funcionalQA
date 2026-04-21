package browser;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import config.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
    
    private static final Logger logger = LogManager.getLogger(Browser.class);
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<String> browserType = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            initializeDriver();
        }
        return driver.get();
    }

    private static void initializeDriver() {
        try {
            String browser = ConfigProperties.getProperty("browser").toUpperCase();
            browserType.set(browser);
            
            logger.info("Initializing {} browser", browser);
            
            switch (browser) {
                case "FIREFOX":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--no-sandbox");
                    firefoxOptions.addArguments("--disable-dev-shm-usage");
                    driver.set(new FirefoxDriver(firefoxOptions));
                    break;
                case "CHROME":
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    chromeOptions.addArguments("--disable-gpu");
                    if (ConfigProperties.getProperty("headless", "false").equalsIgnoreCase("true")) {
                        chromeOptions.addArguments("--headless");
                    }
                    driver.set(new ChromeDriver(chromeOptions));
                    break;
            }
            
            // Configure timeouts
            WebDriver currentDriver = driver.get();
            currentDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            currentDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            currentDriver.manage().window().maximize();
            
        } catch (Exception e) {
            logger.error("Failed to initialize browser: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to initialize browser", e);
        }
    }
    
    public static void closeBrowser() {
        try {
            WebDriver currentDriver = driver.get();
            if (currentDriver != null) {
                logger.info("Closing {} browser", browserType.get());
                currentDriver.quit();
            }
        } catch (Exception e) {
            logger.error("Error closing browser: {}", e.getMessage(), e);
        } finally {
            driver.remove();
            browserType.remove();
        }
    }
    
    public static void quitCurrentDriver() {
        closeBrowser();
    }
    
    public static String getCurrentBrowserType() {
        return browserType.get();
    }
}
