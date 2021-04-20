package SeleniumSession;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * not part of Webelement
 * Web/JS/browser based popups alerts <here JSbased alert>
 *JSAlert is separate window,u need to switch to that AlertBox and perform actions.
 *Solution:Alert Interface,SwitchTo use
 *Alert,Confirm,Prompt -AlrtBox can have
 *
 *Methods use-accept,getText,dismiss.
 *
 */
public class JSAlertPopUpHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		WebElement proceed=driver.findElement(By.name("proceed"));
		proceed.click();
		
//Above click takes us to AlertBox:First Switch and Use Alert Interface
		Alert myalert=driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(myalert.getText());
		myalert.accept();
		//myalert.dismiss();
		
//After this,driver switches back automatically,shown by fetching Title
		System.out.println(driver.getTitle());
		
		
		
	}

}
