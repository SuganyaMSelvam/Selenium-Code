package SeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


/*
 * Xpath-getting address of an element inside the HTML DOM
 * Relative-//-custom built
 * Abs path-from parent to child /html/body/div/div[1]/ul/li/span
 */
public class AllaboutXpath {
	  
	
//xpath-1[Relative Xpath basic]
	//htmltag[@attribute='value'];
	//input[@id='user-name'];
	
//xpath-2 [AND,OR,NOT]
	//htmltag[@attri1='value' and @attri2='value']-u can have n number or attributes.
	//htmltag[@attri1='value' and @attri2 and @attri3]-u can have n no.of attributes with/Without values
	//htmltag[@attr='value1][@attri2='value2']
	//input[@id and @type and @name]
	//input[@id='Form_input' and @type=text]
	
	//htmltag[@attr1='value1'] or [@attri2='value2']
	//htmltag[@attr1='value1'] | [@attri2='value2']
	
	//[not(@attri1='Value')]
	 //input[not(@type='text')]
	
//-------------------------------------------------------------------
	
//xpath-3 text()-used for elements where text is available--no parameters
	//htmltag[text()='value']
//header,span,link-mostly
	//input[text()='Refresh_button_click']
	//h2[text()='Tgcvjh']
	//a[text()='customers']
	
	
	
//xpath-4 contains() function-DYNAMIC elements with dynamic text and attributes
	              // takes 2 parameters,one is attribute name and other its value
	//htmltag[contains(@attri,'value')]
	//input[contains(@type,'test_1')]
//contains with Text	
	//input[contains(text(),'refresg']
//Multi-contains with text and attribute
	//htmltag[contains(@attri1,'value') and contains(text(),'value')];
	//html[contains(@attri1,'value') and contains(@attri2,'value')];
	

//xpath-5 starts-with() function-DYNAMIC element same as contains,takes 2 parameters
	//htmltag[starts-with(@attri,'value')]
	//input[starts-with(text(),'value')] -can be combined with contains,text,attribute
	
//________________________________________________________________________________________	
	
//xpath-6-Group by Index "()"and []| Position()-function
	//Positioning-Index-Retrieves group of elements-
	 //xpath Array then using indexing to retrieve that element-Index start from 1
	//(html[@attri='value'])[1]
	//(input[@type='text'])[2] or //(input[@type='text'])[position()=2]
	
	
//---------------------------------------------------------------------	
//xpath-Xpath Axes-7
//Parent,child,following-sibling,preceding-sibling,ancestor
	
//	(7a)
//Parent to Child(Forward)	//-Forward Traversing(/)
	//ul[@class='footer_nav']/li->Direct child
	//ul[@class='footer_nav']//li-Indirect Child
	//ul[@class='footer_nav']/li/a(recommend) or //ul[@class='footer_nav']//a(but not recommended)
	//ul[@class='list-unstyled']/li
	//ul[@class='list-unstyled']/child::li[same as above]
	//div[@class='private-form__input-wrapper']/child::input[@id='username']
	
	
//    (7b)	
//Child to Parent(Backward) //xpath-Backward Traversing(/..)
	//html[@attri='value']/../../..
	//input[@id='username']/parent::div
	//ul[@class='list-unstyled']/parent::div[@class='col-lg-4 col-sm-6 col-offset-2 margin social']
	//ul[@class='list-unstyled']/..

	
//		(7c)	
	//input[@id='username']/ancestor::div

	
//   	(7d)
//Siblings-Preceding-Left traversing in a table
	//a[text()='Freshstatus']/parent::li/preceding-sibling::li -Gives 7 it gives all the preceding siblings
	
//Siblings-Following-Right traversing in a table	
	//img[@alt='Freshworks']/parent::a/following-sibling::span
	//a[text()='Freshstatus']/parent::li/following-sibling::li-Gives 2 all the following sibling
	

//xpath-Independent dependent path (8)	
// In Dynamic Webpages,position changes constantly so look for something solid(like name,unique identifier) based on that position
// the checkbox,traverse left and right to get details	
	
	
//Normalize-space-String function(9) 
	// ignores the leading, trailing, and repeating white spaces
	//It strips leading and trailing white-space from a string, replaces sequences of whitespace characters by a single space, and returns the resulting string.	
		// (//label[@class='radio-inline'])[position()=1]/input
		// (//label[@class='radio-inline'])[position()=2]/input
		
	//label[normalize-space(text())='No']
		//label[normalize-space()='No']
		//label[normalize-space()='Yes']

//To get all vs Specified(10)
		//*[@id="username"]-300
		//input[@id="username"]-10
	
	
	

	
}
