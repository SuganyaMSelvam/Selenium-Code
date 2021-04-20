package SeleniumSession;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle2UseCases {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");//Parent
		By LinkedIn=By.xpath("//img[@alt='LinkedIn OrangeHRM group']");
		By fb=By.xpath("//img[@alt='OrangeHRM on Facebook']");
		By twitter=By.xpath("//img[@alt='OrangeHRM on twitter']");
		By youtube=By.xpath("//img[@alt='OrangeHRM on youtube']");				

//At a time multi-segments-window open
//		dogetWebElement(twitter).click();
//		Thread.sleep(1000);
//		dogetWebElement(LinkedIn).click();
//		dogetWebElement(youtube).click();
//		Thread.sleep(1500);
//		doIterateWindowId();
		
//At a time only 2 segments of windows open		
        dogetWindowHandles(twitter);
        dogetWindowHandles(youtube);
		
	}
	
	public static WebElement dogetWebElement(By locator)
	{
		return driver.findElement(locator);
	}
	
//At a time only 2 segments of windows open	(One Parent other Child)
	public static void dogetWindowHandles(By locator) 
	{
		dogetWebElement(locator).click();
		Set<String> handleId=driver.getWindowHandles();
		Iterator<String> it= handleId.iterator();
		String parentId =it.next();
		String childId=it.next();
		dogetWindowIdTitle(childId);
		driver.close();
		dogetWindowIdTitle(parentId);
	}
	
//At a time anynumber of segments(4 in this case) open
	public static void doIterateWindowId()
	{
		Set<String> handleId=driver.getWindowHandles();
		List<String> handleList=new ArrayList<String>(handleId);
		String ParentId=handleList.get(0);
		//for(String s:handleList)-As i need indexing I didnt use EnhancedFORLOOP
		for(int i=1;i<handleList.size();i++)
		{
			String childId=handleList.get(i);
			dogetWindowIdTitle(childId);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.close();
			
		}
		//System.out.println("Out of Loop");
		dogetWindowIdTitle(ParentId);
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	
//Generic function to get Id/Switch to Window/Get Title/URL	
	public static void dogetWindowIdTitle(String id)  
	{
		System.out.println("CurrentId :"+id);
		driver.switchTo().window(id);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Title is:"+driver.getTitle());
		System.out.println("Current URL :"+driver.getCurrentUrl());
		System.out.println("-------------------------");
		return;
	}
}
	
	
	


