package SeleniumSession;

import java.util.List;

//Get the lanaguage footer displayed and click on particular lang,exit.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLangLink {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in");

		List<WebElement> langList=driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		System.out.println(langList.size());
		for(WebElement e:langList)
		{
			String txt=e.getText();//Visible txt on page-gives all lang on tat xpath.
			System.out.println(txt);
		if(txt.equals("ಕನ್ನಡ"))
		{
			e.click();//click on it and exit.Whole page converted to malayalam lang.
			break;
		}
		}
	}
}

