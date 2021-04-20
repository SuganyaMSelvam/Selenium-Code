package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElem {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

//Formula is creating webelements+performing with them

//Finding/Creating WebElement-Use findelement
		// (By class->Id Static method->
		// HTML Tag-input,
		// Attributes/Properties like type,name,class,id values are "text","email" etc
		// +interacting(perform) with them sendkeys,click,isDisplayed.

		// 1st Approach
		// driver.findElement(By.id("input-email")).sendKeys("suganyamselvam@gmail.com");
		// driver.findElement(By.id("input-password")).sendKeys("admin789");

		// 2nd Approach(creating webelements separately then performing)
		// WebElement email=driver.findElement(By.id("input-email"));
		// WebElement pwd=driver.findElement(By.id("input-password"));

		// email.sendKeys("suganyamselvam@gmail.com");
		// pwd.sendKeys("admin789");

		// 3rd Approach(Creating By locators) then putting on 1st approach
		// Server request doesn't happen (script is not acting with
		// Selenium)-Optimization

		// By email=By.id("input-email");//acts like java normal variables-not
		// interacting with Server.
		// By pwd=By.id("input-password");

		// driver.findElement(email).sendKeys("suganyamselvam@gmail.com");
		// driver.findElement(pwd).sendKeys("admin789");

		// 4th Approach-By locators+create Webelements
//		By locators
//		By email=By.id("input-email");
//		By pwd=By.id("input-password");

//		Creating Webelements		
//		WebElement email_ele=driver.findElement(email);
//		WebElement pwd_ele=driver.findElement(pwd);

//		Performing action
//		email_ele.sendKeys("suganyamselvam@gmail.com");
//		pwd_ele.sendKeys("admin789");
//		
//	//5th approach 	:Generic Method [create o/s of main method]
//		//Method who needs locators and values to perform.(1st approach logic single line)
//		
//		By email=By.id("input-email");
//		By pwd=By.id("input-password");	
//		
//		getElement(email,"suganyamselvam@gmail.com");
//	}
//		
//		/*As this method is called in the main mtd we r using static keyword.*/
//		public static void getElement(By locators,String values)
//		{
//			driver.findElement(locators).sendKeys(values);
//		}

		// 6th Approach-Generic Methods create-call

		// define 2 methods for the above 2 actions o/s main method and call methd
		// ->Creating Webelement-> needs locators
		// ->Performing actions->needs values and it has to be performed on Webelements.
		// inturn it calls Webelement method(Method chaining)->Needs Webelement

		By email = By.id("input-email");
		By pwd = By.id("input-password");

		// call method
		doSendKeys(email,"suganyamselvam@gmail.com");

	}

	public static WebElement crteWebElement(By locators) {
		return driver.findElement(locators);
	}

    public static void doSendKeys(By locators,String values)//Method chaining cos this method cant work without WebElement
   {
    	crteWebElement(locators).sendKeys(values);
     }
}