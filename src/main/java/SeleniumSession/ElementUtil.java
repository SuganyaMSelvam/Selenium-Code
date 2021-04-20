package SeleniumSession;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	/**
	 *
	 * This class is exclusively for all WebElements. CreatingWebElements and
	 * performing on them-2 actions -2 methods-Generic Approach. Any appln which
	 * requires to findWebElements and performing action on them.
	 * 
	 * By locators has to be maintained separately.->Another class/main method not
	 * in this. like variables in Java independently. This mthod works on that
	 * Locator. Requires driver->Constructor call
	 */
	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getWebElement(By locators) {
		return driver.findElement(locators);
	}

	public List<WebElement> getWebElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locators, String values)// Method chaining cos this method cant work without WebElement
	{
		getWebElement(locators).sendKeys(values);
	}

	public void doClick(By locators) {
		getWebElement(locators).click();
	}

	// getText() fetches only visible text on Webpage.Selenium fetches the inner
	// text of an element, which is not hidden by CSS
	public String doGetText(By locators) {
		return getWebElement(locators).getText();
	}

	// isDisplayed() method returns boolean value either True or False
	public boolean doisDisplayed(By locators) {
		return getWebElement(locators).isDisplayed();
	}

	// this mtd gives DynamicArray of TextList based on links provided.
	public ArrayList<String> getTextListLink(By locator) {
		List<WebElement> locatorlist = getWebElements(locator);
		ArrayList<String> TextList = new ArrayList<String>();

		for (WebElement e : locatorlist) {
			String txt = e.getText();
			if (!txt.isBlank()) {
				TextList.add(txt);
			}
		}
		return TextList;
	}

	public ArrayList<String> getAttriTextLinkList(By locator, String attribute) {
		List<WebElement> ele_List = getWebElements(locator);
		ArrayList<String> attriList = new ArrayList<String>();
		for (WebElement e : ele_List) {
			String s = e.getAttribute(attribute);
			attriList.add(s);// attriList.add(e.getAttribute(attribute));
		}
		return attriList;
	}

	public void doActionsMoveToElement(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(getWebElement(locator)).perform();
	}

	public void doActionsMoveToElementAndClick(By locator) {
		doActionsMoveToElement(locator);
		getWebElement(locator).click();
	}

	// *****************************DropDownUtils************************//

	/*
	 * public Select dogetSelectObject(By locators) { Select select=new
	 * Select(getWebElement(locators)); return select; }
	 */

	public void doSelectByIndex(By locator, int index) {
		Select sel_index = new Select(getWebElement(locator));
		// Select sel_index=dogetSelectObject(locator);By creating mtd for this we didnt
		// achieve any optimization so forget abt creating Select object method
		sel_index.selectByIndex(index);
	}

	public void doSelectByVisibleText(By locator, String text) {
		WebElement e = getWebElement(locator);
		Select sel_vtxt = new Select(e);
		sel_vtxt.selectByVisibleText(text);
	}

	public void doSelectByValue(By locator, String value) {
		WebElement e = getWebElement(locator);
		Select sel_val = new Select(e);
		sel_val.selectByValue(value);
	}

	public void dropDownwithoutSelect(By locator, String value) {
		List<WebElement> locList = getWebElements(locator);
		for (WebElement e : locList) {
			String txt = e.getText();
			if (txt.equalsIgnoreCase(value)) {
				e.click();
				break;
			}
		}
	}

	public void doMultiDropDownHandlewithoutSelect(By locator, String... value) {
		List<WebElement> locList = getWebElements(locator);
		for (WebElement e : locList)// Dynamic(Outer)-AllOptions array
		{
			String txt = e.getText();
			for (int j = 0; j < value.length; j++)// Static(Inner)-UserOption array
			{
				if (txt.equals(value[j])) {
					e.click();
					break;
				}
			}
		}

	}

	public void switchWindowGetUrlTitle(String id) {
		driver.switchTo().window(id);
		System.out.println("Title :" + driver.getTitle());
		System.out.println("URL :" + driver.getCurrentUrl());
		System.out.println("------------");
		driver.close();
	}

	// *********************************WAITS***************************************

	public WebElement waitforElementPresent(By locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitforElementVisibility(By locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

//Below mtd requires WebElement as Arg,for maintaining General util(easy maintenance) 
	// we pass locator and get its converted to WE by getWebElement metd in same
	// Util class.
	// public void waitforWebElementVisibility(WebElement e,long timeOut)

	public void waitforWebElementVisibility(By locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(getWebElement(locator)));
	}

//ListofWebElements-WebdriverWait
	public List<WebElement> waitForVisibilityListofElements(By locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public List<String> waitGetTextListofVisibleElements(By locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		List<WebElement> locList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		List<String> strList = new ArrayList<String>();// for use in loop
		for (WebElement e : locList) {
			if (!e.getText().isEmpty()) {
				strList.add(e.getText());
			}
		}
		return strList;
	}

// Recommended for Links and Images<Tag name>
// An expectation for checking that there is at least one element present on a
// web page.	
	public List<WebElement> waitpresenceofOneElementinList(By locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

// Wait for the element to be Visible and enabled so that u can click+createWE
	public WebElement waitforElementTobeClickable(By locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
//combined with above method for Click Event
	public void clickLocator(By locator, long timeOut) {
		waitforElementTobeClickable(locator, 5).click();
		;
	}

//Alert
	public Alert isAlertPresent(long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(long timeOut) {
		isAlertPresent(timeOut).accept();
	}

	public void declineAlert(long timeOut) {
		isAlertPresent(timeOut).dismiss();
	}

	public void getAlertText(long timeOut) {
		System.out.println(isAlertPresent(timeOut).getText());
	}

//Title	
	public boolean verifyExactTitle(long timeOut, String exptitle) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.titleIs(exptitle));
	}

	public boolean verifyTitleContains(long timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.titleContains(title));
	}

	public boolean verifyTitleContains(long timeOut, String title, long sleepTimeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut, sleepTimeOut);
		return wait.until(ExpectedConditions.titleContains(title));
	}

// URL
	public boolean verifyExactURL(long timeOut, String url) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlToBe(url));
	}

	public boolean verifyURLContains(long timeOut, String url_fraction) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlContains(url_fraction));
	}

//Frames-4(By Stringname,By Index,By locator,By WebElement)
	public void waitForFrameAndSwitchToIt(String idOrName, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName));
	}

	public void waitForFrameAndSwitchToIt(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public void waitForFrameAndSwitchToIt(int index, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}

	public void waitForFrameAndSwitchToIt(WebElement frameElement, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	
//Fluent Wait
	
	public WebElement fluentWaitForVisibilityofElement(By locator, long timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
				
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public Alert fluentWaitforAlert(By locator,long timeOut,long pollingtime) {
    Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
    		.withTimeout(Duration.ofSeconds(timeOut))
    		.pollingEvery(Duration.ofSeconds(pollingtime))
    		.ignoring(NoAlertPresentException.class);

    		return wait.until(ExpectedConditions.alertIsPresent());	
	}
	
	public WebDriver fluentWaitforFrame(By locator,long timeOut,long pollingtime) {
	    Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
	    		.withTimeout(Duration.ofSeconds(timeOut))
	    		.pollingEvery(Duration.ofSeconds(pollingtime))
	    		.ignoring(NoSuchFrameException.class);

	    		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));	
		}


	
	
	
}
