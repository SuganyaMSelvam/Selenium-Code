package myTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoCartMyAccountTest extends BaseTest {
	

	@Test(priority=1)
	public void getUrlAccountDemoCart()
	{
		DemoCartLoginPage lp=new DemoCartLoginPage();
		lp.loginDetailsverify();
		Assert.assertTrue(driver.getCurrentUrl().contains("account/account"));
	}

//	@Test(priority=2)
//	public void getUrlAccountDemoCart()
//	{
//		Assert.assertTrue(driver.getCurrentUrl().contains("account/account"));
//    }
	
	@Test(priority=2)
	public void accountHeaderverify()
	{
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='My Account']")).isDisplayed());
	}
 
	@Test(priority=3)
	public void searchButtonEnabled()
	{
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='search']")).isEnabled());
	}
	
}
