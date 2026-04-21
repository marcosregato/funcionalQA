package cenarioTeste;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import base.BaseTest;
import config.ConfigProperties;
import pages.MainPage;
import reporting.AllureReporter;

public class TC_001_PaginaPrincipal extends BaseTest {
    
    private static final Logger logger = LogManager.getLogger(TC_001_PaginaPrincipal.class);
    
    private MainPage mainPage;
    
    @BeforeEach
    public void setUpTest() {
        mainPage = new MainPage(getDriver());
        AllureReporter.addEnvironmentInfo();
    }
    
    @Test
    @DisplayName("Execute complete search test flow")
    public void exect() {
        cenarioTestePesquisar();
        cenarioTestePesquisarComTexto();
    }
    
    @Test
    @DisplayName("Test search with valid text")
    public void cenarioTestePesquisar() {
        try {
            logger.info("Starting search test with valid text");
            AllureReporter.log("Starting search test with valid text");
            
            // Verify page is loaded
            Assertions.assertTrue(mainPage.isPageLoaded(), "Main page should be loaded");
            
            // Perform search with valid text
            String searchText = ConfigProperties.getProperty("txt.pesquisar");
            AllureReporter.addTestData("Search text: " + searchText);
            
            mainPage.searchForProduct(searchText);
            
            // Validate search results
            boolean searchResultsValid = mainPage.verifySearchResultsContain("BLOUSE");
            Assertions.assertTrue(searchResultsValid, "Search results should contain 'BLOUSE'");
            
            AllureReporter.markStepAsPassed("Search with valid text completed successfully");
            logger.info("Search test completed successfully");
            
        } catch (Exception e) {
            logger.error("Search test failed: {}", e.getMessage(), e);
            AllureReporter.markStepAsFailed("Search test failed", e);
            throw e;
        }
    }
    
    @Test
    @DisplayName("Test search with empty text")
    public void cenarioTestePesquisarComTexto() {
        try {
            logger.info("Starting search test with empty text");
            AllureReporter.log("Starting search test with empty text");
            
            // Navigate back to home page
            mainPage.navigateToHome();
            
            // Click search button without entering text
            mainPage.clickSearchButton();

            // Validate warning message for empty search
            boolean alertDisplayed = mainPage.verifyAlertMessage("Please enter a search keyword");
            Assertions.assertTrue(alertDisplayed, "Alert message should be displayed for empty search");

            AllureReporter.markStepAsPassed("Empty search test completed successfully");
            logger.info("Empty search test completed successfully");
            
        } catch (Exception e) {
            logger.error("Empty search test failed: {}", e.getMessage(), e);
            AllureReporter.markStepAsFailed("Empty search test failed", e);
            throw e;
        }
    }
}