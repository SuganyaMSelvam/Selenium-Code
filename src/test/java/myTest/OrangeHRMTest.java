package myTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest {
//	WebDriver driver;

//	@BeforeTest
//	public void setUp() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().deleteAllCookies();
//		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
//	}

	@Test(priority = 1)
	public void orangeHRMTitleTest() {
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		Assert.assertTrue(driver.getTitle().contains("Free Human Resource"));
	}

	@Test(priority = 3)
	public void orangeHRMUrlTest() {
		Assert.assertTrue(driver.getCurrentUrl().contains("orangehrm-30-day-trial"));
	}

	@Test(priority = 2)
	public void TrailButtonExistTest() {
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='FREE 30 Day Trial']")).isDisplayed());
	}

//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}

}


