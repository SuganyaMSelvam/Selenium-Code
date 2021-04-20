package testNgSessions;

//Main use for Load Testing/Performance Testing-100 users create/perform
import org.testng.annotations.Test;

public class InvocationCountConcept {
	

	@Test(invocationCount = 10)//Execution 10 times
	public void createUserTest() {
		System.out.println("create user");
	}
	
	@Test(invocationCount = 100)//Execution 100 times
	public void getUserTest() {
		System.out.println("get user");
	}
	

}
