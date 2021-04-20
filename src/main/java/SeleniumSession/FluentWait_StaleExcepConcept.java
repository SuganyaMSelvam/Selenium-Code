package SeleniumSession;
/*
 * FluentWait and WebDriverWait are same concept-wise some differences like
 * Initialization(Topcasting in FluentWait,also Generic differ,constructor
 *              WebDriverWait typical Class initialization with constructor(driver,timeOut)
 * <Ignoring Exceptions> main difference-MakesureExceptions are from Selenium(orq.openqa.selenium not java.lang etc)
 * Recommended:FluentWait(as its Parent class)
 * apart from that <until implementation method is same for both>
 *Refer End Notes: FluentWait ideal solution for AJAX and dynamic pages like world population count.
 * 
 */

import java.time.Duration;

import org.openqa.selenium.Alert;
/*
 * FluentWait is Parent Class implements Wait Interface which has until method implemented at FluentClass.
 * 
 */
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWait_StaleExcepConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		// WebDriverWait (c) --> FluentWait (c) ---> Wait(I) --> until(M)

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().window().maximize();
		By username = By.name("username");
//		
//		Wait<WebDriver>  wait=new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(5))
//				.pollingEvery(Duration.ofMillis(200))
//				.ignoring(NoSuchElementException.class)//max of timeout(5 sec)specified Exception willnot be thrown even if found,after 5sec All Exception pertaining to the context including specified ignored Exception will b thrown in Console
//				.ignoring(StaleElementReferenceException.class);
//				
//	wait.until(ExpectedConditions.visibilityOfElementLocated(username));			

		//fluentWaitForVisibilityofElement(username, 6, 200).sendKeys("groupautomation");
		
		WebElement e=fluentWaitForVisibilityofElement(username, 10, 200);//e-V1  WE
		e.sendKeys("groupautomation");//Performing on V1 with V1-WE.
		
		driver.navigate().refresh();//V2 webpage	
		//e.sendKeys("groupautomation");//Performing on V2 with same V1-WE
		
//Above Will give StaleException.
//StaleExcep comes when we perform Operation on V1 of Webpage-Element,once page refresh/back/forth traverse samepage becomes v2,so we need to find WE then perform action.Simple performing operation on V1 of WE throws this Exception..		
//to solve above Stale Exception,find WE once again and pass the value tat will be taken care by FluentWait
		
		fluentWaitForVisibilityofElement(username, 6, 200).sendKeys("groupautomation");//V2-performing V2WE
	}

	// *************UTIL**************************************
	
	public static WebElement fluentWaitForVisibilityofElement(By locator, long timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
				
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static Alert fluentWaitforAlert(By locator,long timeOut,long pollingtime) {
    Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
    		.withTimeout(Duration.ofSeconds(timeOut))
    		.pollingEvery(Duration.ofSeconds(pollingtime))
    		.ignoring(NoAlertPresentException.class);

    		return wait.until(ExpectedConditions.alertIsPresent());	
	}
	
	public static WebDriver fluentWaitforFrame(By locator,long timeOut,long pollingtime) {
	    Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
	    		.withTimeout(Duration.ofSeconds(timeOut))
	    		.pollingEvery(Duration.ofSeconds(pollingtime))
	    		.ignoring(NoSuchFrameException.class);

	    		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));	
		}

}
//Uses of FluentWait: AJAX/With/W/O DOM Refresh and Dynamic Pages/DOM refresh
/* Wait<WebDriver>  wait=new FluentWait<WebDriver>(driver)
			     .withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(200))
				.ignoring(NoSuchElementException.class)-> this will helps to handle the situation whenever Page refresh/traversed/performed operation 
//It Will ignore those exceptions for timeout specified then it will create WE,Exp: AJAX-Cos it occupies a particular space on Webpage(V1) and Page doesnt have to refresh(V1) on the whole I mean DOM is not refreshed. Only that particular portion of AJAX component got updated/dynamically. So No new Version of Page same V1,on tat AJAX only got updated.
 *FluentWait will wait and then create WE-Ideal solution for ALL AJAX 
 *			
				.ignoring(StaleElementReferenceException.class);->This will helps when DOM refreshed and operation is performed. So new Page is created everytime(V2,V3) whenever operation is performed on page.
FluentWait Ideal solution for everytime DOM Refresh-Ignores StaleExcep till Timeout->then Create new WE then operation can be performed.
				
wait.until(ExpectedConditions.visibilityOfElementLocated(username));			

 */
