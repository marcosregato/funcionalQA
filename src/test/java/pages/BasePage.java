package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import reporting.AllureReporter;
import util.WaitManager;

public abstract class BasePage {
    
    protected static final Logger logger = LogManager.getLogger(BasePage.class);
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    
    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = WaitManager.getWait(driver);
    }
    
    protected void logStep(String stepDescription) {
        logger.info("Step: {}", stepDescription);
        AllureReporter.log(stepDescription);
    }
    
    protected void captureScreenshot(String stepName) {
        AllureReporter.captureScreenshot(driver, stepName);
    }
    
    protected void waitForPageLoad() {
        WaitManager.waitForPageLoad(driver);
    }
    
    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    
    protected String getTitle() {
        return driver.getTitle();
    }
    
    protected boolean isUrlContains(String expectedUrl) {
        return getCurrentUrl().contains(expectedUrl);
    }
    
    protected boolean isTitleContains(String expectedTitle) {
        return getTitle().contains(expectedTitle);
    }
    
    protected void navigateTo(String url) {
        logStep("Navigating to: " + url);
        driver.get(url);
        waitForPageLoad();
        captureScreenshot("Page after navigation");
    }
    
    protected void refreshPage() {
        logStep("Refreshing page");
        driver.navigate().refresh();
        waitForPageLoad();
    }
}
