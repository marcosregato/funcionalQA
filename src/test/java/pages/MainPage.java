package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;
import util.WaitManager;
import util.Utilidade;

public class MainPage extends BasePage {
    
    // Locators
    private final By searchInput = By.id("search_query_top");
    private final By searchButton = By.name("submit_search");
    private final By womenLink = By.linkText("Women");
    private final By dressesLink = By.linkText("Dresses");
    private final By tshirtsLink = By.linkText("T-shirts");
    private final By bestSellersLink = By.linkText("Best Sellers");
    private final By popularLink = By.linkText("Popular");
    private final By homeLink = By.xpath(".//a[@href='http://automationpractice.com/']");
    private final By searchResultsHeader = By.xpath(".//span[@class='lighter']");
    private final By alertMessage = By.xpath(".//p[@class='alert alert-warning']");
    
    private final Utilidade util = new Utilidade();
    
    public MainPage(WebDriver driver) {
        super(driver);
    }
    
    @Step("Enter search text: {searchText}")
    public void enterSearchText(String searchText) {
        logStep("Entering search text: " + searchText);
        try {
            WebElement searchElement = WaitManager.waitForElementToBeVisible(driver, driver.findElement(searchInput));
            util.menuHighlightElement(searchElement, driver);
            searchElement.clear();
            searchElement.sendKeys(searchText);
            captureScreenshot("Search text entered");
        } catch (Exception e) {
            logger.error("Failed to enter search text: {}", e.getMessage());
            captureScreenshot("Failed to enter search text");
            throw e;
        }
    }
    
    @Step("Click search button")
    public void clickSearchButton() {
        logStep("Clicking search button");
        try {
            WebElement button = WaitManager.waitForElementToBeClickable(driver, driver.findElement(searchButton));
            util.menuHighlightElement(button, driver);
            button.click();
            waitForPageLoad();
            captureScreenshot("Search button clicked");
        } catch (Exception e) {
            logger.error("Failed to click search button: {}", e.getMessage());
            captureScreenshot("Failed to click search button");
            throw e;
        }
    }
    
    @Step("Search for product: {searchText}")
    public void searchForProduct(String searchText) {
        enterSearchText(searchText);
        clickSearchButton();
    }
    
    @Step("Click Women link")
    public void clickWomenLink() {
        logStep("Clicking Women link");
        try {
            WebElement link = WaitManager.waitForElementToBeClickable(driver, driver.findElement(womenLink));
            util.menuHighlightElement(link, driver);
            link.click();
            waitForPageLoad();
            captureScreenshot("Women page opened");
        } catch (Exception e) {
            logger.error("Failed to click Women link: {}", e.getMessage());
            captureScreenshot("Failed to click Women link");
            throw e;
        }
    }
    
    @Step("Click Dresses link")
    public void clickDressesLink() {
        logStep("Clicking Dresses link");
        try {
            WebElement link = WaitManager.waitForElementToBeClickable(driver, driver.findElement(dressesLink));
            util.menuHighlightElement(link, driver);
            link.click();
            waitForPageLoad();
            captureScreenshot("Dresses page opened");
        } catch (Exception e) {
            logger.error("Failed to click Dresses link: {}", e.getMessage());
            captureScreenshot("Failed to click Dresses link");
            throw e;
        }
    }
    
    @Step("Click T-shirts link")
    public void clickTshirtsLink() {
        logStep("Clicking T-shirts link");
        try {
            WebElement link = WaitManager.waitForElementToBeClickable(driver, driver.findElement(tshirtsLink));
            util.menuHighlightElement(link, driver);
            link.click();
            waitForPageLoad();
            captureScreenshot("T-shirts page opened");
        } catch (Exception e) {
            logger.error("Failed to click T-shirts link: {}", e.getMessage());
            captureScreenshot("Failed to click T-shirts link");
            throw e;
        }
    }
    
    @Step("Click Best Sellers link")
    public void clickBestSellersLink() {
        logStep("Clicking Best Sellers link");
        try {
            WebElement link = WaitManager.waitForElementToBeClickable(driver, driver.findElement(bestSellersLink));
            util.menuHighlightElement(link, driver);
            link.click();
            waitForPageLoad();
            captureScreenshot("Best Sellers page opened");
        } catch (Exception e) {
            logger.error("Failed to click Best Sellers link: {}", e.getMessage());
            captureScreenshot("Failed to click Best Sellers link");
            throw e;
        }
    }
    
    @Step("Click Popular link")
    public void clickPopularLink() {
        logStep("Clicking Popular link");
        try {
            WebElement link = WaitManager.waitForElementToBeClickable(driver, driver.findElement(popularLink));
            util.menuHighlightElement(link, driver);
            link.click();
            waitForPageLoad();
            captureScreenshot("Popular items page opened");
        } catch (Exception e) {
            logger.error("Failed to click Popular link: {}", e.getMessage());
            captureScreenshot("Failed to click Popular link");
            throw e;
        }
    }
    
    @Step("Navigate back to home page")
    public void navigateToHome() {
        logStep("Navigating back to home page");
        try {
            WebElement link = WaitManager.waitForElementToBeClickable(driver, driver.findElement(homeLink));
            util.menuHighlightElement(link, driver);
            link.click();
            waitForPageLoad();
            captureScreenshot("Navigated to home page");
        } catch (Exception e) {
            logger.error("Failed to navigate to home page: {}", e.getMessage());
            captureScreenshot("Failed to navigate to home page");
            throw e;
        }
    }
    
    @Step("Verify search results contain: {expectedText}")
    public boolean verifySearchResultsContain(String expectedText) {
        logStep("Verifying search results contain: " + expectedText);
        try {
            WebElement header = WaitManager.waitForElementToBeVisible(driver, driver.findElement(searchResultsHeader));
            String actualText = header.getText().replace("\"", "");
            boolean result = actualText.contains(expectedText.toUpperCase());
            
            if (result) {
                logStep("Search results verification PASSED");
                captureScreenshot("Search results verification passed");
            } else {
                logStep("Search results verification FAILED - Expected: " + expectedText + ", Actual: " + actualText);
                captureScreenshot("Search results verification failed");
            }
            
            return result;
        } catch (Exception e) {
            logger.error("Failed to verify search results: {}", e.getMessage());
            captureScreenshot("Failed to verify search results");
            throw e;
        }
    }
    
    @Step("Verify alert message is displayed: {expectedMessage}")
    public boolean verifyAlertMessage(String expectedMessage) {
        logStep("Verifying alert message: " + expectedMessage);
        try {
            WebElement alert = WaitManager.waitForElementToBeVisible(driver, driver.findElement(alertMessage));
            String actualMessage = alert.getText();
            boolean result = actualMessage.contains(expectedMessage);
            
            if (result) {
                logStep("Alert message verification PASSED");
                captureScreenshot("Alert message verification passed");
            } else {
                logStep("Alert message verification FAILED - Expected: " + expectedMessage + ", Actual: " + actualMessage);
                captureScreenshot("Alert message verification failed");
            }
            
            return result;
        } catch (Exception e) {
            logger.error("Failed to verify alert message: {}", e.getMessage());
            captureScreenshot("Failed to verify alert message");
            throw e;
        }
    }
    
    @Step("Check if page is loaded")
    public boolean isPageLoaded() {
        try {
            WebElement searchBox = WaitManager.waitForElementToBePresent(driver, searchInput);
            return searchBox != null && searchBox.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
