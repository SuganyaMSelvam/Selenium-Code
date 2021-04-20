package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//Handling Drop-Downs without Select Class Handle
//Logic- Get all options from dropdown-FE's -List store
//Loop-fetch element ---->chk-against-User choice<Condition>-->click->quit

public class DropDownWithoutSelectClass {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		driver.manage().window().maximize();
//		below 3 lines are not needed
//		//By country=By.id("Form_submitForm_Country");
//		//driver.findElement(country).click();
//		//Thread.sleep(2000);
		
	    //By country_options=By.xpath("//select[@id='Form_submitForm_Country']/option");
//	//Getting allOptions
	    //List<WebElement> countryList=driver.findElements(country_options);
//	//Traversing      
//	    for(WebElement e:countryList)
//	    {
	    //System.out.println(e.getText());
//	    	String txt=e.getText();
//	    	if (txt.equalsIgnoreCase("India"))
//	    	{
//	    		e.click();
//	    		//System.out.println(driver.getCurrentUrl());
//	    		break;
//	    	}
//	    }
//		
		By country_options=By.xpath("//select[@id='Form_submitForm_Country']/option");
		dropDownwithoutSelect(country_options,"Benin");
	}
	    //****************Util for this******************************//
	  public static void dropDownwithoutSelect(By locator,String value)
	    {
	    	 List<WebElement> countryList=driver.findElements(locator);
	    	 for(WebElement e:countryList)
	    		    {
	    		    	String txt=e.getText();
	    		    	if (txt.equalsIgnoreCase(value))
	    		    	{
	    		    		e.click();
	    		    		break;
	    		    	}
	    		    }
	    }
		

	

}
