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

/*
 * This class-Parent Window open-click 4 Links-opens child windows
 * totally 5 windows open,then get <each child window Title+URL , close>
 * Switch to Parent window finally.Get details,Close.
 */
public class WindowHandlePopUp5seg {
static WebDriver driver;

	public static void main(String[] args) throws InterruptedException  {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");//Parent
		
//Locators		
		By LinkedIn=By.xpath("//img[@alt='LinkedIn OrangeHRM group']");
		By fb=By.xpath("//img[@alt='OrangeHRM on Facebook']");
		By twitter=By.xpath("//img[@alt='OrangeHRM on twitter']");
		By youtube=By.xpath("//img[@alt='OrangeHRM on youtube']");				

		
//find WebElements+click		
		driver.findElement(LinkedIn).click();
		Thread.sleep(1000);
		driver.findElement(youtube).click();
		Thread.sleep(1000);
		driver.findElement(twitter).click();
		Thread.sleep(1000);
		driver.findElement(fb).click();
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
//Now u have 5 windows(1 Parent+4 child)		
		Set<String> handleId=driver.getWindowHandles();//it has 4+1 segments
		Iterator<String> it= handleId.iterator();

//Modifying the below code
//		String parentId =it.next();
//		System.out.println("ParentId :"+parentId);
//		//System.out.println(driver.getTitle());
//		System.out.println("----------");
//		String childId1=it.next();
//		System.out.println("childId1 :"+childId1);
//		driver.switchTo().window(childId1);
//		System.out.println("Title of Child1 is :"+driver.getTitle());
//		System.out.println("URL of Child1 is :"+driver.getCurrentUrl());
//		System.out.println("----------");
//		Thread.sleep(1000);
//		driver.close();
//		String childId2=it.next();
//		System.out.println("childId2 :"+childId2);
//		driver.switchTo().window(childId2);
//		System.out.println("Title of Child2 is :"+driver.getTitle());
//		System.out.println("URL of Child2 is :"+driver.getCurrentUrl());
//		System.out.println("----------");
//		driver.close();
//		Thread.sleep(1000);
//		String childId3=it.next();
//		System.out.println("childId3 :"+childId3);
//		driver.switchTo().window(childId3);
//		System.out.println("Title of Child3 is :"+driver.getTitle());
//		System.out.println("URL of Child3 is :"+driver.getCurrentUrl());
//		System.out.println("----------");
//		driver.close();
//		String childId4=it.next();
//		System.out.println("childId4 :"+childId4);
//		driver.switchTo().window(childId4);
//		System.out.println("Title of Child4 is :"+driver.getTitle());
//		System.out.println("URL of Child4 is :"+driver.getCurrentUrl());
//		System.out.println("----------");
//		Thread.sleep(1000);
//		driver.close();
//		driver.switchTo().window(parentId);
//		System.out.println("Title of PArent :"+driver.getTitle());
//		System.out.println("URL of Parent :"+driver.getCurrentUrl());
//		Thread.sleep(2000);
//		driver.quit();
		
		//System.out.println(it);//it gives 5 segmentsIds in SET
		 String parentId=driver.getWindowHandle();//Currently Webdriver is in Parent
		
		int counter=1;
		while(it.hasNext())
		{
			String childId=it.next();
			if(!parentId.equalsIgnoreCase(childId))
			{
				System.out.println("Child Window"+counter+" :");
				doSwitchGetIdTitle(childId);
				counter++;
			}
		}
		doSwitchGetIdTitle(parentId);
				
	}
		
public static void doSwitchGetIdTitle(String id)
{
		driver.switchTo().window(id);
		System.out.println("Title :"+driver.getTitle());
		System.out.println("URL :"+driver.getCurrentUrl());
		System.out.println("------------");
		driver.close();		
	}
}
