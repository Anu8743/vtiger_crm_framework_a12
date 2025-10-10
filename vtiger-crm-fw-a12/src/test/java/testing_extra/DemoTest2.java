package testing_extra;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoTest2 {
	@Test(priority = -1)
	public void create() {
		System.out.println("case1: baby ");//console
	}
	
	@Test
	public void modify() {
		Reporter.log("case2 :boy");//report
	}
	
	@Test(priority = 1)
	public void delete() {
		System.out.println("case3 : boy will deleted ,true");// report + console
	}

}
