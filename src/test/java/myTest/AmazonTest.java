package myTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest {
	
//	WebDriver driver;

//	@BeforeTest
//	public void setUp() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().deleteAllCookies();
//		driver.get("https://www.amazon.in/");
//	}

	@Test(priority = 1)
	public void amazonPageTitleTest()
	{
		driver.get("https://www.amazon.in/");
		Assert.assertTrue(driver.getTitle().contains("Online Shopping"));
	}

	@Test(priority = 3)
	public void amazonLogoTest() {
		Assert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed());
	}

	@Test(priority = 2)
	public void searchBarExistTest() {
		Assert.assertTrue(driver.findElement(By.id("twotabsearchtextbox")).isDisplayed());
	}

//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}

}
