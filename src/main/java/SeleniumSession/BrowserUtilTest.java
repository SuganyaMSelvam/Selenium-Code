package SeleniumSession;

public class BrowserUtilTest {

	public static void main(String[] args) {
		
		/*BrowserUtil br=new BrowserUtil(); 
		br.launchBrowser("chrome");//initialize browser
		//If user wants to provide the value directly u can pass as
		//br.launchURL("http://www.google.com");//always better to use this approach.
		br.launchURL();//enter the url
		//string st=br.gettitle();Returns the value here.
		//so when declaring mtd instead of void u need to use String
		br.gettitle();//Getting the title
		br.verification();//Verification part-Testing
		br.navigation();//Navigation commands
		br.getCurrentpage();//current page URL
		br.close();*/
		
		BrwserUtilities bu=new BrwserUtilities();
		bu.init_browser("chrome");//1.Initialize browser
		bu.launchUrl("http://www.google.com");//2.Launch URL
		String title=bu.getPageTitle();//get the title
		System.out.println(title);
		//verification part-actual testing
		if (title.contains("Google"))
		{
			System.out.println("correct title");
		}
		else
		{
			System.out.println("IncorrectTitle");
		}
		
		String c_Url=bu.getCurrentPageURL();
		System.out.println(c_Url);
		bu.closeBrowser();
		
		
	}

}
