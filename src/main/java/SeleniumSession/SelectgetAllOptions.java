package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/*GetAllOptions in Select Handle method. 
 * GettingAll options and Printing each option on console -->sln:getoption, gettext  
 * Choose an option-Validating against a particular selection,then click and exit.
 * Creating util for that. 
 * Select works only one WebElement
 *u r getting "A" webelement for a particular field(country) rather like getting all links/text where u use WebElements.
 */

public class SelectgetAllOptions {

  static WebDriver driver;
  
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By industry=By.id("Form_submitForm_Industry");
		doSelectGetOptions(industry, "Travel");
		
	/*	***************General way(Rough work before Utility methd creation**********
	 * 
//select works on single webelement as its obvious we work on a particular webElement
		Select sel_handle=new Select(driver.findElement(By.id("Form_submitForm_Industry")));
//Below 3 lines equivalent to above 1 line.
//		By industry=By.id("Form_submitForm_Industry");
//		WebElement e=driver.findElement(industry);
//		Select sel_handle=new Select(e);
//using Select handle_object we access getoption method	
		List<WebElement> sel_OptionsList=sel_handle.getOptions();//this mtd gives list of all options.
//Traversing list and printing each options-for loop
//OptionList is ListOfWebElements,we get each webelement and print tats y for loop-Webelement e is used.
		for(WebElement e:sel_OptionsList)
		{
		//System.out.println(e.getText());
			String txt=e.getText();//Getting details behindscenes but visible on browser(gettxt) u need Webelement(e).
			if(txt.equals("Travel"))
			{
				e.click();//Performing any action on browser u need Webelement.
				driver.manage().window().maximize();
				break;//u can select one option and move on to next field on browser.
			}
		}
*/		
	}
	
	//*******************************Utility window*******************************
	
	public static WebElement getWebElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public static void doSelectGetOptions(By locator,String value)
	{
		Select sel_handle=new Select(getWebElement(locator));
		List<WebElement> optionList=sel_handle.getOptions();
		for(WebElement e:optionList)
		{
			String txt=e.getText();
			if(txt.equals(value))
			{
				e.click();
				driver.manage().window().maximize();
				break;
			}
		}
	}

}
