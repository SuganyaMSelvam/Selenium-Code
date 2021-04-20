package SeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Its a static webTable,Position constant.
 * Approach for any static table:Rowcount,Columncount find.
 * based on that generate Xpath(WE access) and gettext(value).
 * Row-OuterLoop,Column-InnerLoop 
 * th-gives Column count,tr gives Row count.
 * td talks about each individual cell[One Row details]-Column
 */

public class StaticWebTableXpath {
static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
//As I was unable to create X-path with inspecting each cell,used below mtd		
//Following are the Xpath generated when copied directly from each Row-1st cell		
		//*[@id="customers"]/tbody/tr[2]/td[1]-1st column 1st cell
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[7]/td[1]-1st column 7th cell
//From the above, we got a key to generate X-path,but again dynamically 
		               //as tr[] td[] differs for each Row-cell
		//*[@id="customers"]/tbody/tr[2]/td[2]-2nd column 1st cell
		//*[@id="customers"]/tbody/tr[7]/td[2]-2nd column 7th cell
		
		//TR-gives Row
		//TD-Gives Column
		
	generateXpath();
		
	}//main mthd ends here
	
	public static void generateXpath()
	{
		int col_count=driver.findElements(By.xpath("//table[@id='customers']//tr/th")).size();
		int row_count=driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		
		String bfXpath="//*[@id=\"customers\"]/tbody/tr[";
		String afXpath="]/td[";
	
// 1st row(outer)2st column(inner)	2,1 2,2 2,3			
		
		for(int i=2;i<=row_count;i++) 
		{
			for(int j=1;j<=col_count;j++) 
			{
				String cell_pos=bfXpath+i+afXpath+j+"]";
				//System.out.println(xpath);
				String txt=driver.findElement(By.xpath(cell_pos)).getText();
				System.out.print(txt+" "+"|");
			}
			System.out.println();
		}
		
	}   

}
