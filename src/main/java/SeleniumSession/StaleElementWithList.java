package SeleniumSession;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * Solution:Everytime we need to find/create WE then perform 
 * whenever page changes/refresh/DOM refresh. 
 * In the Loop-at the end after performing operation,(new page will be loaded-V2)-
 *  create new WEList(eV2) with same By locator.(As line 34)
 *  WebElementIdentifier will be different for each page after page/DOM reloads
 *  RootCause:Internally Selenium maintains WEidentifier for each WE associated tat page
 */
public class StaleElementWithList {
	static WebDriver driver;
		
		public static void main(String[] args) throws InterruptedException {			
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.freshworks.com/");
			Thread.sleep(1000);
			
			//v1
			List<WebElement> compList = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[2]//a"));
			for(int i=0; i<compList.size(); i++) {
				System.out.println(compList.get(i).getText());
				compList.get(i).click();
				Thread.sleep(1000);
				//v2 v3
				compList = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[2]//a"));
//When the appln is big,wen u have to perform so many operations on Dynamic page like AJAX FluentWait is a good solution not this one(Creating WE everytime)
//Refer Fluent_wait for more info				
				
			}
			
			
		}

	
}
