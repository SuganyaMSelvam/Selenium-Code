package SeleniumSession;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class JSExceutor {

		public static void main(String[] args) {

			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.amazon.in/");
	
//Title			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			String title = js.executeScript("return document.title;").toString();
//			System.out.println(title);
			
			JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
			System.out.println(jsUtil.getTitleByJS());

//Refresh			
			//jsUtil.refreshBrowserByJS();
//Alert			
			//jsUtil.generateAlert("this is my JS");

//InnerpageText-Gives all the visibletext in a page 			
			//System.out.println(jsUtil.getPageInnerText());

//Border			
//			WebElement login = driver.findElement(By.xpath("//input[@value='Login']"));
//			WebElement login_form = driver.findElement(By.id("loginForm"));
//			jsUtil.drawBorder(login_form);
		
//Flash-Highlight-particular WebElement			
//			jsUtil.flash(login_form);
//			jsUtil.flash(login);
			
//Click the WE using JSExec			
			//jsUtil.clickElementByJS(login);
			
//Scrolling-Important feature which is impossible using ActionClass or Selenium			
//			jsUtil.scrollPageDown();
//			jsUtil.scrollPageUp();
			
//Scrolling to Particular WE			
			WebElement ele = driver.findElement(By.xpath("//span[text()='Best Sellers in Home & Kitchen']"));
			jsUtil.scrollIntoView(ele);
//ScrollDown			
			jsUtil.scrollPageDown("100");
						
		}

	}

