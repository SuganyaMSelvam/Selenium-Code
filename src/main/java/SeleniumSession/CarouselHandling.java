package SeleniumSession;


/*Star-Xpath
 * Lesson Learnt:X-Path figuring out so generic (h3,products,nexticon)
 * While Loop-next icon condition-Very Unique-gud learning
 * TreeSet-sorts Out while storing itself instead of ArrayList
 * Generic Xpath-change heading-u will get products under them
 * Clicking icon(next) to traverse through products-like carousel
 */
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarouselHandling {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		driver.get("https://www.noon.com/uae-en/");
		driver.manage().window().maximize();//without this nexticon not visible in Windows Laptop
		Thread.sleep(1000);

//*************************Individual inside main concept******************************		
//h3[text()='Top deals on skincare'] -Gives Heading
    //Capture products under them by traversing up -find sibling-traverse below-products
//div[@data-qa='product-name']-Gives all the carousel products
		//Star
//h3[text()='Recommended For You']/parent::div/../following-sibling::div//div[@data-qa='product-name']
//*******************************************

//Recommended-For You-Carousel products-Xpath		
		//By prod_recom=By.xpath("//h3[text()='Recommended For You']/parent::div/../following-sibling::div//div[@data-qa='product-name']");
	
//***************RoughCopy-Mistakes******************************		
	//Following code didn't work  because its clicking next icon so fast without control
		//solution:condition has to be applied before capturing WebElements
//		for(WebElement e:productList)
//		{
//			System.out.println(e.getText());
	//Gives only 5(win-min)7(win-max) among 42 cos of Visibility on WebPage
	//Solution:Need to press next icon till all icon is disabled/all 42 elements gather
//			driver.findElement(By.xpath("//h3[text()='Recommended For You']/parent::div/../following-sibling::div//div[contains(@class,'swiper-button-next')]")).click();
//			Thread.sleep(1000);//Above couldnt give all products infact only 1.		
//		}

		
//**********************Before writing Generic Working code***************		
////Solution:While Loop
//		List<WebElement> prod_RecmList=driver.findElements(prod_recom);	
//		By next_icon=By.xpath("//h3[text()='Recommended For You']/parent::div/../following-sibling::div//div[contains(@class,'swiper-button-next')]");
//		
//		Set<String> data=new TreeSet<String>();
//while (!(driver.findElement(next_icon).getAttribute("class").contains("swiper-button-disabled")))	
//		{
//		for(WebElement e: prod_RecmList)
//		{
//			if(!e.getText().isBlank())
//			{
//			 data.add(e.getText());
//			 //System.out.println(e.getText());//In order to sort out TreeSet used
//			}
//		}
//		driver.findElement(next_icon).click();//it cant come in for loop-inside for it doesnt exist
//		}
//        System.out.println(data.size());
   
//********************************************************
		
		//Set<String> dataSet=getProducts("Recommended For You");

 //Streams use Print     
        //dataSet.stream().forEach(e->System.out.println(e));
        
	}//main methd

//*****************************************UTIL***********************	
	
	//Generic UTIL for creating Xpath for whole Appln based on heading provided-Product Xpath provide
	public static List<WebElement> getXpathCarousel(String heading)
	{
		By product=By.xpath("//h3[text()='"+heading+"']/parent::div/../following-sibling::div//div[@data-qa='product-name']");
		return driver.findElements(product);		
	}
	
	public static WebElement getNextIcon(String heading)
	{
		return driver.findElement(By.xpath("//h3[text()='"+heading+"']/parent::div/../following-sibling::div//div[contains(@class,'swiper-button-next')]")); 
	}
	
	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static Set<String> getProducts(String heading)
	{
		WebElement v=driver.findElement(By.xpath("//h3[text()='"+heading+"']"));
		//scrollIntoView(v);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", v);
		List<WebElement> prod_RecmList=getXpathCarousel(heading);	
		Set<String> data=new TreeSet<String>();
		
     while (!(getNextIcon(heading).getAttribute("class").contains("swiper-button-disabled")))	
		{
		for(WebElement e: prod_RecmList)
		{
			if(!e.getText().isBlank())
			{
			 data.add(e.getText());
			}
		}
		getNextIcon(heading).click();
		}
        System.out.println(data.size());
        return data;     
	
	
	}
}//class ends

//Needs Scrolling of the pageDown
		//Set<String> dataSet=getProducts("Dresses - new arrivals");

////String heading="Dresses - new arrivals";
//		//h3[text()='Dresses - new arrivals']
//		//WebElement v=driver.findElement(By.xpath("//h3[text()='Dresses - new arrivals']"));
//		By d=By.xpath("//h3[text()='Dresses - new arrivals']");
//		WebDriverWait wait=new WebDriverWait(driver, 10);
//		WebElement v=wait.until(ExpectedConditions.visibilityOfElementLocated(d));
//		js.executeScript("arguments[0].scrollIntoView(true);", v);	
//		
