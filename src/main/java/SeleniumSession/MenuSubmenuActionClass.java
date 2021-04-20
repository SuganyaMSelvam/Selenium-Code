package SeleniumSession;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Actions class-in Selenium imitates user actions on Keyboard,Mouse.
 * Action-Interface-single user action(PERFORM) whereas Actions is Class
 * We pass driver to Actions class.
 * single action-perform,multi-build().perform()
 * Limitations:Scrolling is not possible with Action.
 * In this code-Menu/Submenu handle
 * Lesson Learnt:We have to initate or find WE everytime
 *               whenever we refresh/switch/DOM pages else StaleReferException
 *
 */

public class MenuSubmenuActionClass {
	static WebDriver driver;
	static Actions act;
	static By content;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://mrbool.com/how-to-create-menu-with-submenu-using-css-html/26146");
		
//Locator
		//By course=By.xpath("//a[@class='menulink']");//Xpath
		content=By.className("menulink");
		By course=By.linkText("COURSES");
		By article=By.linkText("ARTICLES");
		By videos=By.linkText("SINGLE VIDEOS");
				
        
// Here passing the control of driver to Action class	
     		act=new Actions(driver);
     		
 
////Moving the cursor to Content  
//     	WebElement w_cont=driver.findElement(content);
//		act.moveToElement(w_cont).perform();//Without perform u wont see the submenu of Content
//		Thread.sleep(1500);
//		
////GetText() and LinkText does the same,both use the visible text of webpage not DOM.		
//        WebElement w_course=driver.findElement(course);//courses is used in DOM		
//        w_course.click();
// //act.click(w_course).perform();
// 
     	performMenuAction(content);
     	Thread.sleep(1000);
     	By submenu=By.xpath("//ul[@class='submenu']/li/a");
		performSubmenuAction(submenu);
		driver.switchTo().parentFrame();//same as 85line not working.
		
	}//main mthd ends here
	
    //************************GENERIC UTIL***************************************
	
    public static void performMenuAction(By locator)
    {
    		WebElement e =getElement(locator);
    		act.moveToElement(e).perform();
//above 2 lines can be written as below 1 line.    		
 //act.moveToElement(getElement(locator)).perform();
    }
    
    public static void performSubmenuAction(By locator)
    {
    	List<WebElement> locList=driver.findElements(locator);
    	//for(WebElement e:locList) u cant use,in this case better use with indexing
    	for(int i=0;i<locList.size();i++)
    	{
    		WebElement e=locList.get(i);
    		act.moveToElement(e).perform();
    		e.click();
    		performMenuAction(content);
    		locList=driver.findElements(locator);
    	}
    	driver.switchTo().defaultContent();//Not switching to first window
    }

   //want to do this 
//    act initiate(driver)//static
//    2.find (Main)webelement and move the cursor(act) to tat point
//    3.Thread
//    4.find WE of submenu,move cursor(act),click
//    5.driver.back
//    6.step 1 to 5 repeat

public static WebElement getElement(By locator) {
	return driver.findElement(locator);
}
/*
public static void doActionsMoveToElement(By locator) {
	Actions act = new Actions(driver);
	act.moveToElement(getElement(locator)).perform();
}

public static void doActionsMoveToElementAndClick(By locator) {
	doActionsMoveToElement(locator);
	getElement(locator).click();
}*/

}//Class ends here