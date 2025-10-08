package Calendar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateCalTest {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
//		get the java represention object of the physical file 
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		
//		use the load() of properties class to load all the keys value 
		Properties pObj = new Properties();
		pObj.load(fis);
	
//		use the getproperty(key) and pass the key and you will get string value 
		String BROWSER=pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
		
//		PRINT
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
//		open browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);

//		login page
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys(USERNAME);
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();

//		click on calendar
		driver.findElement(By.linkText("Calendar")).click();

//		click on month
		driver.findElement(By.linkText("Month")).click();

//		hover
		WebElement add = driver.findElement(By.className("calAddButton"));
		Actions act = new Actions(driver);
		act.moveToElement(add).build().perform();
		Thread.sleep(15);

//		click on call
		driver.findElement(By.id("addcall")).click();

//		click on event type
		driver.findElement(By.id("activitytype")).click();

//		enter the event name
		WebElement orgField= driver.findElement(By.xpath("//input[contains(@name,'subject')]"));
		String org = "hackathon";
		orgField.sendKeys(org);
		

//		click on ckeckbox 
		driver.findElement(By.cssSelector("input[value='Public']")).click();

//		click on describe and write it
		driver.findElement(By.cssSelector("textarea[name='description']")).sendKeys(
				"Hackathons are not just about coding; they are also about collaboration, learning new technologies, and applying problem-solving skills in real-world scenarios.");

//		click on location
		driver.findElement(By.cssSelector("input[name='location']")).sendKeys("gandhinager");

//		dropdown  on eventstatus
		WebElement status = driver.findElement(By.id("eventstatus"));
		Select ab = new Select(status);
		ab.selectByIndex(1);

//		click on 	Assigned To
		WebElement assi = driver.findElement(By.name("assigned_user_id"));
		Select sd = new Select(assi);
		ab.selectByIndex(1);

//		dropdown on pripoity
		WebElement pro = driver.findElement(By.id("taskpriority"));
		Select task = new Select(pro);
		task.selectByIndex(2);

//	   checkbox 
		driver.findElement(By.name("sendnotification")).click();

//		save
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
//		verify
		String event=  driver.findElement(By.id("event_0_0")).getText();
		if(event.equals(org)) {
			System.out.println("Created Organization successfully!!!!");
		}else {
			System.out.println("failed...............");
		}

		
		WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

		Actions acts = new Actions(driver);
		acts.moveToElement(profilePic).build().perform();

		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();

		Thread.sleep(3000);
		driver.quit();

//		

	}

}
