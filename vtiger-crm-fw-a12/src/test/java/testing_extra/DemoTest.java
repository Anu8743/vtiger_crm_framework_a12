package testing_extra;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoTest {
	@Test
	public void case1() {
		System.out.println("case1: hello ");//console
	}
	
	@Test
	public void case2() {
		Reporter.log("case2 : plz go anywheree....!!!");//report
	}
	
	@Test
	public void case3() {
		System.out.println("case3 : plz ,true");// report + console
	}

}
