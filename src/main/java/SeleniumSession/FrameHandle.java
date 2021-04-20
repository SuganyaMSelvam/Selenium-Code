package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {

	/*Frames are part of Webelements,frames have their own DOM
	 * Solution:SwitchTo<Frame> from ParentWindow then findelement+perform on Frame
	 * Index,name,WebElement
	 * DefaultContent-takes back to window where frame is called.
	 * Eg)Parent->Frame1->Frame2 designed. From Parent switchTo<Frame2>,when defaultContent is used form Fram2 it goes to Frame1.(As Fram1 is parent of Frame2>
	 * Iframe and frame both can be dealt the same way but Security wise Frames are safer
	 * Inline frame is just one "box" and you can place it anywhere on your site. Frames are a bunch of 'boxes' put together to make one site with many pages.
	 */
	
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
//Frames-Switch
		//driver.switchTo().frame(2);//DOM-this is on 3rd framset,index:2
		//driver.switchTo().frame("main");
		driver.switchTo().frame(driver.findElement(By.name("main")));//U can find this on the frame of this frameset
		
		WebElement e=driver.findElement(By.xpath("//html/body/h2"));//Visible content on WebPage
		
		System.out.println(e.getText());
		
		driver.switchTo().defaultContent();
//		driver.switchTo().parentFrame();
		
	}

}
