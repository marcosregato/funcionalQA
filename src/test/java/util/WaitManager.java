package util;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigProperties;

public class WaitManager {
    
    private static final Logger logger = LogManager.getLogger(WaitManager.class);
    private static final int DEFAULT_TIMEOUT = Integer.parseInt(ConfigProperties.getProperty("tempo.espera", "10"));
    
    public static WebDriverWait getWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
    }
    
    public static WebDriverWait getWait(WebDriver driver, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }
    
    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement element) {
        try {
            return getWait(driver).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            logger.error("Element not visible within timeout: {}", e.getMessage());
            throw e;
        }
    }
    
    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {
        try {
            return getWait(driver).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            logger.error("Element not clickable within timeout: {}", e.getMessage());
            throw e;
        }
    }
    
    public static WebElement waitForElementToBePresent(WebDriver driver, org.openqa.selenium.By locator) {
        try {
            return getWait(driver).until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            logger.error("Element not present within timeout: {}", e.getMessage());
            throw e;
        }
    }
    
    public static boolean waitForTextToBePresent(WebDriver driver, org.openqa.selenium.By locator, String text) {
        try {
            return getWait(driver).until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        } catch (Exception e) {
            logger.error("Text not present in element within timeout: {}", e.getMessage());
            return false;
        }
    }
    
    public static void waitForPageLoad(WebDriver driver) {
        try {
            WebDriverWait wait = getWait(driver, 30);
            wait.until(webDriver -> 
                "complete".equals(((org.openqa.selenium.JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState"))
            );
        } catch (Exception e) {
            logger.error("Page load timeout: {}", e.getMessage());
        }
    }
    
    public static void shortPause() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.warn("Short pause interrupted: {}", e.getMessage());
        }
    }
    
    public static void mediumPause() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.warn("Medium pause interrupted: {}", e.getMessage());
        }
    }
}
