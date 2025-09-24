package Calendar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalendarTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888/");
//		login
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("manager");
		
		driver.findElement(By.id("submitButton")).click();
		
//		click on Opportunities
		driver.findElement(By.linkText("Calendar")).click();
		
//		Click on All Events & Todos	
		driver.findElement(By.linkText("All Events & Todos")).click();
		
		Thread.sleep(3000);
		
//		Click Planned  on Search bar
		driver.findElement(By.xpath("//input[contains(@name,'search_text')]")).sendKeys("Planned");
		
//		Click on Search now button
		driver.findElement(By.xpath("//input[contains(@name,'submit')]")).click();
		
//		click on Administrator 
		
		WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(profilePic).build().perform();
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(3000);
		driver.quit();

	}

}
