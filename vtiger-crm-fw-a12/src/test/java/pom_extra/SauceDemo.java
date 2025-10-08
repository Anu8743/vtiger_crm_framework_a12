package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SauceDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "./resources/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://saucedemo.com/v1/");
		
		LoginPage lp = new LoginPage(driver);
//		login 
//		Declaration with initialization
		WebElement un = lp.getUn();
		WebElement pwd = lp.getPwd();
		WebElement login = lp.getLogin();
		
		driver.navigate().refresh();
		
//		utilization
		un.sendKeys("standard_user");
		pwd.sendKeys("secret_sauce");
		login.click();
		
//		verify
		Homepage hp = new Homepage(driver);
		
//	    declaration and initialization
		WebElement logo  = hp.getLogo();
		
//		utilization 
		if(logo.isDisplayed()) {
			System.out.println("Logged in successfully!!!!!!");
		}else {
			System.out.println("Could not log in .....");
		}
		
		Thread.sleep(5000);
		driver.quit();
		
		
	}

}
