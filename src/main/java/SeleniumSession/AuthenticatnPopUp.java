package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * Authentication PopUp -not a Webelement,its part of browser.
 * We have to provide usrname,pwd for this AuthPopUp
 * Solution:Along with launching the URL,provide <usr:pwd@URL> 
 * Constraint:u cant use pwd with @,as @ is the delimiter.
 */
public class AuthenticatnPopUp {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
	}

}
