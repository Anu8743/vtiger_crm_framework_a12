package config_anno_extra;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	@BeforeClass
	public void openBro() {
		System.out.println("open Browser");
	}
	
	@BeforeMethod
	public void Login() {
		System.out.println("login");
	}
	@AfterMethod
	public void Logout() {
		System.out.println("logout");
	}
	@AfterClass
	public void CloseBro() {
		System.out.println("close browser");
	}
}
