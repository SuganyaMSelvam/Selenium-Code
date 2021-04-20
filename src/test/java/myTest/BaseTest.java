package myTest;

/*
 * Its like maintaining all the pre-conditions and post-Conditions so avoiding redundancy in maincode
 */
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		//loginDemo();
	}
	
//	public void loginDemo()
//	{
//		driver.findElement(By.id("input-email")).sendKeys("suganyamselvam@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("Test123;");
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
//	}


	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

}
