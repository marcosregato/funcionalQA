package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigProperties;
import relatorio.ManipularCsv;
import util.Utilidade;

public class TelaPrincipalController {

    private static final Logger logger = LogManager.getLogger(TelaPrincipalController.class);
    
    private final By txtPesquisar = By.xpath(".//*[@id='search_query_top']");
    private final By btnPesquisar = By.xpath(".//*[@name='submit_search']");
    private final By btnWomen = By.linkText("Women");
    private final By btnDresses = By.linkText("Dresses");
    private final By btnT_shirts = By.linkText("T-shirts");
    private final By btnBestSellers = By.linkText("Best Sellers");
    private final By btnPopular = By.linkText("Popular");
    private final By voltarPagIndex = By.xpath(".//a[@href='http://automationpractice.com/']");

    private final WebDriver driver;
    private final Utilidade util;
    private final ManipularCsv manipularCsv;
    private final int tempo = Integer.valueOf(ConfigProperties.getProperty("tempo.espera"));
    
    public TelaPrincipalController(WebDriver driver) {
        this.driver = driver;
        this.util = new Utilidade();
        this.manipularCsv = new ManipularCsv();
    }
    
    public void setTxtPesquisar(String txt) {
        String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            logger.info("Setting search text: {}", txt);
            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(tempo));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(txtPesquisar));
            util.menuHighlightElement(element, driver);
            element.clear();
            element.sendKeys(txt);
            manipularCsv.escreverCsv(nomeMetodo, "OK", "Search text set successfully: " + txt);
            logger.info("Search text set successfully");
        } catch (Exception e) {
            logger.error("Error setting search text: {}", e.getMessage(), e);
            manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
            throw e;
        }
    }

    public void clickBtnPesquisar() {
        String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            logger.info("Clicking search button");
            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(tempo));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnPesquisar));
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK", "Search button clicked successfully");
            logger.info("Search button clicked successfully");
        } catch (Exception e) {
            logger.error("Error clicking search button: {}", e.getMessage(), e);
            manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
            throw e;
        }
    }

    public void clickBtnWomen() {
        String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            logger.info("Clicking Women button");
            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(tempo));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnWomen));
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK", "Women button clicked successfully");
            logger.info("Women button clicked successfully");
        } catch (Exception e) {
            logger.error("Error clicking Women button: {}", e.getMessage(), e);
            manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
            throw e;
        }
    }
    
    public void clickBtnDresses() {
        String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            logger.info("Clicking Dresses button");
            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(tempo));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnDresses));
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK", "Dresses button clicked successfully");
            logger.info("Dresses button clicked successfully");
        } catch (Exception e) {
            logger.error("Error clicking Dresses button: {}", e.getMessage(), e);
            manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
            throw e;
        }
    }

    public void clickBtnT_shirts() {
        String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            logger.info("Clicking T-shirts button");
            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(tempo));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnT_shirts));
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK", "T-shirts button clicked successfully");
            logger.info("T-shirts button clicked successfully");
        } catch (Exception e) {
            logger.error("Error clicking T-shirts button: {}", e.getMessage(), e);
            manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
            throw e;
        }
    }
    
    public void clickBtnBestSellers() {
        String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            logger.info("Clicking Best Sellers button");
            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(tempo));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnBestSellers));
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK", "Best Sellers button clicked successfully");
            logger.info("Best Sellers button clicked successfully");
        } catch (Exception e) {
            logger.error("Error clicking Best Sellers button: {}", e.getMessage(), e);
            manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
            throw e;
        }
    }
    
    public void clickBtnPopular() {
        String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            logger.info("Clicking Popular button");
            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(tempo));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnPopular));
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK", "Popular button clicked successfully");
            logger.info("Popular button clicked successfully");
        } catch (Exception e) {
            logger.error("Error clicking Popular button: {}", e.getMessage(), e);
            manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
            throw e;
        }
    }
    
    public void voltarPagIndex() {
        String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            logger.info("Navigating back to index page");
            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(tempo));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(voltarPagIndex));
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK", "Navigated back to index page successfully");
            logger.info("Navigated back to index page successfully");
        } catch (Exception e) {
            logger.error("Error navigating back to index page: {}", e.getMessage(), e);
            manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
            throw e;
        }
    }
}