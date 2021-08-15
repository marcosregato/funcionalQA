package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.ConfigProperties;
import relatorio.ManipularCsv;
import util.Utilidade;

public class TelaWomenController {

    private final WebDriver driver;
    private int tempo = Integer.valueOf(ConfigProperties.getProperty("tempo.espera"));
    private Utilidade util = new Utilidade();
    ManipularCsv manipularCsv = new ManipularCsv();

    private final By checkBoxMenuTops = By.linkText("Tops");
    private final By checkBoxMenuDresses = By.linkText("Dresses");
    
    private final By checkBoxCategoriaTops = By.xpath(".//*[@id='layered_category_4']");
    private final By checkBoxCategoriaDresses = By.xpath(".//*[@id='layered_category_8']");
 
    private final By checkBoxSizeS = By.xpath(".//*[@id='layered_id_attribute_group_1']");
    private final By checkBoxSizeL = By.xpath(".//*[@id='layered_id_attribute_group_3']");
    private final By checkBoxSizeM = By.xpath(".//*[@id='layered_id_attribute_group_2']");
   
    private final By checkBoxColorBeige = By.linkText("Beige");
    private final By checkBoxColorBlack = By.linkText("Black");
    private final By checkBoxColorBlue = By.linkText("Blue");
    private final By checkBoxColorYellow = By.linkText("Yellow");
    private final By checkBoxColorWhite = By.linkText("White");
    private final By checkBoxColorOrange = By.linkText("Orange");
    private final By checkBoxColorGreen = By.linkText("Green");
    private final By checkBoxColorPink = By.linkText("Pink");
    
    private final By checkBoxCompositionsCotton = By.xpath(".//*[@id='layered_id_feature_5']");
    private final By checkBoxCompositionsViscose = By.xpath(".//*[@id='layered_id_feature_3']");
    private final By checkBoxCompositionsPolyester = By.xpath(".//*[@id='layered_id_feature_1']");
    
    private final By checkBoxStylesCasual = By.xpath(".//*[@id='layered_id_feature_11']");
    private final By checkBoxStylesGirly = By.xpath(".//*[@id='layered_id_feature_13']");
    private final By checkBoxStylesDressy = By.xpath(".//*[@id='layered_id_feature_16']");
    
    private final By checkBoxPropertiesColorfulDress = By.xpath(".//*[@id='layered_id_feature_18']");
    private final By checkBoxPropertiesMidiDress = By.xpath(".//*[@id='layered_id_feature_20']");
    private final By checkBoxPropertiesShortSleeve = By.xpath(".//*[@id='layered_id_feature_17']");
    private final By checkBoxPropertiesMaxiDress = By.xpath(".//*[@id='layered_id_feature_21']");
    private final By checkBoxPropertiesSortDress = By.xpath(".//*[@id='layered_id_feature_19']");
 
    private final By checkBoxAvailabilityInStock = By.xpath(".//*[@id='layered_quantity_1']");
   
    private final By checkBoxManufacturerFashoinManufacture = By.xpath(".//*[@id='layered_manufacturer_1']");
    
    private final By checkBoxCategoriaDressea = By.xpath(".//*[@id='layered_condition_new']");
    
   
    public TelaWomenController(WebDriver driver) {
        this.driver = driver;
    }

    public void checkBoxMenuTops() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxMenuTops);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxMenuDresses() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxMenuDresses);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxCategoriaTops() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxCategoriaTops);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxCategoriaDresses() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxCategoriaDresses);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxSizeS() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxSizeS);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxSizeL() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxSizeL);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxSizeM() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxSizeM);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxColorBeige() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxColorBeige);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxColorBlack() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxColorBlack);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxColorBlue() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxColorBlue);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxColorYellow() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxColorYellow);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxColorWhite() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxColorWhite);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxColorOrange() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxColorOrange);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxColorGreen() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxColorGreen);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxColorPink() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxColorPink);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxCompositionsCotton() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxCompositionsCotton);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxCompositionsViscose() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxCompositionsViscose);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxCompositionsPolyester() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxCompositionsPolyester);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxStylesCasual() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxStylesCasual);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxStylesGirly() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxStylesGirly);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxPropertiesColorfulDress() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxPropertiesColorfulDress);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxPropertiesMidiDress() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxPropertiesMidiDress);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxPropertiesShortSleeve() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxPropertiesShortSleeve);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxPropertiesMaxiDress() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxPropertiesMaxiDress);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxPropertiesSortDress() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxPropertiesSortDress);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxAvailabilityInStock() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxAvailabilityInStock);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxManufacturerFashoinManufacture() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxManufacturerFashoinManufacture);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxCategoriaDressea() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxCategoriaDressea);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
    
    public void checkBoxStylesDressy() {
    	String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
        try {
            util.abrirMenu(driver);
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(checkBoxStylesDressy);
            util.menuHighlightElement(element, driver);
            element.click();
            manipularCsv.escreverCsv(nomeMetodo, "OK",null);
        } catch (Exception e) {
             manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
        }
    }
}