package SeleniumSession;

import org.openqa.selenium.By;

/*URL,Pop_up,title are not part of WE so Webdriver wait can handle those*/


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForUrlandTitle {

static WebDriver driver;

	public static void main(String[] args)  {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			driver.get("http://automationpractice.com/index.php");	
			//Thread.sleep(1000);//instead of this we can use Webdriver wait too
			driver.manage().window().maximize();
			
//Scenario:Click contact us verify title and URL of tat			
			//driver.findElement(By.xpath("//a[text()='Contact us']")).click();
			By loc=By.linkText("Contact us");
		   findElementandCreate(10,loc).click();
			
			
//Exact Title-Arg Pass and verify-Returns true/False		
//			WebDriverWait wait=new WebDriverWait(driver, 6);
//			Boolean a =wait.until(ExpectedConditions.titleIs("Contact us - My Store"));
//			System.out.println(a);
			//verifyExactTitle(5,"Contact us");//ErrorLog shows correct Title when we pass the wrong one
			//verifyExactTitle(5,"Contact us - My Store");
//			if(verifyExactTitle(5,"Contact us - My Store"))
//			{
//				System.out.println("Correct title");
//			}
			
//Title contains
			//verifyTitleContains(4, "Contact us");
		   verifyTitleContains(10,"Contact",2);//2 ms interval instead of default 500 MSec
			
//VerifyURL	
		   //verifyExactURL(5,"http://automationpractice.com/index.php?controller=contact");
		   
//VerifyURLcontains-Fraction of the URL-Most Widely used for Testing
		   //verifyURLContains(5,"controller=contact");
		   
//TestNG testing use	
		   if(verifyURLContains(5,"controller=contact"))
				   {
			   System.out.println("URL provided is checked and its correct");
				   }
		   
		   
	}//main methd ends here
//**************************UTIL*************************************
	public static WebElement findElementandCreate(long timeOut,By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}		
//Title	
		public static boolean verifyExactTitle(long timeOut,String exptitle)
			{
				WebDriverWait wait=new WebDriverWait(driver, timeOut);
				return wait.until(ExpectedConditions.titleIs(exptitle));
			}
		public static boolean verifyTitleContains(long timeOut,String title)
			{
				WebDriverWait wait=new WebDriverWait(driver, timeOut);
				return wait.until(ExpectedConditions.titleContains(title));
			}
		public static boolean verifyTitleContains(long timeOut,String title,long sleepTimeOut)
		{
			WebDriverWait wait=new WebDriverWait(driver, timeOut,sleepTimeOut);
			return wait.until(ExpectedConditions.titleContains(title));
		}
//URL		
		public static boolean verifyExactURL(long timeOut,String url)
		{
			WebDriverWait wait=new WebDriverWait(driver, timeOut);
			return wait.until(ExpectedConditions.urlToBe(url));
		}
		public static boolean verifyURLContains(long timeOut,String url_fraction)
		{
			WebDriverWait wait=new WebDriverWait(driver, timeOut);
			return wait.until(ExpectedConditions.urlContains(url_fraction));
		}
	
		
			
			
	

}
