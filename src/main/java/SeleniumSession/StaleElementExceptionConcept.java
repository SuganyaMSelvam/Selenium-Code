package SeleniumSession;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*V1-OldWebpage -WE(eV1)
 * V2-New WebPage-WE(eV2)
 * Problem: Perform operation on eV1(WE) on V2(new WebPage)
*StaleExcep will be thrown when we perform Operation on V1 of Webpage-Element(ev1),
*once page refresh/back/forth/ traverse samepage becomes V2(cos DOM refresh everytime)
 * so we need to find/create new WE(eV2) then perform action.Simple performing operation on V1 of WE throws this Exception..
 * 		
 *Solution:find/Create WE(ev2) everytime when page changes/refresh/traverses 
        and perform the Operation on new WE(V2)
        Refer FluentWait for handling this at larger level

 */
public class StaleElementExceptionConcept {

static WebDriver driver;

public static void main(String[] args) throws InterruptedException {			
				
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				
				driver.get("https://classic.crmpro.com/index.html");//v1
				By username = By.name("username");//v1
				
				WebElement user_ele = driver.findElement(username);//v1
				user_ele.sendKeys("batchautomation");//v1
				
				Thread.sleep(3000);
				
				driver.navigate().refresh();
				
				//v2 --DOM
				//v2 -- e			
				//user_ele = driver.findElement(username);//Creating new WE(eV2 on V2)
				user_ele.sendKeys("batchautomation");//Performing Operation on eV1 on V2 Webpage
				//Above Will give StaleException without line 41 uncommenting
			
		}

}

