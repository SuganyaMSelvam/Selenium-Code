package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrwserUtilities {
	
	//We are creating browser utilities so we r going to reuse the same class without modification.
	//Shud be GENERIC CLASS/WRAPPER CLass
	WebDriver driver;
	
	/**
	 * This method is used to initialize the browser
	 * @param browser
	 * @return WebDriver
	 */
	
	public WebDriver init_browser(String browser)
	{
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		case "safari":
			driver=new SafariDriver();//we dont need to call WebdriverManager
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default:
			System.out.println("Sorry u didnt pass correct Browser\n");
			break;
		}
		return driver;
	}

	public void launchUrl(String url)
	{
		//driver.get(url);
		driver.navigate().to(url);//to method(synonym to get)inturn call get method mentioned in line44.
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
		//String title=driver.getTitle();
		//return title;//Verification part is done by user in main mthd.
	}
	
	public String getCurrentPageURL()
	{
		return driver.getCurrentUrl();
	}
	
	public void navigation()
	{
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}
	
	 public void closeBrowser()
	 {
		 driver.close();
	 }
	 
	 public void quitBrowser()
	 {	 
		 driver.quit();
	 }
	
}
