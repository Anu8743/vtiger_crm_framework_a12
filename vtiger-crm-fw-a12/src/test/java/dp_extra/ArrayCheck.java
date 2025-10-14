package dp_extra;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayCheck {
	@Test(dataProvider = "getData")
	public void login(String username, String password) {
//		String username = "anu";
//		String password = "anu@123";

		System.out.println(username);
		System.out.println(password);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] cred = new Object[5][2];
//		                            row => no. of executions
//									col => no. of parameters
		cred[0][0] = "ani";
		cred[0][1] = "ani@1234";

		cred[1][0] = "taanni";
		cred[1][1] = "tani@123";

		cred[0][0] = "any";
		cred[0][1] = "any@123";

		cred[0][0] = "nisha";
		cred[0][1] = "nisha@12";

		cred[0][0] = "neha";
		cred[0][1] = "neha@1289";

		cred[0][0] = "sneha";
		cred[0][1] = "sneha@64";

		return cred;

	}

}
