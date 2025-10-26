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
import org.testng.annotations.Test;

import generic_Utilities.FileUtility;
import gu_extra.WebDriverUtility;
import object_repository.LoginPage;

public class CreteContactTestBeforeBaseClass {
	@Test
	
	public void createContTest()throws InterruptedException, EncryptedDocumentException, IOException {
//		public static void main(String[] args) throws InterruptedException, IOException {
//		get the java represention object of the physical file 
		FileUtility fUtil = new FileUtility();

//		Get the data from properties file
		String BROWSER = fUtil.getDataFromPropertiesFile("bro");
		String URL = fUtil.getDataFromPropertiesFile("url");
		
//		Get the data from excelflie

		FileInputStream fisExcel = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fisExcel);
		Sheet sh = wb.getSheet("LastName");
		Row row = sh.getRow(13);
		Cell cell = row.getCell(0);
		String LastName = cell.getStringCellValue() + (int) (Math.random() * 1000);
		wb.close();

//		Open Browser 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		Login
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.login();
		
//		WebElement username = driver.findElement(By.name("user_name"));
//		username.sendKeys(USERNAME);
//		WebElement password = driver.findElement(By.name("user_password"));
//		password.sendKeys(PASSWORD);

//		driver.findElement(By.id("submitButton")).click();

//		Create Organization
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

//		Filling data to the form
		WebElement lastnameField = driver.findElement(By.name("lastname"));
		lastnameField.sendKeys(LastName);

//		save button
		driver.findElement(By.xpath("//input[contains(@value,'  Save  ')]")).click();

//		Verification
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

		if (actLastName.equals(LastName)) {
			System.out.println("Created Contact " + LastName + "successfully!!!!");
		} else {
			System.out.println("Failed....");
		}

//		Logout
		WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		WebDriverUtility wdUtil = new WebDriverUtility(driver);
//		Actions act = new Actions(driver);
//		act.moveToElement(profilePic).build().perform();
		wdUtil.hover(profilePic);
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();

		Thread.sleep(3000);
		driver.quit();

	}
}
