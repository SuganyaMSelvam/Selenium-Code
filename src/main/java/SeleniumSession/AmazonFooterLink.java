package SeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


//Get the 4 footers from amazon page display it,no clicking
public class AmazonFooterLink {
 static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		
		/*1.Get the xpath
		2.findelements-list<Ele>=ele_list
		3.list traverse-for loop,gettext(-page visible text)-store array list
		*/
		 By country=By.xpath("//div[@id='navFooter']/div[4]//a");
		 By more_amz=By.xpath("//*[@id='navFooter']/div[5]/table//a");
		 By cpyrgt=By.xpath("//*[@id='navFooter']/div[6]//a");
		 By footer=By.xpath("//div[@id='navFooter']/div[1]//a");
		 
		ArrayList<String> countryText=getTextWebElements(country);//(footer2)
		ArrayList<String> moreText=getTextWebElements(more_amz);//Abebooks(footer3)
		ArrayList<String> cpyrgtText=getTextWebElements(cpyrgt);//footer 4
		ArrayList<String> footerText=getTextWebElements(footer);//(footer1 about us)
		
//These 2 lines are needed only for printing size,else getTextWebEle() is enough.
//        List<WebElement> countryList=getWebelements(country);
//        System.out.println(countryList.size());
		
        List<WebElement> more_amzList=getWebelements(more_amz);
        System.out.println(more_amzList.size());
        
		for(String s: moreText)//text is StringArray-dynamic
		{
			System.out.println(s);//string u can print directly its not array
		}
				
	}//main ends here
	
	public static List<WebElement> getWebelements(By locator)
	{
	   List<WebElement> loc_List=driver.findElements(locator);
	   return loc_List;
	}
	
	public static ArrayList<String> getTextWebElements(By locator)
	{
       List<WebElement> loc_list=getWebelements(locator);
       ArrayList<String> txt=new ArrayList<String>();
       
       for(WebElement e:loc_list)
       {
    	   //String t=e.getText();
    	   //txt.add(t);
    	   txt.add(e.getText());//txt=e.getText();I cant assign lik as txt is dynamicArray
       }
       return txt;
}
}