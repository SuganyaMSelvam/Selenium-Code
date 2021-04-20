package SeleniumSession;

public class CustomCSS {
	
			//css: cascaded style sheet
			
/*1)Use of ID and CLASS in CSS
        	id-> #{idname} or htmltag#id
			class-> .{classname} or htmltag.classname	
Example:<input type="text" id="input-firstname" class="form-control">
Above HTMLtag is input ,Attributes type,id,class, Values are "text","input-firstname" "form-control"
			#input-firstname
			.form-control
	
	
2)Multiple classes can be combined with dot. in CSS 
			.c1.c2.c3....cn
			.form-control.private-form__control.login-email
			.login-email
U can combine CLASSNAME with ID too 
			 .login-email#username
			 #username.login-email
			 .form-control.private-form__control.login-email#username
			 #username.form-control.private-form__control.login-email
			 input#username.form-control.private-form__control.login-email
	Examples:		 
	By loc1 = By.className("form-control private-form__control login-email");
	By loc2 = By.xpath("//input[@class='form-control private-form__control login-email']");
	By loc3 = By.cssSelector(".form-control.private-form__control.login-email");
	By loc4 = By.className("login-email");
	
	
	
3)Difference between XPATH and CSS,NO----> //htmltag,@id,'value'
			 htmltag[attr='value']
		     input[id='input-firstname']
			XPATH - //input[@id='input-firstname']
			CSS   -   input[name=username]

			
4)Multiple conditions,attributes can be combined with [] whereas XPATH use AND or [].
			 htmltag[attr1='value'][attr2='value']
			 CSS  -   input[name='firstname'][type='text']
			XPATH -  //input[@name='firstname' and @type='text']
			               OR
			         //input[@name='firstname'][@type='text']      
			
			
5)CONTAINS In CSS
		input[name*='user'] --CSS
		//input[contains(@name,'user')]-Xpath
		input[name*='user'][type='text']
DOM -- <input type="text" name="firstname" value="" placeholder="First Name" id="input-firstname" class="form-control">
         XPATH  -  //input[contains(@name,'name')]-Gives 2 firstname,lastname
         CSS    -    input[name*=name]


6)STARTS WITH in CSS
           input[name^='user'] 
          XPATH  -  //input[starts-with(@name,'firs')]-Gives only firstname
          CSS    -    input[name*=firs]

7)ENDS WITH in CSS ONLY
       		input[name$='name'] 
       		CSS   -  input[name$=name] -Gives 2 as of contains in this eg)


8)Parent to Child:
     As in Xpath(/ and /child::htmltag) in CSS also it can be represented 2 ways(Space and >)
		 div.container div  --57(Direct+indirect)
		 div.container > div  --7(Direct children)
Child to Parent
		 "BACKWARD TRAVERSING is IMPOSSIble in CSS."
		 
9)NOT in CSS(Exclusive of something use not()
		 DOM  :  form-control private-form__control login-email
		         form-control private-form__control login-password 
		CSS:input.form-control.private-form__control:not(.login-email)
		 input.form-control.private-form__control:not(#password)
		
1.It does not support text i.e. we can identify element using text of the element. 
2.It does not support backward traversing. 
3.It doesn’t support index 
	
10)COMMA in CSS:
We can collect different elements and use for SANITY TESTING via List<WebElement>
whether they are present and then IS DISPLAYED.(visible)
		input#username, input#password, button#loginBtn, input#remember	
Example)	
List<WebElement> formList = driver.
		  findElements
		   (By.cssSelector("input#username, input#password, button#loginBtn, input#remember"));
		if(formList.size() == 4) {
			System.out.println("all imp elements are present on the page....");
			
			for(WebElement e : formList) {
				System.out.println(e.isDisplayed());
			}
		}
		
11)	nth-of-type:(Indexing)
 		Syntax  	:nth-of-type()
		ul.footer-nav li:nth-of-type(5) > a -- for 5th index
		ul.list-unstyled li:nth-of-type(n) a -- for all elements
		
		
12)	following sibling: (+)
		//div.private-form__input-wrapper + div	
	
	For more differences visit this
	https://www.testim.io/blog/xpath-vs-css-selector-difference-choose/
	
		
			
*/
}
