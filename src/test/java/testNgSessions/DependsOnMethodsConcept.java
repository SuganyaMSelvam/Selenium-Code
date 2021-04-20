package testNgSessions;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept {
	
	//dependency bw multiple test cases, is it a good idea? No
			//testcases should be independent
			//test case should be written for a specific feature
			//test case should have only one or max two assertions
			//multi-assertions -- you can have soft assertions for the single features
			//login feature: username, pwd, login button is displayed or not--- 3 soft assertions
			
			
			@Test
			public void loginTest() {
				System.out.println("login test");
				//int i = 9/0;//uncommenting this make everything failed
			}
			
			@Test(dependsOnMethods = "loginTest")//will be skipped if login is failed as it depends on 
			public void homeTest() {
				System.out.println("home test");
			}
			
			@Test(dependsOnMethods = "homeTest")//same as above
			public void profileTest() {
				//logo
				//name
				//account info
				//email
				//reset pwd
			}
			
			@Test(dependsOnMethods = "loginTest")
			public void searchTest() {
				System.out.println("Search test");
			}
			
			

}
