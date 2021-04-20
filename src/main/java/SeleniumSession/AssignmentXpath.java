package SeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentXpath {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		List<WebElement> list=driver.findElements(By.xpath("//ul[@class='list-unstyled']/li"));
		for(WebElement e:list)
		{
			System.out.println(e.getText());
		}

	}

}
