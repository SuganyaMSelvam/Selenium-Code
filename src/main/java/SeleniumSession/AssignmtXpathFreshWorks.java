package SeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmtXpathFreshWorks {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.freshworks.com/");

//div//ul[@class='footer-nav']-gives 4 vertical position-need only the 1st-indexing
//By loc=By.xpath(//div//ul[@class='footer-nav'])[1];-gives 1st vertical column
		By footer=By.xpath("(//div//ul[@class='footer-nav'])");
		
		List<WebElement> footerList=driver.findElements(footer);
		List<String> strList=new ArrayList<String>();
		
		//System.out.println(footerList.size());4 Columns
		for(int i=1;i<footerList.size();i++)                          
		{
			List<WebElement> xpathColList=driver.findElements(By.xpath("(//div//ul[@class='footer-nav'])["+i+"]/li/a"));
			for(WebElement e:xpathColList)//Column-wise traverse details get
			{
				String txt=e.getText();
				strList.add(txt);
			}	
		}
	//System.out.println(strList.size());//Gives the entire 26 values under each column.
		for(int j=1;j<strList.size();j++)
		{
          System.out.println(strList.get(j));
		}	
	}

}
