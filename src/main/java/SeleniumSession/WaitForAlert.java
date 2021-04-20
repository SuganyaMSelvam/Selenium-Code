package SeleniumSession;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlert {
	
static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		Thread.sleep(1000);
		driver.findElement(By.name("proceed")).click();
		
/*Alert-handling via WebDriverWait
 *       -Waits+create Alert Element
		-No need to switch driver to Alert Interface
		-Method returns Alert 
*/
//		WebDriverWait wait=new WebDriverWait(driver, 8);
//		Alert al=wait.until(ExpectedConditions.alertIsPresent());
//		System.out.println(al.getText());
//		al.accept();
		
		//isAlertPresent(7);
		getAlertText(6);
		acceptAlert(0);
		
	}//main methd ends here
//****************UTIL************************************
		public static Alert isAlertPresent(long timeOut)
		{
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			return wait.until(ExpectedConditions.alertIsPresent());
		}
		
		public static void acceptAlert(long timeOut)
		{
			isAlertPresent(timeOut).accept();
		}
		public static void declineAlert(long timeOut)
		{
			isAlertPresent(timeOut).dismiss();
		}
		public static void getAlertText(long timeOut)
		{
			System.out.println(isAlertPresent(timeOut).getText());
		}



}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

