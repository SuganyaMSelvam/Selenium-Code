package SeleniumSession;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NaukriPopUpHandle {
	
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.naukri.com");
//Opening this URL give Pop-Ups(child Windows-WindowHandler API)
		String parentwin=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		System.out.println(it);
		while(it.hasNext())
		{
			String childwindow=it.next();
			if(!parentwin.equalsIgnoreCase(childwindow))
			{
			driver.switchTo().window(childwindow);
			driver.close();
			}
		}
		driver.switchTo().window(parentwin);
		
		System.out.println("title :"+driver.getCurrentUrl());
	}

}
