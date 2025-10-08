package gu_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {
	WebDriver driver;
	
	public WebDriverUtility(WebDriver driver) {
		this.driver=driver;
	}
	
	public void openUrl() {
		driver.get("http://49.249.28.218:8888/");
	}
	
	public void winMax() {
		driver.manage().window().maximize();
	}
	
	public void hover(WebElement targetElement) {
		Actions act = new Actions(driver);
		act.moveToElement(targetElement).build().perform();	
	}
}
