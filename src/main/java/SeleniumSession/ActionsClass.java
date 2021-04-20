package SeleniumSession;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Action Inteface/Actions Class provided by Selenium
 * Key:Driver and Perform.
 * 
 * Takes Driver as Argument.
 * Perform() is must.Build and perform depends
 * draganddrop,moveto,click,sendKeys,RightClick(Context),Double click etc.
 * Without perform() it wont work;
 */
public class ActionsClass {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

//DragMe and Drop
//		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
//		
//		Actions act=new Actions(driver);
//		
//		WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
//		WebElement drop=driver.findElement(By.xpath("//div[@id='droppable']"));
//		
//		act.dragAndDrop(drag, drop).perform();		
	    //act.clickAndHold(drag).moveToElement(drop).release().build().perform();

		
//Right Click
//		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
//		Actions act=new Actions(driver);
//		
//		WebElement right_click=driver.findElement(By.xpath("//span[text()='right click me']"));
//		act.contextClick(right_click).perform();
//		Thread.sleep(1500);
		
//		List<WebElement> rc_List=driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']/li/span");
//		for(WebElement e:rc_List)
//		{
//			String txt=e.getText();
//			if(txt.equalsIgnoreCase("edit"))
//			{
//				e.click();
		      //Below code is used as it generates AlertBox else not needed
//				Alert jsalert=driver.switchTo().alert();
//				System.out.println(jsalert.getText());
//				jsalert.accept();
//			}
//		}
	
//**************Generic Util for above****************		
		By rc_options=By.xpath("//ul[@class='context-menu-list context-menu-root']/li/span");
		//doActionRightClickOption(rc_options,"copy");
		
//Double-Click		
		driver.get("https://artoftesting.com/sampleSiteForSelenium");
		WebElement dbl_click=driver.findElement(By.id("dblClkBtn"));
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		act.doubleClick(dbl_click).perform();;
		//Below code is used as its having AlertBox
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
	}//main method ends here.
	
	
	
//Generic function for right_click_optionsList_Action	
		public static void doActionRightClickOption(By locator,String value)
		{
		List<WebElement> rc_List=driver.findElements(locator);
		for(WebElement e:rc_List)
		{
			String txt=e.getText();
			if(txt.equalsIgnoreCase(value))
			{
				e.click();
				break;
			}
		}
	    }

}
