package SeleniumSession;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserSwitchQuitClose {
	WebDriver driver=null;
	
	public void crossbrowser(String browser)
	{
	switch (browser) {
	case "chrome":
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\mssug\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//new ChromeDriver();Null Pointer Exception
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
	case "Edge":
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		break;
		//WebDriverManager.firefoxdriver().setup();//this command removes hectic of manually downloading exe file for that browser and providing the path.
		//driver=new FirefoxDriver();
		//U need to have the Browser(Firefox in ur system installed),only .exe file of driver will be automatically installed/updated by WebdriverManager.
	case "safari":
		driver=new SafariDriver();
		break;
	default:
		System.out.println("Sorry no match");
		break;
	}
	driver.get("http://www.google.com");
	System.out.println(driver.getTitle());
	
	
	//Sessionclosed by calling quit. Id will be pointing to null.Trying to print.
	//Session ID is null. Using WebDriver after calling quit()?
	//driver.quit();
	//System.out.println(driver.getTitle());
	
	//Sessionclosed by calling close. 
	//Session ID is invalid.
	driver.close();
	//System.out.println(driver.getTitle());
	
	
	}
	public static void main(String[] args) {
		CrossBrowserSwitchQuitClose cb=new CrossBrowserSwitchQuitClose();
		System.out.println("Enter the browser name");
		Scanner sc=new Scanner(System.in);
		cb.crossbrowser(sc.nextLine());
		sc.close();
	}

}
