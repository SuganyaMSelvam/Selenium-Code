package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverbasics {

	public static void main(String[] args) {
		
System.setProperty("webdriver.chrome.driver","C:\\Users\\mssug\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//Topcasting-Parent c=new Child();//Child upcasted to Parent.
		WebDriver driver=new ChromeDriver();
		/*driver.get("http://www.google.com");
		String title=driver.getTitle();//Google
		System.out.println("Page title :"+title);
		if(title.equals("Google"))
		{
			System.out.println("Gotcha");
		}
		else
		{
			System.out.println("OOPS try correctly");
		}*/
		//driver.get("http://www.facebook.com");//Page title :Facebook – log in or sign up
		//driver.get("http://www.yahoo.com");//Yahoo India | News, Finance, Cricket, Lifestyle and Entertainment
		driver.get("http://www.ask.com");//Ask.com - What's Your Question?
		String title=driver.getTitle();
		System.out.println("Page title :"+title);
	if(title.contains("Ask.com"))
		{
			System.out.println("Gotcha");
		}
		else
		{
			System.out.println("OOPS try correctly");
		}
		
	}

}
