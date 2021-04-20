package SeleniumSession;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RoleBasedLoginHashMap {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");//Loginpage direct launch
		
//Scenario:Login Details-HashMap store,fetch it based on Role called.
		//1.Store Method (return (values)credentials based on Key provided)
		//2.Call Method (fetch values-use those to Login using Selenium(inspect,locators,sendKeys)
		
		doLogin("admin1");
	//driver.navigate().refresh();//doesnt clear the already entered data on usrfields
		doLogin("naveen");
		
	}//main mthd
	
	
public static void doLogin(String role)	
{
	String s=getCredentials(role);
	if(!(s==null))
	{		
//Fetch_Separate username:pwd
	String[] str_Ary=s.split(":");//split return String Array
//dont need to iterate the array as it has only 2 values.
//	str_Ary[0]="username";
//	str_Ary[1]="Pwd";
//Inspect&Create WE and pass/perform the values/operation
	By usrname=By.id("input-email");
	By pwd=By.id("input-password");
	By login=By.xpath("//input[@value='Login']");
	driver.findElement(usrname).clear();
	driver.findElement(usrname).sendKeys(str_Ary[0]);//u can use trim if u want to remove empty spaces.
	driver.findElement(pwd).clear();
	driver.findElement(pwd).sendKeys(str_Ary[1]);
	driver.findElement(login).click();
	}
	else
	{
		System.out.println("Invalid User");
	}
}
	
	
public static String getCredentials(String key_Role)
{
	Map<String,String> cred=new HashMap<String,String>();
	cred.put("admin","admin@g.com:admin123");
	cred.put("user","user1@g.co:user123");
	cred.put("DBA","dba@g.com:db1789");
	cred.put("naveen","groupautomation:Test@12345");
	cred.put("customer2", "cust.r@ya.in:Cust980");
	
	if(cred.containsKey(key_Role))
	{
		System.out.println("Role :"+key_Role+"Values :"+cred.get(key_Role));
		return cred.get(key_Role);//Value get
	}
	return null;//Else path-doesnt match throws NullPointerException if invalid role provided
	
}


}//Class ends
