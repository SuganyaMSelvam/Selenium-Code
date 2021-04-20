package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 *  WebDriverWait(Childclass) -- class in Selenium
	 extends FluentWait (Parentclass) --> implements Wait Interface - until method
		// until method is implemented in FluentWait class 
		//it can be applied for any WebElement and non WEs (alert, url, title)
		 
		 * WebDriverWait function:Wait+WE creation
		 * Waits for time specified for the element to be Visible/located.
		 * Also Dynamic in nature
		 * Then it creates WebElement based on locator given/Method used.
		 * Applied on driver like anyother Wait,+<Time,locator>provide.

		 * 4 methods explained below,
		 * for Frame-2 ways(driver.switch)+(method available in Webdriver)
 */
public class WebDriverWaitConcept {
static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver(); making static for Generic Util
		driver=new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().window().maximize();
//Its not like Implicit Wait which is declared after driver initialization

//By Locators-like instant variables-declare		
		By usrname=By.name("username");
		By pwd=By.name("password");
		By logn=By.xpath("//input[@type='submit']");
		//By logt=By.xpath("//a[contains(text(),'Logout')]");

//WebDriverWait initialization,needs driver,timeout and locator(dependonMethodcalled)
//	Function:Wait+WE creation	
//		WebDriverWait wait=new WebDriverWait(driver,10);
//		WebElement usr=wait.until(ExpectedConditions.presenceOfElementLocated(usrname));		
/*
 *Element is present on the DOM of a page.not necessarily mean that the element is visible.(Webpage)		
 *  Returns WebElement if located.
 *  This mtd checks only in DOM not necessarily on Webpage-visibility
 */  
		//usr.sendKeys("groupautomation");		
		waitforElementPresent(usrname, 5).sendKeys("groupautomation");
		
//Logically-when usrname is visible-page is loaded for login details-pwd,login	
//Use:We don't have to apply wait on below two-Saves time,Flexibility unlike ImplicitWait which is global
		
		driver.findElement(pwd).sendKeys("Test@12345");
		driver.findElement(logn).click();
//********************FRAME************************************************		
		By logt=By.xpath("//a[contains(text(),'Logout')]");
		
		//driver.switchTo().frame("mainpanel");//Frame name provide		
	
//		WebDriverWait wait=new WebDriverWait(driver,5);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(logout)));		
//Provide WebElement as arg-doesnt create WE,chks only Visibility.

//Visibility means that the element is not only displayed but also has a height andwidth that is greater than 0.
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
//Created WE+wait+visible chk,we need to provide locator as arg)
//Definition same as above difference is this Returns WE.
	//WebElement logout=wait.until(ExpectedConditions.presenceOfElementLocated(logt));
		
		//waitforElementVisibility(logt, 5).click();;
//		WebElement e=driver.findElement(logt);
//		waitforWebElementVisibility(e, 6);
//		e.click();
	
		
		//driver.switchTo().frame("mainpanel");
		
		
//SwitchTo Frame by Index,name,WebElement
		//By frameloc=By.name("mainpanel");//locator
		//frameTobeAvailable(frameloc,8,logt);//By locator
		//frameTobeAvailable("mainpanel",6,logt);//String 
		frameTobeAvailable(1,10,logt);//Index//Frame[1] means 2nd frame
		//WebElement frameWE=driver.findElement(By.name("mainpanel"));
		//frameTobeAvailable(frameWE, 6, logt);//WebElement
	
			
	}//main methd ends here
	
		//***************Generic Util********************//
		public static WebElement waitforElementPresent(By locator,long timeOut)
		{
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
		    return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		
		public static WebElement waitforElementVisibility(By locator,long timeOut)
		{
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		
		public static void waitforWebElementVisibility(WebElement e,long timeOut) {
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			wait.until(ExpectedConditions.visibilityOf(e));			
		}
		
		public static void frameTobeAvailable(By locator,long timeOut,By locator1)
		{
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
			driver.findElement(locator1).click();
		}
		public static void frameTobeAvailable(String frame_name,long timeOut,By locator)
		{
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame_name));
			driver.findElement(locator).click();
		}
		public static void frameTobeAvailable(int index,long timeOut,By locator)
		{
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
			driver.findElement(locator).click();			
		}
		public static void frameTobeAvailable(WebElement e,long timeOut,By locator)
		{
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(e));
			driver.findElement(locator).click();			
		}
		
		
}//class ends
