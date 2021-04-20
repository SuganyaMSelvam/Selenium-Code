package SeleniumSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductMetaData2 {
	static WebDriver driver; 
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.get("https://demo.opencart.com/index.php?route=account/login");
	    
//LoginPage	    
	    By usrname=By.id("input-email");
		By pwd=By.id("input-password");
		By login=By.xpath("//input[@value='Login']");
		waitforElementVisibility(usrname, 10).sendKeys("suganyamselvam@gmail.com");		
		getWebElement(pwd).sendKeys("Test123;");
		getElementandClick(login);
		
			
//Search Page
		By search=By.xpath("//input[@name='search']");
		By srchbutton=By.xpath("//div[@class='col-sm-5']//button[@type='button']");
		//doSearch(search,"MacBook");
		doSearch(search,"iMac");
		getElementandClick(srchbutton);
			
//Product_Display
		By disply=By.xpath("(//div[@class='row'])[5]/div//h4/a");
		//getSearchTxtDisplay(disply,"Macbook Air");
		getSearchTxtDisplay(disply,"iMac");
		Thread.sleep(1000);
									
//Product Details-Get
		By product=By.xpath("//div[@id='content']//h1");//Always give product name
		By brand_details=By.xpath("//div[@class='col-sm-4']/ul/li");//always give product details in pair to add
		getProductDetails(product, brand_details);
			
		
	}//main mtd
	
	public static void doSearch(By locator,String searchtxt)
	{	
		waitforElementVisibility(locator, 5).sendKeys(searchtxt);//value Pass from user
	}
	
	public static void getSearchTxtDisplay(By locator,String user_search)
	{
		List<WebElement> searchList=getListWebElements(locator);
		for(int i=0;i<searchList.size();i++)
		{
			String txt=searchList.get(i).getText();
			System.out.println(txt);
			if(txt.equalsIgnoreCase(user_search))
			{
				searchList.get(i).click();
				break;
			}
		}
	}	
	public static void getSearchLinks(By locator)
	{
		List<WebElement> searchLink=getListWebElements(locator);
		for(WebElement e:searchLink)
		{
			System.out.println(e.getAttribute("href"));
		}
	}
	
	
	public static WebElement waitforElementVisibility(By locator,long timeOut)
	{
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static WebElement getWebElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public static void getElementandClick(By locator)
	{
		driver.findElement(locator).click();
	}
	
	public static String getWebElementText(By locator)
	{
		return getWebElement(locator).getText();	
	}	
	
	public static List<WebElement> getListWebElements(By locator)
	{
	List<WebElement> list=driver.findElements(locator);
	return list;
	}
	
	public static void getProductDetails(By product,By detailsLoc)
	{
//HardCode:Key
		Map<String,String> prd_data=new HashMap<String,String>();
		prd_data.put("Product_Name", getWebElementText(product));
		
		List<WebElement> list=getListWebElements(detailsLoc);
		System.out.println("--From the WebPage--");
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
			String txt=list.get(i).getText();
			if(!txt.isBlank() && txt.contains(":"))
				{
				String[] st_arry=txt.split(":");
				prd_data.put(st_arry[0].trim(),st_arry[1].trim());
			   }
				else
				{
				prd_data.put("Price", txt);	
				}		
		}
			
		System.out.println("--Fetching value from HashMap---");
		for(String i:prd_data.keySet())
		{
			System.out.println("Key:"+i+", Value:"+prd_data.get(i));
		}

	}
	
	
}//class ends
