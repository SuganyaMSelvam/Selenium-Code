package SeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class CricInfoBowlAssign {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/the-marsh-cup-2020-21-1244113/western-australia-vs-victoria-11th-match-1244131/full-scorecard");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
	List<String> detl=bowlerDetails("James Pattinson");
	System.out.println(detl);
		
	}//main mtd ends here
	
public static List<String> bowlerDetails(String name)
{
	String xpath="//a[text()='"+name+"']/parent::td/following-sibling::td";
	List<WebElement> details=driver.findElements(By.xpath(xpath));
	List<String> score=new ArrayList<String>();
	for(int i=0;i<details.size();i++)
	{
		String txt=details.get(i).getText();
		if(!txt.isBlank())
		{
			score.add(txt);
		}
	}
	return score;
}
	

}
