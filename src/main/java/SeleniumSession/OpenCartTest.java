package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartTest {

	/**
	 * Application dependent values like URL,By locators,values.hard-coded values 
	 * has to be userside-Main method.
	 * Single Responsibility Principle-Every class is responsible for singlething/specific feature.
	 * Generic methods only in Utilities-Not application dependent. Only logic dependent.
	 * This class needs BrowserUtilities,ElementUtilities and locators.
	 * 1.Browser Initialization->BrowserUtilities 
	 * 2.Enter the URL->method call pass URL
	 * 3.WebElements find+Perform.[ElementUtilities job but this requires driver,
	 * 4.Creating object of ElementUtil-> calls constructor which in turn initializes the driver.
	 * 5.Using obj call methods to create and perform but it requires locators. 
	 * Locators are initialized in the main method.
	 * @param args
	 */
	public static void main(String[] args) {
		
		BrwserUtilities br=new BrwserUtilities();
		WebDriver driver=br.init_browser("chrome");
		//br.launchUrl("https://demo.opencart.com/index.php?route=account/login");
		br.launchUrl("https://demo.opencart.com/index.php?route=account/register");
		
		ElementUtil ele_util=new ElementUtil(driver);
		//By locators are assigned its like variable assigned no interaction with Selenium/Server/Broswer until called by methods.
		//By email = By.id("input-email");
		By header=By.tagName("h1");//h1 has 2-headers default 1st webelement h1<your store> captured.
		By h1=By.linkText("Your Store");//By LinkText
		By email=By.xpath("//input[@type='email']");//xpath-custom created
		By pwd = By.id("input-password");//id
		//By fname=By.id("input-firstname");
		By fname=By.name("firstname");//name
		//By lname=By.id("input-lastname");
		By lname=By.name("lastname");//name
		//By telph=By.id("input-telephone");
		By telph=By.xpath("//*[@id=\"input-telephone\"]");//xpath-copy from page source
		//By pwd_conf=By.id("input-confirm");
		By pwd_conf=By.cssSelector("#input-confirm");
		By news_yes=By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]");
		By news_no=By.cssSelector("#content > form > fieldset:nth-child(3) > div > div > label:nth-child(2)");
		//By terms=By.linkText("agree");
		By terms=By.cssSelector("#content > form > div > div");
		By priv_pol=By.className("agree");
		By agree=By.name("agree");
		//By cntnue=By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");//copied xpath from website
		By cntnue=By.xpath("//input[@type='submit']");//have created my own-custom xpath
		By cont2=By.xpath("//input[@value='Continue']");//custom xpath same as ln51.
		
		System.out.println(ele_util.doGetText(header));//Your store-can click this(line 52) too.
		//ele_util.doClick(h1);
		//ele_util.doClick(header);-does same as 52 but its not specific header,1st default header. If design changes this also changes whereas line52 is narrowed down.
		//Clicks "Your store" link and takes to different pagehttps://demo.opencart.com/index.php?route=common/home
			
		ele_util.doSendKeys(fname, "Suganya");
		ele_util.doSendKeys(lname, "Aravindh");
		ele_util.doSendKeys(email, "suganyamselvam@gmail.com");
		ele_util.doSendKeys(telph, "9788111115");
		ele_util.doSendKeys(pwd, "Suganya789");
		ele_util.doSendKeys(pwd_conf, "Suganya789");
		//ele_util.doClick(news_yes);
		ele_util.doClick(news_no);
		
		//System.out.println(ele_util.dogetText(terms));//I have read and agree to the
		//System.out.println(ele_util.dogetText(priv_pol));//Privacy Policy-used Class name By locator
		//System.out.println(ele_util.doisDisplayed(priv_pol));//true
		//System.out.println(ele_util.dogetText(agree));
		//ele_util.doClick(agree);
		
		ele_util.doClick(cont2);//
		
		//System.out.println(br.getPageTitle());//RegisterAccount
		//br.closeBrowser();

	}

}
