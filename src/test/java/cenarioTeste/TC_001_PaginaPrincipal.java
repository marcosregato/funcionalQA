package cenarioTeste;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import browser.Browser;
import config.ConfigProperties;
import controller.TelaPrincipalController;
import relatorio.ManipularCsv;
import util.Validacao;

public class TC_001_PaginaPrincipal {

	WebDriver driver = Browser.getDriver();

	String nomeTeste = getClass().getSimpleName();
	ManipularCsv manipularCsv = new ManipularCsv();
	
	@Test
	public void exect() {
		cenarioTestePesquisar();
		cenarioTestePesquisarComTexto();
	}
	
	public void cenarioTestePesquisar() {
		TelaPrincipalController telaPrincipalController = new TelaPrincipalController(driver);//, doc);
		String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();

		try {
			manipularCsv.criarRelatorioCsv(nomeTeste);
			driver.get(ConfigProperties.getProperty("URL"));
			telaPrincipalController.setTxtPesquisar(ConfigProperties.getProperty("txt.pesquisar"));
			
			telaPrincipalController.clickBtnPesquisar();

			Validacao validacao = new Validacao(driver);
			validacao.isValidarElement("BLOUSE", ".//span[@class='lighter']");

		} catch (Exception e) {
			manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
			Browser.closeBrowser(driver);
		}
	}
	
	public void cenarioTestePesquisarComTexto() {
		TelaPrincipalController telaPrincipalController = new TelaPrincipalController(driver);//, doc);
		String nomeMetodo = new Object() {}.getClass().getEnclosingMethod().getName();

		try {
			telaPrincipalController.voltarPagIndex();
			telaPrincipalController.clickBtnPesquisar();

			Validacao validacao = new Validacao(driver);
			validacao.isValidarElement("Please enter a search keyword", ".//p[@class='alert alert-warning']");

			manipularCsv.escreverCsv(nomeMetodo, "OK", "Final do Teste");
			
			Browser.closeBrowser(driver);
		} catch (Exception e) {
			manipularCsv.escreverCsv(nomeMetodo, "ERRO", e.getMessage());
			Browser.closeBrowser(driver);
		}
	}
}