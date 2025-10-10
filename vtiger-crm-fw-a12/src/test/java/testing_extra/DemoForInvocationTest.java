package testing_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoForInvocationTest {
	@Test(invocationCount = 5)
	public void case1() {
		System.out.println("Hey!!!!!!!!!!");
	}
	
	@Test(invocationCount = 0)
	public void case2() {
		System.out.println("holaaaaa!!!!!!!!!!!");
	}
	
	@Test(enabled = true)
	public void case3() {
		System.out.println("haaaloooooo!!!!!!1");
	}
	
	@Test(invocationCount = 10, threadPoolSize = 3)
	public void case4() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(3000);
		driver.quit();
	}
	
}
