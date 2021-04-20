package SeleniumSession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Debug {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.freshworks.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

//		List<WebElement> list = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[2]//a"));
//
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getText());
//			list.get(i).click();
//			list = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[2]//a"));
		
		List<WebElement> list = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[2]//a"));

		for (WebElement e : list) {
			System.out.println(e.getText());
			e.click();
			Thread.sleep(1000);;
			list = driver.findElements(By.xpath("(//ul[@class='footer-nav'])[2]//a"));
		}

	}

}
