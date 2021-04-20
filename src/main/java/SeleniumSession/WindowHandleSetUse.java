package SeleniumSession;

import java.util.Iterator;

import java.util.Set;//Set is an Interface

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*Scenario: Window(parent)-click->opens another Window(child)
 * To consider:Driver can't switch automatically from parent to child.
 *Solution: WindowHandler API use,switchTo
 * getWindowHandles<Set> and loop<Iterator><next>[SIN-Set]
 *Switching between Parent and Child<switchTo>
 */

public class WindowHandleSetUse {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");//Parent
//String parentid=driver.getWindowHandle();ParentId gives
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();//child
//String childid=driver.getWindowHandle(); doesnt give childId cos driver still points to Parent we need SwitchTo to move from Parent to Child.
//System.out.println("ParentId :"+parentid+"\n"+"ChildId :"+childid);
//		ParentId :CDwindow-FF0306D4045372EDC534BD6B08FCAC60
//		ChildId :CDwindow-FF0306D4045372EDC534BD6B08FCAC60

		
//Getting Id's and stored in array<Set>,iterating to get the Id's		
		Set<String> windowIds=driver.getWindowHandles();//mtd(getWinHand) returns Set<String>
//Iterate
		Iterator<String> it=windowIds.iterator(); //Mtd iterator returns Iterator<String>
		System.out.println("1st pointer:"+it);
//Above line points to above windowIds.In this case above ParentId.		
	    String ParentId=it.next();//Points to Parenthandle in Set
	    System.out.println("ParentId is:"+ParentId);
	    String childId=it.next();//Points to ChildHandle in Set.
	    System.out.println("ChildId is :"+childId);
	    
//Testing Purpose	    
 String driverId=driver.getWindowHandle(); 
 //Driver doesnt move anywhere from original(Parent) we need to move<switch> so gives ParentId window.
 System.out.println("Testing Perspective:"+driverId);//Gives ParentId to prove driver doesnt move untill we switchTo.
 	
 		driver.switchTo().window(childId);//We r moving to ChildWindow.
 		System.out.println("Child Title :"+driver.getTitle());
 		System.out.println("Child URL :"+driver.getCurrentUrl());
 		driver.close();//closes the child window.
 		//driver.quit();//closes all,driver doesnt exist anymore.No windows.
 //org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()
 //Driver is now lost not pointing to anything cos we closed and we didnt switch to Parent.
 		//System.out.println(driver.getCurrentUrl()); //throws Exception
 //no such window: target window already closed from unknown error: web view not found		
 
 		driver.switchTo().window(ParentId);
 		System.out.println("Parent URL :"+driver.getCurrentUrl());
 		driver.close();
 		//driver.quit.u can use close or quit here noprob.
 
	}

}
