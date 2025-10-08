package Contact;

import java.io.FileInputStream;
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

public class CreteContactTest {
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
		
//		How to create execlflie
		
		FileInputStream fisExcel = new FileInputStream("./src/test/resources/testScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fisExcel);

		Sheet sh = wb.getSheet("LastName");

		Row row = sh.getRow(13);

		Cell cell = row.getCell(0);

		String LastName = cell.getStringCellValue()+ (int)(Math.random()*1000);

		System.out.println(LastName);		

//		Open Browser 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		Login
		driver.get(URL);

		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys(USERNAME);
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);

//		Create Organization
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

//		Filling data to the form
		WebElement lastnameField = driver.findElement(By.name("lastname"));
//		String ContLastname = "Singh";
		lastnameField.sendKeys(LastName);
		Thread.sleep(3000);
  
//		save button
		driver.findElement(By.xpath("//input[contains(@value,'  Save  ')]")).click();

//		Verification
		String contects = driver.findElement(By.id("dtlview_Last Name")).getText();
		
		if (contects.equals(LastName)) {
			System.out.println("Created Contact "+ LastName +"successfully!!!!");
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
