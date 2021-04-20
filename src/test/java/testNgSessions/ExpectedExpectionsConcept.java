package testNgSessions;

import org.testng.annotations.Test;

public class ExpectedExpectionsConcept {
	String name;

	@Test(expectedExceptions = NullPointerException.class) // fail
	public void loginTest1() {
		System.out.println("login1 Test");
		int i = 9 / 0;// Arithmetic Exception but line8-NullPointer so Failure
	}

	@Test(expectedExceptions = ArithmeticException.class) // fail
	public void loginTest3() {
		System.out.println("No error-but still failure as its eXpecting ArithmException");
	}

	// Pass
	@Test(priority = 1, expectedExceptions = { NullPointerException.class, ArithmeticException.class })
	public void loginTest2() {
		System.out.println("login test");
		int i = 9 / 0;// Arithmetic if anyone exception occurs it comes out as it doesnt chk next line 24-ignore
		ExpectedExpectionsConcept obj = new ExpectedExpectionsConcept();
		obj = null;
		//obj.name = "loginTest";// NullPointer
		System.out.println(obj.name);

	}

}
