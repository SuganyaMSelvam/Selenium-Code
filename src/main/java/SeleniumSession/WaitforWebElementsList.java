package SeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitforWebElementsList {
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		
//Driver.FindElements-Avoid we can use WebdriverWait to Wait+create List of WE
//Scenario1:All the footer-linktext capture		
		By loc=By.cssSelector(".footer-main a");
		//By one=By.xpath("//li/a[text()='Citizens Advice']");
		
//List<WebElement> footerList=driver.findElements(loc);Replaced by below with Wait

//		WebDriverWait wait=new WebDriverWait(driver, 5);
//		List<WebElement> footerList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loc));
//		for(WebElement e:footerList)
//		{
//			System.out.println(e.getText());
//		}

		//waitgetTextforListofElements(loc, 5);
		
		
//Scenario2:Finding total number of links and images	
		By img=By.tagName("img");	
		int imgcnt=waitpresenceofOneElementinList(img,5).size();//77
		System.out.println("Total ImageCount:"+imgcnt);
		
		By img1=By.xpath("//img");
		//int imgcnt=waitpresenceofOneElementinList(img1,10).size();//77
//Visibility Method doesnt work for Images and Links		
	//int imgcnt=waitForVisibilityListofElements(img1, 10).size();not Working
		
		By links=By.tagName("a");
		int linkcnt=waitpresenceofOneElementinList(links, 5).size();
		System.out.println("Total No:of links :"+linkcnt);

	}//main mtd ends here
	
	
//************************UTIL*******************************
	public static List<WebElement> waitForVisibilityListofElements(By locator,long timeOut)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));	
	}
	
	public static void waitgetTextforListofVisibleElements(By locator,long timeOut)
	{
		//List<WebElement> locList=waitForListofElements(locator, timeOut);
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		List<WebElement> locList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		for(WebElement e:locList)
			{
				System.out.println(e.getText());
			}
	}
	public static List<String> waitGettextListofVisibleElements(By locator,long timeOut)
	{
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		List<WebElement> locList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		List<String> strList=new ArrayList<String>();//for use in loop
		for(WebElement e:locList)
		{
			if(!e.getText().isEmpty())
			{
				strList.add(e.getText());
			}
		}
		return strList;
	}
	
//Recommended for Links and Images<Tag name> 
//An expectation for checking that there is at least one element present on a web page.
	public static List<WebElement> waitpresenceofOneElementinList(By locator,long timeOut)
	{
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));	
	}

//Wait for the element to be Visible and enabled so that u can click+createWE
public static WebElement waitforElementTobeClickable(By locator,long timeOut)
{
	WebDriverWait wait=new WebDriverWait(driver, timeOut);
	return wait.until(ExpectedConditions.elementToBeClickable(locator));
}

public static void clickLocator(By locator,long timeOut)
{
	waitforElementTobeClickable(locator, 5).click();;
}


}//Class ends