package myTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoCartSearchTest extends BaseTest {
	@Test(priority=1)
	public void searchIn()
	{
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("iMac");
		driver.findElement(By.cssSelector(".input-group-btn button")).click();
	}

	@Test(priority=2)
	public void chkSearchCrit()
	{
		Assert.assertTrue(driver.findElement(By.id("input-search")).isDisplayed());
	}
	
	@Test(priority=3)
	public void visibilityChk()
	{
		Assert.assertTrue(driver.findElement(By.xpath("//h4/a")).getText().equalsIgnoreCase("imac"));
	}
}
