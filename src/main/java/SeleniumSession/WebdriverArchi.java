package SeleniumSession;

public class WebdriverArchi {

	
	/*1.RemoteWebdriver has all the Business Logic implemented none of the other
		classes have it. Eg)chromedriver/Firefoxdriver etc doesnt have logic.
		2.Quit vs close-SessionId is maintained throughout the establishment till close/quit is called.
		3.Selenium+Java act as client,.exe file of chrome/firefox act as server,from server request sent to browser launched.
		4.Webdriver driver=new ChromeDriver();//Topcasting.
		5.System.setproperty->key/Value pair-Key constant webdriver.chrome.driver
		Value->exe file path ->Provided by vendor-Google/Mozilla not Selenium's responsibility.
		6.After Selenium 3->WebdriverManager takes care of this downloading the exe file on own. No manaul downloading needed for .exe file.
		7.Quit-Session Id is null
		8.Close-Session id is invalid.
		*/


	

}
