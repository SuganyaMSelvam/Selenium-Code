package SeleniumSession;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class JSExecNoonAppln {

    public static void main(String[] ar) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Launch the application		
        driver.get("https://www.noon.com/uae-en/");
        Thread.sleep(2000);

        //Find element and store in variable "Element"  
        //WebElement element = driver.findElement(By.xpath("//h3[contains(text(),'Dresses')]/parent::div"));
        //WebElement e=driver.findElement(By.xpath("//img[@class='sc-crrsfI iDhzRL']"));
       WebElement e=driver.findElement(By.xpath("//h3[normalize-space()='Dresses - new arrivals']"));
        //WebElement e=driver.findElement(By.xpath("(//div[@class='sc-GTWni GkeGT'])[3]"));
      
       
       
        //By css=By.cssSelector("div[class='sc-1oj0twj-0 eTIkrq'] h3[class='sc-dlfnbm eFXxew']");
        //WebElement cs=driver.findElement(css);
        //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView(true);",e);
    }
}