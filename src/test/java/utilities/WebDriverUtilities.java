package utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtilities {

	static WebDriver driver= null; 
	static String baseUrl = "https://www.expedia.com/";
	
	public static WebDriver getWebDriver() {
		
		if(driver==null)
		{
			System.setProperty("webdriver.chrome.driver", Utility.getProjectDirectory()+"//resources//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(baseUrl);
			return driver;
		}
		else {
	
		return driver;
	}
	}
		
		public static void main(String[] args)
		{
			getWebDriver();
		}
	
	
}
