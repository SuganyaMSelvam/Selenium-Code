package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	String st;
	WebDriver driver;
/**This method is used to initialize the browser
 * 
 * @param browser
 * @return Webdriver 
 */
	
	
	public WebDriver launchBrowser(String browser)

	{
		System.out.println("Browsername is:" + browser);
		// u can use switch stmt too instead of if stmt
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			return driver;
		} else if (browser.equals("edge"))
			WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		return driver;
	}

	public void launchURL() {
		driver.get("http://www.amazon.com");
		// driver.navigate().to(url);
	}

	public void gettitle() {
		System.out.println(driver.getTitle());
		this.st=driver.getTitle();
	}

	public void verification()
	{
		if (st.contains("Online"))
		{
	      System.out.println("Title is verified\n");		
		}
		else
		{
			System.out.println("Not correct one");
		}
	}
	
	public void navigation() {
		driver.navigate().to("\nhttp://www.ask.com");
		System.out.println("Now navigating to:"+driver.getTitle());
		driver.navigate().back();
		System.out.println("Back to:"+driver.getTitle());
		driver.navigate().forward();
		System.out.println("Forward to ask:"+driver.getTitle());
		driver.navigate().refresh();
		System.out.println("Refresh :"+driver.getTitle());
	}

	public void getCurrentpage() {
		System.out.println("\nCurrentURL is :"+driver.getCurrentUrl());
	}

	public void close() {
		driver.close();
		//driver.quit();
	}

}
