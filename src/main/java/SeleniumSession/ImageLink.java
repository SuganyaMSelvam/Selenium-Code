package SeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//Find Image count<By.Tagname<img> and its attribute<alt,src>.(getAttribute)
//Webscraping

public class ImageLink {
 static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");	
		
		//image tag is <img><tagname use> and its attribute value<alt="">
		//<src is attribute name<getAttribute use> fro each tag<img>in amazonlink
		//Webscraping-getting data from webpage(any ecommerce- and do R&D,datascience,etc)
		//image tag is <img><tagname use> and its value tag<src>
		//<src is attribute name<getAttribute use> fro each tag<img>in amazonlink)
		
		//List<WebElement> imglist=driver.findElements(By.tagName("img"));
		By image=By.tagName("img");
		List<WebElement> imglist=getWebElements(image);
		System.out.println();
		System.out.println("total img :"+imglist.size());
		
		ArrayList<String> srcTxt=getAttriTextLinkList(image,"src");
		ArrayList<String> altTxt=getAttriTextLinkList(image, "alt");
		
		//System.out.println(srcTxt.size());
		System.out.println(altTxt.size());
		
		for(String s:altTxt)
		{
			System.out.println(s);
		}
	}//main mthd ends here
		
	//Writing the util for below for loop 	
		/*for(WebElement e:imglist )//Webscraping
		{
		//e.getText(); will not give anything as there is no Visible text and for img tats not we do.
		String src=e.getAttribute("src");//gives link,returns String
		String alt=e.getAttribute("alt");//gives name
		System.out.println(alt+"\n"+src+"\n");
		}*/		
	
		public static List<WebElement> getWebElements(By locator)
		{
			return driver.findElements(locator);
		}
	
		public static ArrayList<String> getAttriTextLinkList(By locator,String attribute)
		{
			List<WebElement> ele_List=getWebElements(locator);
			ArrayList<String> attriList=new ArrayList<String>();
			for(WebElement e:ele_List)
			{
				String s=e.getAttribute(attribute);
				attriList.add(s);//attriList.add(e.getAttribute(attribute));
			}
			return attriList;
		}
		
}