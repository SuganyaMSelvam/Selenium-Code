package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//MultiSelection DropDown 
//Tc1:Single selection
//Tc2:MultiSelection:String Array but its String... not String[]
//TC3:All options-
//Generic approach which works for Tc1,tc2,tc3.


public class JQueryMultipleDropdown {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(2000);
		
//Locators
		By choices=By.xpath("//span[@class='comboTreeItemTitle']");
		//By choiceOptions=By.className("comboTreeItemTitle");
		//By choiceOptions=By.cssSelector(".comboTreeItemTitle");//gives 45
//GetElements		
		//List<WebElement> choiceList=driver.findElements(choices);
		
//Calling Generic method for all 3 TC
		//doMultiDropDownHandle(choices, "choice 7");//didnt work wen String[] is given instead of String...
		doMultiDropDownHandle(choices,"choice 2 3","choice 6 2 2","choice 7","choice 1");
		//doMultiDropDownHandle(choices, "AlL");
		
//TC1:Single Selection		
//Below code works fine for DropDown-Single Selection but for MultiSelection DropDown?		
//		for(WebElement e:choiceList)
//		{
//System.out.println(e.getText());	
//above stmt doesnt work without click and thread,also when xpath has /input included at end.
//			String txt=e.getText();
//			if(txt.equals("choice 2 3"))
//			{
//				e.click();
//			}
//		}
		
//TC2:Multi-Selection-Static Array:string for storing choices of user.
//		String[] usrChoice=new String[3];
//		usrChoice[0]="choice 2";
//		usrChoice[1]="choice 6 2";
//		usrChoice[2]="choice 6 2 3";
//		for(WebElement e:choiceList)
//		{
//			String txt=e.getText();
//			for(int j=0;j<usrChoice.length;j++)
//			{
//				if(txt.equals(usrChoice[j]))
//				{
//					e.click();
//					//break;//this doesnt do any difference
//				}
//			}
//		}
//TC3:All options-select
//Get all options-List store-click inside loop
//In this case it throws exception as source code shows 44 elements with Xpath but getText/Visible option is only 14 .
//selenium.ElementNotInteractableException-unable to interact when performed.click on 15th element.		
//		List<WebElement> allOptions=driver.findElements(By.cssSelector(".comboTreeItemTitle"));
//		
//		for(WebElement e:allOptions)
//		{
//			try
//			{
//				e.click();	
//			}
//			catch(Exception c)
//			{
//			//System.out.println("Exception captured");	
////when u print something it shows tat many times whenever catch is executed so its better not to print until its needed.	
//			}
//		}
		
//**********************Utility-Generic way****************************************		
		
	}// main mtd ends here.
	
	public static void doMultiDropDownHandle(By locator,String... value)
	{
		List<WebElement> locList=driver.findElements(locator);
		if(!value[0].equalsIgnoreCase("ALL"))
		{
		for(WebElement e:locList)//Dynamic array-OuterLoop
		//for(int i=0;i<locList.size();i++)
		{
			//WebElement e=locList.get(i);locList.get(i).getText();
			String txt=e.getText();
			for(int j=0;j<value.length;j++)//Static-InnerLoop 
			{
			if(txt.equals(value[j])){
				e.click();
//				if(txt.equals("choice 6"))
//				{
//					e.click();
//					System.out.println("DeSelected the choice 6 if selected");
//				}
			                       }
			           }
		   }
		}
		else {
			for(WebElement e:locList)
			{
				try
				{
				e.click();
				}
				catch(Exception c)
				{
					
				}
			}
			
		}
		
	}
	
}

