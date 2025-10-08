package gu_extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScript {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.openUrl();
		WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

		wdUtil.winMax();
		wdUtil.hover(profilePic);
		
	}

}
