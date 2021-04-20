package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;


//No GUI-Runs background webpage-(U cant see the page)
//Fast,mostly used on server side where no installation of browser needed
//CI-Jenkins,multitasking,multiwindows,multibroswers,grid use
//not for usual webpage where we need to interact(user actions required)
public class HeadlessBrowser {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		
		//ChromeOptions(Class) provided by Selenium to interact with ChromeBrowser in Headless mode
		ChromeOptions co=new ChromeOptions();
		//"headless" specifies to launch as Headless Browser.
		co.addArguments("headless");
		
		
		//We have to pass arguments when starting the driver.
		WebDriver driver=new ChromeDriver(co);
		
		driver.get("https://www.google.com");
		System.out.println("URL :"+driver.getCurrentUrl());

	}

}
