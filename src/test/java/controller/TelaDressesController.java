package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.ConfigProperties;
import relatorio.ManipularCsv;
import util.Utilidade;

public class TelaDressesController {

    private final WebDriver driver;
    private int tempo = Integer.valueOf(ConfigProperties.getProperty("tempo.espera"));
    private Utilidade util = new Utilidade();
    ManipularCsv manipularCsv = new ManipularCsv();
    
   public TelaDressesController(WebDriver driver){
       this.driver = driver;
   }

    public void clickMenuSair(String xpath) {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(By.xpath(xpath));
            util.menuHighlightElement(element,driver);
            element.click();
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
}