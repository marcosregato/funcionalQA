package util;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.ConfigProperties;
import java.awt.Robot;
import java.awt.event.InputEvent;
import org.openqa.selenium.By;

public class Utilidade {

	String nomeUsuario = System.getProperty("user.name");
    private static final String ABRIR_MENU = ".//div[@class='dropdown-menu']/i[@class='icon icon-burger-b']";

    int tempo = Integer.valueOf(ConfigProperties.getProperty("tempo.espera"));

    public String pathDiretorioArquivo(String nome) {
    	String nomeDiretorio = System.getProperty("user.dir");
    	String path = nomeDiretorio+"/"+nome+"/";
    	return path;
    	
    }
    
    public void menuHighlightElement(WebElement element, WebDriver driver) {
        try {
            if (driver instanceof JavascriptExecutor) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].style.border='3px solid red'", element);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void menuHighlightText(String txt, WebDriver driver) {
        try {
            if (driver instanceof JavascriptExecutor) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].style.border='3px solid red'", txt);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void screenshot(WebDriver driver, String txt) {
        try {
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\Users\\"+nomeUsuario+"\\Documents\\FERRAMENTA_TESTE\\screenshotTeste\\" + txt + ".png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void abrirMenu(WebDriver driver) {
        try {
            for (int x = 0; x <= tempo; x++) {
                Thread.sleep(1000);
            }
            WebElement element = driver.findElement(By.xpath(ABRIR_MENU));
            element.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listInfo() {
        try {
            for (int x = 0; x <= 10; x++) {
                Thread.sleep(1000);
            }
            Robot robot = new Robot();
            robot.mouseMove(400, 650);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
