package myTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoCartLoginPage extends BaseTest {
	
	@Test(priority=1)
	public void getTitleDemoCart()
	{
		Assert.assertEquals(driver.getTitle(),"Account Login");
	}
	
	@Test(priority=2)
	public void getUrlDemoCart()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("account/login"));
	}
	
	@Test(priority=1)
	public void verifyHeader()
	{
		Assert.assertTrue(driver.findElement(By.xpath("//h1/a[text()='Your Store']")).isDisplayed());
	}
	

	@Test(priority=4)
	public void loginDetailsverify()
	{
		driver.findElement(By.id("input-email")).sendKeys("suganyamselvam@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Test123;");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
