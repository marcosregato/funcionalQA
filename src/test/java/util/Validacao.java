package util;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import browser.Browser;
import config.ConfigProperties;
import relatorio.ManipularCsv;

public class Validacao {

	private final WebDriver driver;
	private Utilidade util = new Utilidade();
	int tempo = Integer.valueOf(ConfigProperties.getProperty("tempo.espera"));
	ManipularCsv manipularCsv = new ManipularCsv();

	public Validacao(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @param titulo
	 * @param xpath 
	 */
	public void isValidarElement(String txt, String xpath) {
		String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();
		try {
			for (int x = 0; x <= tempo; x++) {
				Thread.sleep(1000);
			}
			WebElement element = driver.findElement(By.xpath(xpath));
			assertEquals(txt,element.getText().replace("\"", ""));
			util.menuHighlightElement(element, driver);

			manipularCsv.escreverCsv(nomeMetodo, "OK", "Texto encontrado => "+txt);

		} catch (Exception e) {
			manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
			e.getMessage();
			Browser.closeBrowser(driver);
		}
	}
}