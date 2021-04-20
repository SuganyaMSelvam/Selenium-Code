package testNgSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//TestNg doesnt have main mtd,it has annotations to execute

public class AmazonTestBefMethod {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
	}

	@Test
	public void getTitle() {
		String actual = driver.getTitle();
		Assert.assertEquals(actual,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}

	@Test
	public void getUrl() {
		String actual = driver.getCurrentUrl();
		String exp = "https://www.amazon.in/";
		Assert.assertEquals(actual, exp);
	}

	@Test
	public void logoVerify() {
		boolean flag = driver.findElement(By.id("nav-logo-sprites")).isDisplayed();
		Assert.assertTrue(flag);
	}

	@Test
	public void searchDisplay() {
		Assert.assertTrue(driver.findElement(By.id("twotabsearchtextbox")).isEnabled());
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}