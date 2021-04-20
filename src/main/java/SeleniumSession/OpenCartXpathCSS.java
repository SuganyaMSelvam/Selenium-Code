package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Sequence of using Locators
 * ID,Classname,CSS,Xpath
 */


public class OpenCartXpathCSS {
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=common/home");
		driver.manage().window().maximize();
		
//home page-Locators
		
		//By my_acct=By.xpath("//span[text()='My Account']");
		By my_acct=By.cssSelector("a.dropdown-toggle");
		doClick(my_acct);
		By reg=By.cssSelector("ul.dropdown-menu.dropdown-menu-right >li>a");
		doClick(reg);
		//By reg=By.xpath("//a[text()='Register']");
		
//Register page-Locators		
		//By fname=By.cssSelector("input[id=input-firstname]");
		//By fname=By.xpath("//input[@id='input-firstname']");
		By fname=By.id("input-firstname");
		getElement(fname).sendKeys("Suganya");
		By lname=By.id("input-lastname");
		getElement(lname).sendKeys("Selvam");
		By email=By.id("input-email");//input[id=input-email]-CSS, //input[@id='input-email']
		By tele=By.id("input-telephone");////input[@id='input-telephone'] input[id=input-telephone]
//Your Pwd		
		By pwd=By.id("input-password");//input[type=password][name=password] //input[@class='form-control' and @name='password']
		By conf_pwd=By.id("input-confirm");
//Newsletter	
//		(//input[@type='radio'])[2] gives "YES" based on position
		By Yes=By.xpath("//label[normalize-space()='Yes']"); //Recommended		
		//By Yes=By.xpath("//label[@class='radio-inline']");Working but not recommended in this case
        System.out.println(getElement(Yes).getText());
	}
public static void doClick(By locator)
{
	driver.findElement(locator).click();
}

public static WebElement getElement(By locator) 
{
	return driver.findElement(locator);	
}


}