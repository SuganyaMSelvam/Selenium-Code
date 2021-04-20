package SeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksFindGet {
	static WebDriver driver; 
	
	public static void main(String[] args) {
		//1.Total links and its text. Print only those r not blank with index.
		//html tag for links <a>
		//navigation Url-Link href.sometimes properties of <a> get those.(getattribute)
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		
	//List of Webelements,List an interface of ArrayList <generic use>,DynamicArray
	//it takes every tagname from <a> to </a> so if it has child-span under <a><span>0</span></a> it takes that "0" name too.
		
		 //List<WebElement> linklist=driver.findElements(By.tagName("a"));
		By links=By.tagName("a");
		 List<WebElement> linklist=getWebElements(links);
		System.out.println("Total links :"+linklist.size());
		
		ArrayList<String> TextList=getTextListLink(links);
		for(String s:TextList)
		{
			System.out.println(s);
		}
	}	//main mthd ends here
	
		/*Writing util method for the below for loop-which gives TextList
	-----------------------------------------------------------------------
		//Easy solution//Fair work//Rough work below
		for(int i=0;i<linklist.size();i++)
		{
			WebElement e=linklist.get(i);//returns "A" Webelement by indexing
			String txt=e.getText();//mtd works only on webelement not "Elements"
			//or String txt=linklist.get(i).getText();
	        //System.out.println(linklist.get(i).getText());//no validation
		//Validation part for notEmpty
			if(!txt.isBlank())// if its not blank/empty .isEmpty()
			{
				System.out.println(i+"--->"+txt);
			}
		}
		
		//Getting Attribute"Href" for the tag"a" using enhanced for loop
		for(WebElement h:linklist)
		{
			String hrf=h.getAttribute("href");
			System.out.println(hrf);
		}
		
		*****************************************************************************
		*/
		
		public static List<WebElement> getWebElements(By locator)
		{
			return driver.findElements(locator);
		}
		
		//this will give Text of allWebelements fetched based on locator in ArrayList
		public static ArrayList<String> getTextListLink(By locator)
		{
			List<WebElement> locatorlist=getWebElements(locator);
			  ArrayList<String> TextList=new ArrayList<String>();
			
			for(WebElement e:locatorlist)
			{
				String txt=e.getText();
				if(!txt.isBlank())//(!e.getText().isEmpty())
				{
					//Dont print like above,just fetch and add in Array
					TextList.add(txt);//TextList.add(e.getText());
				}
			}
			return TextList;
		}
			
}
			
		/* Indexing(Ordi.FOR LOOP) throws Exception if 1st webelement doesnt have href as attribute under tag<a> is null.
		 *Advisable to use EnhancedFOR LOOP when searching for Attributes,it might have. 
		/***************************************************************
		 *Ordinary For loop for getting attributes<href> under Tagname<a> 
		 *
		for(int i=0;i<linklist.size();i++)
		{
			WebElement e=linklist.get(i);// for(Webelement e:linklist)
			try
			{
			String href=e.getAttribute("href");
			if(!href.contains("null"))
			{
				System.out.println(href);
			}
			}
			catch(NullPointerException n)
			{
				System.out.println("Null PointerException");
			}	
		}
	 **************************************************************************
		 //Substitute for above ordinary-for loop code
		   for(WebElement e:linklist)// u can't print indexing in this like Ord.For Loop.
		  {
			  //System.out.println(e.getText());
			  String txt=e.getText();
			  if(!txt.isEmpty())
			  {
				  System.out.println(txt);
			  }
		  }
*/
		  
