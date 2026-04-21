package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;

import browser.Browser;
import config.ConfigProperties;
import io.qameta.allure.Step;

public abstract class BaseTest {
    
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected static WebDriver driver;
    protected String baseUrl;
    
    @BeforeAll
    public static void setUpClass() {
        logger.info("=== Starting Test Suite ===");
        logger.info("Browser: {}", ConfigProperties.getProperty("browser"));
        logger.info("Base URL: {}", ConfigProperties.getProperty("URL"));
    }
    
    @BeforeEach
    public void setUp(TestInfo testInfo) {
        logger.info("=== Starting Test: {} ===", testInfo.getDisplayName());
        
        try {
            driver = Browser.getDriver();
            baseUrl = ConfigProperties.getProperty("URL");
            
            if (baseUrl != null && !baseUrl.isEmpty()) {
                driver.get(baseUrl);
                logger.info("Navigated to: {}", baseUrl);
            }
            
        } catch (Exception e) {
            logger.error("Failed to setup test: {}", e.getMessage(), e);
            throw new RuntimeException("Test setup failed", e);
        }
    }
    
    @AfterEach
    public void tearDown(TestInfo testInfo) {
        logger.info("=== Finished Test: {} ===", testInfo.getDisplayName());
        
        try {
            if (driver != null) {
                // Take screenshot on test failure if needed
                // This could be enhanced with Allure attachment
                logger.info("Test cleanup completed");
            }
        } catch (Exception e) {
            logger.error("Error during test cleanup: {}", e.getMessage(), e);
        }
    }
    
    @AfterAll
    public static void tearDownClass() {
        logger.info("=== Test Suite Completed ===");
        try {
            Browser.closeBrowser();
        } catch (Exception e) {
            logger.error("Error closing browser: {}", e.getMessage(), e);
        }
    }
    
    @Step("Navigate to URL: {url}")
    protected void navigateTo(String url) {
        try {
            driver.get(url);
            logger.info("Navigated to: {}", url);
        } catch (Exception e) {
            logger.error("Failed to navigate to {}: {}", url, e.getMessage(), e);
            throw e;
        }
    }
    
    @Step("Wait for page to load")
    protected void waitForPageLoad() {
        try {
            // This could use the WaitManager if needed
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.warn("Page load wait interrupted");
        }
    }
    
    protected WebDriver getDriver() {
        return driver;
    }
    
    protected String getBaseUrl() {
        return baseUrl;
    }
}
