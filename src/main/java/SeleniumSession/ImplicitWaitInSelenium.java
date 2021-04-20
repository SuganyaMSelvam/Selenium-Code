package SeleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Thread-static wait-pause script for particular time
 * Dynamic wait- -> time out is dynamic
			a. Implicitly wait
			b. Explicit Wait
				b.1: WebDriverWait(ChildClass)
				b.2: FluentWait(ParentClass)
		WebDriverWait extends FluentWait
		implementing Wait Interface which has Methods implemented in Classes
		
  Implicitly Wait:
           --is a global wait
           --only for web elements
           it will be applied after driver initialization
     It means implicitly script waits for time defined 
     for that WE to be found on the Webpage.If its found bf that time,ignores 
     remaining time and move on with next line execution but call will be
     made every time
           
Limitations: 
1)not applicable for non web elements: alert, url, title
				   FE/FEs -- by default imp wait will be applied
2)Performance will be affected as call will be made everytime to implicit Mtd
even though it ignores the time to wait if WE is found in no time.
3)In Framework we dont use this wait at all.Its not recommended
We never use this wait			
 */

public class ImplicitWaitInSelenium {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
//After driver initialization-IMPLICITWAIT declared on driver so whenever driver 
//is called default apply hereafter.
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
//URL launch		
		driver.get("https://classic.crmpro.com/index.html");
		
//FE	-Wait applicable if Web element is found within 2 seconds it will ignore remaining wait time here 8 seconds 
//and proceeds to next WebEle if its found withno time ignores 
//10 sec of wait time but internally call is made to the implicitMethod everytime then decision taken,Performance will be affected if we expand teh scale of FE		
		driver.findElement(By.name("username")).sendKeys("groupautomation");//2 -- 8
		driver.findElement(By.name("password")).sendKeys("Test@12345");//0
		driver.findElement(By.xpath("//input[@value='Login']")).click();//0
		
//We can override the method everytime for each/specified page/WE as wished
		//home page: 5
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				//e3//5 -- 5
				//e4 //0 
				//e5 //0 
		
//We can even Nullify it if we want	
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			//e6
			//e7
			//e8
			//e9 -- logout
//login page:Again we can override
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//e1 e2 e3 

	}

}
