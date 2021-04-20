package testNgSessions;
/* priority is optional,without priority-Alphabetical order execute
 * With priority starts from -2,-1,<withoutprior is priority equal to 0>(alphabetical), then +1,+2 
 * with -ve priority without priority
 * with +ve without priority-1st without priority(alphabetical vice )then with+ve priority
 * if both have same priority alphabetical vice
 */
import org.testng.annotations.Test;

public class PriorityConcept {

		@Test()
		public void a_test() {

		}

		@Test(priority=0)
		public void b_test() {

		}

		@Test(priority=0)
		public void c_test() {

		}

		@Test()
		public void d_test() {

		}

		@Test(priority = -2)
		public void e_test() {

		}

		@Test()
		public void f_test() {

		}

	}



