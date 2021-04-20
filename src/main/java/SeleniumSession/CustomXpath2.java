package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * In this, we r using Sibling Xpath concept as POSITION in Webpage Table constantly changes
 * we cant create Xpath on position, we need to create based on txt visible on page.
 * In this case,name on table,then traverse right(details) and left(Checkbox).
 * Create Generic Xpath 
 */


public class CustomXpath2 {
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://classic.crmpro.com/index.html");
//Login	-Finding WE,sending keys,click login 
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("groupautomation");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
//Switch to FRAME as element is inside FRAME
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='mainpanel']")));
		
//Find the WE and click.		
	    driver.findElement(By.linkText("CONTACTS")).click();	    
 //driver.findElement(By.xpath("//div[@id='navmenu']/ul//a[@title='Contacts']"));
	    driver.manage().window().maximize();
	    
//***********************************************************************//	    
	    //HERE COMES WEBTABLE,XPATH CREATION
	    
//CheckBox-WebElement
//finding in DYNAMIC webtable using text()=name as name is constant rather than positioning of checkbox	
	//String chkbox="//a[text()='Devisha Sharma']/parent::td/preceding-sibling::td/input[@type='checkbox']";
	//driver.findElement(By.xpath(chkbox)).click();
	    
/*Decoding X-path
1) //a[text()='Devisha Sharma']->Constant/Base for traversing cos we r checking the box based for a name logically not everytime devisha is going to be 10th position it changes,but devisha's checkbox is always hers not Suganya's.
2) /parent::td->Traversing to parent->getting td/cell of Devisha Sharma in that table (in that row,in that column)-Cell position
3) /preceding-sibling::td->->Traversing to Left-In DOM its above,
         //in this case it gives 1 as only one-Preceding-(Left)sibling is available thats why String is used to store
4) /input[@type='checkbox']->Traversing to the checkbox(as chkbox is left to the Cell(positionof above))
*/
	    
	   
//WebElement-Right to Devisha in Webtable-Details of her like companyname,phone,etc
	  //Sibling-Right-6 available,use List to get 6 details of 'Devisha'
//	   String details="//a[text()='Devisha Sharma']/parent::td/following-sibling::td";		 
//	   List<WebElement> detailsList=driver.findElements(By.xpath(details));
//	   for(WebElement e:detailsList)
//	   {
//		   System.out.println(e.getText());
//	   }
   
//Sibling-Right-Very first-[1] or td/a to get the particular info
//	   String company="//a[text()='Devisha Sharma']/parent::td/following-sibling::td[1]";
	 //a[text()='Devisha Sharma']/parent::td/following-sibling::td/a->Gives 7,but with driver.findElement its gives 1st one -1st right-following sibling.
	 //a[text()='Devisha Sharma']/parent::td/following-sibling::td/a[@context='company']
//	 driver.findElement(By.xpath(company)).getText();  
	    
//Like the above,u can get each info separately using particular Xpath
	  //a[text()='Devisha Sharma']/parent::td/following-sibling::td/span-Gives 3 but FE will give the 1st one.
	   
//***********************************************************	     
	   
	    getCheckbox("Devisha Sharma");
	    getAllDetails("Jade Green");
	    System.out.println(getCompanyName("Devisha Sharma"));
	   
	}//main mthd
	   
	
	
//Generic method for above X-path so any checkbox can be clicked,based on name
	
public static void getCheckbox(String name)
{
	String chkbox="//a[text()='"+name+"']/parent::td/preceding-sibling::td/input[@type='checkbox']";
	driver.findElement(By.xpath(chkbox)).click();
}
	  
public static void getAllDetails(String name)
{
	String details="//a[text()='"+name+"']/parent::td/following-sibling::td";
	List<WebElement> detailsList=driver.findElements(By.xpath(details));
	   for(WebElement e:detailsList)
	   {
		   //System.out.println(e.getText());
		   String txt=e.getText();
		   if(!txt.isEmpty())
		   {
			   System.out.println(txt);
		   }
	   }
}

public static String getCompanyName(String name)
{
	 //String company="//a[text()='"+name+"']/parent::td/following-sibling::td[1]";
	String company="//a[text()='"+name+"']/parent::td/following-sibling::td/a[@context='company']";
	 return driver.findElement(By.xpath(company)).getText();
}
	    
}

