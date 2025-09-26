package Product;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateProductTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		Open Browser 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		Login
		driver.get("http://localhost:8888/");

		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("manager");

		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);

//		Create Organization
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

//		Filling data to the form
		WebElement lastnameField = driver.findElement(By.name("lastname"));
		String ContLastname = "Singh";
		lastnameField.sendKeys("ContLastname");

		Thread.sleep(3000);
  
//		save button
		driver.findElement(By.xpath("//input[contains(@value,'  Save  ')]")).click();

//		Verification
		String contect = driver.findElement(By.id("hdtxt_IsAdmin")).getText();
		
		if (contect.equals(ContLastname)) {
			System.out.println("Created Organization "+ ContLastname +"successfully!!!!");
		}else {
			System.out.println("Failed....");
		}
//		sign out
		WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

		Actions act = new Actions(driver);
		act.moveToElement(profilePic).build().perform();

		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();

		Thread.sleep(3000);
		driver.quit();

	}

}
