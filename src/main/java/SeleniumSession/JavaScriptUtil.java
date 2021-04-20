package SeleniumSession;

/*
/ * Where ‘JavascriptExecutor’ is an interface, 
 * which helps executing JavaScript through Selenium WebDriver.
 * Whenever WE is involved,arguments is involved both in script and as arg
 * Scrolling can be done with or w/o window. for scrollTo,scrollBy.
 * 
 * More of JS based(console u can see results)
 * Scroll-[ScrollTo->Down,up ,ScrollBy->Right/Left,ScrollintoView-ParticularWE
 * Document-Webpage(webpage details)->document.gives lot of functionality
 * 
 * Arguments-WE(webelement)-More of Seleniumcode(can't exec on console)
 * 
 * window-particular segment-console see
 * 
 */
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	public class JavaScriptUtil {
		WebDriver driver;
		JavascriptExecutor js;
		
//Initializing driver and JS executor 
		public JavaScriptUtil(WebDriver driver) {
			this.driver = driver;
			this.js = ((JavascriptExecutor) driver);
		}
//Flash-highlight an WE
		public void flash(WebElement element) {
			String bgcolor = element.getCssValue("backgroundColor");
			for (int i = 0; i < 15; i++) {
				changeColor("rgb(0,200,0)", element);// 1
				changeColor(bgcolor, element);// 2
			}
		}
//ChangeColor of WE
		private void changeColor(String color, WebElement element) {
			js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
		}
//Title
		public String getTitleByJS() {
			return js.executeScript("return document.title;").toString();
		}
//Refresh
		public void refreshBrowserByJS() {
			js.executeScript("history.go(0)");
		}
//Alert
		public void generateAlert(String message) {
			js.executeScript("alert('" + message + "')");
		}
		
//WebScraping-all text in a webpage
		public String getPageInnerText() {
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("return document.documentElement.innerText;").toString();
		}

//click
		public void clickElementByJS(WebElement element) {
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
		
//Finding WE(id)+passing (values)-Document used
		public void sendKeysUsingWithId(String id, String value) {
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
		}
   	
//ScrollDown-window/scroll by calculating page height using document(ScrollTo)
		public void scrollPageDown() {
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}

//ScrollDown-passing height-value(ScrollTo)		
		public void scrollPageDown(String height) {
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, '" + height + "')");
		}
		
//VerticalScrollUp-PageUp(ScrollTo)
		public void scrollPageUp() {
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		}
		
//Horizontal Scroll in the right direction(ScrollBy)		
		public void scrollHorizantalRightView() {
				js.executeScript("window.scrollBy(2000,0)");
				}
		
//Horizontal Scroll in the left direction(ScrollBy) 		
		public void scrollHorizontalLeft()
		{
			js.executeScript("window.scrollBy(-2000,0)");
		}
		
//Scroll to Particular Element(ScrollintoView)
		public void scrollIntoView(WebElement element) {
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		}

//Border
		public void drawBorder(WebElement element) {
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid red'", element);
		}

}
