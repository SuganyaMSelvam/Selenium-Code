package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

//Select Class from Selenium works for <select>html tag
//DropDown Handle using Select and its methods(Byvalue,index,VisibText)
//Create 3 methods for 3selectmethods
public class SelectHandle {
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");
		
		By country=By.id("Form_submitForm_Country");
		By industry=By.id("Form_submitForm_Industry");
		
//		//Select class-obj creation
//		Select sel_industry=new Select(driver.findElement(industry));
//		Select sel_country=new Select(driver.findElement(country));
//		//SelectBy Method use
//		sel_industry.selectByIndex(5);//Reseller
//		sel_country.selectByIndex(2);//Albania
//		
//		//Value and VisibleText doesnt hold samevalue eventhough select option is same
//		//sel_industry.selectByValue("media");
//		sel_industry.selectByVisibleText("Media / Marketing / Entertainment / Publishing / PR");
//		sel_country.selectByValue("Aruba");//Value and VisText both are case_sensitive-Copy from Inspect Source.
//				
		
		//Calling mtd using Index
		//doSelectByIndex(country, 5);
		//doSelectByIndex(industry, 9);
		
		//calling mthd using VisibleText
		//doSelectByVisibleText(country,"Brazil");
		//doSelectByVisibleText(industry,"Healthcare");
		
		//calling mthd using Value
		doSelectByValue(industry,"media");//One Select object
		doSelectByValue(country,"Canada");//another select Object-we cant reduce,its must for each selection.
		driver.manage().window().maximize();
		
//For each selectoption-SelectObject will be created so there is no optimization for creating objects. Only repetition of code shud be optimized in Util methods.
	}
	
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
//Method Overloading is only possible for index and text,cos 3rd method also uses txt as 2nd mtd-might be confusing when calling whther its Visbletext or value)
    public static void doSelectByIndex(By locator,int index)
    {
    	WebElement e=getElement(locator);
    	Select sel_index=new Select(e);
    	sel_index.selectByIndex(index);
    	//sel_index.deselectByIndex(index);-throws Exception as its not supported for single selection.
    }
    public static void doSelectByVisibleText(By locator,String text)
    {
    	WebElement e=getElement(locator);
    	Select sel_vtxt=new Select(e);
    	sel_vtxt.selectByVisibleText(text);
    }
    public static void doSelectByValue(By locator,String value)
    {
    	WebElement e=getElement(locator);
    	Select sel_val=new Select(e);
    	sel_val.selectByValue(value);
    }
}
