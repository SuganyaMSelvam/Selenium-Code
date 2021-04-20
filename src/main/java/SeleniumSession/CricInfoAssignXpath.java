package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricInfoAssignXpath {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/the-marsh-cup-2020-21-1244113/western-australia-vs-victoria-11th-match-1244131/full-scorecard");
		Thread.sleep(1000);
		driver.manage().window().maximize();

		
//Decoding Xpath-Dynamic WebTable-Dynamic Xpath creation
//Generic Xpath create -Figure out which changes(player) which constant(Rightside of tatplayer and anchoring)
/*
 Playername is constant-
 1)//a[contains(text(),'Cameron Bancroft')]
 Goto its Parent-anchor from there
 2)//a[contains(text(),'Cameron Bancroft')]/parent::td/
 Following-Right-Sibling details fetch
 3)//a[contains(text(),'Cameron Bancroft')]/parent::td//following-sibling::td
 Above gives 7 details so fetch in a list and print
 Creating Generic Xpath -provide playername its details will be fetched
 Xpath-Dynamic change value-Playername only tat u pass remaining values of Xpath constant.
 */

		
			Score_Wicket("Cameron Bancroft");		
	}//main mtd ends here

	public static void Score_Wicket(String playername)
	{
		String xpath="//a[contains(text(),'"+playername+"')]/parent::td/following-sibling::td";
		List<WebElement> playerdetail=driver.findElements(By.xpath(xpath));
//		for(int i=0;i<playerdetail.size();i++)
//		{
//			String txt = playerdetail.get(i).getText();
//			if(!txt.isBlank())
//			{
//				System.out.print(txt+" ");
//			}
//		}
		for(WebElement e:playerdetail)
		{
			String txt=e.getText();
			if(!txt.isBlank())
			{
			System.out.print(txt+" ");
			}
		}
	}

}
