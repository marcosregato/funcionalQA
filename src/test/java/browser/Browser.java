package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	static String path = System.getProperty("user.dir");
	@SuppressWarnings("unused")
	private static WebDriver driver;

	public static WebDriver getDriver() {
		try {
			if(ConfigProperties.getProperty("browser").equals("FIREFOX")) {

				WebDriverManager.firefoxdriver().setup();
				return driver = new FirefoxDriver();
			}else {
				WebDriverManager.chromedriver().setup();
				return driver = new ChromeDriver();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeBrowser(WebDriver driver) {
		if(driver!=null) {
			//driver.close();
			driver.quit();
		}
	}
}
