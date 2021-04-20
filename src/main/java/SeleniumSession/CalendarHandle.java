package SeleniumSession;
/*
 * Learning While Loop-Future Date(condition how matches with next icon,fetching data passing to While-condition-evryday]
 */
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/*Calendar is a WebTable-Rows and Columns
 * We're trying to create General utils(Xpath) so any calender can be handled via this.
 * 2 appln-goibibo and mukesh calendar
 * FutureDate,PastDate,Presentdate-Logic
 * 
 */

public class CalendarHandle {
static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		By select_cal=By.id("datepicker");//Selecting the blank date entry where calendar is available.
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(select_cal)).click();
		
//Current month- specific day pick
//		By sp_day=By.xpath("//a[text()='9']");
//		driver.findElement(sp_day).click();
//		selectDayofCurrentMM("30");
//		selectDayofCurrentMM("23","a");
		
//Current month-day pick-Generic way-MethodOverloading
		By all_days=By.cssSelector("table.ui-datepicker-calendar a");
//		selectDayofCurrentMM(all_days,"28");
		
//Future-Date & Past-Date(Change-Icon-)
		/*Get date from user-split and store DD/MM/YY-it if its ///format else ask them to provide in such format
		 * Capture the current month/YY from calendar split it(use sep function)
		 * compare curMMwithUserMM and CuYYwithUserYY if its not same 
		 * inspect icon,click it again capture CurMMYY from cal(Step 2 call)
		 * if its equal call selectDay function.
		 * Negative cases -Feb(Leap year),other months 32-Msg-return
		 * Integer.parseInt use-comparison operation perform -String-cant
		 */

//Later handle1.input(int month)-convert to string?2.input mm/dd/yyyy format 3.Day-mm format 02
				
//User-Input-Date
		//selectFutureDate_Calendar("3","June","2022");
		selectPastDate_Calendar("26","december","2020");
		
		
	}//main mtd ends
	
	//****************************************************************
//Current mm/yy calendar-get-process-String Array-returns month and year in Array.	
	public static String[] getCalendarMMYY(String cal_mmyy)
	{
		return cal_mmyy.split(" ");
	}
		
//Past-Date
	public static void selectPastDate_Calendar(String day,String month,String year)
	{
		String cal_month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String cal_year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		while(!(month.equalsIgnoreCase(cal_month) && year.equals(cal_year)))
		{
			System.out.println(cal_month+" "+cal_year);
			WebDriverWait wait=new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Prev']"))).click();
			cal_month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			cal_year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		}			
	selectDayofCurrentMM(day);		
	}
	
// Util for the-CurrentMM Day-Blog appln
		public static void selectDayofCurrentMM(String day)
		{
			By dayP=By.xpath("//a[text()='"+day+"']");
			driver.findElement(dayP).click();			
		}
	
// Util for the-CurrentMM-day-(gobibo&Blog 2 appln)
	public static void selectDayofCurrentMM(String day,String htmltag)
	{
		driver.findElement(By.xpath("//"+htmltag+"[text()='"+day+"']")).click();			
	}
		
//Current month-day pick-Generic way//Method Overloading
		public static void selectDayofCurrentMM(By locator,String day)
		{
		List<WebElement> day_List=driver.findElements(locator);
		for(WebElement e:day_List)
		{
			if(e.getText().equals(day))
			{
			e.click();
			}
		}
		}
		
//Future-Date		
public static void selectFutureDate_Calendar(String day,String expmonth,String expYear) 
		{
	//Logic for Feb Month-we want to use >symbol Integer convert
			if(expmonth.equals("February")&& Integer.parseInt(day)>29)
			{
				System.out.println("Wrong date,pls chk");
				return;
			}
	//get calendarMMYY-split-function use-while loop-compare against userMMYY evreytime, till then click next icon		
		String cal_mmyy=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();	
		while (!(getCalendarMMYY(cal_mmyy)[0].equals(expmonth) && getCalendarMMYY(cal_mmyy)[1].equals(expYear)))
		{
			System.out.println(cal_mmyy);
			WebDriverWait wait=new WebDriverWait(driver, 10, 2);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Next']"))).click();
		    cal_mmyy=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		}
			selectDayofCurrentMM(day);
		} 

//Getting Calendar MM&&YY and returning both-U can get separately and return viceversa
//			String cal_mmyy=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
//			String[] st_ary=getCalendarMMYY(cal_mmyy);
//			System.out.println(st_ary[0]+ " "+st_ary[1]);
			


//public static void getUserDate(String day,String expmonth,String expYear)
//		{
//	//Path for calendar mm/yy	
//		String cal_mmyy=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
//	//getCalendar-function-return-array[0]-month [1]-Year	
//		while (!(getCalendarMMYY(cal_mmyy)[0].equals(expmonth) && getCalendarMMYY(cal_mmyy)[1].equals(expYear)))
//		{
//	//next icon click-traverse	
//			WebDriverWait wait=new WebDriverWait(driver,10);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Next']"))).click();
//			//driver.findElement(By.xpath("//div//a[@title='Next']")).click();
//	//again need to get calendar month and compare		
//			cal_mmyy=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
//		}
//	//end of this loop gets us usrMonth_Year in calendar page.
//		//Select day-call day function
//			selectDayofCurrentMM(day);
//		}
	
		

	

}
