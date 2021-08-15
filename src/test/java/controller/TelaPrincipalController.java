package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.ConfigProperties;
import relatorio.ManipularCsv;
import util.Utilidade;

public class TelaPrincipalController {

    private final By txtPesquisar = By.xpath(".//*[@id='search_query_top']");
    private final By btnPesquisar = By.xpath(".//*[@name='submit_search']");
    private final By btnWomen = By.linkText("Women");
    private final By btnDresses = By.linkText("Dresses");
    private final By btnT_shirts = By.linkText("T-shirts");
    private final By btnBestSellers = By.linkText("Best Sellers");
    private final By btnPopular = By.linkText("Popular");
    private final By voltarPagIndex = By.xpath(".//a[@href='http://automationpractice.com/']");

    private final WebDriver driver;
    int tempo = Integer.valueOf(ConfigProperties.getProperty("tempo.espera"));
    private Utilidade util = new Utilidade();
    ManipularCsv manipularCsv = new ManipularCsv();
    
   
    public TelaPrincipalController(WebDriver driver) {
        this.driver = driver;
    }
    
    public void setTxtPesquisar(String txt) {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(txtPesquisar);
            util.menuHighlightElement(element, driver);
            element.sendKeys(txt);
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
            manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }

    public void clickBtnPesquisar() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(btnPesquisar);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
            manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }

    public void clickBtnWomen() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(btnWomen);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void clickBtnDresses() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(btnDresses);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }

    public void clickBtnT_shirts() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(btnT_shirts);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
            manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void clickBtnBestSellers() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(btnBestSellers);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void clickBtnPopular() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(btnPopular);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void voltarPagIndex() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(voltarPagIndex);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
}