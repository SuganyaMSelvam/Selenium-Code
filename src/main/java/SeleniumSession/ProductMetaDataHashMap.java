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

public class ProductMetaDataHashMap {
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
		//driver.findElement(usrname).sendKeys("suganyamselvam@gmail.com");//u can use trim if u want to remove empty spaces.
		getWebElement(pwd).sendKeys("Test123;");
		getElementandClick(login);
		
//Search Page		
		By search=By.xpath("//input[@name='search']");
		waitforElementVisibility(search, 5).sendKeys("iMac");
		By srchbutton=By.xpath("//div[@class='col-sm-5']//button[@type='button']");
		getElementandClick(srchbutton);
		//Thread.sleep(500);Used WebDriverWait to avoid this
		
//click on Product
		By prd=By.xpath("//img[@title='iMac']");
		getElementandClick(prd);
		
//Product Details-Get
		By prdtext=By.xpath("//div[@id='content']//h1");
		By brand=By.xpath("//div[@class='col-sm-4']/ul/li");
		getProductDetails(prdtext, brand);
			
		
	}//main mtd
	
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
	
	public static void getProductDetails(By prodLoc,By brandLoc)
	{
//HardCode:Key
		Map<String,String> prd_data=new HashMap<String,String>();
		prd_data.put("Product_Name", getWebElementText(prodLoc));
		
		List<WebElement> list=getListWebElements(brandLoc);
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
			String txt=list.get(i).getText();
			if(!txt.isBlank() && txt.contains(":"))
				{
				String[] st_arry=txt.split(":");
				prd_data.put(st_arry[0],st_arry[1]);
			   }
				else
				{
				prd_data.put("Price", txt);	
				}		
		}
			
		for(String i:prd_data.keySet())
		{
			System.out.println("Key :"+i+"Value :"+prd_data.get(i));
		}

	}
	
	
}//class ends

