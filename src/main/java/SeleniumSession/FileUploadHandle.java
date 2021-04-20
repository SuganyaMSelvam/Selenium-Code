package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Selenium cant handle the FileUpload as its not a Webelement/presnt on Webpage
 * When we click on FileUpload,OS opens a window to upload.
 * HACK:dont click,find webelement,sendKeys(Provide the file to be uploaded)
 * Constraint:TYPE has to be file
 * @author Suganya
 *
 */
public class FileUploadHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		//input[@name='upfile']-xpath
		WebElement e=driver.findElement(By.name("upfile"));
		e.sendKeys("C:\\Users\\mssug\\OneDrive\\Documents\\Ec_dad.jpg");

	}

}
